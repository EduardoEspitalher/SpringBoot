package curse.spring.boot.service.impl;


import curse.spring.boot.domain.repository.Pedidos;
import curse.spring.boot.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
