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
public class Deputado extends Candidato {
    String nome;
    String estado;
    Partido partido;
    Candidato suplente;
    int numero_cand;
    
    public Deputado(String nome, String estado, Partido partido) {
        super(nome, estado, partido);
    }
}
