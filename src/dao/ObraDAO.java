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
import modelo.ObraVO;
import persistencia.ConexaoBanco;

public class ObraDAO {

   public void cadastrarObra(ObraVO obra) throws SQLException {

        /**
         Buscando uma conexão com o Banco de Dados
         **/
        Connection con = ConexaoBanco.getConexao();
        /**
         Criando obj. capaz de executar instruções
         SQL no banco de dados
         Montando a instrução INSERT para inserir
         um objeto obra no Banco MySQL
         **/
        String sql = "INSERT INTO obra(codigo, nome, editora, edicao, autor, categoria, quantidade,data) VALUES(default,?,?,?,?,?,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obra.getNome());
            stmt.setString(2, obra.getEditora());
            stmt.setString(3, obra.getEdicao());
            stmt.setString(4, obra.getAutor());
            stmt.setString(5, obra.getCategoria());
            stmt.setInt(6, obra.getQuantidade());
            stmt.execute();
            stmt.close();
            con.close();
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 

        

    public ArrayList<ObraVO> buscarObras() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from obra";

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
            ArrayList<ObraVO> prod = new ArrayList<>();

            /**
             Enquanto houver uma próxima linha no 
             banco de dados o while roda 
             **/
            while (rs.next()) {
                //Criando um novo obj. ObraVO
                ObraVO p = new ObraVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO 
                 **/
                p.setCodigo(rs.getInt("codigo"));
                p.setNome(rs.getString("nome"));
                p.setEditora(rs.getString("editora"));
                p.setEdicao(rs.getString("edicao"));
                p.setAutor(rs.getString("autor"));
                p.setCategoria(rs.getString("categoria"));
                p.setQuantidade(rs.getInt("quantidade"));
                               

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
            throw new SQLException("Erro ao buscar obras! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void deletar(ObraVO obra) throws SQLException {
        Connection con = ConexaoBanco.getConexao();

        PreparedStatement p = con.prepareStatement("delete from obra where codigo = ?");
        p.setInt(1, obra.getCodigo());
        p.execute();
        p.close();
    }

    public void alterar(ObraVO obra) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        PreparedStatement p = con.prepareStatement("update obra set nome=?,editora=?,edicao=?,autor=?,categoria=?,quantidade=? where codigo=?");

        p.setString(1, obra.getNome());
        p.setString(2, obra.getEditora());
        p.setString(3, obra.getEdicao());
        p.setString(4, obra.getAutor());
        p.setString(5, obra.getCategoria());
        p.setInt(6, obra.getQuantidade());
        p.setInt(7, obra.getCodigo());
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
    
   
      public boolean somaLivro(String codigo) throws SQLException, SQLException{
        conectar();
         String sql = "UPDATE obra SET quantidade=quantidade+1 where codigo=?";
         try{
            comando = con.prepareStatement(sql);
            comando.setString(1, codigo);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            imprimeErro("Erro ao atualizar Livro", e.getMessage());
        }finally{
            fechar();
        }
         return false;
    }
      public boolean alteraLivro(ObraVO livro) throws SQLException{
        conectar();
         String sql = "UPDATE LIVRO SET NOME = ?, EDITORA = ?, EDICAO = ?, AUTOR= ?, CATEGORIA = ?, QUANTIDADE = ?"
                 + " WHERE CODIGO = ?";
         try{
            comando = con.prepareStatement(sql);
            comando.setString(1, livro.getNome());
            comando.setString(2, livro.getEditora());
            comando.setString(3, livro.getEdicao());
            comando.setString(4, livro.getAutor());
            comando.setString(5, livro.getCategoria());
            comando.setInt(6, livro.getQuantidade());
            comando.setInt(7, livro.getCodigo());
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            imprimeErro("Erro ao atualizar Livro", e.getMessage());
        }finally{
            fechar();
        }
         return false;
      }
}//fecha classe
