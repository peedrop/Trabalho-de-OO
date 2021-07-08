/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tribunal;
import com.mycompany.candidato.Candidato;
import com.mycompany.candidato.Partido;
import com.mycompany.candidato.Presidente;
import com.mycompany.usuarios.Administrador;
import com.mycompany.usuarios.Eleitor;
import java.util.*;

/**
 *
 * @author gabriel
 */
public class TribunalEleitoral {
    Map<String, Candidato> listaCandidatos = new HashMap<>();
    Set<Eleitor> listaEleitores = new HashSet<>();
    Set<Partido> listaPartidos = new HashSet<>();
    Set<Administrador> listaAdministradores = new HashSet<>();
    
    public void menuPrincipal() {
        //abre interface gráfica com menu principal para cadastro
    }
    
    public void cadastrarCandidato(String cargo, int numero, String nome, Partido partido, String estado, String suplente, String estado_suplente, Partido partido_suplente) {
        if(null != cargo) switch (cargo) {
            case "Presidente":
                listaCandidatos.put("Presidente", new Presidente(new Candidato(suplente, estado_suplente, partido_suplente), nome, estado, partido));
                break;
            case "Senador":
                break;
            case "Deputado Federal":
                break;
            case "Deputado Estadual":
                break;
            default:
                break;
        }
        
    }
    
    public void cadastrarPartido(String nome, String sigla, int numero) {
        //cadastra Partido de acordo com seus dados informados
    }    
    
    public void cadastrarEleitor(String nome, String cpf, String titulo_eleitor) {
        //cadastra Eleitor de acordo com seus dados informados
    }
}
