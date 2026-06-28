package com.processo.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("INADIMPLENCIA")
public class ProcessoInadimplencia extends Processo {


    // construtor vazio obrigatório para o Hibernate
    public ProcessoInadimplencia() {
    }

    // construtor p/ controller/testes que repassa os dados para a classe mãe (super)
    public ProcessoInadimplencia(Cliente cliente, int nProcesso, double valorAtual) {
        super(cliente, nProcesso, valorAtual);
    }

    @Override
    public String gerarResumo() {
        return "[INADIMPLÊNCIA] Processo nº " + nProcesso + " - Valor: " + valorAtual;
    }
}