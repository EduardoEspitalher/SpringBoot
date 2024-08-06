package curse.spring.boot.service;

import curse.spring.boot.domain.entity.Pedido;
import curse.spring.boot.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}

