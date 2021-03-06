/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tribunal;
import com.mycompany.politicos.Candidato;
import com.mycompany.politicos.DeputadoEstadual;
import com.mycompany.politicos.DeputadoFederal;
import com.mycompany.politicos.Partido;
import com.mycompany.politicos.Presidente;
import com.mycompany.politicos.Senador;
import com.mycompany.usuarios.Administrador;
import com.mycompany.usuarios.Eleitor;
import java.nio.charset.Charset;
import java.util.*;

/*
    Gabriel Arantes Resende Pereira - 202065126A
    Gabriel do Carmo Silva - 202065030A
    Pedro Leopoldo Dal-Col Vianna - 202065518B
    Pedro Paulo Silva Filogônio - 202065215A
 */
public class TribunalEleitoral {
    private Set<Candidato> listaCandidatos = new HashSet<>();
    private Set<Eleitor> listaEleitores = new HashSet<>();
    private Set<Partido> listaPartidos = new HashSet<>();
    private Set<Administrador> listaAdministradores = new HashSet<>();
    private String id_teste = "admin";
    private String senha_teste = "senha";

    public Set<Candidato> getListaCandidatos() {
        return this.listaCandidatos;
    }
    
    public Set<Eleitor> getListaEleitores() {
        return this.listaEleitores;
    }

    public Set<Partido> getListaPartidos() {
        return this.listaPartidos;
    }
    
    public void setListaPartidos(Set<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public void setListaCandidatos(Set<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }
    
    public void setListaAdministradores(Set<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public void setListaEleitores(Set<Eleitor> listaEleitores) {
        this.listaEleitores = listaEleitores;
    }
   
    public Set<Administrador> getListaAdministradores() {
        return this.listaAdministradores;
    }
    
    public String cadastrarCandidato(String cargo, int numero, String nome, Partido partido, String estado, String suplente, String estado_suplente, Partido partido_suplente) {
        try {
            if(listaPartidos.contains(partido) && listaPartidos.contains(partido_suplente)) {
                if(null != cargo) switch (cargo) {
                    case "Presidente":
                        boolean flag_presidente = false;
                        Presidente presidente = new Presidente(new Candidato(suplente, estado_suplente, partido_suplente), nome, estado, partido);
                        for(Candidato c : listaCandidatos) {
                            if("Presidente".equals(c.cargo)) {
                                if(c.getPartido().getSigla().equals(presidente.getPartido().getSigla())) {
                                    flag_presidente = true; //existe um candidato a presidente com esse partido
                                    return "O candidato já existe.";
                                }
                            }
                        }
                        if(!flag_presidente) {
                            listaCandidatos.add(presidente);
                            return "O candidato foi adicionado com sucesso.";
                        }    
                        break;
                    case "Senador":
                        if(Integer.parseInt(Integer.toString(numero).substring(0, 2)) != partido.getNumero()) {
                            return "Os dois primeiros dígitos não estão de acordo com o partido.";
                        }
                        else if(numero < 100 || numero > 999) {
                            return "O senador deve ter três dígitos.";
                        }
                        else {
                            boolean flag_senador = false;
                            Senador senador = new Senador(nome, estado, partido, new Candidato(suplente, estado_suplente, partido_suplente), numero);
                            for(Candidato c : listaCandidatos) {
                                if(c instanceof Senador) {
                                    if(c.getNumero_cand() == senador.getNumero_cand()) {
                                        flag_senador = true;
                                        return "O candidato já existe.";
                                    }
                                }
                            }
                            if(!flag_senador) {
                                listaCandidatos.add(senador);
                                return "O candidato foi adicionado com sucesso.";
                            }    
                        }
                        break;
                    case "Deputado Federal":
                        if(Integer.parseInt(Integer.toString(numero).substring(0, 2)) != partido.getNumero()) {
                            return "Os dois primeiros dígitos não estão de acordo com o partido.";
                        }
                        else if(numero < 1000 || numero > 9999) {
                            return "O deputado federal deve ter quatro dígitos.";
                        }
                        else {
                            boolean flag_depfed = false;
                            DeputadoFederal deputadoFederal = new DeputadoFederal(nome, estado, partido, new Candidato(suplente, estado_suplente, partido_suplente), numero);
                            for(Candidato c : listaCandidatos) {
                                if(c instanceof DeputadoFederal) {
                                    if(c.getNumero_cand() == deputadoFederal.getNumero_cand()) {
                                        flag_depfed = true;
                                        return "O deputado federal já existe.";
                                    }
                                }
                            }
                            if(!flag_depfed) {
                                listaCandidatos.add(deputadoFederal);
                                return "O candidato foi adicionado com sucesso.";
                            }    
                        }
                        break;
                    case "Deputado Estadual":
                        if(Integer.parseInt(Integer.toString(numero).substring(0, 2)) != partido.getNumero()) {
                            return "Os dois primeiros dígitos não estão de acordo com o partido.";
                        }
                        else if(numero < 10000 || numero > 99999) {
                            return "O deputado estadual deve ter cinco dígitos.";
                        }
                        else {
                            boolean flag_depest = false;
                            DeputadoEstadual deputadoEstadual = new DeputadoEstadual(nome, estado, partido, new Candidato(suplente, estado_suplente, partido_suplente), numero);
                            for(Candidato c : listaCandidatos) {
                                if(c instanceof DeputadoEstadual) {
                                    if(c.getNumero_cand() == deputadoEstadual.getNumero_cand()) {
                                        flag_depest = true;
                                        return "O deputado estadual já existe.";
                                    }
                                }
                            }
                            if(!flag_depest) {
                                listaCandidatos.add(deputadoEstadual);
                                return "O candidato foi adicionado com sucesso.";
                            }   
                        }
                        break;
                    default:
                        break;
                }
            }
            else {
                return "O partido do candidato não está cadastrado.";
            }
            return "Erro desconhecido";
        } catch(NumberFormatException e) {
            return "Erro!";
        }    
    }
    
    public boolean cadastrarPartido(Partido partido) {
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
                return true;
            }
            return false;
        } catch(Exception e) {    
            return false;
        }
    }

    public boolean editarPartido(Partido partido_antigo, Partido partido_novo) {
        Partido partido_removido = null;
        for(Partido p : this.listaPartidos) {
            if(p == partido_antigo) {
                partido_removido = p;
                break;
            }
        }
        if(this.verificarCandidatosPartido(partido_antigo)){
            return false;
        }
        this.listaPartidos.remove(partido_removido);
        return this.cadastrarPartido(partido_novo);
    }
    
    public boolean verificarCandidatosPartido(Partido partido_antigo) {
        for(Candidato c : this.listaCandidatos) {
            if(c.getPartido().getNumero() == partido_antigo.getNumero()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean deletarPartido(Partido partido) {
        if(!verificarCandidatosPartido(partido)){
            listaPartidos.remove(partido);
            return true;
        }
        return false;
    }
    
    public String editarCandidato(Candidato candidato_antigo, String cargo, int numero, String nome, Partido partido, String estado, String suplente, String estado_suplente, Partido partido_suplente) {
        Candidato candidato_removido = null;
        for(Candidato c : this.listaCandidatos) {
            if(c == candidato_antigo) {
                candidato_removido = c;
                break;
            }
        }
        this.deletarCandidato(candidato_removido);
        return this.cadastrarCandidato(cargo, numero, nome, partido, estado, suplente, estado_suplente, partido_suplente);
    }
    
    public void deletarCandidato(Candidato candidato) {
        listaCandidatos.remove(candidato);
    }
    
    public String editarEleitor(Eleitor eleitor_antigo, Eleitor eleitor_novo) {
        Eleitor eleitor_removido = null;
        for(Eleitor e : this.listaEleitores) {
            if(e == eleitor_antigo) {
                eleitor_removido = e;
                break;
            }
        }
        this.listaEleitores.remove(eleitor_removido);
        return this.cadastrarEleitor(eleitor_novo.getNome(), eleitor_novo.getEstado(), eleitor_novo.getCpf(), eleitor_novo.getTitulo_eleitor(), eleitor_novo.getVotou());
    }
    
    public void deletarEleitor(Eleitor eleitor) {
        listaEleitores.remove(eleitor);
    }
    
    public void editarAdministrador(Administrador administrador_antigo, Administrador administrador_novo) {
        Administrador administrador_removido = null;
        for(Administrador a : this.listaAdministradores) {
            if(a == administrador_antigo) {
                administrador_removido = a;
                break;
            }
        }
        administrador_novo.setIdentificador(administrador_antigo.getIdentificador());
        this.listaAdministradores.remove(administrador_removido);
        this.listaAdministradores.add(administrador_novo);
    }
    
    public void deletarAdministrador(Administrador administrador) {
        listaAdministradores.remove(administrador);
    }
     
    public String cadastrarEleitor(String nome, String estado, String cpf, String titulo_eleitor, boolean votou) {
        try {
            System.out.println(cpf.toCharArray().length);
            System.out.println(titulo_eleitor.toCharArray().length);
            if(cpf.toCharArray().length != 11 || titulo_eleitor.toCharArray().length != 12) {
                return "Número de dígitos de um dos documentos inválido!";
            }
            boolean flag = false;
            for(Eleitor e : listaEleitores) {
                if((e.getCpf() == null ? cpf == null : e.getCpf().equals(cpf)) || (e.getTitulo_eleitor() == null ? titulo_eleitor == null : e.getTitulo_eleitor().equals(titulo_eleitor))) {
                    flag = true;
                    return "O eleitor já está cadastrado.";
                }
            }
            if(!flag) {
                listaEleitores.add(new Eleitor(nome, estado, cpf, titulo_eleitor, votou));
                return "Eleitor cadastrado com sucesso.";
            }
            return "Erro desconhecido";
        } catch(Exception e) {
            return "Erro!";
        }    
    }
    
    public String cadastrarAdministrador(String nome, String senha) {
        try {
            String charset = "abcdefghijklmnopqrstuvwxyzABCDEIFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*_+";
            String generatedString = "";
            Random aleatorio = new Random();
            for(int i = 0; i < 7; i++) {
                generatedString += charset.charAt(aleatorio.nextInt(charset.length()));
            }

            Administrador adm = new Administrador(nome, senha);
            adm.setIdentificador(generatedString);
            listaAdministradores.add(adm);
            return generatedString;
            //mostrar na interface grafica o identificador do novo administrador cadastrado
        } catch(Exception e) {
            System.out.println("Erro!");
            return "";
        }    
    }
    
    public boolean login(String identificador, String senha) {
        if(this.listaAdministradores.isEmpty()) {
            if((identificador == null ? this.id_teste == null : identificador.equals(this.id_teste)) && (senha == null ? this.senha_teste == null : senha.equals(this.senha_teste))) {
                return true;
            }
            return false;
        }
        for(Administrador administrador : this.listaAdministradores) {
            if((administrador.getIdentificador() == null ? identificador == null : administrador.getIdentificador().equals(identificador)) && (administrador.getSenha() == null ? senha == null : administrador.getSenha().equals(senha))) {
                System.out.println("Logado com sucesso!");
                return true;
            }
        }
        return false;
    }
}
