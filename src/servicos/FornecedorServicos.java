/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.FornecedorVO;
import dao.FornecedorDAO;

/**
 *
 * @author gustavoz
 */
public class FornecedorServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarFornecedor(FornecedorVO uVO) throws SQLException {
        FornecedorDAO pDAO = DAOFactory.getFornecedorDAO();
        pDAO.cadastrarFornecedor(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<FornecedorVO> buscarFornecedoress() throws SQLException {
        FornecedorDAO pDAO = DAOFactory.getFornecedorDAO();
        return pDAO.buscarFornecedores();
    }//fecha método
}//fecha classe