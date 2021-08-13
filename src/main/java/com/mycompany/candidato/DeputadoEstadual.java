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
public class DeputadoEstadual extends Deputado {

    public DeputadoEstadual(String nome, String estado, Partido partido, Candidato suplente, int numero_cand) {
        super(nome, estado, partido);
        this.suplente = suplente;
        this.numero_cand = numero_cand;
    }
}
