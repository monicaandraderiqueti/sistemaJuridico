package com.processo.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_processos_Inadimplencia")
@DiscriminatorValue("INADIMPLENCIA")
public class ProcessoInadimplencia extends Processo{
    //construtor vazio
    public ProcessoInadimplencia() {
    }

    //construtor p/ controller/testes
    public ProcessoInadimplencia(Cliente cliente, int nProcesso, double valorAtual) {
        super(cliente, nProcesso, valorAtual);
    }

    @Override
    public String gerarResumo() {
        return "[INADIMPLÊNCIA] Processo nº " + nProcesso + " - Valor: " + valorAtual;
    }

}
