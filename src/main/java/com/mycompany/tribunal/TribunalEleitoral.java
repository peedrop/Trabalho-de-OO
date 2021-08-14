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
    private Set<Candidato> listaCandidatos = new HashSet<>();
    private Set<Eleitor> listaEleitores = new HashSet<>();
    private Set<Partido> listaPartidos = new HashSet<>();
    private Set<Administrador> listaAdministradores = new HashSet<>();

    public Set<Candidato> getListaCandidatos() {
        return this.listaCandidatos;
    }
    
    public Set<Eleitor> getListaEleitores() {
        return this.listaEleitores;
    }

    public Set<Partido> getListaPartidos() {
        return this.listaPartidos;
    }

    public void setListaCandidatos(Set<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }
    
    public void menuPrincipal() {
        //abre interface gráfica com menu principal para cadastro
    }
    
    public void cadastrarCandidato(String cargo, int numero, String nome, Partido partido, String estado, String suplente, String estado_suplente, Partido partido_suplente) {
        try {
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
        } catch(NumberFormatException e) {
            System.out.println("Erro!");
        }    
    }
    
    public void cadastrarPartido(Partido partido) {
        try {
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
        } catch(Exception e) {    
            System.out.println("Erro!");
        }
    }

    public void editarPartido(Partido partido_antigo, Partido partido_novo) {
        listaPartidos.stream().filter((p) -> (partido_antigo == p)).forEachOrdered((p) -> {
            p = partido_novo;
        });
    }
    
    public void deletarPartido(Partido partido) {
        listaPartidos.remove(partido);
    }
    
    public void editarCandidato(Candidato candidato_antigo, Candidato candidato_novo) {
        listaCandidatos.stream().filter((c) -> (candidato_antigo == c)).forEachOrdered((c) -> {
           c = candidato_novo; 
        });
    }
    
    public void deletarCandidato(Candidato candidato) {
        listaCandidatos.remove(candidato);
    }
    
    public void editarEleitor(Eleitor eleitor_antigo, Eleitor eleitor_novo) {
        listaEleitores.stream().filter((e) -> (eleitor_antigo == e)).forEachOrdered((e) -> {
           e = eleitor_novo; 
        });
    }
    
    public void deletarEleitor(Eleitor eleitor) {
        listaEleitores.remove(eleitor);
    }
    
    public void editarAdministrador(Administrador administrador_antigo, Administrador administrador_novo) {
        listaAdministradores.stream().filter((a) -> (administrador_antigo == a)).forEachOrdered((a) -> {
           a = administrador_novo; 
        });
    }
    
    public void deletarAdministrador(Administrador administrador) {
        listaAdministradores.remove(administrador);
    }
     
    public void cadastrarEleitor(String nome, String estado, String cpf, String titulo_eleitor) {
        try {
            if(cpf.toCharArray().length != 11 || titulo_eleitor.toCharArray().length != 12) {
                return;
            }
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
        } catch(Exception e) {
            System.out.println("Erro!");
        }    
    }
    
    public void cadastrarAdministrador(String nome, String senha) {
        try {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));

            Administrador adm = new Administrador(nome, senha);
            adm.setIdentificador(generatedString);
            listaAdministradores.add(adm);
            //mostrar na interface grafica o identificador do novo administrador cadastrado
        } catch(Exception e) {
            System.out.println("Erro!");
        }    
    }
    
    public void login(String identificador, String senha) {
        for(Administrador administrador : this.listaAdministradores) {
            if((administrador.getIdentificador() == null ? identificador == null : administrador.getIdentificador().equals(identificador)) && (administrador.getSenha() == null ? senha == null : administrador.getSenha().equals(senha))) {
                System.out.println("Logado com sucesso!");
                break;
            }
        }
    }
}
