package curse.spring.boot.rest.controller;

import curse.spring.boot.exception.PedidoNaoEncontradoException;
import curse.spring.boot.exception.RegraNegocioException;
import curse.spring.boot.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors HandleRegraNegocioException(RegraNegocioException ex) {
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors HandlePedidoNotFoundException( PedidoNaoEncontradoException ex) {
        return new ApiErrors(ex.getMessage());
    }

}
