package com.processo.api.controller;

import com.processo.api.model.Cliente; //traz a classe Cliente
import com.processo.api.repository.ClienteRepository; //traz o repositório ("conversa" com o banco)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; //para retornar a lista de clientes

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
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }
    @GetMapping("/teste")
    public String teste() {
        Cliente c = new Cliente();
        c.setNomeCliente("Maria");
        c.setCpfcnpj("12345678900");
        c.setIdConsorciado("ABC123");
        c.setTelefone("44999999999");
        c.setEmail("maria@email.com");
        c.setEndereco("Rua X");
        c.setCidade("Guaíra");
        c.setnGrupo(1);
        c.setnCota(10);
        c.setInadimplente(false);

        repository.save(c);

        return "Cliente salvo!";
    }
}