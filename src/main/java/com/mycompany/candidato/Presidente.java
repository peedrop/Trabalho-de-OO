/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.candidato;

/**
 *
 * @author gabriel
 */
public class Presidente extends Candidato {
    private Candidato vice;

    public Presidente(Candidato vice, String nome, String estado, Partido partido) {
        super(nome, estado, partido, vice);
        this.numero_cand = partido.getNumero();
    }

    public Candidato getVice() {
        return vice;
    }

    public void setVice(Candidato vice) {
        this.vice = vice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    public void setNumero_votos(int numero_votos) {
        this.numero_votos = numero_votos;
    }
    
}
