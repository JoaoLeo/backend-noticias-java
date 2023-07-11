package io.github.joaoleo.backendnoticiasjava.resources.exceptions;

import io.github.joaoleo.backendnoticiasjava.services.ObjetoNaoEncontrado;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ObjetoNaoEncontradoHandler {
    @ExceptionHandler(ObjetoNaoEncontrado.class)
    public ResponseEntity<StandardError> resourceNotFound(ObjetoNaoEncontrado err, HttpServletRequest req){
        String errMsg = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError e = new StandardError(Instant.now(), status.value(), errMsg, err.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(e);
    }
}
