package com.processo.api.controller;

import com.processo.api.model.Cliente;
import com.processo.api.model.Processo;
import com.processo.api.model.ProcessoInadimplencia;
import com.processo.api.repository.ClienteRepository;
import com.processo.api.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
@CrossOrigin(origins = "*")
public class ProcessoController {
    @Autowired
    private ProcessoRepository repository;

    @GetMapping
    public List<Processo> listar() {
        return repository.findAll();
    }

    @Autowired
    private ClienteRepository clienteRepository; // Adicione isso aqui

    @GetMapping("/teste-save")
    public String testeProcesso() {
        //criar cliente
        Cliente c = new Cliente();
        c.setNomeCliente("Teste Groscon");
        c.setCpfcnpj("00000000000");
        clienteRepository.save(c); // Salva o cliente primeiro!

        //criar processo inadimplencia
        ProcessoInadimplencia p = new ProcessoInadimplencia(c, 98765, 1500.50);
        p.setSituacaoAtual("Em andamento");
        //salva no banco
        repository.save(p);

        return "Processo salvo com sucesso!";
    }

    @GetMapping("/listar-tudo")
    public List<Processo> listarTudo() {
        return repository.findAll();
    };

    @GetMapping("/buscar/numero")
    public List<Processo> buscarPorNumero(@RequestParam String numero) {
        return repository.buscarPorNumero(numero);
    }

    @GetMapping("/buscar/cliente")
    public List<Processo> buscarPorCliente(@RequestParam String nome) {
        return repository.buscarPorNomeCliente(nome);
    }
}