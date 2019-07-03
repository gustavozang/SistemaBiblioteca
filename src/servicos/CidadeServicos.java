/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CidadeVO;
import dao.CidadeDAO;

/**
 *
 * @author gustavoz
 */
public class CidadeServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarCidade(CidadeVO uVO) throws SQLException {
        CidadeDAO pDAO = DAOFactory.getCidadeDAO();
        pDAO.cadastrarCidade(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<CidadeVO> buscarCidades() throws SQLException {
        CidadeDAO pDAO = DAOFactory.getCidadeDAO();
        return pDAO.buscarCidades();
    }//fecha método
}//fecha classe