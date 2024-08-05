package curse.spring.boot.domain.entity;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private Integer id;

    @Column(name="descicao",length=100)
    private String descricao;

    @Column(name="preco_unitario", precision=10, scale=2)
    private BigDecimal preco;

    public Produto(BigDecimal preco, String descricao, Integer id) {
        this.preco = preco;
        this.descricao = descricao;
        this.id = id;
    }

    public Produto() {

    }


    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
