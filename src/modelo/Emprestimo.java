/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Emprestimo {
    
    private String cpf;
    private String codlivro;
    private String nomelivro;
    private String data_emprestimo;
    private String data_devolucao;


    /**
     * @return the nomelivro
     */
    public String getNomelivro() {
        return nomelivro;
    }

    /**
     * @param nomelivro the nomelivro to set
     */
    public void setNomelivro(String nomelivro) {
        this.nomelivro = nomelivro;
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
     * @return the codlivro
     */
    public String getCodlivro() {
        return codlivro;
    }

    /**
     * @param codlivro the codlivro to set
     */
    public void setCodlivro(String codlivro) {
        this.codlivro = codlivro;
    }

    /**
     * @return the data_emprestimo
     */
    public String getData_emprestimo() {
        return data_emprestimo;
    }

    /**
     * @param data_emprestimo the data_emprestimo to set
     */
    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    /**
     * @return the data_devolucao
     */
    public String getData_devolucao() {
        return data_devolucao;
    }

    /**
     * @param data_devolucao the data_devolucao to set
     */
    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
  
    
}
