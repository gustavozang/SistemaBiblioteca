/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class ObraVO {

    private int codigo;
    private String nome;
    private String autor;
    private String ano_publicacao;
    private String situacao_obra;
    private String cod_editora;
    private String cod_fornecedor;
    
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
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the ano_publicacao
     */
    public String getAno_publicacao() {
        return ano_publicacao;
    }

    /**
     * @param ano_publicacao the ano_publicacao to set
     */
    public void setAno_publicacao(String ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    /**
     * @return the situacao_obra
     */
    public String getSituacao_obra() {
        return situacao_obra;
    }

    /**
     * @param situacao_obra the situacao_obra to set
     */
    public void setSituacao_obra(String situacao_obra) {
        this.situacao_obra = situacao_obra;
    }

    /**
     * @return the cod_editora
     */
    public String getCod_editora() {
        return cod_editora;
    }

    /**
     * @param cod_editora the cod_editora to set
     */
    public void setCod_editora(String cod_editora) {
        this.cod_editora = cod_editora;
    }

    /**
     * @return the cod_fornecedor
     */
    public String getCod_fornecedor() {
        return cod_fornecedor;
    }

    /**
     * @param cod_fornecedor the cod_fornecedor to set
     */
    public void setCod_fornecedor(String cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

 @Override
 
    public String toString() {
        return "ObraVO{" + "Codigo=" + getCodigo() + ", nome=" + getNome() + ", autor=" + autor + "ano_publicacao=" + ano_publicacao + ", situacao_obra=" + situacao_obra + "cod_editora=" + cod_editora + "cod_fornecedor=" + cod_fornecedor + '}';
    }
}//fecha classe