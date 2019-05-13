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
   private static FornecedorServicos fornecedorServicos= new FornecedorServicos();
   private static FuncionarioServicos funcionarioServicos= new FuncionarioServicos();
   private static ObraServicos obraServicos= new ObraServicos();
   private static DepartamentoServicos departamentoServicos= new DepartamentoServicos();
   private static AutorServicos autorServicos= new AutorServicos();

   public static UsuarioServicos getUsuarioServicos(){
          
       return usuarioServicos;                                
   }//fecha metodo
   
   public static EditoraServicos getEditoraServicos(){
          
       return editoraServicos;                                
   }//fecha metodo 
   
   public static FornecedorServicos getFornecedorServicos(){
          
       return fornecedorServicos;                                
   }//fecha metodo 
   
   public static FuncionarioServicos getFuncionarioServicos(){
          
       return funcionarioServicos;
    }//fecha metodo    
   public static ObraServicos getObraServicos(){
          
       return obraServicos;     
   }//fecha metodo
     

    public static DepartamentoServicos getDepartamentoServicos() {
        return departamentoServicos;
    }
    
    public static AutorServicos getAutorServicos() {
        return autorServicos;
    }
   
}//fecha classe
 


