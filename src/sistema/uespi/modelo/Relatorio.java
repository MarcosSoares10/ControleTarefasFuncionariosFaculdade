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
public class Relatorio {
private String assunto;
private Date dataInicio;
private Date dataFinal;
private String NomeDepart;
private String Nome;
private String estado_tarefa;

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
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFinal
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the NomeDepart
     */
    public String getNomeDepart() {
        return NomeDepart;
    }

    /**
     * @param NomeDepart the NomeDepart to set
     */
    public void setNomeDepart(String NomeDepart) {
        this.NomeDepart = NomeDepart;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
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
    
    
}
