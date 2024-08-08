package curse.spring.boot.service;

import curse.spring.boot.domain.entity.Pedido;
import curse.spring.boot.domain.enums.StatusPedido;
import curse.spring.boot.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}

