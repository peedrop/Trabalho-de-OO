/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tribunal;

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
    }
    
    public void votar(String cargo, int numero_escolhido) {
        if(votacao) {
            tribunalEleitoral.getListaCandidatos().stream().filter((candidato) -> (candidato.getNumero_cand() == numero_escolhido)).forEachOrdered((candidato) -> {
                candidato.setNumeroVotos(1 + candidato.getNumeroVotos());
            });
        }
        else {
            System.out.println("Votação não iniciada!");
        }
    }
    
    public static void main(String[] args) {
        
    }
}
