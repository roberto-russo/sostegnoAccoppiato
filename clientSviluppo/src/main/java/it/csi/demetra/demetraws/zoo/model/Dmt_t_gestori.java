package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_gestori_id;

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
