/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class FuncionarioVO {

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
     * @return the nome_departamento
     */
    public String getNome_departamento() {
        return nome_departamento;
    }

    /**
     * @param nome_departamento the nome_departamento to set
     */
    public void setNome_departamento(String nome_departamento) {
        this.nome_departamento = nome_departamento;
    }

    private int codigo;
    private String nome;
    private String nome_departamento;
     

    
    public String toString() {
        return "FuncioarioVO{" + "Codigo=" + codigo + ", nome=" + nome + ", nome_departamento=" + nome_departamento + '}';
    }
}
    