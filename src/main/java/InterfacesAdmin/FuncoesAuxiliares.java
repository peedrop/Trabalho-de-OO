/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesAdmin;

import com.mycompany.candidato.Candidato;
import com.mycompany.candidato.Partido;
import com.mycompany.tribunal.TribunalEleitoral;
import com.mycompany.usuarios.Administrador;
import com.mycompany.usuarios.Eleitor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author pedro
 */
public class FuncoesAuxiliares {
    
    protected static void iniciaModeloListaPartidos(DefaultListModel modeloLista, TribunalEleitoral tribunalEleitoral, JList lista){
        //Inicializando os components
        for (Partido partido : tribunalEleitoral.getListaPartidos()) {
            modeloLista.addElement(partido.getSigla());
        }
        lista.setModel(modeloLista);
        lista.repaint();
    }
    
    protected static void iniciaModeloListaEleitores(DefaultListModel modeloLista, TribunalEleitoral tribunalEleitoral, JList lista){
        //Inicializando os components
        for (Eleitor eleitor : tribunalEleitoral.getListaEleitores()) {
            modeloLista.addElement(eleitor.getNome() + " - " + eleitor.getTitulo_eleitor());
        }
        lista.setModel(modeloLista);
        lista.repaint();
    }
    
    protected static void iniciaModeloListaAdm(DefaultListModel modeloLista, TribunalEleitoral tribunalEleitoral, JList lista){
        //Inicializando os components
        if(tribunalEleitoral.getListaAdministradores().isEmpty()) {
            modeloLista.addElement("admin (Crie um novo perfil)");
        }
        else {
            for (Administrador adm : tribunalEleitoral.getListaAdministradores()) {
                modeloLista.addElement(adm.getNome() + " - " + adm.getIdentificador());
            }
        }
        lista.setModel(modeloLista);
        lista.repaint();
    }
    
    protected static void iniciaModeloListaCandidatos(DefaultListModel modeloLista, TribunalEleitoral tribunalEleitoral, JList lista){
        //Inicializando os components
        for(Candidato candidato : tribunalEleitoral.getListaCandidatos()) {
            modeloLista.addElement(candidato.getNome() + " - " + candidato.getNumero_cand());
        }
        lista.setModel(modeloLista);
        lista.repaint();
    }
}
