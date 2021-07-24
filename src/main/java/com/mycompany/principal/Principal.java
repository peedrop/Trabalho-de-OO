/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.principal;

import com.mycompany.candidato.Candidato;
import com.mycompany.candidato.Partido;
import com.mycompany.candidato.Presidente;
import com.mycompany.tribunal.TribunalEleitoral;
import com.mycompany.tribunal.UrnaEletronica;
import java.util.Set;

/**
 *
 * @author gabriel
 */
public class Principal {
    public static void main(String[] args) {
        UrnaEletronica urna = new UrnaEletronica();
        TribunalEleitoral tribunal = new TribunalEleitoral();
        Partido p1 = new Partido("Partido 1", 13, "P1");
        Partido p2 = new Partido("Partido 2", 14, "P2");
        tribunal.cadastrarPartido(p1);
        tribunal.cadastrarPartido(p2);
        tribunal.cadastrarCandidato("Presidente", 13, "Gabriel", 
                p1, "MG", 
                "Suplente", "MG", p2);
        tribunal.cadastrarEleitor("Gabriel", "MG", "12901920192", "102910921029");
        tribunal.cadastrarAdministrador("Admin", "123456");
        urna.setTribunalEleitoral(tribunal);
        Set<Candidato> lista = tribunal.getListaCandidatos();
    }
}
