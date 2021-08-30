/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.candidato;

/*
    Gabriel Arantes Resende Pereira - 202065126A
    Gabriel do Carmo Silva - 202065030A
    Pedro Leopoldo Dal-Col Vianna - 202065518B
    Pedro Paulo Silva Filogônio - 202065215A
 */
public class Candidato {
    String nome;
    String estado;
    Partido partido;
    Candidato suplente_vice;
    int numero_cand;
    int numero_votos;
    public String cargo;
    
    public Candidato(String nome, String estado, Partido partido) {
        this.nome = nome;
        this.estado = estado;
        this.partido = partido;
    }
    
    public Candidato(String nome, String estado, Partido partido, Candidato suplente_vice, int numero_cand) {
        this.nome = nome;
        this.estado = estado;
        this.partido = partido;
        this.suplente_vice = suplente_vice;
        this.numero_cand = numero_cand;
    }
    
    public String getNome() {
        return this.nome;
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
    
    public Candidato getSuplenteVice() {
        return this.suplente_vice;
    }    
    
    public void setNumeroVotos(int numero_votos) {
        this.numero_votos = numero_votos;
    }
    
    public String getEstado() {
        return this.estado;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
