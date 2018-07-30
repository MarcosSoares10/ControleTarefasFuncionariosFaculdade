/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.modelo;

/**
 *
 * @author Marquinhos
 */
public class Conta {
    private String email;
    private String senha;
    private String estadoConta;
    private Funcionario funcionario;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the estadoConta
     */
    public String isEstadoConta() {
        return estadoConta;
    }

    /**
     * @param estadoConta the estadoConta to set
     */
    public void setEstadoConta(String estadoConta) {
        this.estadoConta = estadoConta;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
