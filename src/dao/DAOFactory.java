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
 private static final FornecedorDAO fornecedorDAO = new FornecedorDAO();
 private static final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
 private static final DAOLivro livroDAO = new DAOLivro();
 private static final DepartamentoDAO departamentoDAO = new DepartamentoDAO();
 private static final AutorDAO autorDAO = new AutorDAO();
    
    
    public static UsuarioDAO getUsuarioDAO(){
        return usuarioDAO;
      }//fecha método

    public static EditoraDAO getEditoraDAO() {
        return editoraDAO;
    }
    
    public static FornecedorDAO getFornecedorDAO() {
        return fornecedorDAO;
    }
    
    public static FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public static DAOLivro getLivroDAO() {
        return livroDAO;
    }
    
    public static DepartamentoDAO getDepartamentoDAO() {
        return departamentoDAO;
    }
    
    public static AutorDAO getAutorDAO() {
        return autorDAO;
    }
}    




