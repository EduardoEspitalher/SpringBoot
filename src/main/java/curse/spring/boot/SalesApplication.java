package curse.spring.boot;



import curse.spring.boot.domain.entity.Cliente;
import curse.spring.boot.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando clientes...");
            clientes.save(new Cliente("Eduard"));
            clientes.save(new Cliente("Kallel"));

            boolean existe = clientes.existsByNome("Eduardo");
            System.out.println("Existe um cliente com o nome Eduardo " + existe);

       };
    }

    public static void main(String[] args) {

        SpringApplication.run(SalesApplication.class, args);
    }

}

