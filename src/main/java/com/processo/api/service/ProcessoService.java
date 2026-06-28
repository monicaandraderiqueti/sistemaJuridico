package com.processo.api.service;

import com.processo.api.model.Cliente;
import com.processo.api.model.Processo;
import com.processo.api.model.ProcessoInadimplencia;
import com.processo.api.repository.ClienteRepository;
import com.processo.api.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcessoService { // APENAS public class, sem "final"!

    @Autowired
    private ProcessoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos os processos
    public List<Processo> listar() {
        return repository.findAll();
    }

    // Método de teste para forçar a criação do primeiro cliente e processo
    public String testeProcesso() {
        Cliente c = new Cliente();
        c.setNome("Teste Groscon"); // Corrigido com N maiúsculo
        c.setCpfcnpj("00000000000");

        clienteRepository.save(c);

        ProcessoInadimplencia p = new ProcessoInadimplencia(c, 98765, 1500.50);
        p.setSituacaoAtual("Em andamento");
        p.setPassivel("Sim");

        repository.save(p);

        return "Processo salvo com sucesso!";
    }

    // Buscar por número do processo
    public List<Processo> buscarPorNumero(int numero) {
        return repository.findByNProcesso(numero);
    }

    // Buscar por nome do cliente
    public List<Processo> buscarPorCliente(String nome) {
        return repository.findByClienteNomeContainingIgnoreCase(nome);
    }

    // Salvar novo processo vindo do formulário manual
    @Transactional
    public Processo salvar(Processo processo) {
        if (processo.getCliente() != null && processo.getCliente().getId() != null) {
            Cliente clienteReal = clienteRepository.findById(processo.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
            processo.setCliente(clienteReal);
        }

        if (processo.getSituacaoAtual() == null) {
            processo.setSituacaoAtual("Aberto");
        }

        if (processo.getPassivel() == null) {
            processo.setPassivel("Talvez");
        }

        return repository.save(processo);
    }

    // Buscar processo por ID
    public Processo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Encerrar processo mudando o status de forma rápida
    public Processo encerrar(Long id) {
        Processo p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado."));

        p.setSituacaoAtual("Encerrado");
        return repository.save(p);
    }

    // Atualizar dados do processo (Edição completa corrigida)
    public Processo atualizar(Long id, Processo novo) {
        Processo p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado."));

        p.setnProcesso(novo.getnProcesso());
        p.setCidade(novo.getCidade());
        p.setValorAtual(novo.getValorAtual());
        p.setSituacaoAtual(novo.getSituacaoAtual());

        // Atualiza o nome do cliente dentro do relacionamento
        if (novo.getCliente() != null && p.getCliente() != null) {
            p.getCliente().setNome(novo.getCliente().getNome()); // Corrigido com N maiúsculo
        }

        if (novo.getPassivel() != null) {
            p.setPassivel(novo.getPassivel());
        }

        return repository.save(p);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Processo não encontrado com o ID: " + id);
        }
        repository.deletarPorIdDirect(id);
    }
}