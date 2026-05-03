package com.processo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tbprocessosInadimplencia")
public class ProcessoInadimplencia extends Processo{
    //construtor vazio
    public ProcessoInadimplencia() {
    }

    //construtor p/ controller/testes
    public ProcessoInadimplencia(Cliente cliente, int nProcesso, double valorAtual) {
        super(cliente, nProcesso, valorAtual);
    }

}
