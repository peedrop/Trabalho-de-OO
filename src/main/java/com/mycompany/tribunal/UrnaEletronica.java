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
import java.util.Set;
/**
 *
 * @author gabriel
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
            ArrayList<Candidato> presidentes = new ArrayList<>();
            ArrayList<Candidato[]> senadores = new ArrayList<>();
            ArrayList<Candidato[]> deputados_federais = new ArrayList<>();
            ArrayList<Candidato[]> deputados_estaduais = new ArrayList<>();
            ArrayList<Candidato[]> sen_eleitos = new ArrayList<>();
            ArrayList<Candidato[]> depfed_eleitos = new ArrayList<>();
            ArrayList<Candidato[]> depest_eleitos = new ArrayList<>();
            for(Candidato c : listaProvisoria) {
                if("Presidente".equals(c.cargo)) {
                    presidentes.add(c);
                }
            }
            Candidato senadores_estado[] = {null, null, null};
            Candidato deputadosf_estado[] = {null, null, null};
            Candidato deputadose_estado[] = {null, null, null};
            int sen = 0, depf = 0, depe = 0;
            for (String estado : estados) {
                for (Candidato c : listaProvisoria) {
                    if(c.getEstado().trim().equals(estado)) {
                        if ("Senador".equals(c.cargo)) {
                            senadores_estado[sen] = c;
                            sen++;
                        }
                        if("Deputado Federal".equals(c.cargo)) {
                            deputadosf_estado[depf] = c;
                            depf++;
                        }
                        if("Deputado Estadual".equals(c.cargo)) {
                            deputadose_estado[depe] = c;
                            depe++;
                        }
                    }    
                }
                sen = 0;
                depf = 0;
                depe = 0;
                senadores.add(senadores_estado);
                deputados_federais.add(deputadosf_estado);
                deputados_estaduais.add(deputadose_estado);
                senadores_estado[0] = null;
                senadores_estado[1] = null;
                senadores_estado[2] = null;
                deputadosf_estado[0] = null;
                deputadosf_estado[1] = null;
                deputadosf_estado[2] = null;
                deputadose_estado[0] = null;
                deputadose_estado[1] = null;
                deputadose_estado[2] = null;
            }
            for(Candidato c : listaProvisoria) {
                if("Presidente".equals(c.cargo)) {
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
            Candidato aux_senadores_eleitos[] = {null, null, null};
            Candidato aux_deputadosf_eleitos[] = {null, null, null};
            Candidato aux_deputadose_eleitos[] = {null, null, null};
            int n_cand;
            for(i = 0; i < estados.length; i++) {
                if(senadores.get(i) != null) {
                    if(senadores.get(i).length >= 3) {
                        n_cand = 3;
                    }
                    else {
                        n_cand = senadores.get(i).length;
                    }
                    for(int j = 0; j < n_cand; j++) {
                        for(Candidato cand : this.tribunalEleitoral.getListaCandidatos()) {
                            if("Senador".equals(cand.cargo) && cand.getEstado().trim().equals(estados[i])) {
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
                        aux_senadores_eleitos[j] = senador_eleito;
                        listaProvisoria.remove(senador_eleito);
                        senador_eleito = null;
                    }
                }
                if(deputados_federais.get(i) != null) {
                    if(deputados_federais.get(i).length >= 3) {
                        n_cand = 3;
                    }
                    else {
                        n_cand = deputados_federais.get(i).length;
                    }
                    for(int j = 0; j < n_cand; j++) {
                        for(Candidato cand : this.tribunalEleitoral.getListaCandidatos()) {
                            if("Deputado Federal".equals(cand.cargo) && cand.getEstado().trim().equals(estados[i])) {
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
                        aux_deputadosf_eleitos[j] = depfed_eleito;
                        listaProvisoria.remove(depfed_eleito);
                        depfed_eleito = null;
                    }
                }
                if(deputados_estaduais.get(i) != null) {
                    if(deputados_estaduais.get(i).length >= 3) {
                        n_cand = 3;
                    }
                    else {
                        n_cand = deputados_estaduais.get(i).length;
                    }
                    for(int j = 0; j < n_cand; j++) {
                        for(Candidato cand : this.tribunalEleitoral.getListaCandidatos()) {
                            if("Deputado Estadual".equals(cand.cargo) && cand.getEstado().trim().equals(estados[i])) {
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
                        aux_deputadose_eleitos[j] = depest_eleito;
                        listaProvisoria.remove(depest_eleito);
                        depest_eleito = null;
                    }
                }
                sen_eleitos.add(aux_senadores_eleitos);
                depfed_eleitos.add(aux_deputadosf_eleitos);
                depest_eleitos.add(aux_deputadose_eleitos);
                senadores_estado = null;
                deputadosf_estado = null;
                deputadose_estado = null;
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
                if(sen_eleitos.get(j) == null) {
                    retorno += "Nenhum candidato a senador neste estado foi cadastrado.\n";
                }
                else {
                    if(numero_votos_estado_sen[j] > 0) {
                        for(int cont = 0; cont < sen_eleitos.get(j).length; cont++) {
                            if(sen_eleitos.get(j)[cont] != null) {
                                retorno += "Nome: " + sen_eleitos.get(j)[cont].getNome() + " | Partido: " + sen_eleitos.get(j)[cont].getPartido().getSigla() + " | Número de votos: " + sen_eleitos.get(j)[cont].getNumeroVotos() + " (" + (sen_eleitos.get(j)[cont].getNumeroVotos() / (numero_votos_estado_sen[j]))*100 + "% dos votos válidos) (Eleito)\n";
                            }    
                        }
                        for(Candidato c : listaProvisoria) {
                            if("Senador".equals(c.cargo) && (c.getEstado() == null ? estados[j] == null : c.getEstado().equals(estados[j]))) {
                                retorno += "Nome: " + c.getNome() + " | Partido: " + c.getPartido() + " | Número de votos: " + c.getNumeroVotos() + " (" + (c.getNumeroVotos() / (numero_votos_estado_sen[j]))*100 + "% dos votos válidos)\n";
                            }
                        }
                    }
                    else {
                        retorno += "Não houveram votos válidos.\n";
                    }
                }
                retorno += "DEPUTADO FEDERAL " + estados[j] + "\n";
                if(depfed_eleitos.get(j) == null) {
                    retorno += "Nenhum candidato a deputado federal neste estado foi cadastrado.\n";
                }
                else {
                    if(numero_votos_estado_depfed[j] > 0) {
                        for(int cont = 0; cont < depfed_eleitos.get(j).length; cont++) {
                            if(depfed_eleitos.get(j)[cont] != null) {
                                retorno += "Nome: " + depfed_eleitos.get(j)[cont].getNome() + " | Partido: " + depfed_eleitos.get(j)[cont].getPartido().getSigla() + " | Número de votos: " + depfed_eleitos.get(j)[cont].getNumeroVotos() + " (" + (depfed_eleitos.get(j)[cont].getNumeroVotos() / (numero_votos_estado_depfed[j]))*100 + "% dos votos válidos) (Eleito)\n";
                            }    
                        }
                        for(Candidato c : listaProvisoria) {
                            if("Deputado Federal".equals(c.cargo) && (c.getEstado() == null ? estados[j] == null : c.getEstado().trim().equals(estados[j]))) {
                                retorno += "Nome: " + c.getNome() + " | Partido: " + c.getPartido() + " | Número de votos: " + c.getNumeroVotos() + " (" + (c.getNumeroVotos() / (numero_votos_estado_depfed[j]))*100 + "% dos votos válidos)\n";
                            }
                        }
                    }
                    else {
                        retorno += "Não houveram votos válidos.\n";
                    }
                }
                retorno += "DEPUTADO ESTADUAL " + estados[j] + "\n";
                if(depest_eleitos.get(j) == null) {
                    retorno += "Nenhum candidato a deputado estadual neste estado foi cadastrado!\n";
                }
                else {
                    if(numero_votos_estado_depest[j] > 0) {
                        for(int cont = 0; cont < depest_eleitos.get(j).length; cont++) {
                            if(depest_eleitos.get(j)[cont] != null) {
                                retorno += "Nome: " + depest_eleitos.get(j)[cont].getNome() + " | Partido: " + depest_eleitos.get(j)[cont].getPartido().getSigla() + " | Número de votos: " + depest_eleitos.get(j)[cont].getNumeroVotos() + " ( " + (depest_eleitos.get(j)[cont].getNumeroVotos() / (numero_votos_estado_depest[j]))*100 + "% dos votos válidos) (Eleito)\n";
                            }    
                        }
                        for(Candidato c : listaProvisoria) {
                            if("Deputado Estadual".equals(c.cargo) && (c.getEstado() == null ? estados[j] == null : c.getEstado().equals(estados[j]))) {
                                retorno += "Nome: " + c.getNome() + " | Partido: " + c.getPartido() + " | Número de votos: " + c.getNumeroVotos() + " (" + (c.getNumeroVotos() / (numero_votos_estado_depest[j]))*100 + "% dos votos válidos)\n";
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
}
