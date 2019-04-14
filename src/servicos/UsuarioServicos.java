/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.UsuarioVO;
import dao.UsuarioDAO;

/**
 *
 * @author gustavoz
 */
public class UsuarioServicos {
   /**
     * @param uVO Objeto proveniente da interface
     * @throws SQLException Lançando exceção de SQL
     */
    public void cadastrarUsuario(UsuarioVO uVO) throws SQLException {
        UsuarioDAO pDAO = DAOFactory.getUsuarioDAO();
        pDAO.cadastrarUsuario(uVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<UsuarioVO> buscarUsuarios() throws SQLException {
        UsuarioDAO pDAO = DAOFactory.getUsuarioDAO();
        return pDAO.buscarUsuarios();
    }//fecha método
}//fecha classe