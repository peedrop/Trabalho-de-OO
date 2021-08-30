/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuarios;

/**
 *
 * @author gabriel
 */
public class Administrador extends Usuario {
    private String senha;
    private String identificador;

    public Administrador(String nome, String senha) {
        super(nome);
        this.senha = senha;
    }

    public String getIdentificador() {
        return identificador;
    }
    
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getSenha() {
        return this.senha;
    }

    @Override
    public String imprimirNomeFormatado() {
        return this.getNome() + " - " + this.identificador;
    }
}
