/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import persistencia.ConexaoBanco;
import utils.JTextFieldTamanhoMaximo;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Classe responsável por montar a tela de login do sistema que consite em input
 * de usuário e senha, se esses dados de autenticação forem verdadeiros é aberto
 * a tela da Janela principal do sistema biblioteca.
 *
 */
public final class TelaLogin extends javax.swing.JFrame {

    // Declarando Variaveis
    public static String nomelogado;
    public static String matriculalogado;
    public static String senhalogado;
    public static String tipouser;

    /**
     * Construtor inicia componentes básicos da interface gráfica.
     */
    public TelaLogin() {
        initComponents();
        setIcon();
        setLimitTextFields();
    }
    
    /**
     * Método seta a imagem ao favicon do frame.
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/utils/chave.png")));
    }

    /** 
     * Método responsável por inicializar os componentes de entrada de dados,
     * com a classes que limita os componentes<br>
     * Ex: jtextfield, jpasswordfield.
     */
    public void setLimitTextFields(){
        textfieldNome.setDocument(new JTextFieldTamanhoMaximo(20));
        jpasswordField.setDocument(new JTextFieldTamanhoMaximo(20));
    }
    /**
     * Método instancia objeto da janela principal do sistema e seta como
     * visível.
     */
    public void acessarSistema() {
        MenuPrincipal telaprin = new MenuPrincipal();
        telaprin.setVisible(true);
    }

    /**
     * Método verifica autenticação no banco de dados postgres se os dados de
     * usuário/matrícula e senha forem corretos o sistema retorna true, caso não
     * seja ele retorna false informando que o usuário/matrícula ou senha estão
     * incorretos.
     *
     * @return acesso Boolean
     */
    public boolean verificaAutenticacao() {
        boolean acesso = false;

        try {
            ConexaoBanco conect = new ConexaoBanco();
            conect.abrirConexao();
            conect.createStatement();
            conect.executaSQL("SELECT * FROM usuario");

            while (conect.resultset.next()) {
                if ((textfieldNome.getText().equals(conect.resultset.getString("matriculauser"))
                        || textfieldNome.getText().equals(conect.resultset.getString("loginunico")))
                        && jpasswordField.getText().equals(conect.resultset.getString("senhauser"))) {
                    nomelogado = conect.resultset.getString("nomeuser");
                    matriculalogado = conect.resultset.getString("matriculauser");
                    senhalogado = conect.resultset.getString("senhauser");
                    tipouser = conect.resultset.getString("permissaouser");
                    acesso = true;
                }
            }
            conect.fecharConexao();

            if (!acesso) {
                JOptionPane.showMessageDialog(null, "Usuário/Matrícula ou Senha Inválida!", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception erro) {
            System.out.println("Erro Tela Login: " + erro);
        }
        return acesso;
    }

    // Método gerado automaticamente GUI 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textfieldNome = new javax.swing.JTextField();
        jpasswordField = new javax.swing.JPasswordField();
        labelNome = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        buttonSair = new javax.swing.JButton();
        buttonAcessar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelImageLogin = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Biblioteca Login");
        setMinimumSize(new java.awt.Dimension(450, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        textfieldNome.setBackground(new java.awt.Color(255, 255, 204));
        textfieldNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textfieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldNomeActionPerformed(evt);
            }
        });
        getContentPane().add(textfieldNome);
        textfieldNome.setBounds(122, 143, 280, 30);

        jpasswordField.setBackground(new java.awt.Color(255, 255, 204));
        jpasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpasswordFieldKeyPressed(evt);
            }
        });
        getContentPane().add(jpasswordField);
        jpasswordField.setBounds(122, 220, 280, 30);

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        labelNome.setForeground(new java.awt.Color(0, 102, 153));
        labelNome.setText("Matrícula / Login Único");
        getContentPane().add(labelNome);
        labelNome.setBounds(122, 117, 260, 25);

        labelPassword.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        labelPassword.setForeground(new java.awt.Color(0, 102, 153));
        labelPassword.setText("Senha:");
        getContentPane().add(labelPassword);
        labelPassword.setBounds(122, 191, 120, 25);

        buttonSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/delete.png"))); // NOI18N
        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSair);
        buttonSair.setBounds(282, 275, 130, 50);

        buttonAcessar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonAcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/accept.png"))); // NOI18N
        buttonAcessar.setText("Entrar");
        buttonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAcessar);
        buttonAcessar.setBounds(109, 275, 130, 50);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelTitulo.setText("Sistema Biblioteca");

        labelImageLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/booklelogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelImageLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTitulo)
                    .addComponent(labelImageLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 520, 102);

        setSize(new java.awt.Dimension(520, 381));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcessarActionPerformed
        boolean acesso;
        acesso = verificaAutenticacao();
        if (acesso) {
            dispose();
            acessarSistema();
        }
    }//GEN-LAST:event_buttonAcessarActionPerformed

    private void jpasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean acesso;
            acesso = verificaAutenticacao();
            if (acesso) {
                dispose();
                acessarSistema();
            }
        }
    }//GEN-LAST:event_jpasswordFieldKeyPressed

    private void textfieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldNomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAcessar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jpasswordField;
    private javax.swing.JLabel labelImageLogin;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textfieldNome;
    // End of variables declaration//GEN-END:variables
}
