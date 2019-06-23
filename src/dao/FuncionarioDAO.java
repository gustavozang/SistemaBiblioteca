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
import modelo.FuncionarioVO;
import persistencia.ConexaoBanco;

public class FuncionarioDAO {

    public void cadastrarFuncionario(FuncionarioVO funcionario) throws SQLException {
         /**
         Buscando uma conexão com o Banco de Dados
         **/
        Connection con = ConexaoBanco.getConexao();
        /**
         Criando obj. capaz de executar instruções
         SQL no banco de dados
         Montando a instrução INSERT para inserir
         um objeto funcionario no Banco MySQL
         **/
        String sql = "INSERT INTO funcionario(codigo, nome, nome_departamento, data) VALUES(default,?,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getNome_departamento());
            stmt.execute();
            stmt.close();
            con.close();
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    public ArrayList<FuncionarioVO> buscarFuncionarios() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            /**
            Montando o sql
            **/
            sql = "select * from funcionario";

            /** Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs **/
            ResultSet rs = stat.executeQuery(sql);

            /** Criando ArrayList para armazenar 
             objetos do tipo produto **/
            ArrayList<FuncionarioVO> prod = new ArrayList<>();

            /** Enquanto houver uma próxima linha no 
             banco de dados o while roda **/
            while (rs.next()) {
                /**
                 Criando um novo obj. FuncionarioVO
                 * */
                FuncionarioVO p = new FuncionarioVO();

                /** Mapeando a tabela do banco para objeto
                 chamado pVO **/
                p.setCodigo(rs.getInt("codigo"));
                p.setNome(rs.getString("nome"));
                p.setNome_departamento(rs.getString("nome_departamento"));
                           
                

                /** 
                 Inserindo o objeto pVO no ArrayList 
                 **/
                prod.add(p);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar funcionarios! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void deletar(FuncionarioVO funcionario) throws SQLException {
        Connection con = ConexaoBanco.getConexao();

        PreparedStatement p = con.prepareStatement("delete from funcionario where codigo = ?");
        p.setInt(1, funcionario.getCodigo());
        p.execute();
        p.close();
    }

    public void alterar(FuncionarioVO funcionario) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        PreparedStatement p = con.prepareStatement("update funcionario set nome=?,nome_departamento=? where codigo=?");

        p.setString(1, funcionario.getNome());
        p.setString(2, funcionario.getNome_departamento());
        p.setInt(3,funcionario.getCodigo());
        p.execute();
        p.close();

    }

    public void adiciona(FuncionarioVO funcionarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//fecha classe
