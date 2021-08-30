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
public class DeputadoFederal extends Candidato implements Deputado {
    private Candidato suplente;
    
    public DeputadoFederal(String nome, String estado, Partido partido, Candidato suplente, int numero_cand) {
        super(nome, estado, partido, suplente, numero_cand);
        this.cargo = "Deputado Federal";
    }

    @Override
    public boolean verificarNumeroCandidato() {
        return this.numero_cand >= 1000 && this.numero_cand <= 9999;
    }

    @Override
    public boolean verificarNumeroCandidatoPorPartido() {
        return Integer.parseInt(Integer.toString(this.numero_cand).substring(0, 2)) != this.partido.getNumero();
    }
}
