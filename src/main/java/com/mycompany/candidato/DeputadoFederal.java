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
public class DeputadoFederal extends Candidato {
    private Candidato suplente;
    private int numero_cand;
    
    public DeputadoFederal(String nome, String estado, Partido partido, Candidato suplente, int numero_cand) {
        super(nome, estado, partido, suplente);
        this.numero_cand = numero_cand; 
        this.cargo = "Deputado Federal";
    }

    public int getNumero_cand() {
        return numero_cand;
    }
    
}
