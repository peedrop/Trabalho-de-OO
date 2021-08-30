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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/*
    Gabriel Arantes Resende Pereira - 202065126A
    Gabriel do Carmo Silva - 202065030A
    Pedro Leopoldo Dal-Col Vianna - 202065518B
    Pedro Paulo Silva Filogônio - 202065215A
 */
public class UrnaEletronica {
    private static boolean votacao = false;
    private static float numero_votos_presidente = 0;
    private static float[] numero_votos_estado_sen = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static float[] numero_votos_estado_depest = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static float[] numero_votos_estado_depfed = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private final String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES",
        "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO",
        "RR", "SC", "SP", "SE", "TO"};
    private TribunalEleitoral tribunalEleitoral;

    public UrnaEletronica() {
        this.tribunalEleitoral = new TribunalEleitoral();
    }
    
    public void setTribunalEleitoral(TribunalEleitoral tribunalEleitoral) {
        this.tribunalEleitoral = tribunalEleitoral;
    }
    
    public TribunalEleitoral getTribunalEleitoral() {
        return this.tribunalEleitoral;
    }
    
    public boolean getVotacao() {
        return votacao;
    }
    
    public void iniciarVotacao() {
       votacao = true;
    }
    
    public String encerrarVotacao() {
//        try {
            String retorno = "";
            votacao = false;
            Candidato presidente_eleito = null;
            Candidato senador_eleito = null;
            Candidato depfed_eleito = null;
            Candidato depest_eleito = null;
            Set<Candidato> listaProvisoria = this.getTribunalEleitoral().getListaCandidatos();
            Candidato matriz_sen[][] = new Candidato[27][10];
            Candidato matriz_depFed[][] = new Candidato[27][10];
            Candidato matriz_depEst[][] = new Candidato[27][10];
            Candidato matriz_sen_eleitos[][] = new Candidato[27][3];
            Candidato matriz_depFed_eleitos[][] = new Candidato[27][3];
            Candidato matriz_depEst_eleitos[][] = new Candidato[27][3];
            int sen = 0, depf = 0, depe = 0;
            int num_est = 0;
            for (String estado : estados) {
                for (Candidato c : listaProvisoria) {
                    if(c.getEstado().trim().equals(estado)) {
                        if ("Senador".equals(c.cargo)) {
                            matriz_sen[num_est][sen] = c;
                            sen++;
                        }
                        if("Deputado Federal".equals(c.cargo)) {
                            matriz_depFed[num_est][depf] = c;
                            depf++;
                        }
                        if("Deputado Estadual".equals(c.cargo)) {
                            matriz_depEst[num_est][depe] = c;
                            depe++;
                        }
                    }    
                }
                sen = 0;
                depf = 0;
                depe = 0;
                num_est++;
            }
            for(Candidato c : listaProvisoria) {
                if("Presidente".equals(c.cargo) && (c.getNumeroVotos() > 0)) {
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
            listaProvisoria.remove(presidente_eleito);
            int i = 0;
            int n_cand;
            for(i = 0; i < estados.length; i++) {
                if(matriz_sen[i][0] != null) {
                    n_cand = 3;
                    for(int j = 0; j < n_cand; j++) {
                        for(Candidato cand : listaProvisoria) {
                            if(("Senador".equals(cand.cargo) && cand.getEstado().trim().equals(estados[i])) && (cand.getNumeroVotos() > 0)) {
                                if(senador_eleito == null) {
                                    senador_eleito = cand;
                                }
                                else {
                                    if(senador_eleito.getNumeroVotos() < cand.getNumeroVotos() && (cand.getEstado() == null ? estados[i] == null : cand.getEstado().equals(estados[i]))) {
                                        senador_eleito = cand;
                                    }
                                }
                            }
                        }
                        matriz_sen_eleitos[i][j] = senador_eleito;
                        listaProvisoria.remove(senador_eleito);
                        senador_eleito = null;
                    }
                }
                if(matriz_depFed[i][0] != null) {
                    n_cand = 3;
                    for(int j = 0; j < n_cand; j++) {
                        for(Candidato cand : listaProvisoria) {
                            if(("Deputado Federal".equals(cand.cargo) && cand.getEstado().trim().equals(estados[i])) && (cand.getNumeroVotos() > 0)) {
                                if(depfed_eleito == null) {
                                    depfed_eleito = cand;
                                }
                                else {
                                    if(depfed_eleito.getNumeroVotos() < cand.getNumeroVotos() && (cand.getEstado() == null ? estados[i] == null : cand.getEstado().equals(estados[i]))) {
                                        depfed_eleito = cand;
                                    }
                                }
                            }
                        }
                        matriz_depFed_eleitos[i][j] = depfed_eleito;
                        listaProvisoria.remove(depfed_eleito);
                        depfed_eleito = null;
                    }
                }
                if(matriz_depEst[i][0] != null) {
                    n_cand = 3;
                    for(int j = 0; j < n_cand; j++) {
                        for(Candidato cand : listaProvisoria) {
                            if(("Deputado Estadual".equals(cand.cargo) && cand.getEstado().trim().equals(estados[i])) && (cand.getNumeroVotos() > 0)) {
                                if(depest_eleito == null) {
                                    depest_eleito = cand;
                                }
                                else {
                                    if(depest_eleito.getNumeroVotos() < cand.getNumeroVotos() && (cand.getEstado().trim().equals(estados[i]))) {
                                        depest_eleito = cand;
                                    }
                                }
                            }
                        }
                        matriz_depEst_eleitos[i][j] = depest_eleito;
                        listaProvisoria.remove(depest_eleito);
                        depest_eleito = null;
                    }
                }
            }
            retorno += "PRESIDENTE\n";
            if(presidente_eleito == null) {
                retorno += "Nenhum candidato a presidente foi cadastrado.\n";
            }
            else {
                if(numero_votos_presidente > 0) {
                    retorno += "Nome: " + presidente_eleito.getNome() + " | Partido: " + presidente_eleito.getPartido().getSigla() + " | Número de votos: " + presidente_eleito.getNumeroVotos() + " (" + (presidente_eleito.getNumeroVotos() / numero_votos_presidente)*100 + "% dos votos válidos) ";
                    retorno += " (Eleito) \n";
                    for(Candidato c : listaProvisoria) {
                        if("Presidente".equals(c.cargo)) {
                            retorno += "Nome: " + c.getNome() + " | Partido: " + c.getPartido().getSigla() + " | Número de votos: " + c.getNumeroVotos() + " (" + (c.getNumeroVotos() / numero_votos_presidente)*100 + "% dos votos válidos)\n";
                        }
                    }
                }
                else {
                    retorno += "Não houveram votos válidos.\n";
                }
            }
            for(int j = 0; j < estados.length; j++) {
                retorno += "SENADOR " + estados[j] + "\n";
                if(matriz_sen_eleitos[j][0] == null) {
                    retorno += "Nenhum candidato a senador neste estado foi cadastrado.\n";
                }
                else {
                    if(numero_votos_estado_sen[j] > 0) {
                        for(int cont = 0; cont < matriz_sen_eleitos[j].length; cont++) {
                            if(matriz_sen_eleitos[j][cont] != null) {
                                retorno += "Nome: " + matriz_sen_eleitos[j][cont].getNome() + " | Partido: " + matriz_sen_eleitos[j][cont].getPartido().getSigla() + " | Número de votos: " + matriz_sen_eleitos[j][cont].getNumeroVotos() + " (" + (matriz_sen_eleitos[j][cont].getNumeroVotos() / (numero_votos_estado_sen[j]))*100 + "% dos votos válidos) (Eleito)\n";
                            }    
                        }
                        for(Candidato c : listaProvisoria) {
                            if("Senador".equals(c.cargo) && (c.getEstado() == null ? estados[j] == null : c.getEstado().trim().equals(estados[j]))) {
                                retorno += "Nome: " + c.getNome() + " | Partido: " + c.getPartido().getSigla() + " | Número de votos: " + c.getNumeroVotos() + " (" + (c.getNumeroVotos() / (numero_votos_estado_sen[j]))*100 + "% dos votos válidos)\n";
                            }
                        }
                    }
                    else {
                        retorno += "Não houveram votos válidos.\n";
                    }
                }
                retorno += "DEPUTADO FEDERAL " + estados[j] + "\n";
                if(matriz_depFed_eleitos[j] == null) {
                    retorno += "Nenhum candidato a deputado federal neste estado foi cadastrado.\n";
                }
                else {
                    if(numero_votos_estado_depfed[j] > 0) {
                        for(int cont = 0; cont < matriz_depFed_eleitos[j].length; cont++) {
                            if(matriz_depFed_eleitos[j][cont] != null) {
                                retorno += "Nome: " + matriz_depFed_eleitos[j][cont].getNome() + " | Partido: " + matriz_depFed_eleitos[j][cont].getPartido().getSigla() + " | Número de votos: " + matriz_depFed_eleitos[j][cont].getNumeroVotos() + " (" + (matriz_depFed_eleitos[j][cont].getNumeroVotos() / (numero_votos_estado_depfed[j]))*100 + "% dos votos válidos) (Eleito)\n";
                            }    
                        }
                        for(Candidato c : listaProvisoria) {
                            if("Deputado Federal".equals(c.cargo) && (c.getEstado() == null ? estados[j] == null : c.getEstado().trim().equals(estados[j]))) {
                                retorno += "Nome: " + c.getNome() + " | Partido: " + c.getPartido().getSigla() + " | Número de votos: " + c.getNumeroVotos() + " (" + (c.getNumeroVotos() / (numero_votos_estado_depfed[j]))*100 + "% dos votos válidos)\n";
                            }
                        }
                    }
                    else {
                        retorno += "Não houveram votos válidos.\n";
                    }
                }
                retorno += "DEPUTADO ESTADUAL " + estados[j] + "\n";
                if(matriz_depEst_eleitos[j] == null) {
                    retorno += "Nenhum candidato a deputado estadual neste estado foi cadastrado!\n";
                }
                else {
                    if(numero_votos_estado_depest[j] > 0) {
                        for(int cont = 0; cont < matriz_depEst_eleitos[j].length; cont++) {
                            if(matriz_depEst_eleitos[j][cont] != null) {
                                retorno += "Nome: " + matriz_depEst_eleitos[j][cont].getNome() + " | Partido: " + matriz_depEst_eleitos[j][cont].getPartido().getSigla() + " | Número de votos: " + matriz_depEst_eleitos[j][cont].getNumeroVotos() + " ( " + (matriz_depEst_eleitos[j][cont].getNumeroVotos() / (numero_votos_estado_depest[j]))*100 + "% dos votos válidos) (Eleito)\n";
                            }    
                        }
                        for(Candidato c : listaProvisoria) {
                            if("Deputado Estadual".equals(c.cargo) && (c.getEstado() == null ? estados[j] == null : c.getEstado().trim().equals(estados[j]))) {
                                retorno += "Nome: " + c.getNome() + " | Partido: " + c.getPartido().getSigla() + " | Número de votos: " + c.getNumeroVotos() + " (" + (c.getNumeroVotos() / (numero_votos_estado_depest[j]))*100 + "% dos votos válidos)\n";
                            }
                        }
                    }
                    else {
                        retorno += "Não houveram votos válidos.\n";
                    }
                }
            }
            return retorno;
//        } catch(Exception e) {
//            return "Erro!";
//        }    
    }
    
    public boolean validaDadosEleitor(String titulo_eleitor, String cpf) {
        for(Eleitor e : this.tribunalEleitoral.getListaEleitores()) {
            if(e.getCpf().equals(cpf) && e.getTitulo_eleitor().equals(titulo_eleitor) && !e.getVotou()) {
                return true;
            }
        }
        return false;
    }    
    
    public String votar(String titulo_eleitor, String cargo, int numero_escolhido) {
        try {
            if(votacao) {
                Eleitor votante = null;
                for(Eleitor eleitor : this.tribunalEleitoral.getListaEleitores()) {
                    if(eleitor.getTitulo_eleitor() == null ? titulo_eleitor == null : eleitor.getTitulo_eleitor().equals(titulo_eleitor)) {
                        votante = eleitor;
                    }
                }
                if(validaDadosEleitor(titulo_eleitor, votante.getCpf())) {
                    for(Candidato candidato : this.tribunalEleitoral.getListaCandidatos()) {
                        if(candidato.getNumero_cand() == numero_escolhido) {
                            if("Presidente".equals(candidato.cargo)) {
                                candidato.setNumeroVotos(1 + candidato.getNumeroVotos());
                                numero_votos_presidente++;
                                Eleitor antigo = votante;
                                votante.setVotou(true);
                                this.getTribunalEleitoral().editarEleitor(antigo, votante);
                                return "Voto contabilizado com sucesso!";
                            }else {
                                for(int i = 0; i < estados.length; i++) {
                                    if(votante.getEstado().trim().equals(estados[i])) {
                                        if("Senador".equals(candidato.cargo)) {
                                            candidato.setNumeroVotos(1 + candidato.getNumeroVotos());
                                            numero_votos_estado_sen[i]++;
                                            return "Voto contabilizado com sucesso!";
                                        }
                                        else if("Deputado Estadual".equals(candidato.cargo)) {
                                            candidato.setNumeroVotos(1 + candidato.getNumeroVotos());
                                            numero_votos_estado_depest[i]++;
                                            return "Voto contabilizado com sucesso!";
                                        }
                                        else if("Deputado Federal".equals(candidato.cargo)) {
                                            candidato.setNumeroVotos(1 + candidato.getNumeroVotos());
                                            numero_votos_estado_depfed[i]++;
                                            return "Voto contabilizado com sucesso!";
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if("Presidente".equals(cargo)){
                        Eleitor antigo = votante;
                        votante.setVotou(true);
                        this.getTribunalEleitoral().editarEleitor(antigo, votante);
                    }
                    return "Voto nulo!";
                }
            }
            else {
                return "Votação não iniciada!";
            }
        } catch(Exception e) {
            return "Erro!";
        }
        return "Erro desconhecido!";
    }
    
    public Candidato buscaCandidato(int numero) {
        for(Candidato c : this.tribunalEleitoral.getListaCandidatos()) {
            if(c.getNumero_cand() == numero) {
                return c;
            }
        }
        return null;
    }
    
    public Eleitor buscaEleitorTitulo(String titulo) {
        for(Eleitor e : this.tribunalEleitoral.getListaEleitores()) {
            if(e.getTitulo_eleitor().equals(titulo)) {
                return e;
            }
        }
        return null;
    }
}
