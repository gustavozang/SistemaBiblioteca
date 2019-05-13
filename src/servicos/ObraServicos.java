/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ObraVO;
import dao.ObraDAO;

/**
 *
 * @author gustavoz
 */
public class ObraServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarObra(ObraVO uVO) throws SQLException {
        ObraDAO pDAO = DAOFactory.getObraDAO();
        pDAO.cadastrarObra(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<ObraVO> buscarObras() throws SQLException {
        ObraDAO pDAO = DAOFactory.getObraDAO();
        return pDAO.buscarObras();
    }//fecha método
}//fecha classe