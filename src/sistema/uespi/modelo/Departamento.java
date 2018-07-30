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
public class Departamento {
    private Long idDepart;
    private String nomeDepart;
    private String descricaoDepart;
    private Long gerenteid;
    private Long usuario;
       

    public Long getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(Long idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomeDepart() {
        return nomeDepart;
    }

    public void setNomeDepart(String nomeDepart) {
        this.nomeDepart = nomeDepart;
    }

    public String getDescricaoDepart() {
        return descricaoDepart;
    }

    public void setDescricaoDepart(String descricaoDepart) {
        this.descricaoDepart = descricaoDepart;
    }

    /**
     * @return the gerenteid
     */
    public Long getGerenteid() {
        return gerenteid;
    }

    /**
     * @param gerenteid the gerenteid to set
     */
    public void setGerenteid(Long gerenteid) {
        this.gerenteid = gerenteid;
    }

    /**
     * @return the usuario
     */
    public Long getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
