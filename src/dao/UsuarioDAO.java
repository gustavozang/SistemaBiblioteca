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
import modelo.UsuarioVO;
import persistencia.ConexaoBanco;

public class UsuarioDAO {

   public void cadastrarUsuario(UsuarioVO usuario) throws SQLException {

        /**
         Buscando uma conexão com o Banco de Dados
         **/
        Connection con = ConexaoBanco.getConexao();
        /**
         Criando obj. capaz de executar instruções
         SQL no banco de dados
         Montando a instrução INSERT para inserir
         um objeto usuario no Banco MySQL
         **/
        String sql = "INSERT INTO usuario(codigo, nome, endereco, endereco_nr, endereco_complemento, bairro, cidades, cep, telefone, celular,data) VALUES(default,?,?,?,?,?,?,?,?,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getEndereco_nr());
            stmt.setString(4, usuario.getEndereco_complemento());
            stmt.setString(5, usuario.getBairro());
            stmt.setString(6, usuario.getCidades());
            stmt.setString(7, usuario.getCep());
            stmt.setString(8, usuario.getTelefone());
            stmt.setString(9, usuario.getCelular());
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
                p.setNome(rs.getString("nome"));
                p.setEndereco(rs.getString("endereco"));
                p.setEndereco_nr(rs.getString("endereco_nr"));
                p.setEndereco_complemento(rs.getString("endereco_complemento"));
                p.setBairro(rs.getString("bairro"));
                p.setCidades(rs.getString("cidades"));
                p.setCep(rs.getString("cep"));
                p.setTelefone(rs.getString("telefone"));
                p.setCelular(rs.getString("celular"));
                

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
        PreparedStatement p = con.prepareStatement("update usuario set nome=?,endereco=?,endereco_nr=?,endereco_complemento=?,bairro=?,cidades=?,cep=?,telefone=?,celular=? where codigo=?");

        p.setString(1, usuario.getNome());
        p.setString(2, usuario.getEndereco());
        p.setString(3, usuario.getEndereco_nr());
        p.setString(4, usuario.getEndereco_complemento());
        p.setString(5, usuario.getBairro());
        p.setString(6, usuario.getCidades());
        p.setString(7, usuario.getCep());
        p.setString(8, usuario.getTelefone());
        p.setString(9, usuario.getCelular());
        p.setInt(10, usuario.getCodigo());
        p.execute();
        p.close();

    }

    
}//fecha classe
