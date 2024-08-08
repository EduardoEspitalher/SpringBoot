package curse.spring.boot.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException() {
        super("Pedido Não Encontrado.");
    }
}
