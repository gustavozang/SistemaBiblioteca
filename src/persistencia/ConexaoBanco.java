/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBanco {

    /**
    Atributos estáticos com os dados do Banco de Dados
    **/
    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String USUARIO = "postgres";
    private static String SENHA = "postgres";

    /**
    Método que efetua a conexão com o MySQL
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
    
}//fecha classe

