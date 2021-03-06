/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.politicos;

/*
    Gabriel Arantes Resende Pereira - 202065126A
    Gabriel do Carmo Silva - 202065030A
    Pedro Leopoldo Dal-Col Vianna - 202065518B
    Pedro Paulo Silva Filogônio - 202065215A
 */
public class Senador extends Candidato {
    private Candidato suplente;

    public Senador(String nome, String estado, Partido partido, Candidato suplente, int numero_cand) {
        super(nome, estado, partido, suplente, numero_cand);
        this.cargo = "Senador";
    }

    public Candidato getSuplente() {
        return suplente;
    }

    public void setSuplente(Candidato suplente) {
        this.suplente = suplente;
    }

    public int getNumero_cand() {
        return numero_cand;
    }

    public void setNumero_cand(int numero_cand) {
        this.numero_cand = numero_cand;
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
