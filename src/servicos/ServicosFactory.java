/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author gustavoz
 */
public class ServicosFactory {
    
   private static UsuarioServicos usuarioServicos= new UsuarioServicos();
   private static EditoraServicos editoraServicos= new EditoraServicos();

   public static UsuarioServicos getUsuarioServicos(){
          
       return usuarioServicos;                                
   }//fecha metodo
   
   public static EditoraServicos getEditoraServicos(){
          
       return editoraServicos;                                
   }//fecha metodo 

 
   
}//fecha classe
 


