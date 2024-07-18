package curse.spring.boot.repository;

import curse.spring.boot.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientsRepository {
    public void persistir(Client client) {
        // acessa o banco e salva o cliente
    }
}
