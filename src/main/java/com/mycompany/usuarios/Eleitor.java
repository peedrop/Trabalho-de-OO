package com.mycompany.usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Eleitor {
    private String nome;
    private String estado;
    private String cpf;
    private String titulo_eleitor;
    private boolean votou;
    private static boolean validado;

    public Eleitor(String nome, String estado, String cpf, String titulo_eleitor) {
        this.nome = nome;
        this.estado = estado;
        this.cpf = cpf;
        this.titulo_eleitor = titulo_eleitor;
        this.votou = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getVotou() {
        return votou;
    }

    public void setVotou(boolean votou) {
        this.votou = votou;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTitulo_eleitor() {
        return titulo_eleitor;
    }

    public void setTitulo_eleitor(String titulo_eleitor) {
        this.titulo_eleitor = titulo_eleitor;
    }
    
    public void setValidado(boolean validado) {
        Eleitor.validado = validado;
        /*método usado pra verificar se ele pode votar ou não. deve ser chamado
        após o eleitor informar seus dados antes da primeira tela de votação */
    }
}
