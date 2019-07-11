/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.UsuarioVO;
import persistencia.ConexaoBanco;

public class UsuarioDAO {

   public void cadastrarUsuario(UsuarioVO usuario) throws SQLException {

        /**
         Buscando uma conexão com o Banco de Dados
         **/
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        /**
         Criando obj. capaz de executar instruções
         SQL no banco de dados
         Montando a instrução INSERT para inserir
         um objeto usuario no Banco MySQL
         **/
        String sql = "INSERT INTO usuario(codigo, nomeuser, cpf, endereco, endereco_nr, endereco_complemento, bairro, cidades, cep, telefone, celular, matriculauser, loginunico, senhauser, permissaouser,data) VALUES(default,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNomeuser());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEndereco());
            stmt.setString(4, usuario.getEndereco_nr());
            stmt.setString(5, usuario.getEndereco_complemento());
            stmt.setString(6, usuario.getBairro());
            stmt.setString(7, usuario.getCidades());
            stmt.setString(8, usuario.getCep());
            stmt.setString(9, usuario.getTelefone());
            stmt.setString(10, usuario.getCelular());
            stmt.setString(11, usuario.getMatriculauser());
            stmt.setString(12, usuario.getLoginunico());
            stmt.setString(13, usuario.getSenhauser());
            stmt.setString(14, usuario.getPermissaouser());
            stmt.execute();
            stmt.close();
            con.close();
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 

        

    public ArrayList<UsuarioVO> buscarUsuarios() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from usuario";

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
            ArrayList<UsuarioVO> prod = new ArrayList<>();

            /**
             Enquanto houver uma próxima linha no 
             banco de dados o while roda 
             **/
            while (rs.next()) {
                //Criando um novo obj. UsuarioVO
                UsuarioVO p = new UsuarioVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO 
                 **/
                p.setCodigo(rs.getInt("codigo"));
                p.setNomeuser(rs.getString("nomeuser"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setEndereco_nr(rs.getString("endereco_nr"));
                p.setEndereco_complemento(rs.getString("endereco_complemento"));
                p.setBairro(rs.getString("bairro"));
                p.setCidades(rs.getString("cidades"));
                p.setCep(rs.getString("cep"));
                p.setTelefone(rs.getString("telefone"));
                p.setCelular(rs.getString("celular"));
                p.setMatriculauser(rs.getString("matriculauser"));
                p.setLoginunico(rs.getString("loginunico"));
                p.setSenhauser(rs.getString("senhauser"));
                p.setPermissaouser(rs.getString("permissaouser"));
                

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
            throw new SQLException("Erro ao buscar usuarios! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void deletar(UsuarioVO usuario) throws SQLException {
        Connection con = ConexaoBanco.getConexao();

        PreparedStatement p = con.prepareStatement("delete from usuario where codigo = ?");
        p.setInt(1, usuario.getCodigo());
        p.execute();
        p.close();
    }

    public void alterar(UsuarioVO usuario) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        PreparedStatement p = con.prepareStatement("update usuario set nomeuser=?,cpf=?,endereco=?,endereco_nr=?,endereco_complemento=?,bairro=?,cidades=?,cep=?,telefone=?,celular=?,matriculauser=?,loginunico=?,senhauser=?,permissaouser=?  where codigo=?");

        p.setString(1, usuario.getNomeuser());
        p.setString(2, usuario.getCpf());
        p.setString(3, usuario.getEndereco());
        p.setString(4, usuario.getEndereco_nr());
        p.setString(5, usuario.getEndereco_complemento());
        p.setString(6, usuario.getBairro());
        p.setString(7, usuario.getCidades());
        p.setString(8, usuario.getCep());
        p.setString(9, usuario.getTelefone());
        p.setString(10, usuario.getCelular());
        p.setString(11, usuario.getMatriculauser());
        p.setString(12, usuario.getLoginunico());
        p.setString(13, usuario.getSenhauser());
        p.setString(14, usuario.getPermissaouser());
        p.setInt(15, usuario.getCodigo());
        p.execute();
        p.close();

    }
    
    private Connection con;
    //Pre-compila a query para o banco de dados
    private PreparedStatement comando;
    
    public void imprimeErro(String msg1, String errorSystem){
        JOptionPane.showMessageDialog(null, msg1, "Erro", JOptionPane.ERROR_MESSAGE, null);
        System.err.println(""+errorSystem);
    }
    
     private void conectar() throws SQLException{
        con = ConexaoBanco.getConexao();
    }
    
     private void fechar(){
        try{
            comando.close();
            con.close();
        }catch(SQLException e){
            imprimeErro("Erro ao fechar conexão", e.getMessage());
        }
    }
     
    
 public  ArrayList<UsuarioVO> selecionarTodosRegistrosCPF() throws SQLException
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM USUARIO";
        //lista que conterá todas as informações de livros no banco de dados
        ArrayList<UsuarioVO> listaEmprestimo = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            rs = comando.executeQuery();
            while(rs.next())
            {
                UsuarioVO usuario = new UsuarioVO();
                usuario.setCpf(rs.getString("CPF"));
                
                listaEmprestimo.add(usuario);
            }
            fechar();
            return listaEmprestimo;
        }catch(SQLException e){
            imprimeErro("Erro ao buscar CPF(s)", e.getMessage());
            fechar();
            return null;
        }
        
    }
    
}//fecha classe
