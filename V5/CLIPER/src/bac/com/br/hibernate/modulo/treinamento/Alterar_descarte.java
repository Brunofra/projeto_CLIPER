/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.com.br.hibernate.modulo.treinamento;

import bac.com.br.hibernate.Dao.PastaDao;
import bac.com.br.hibernate.entidade.Pasta;
import bac.com.br.hibernate.utils.Loggin;
import bac.com.br.hibernate.utils.Msg;
import bac.com.br.hibernate.utils.TextDocument;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Alterar_descarte extends javax.swing.JDialog {
    private carregar_pastas pai;
    Pasta pasta;
    List<Pasta> lista_pasta = new ArrayList<Pasta>();
    List<Date> descarte = new ArrayList<Date>();
    /**
     * Creates new form Criar_pasta
     */
    public Alterar_descarte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pasta = new Pasta();
        iniciar();
    }
    public Alterar_descarte(carregar_pastas parent, boolean modal) {
        super(parent, modal);
        this.pai = parent;
        initComponents();
        pasta = new Pasta();
        iniciar();
    }
    private void iniciar(){
        txlocal.setDocument(new TextDocument(50));
    }
    private void verifica() {
        if (txlocal.getText().equals("")) {
            Msg.alerta(this, "preencha o campo para prosseguir");
        } else {
            salvar();
            dispose();
        }
    }
    private void salvar(){
        pai.pasta.setDescarte(txlocal.getText());
        Loggin.arquivo_log("pasta descartada com a localização"+txlocal.getText());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txlocal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("c:/treinamento/icone.png"));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        txlocal.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jPanel1.add(txlocal);

        jPanel4.add(jPanel1);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/tag_blue_add.png"))); // NOI18N
        jButton1.setText("LOCAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel4.add(jPanel2);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel1.setText("DIGITE O LOCAL DE DESCARTE DA PASTA:");
        jPanel3.add(jLabel1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        setSize(new java.awt.Dimension(454, 95));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      verifica();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Alterar_descarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alterar_descarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alterar_descarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alterar_descarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Alterar_descarte dialog = new Alterar_descarte(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txlocal;
    // End of variables declaration//GEN-END:variables
}
