package curse.spring.boot.api.controller;


import curse.spring.boot.domain.entity.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @RequestMapping(
            value = {"/api/clientes/hello/{nome}",""},
            method = RequestMethod.POST,
            consumes = {"application/json","application/xml"},
            produces = {"application/json", "application/xml"}
    )
    @ResponseBody
    public String helloCliente(@PathVariable("nome")
                                   String nomeCliente, @RequestBody Cliente cliente){
        return String.format("Hello %s", nomeCliente);
    }

}
