package curse.spring.boot.service;

import curse.spring.boot.model.Client;
import curse.spring.boot.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    private ClientsRepository repository;

    @Autowired
    public ClientsService(ClientsRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Client client) {
        validarCliente(client);
        this.repository.persistir(client);

    }

    public void validarCliente(Client cliente) {
        //aplica validaçoes
    }
}

