/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AutorVO;
import dao.AutorDAO;

/**
 *
 * @author gustavoz
 */
public class AutorServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarAutor(AutorVO uVO) throws SQLException {
        AutorDAO pDAO = DAOFactory.getAutorDAO();
        pDAO.cadastrarAutor(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<AutorVO> buscarAutores() throws SQLException {
        AutorDAO pDAO = DAOFactory.getAutorDAO();
        return pDAO.buscarAutores();
    }//fecha método
}//fecha classe