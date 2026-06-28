package com.processo.api.service;

import com.processo.api.model.Cliente;
import com.processo.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //fala pro Spring que essa classe é um service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    //listar clientes
    public List<Cliente> listar() {
        return repository.findAll();
    }

    //salvar cliente
    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }
}