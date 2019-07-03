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
import modelo.CidadeVO;
import persistencia.ConexaoBanco;

public class CidadeDAO {

   public void cadastrarCidade(CidadeVO cidade) throws SQLException {

        /**
         Buscando uma conexão com o Banco de Dados
         **/
        Connection con = ConexaoBanco.getConexao();
        /**
         Criando obj. capaz de executar instruções
         SQL no banco de dados
         Montando a instrução INSERT para inserir
         um objeto Cidade no Banco MySQL
         **/
        String sql = "INSERT INTO cidade(codigo, cidade,uf, data) VALUES(default,?,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, cidade.getCidade());
            stmt.setString(2, cidade.getUf());
            stmt.execute();
            stmt.close();
            con.close();
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 

        

    public ArrayList<CidadeVO> buscarCidades() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from cidade";

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
            ArrayList<CidadeVO> prod = new ArrayList<>();

            /**
             Enquanto houver uma próxima linha no 
             banco de dados o while roda 
             **/
            while (rs.next()) {
                //Criando um novo obj. CidadeVO
                CidadeVO p = new CidadeVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO 
                 **/
                p.setCodigo(rs.getInt("codigo"));
                p.setCidade(rs.getString("cidade"));
                p.setUf(rs.getString("uf"));
                                             

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
            throw new SQLException("Erro ao buscar cidade! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void deletar(CidadeVO cidade) throws SQLException {
        Connection con = ConexaoBanco.getConexao();

        PreparedStatement p = con.prepareStatement("delete from cidade where codigo = ?");
        p.setInt(1, cidade.getCodigo());
        p.execute();
        p.close();
    }

    public void alterar(CidadeVO cidade) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        PreparedStatement p = con.prepareStatement("update cidade set cidade=?,uf=? where codigo=?");

        p.setString(1, cidade.getCidade());
        p.setString(2, cidade.getUf());
        p.setInt(3, cidade.getCodigo());
        p.execute();
        p.close();

    }

    
}//fecha classe
