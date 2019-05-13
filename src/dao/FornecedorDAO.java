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
import modelo.FornecedorVO;
import persistencia.ConexaoBanco;

public class FornecedorDAO {

   public void cadastrarFornecedor(FornecedorVO Fornecedor) throws SQLException {

        /**
         Buscando uma conexão com o Banco de Dados
         **/
        Connection con = ConexaoBanco.getConexao();
        /**
         Criando obj. capaz de executar instruções
         SQL no banco de dados
         Montando a instrução INSERT para inserir
         um objeto Fornecedor no Banco MySQL
         **/
        String sql = "INSERT INTO Fornecedor(codigo, nome, endereco, endereco_nr, endereco_complemento, bairro, cidades, cep, telefone, celular,data) VALUES(default,?,?,?,?,?,?,?,?,?, CURRENT_DATE)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, Fornecedor.getNome());
            stmt.setString(2, Fornecedor.getEndereco());
            stmt.setString(3, Fornecedor.getEndereco_nr());
            stmt.setString(4, Fornecedor.getEndereco_complemento());
            stmt.setString(5, Fornecedor.getBairro());
            stmt.setString(6, Fornecedor.getCidades());
            stmt.setString(7, Fornecedor.getCep());
            stmt.setString(8, Fornecedor.getTelefone());
            stmt.setString(9, Fornecedor.getCelular());
            stmt.execute();
            stmt.close();
            con.close();
            
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 

        

    public ArrayList<FornecedorVO> buscarFornecedores() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from Fornecedor";

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
            ArrayList<FornecedorVO> prod = new ArrayList<>();

            /**
             Enquanto houver uma próxima linha no 
             banco de dados o while roda 
             **/
            while (rs.next()) {
                //Criando um novo obj. FornecedorVO
                FornecedorVO p = new FornecedorVO();

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
            throw new SQLException("Erro ao buscar Fornecedores! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

    public void deletar(FornecedorVO Fornecedor) throws SQLException {
        Connection con = ConexaoBanco.getConexao();

        PreparedStatement p = con.prepareStatement("delete from Fornecedor where codigo = ?");
        p.setInt(1, Fornecedor.getCodigo());
        p.execute();
        p.close();
    }

    public void alterar(FornecedorVO Fornecedor) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        PreparedStatement p = con.prepareStatement("update Fornecedor set nome=?,endereco=?,endereco_nr=?,endereco_complemento=?,bairro=?,cidades=?,cep=?,telefone=?,celular=? where codigo=?");

        p.setString(1, Fornecedor.getNome());
        p.setString(2, Fornecedor.getEndereco());
        p.setString(3, Fornecedor.getEndereco_nr());
        p.setString(4, Fornecedor.getEndereco_complemento());
        p.setString(5, Fornecedor.getBairro());
        p.setString(6, Fornecedor.getCidades());
        p.setString(7, Fornecedor.getCep());
        p.setString(8, Fornecedor.getTelefone());
        p.setString(9, Fornecedor.getCelular());
        p.setInt(10, Fornecedor.getCodigo());
        p.execute();
        p.close();

    }

    
}//fecha classe
