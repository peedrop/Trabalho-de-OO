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
public class Candidato {
    String nome;
    String estado;
    Partido partido;
    int numero_cand;
    int numero_votos;
    
    public Candidato(String nome, String estado, Partido partido) {
        this.nome = nome;
        this.estado = estado;
        this.partido = partido;
    }

    public Partido getPartido() {
        return this.partido;
    }

    public int getNumero_cand() {
        return numero_cand;
    }

    public int getNumeroVotos() {
        return this.numero_votos;
    }
    
    public void setNumeroVotos(int numero_votos) {
        this.numero_votos = numero_votos;
    }
    
    public String getEstado() {
        return this.estado;
    }
}
