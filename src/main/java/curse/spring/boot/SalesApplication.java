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
            System.out.println("Salvando clientes");
            clientes.salvar(new Cliente("Eduardo"));
            clientes.salvar(new Cliente("Kallel"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);
       };
    }

    public static void main(String[] args) {

        SpringApplication.run(SalesApplication.class, args);
    }

}
