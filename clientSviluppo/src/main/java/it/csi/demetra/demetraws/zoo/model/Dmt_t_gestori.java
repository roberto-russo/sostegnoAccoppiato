package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_gestori_id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "DMT_T_GESTORI")
@IdClass(Dmt_t_gestori_id.class)
public class Dmt_t_gestori implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8713738907975123618L;

    @Id
    @Column(name = "id_sessione")
    private Long idSessione;


    @Column(name = "ID")
    @NotNull
    private Long id;

    @Id
    @Column(name = "id_tipologia")
    @NotNull
    private Long id_tipologia;

    @Column(name = "nome_service")
    private String nomeService;

    public Long getId() {
        return id;
    }

    public Long getId_tipologia() {
        return id_tipologia;
    }

    public String getNomeService() {
        return nomeService;
    }

    public void setNomeService(String nomeService) {
        this.nomeService = nomeService;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione.getIdSessione();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_tipologia(Long id_tipologia) {
        this.id_tipologia = id_tipologia;
    }

}
