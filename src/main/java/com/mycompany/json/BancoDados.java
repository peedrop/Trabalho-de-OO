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
import com.mycompany.tribunal.TribunalEleitoral;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static void main(String[] args) {
        // Inicio teste salvando
        TribunalEleitoral tribunal = new TribunalEleitoral();
        Partido p1 = new Partido("Partido 1", 1, "P1");
        Partido p2 = new Partido("Partido 2", 2, "P2");
        Partido p3 = new Partido("Partido 3", 3, "P3");
        Set<Partido> partidos = tribunal.getListaPartidos();
        partidos.add(p1);
        partidos.add(p2);
        partidos.add(p3);
        
        boolean salvou = BancoDados.salvar(partidos, "partidos");
        if(salvou)
            System.out.println("Salvo com sucesso!");
        else
            System.out.println("Erro ao salvar!");
        // Fim teste salvando
        
        
        // Inicio teste recuperando
        System.out.println("Recuperado");
        Set<Partido> partidos2 = BancoDados.recuperar(Partido.class, "partidos");
        for(Partido p : partidos2) {
            System.out.println(p.getNome());
        }
        // Fim teste recuperando
        
        
        // Inicio teste sincronizando
        System.out.println("Sincronizado");
        tribunal.setListaPartidos(partidos2);
        Set<Partido> partidos3 = tribunal.getListaPartidos();
        for(Partido p : partidos3) {
            System.out.println(p.getNome());
        }
        // Fim teste sincronizando
    }
    
    // Função salvar todas listas set do programa
    public static void salvarTodos(TribunalEleitoral tribunalEleitoral) {
        
    }
    // Fim função salvar todas
    
    // Função recuperar todas listas set do programa
    public static void recuperarTodos(TribunalEleitoral tribunalEleitoral) {
        
    }
    // Fim função recuperar todas
    
    // Função para salvar uma lista Set em um arquivo Json
    public static boolean salvar(Set<?> listaSet, String nomeArquivoJson) {
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
    public static <T> Set<T> recuperar(Class<T> classe, String nomeArquivoJson) {
        try {
            FileReader arq = new FileReader(BancoDados.caminhoCompleto(nomeArquivoJson));
            try (BufferedReader lerArq = new BufferedReader(arq)) {
                Type typeOfT = TypeToken.getParameterized(Set.class, classe).getType();
                Set<T> listaSet = new Gson().fromJson(lerArq, typeOfT);
                return listaSet;
            }
        } catch(IOException ex) {
            return null;
        }
    }
    // Fim função recuperar

}