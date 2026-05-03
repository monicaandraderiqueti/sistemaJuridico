package com.processo.api.controller;

import com.processo.api.model.Cliente; //traz a classe Cliente
import com.processo.api.repository.ClienteRepository; //traz o repositório ("conversa" com o banco)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; //para retornar a lista de clientes

@CrossOrigin(origins = "*")
@RestController //diz que a classe é uma api (vira endpoint HTTP)
@RequestMapping("/clientes") //URL base
public class ClienteController {

    @Autowired
    private ClienteRepository repository; //dá acesso ao banco

    @GetMapping //ao acessar o link busca os clientes e retorna a lista
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @PostMapping //transforma em objeto cliente, salva no banco e retorna cliente salvo
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente salvo = repository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

}