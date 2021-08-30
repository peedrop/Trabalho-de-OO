/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.lang.reflect.Type;
import com.mycompany.candidato.Partido;
import com.mycompany.usuarios.Administrador;
import com.mycompany.usuarios.Eleitor;
import com.mycompany.candidato.Candidato;
import com.mycompany.tribunal.TribunalEleitoral;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pedro
 */
public class BancoDados {
        
    // Atributo estático definindo extensão do arquivo
    private static final String EXTENSAO  = ".json";
    
    // Atributo estático definindo caminho do arquivo
    private static final String CAMINHO = "src/main/jsons/";
    
    // Método estático auxiliar para retornar o caminho completo do arquivo
    public static String caminhoCompleto(String nomeArquivoJson) {
        return (CAMINHO + nomeArquivoJson + EXTENSAO);
    }

    // Função salvar todas listas set do programa
    public void salvarTodos(TribunalEleitoral tribunalEleitoral) {
        salvar(tribunalEleitoral.getListaPartidos(), "partidos");
        salvar(tribunalEleitoral.getListaAdministradores(), "administradores");
        
        //SALVANDO ELEITORES
        Set<Eleitor> eleitores = tribunalEleitoral.getListaEleitores();
        for(Eleitor e : eleitores) {
            e.setVotou(false);
        }
        salvar(eleitores, "eleitores");
        
        //SALVANDO CANDIDATOS
        Set<Candidato> candidatos = tribunalEleitoral.getListaCandidatos();
        for(Candidato c : candidatos) {
            c.setNumeroVotos(0);
        }
        salvar(candidatos, "candidatos");
    }
    // Fim função salvar todas
    
    // Função recuperar todas listas set do programa
    public void recuperarTodos(TribunalEleitoral tribunalEleitoral) {
        tribunalEleitoral.setListaPartidos(recuperar(Partido.class, "partidos"));
        tribunalEleitoral.setListaAdministradores(recuperar(Administrador.class, "administradores"));
        tribunalEleitoral.setListaCandidatos(recuperar(Candidato.class, "candidatos"));
        tribunalEleitoral.setListaEleitores(recuperar(Eleitor.class, "eleitores"));
    }
    // Fim função recuperar todas
    
    // Função para salvar uma lista Set em um arquivo Json
    public boolean salvar(Set<?> listaSet, String nomeArquivoJson) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(BancoDados.caminhoCompleto(nomeArquivoJson))) {
            gson.toJson(listaSet, writer);
            return true;
        } catch(IOException ex) {
            return false;
        }
    }
    // Fim função salvar
    
    // Função para recuperar uma lista Set em um arquivo Json
    public <T> Set<T> recuperar(Class<T> classe, String nomeArquivoJson) {
        try {
            FileReader arq = new FileReader(BancoDados.caminhoCompleto(nomeArquivoJson));
            try (BufferedReader lerArq = new BufferedReader(arq)) {
                Type typeOfT = TypeToken.getParameterized(Set.class, classe).getType();
                Set<T> listaSet = new Gson().fromJson(lerArq, typeOfT);
                if(listaSet == null) {
                    Set<T> listaVazia = new HashSet<>();
                    return listaVazia;
                }
                return listaSet;
            }
        } catch(IOException ex) {
            Set<T> listaVazia = new HashSet<>();
            return listaVazia;
        }
    }
    // Fim função recuperar
}
