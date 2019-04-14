/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.EditoraDAO;
import modelo.EditoraVO;

/**
 *
 * @author gustavoz
 */
public class EditoraServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarEditora(EditoraVO uVO) throws SQLException {
        EditoraDAO uDAO = DAOFactory.getEditoraDAO();
        uDAO.adiciona(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<EditoraVO> buscarEditoras() throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.buscarEditoras();
    }//fecha método
}//fecha classe