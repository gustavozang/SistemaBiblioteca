/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOLivro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AutorVO;
import modelo.EditoraVO;
import modelo.Livro;
import org.exolab.castor.mapping.loader.J1CollectionHandlers;
import persistencia.ConexaoBanco;
import servicos.LivroServicos;
import servicos.ServicosFactory;

public class GUIManutencaoLivro extends javax.swing.JInternalFrame {

    /* Criando um modelo de tabela padrão 
     com o nome das colunas */
    DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Código", "Nome", "Editora", "Edicao", "Autor", "Categoria", "Quantidade"});

    /**
     * Creates new form GUIManutencaoLivro
     */
    public GUIManutencaoLivro() throws SQLException {
        initComponents();
        this.populaJComboBoxEditora();
        this.populaJComboBoxAutor();
        /* Chamando o método preencherTabela 
         no construtor */
        preencherTabela();
    }
    public void populaJComboBoxEditora() throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            /**
            Montando o sql
            **/
            sql = "select * from editora ORDER BY nome";

            /** Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs **/
            ResultSet rs = stat.executeQuery(sql);

            /** Criando ArrayList para armazenar 
             objetos do tipo produto **/
            ArrayList<EditoraVO> prod = new ArrayList<>();

            /** Enquanto houver uma próxima linha no 
             banco de dados o while roda **/
            while (rs.next()) {
                /**
                 Criando um novo obj. EditoraVO
                 * */
                EditoraVO p = new EditoraVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO **/
                jComboBoxEditora.addItem(rs.getString("nome"));
                              

                /** 
                 Inserindo o objeto pVO no ArrayList 
                 **/
                prod.add(p);
            }
            //Retornando o ArrayList com todos objetos
            //fecha while

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar editora! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
    public void populaJComboBoxAutor() throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            /**
            Montando o sql
            **/
            sql = "select * from autor ORDER BY nome";

            /** Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs **/
            ResultSet rs = stat.executeQuery(sql);

            /** Criando ArrayList para armazenar 
             objetos do tipo produto **/
            ArrayList<AutorVO> prod = new ArrayList<>();

            /** Enquanto houver uma próxima linha no 
             banco de dados o while roda **/
            while (rs.next()) {
                /**
                 Criando um novo obj. AutorVO
                 * */
                AutorVO p = new AutorVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO **/
                jComboBoxAutor.addItem(rs.getString("nome"));
                              

                /** 
                 Inserindo o objeto pVO no ArrayList 
                 **/
                prod.add(p);
            }
            //Retornando o ArrayList com todos objetos
            //fecha while

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Autor! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
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

        jFAlterar = new javax.swing.JFrame();
        jbAtualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtEdicao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtCategoria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jtQuantidade = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxEditora = new javax.swing.JComboBox<>();
        jComboBoxAutor = new javax.swing.JComboBox<>();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableLivro = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jbPreencher = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jDeletar = new javax.swing.JButton();
        jAlterar = new javax.swing.JButton();

        jFAlterar.setTitle("Atualizar");
        jFAlterar.setMinimumSize(new java.awt.Dimension(550, 450));

        jbAtualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preencha os campos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Edição:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 111, -1, -1));

        jLabel2.setText("Editora:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 80, -1, -1));

        jLabel4.setText("Autor:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 142, -1, 24));

        jtEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEdicaoActionPerformed(evt);
            }
        });
        jPanel1.add(jtEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 111, 208, -1));

        jLabel5.setText("Categoria:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 177, -1, 24));

        jtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(jtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 208, -1));

        jLabel7.setText("Quantidade:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 212, -1, 24));

        jLabel10.setText("Nome:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 49, -1, -1));

        jtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(jtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 49, 208, -1));

        jtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtQuantidadeActionPerformed(evt);
            }
        });
        jPanel1.add(jtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 40, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Alteração livros");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, -1));

        jPanel1.add(jComboBoxEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 210, -1));

        jPanel1.add(jComboBoxAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 210, -1));

        javax.swing.GroupLayout jFAlterarLayout = new javax.swing.GroupLayout(jFAlterar.getContentPane());
        jFAlterar.getContentPane().setLayout(jFAlterarLayout);
        jFAlterarLayout.setHorizontalGroup(
            jFAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFAlterarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFAlterarLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jFAlterarLayout.setVerticalGroup(
            jFAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Manutenção Livro");
        setMinimumSize(new java.awt.Dimension(550, 400));
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jLayeredPane1.setBackground(new java.awt.Color(127, 131, 249));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtableLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Editora", "Edição", "Autor", "Categoria", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtableLivro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtableLivro);

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbPreencher.setText("Preencher");
        jbPreencher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPreencherActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jDeletar.setText("Deletar");
        jDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeletarActionPerformed(evt);
            }
        });

        jAlterar.setText("Alterar");
        jAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jbPreencher, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jbLimpar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jDeletar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jAlterar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbPreencher, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Manutenção Obra");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void preencherTabela() {
        try {

            //Buscando objeto LivroServicos     
            LivroServicos ps = ServicosFactory.getLivroServicos();

            /* Criando um ArrayList<LivroVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<Livro> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em livros
            prod = ps.buscarLivros();

            for (int i = 0; i < prod.size(); i++) {
                dtm.addRow(new String[]{
                    String.valueOf(prod.get(i).getCodigo()),
                    String.valueOf(prod.get(i).getNome()),
                    String.valueOf(prod.get(i).getEditora()),
                    String.valueOf(prod.get(i).getEdicao()),
                    String.valueOf(prod.get(i).getAutor()),
                    String.valueOf(prod.get(i).getCategoria()),
                    String.valueOf(prod.get(i).getQuantidade()),
                });
            }//fecha for
            
            /* Adicionando o modelo de tabela 
             com os dados na tabela livro */
            jtableLivro.setModel(dtm);
            
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//fecha catch
    }//fecha preencherTabela

    private void limparTabela() {
        /* Para limpar a tabela temos que setar o número de
         linhas para zero no default table model */
        dtm.setNumRows(0);
    }//fecha limparTabela

    private void excluir() {

        try {
            //Buscando objeto LivroServicos     
            LivroServicos ps = ServicosFactory.getLivroServicos();

            /* Criando um ArrayList<LivroVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<Livro> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em Livros
            prod = ps.buscarLivros();

            int i = jtableLivro.getSelectedRow();

            DAOLivro p = new DAOLivro();

            p.deletar(prod.get(i));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//fecha catch

    }

    private void alterar() {
        try {
            //Buscando objeto LivroServicos     
            LivroServicos ps = ServicosFactory.getLivroServicos();

            /* Criando um ArrayList<LivroVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<Livro> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em Livros
            prod = ps.buscarLivros();

            int i = jtableLivro.getSelectedRow();

            DAOLivro p = new DAOLivro();
            /*jtNome.setText(prod.get(i).getNome());
            jtValor.setText(String.valueOf(prod.get(i).getEditora()));
            jtValor.setText(String.valueOf(prod.get(i).getEdicao()))
            jtValor.setText(String.valueOf(prod.get(i).getAutor()))
            jtValor.setText(String.valueOf(prod.get(i).getCategoria()))
            jtValor.setText(String.valueOf(prod.get(i).getQuantidade()))*/
                
            
            
            
            

            prod.get(i).setNome(jtNome.getText());
            prod.get(i).setEditora((String) jComboBoxEditora.getSelectedItem());
            prod.get(i).setEdicao(jtEdicao.getText());
            prod.get(i).setAutor((String) jComboBoxAutor.getSelectedItem());
            prod.get(i).setCategoria(jtCategoria.getText());
            prod.get(i).setQuantidade(Integer.parseInt(jtQuantidade.getText()));
                      
            
            

            p.alterar(prod.get(i));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//fecha catch
    }
    
    private void informacoes(){
         try {
            //Buscando objeto LivroServicos     
            LivroServicos ps = ServicosFactory.getLivroServicos();

            /* Criando um ArrayList<LivroVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<Livro> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em Livros
            prod = ps.buscarLivros();

            int i = jtableLivro.getSelectedRow();
            
            jtNome.setText(prod.get(i).getNome());
            jComboBoxEditora.setSelectedItem(String.valueOf(prod.get(i).getEditora()));
            jtEdicao.setText(String.valueOf(prod.get(i).getEdicao()));
            jComboBoxAutor.setSelectedItem(String.valueOf(prod.get(i).getAutor()));
            jtCategoria.setText(String.valueOf(prod.get(i).getCategoria()));
            jtQuantidade.setText(String.valueOf(prod.get(i).getQuantidade()));
                     
            
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//f
    }

    private void limparAlterar() {
        jtNome.setText(null);
        jComboBoxEditora.setSelectedItem(null);
        jtEdicao.setText(null);
        jComboBoxAutor.setSelectedItem(null);
        jtCategoria.setText(null);
        jtQuantidade.setText(null);
    }

    private void jbPreencherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPreencherActionPerformed
        limparTabela();
        preencherTabela();
    }//GEN-LAST:event_jbPreencherActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limparTabela();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeletarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir",title,JOptionPane.YES_NO_OPTION);
        if(resposta ==JOptionPane.YES_OPTION){;
        excluir();
        jbPreencherActionPerformed(evt);
        }else if (resposta == JOptionPane.NO_OPTION)
              
        return;
    }//GEN-LAST:event_jDeletarActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        alterar();
        jbPreencherActionPerformed(evt);
        jFAlterar.setVisible(false);
    }//GEN-LAST:event_jbAtualizarActionPerformed

    
    
    private void jAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarActionPerformed
        informacoes();
        jFAlterar.setVisible(true);
    }//GEN-LAST:event_jAlterarActionPerformed

    private void jtEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEdicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEdicaoActionPerformed

    private void jtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCategoriaActionPerformed

    private void jtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNomeActionPerformed

    private void jtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtQuantidadeActionPerformed

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
            java.util.logging.Logger.getLogger(GUIManutencaoLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIManutencaoLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIManutencaoLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIManutencaoLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUIManutencaoLivro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GUIManutencaoLivro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlterar;
    private javax.swing.JComboBox<String> jComboBoxAutor;
    private javax.swing.JComboBox<String> jComboBoxEditora;
    private javax.swing.JButton jDeletar;
    private javax.swing.JFrame jFAlterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbPreencher;
    private javax.swing.JTextField jtCategoria;
    private javax.swing.JTextField jtEdicao;
    private javax.swing.JTextField jtNome;
    private javax.swing.JFormattedTextField jtQuantidade;
    private javax.swing.JTable jtableLivro;
    // End of variables declaration//GEN-END:variables
}
