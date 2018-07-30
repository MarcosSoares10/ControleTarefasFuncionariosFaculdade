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
public class Endereco {
    private Long idEnd_idFunc;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String cep;

    public Long getIdEnd_idFunc() {
        return idEnd_idFunc;
    }

    public void setIdEnd_idFunc(Long idEnd_idFunc) {
        this.idEnd_idFunc = idEnd_idFunc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
    
}
