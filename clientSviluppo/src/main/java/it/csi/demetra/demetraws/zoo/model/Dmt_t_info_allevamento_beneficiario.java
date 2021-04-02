package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_info_allevamento_beneficiario_id;

@Entity
@Table(name="DMT_T_INFO_ALLEV_BENEFICIARIO")
@IdClass(Dmt_t_info_allevamento_beneficiario_id.class)
public class Dmt_t_info_allevamento_beneficiario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4534213914016275848L;
	
	@ManyToOne
	@JoinColumn(name="idSessione", nullable = false)
	private Dmt_t_sessione idSessione;
	
	@Id
	private Long idCapo;
	
	@Id
	private Long allevId;
	
	@Id
	private Integer annoCampagna;
	
	private String cuaa;
	
	
	public Dmt_t_info_allevamento_beneficiario() {
	}

	public Dmt_t_info_allevamento_beneficiario(Dmt_t_sessione idSessione, Long idCapo, Long allevId,
			Integer annoCampagna, String cuaa) {
		super();
		this.idSessione = idSessione;
		this.idCapo = idCapo;
		this.allevId = allevId;
		this.annoCampagna = annoCampagna;
		this.cuaa = cuaa;
	}

	public String getCuaa() {
		return cuaa;
	}

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione idSessione) {
		this.idSessione = idSessione;
	}

	public Long getIdCapo() {
		return idCapo;
	}

	public void setIdCapo(Long idCapo) {
		this.idCapo = idCapo;
	}

	public Long getAllevId() {
		return allevId;
	}

	public void setAllevId(Long allevId) {
		this.allevId = allevId;
	}

	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}	
}
