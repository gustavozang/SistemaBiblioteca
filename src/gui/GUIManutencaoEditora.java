/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.EditoraDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EditoraVO;
import servicos.EditoraServicos;
import servicos.ServicosFactory;

public class GUIManutencaoEditora extends javax.swing.JInternalFrame {

    /* Criando um modelo de tabela padrão 
     com o nome das colunas */
    DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Código", "Nome", "Endereco", "Numero", "Endereco_Complemento", "Bairro", "Cidades", "Cep", "Telefone", });

    /**
     * Creates new form GUIManutencaoEditora
     */
    public GUIManutencaoEditora() {
        initComponents();
        /* Chamando o método preencherTabela 
         no construtor */
        preencherTabela();
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
        jtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtEndereco_complemento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtEndereco_nr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtCidades = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtCep = new javax.swing.JFormattedTextField();
        jtTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableEditora = new javax.swing.JTable();
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

        jtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEnderecoActionPerformed(evt);
            }
        });
        jPanel1.add(jtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 80, 208, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Número:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 111, -1, -1));

        jtEndereco_complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEndereco_complementoActionPerformed(evt);
            }
        });
        jPanel1.add(jtEndereco_complemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 146, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Endereço:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Complemento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 142, -1, 24));

        jtEndereco_nr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEndereco_nrActionPerformed(evt);
            }
        });
        jPanel1.add(jtEndereco_nr, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 111, 208, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Bairro:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 177, -1, 24));

        jtCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCidadesActionPerformed(evt);
            }
        });
        jPanel1.add(jtCidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 216, 208, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cep:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 247, -1, 24));

        jtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBairroActionPerformed(evt);
            }
        });
        jPanel1.add(jtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 181, 208, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cidade:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 212, -1, 24));

        try {
            jtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 251, 208, -1));

        try {
            jtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 282, 207, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Telefone:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 282, -1, 24));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nome:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 49, -1, -1));

        jtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(jtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 49, 208, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Alteração de Editora");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, -1));

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
        setTitle("Manutenção Editora");
        setMinimumSize(new java.awt.Dimension(550, 400));
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jLayeredPane1.setBackground(new java.awt.Color(127, 131, 249));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtableEditora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Endereço", "Número", "Complemento", "Bairro", "Cidade", "Cep", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtableEditora.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtableEditora);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void preencherTabela() {
        try {

            //Buscando objeto EditoraServicos     
            EditoraServicos ps = ServicosFactory.getEditoraServicos();

            /* Criando um ArrayList<ProdutoVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<EditoraVO> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em editoras
            prod = ps.buscarEditoras();

            for (int i = 0; i < prod.size(); i++) {
                dtm.addRow(new String[]{
                    String.valueOf(prod.get(i).getCodigo()),
                    String.valueOf(prod.get(i).getNome()),
                    String.valueOf(prod.get(i).getEndereco()),
                    String.valueOf(prod.get(i).getEndereco_nr()),
                    String.valueOf(prod.get(i).getEndereco_complemento()),
                    String.valueOf(prod.get(i).getBairro()),
                    String.valueOf(prod.get(i).getCep()),
                    String.valueOf(prod.get(i).getCidades()),
                    String.valueOf(prod.get(i).getTelefone()),
                   
                });
            }//fecha for
            
            /* Adicionando o modelo de tabela 
             com os dados na tabela produto */
            jtableEditora.setModel(dtm);
            
            

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
            //Buscando objeto ProdutoServicos     
            EditoraServicos ps = ServicosFactory.getEditoraServicos();

            /* Criando um ArrayList<ProdutoVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<EditoraVO> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em produtos
            prod = ps.buscarEditoras();

            int i = jtableEditora.getSelectedRow();

            EditoraDAO p = new EditoraDAO();

            p.deletar(prod.get(i));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//fecha catch

    }

    private void alterar() {
        try {
            //Buscando objeto ProdutoServicos     
            EditoraServicos ps = ServicosFactory.getEditoraServicos();

            /* Criando um ArrayList<ProdutoVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<EditoraVO> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em produtos
            prod = ps.buscarEditoras();

            int i = jtableEditora.getSelectedRow();

            EditoraDAO p = new EditoraDAO();
            /*jtNome.setText(prod.get(i).getNome());
            jtValor.setText(String.valueOf(prod.get(i).getEndereco()));
            jtValor.setText(String.valueOf(prod.get(i).getEndereco_nr()))
            jtValor.setText(String.valueOf(prod.get(i).getEndereco_complemento()))
            jtValor.setText(String.valueOf(prod.get(i).getBairro()))
            jtValor.setText(String.valueOf(prod.get(i).getCidades()))
            jtValor.setText(String.valueOf(prod.get(i).getCep()))
            jtValor.setText(String.valueOf(prod.get(i).getTelefone()))*/ 
                   
            
            
            
            

            prod.get(i).setNome(jtNome.getText());
            prod.get(i).setEndereco(jtEndereco.getText());
            prod.get(i).setEndereco_nr(jtEndereco_nr.getText());
            prod.get(i).setEndereco_complemento(jtEndereco_complemento.getText());
            prod.get(i).setBairro(jtBairro.getText());
            prod.get(i).setCidades(jtCidades.getText());
            prod.get(i).setCep(jtCep.getText());
            prod.get(i).setTelefone(jtTelefone.getText());
         
            
            
            

            p.alterar(prod.get(i));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//fecha catch
    }
    
    private void informacoes(){
         try {
            //Buscando objeto ProdutoServicos     
            EditoraServicos ps = ServicosFactory.getEditoraServicos();

            /* Criando um ArrayList<EditoraVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<EditoraVO> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em editoras
            prod = ps.buscarEditoras();

            int i = jtableEditora.getSelectedRow();
            
            jtNome.setText(prod.get(i).getNome());
            jtEndereco.setText(String.valueOf(prod.get(i).getEndereco()));
            jtEndereco_nr.setText(String.valueOf(prod.get(i).getEndereco_nr()));
            jtEndereco_complemento.setText(String.valueOf(prod.get(i).getEndereco_complemento()));
            jtBairro.setText(String.valueOf(prod.get(i).getBairro()));
            jtCidades.setText(String.valueOf(prod.get(i).getCidades()));
            jtCep.setText(String.valueOf(prod.get(i).getCep()));
            jtTelefone.setText(String.valueOf(prod.get(i).getTelefone()));
            
            
            
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//f
    }

    private void limparAlterar() {
        jtNome.setText(null);
        jtEndereco.setText(null);
        jtEndereco_nr.setText(null);
        jtEndereco_complemento.setText(null);
        jtBairro.setText(null);
        jtCidades.setText(null);
        jtCep.setText(null);
        jtTelefone.setText(null);
        

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

    private void jtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEnderecoActionPerformed

    private void jtEndereco_complementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEndereco_complementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEndereco_complementoActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        alterar();
        jbPreencherActionPerformed(evt);
        jFAlterar.setVisible(false);
    }//GEN-LAST:event_jbAtualizarActionPerformed

    
    
    private void jAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarActionPerformed
        informacoes();
        jFAlterar.setVisible(true);
    }//GEN-LAST:event_jAlterarActionPerformed

    private void jtEndereco_nrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEndereco_nrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEndereco_nrActionPerformed

    private void jtCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCidadesActionPerformed

    private void jtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBairroActionPerformed

    private void jtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNomeActionPerformed

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
            java.util.logging.Logger.getLogger(GUIManutencaoEditora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIManutencaoEditora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIManutencaoEditora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIManutencaoEditora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIManutencaoEditora().setVisible(true);
            }
        });
    }

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlterar;
    private javax.swing.JButton jDeletar;
    private javax.swing.JFrame jFAlterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbPreencher;
    private javax.swing.JTextField jtBairro;
    private javax.swing.JFormattedTextField jtCep;
    private javax.swing.JTextField jtCidades;
    private javax.swing.JTextField jtEndereco;
    private javax.swing.JTextField jtEndereco_complemento;
    private javax.swing.JTextField jtEndereco_nr;
    private javax.swing.JTextField jtNome;
    private javax.swing.JFormattedTextField jtTelefone;
    private javax.swing.JTable jtableEditora;
    // End of variables declaration//GEN-END:variables
}
