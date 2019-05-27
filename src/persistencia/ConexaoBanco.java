/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoBanco {

    // Instanciando variáveis de conexao
    public Connection conexao;
    public Statement statement;
    public ResultSet resultset;
    public PreparedStatement preparestatement;
    
    /**
    Atributos estáticos com os dados do Banco de Dados
    **/
    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String USUARIO = "postgres";
    private static String SENHA = "postgres";

    /**
    Método que efetua a conexão com o Postgres
    * */
    public static Connection getConexao() throws SQLException {
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException se) {
            throw new SQLException("Erro ao conectar! " + se.getMessage());
        }//fecha catch
        return c;
    }//fecha metodo
    
    public void abrirConexao() {
        try {
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName);

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "postgres";

            conexao = DriverManager.getConnection(url, username, password);
            statement = conexao.createStatement();

        } catch (Exception erro) {
            System.err.println("Error Classe: ConexaoBanco - Método: abrirConexao Exceção:  " + erro);
        }

    }
    
    public void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException erroSQL) {
            System.err.println("Error Classe: ConexaoMysql - Método: fecharConexao - Exceção: " + erroSQL);
        }
    }

     /**
     * Método para executar uma consulta SQL com o banco de dados, informando 
     * como argumento uma string.
     * @param Query String - Query SQL, ex: SELECT * FROM NOMETABELA
     */
    public void executaSQL(String Query) {
        try {
            statement = conexao.createStatement();
            resultset = statement.executeQuery(Query);
        } catch (SQLException erroSQL) {
            System.err.println("Error Classe: ConexaoMysql - Método: executaSQL - Exceção: " + erroSQL);
        }
    }
    
     /**
     * Método para preparar uma Statement com o banco de dados, informando 
     * como argumento uma string.
     * @param Query String - Query SQL, ex: SELECT * FROM NOMETABELA
     */
    public void prepareStatement(String Query) {
        try {
          preparestatement = conexao.prepareStatement(Query);
        } catch (SQLException erroSQL) {
            System.err.println("Error Classe: ConexaoMysql - Método: prepareStatement - Exceção: " + erroSQL);
        }
    }

     /**
     * Método para criar uma Statement com o banco de dados.
     */
    public void createStatement() {
        try {
            statement = conexao.createStatement();
        } catch (SQLException erroSQL) {
            System.err.println("Error Classe: ConexaoMysql - Método: createStatemente - Exceção: " + erroSQL);
        }

    }
}//fecha classe

