/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Livro;
import dao.DAOLivro;

/**
 *
 * @author gustavoz
 */
public class LivroServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarLivro(Livro uVO) throws SQLException {
        DAOLivro pDAO = DAOFactory.getLivroDAO();
        pDAO.cadastrarLivro(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<Livro> buscarLivros() throws SQLException {
        DAOLivro pDAO = DAOFactory.getLivroDAO();
        return pDAO.buscarLivros();
    }//fecha método
}//fecha classe