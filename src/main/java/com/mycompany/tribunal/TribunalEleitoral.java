/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tribunal;
import com.mycompany.candidato.Candidato;
import com.mycompany.candidato.DeputadoEstadual;
import com.mycompany.candidato.DeputadoFederal;
import com.mycompany.candidato.Partido;
import com.mycompany.candidato.Presidente;
import com.mycompany.candidato.Senador;
import com.mycompany.usuarios.Administrador;
import com.mycompany.usuarios.Eleitor;
import java.nio.charset.Charset;
import java.util.*;

/**
 *
 * @author gabriel
 */
public class TribunalEleitoral {
    Set<Candidato> listaCandidatos = new HashSet<>();
    Set<Eleitor> listaEleitores = new HashSet<>();
    Set<Partido> listaPartidos = new HashSet<>();
    Set<Administrador> listaAdministradores = new HashSet<>();
    
    private String id_teste = "admin";
    private String senha_teste = "senha";

    public Set<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }
    
    public Set<Eleitor> getListaEleitores() {
        return listaEleitores;
    }


    public void setListaCandidatos(Set<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }
    
    public void menuPrincipal() {
        //abre interface gráfica com menu principal para cadastro
    }
    
    public void cadastrarCandidato(String cargo, int numero, String nome, Partido partido, String estado, String suplente, String estado_suplente, Partido partido_suplente) {
        if(listaPartidos.contains(partido) && listaPartidos.contains(partido_suplente)) {
            if(null != cargo) switch (cargo) {
                case "Presidente":
                    boolean flag_presidente = false;
                    Presidente presidente = new Presidente(new Candidato(suplente, estado_suplente, partido_suplente), nome, estado, partido);
                    for(Candidato c : listaCandidatos) {
                        if(c.getClass() == presidente.getClass()) {
                            if(c.getPartido() == presidente.getPartido()) {
                                flag_presidente = true; //existe um candidato a presidente com esse partido
                                break;
                            }
                        }
                    }
                    if(!flag_presidente) {
                        listaCandidatos.add(presidente);
                    }    
                    break;
                case "Senador":
                    if(Integer.parseInt(Integer.toString(numero).substring(0, 2)) != partido.getNumero()) {
                        //partido diferente
                    }
                    else if(numero < 100 || numero > 999) {
                        //numero de digitos invalido
                    }
                    else {
                        boolean flag_senador = false;
                        Senador senador = new Senador(nome, estado, partido, new Candidato(suplente, estado_suplente, partido_suplente), numero);
                        for(Candidato c : listaCandidatos) {
                            if(c.getClass() == senador.getClass()) {
                                if(c.getNumero_cand() == senador.getNumero_cand()) {
                                    flag_senador = true;
                                    break;
                                }
                            }
                        }
                        if(!flag_senador) {
                            listaCandidatos.add(senador);
                        }    
                    }
                    break;
                case "Deputado Federal":
                    if(Integer.parseInt(Integer.toString(numero).substring(0, 2)) != partido.getNumero()) {
                        //nao cadastrou deputado federal
                    }
                    else if(numero < 1000 || numero > 9999) {
                        //nao cadastrou deputado federal
                    }
                    else {
                        boolean flag_depfed = false;
                        DeputadoFederal deputadoFederal = new DeputadoFederal(nome, estado, partido, new Candidato(suplente, estado_suplente, partido_suplente), numero);
                        for(Candidato c : listaCandidatos) {
                            if(c.getClass() == deputadoFederal.getClass()) {
                                if(c.getNumero_cand() == deputadoFederal.getNumero_cand()) {
                                    flag_depfed = true;
                                    break;
                                }
                            }
                        }
                        if(!flag_depfed) {
                            listaCandidatos.add(deputadoFederal);
                        }    
                    }
                    break;
                case "Deputado Estadual":
                    if(Integer.parseInt(Integer.toString(numero).substring(0, 2)) != partido.getNumero()) {
                        
                    }
                    else if(numero < 10000 || numero > 99999) {
                        //nao cadastrou deputado estadual
                    }
                    else {
                        boolean flag_depest = false;
                        DeputadoEstadual deputadoEstadual = new DeputadoEstadual(nome, estado, partido, new Candidato(suplente, estado_suplente, partido_suplente), numero);
                        for(Candidato c : listaCandidatos) {
                            if(c.getClass() == deputadoEstadual.getClass()) {
                                if(c.getNumero_cand() == deputadoEstadual.getNumero_cand()) {
                                    flag_depest = true;
                                    break;
                                }
                            }
                        }
                        if(!flag_depest) {
                            listaCandidatos.add(deputadoEstadual);
                        }   
                    }
                    break;
                default:
                    break;
            }
        }   
    }
    
    public void cadastrarPartido(Partido partido) {
        boolean flag = false;
        for(Partido p : listaPartidos) {
            if(p.getNumero() == partido.getNumero() || (p.getSigla() == null ? partido.getSigla() == null : p.getSigla().equals(partido.getSigla()))) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            listaPartidos.add(partido);
        }    
    }    
    
    public void cadastrarEleitor(String nome, String estado, String cpf, String titulo_eleitor) {
        boolean flag = false;
        for(Eleitor e : listaEleitores) {
            if((e.getCpf() == null ? cpf == null : e.getCpf().equals(cpf)) || (e.getTitulo_eleitor() == null ? titulo_eleitor == null : e.getTitulo_eleitor().equals(titulo_eleitor))) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            listaEleitores.add(new Eleitor(nome, estado, cpf, titulo_eleitor));
        }
    }
    
    public void cadastrarAdministrador(String nome, String senha) {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        
        Administrador adm = new Administrador(nome, senha);
        adm.setIdentificador(generatedString);
        listaAdministradores.add(adm);
        //mostrar na interface grafica o identificador do novo administrador cadastrado
    }
    
    public boolean login(String identificador, String senha) {
        for(Administrador administrador : this.listaAdministradores) {
            if((administrador.getIdentificador() == null ? identificador == null : administrador.getIdentificador().equals(identificador)) && (administrador.getSenha() == null ? senha == null : administrador.getSenha().equals(senha))) {
                System.out.println("Logado com sucesso!");
                return true;
            }
        }
        return false;
    }
}
