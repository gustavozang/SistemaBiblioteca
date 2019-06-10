/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class UsuarioVO {
    
 private int codigo;
    private String nomeuser;
    private String cpf;
    private String endereco;
    private String endereco_nr;
    private String endereco_complemento;
    private String bairro;
    private String cidades;
    private String cep;
    private String telefone;
    private String celular;
    private String matriculauser;
    private String loginunico;
    private String senhauser;
    private String permissaouser;
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
     * @return the nomeuser
     */
    public String getNomeuser() {
        return nomeuser;
    }

    /**
     * @param nomeuser the nomeuser to set
     */
    public void setNomeuser(String nomeuser) {
        this.nomeuser = nomeuser;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    /**
     * @return the matriculauser
     */
    public String getMatriculauser() {
        return matriculauser;
    }

    /**
     * @param matriculauser the matriculauser to set
     */
    public void setMatriculauser(String matriculauser) {
        this.matriculauser = matriculauser;
    }

    /**
     * @return the loginunico
     */
    public String getLoginunico() {
        return loginunico;
    }

    /**
     * @param loginunico the loginunico to set
     */
    public void setLoginunico(String loginunico) {
        this.loginunico = loginunico;
    }

    /**
     * @return the senhauser
     */
    public String getSenhauser() {
        return senhauser;
    }

    /**
     * @param senhauser the senhauser to set
     */
    public void setSenhauser(String senhauser) {
        this.senhauser = senhauser;
    }

    /**
     * @return the permissaouser
     */
    public String getPermissaouser() {
        return permissaouser;
    }

    /**
     * @param permissaouser the permissaouser to set
     */
    public void setPermissaouser(String permissaouser) {
        this.permissaouser = permissaouser;
    }


    

    

    
   @Override
    public String toString() {
        return "UsuarioVO{" + "Codigo=" + getCodigo() + " nomeuser=" + getNomeuser()+ "cpf=" + getCpf()+ " endereco=" + getEndereco() + "endereco_nr=" + getEndereco_nr() + " endereco_complemento=" + getEndereco_complemento() + "bairro=" + getBairro() + "cidades=" + getCidades() + "cep=" + getCep() + "telefone=" + getTelefone() + "celular=" + getCelular() + "matriculauser=" + getMatriculauser () + "loginunico=" + getLoginunico() + "senhauser=" + getSenhauser() + "permissaouser=" + getPermissaouser() +'}';
    }
}//fecha classe
