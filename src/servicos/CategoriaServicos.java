/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CategoriaVO;
import dao.CategoriaDAO;

/**
 *
 * @author gustavoz
 */
public class CategoriaServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarCategoria(CategoriaVO uVO) throws SQLException {
        CategoriaDAO pDAO = DAOFactory.getCategoriaDAO();
        pDAO.cadastrarCategoria(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<CategoriaVO> buscarCategorias() throws SQLException {
        CategoriaDAO pDAO = DAOFactory.getCategoriaDAO();
        return pDAO.buscarCategorias();
    }//fecha método
}//fecha classe