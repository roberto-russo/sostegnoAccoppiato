package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_beneficiario_capi_doppi_id;

@Entity
@Table(name = "DMT_T_BENEFICIARIO_CAPI_DOPPI")
@IdClass(Dmt_t_beneficiario_capi_doppi_id.class)
public class Dmt_t_beneficiario_capi_doppi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7772655255723264279L;

	
	@Id
	@Column(name = "ANNO_CAMPAGNA")
	private Integer annoCampagna;
	
	@Id
	@Column(name = "CODICE_INTERVENTO")
	private String codiceIntervento;
	
	@Column(name = "CUAA")
	private String cuaa;
	
	@Id
	@Column(name ="ID_CAPO")
	private Long idCapo;

	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	public String getCodiceIntervento() {
		return codiceIntervento;
	}

	public void setCodiceIntervento(String codiceIntervento) {
		this.codiceIntervento = codiceIntervento;
	}

	public String getCuaa() {
		return cuaa;
	}

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public Long getIdCapo() {
		return idCapo;
	}

	public void setIdCapo(Long idCapo) {
		this.idCapo = idCapo;
	}
}
