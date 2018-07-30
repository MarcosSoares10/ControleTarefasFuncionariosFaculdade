/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.modelo;

import java.util.Date;

/**
 *
 * @author Marquinhos
 */
public class Tarefa {
    private long idTarefa;
    private long func_id;
    private String assunto;
    private String descricao;
    private Date datainicio;
    private Date datafinal;
    private long depart;
    private String estado_tarefa;
    private String nomeDepart;

    /**
     * @return the idTarefa
     */
    public long getIdTarefa() {
        return idTarefa;
    }

    /**
     * @param idTarefa the idTarefa to set
     */
    public void setIdTarefa(long idTarefa) {
        this.idTarefa = idTarefa;
    }

    /**
     * @return the func_id
     */
    public long getFunc_id() {
        return func_id;
    }

    /**
     * @param func_id the func_id to set
     */
    public void setFunc_id(long func_id) {
        this.func_id = func_id;
    }

    /**
     * @return the assunto
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the datainicio
     */
    public Date getDatainicio() {
        return datainicio;
    }

    /**
     * @param datainicio the datainicio to set
     */
    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    /**
     * @return the datafinal
     */
    public Date getDatafinal() {
        return datafinal;
    }

    /**
     * @param datafinal the datafinal to set
     */
    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    /**
     * @return the depart
     */
    public Long getDepart() {
        return depart;
    }

    /**
     * @param depart the depart to set
     */
    public void setDepart(Long depart) {
        this.depart = depart;
    }

    /**
     * @return the estado_tarefa
     */
    public String getEstado_tarefa() {
        return estado_tarefa;
    }

    /**
     * @param estado_tarefa the estado_tarefa to set
     */
    public void setEstado_tarefa(String estado_tarefa) {
        this.estado_tarefa = estado_tarefa;
    }

    /**
     * @return the nomeDepart
     */
    public String getNomeDepart() {
        return nomeDepart;
    }

    /**
     * @param nomeDepart the nomeDepart to set
     */
    public void setNomeDepart(String nomeDepart) {
        this.nomeDepart = nomeDepart;
    }

    
    
    
}
