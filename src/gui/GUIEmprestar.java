/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOEmprestimo;
import dao.ObraDAO;
import java.sql.SQLException;
import modelo.Emprestimo;
import modelo.ObraVO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GUIEmprestar extends javax.swing.JFrame {

    /**
     * Creates new form Emprestar
     */
    public GUIEmprestar() throws SQLException {
        initComponents();
        ObraDAO dadosLivro = new ObraDAO();
        ArrayList<ObraVO> listaLivros = new ArrayList();
        listaLivros = dadosLivro.buscarObras();
        //criando um modelo para a JTable
        DefaultTableModel modelo = (DefaultTableModel) tabelaDados.getModel();
        for(ObraVO livro : listaLivros)
        {
            Object[] dados = {livro.getNome(), livro.getEditora(), livro.getEdicao(), 
                  livro.getAutor(), livro.getCategoria(), livro.getQuantidade(), livro.getCodigo()};
            modelo.addRow(dados);
        }
    }
    
    public boolean verificaCpf()
    {
        DAOEmprestimo dadosEmprestimo = new DAOEmprestimo();
        ArrayList<Emprestimo> listaEmprestimos = new ArrayList();
        try {
            listaEmprestimos = dadosEmprestimo.selecionarTodosRegistros();
        } catch (SQLException ex) {
            Logger.getLogger(GUIEmprestar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Emprestimo emprestimo : listaEmprestimos)
        {
            if(emprestimo.getCpf().equals(campocpf.getText()))
            {
                return true;
            }
        }
        return false;
    }
    public boolean Valida()
    {
        if(tabelaDados.getSelectedRow()!=-1)
        {
            return true;
        }
        return false;
    }
    
    public boolean Validacao()
    {
        if(campocpf.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo de CPF.", "Erro", 0);
            return false;
        }
        else if(campocpf.getText().length()!=11)
        {
            JOptionPane.showMessageDialog(null, "Preencha o campo de CPF corretamente.", "Erro", 0);
            return false;
        }
        else if(verificaCpf())
        {
            JOptionPane.showMessageDialog(null, "Devolva o livro antes de pegar outro emprestado.", "Erro", 0);
            return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    public void Decresce() throws SQLException, SQLException
    {
        int linha=tabelaDados.getSelectedRow();
        ObraVO livro = new ObraVO();
        livro.setNome(""+tabelaDados.getValueAt(linha, 0));
        livro.setEditora(""+tabelaDados.getValueAt(linha, 1));
        livro.setEdicao(""+tabelaDados.getValueAt(linha, 2));
        livro.setAutor(""+tabelaDados.getValueAt(linha, 3));
        livro.setCategoria(""+tabelaDados.getValueAt(linha, 4));
        livro.setQuantidade(Integer.parseInt(""+tabelaDados.getValueAt(linha, 5))-1);
        livro.setCodigo(Integer.parseInt(""+tabelaDados.getValueAt(linha, 6)));
        
        ObraDAO atualizar = new ObraDAO();
       if(atualizar.alteraLivro(livro))
        {
            dispose();
            try {
                new GUIEmprestar().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(GUIEmprestar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar registro");
            dispose();
            new GUIManutencaoObra().setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campocpf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emprestar");
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.white);

        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Editora", "Edição", "Autor", "Categoria", "Quantidade", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaDados);

        jLabel1.setText("CPF :");

        campocpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campocpfActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/voltar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/confirma.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Empréstimo de obra:");
        jLabel2.setToolTipText("Cadastro de Usuário");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleciona a obra, após digite seu cpf e confirme."));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campocpf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campocpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel3.getAccessibleContext().setAccessibleName("Seleciona a obra, após digite seu cpf e confirme");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campocpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campocpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campocpfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(Valida())
       {
            if(Validacao())
            {
                DAOEmprestimo insereDados = new DAOEmprestimo();
                int linha=tabelaDados.getSelectedRow();
                try {
                    if(insereDados.insereEmprestimo(campocpf.getText(),""+tabelaDados.getValueAt(linha, 6)))
                    {
                        JOptionPane.showMessageDialog(null, "Registro cadastrado com sucesso!");
                        campocpf.setText("");
                        Decresce();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar registro, tente novamente.");
                        campocpf.setText("");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GUIEmprestar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIEmprestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEmprestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEmprestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEmprestar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUIEmprestar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GUIEmprestar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campocpf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDados;
    // End of variables declaration//GEN-END:variables
}