package curse.spring.boot.domain.repository;

import curse.spring.boot.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Produtos extends JpaRepository<Produto, Integer> {

    @Query(value = "select p from Produto p where p.descricao like :descricao")
    List<Produto> encontrarPorDescricao(@Param("descricao") String descricao);

    @Query(value = "delete from Produto p where p.descricao = :descricao")
    @Modifying
    void deleteByDescricao(String descricao);

    boolean existsByDescricao(String descricao);




}
