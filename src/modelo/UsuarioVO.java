/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class UsuarioVO {

    private int codigo;
    private String nome;
    private String endereco;
    private String endereco_nr;
    private String endereco_complemento;
    private String bairro;
    private String cidades;
    private String cep;
    private String telefone;
    private String celular;

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
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the endereco_nr
     */
    public String getEndereco_nr() {
        return endereco_nr;
    }

    /**
     * @param endereco_nr the endereco_nr to set
     */
    public void setEndereco_nr(String endereco_nr) {
        this.endereco_nr = endereco_nr;
    }

    /**
     * @return the endereco_complemento
     */
    public String getEndereco_complemento() {
        return endereco_complemento;
    }

    /**
     * @param endereco_complemento the endereco_complemento to set
     */
    public void setEndereco_complemento(String endereco_complemento) {
        this.endereco_complemento = endereco_complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidades
     */
    public String getCidades() {
        return cidades;
    }

    /**
     * @param cidades the cidades to set
     */
    public void setCidades(String cidades) {
        this.cidades = cidades;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
   @Override
    public String toString() {
        return "UsuarioVO{" + "Codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + "endereco_nr=" + endereco_nr + ", endereco_complemento=" + endereco_complemento + "bairro=" + bairro + "cidades=" + cidades + "cep=" + cep + "telefone=" + telefone + "celular=" + celular + '}';
    }
}//fecha classe
