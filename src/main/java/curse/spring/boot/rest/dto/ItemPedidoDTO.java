package curse.spring.boot.rest.dto;

public class ItemPedidoDTO {

    private Integer profuto;
    private Integer quantidade;

    public Integer getProfuto() {
        return profuto;
    }

    public void setProfuto(Integer profuto) {
        this.profuto = profuto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
