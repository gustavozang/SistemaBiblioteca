/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.DepartamentoDAO;
import modelo.DepartamentoVO;

/**
 *
 * @author gustavoz
 */
public class DepartamentoServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarDepartamento(DepartamentoVO uVO) throws SQLException {
        DepartamentoDAO uDAO = DAOFactory.getDepartamentoDAO();
        uDAO.adiciona(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<DepartamentoVO> buscarDepartamentos() throws SQLException {
        DepartamentoDAO eDAO = DAOFactory.getDepartamentoDAO();
        return eDAO.buscarDepartamentos();
    }//fecha método
}//fecha classe