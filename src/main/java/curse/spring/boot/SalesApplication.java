package curse.spring.boot;

import curse.spring.boot.domain.entity.Cliente;
import curse.spring.boot.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes) {
        return args -> {
            Cliente c = new Cliente(null, "Eduardo");
            clientes.save(c);
        };
    }


    public static void main(String[] args) {

        SpringApplication.run(SalesApplication.class, args);
    }

}

