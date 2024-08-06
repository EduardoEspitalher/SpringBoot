package curse.spring.boot.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
