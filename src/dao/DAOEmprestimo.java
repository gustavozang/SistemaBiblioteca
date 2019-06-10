/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Emprestimo;
import modelo.ObraVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.ConexaoBanco;

/**
 *
 * @author Vitor
 */
public class DAOEmprestimo {
    
    
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
     
     
     
     public  ArrayList<Emprestimo> selecionarTodosRegistros() throws SQLException
    {
        conectar();
        //interface utilizada pra guardar dados vindos de um banco de dados
        ResultSet rs;
        String sql = "SELECT * FROM EMPRESTIMO";
        //lista que conterá todas as informações de livros no banco de dados
        ArrayList<Emprestimo> listaEmprestimo = new ArrayList();
        try{
            comando = con.prepareStatement(sql);
            rs = comando.executeQuery();
            while(rs.next())
            {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setCpf(rs.getString("CPF"));
                emprestimo.setCodlivro(rs.getString("CODLIVRO"));
                listaEmprestimo.add(emprestimo);
            }
            fechar();
            return listaEmprestimo;
        }catch(SQLException e){
            imprimeErro("Erro ao buscar Emprestimo(s)", e.getMessage());
            fechar();
            return null;
        }
            
    }
    
     

     
       public boolean insereEmprestimo(String cpf,String codlivro) throws SQLException{
        
        conectar();
        String sql = "INSERT INTO emprestimo(cpf, codlivro) VALUES(?,?)";
        
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, cpf);
            comando.setString(2, codlivro);
            comando.execute();
            return true;
        }catch(SQLException e){
            imprimeErro("Erro ao inserir Livro", e.getMessage());
        }finally{
            fechar();
        }
        return false;
    }
       
       public boolean alteraEmprestimo(int qtd,String codigo) throws SQLException, SQLException, SQLException{
        conectar();
         String sql = "UPDATE EMPRESTIMO SET QUANTIDADE = ?"
                 + " WHERE CODIGO = ?";
         try{
            comando = con.prepareStatement(sql);
            comando.setInt(1,qtd);
            comando.setString(2, codigo);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            imprimeErro("Erro ao atualizar Livro", e.getMessage());
        }finally{
            fechar();
        }
         return false;
    }
       
    public boolean removeEmprestimo(String cpf) throws SQLException, SQLException{
        conectar();
        String sql = "DELETE FROM EMPRESTIMO WHERE cpf=?";
        try{
            comando = con.prepareStatement(sql);
            comando.setString(1, cpf);
            comando.executeUpdate();
            return true;
        }catch(SQLException e){
            imprimeErro("Erro ao excluir Livro", e.getMessage());
        }finally{
            fechar();
        }
        return false;
    }   
}
