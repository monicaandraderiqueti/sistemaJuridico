package com.processo.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Diz ao Spring que esta classe vigia todos os controllers
public class GlobalExceptionHandler {

    // Sempre que um Service disparar "RuntimeException", esse método roda automaticamente
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", ex.getMessage());

        // Devolve o erro bonitinho em formato JSON {"erro": "Processo não encontrado."}
        // E com o status HTTP 404 (Not Found) em vez daquele erro 500 feio
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}