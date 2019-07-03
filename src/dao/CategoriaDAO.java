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
import modelo.CategoriaVO;
import persistencia.ConexaoBanco;

public class CategoriaDAO {

   public void cadastrarCategoria(CategoriaVO categoria) throws SQLException {

        /**
         Buscando uma conexão com o Banco de Dados
         **/
        Connection con = ConexaoBanco.getConexao();
        /**
         Criando obj. capaz de executar instruções
         SQL no banco de dados
         Montando a instrução INSERT para inserir
         um objeto Categoria no Banco MySQL
         **/
        String sql = "INSERT INTO categoria(codigo, nome,data) VALUES(default,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, categoria.getNome());
            stmt.execute();
            stmt.close();
            con.close();
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 

        

    public ArrayList<CategoriaVO> buscarCategorias() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from categoria";

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
            ArrayList<CategoriaVO> prod = new ArrayList<>();

            /**
             Enquanto houver uma próxima linha no 
             banco de dados o while roda 
             **/
            while (rs.next()) {
                //Criando um novo obj. CategoriaVO
                CategoriaVO p = new CategoriaVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO 
                 **/
                p.setCodigo(rs.getInt("codigo"));
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
            throw new SQLException("Erro ao buscar categoria! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void deletar(CategoriaVO categoria) throws SQLException {
        Connection con = ConexaoBanco.getConexao();

        PreparedStatement p = con.prepareStatement("delete from categoria where codigo = ?");
        p.setInt(1, categoria.getCodigo());
        p.execute();
        p.close();
    }

    public void alterar(CategoriaVO categoria) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        PreparedStatement p = con.prepareStatement("update categoria set nome=? where codigo=?");

        p.setString(1, categoria.getNome());
        p.setInt(2, categoria.getCodigo());
        p.execute();
        p.close();

    }

    
}//fecha classe
