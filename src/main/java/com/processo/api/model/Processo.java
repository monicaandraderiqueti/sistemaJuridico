package com.processo.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity // é entidade
@Table(name="tb_processo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Necessário porque a classe é abstrata e tem "filhas"
// Inheritance cria uma tabela separada para "mãe" e outras separadas p/ as "filhas"
@DiscriminatorColumn(name = "tipo_processo", discriminatorType = DiscriminatorType.STRING) // ajuda o banco a diferenciar os tipos de processo
public abstract class Processo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;

    // adicionado o cascade para salvar o cliente automaticamente ao salvar um processo
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    protected Cliente cliente; // Ligação direta com a classe Cliente

    protected LocalDate dataInicio;
    protected String dadosVeiculo;
    protected double valorAtual;
    @Column(name = "n_processo")
    protected int nProcesso;
    protected int nVara;
    protected String cidade;
    protected boolean acao;
    protected String resumo;
    protected String observacoes;
    protected String situacaoAtual;
    protected String passivel; // de receber(sim, talvez, não)

    // construtor vazio
    public Processo() {
    }

    // construtor
    public Processo(Cliente cliente, int nProcesso, double valorAtual) {
        this.cliente = cliente;
        this.nProcesso = nProcesso;
        this.valorAtual = valorAtual;
    }

    public String gerarResumo() {
        return "Processo nº " + nProcesso;
    }

    @JsonProperty("nomeCliente")
    public void setNomeCliente(String Nome) {
        if (this.cliente == null) {
            this.cliente = new Cliente();
        }

        this.cliente.setNome(Nome);
    }

    // Quando o Java enviar o processo para o front-end, ele extrai o nome do Cliente e manda limpo
    @JsonProperty("nomeCliente")
    public String getNomeCliente() {
        return this.cliente != null ? this.cliente.getNome() : "Sem Nome";
    }

    //getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDadosVeiculo() {
        return dadosVeiculo;
    }

    public void setDadosVeiculo(String dadosVeiculo) {
        this.dadosVeiculo = dadosVeiculo;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public int getnProcesso() {
        return nProcesso;
    }

    public void setnProcesso(int nProcesso) {
        this.nProcesso = nProcesso;
    }

    public int getnVara() {
        return nVara;
    }

    public void setnVara(int nVara) {
        this.nVara = nVara;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isAcao() {
        return acao;
    }

    public void setAcao(boolean acao) {
        this.acao = acao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getSituacaoAtual() {
        return situacaoAtual;
    }

    public void setSituacaoAtual(String situacaoAtual) {
        this.situacaoAtual = situacaoAtual;
    }

    public String getPassivel() {
        return passivel;
    }

    public void setPassivel(String passivel) {
        this.passivel = passivel;
    }
}