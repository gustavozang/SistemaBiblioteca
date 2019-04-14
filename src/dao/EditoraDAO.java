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
import modelo.EditoraVO;
import persistencia.ConexaoBanco;

public class EditoraDAO {

    public void cadastrarEditora(EditoraVO editora) throws SQLException {
         /**
         Buscando uma conexão com o Banco de Dados
         **/
        Connection con = ConexaoBanco.getConexao();
        /**
         Criando obj. capaz de executar instruções
         SQL no banco de dados
         Montando a instrução INSERT para inserir
         um objeto editora no Banco MySQL
         **/
        String sql = "INSERT INTO editora(codigo, nome, endereco, endereco_nr, endereco_complemento, bairro, cidades, cep, telefone,data) VALUES(default,?,?,?,?,?,?,?,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getEndereco());
            stmt.setString(3, editora.getEndereco_nr());
            stmt.setString(4, editora.getEndereco_complemento());
            stmt.setString(5, editora.getBairro());
            stmt.setString(6, editora.getCidades());
            stmt.setString(7, editora.getCep());
            stmt.setString(8, editora.getTelefone());
            stmt.execute();
            stmt.close();
            con.close();
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    public ArrayList<EditoraVO> buscarEditoras() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            /**
            Montando o sql
            **/
            sql = "select * from editora";

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
                p.setCodigo(rs.getInt("codigo"));
                p.setNome(rs.getString("nome"));
                p.setEndereco(rs.getString("endereco"));
                p.setEndereco_nr(rs.getString("endereco_nr"));
                p.setEndereco_complemento(rs.getString("endereco_complemento"));
                p.setBairro(rs.getString("bairro"));
                p.setCidades(rs.getString("cidades"));
                p.setCep(rs.getString("cep"));
                p.setTelefone(rs.getString("telefone"));
               
                

                /** 
                 Inserindo o objeto pVO no ArrayList 
                 **/
                prod.add(p);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar editoras! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void deletar(EditoraVO editora) throws SQLException {
        Connection con = ConexaoBanco.getConexao();

        PreparedStatement p = con.prepareStatement("delete from editora where codigo = ?");
        p.setInt(1, editora.getCodigo());
        p.execute();
        p.close();
    }

    public void alterar(EditoraVO editora) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        PreparedStatement p = con.prepareStatement("update editora set nome=?,endereco=?,endereco_nr=?,endereco_complemento=?,bairro=?,cidades=?,cep=?,telefone=? where codigo=?");

        p.setString(1, editora.getNome());
        p.setString(2, editora.getEndereco());
        p.setString(3, editora.getEndereco_nr());
        p.setString(4, editora.getEndereco_complemento());
        p.setString(5, editora.getBairro());
        p.setString(6, editora.getCidades());
        p.setString(7, editora.getCep());
        p.setString(8, editora.getTelefone());
        p.setInt(9, editora.getCodigo());
        p.execute();
        p.close();

    }

    public void adiciona(EditoraVO editoras) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//fecha classe
