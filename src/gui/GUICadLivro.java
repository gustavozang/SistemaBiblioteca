/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import modelo.Livro;
import modelo.AutorVO;
import modelo.EditoraVO;
import modelo.CategoriaVO;
import dao.DAOLivro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.DepartamentoVO;
import persistencia.ConexaoBanco;
import servicos.AutorServicos;
import servicos.ServicosFactory;

/**
 *
 * @author Gustavo
 */
public class GUICadLivro extends javax.swing.JFrame {

    /**
     * Creates new form LivroGUI
     */
    public GUICadLivro() throws SQLException {
        initComponents();
        this.populaJComboBoxEditora();
        this.populaJComboBoxAutor();
        this.populaJComboBoxCategoria();
        setBounds (200, 100, 550, 550);
    }
    
    public void Update() throws SQLException {  
    
     Connection con = ConexaoBanco.getConexao();
        PreparedStatement p = con.prepareStatement("reload livro set nome=?,editora=?,edicao=?,autor=?,categoria=?,quantidade=? where codigo=?");
        Livro livro = new Livro();
        
        p.setString(1, livro.getNome());
        p.setString(2, livro.getEditora());
        p.setString(3, livro.getEdicao());
        p.setString(4, livro.getAutor());
        p.setString(5, livro.getCategoria());
        p.setInt(6, livro.getQuantidade());
        p.setInt(7, livro.getCodigo());
        p.execute();
        p.close();
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
    
    public void populaJComboBoxCategoria() throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            /**
            Montando o sql
            **/
            sql = "select * from categoria ORDER BY nome";

            /** Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs **/
            ResultSet rs = stat.executeQuery(sql);

            /** Criando ArrayList para armazenar 
             objetos do tipo produto **/
            ArrayList<CategoriaVO> prod = new ArrayList<>();

            /** Enquanto houver uma próxima linha no 
             banco de dados o while roda **/
            
            while (rs.next()) {
                /**
                 Criando um novo obj. CategoriaVO
                 * */
                CategoriaVO p = new CategoriaVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO **/
                jComboBoxCategoria.addItem(rs.getString("nome"));
                              

                /** 
                 Inserindo o objeto pVO no ArrayList 
                 **/
                prod.add(p);
            }
            //Retornando o ArrayList com todos objetos
            //fecha while

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar categoria! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
        public ArrayList<AutorVO> buscarAutores() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from autor";

            /**
             Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs 
             **/
            ResultSet rs = stat.executeQuery(sql);

            /**
             Criando ArrayList para armazenar 
             objetos do tipo produto 
             **/
            ArrayList<AutorVO> prod = new ArrayList<>();

            /**
             Enquanto houver uma próxima linha no 
             banco de dados o while roda 
             **/
            jComboBoxAutor.removeAllItems();
            while (rs.next()) {
                //Criando um novo obj. AutorVO
                AutorVO p = new AutorVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO 
                 **/
               
                p.setNome(rs.getString("nome"));
                
                                             

                /** 
                 Inserindo o objeto pVO no ArrayList 
                **/
                prod.add(p);
            }//fecha while

            /**
             Retornando o ArrayList com todos objetos
             * */
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar autor! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        TextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        TextField3 = new javax.swing.JTextField();
        TextField6 = new javax.swing.JTextField();
        jComboBoxEditora = new javax.swing.JComboBox<>();
        jComboBoxAutor = new javax.swing.JComboBox<>();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jCadastroEditora = new javax.swing.JToggleButton();
        jCadastroAutor = new javax.swing.JToggleButton();
        jCadastroCategoria = new javax.swing.JToggleButton();
        Atualizar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de Livros");
        jLabel1.setToolTipText("Cadastro de Usuário");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar livros"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        jPanel2.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Editora"));
        jPanel3.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Edição"));
        jPanel4.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Autor"));
        jPanel5.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        fechar.setText("Sair");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));
        jPanel6.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade"));
        jPanel7.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jCadastroEditora.setText("Cadastrar");
        jCadastroEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastroEditoraActionPerformed(evt);
            }
        });

        jCadastroAutor.setText("Cadastrar");
        jCadastroAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastroAutorActionPerformed(evt);
            }
        });

        jCadastroCategoria.setText("Cadastrar");

        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(TextField3)
                                    .addComponent(TextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxEditora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCadastroEditora)
                                    .addComponent(jCadastroAutor)
                                    .addComponent(jCadastroCategoria)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Atualizar)
                                .addGap(14, 14, 14)
                                .addComponent(fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCadastroEditora)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCadastroAutor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCadastroCategoria)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(fechar)
                    .addComponent(Atualizar))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(496, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
       this.fechar();
    }//GEN-LAST:event_fecharActionPerformed
    private void fechar(){
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Fechar?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){
            this.dispose();
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TextField1.setText("");
        jComboBoxEditora.setSelectedItem("");
        TextField3.setText("");
        jComboBoxAutor.setSelectedItem("");
        jComboBoxCategoria.setSelectedItem("");
        TextField6.setText("");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Livro livro = new Livro();
livro.setNome(TextField1.getText());
livro.setEditora((String) jComboBoxEditora.getSelectedItem());
livro.setEdicao(TextField3.getText());
livro.setAutor((String) jComboBoxAutor.getSelectedItem());
livro.setCategoria((String) jComboBoxCategoria.getSelectedItem());
livro.setQuantidade(Integer.parseInt(TextField6.getText()));


// fazendo a validação dos dados
if ((TextField1.getText().isEmpty()) ||  (TextField3.getText().isEmpty()) || (TextField6.getText().isEmpty())) {
   JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
}
else {

    // instanciando a classe DAOLivro do pacote dao e criando seu objeto dao
     DAOLivro dao = new DAOLivro();
    try {
        dao.cadastrarLivro(livro);
    } catch (SQLException ex) {
        Logger.getLogger(GUICadLivro.class.getName()).log(Level.SEVERE, null, ex);
    }
     JOptionPane.showMessageDialog(null, "Livro "+TextField1.getText()+" inserido com sucesso! ");
}


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCadastroEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastroEditoraActionPerformed
               
        GUICadEditora frameGUICadEditora = null;
        try {
            this.populaJComboBoxEditora();
        } catch (SQLException ex) {
            Logger.getLogger(GUICadLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            frameGUICadEditora = new GUICadEditora();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        frameGUICadEditora.setVisible(true);
    }//GEN-LAST:event_jCadastroEditoraActionPerformed

    private void jCadastroAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastroAutorActionPerformed
        GUICadAutor frameGUICadAutor = null;
        try {
            this.populaJComboBoxAutor();
        } catch (SQLException ex) {
            Logger.getLogger(GUICadLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            frameGUICadAutor = new GUICadAutor();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        frameGUICadAutor.setVisible(true);
    }//GEN-LAST:event_jCadastroAutorActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        
       
    }//GEN-LAST:event_AtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(GUICadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new GUICadLivro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GUICadLivro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Atualizar;
    private javax.swing.JTextField TextField1;
    private javax.swing.JTextField TextField3;
    private javax.swing.JTextField TextField6;
    private javax.swing.JButton fechar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JToggleButton jCadastroAutor;
    private javax.swing.JToggleButton jCadastroCategoria;
    private javax.swing.JToggleButton jCadastroEditora;
    private javax.swing.JComboBox<String> jComboBoxAutor;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxEditora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
