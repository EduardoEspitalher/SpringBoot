package curse.spring.boot.domain.repositorio;

import curse.spring.boot.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select c from Cliente c where c.nome like :nome")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);


    void deleteByNome(String nome);

    List<Cliente> findByNomeLike(String nome);

     boolean existsByNome(String nome);
}




