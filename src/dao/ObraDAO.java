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
        String sql = "INSERT INTO obra(codigo, nome, autor, ano_publicacao, situacao_obra, cod_editora, cod_fornecedor,data) VALUES(default,?,?,?,?,?,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obra.getNome());
            stmt.setString(2, obra.getAutor());
            stmt.setString(3, obra.getAno_publicacao());
            stmt.setString(4, obra.getSituacao_obra());
            stmt.setString(5, obra.getCod_editora());
            stmt.setString(6, obra.getCod_fornecedor());
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
                p.setAutor(rs.getString("autor"));
                p.setAno_publicacao(rs.getString("ano_publicacao"));
                p.setSituacao_obra(rs.getString("situacao_obra"));
                p.setCod_editora(rs.getString("cod_editora"));
                p.setCod_fornecedor(rs.getString("cod_fornecedor"));
                               

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
        PreparedStatement p = con.prepareStatement("update obra set nome=?,autor=?,ano_publicacao=?,situacao_obra=?,cod_editora=?,cod_fornecedor=? where codigo=?");

        p.setString(1, obra.getNome());
        p.setString(2, obra.getAutor());
        p.setString(3, obra.getAno_publicacao());
        p.setString(4, obra.getSituacao_obra());
        p.setString(5, obra.getCod_editora());
        p.setString(6, obra.getCod_fornecedor());
        p.setInt(7, obra.getCodigo());
        p.execute();
        p.close();

    }

    
}//fecha classe
