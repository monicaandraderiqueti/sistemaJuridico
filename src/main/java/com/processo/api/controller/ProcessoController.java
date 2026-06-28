package com.processo.api.controller;

import com.processo.api.model.Processo;
import com.processo.api.model.ProcessoInadimplencia;
import com.processo.api.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
@CrossOrigin(origins = "*")
public class ProcessoController {
    @Autowired
    private ProcessoService service;

    @GetMapping
    public List<Processo> listar() {
        return service.listar();
    }

    @GetMapping("/teste-save")
    public String testeProcesso() {
        return service.testeProcesso();
    }

    @GetMapping("/buscar/numero")
    public List<Processo> buscarPorNumero(
            @RequestParam int numero) {

        return service.buscarPorNumero(numero);
    }

    @GetMapping("/buscar/cliente")
    public List<Processo> buscarPorCliente(
            @RequestParam String nome) {

        return service.buscarPorCliente(nome);
    }

    @PostMapping
    public ResponseEntity<Processo> salvar(@RequestBody ProcessoInadimplencia novoProcesso) {
        Processo salvo = service.salvar(novoProcesso);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public Processo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}/encerrar")
    public Processo encerrar(@PathVariable Long id) {
        return service.encerrar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Processo> atualizar(@PathVariable Long id, @RequestBody ProcessoInadimplencia processoAlterado) {
        Processo atualizado = service.atualizar(id, processoAlterado);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}