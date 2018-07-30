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
public class Funcionario extends Pessoa{
    private Long idFunc;
    private String numCelular;
    private String func_adm;
    private Departamento departamento;
    private Long id_depart;
 

    public Long getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Long idFunc) {
        this.idFunc = idFunc;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getTipoFunc() {
        return func_adm;
    }

    public void setTipoFunc(String tipoFunc) {
        this.func_adm = tipoFunc;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the id_depart
     */
    public Long getId_depart() {
        return id_depart;
    }

    /**
     * @param id_depart the id_depart to set
     */
    public void setId_depart(Long id_depart) {
        this.id_depart = id_depart;
    }

  
    
    
    
}
