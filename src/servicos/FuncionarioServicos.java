/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.FuncionarioVO;
import dao.FuncionarioDAO;

/**
 *
 * @author gustavoz
 */
public class FuncionarioServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarFuncionario(FuncionarioVO uVO) throws SQLException {
        FuncionarioDAO pDAO = DAOFactory.getFuncionarioDAO();
        pDAO.cadastrarFuncionario(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<FuncionarioVO> buscarFuncionarios() throws SQLException {
        FuncionarioDAO pDAO = DAOFactory.getFuncionarioDAO();
        return pDAO.buscarFuncionarios();
    }//fecha método
}//fecha classe