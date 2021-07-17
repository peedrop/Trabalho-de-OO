/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tribunal;

import com.mycompany.candidato.Candidato;
import com.mycompany.candidato.DeputadoEstadual;
import com.mycompany.candidato.DeputadoFederal;
import com.mycompany.candidato.Presidente;
import com.mycompany.candidato.Senador;
import com.mycompany.usuarios.Eleitor;

/**
 *
 * @author gabriel
 */
public class UrnaEletronica {
    private static boolean votacao = false;
    private TribunalEleitoral tribunalEleitoral;
    
    public void setTribunalEleitoral(TribunalEleitoral tribunalEleitoral) {
        this.tribunalEleitoral = tribunalEleitoral;
    }
    
    public void iniciarVotacao() {
       votacao = true;
    }
    
    public void encerrarVotacao() {
        votacao = false;
        String[] estados = new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES",
        "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO",
        "RR", "SC", "SP", "SE", "TO"};
        Candidato presidente_eleito = null;
        Candidato senador_eleito = null;
        Candidato depfed_eleito = null;
        Candidato depest_eleito = null;
        Candidato sen_eleitos[] = null;
        Candidato depfed_eleitos[] = null;
        Candidato depest_eleitos[] = null;
        int i = 0;
        for(Candidato c : this.tribunalEleitoral.listaCandidatos) {
            if(c instanceof Presidente) {
                if(presidente_eleito == null) {
                    presidente_eleito = c;
                }
                else {
                    if(presidente_eleito.getNumeroVotos() < c.getNumeroVotos()) {
                        presidente_eleito = c;
                    }
                }
            }
        }    
        while(i < estados.length) {
            for(Candidato cand : this.tribunalEleitoral.listaCandidatos) {
                if(cand instanceof Senador) {
                    if(senador_eleito == null) {
                        senador_eleito = cand;
                    }
                    else {
                        if(senador_eleito.getNumeroVotos() < cand.getNumeroVotos() && (cand.getEstado() == null ? estados[i] == null : cand.getEstado().equals(estados[i]))) {
                            senador_eleito = cand;
                        }
                    }
                }
                if(cand instanceof DeputadoFederal) {
                    if(depfed_eleito == null) {
                        depfed_eleito = cand;
                    }
                    else {
                        if(depfed_eleito.getNumeroVotos() < cand.getNumeroVotos() && (cand.getEstado() == null ? estados[i] == null : cand.getEstado().equals(estados[i]))) {
                            depfed_eleito = cand;
                        }
                    }
                }
                if(cand instanceof DeputadoEstadual) {
                    if(depest_eleito == null) {
                        depest_eleito = cand;
                    }
                    else {
                        if(depest_eleito.getNumeroVotos() < cand.getNumeroVotos() && (cand.getEstado() == null ? estados[i] == null : cand.getEstado().equals(estados[i]))) {
                            depest_eleito = cand;
                        }
                    }
                }
            }
            depest_eleitos[i] = depest_eleito;
            depfed_eleitos[i] = depfed_eleito;
            sen_eleitos[i] = senador_eleito;
            depest_eleito = null;
            depfed_eleito = null;
            senador_eleito = null;
            i++;
        }
        System.out.println("Presidente eleito: " + presidente_eleito);
        for(int j = 0; j < estados.length; j++) {
           System.out.println("Senador eleito no estado " +  estados[j] + ": " + sen_eleitos[j]);
           System.out.println("Deputado federal eleito no estado " +  estados[j] + ": " + depfed_eleitos[j]);
           System.out.println("Deputado estadual eleito no estado " +  estados[j] + ": " + depest_eleitos[j]);
        } 
    }
    
    public void votar(String titulo_eleitor, String cargo, int numero_escolhido) {
        if(votacao) {
            Eleitor votante = null;
            for(Eleitor eleitor : this.tribunalEleitoral.getListaEleitores()) {
                if(eleitor.getTitulo_eleitor() == null ? titulo_eleitor == null : eleitor.getTitulo_eleitor().equals(titulo_eleitor)) {
                    votante = eleitor;
                }
            }
            for(Candidato candidato : this.tribunalEleitoral.getListaCandidatos()) {
                if(!"Presidente".equals(cargo)) {
                    if(candidato.getEstado() == null ? votante.getEstado() == null : candidato.getEstado().equals(votante.getEstado())) {
                        candidato.setNumeroVotos(1 + candidato.getNumeroVotos());
                    }
                    else {
                        System.out.println("Candidato não é do seu estado!");
                    }
                }
                else {
                    candidato.setNumeroVotos(1 + candidato.getNumeroVotos());
                }
            }
        }
        else {
            System.out.println("Votação não iniciada!");
        }
    }
    
    public static void main(String[] args) {
        
    }
}
