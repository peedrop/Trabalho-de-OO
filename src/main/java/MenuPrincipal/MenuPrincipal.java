/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuPrincipal;

import java.awt.CardLayout;

/**
 *
 * @author pedro
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clMenuPrincipal = new javax.swing.JPanel();
        cardMenu = new javax.swing.JPanel();
        btnVotacao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cardErroVotacao = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cardDadosEleitor = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnValida = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        cardErroDados = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clMenuPrincipal.setLayout(new java.awt.CardLayout());

        btnVotacao.setText("Votação");
        btnVotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotacaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Eleições");

        jButton2.setText("Área Administrativa");

        javax.swing.GroupLayout cardMenuLayout = new javax.swing.GroupLayout(cardMenu);
        cardMenu.setLayout(cardMenuLayout);
        cardMenuLayout.setHorizontalGroup(
            cardMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(cardMenuLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(btnVotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        cardMenuLayout.setVerticalGroup(
            cardMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(162, 162, 162)
                .addComponent(btnVotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        clMenuPrincipal.add(cardMenu, "cardMenu");

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Votação ainda não foi iniciada.");

        jLabel3.setText("Eleições");

        javax.swing.GroupLayout cardErroVotacaoLayout = new javax.swing.GroupLayout(cardErroVotacao);
        cardErroVotacao.setLayout(cardErroVotacaoLayout);
        cardErroVotacaoLayout.setHorizontalGroup(
            cardErroVotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardErroVotacaoLayout.createSequentialGroup()
                .addGroup(cardErroVotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardErroVotacaoLayout.createSequentialGroup()
                        .addGroup(cardErroVotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardErroVotacaoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton3))
                            .addGroup(cardErroVotacaoLayout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(jLabel2)))
                        .addGap(0, 228, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardErroVotacaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        cardErroVotacaoLayout.setVerticalGroup(
            cardErroVotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardErroVotacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(220, 220, 220)
                .addComponent(jButton3)
                .addContainerGap())
        );

        clMenuPrincipal.add(cardErroVotacao, "cardErroVotacao");

        jLabel4.setText("CPF:");

        jLabel5.setText("Título de eleitor:");

        btnValida.setBackground(new java.awt.Color(0, 102, 0));
        btnValida.setText("Validar");
        btnValida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidaActionPerformed(evt);
            }
        });

        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout cardDadosEleitorLayout = new javax.swing.GroupLayout(cardDadosEleitor);
        cardDadosEleitor.setLayout(cardDadosEleitorLayout);
        cardDadosEleitorLayout.setHorizontalGroup(
            cardDadosEleitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardDadosEleitorLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(cardDadosEleitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardDadosEleitorLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnValida))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardDadosEleitorLayout.createSequentialGroup()
                        .addGroup(cardDadosEleitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addGroup(cardDadosEleitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField2))))
                .addGap(41, 41, 41))
        );
        cardDadosEleitorLayout.setVerticalGroup(
            cardDadosEleitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardDadosEleitorLayout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addGroup(cardDadosEleitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cardDadosEleitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(173, 173, 173)
                .addGroup(cardDadosEleitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValida)
                    .addComponent(jButton5))
                .addGap(65, 65, 65))
        );

        clMenuPrincipal.add(cardDadosEleitor, "cardDadosEleitor");

        jLabel6.setText("Seus dados são inválidos! Tente novamente");

        jButton6.setText("Voltar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Eleições");

        javax.swing.GroupLayout cardErroDadosLayout = new javax.swing.GroupLayout(cardErroDados);
        cardErroDados.setLayout(cardErroDadosLayout);
        cardErroDadosLayout.setHorizontalGroup(
            cardErroDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardErroDadosLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel6)
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(cardErroDadosLayout.createSequentialGroup()
                .addComponent(jButton6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardErroDadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );
        cardErroDadosLayout.setVerticalGroup(
            cardErroDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardErroDadosLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(208, 208, 208)
                .addComponent(jButton6)
                .addContainerGap())
        );

        clMenuPrincipal.add(cardErroDados, "cardErroDados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayout cl = (CardLayout) clMenuPrincipal.getLayout();
        cl.show(clMenuPrincipal, "cardMenu");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnValidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidaActionPerformed
        if( validaDadosEleitor() )
        {
            System.out.println("Chama a Votação!");
        }else
        {
            CardLayout cl = (CardLayout) clMenuPrincipal.getLayout();
            cl.show(clMenuPrincipal, "cardErroDados");
        }
    }//GEN-LAST:event_btnValidaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        CardLayout cl = (CardLayout) clMenuPrincipal.getLayout();
        cl.previous(clMenuPrincipal);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnVotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotacaoActionPerformed
        if( validaVotacao() )
        {
            CardLayout cl = (CardLayout) clMenuPrincipal.getLayout();
            cl.show(clMenuPrincipal, "cardDadosEleitor");
        }else{
            CardLayout cl = (CardLayout) clMenuPrincipal.getLayout();
            cl.show(clMenuPrincipal, "cardErroVotacao");
        }
    }//GEN-LAST:event_btnVotacaoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CardLayout cl = (CardLayout) clMenuPrincipal.getLayout();
        cl.show(clMenuPrincipal, "cardMenu");
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValida;
    private javax.swing.JButton btnVotacao;
    private javax.swing.JPanel cardDadosEleitor;
    private javax.swing.JPanel cardErroDados;
    private javax.swing.JPanel cardErroVotacao;
    private javax.swing.JPanel cardMenu;
    private javax.swing.JPanel clMenuPrincipal;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    private boolean validaDadosEleitor() {
        return true;
    }

    private boolean validaVotacao() {
        return true;
    }
}