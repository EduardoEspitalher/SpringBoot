package curse.spring.boot.service.impl;


import curse.spring.boot.domain.entity.Cliente;
import curse.spring.boot.domain.entity.ItemPedido;
import curse.spring.boot.domain.entity.Pedido;
import curse.spring.boot.domain.entity.Produto;
import curse.spring.boot.domain.repository.Clientes;
import curse.spring.boot.domain.repository.ItensPedido;
import curse.spring.boot.domain.repository.Pedidos;
import curse.spring.boot.domain.repository.Produtos;
import curse.spring.boot.exception.RegraNegocioException;
import curse.spring.boot.rest.dto.ItemPedidoDTO;
import curse.spring.boot.rest.dto.PedidoDTO;
import curse.spring.boot.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtoRepository;
    private final ItensPedido itensPedidoRepository;


    @Override
    @Transactional
    public Pedido salvar( PedidoDTO dto ) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemPedido = converterItens(pedido, dto.getItens());
        repository.save(pedido);
        itensPedidoRepository.saveAll(itemPedido);
        pedido.setItens(itemPedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return repository.findByIdFatchItens(id);
    }

    private List<ItemPedido>  converterItens(Pedido pedido, List<ItemPedidoDTO> itens){
        if(itens.isEmpty()){
            throw new RegraNegocioException(
                    "Não é possível realizar um pedido sem itens.");
        }
        return itens
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto =produtoRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () ->
                                    new RegraNegocioException(
                                            "Código de produto inválido: "+idProduto
                                    ));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;

                }).collect(Collectors.toList());
    }
}
