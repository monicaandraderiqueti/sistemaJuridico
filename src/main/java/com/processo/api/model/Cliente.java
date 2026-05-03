package com.processo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

    @Entity //mostra que é entidade (vira tabela)
    @Table(name="tb_clientes")
    public class Cliente {

        @Id //chave primária
        @GeneratedValue(strategy = GenerationType.IDENTITY)//banco cria valor sozinho, como se fosse um contador
        //atributos
        private Long id;

        @OneToMany(mappedBy = "cliente")
        @JsonIgnore
        private List<Processo> processos;

        //identificadores
        private String nomeCliente;
        private String cpfcnpj;
        private String idConsorciado; //identificador(numero do contrato ou algo do tipo)
        //atributos contato
        private String telefone;
        private String email;
        private String endereco;
        private String cidade;
        //atributos consorcio
        private int nGrupo;
        private int nCota;
        private boolean inadimplente; //se o cliente apresenta inadimplencia

        //construtor vazio para o JPA(comunicação do Java com o banco)

        public Cliente() {
        }

        //construtor
        public Cliente(String nomeCliente, String cpfcnpj, String idConsorciado, String telefone, String email, String endereco, String cidade, int nGrupo, int nCota, boolean inadimplente) {
            this.nomeCliente = nomeCliente;
            this.cpfcnpj = cpfcnpj;
            this.idConsorciado = idConsorciado;
            this.telefone = telefone;
            this.email = email;
            this.endereco = endereco;
            this.cidade = cidade;
            this.nGrupo = nGrupo;
            this.nCota = nCota;
            this.inadimplente = inadimplente;
        }
        //getters e setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public String getCpfcnpj() {
            return cpfcnpj;
        }

        public void setCpfcnpj(String cpfcnpj) {
            this.cpfcnpj = cpfcnpj;
        }

        public String getIdConsorciado() {
            return idConsorciado;
        }

        public void setIdConsorciado(String idConsorciado) {
            this.idConsorciado = idConsorciado;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public int getnGrupo() {
            return nGrupo;
        }

        public void setnGrupo(int nGrupo) {
            this.nGrupo = nGrupo;
        }

        public int getnCota() {
            return nCota;
        }

        public void setnCota(int nCota) {
            this.nCota = nCota;
        }

        public boolean isInadimplente() {
            return inadimplente;
        }

        public void setInadimplente(boolean inadimplente) {
            this.inadimplente = inadimplente;
        }
    }

