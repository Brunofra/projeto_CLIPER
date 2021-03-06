/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.com.br.hibernate.modulo.treinamento;

import bac.com.br.hibernate.Dao.ItensDao;
import bac.com.br.hibernate.Dao.PeriodoDao;
import bac.com.br.hibernate.Dao.PgrDao;
import bac.com.br.hibernate.entidade.Itens;
import bac.com.br.hibernate.entidade.Pgr;
import bac.com.br.hibernate.entidade.Periodo;
import bac.com.br.hibernate.relatorios.Relatorio_execucao;
import bac.com.br.hibernate.relatorios.Relatorio_meta;
import bac.com.br.hibernate.relatorios.Relatorio_pgr;
import bac.com.br.hibernate.utils.Loggin;
import bac.com.br.hibernate.utils.Msg;
import bac.com.br.hibernate.utils.Utils;
import java.awt.Toolkit;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno
 */
public class pesquisar_pgr extends javax.swing.JDialog {

    private Tela_principal pai;
    List<Pgr> lista_pgr = new ArrayList<Pgr>();
    List<Itens> lista_itens = new ArrayList<Itens>();

    /**
     * Creates new form pesquisar_pgr
     */
    public pesquisar_pgr(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizar("");
        Utils.maximizar(this);
    }

    public pesquisar_pgr(Tela_principal parent, boolean modal) {
        super(parent, modal);
        this.pai = parent;
        initComponents();
        atualizar("");
        Utils.maximizar(this);
    }

    protected void atualizar(String s) {
        try {
            lista_pgr = new PgrDao().getlista(s);
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setNumRows(0);
            for (Pgr p : lista_pgr) {
                model.addRow(new Object[]{
                    p.getAno()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "erro ao atualizar tabela \n" + e.getMessage());
        }
    }

    protected void atualizaritens(String s) {
        try {
            int row = tabela.getSelectedRow();
            lista_itens = new ItensDao().itens(lista_pgr.get(row).getAno());
            DefaultTableModel model = (DefaultTableModel) tabelaitem.getModel();
            model.setNumRows(0);
            for (Itens t : lista_itens) {
                model.addRow(new Object[]{
                    t.getDescricao(),
                    t.getMesInicio(),
                    t.getMesFim()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "erro ao atualizar tabela \n" + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaitem = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txpesquisa = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("c:/treinamento/icone.png"));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        tabela.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ANO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaMousePressed(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.BorderLayout());

        tabelaitem.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tabelaitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRICAO", "INICIO DO PERIODO", "FIM DO PERIODO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaitem.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaitem);

        jPanel5.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel2.setText("ITENS DO CRONOGRAMA");
        jPanel5.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel5, java.awt.BorderLayout.WEST);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel7.setLayout(new java.awt.GridLayout(3, 0));

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/vcard_add.png"))); // NOI18N
        jButton7.setText("ADICIONAR ITEM");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7);

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/printer.png"))); // NOI18N
        jButton8.setText("IMPRIMIR PLANEJAMENTO");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8);

        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/printer.png"))); // NOI18N
        jButton9.setText("IMPRIMIR EXECU????O");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton9);

        jPanel6.add(jPanel7);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("PESQUISAR:");

        txpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txpesquisaKeyReleased(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/folder_explore.png"))); // NOI18N
        jButton5.setText("BUSCAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/atualizar.png"))); // NOI18N
        jButton6.setText("ATUALIZAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txpesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/vcard_add.png"))); // NOI18N
        jButton1.setText("INSERIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/vcard_edit.png"))); // NOI18N
        jButton2.setText("ALTERAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/vcard_delete.png"))); // NOI18N
        jButton3.setText("EXCLUIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jButton10.setText("jButton10");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bac/com/br/hibernate/imagens/cancel.png"))); // NOI18N
        jButton4.setText("SAIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Cadastrar_pgr(this, true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int row = tabela.getSelectedRow();
        if (row < 0) {
            Msg.alerta(this, "selecione um registro");
        } else {
            Adicionar_itens c = new Adicionar_itens(this, true);
            System.out.println("\n" + lista_pgr.get(row));
            c.seleciona(lista_pgr.get(row));
            c.setVisible(true);

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        atualizaritens("");
    }//GEN-LAST:event_tabelaKeyReleased

    private void tabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMousePressed

    }//GEN-LAST:event_tabelaMousePressed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        atualizaritens("");
    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            int row = tabela.getSelectedRow();
            if (row < 0) {
                Msg.alerta(this, "selecione um registro");
            } else {
                new Relatorio_pgr(lista_pgr.get(row).getId(),Utils.Sistema_operacional());
                System.out.println(lista_pgr.get(row).getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "erro ao passar id \n" + e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tabela.getSelectedRow();
        if (row < 0) {
            Msg.alerta(this, "selecione o registro selecionado");
        } else {
            Cadastrar_pgr f = new Cadastrar_pgr(this, true);
            f.preenchecampo(lista_pgr.get(row));
            f.setAlterar(true);
            f.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tabela.getSelectedRow();
        if (row < 0) {
            Msg.alerta(this, "selecione o registro desejado");
        } else {
            if (Msg.confirmar(this, "deseja realmente excluir esse registro!") == false) {
                return;
            } else {
                try {

                    new PgrDao().excluir(lista_pgr.get(row));
                    
                Loggin.arquivo_log("excluido cadastro de um pgr com o id"+lista_pgr.get(row));
                    atualizar("");
                    Msg.informacao(this, "registro excluido com sucesso");
                } catch (Exception e) {
                    if (e.getMessage().contains("Error while committing the transaction")) {
                        Msg.alerta(this, "Este registro n??o pode ser excluido\n"
                                + "ele esta vinculado ha outro modulo do sistema");
                    } else {
                        e.printStackTrace();
                        Msg.erro(this, "erro ao excluir cargo\n" + e.getMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       try {
            int row = tabela.getSelectedRow();
            if (row < 0) {
                Msg.alerta(this, "selecione um registro");
            } else {
                new Relatorio_execucao(lista_pgr.get(row).getId(),Utils.Sistema_operacional());
                System.out.println(lista_pgr.get(row).getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "erro ao passar id \n" + e.getMessage());
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        atualizar(txpesquisa.getText());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txpesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpesquisaKeyReleased
        atualizar(txpesquisa.getText());
    }//GEN-LAST:event_txpesquisaKeyReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            int row = tabela.getSelectedRow();
        if (row < 0) {
                Msg.alerta(this, "selecione um registro");
            } else {
            Utils u = new Utils();

            u.relatorio_estatistico(lista_pgr.get(row).getAno());
        }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "erro ao gerar analise critica"+e.getMessage());
        }
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(pesquisar_pgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pesquisar_pgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pesquisar_pgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pesquisar_pgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pesquisar_pgr dialog = new pesquisar_pgr(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaitem;
    private javax.swing.JTextField txpesquisa;
    // End of variables declaration//GEN-END:variables
}
