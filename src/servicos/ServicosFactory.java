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
   private static LivroServicos livroServicos= new LivroServicos();
   private static DepartamentoServicos departamentoServicos= new DepartamentoServicos();
   private static AutorServicos autorServicos= new AutorServicos();
   private static CidadeServicos cidadeServicos= new CidadeServicos();
   private static CategoriaServicos categoriaServicos= new CategoriaServicos();

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
   public static LivroServicos getLivroServicos(){
          
       return livroServicos;     
   }//fecha metodo
     

    public static DepartamentoServicos getDepartamentoServicos() {
        return departamentoServicos;
    }
    
    public static AutorServicos getAutorServicos() {
        return autorServicos;
    }
    public static CidadeServicos getCidadeServicos() {
        return cidadeServicos;
    }
    
     public static CategoriaServicos getCategoriaServicos() {
        return categoriaServicos;
    }
   
}//fecha classe
 


