/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.principal;

import com.mycompany.candidato.Candidato;
import com.mycompany.candidato.Partido;
import com.mycompany.candidato.Presidente;
import com.mycompany.usuarios.Administrador;
import com.mycompany.json.BancoDados;
import InterfacesAdmin.AreaAdmin;
import MenuPrincipal.MenuPrincipal;
import com.mycompany.tribunal.TribunalEleitoral;
import com.mycompany.tribunal.UrnaEletronica;
import java.util.Set;

/**
 *
 * @author gabriel
 */
public class Principal {
    public static void main(String[] args) {
//        MenuPrincipal menuPrincipal = new MenuPrincipal();
//        menuPrincipal.setVisible(true);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
}
