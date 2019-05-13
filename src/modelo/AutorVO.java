/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class AutorVO {

    private int codigo;
    private String nome;
    private String obra;
   
    
    


    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the obra
     */
    public String getObra() {
        return obra;
    }

    /**
     * @param obra the obra to set
     */
    public void setObra(String obra) {
        this.obra = obra;
    }
    
 @Override
 
    public String toString() {
        return "ObraVO{" + "Codigo=" + getCodigo() + ", nome=" + getNome() + ", obra=" + obra + '}';
    }
}//fecha classe