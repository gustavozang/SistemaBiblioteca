/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author gustavoz
 */
public class DAOFactory {
 private static UsuarioDAO usuarioDAO = new UsuarioDAO();
 private static final EditoraDAO editoraDAO = new EditoraDAO();
    
    public static UsuarioDAO getUsuarioDAO(){
        return usuarioDAO;
      }//fecha método

    public static EditoraDAO getEditoraDAO() {
        return editoraDAO;
    }
    
}   

