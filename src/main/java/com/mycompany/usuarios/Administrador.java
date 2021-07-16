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
public class Administrador {
    private String nome;
    private String senha;
    private String identificador;

    public Administrador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
