package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_controlli_id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DMT_T_OUTPUT_CONTROLLI")
@IdClass(Dmt_t_output_controlli_id.class)
public class Dmt_t_output_controlli implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -81796758558035640L;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "sessione", nullable = false)
	private Dmt_t_sessione sessione;

	@Id
	@Column(name = "cuaa")
	private String cuaa;

	@Id
	@Column(name = "anno_campagna")
	private Integer annoCampagna;

	@Id
	@Column(name = "intervento")
	private String intervento;

	@Column(name = "capi_richiesti")
	private Integer capiRichiesti;

	@Column(name = "capi_ammissibili")
	private Integer capiAmmissibili;

	public Dmt_t_sessione getSessione() {
		return sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public String getCuaa() {
		return cuaa;
	}

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	public String getIntervento() {
		return intervento;
	}

	public void setIntervento(String intervento) {
		this.intervento = intervento;
	}

	public Integer getCapiRichiesti() {
		return capiRichiesti;
	}

	public void setCapiRichiesti(Integer capiRichiesti) {
		this.capiRichiesti = capiRichiesti;
	}

	public Integer getCapiAmmissibili() {
		return capiAmmissibili;
	}

	public void setCapiAmmissibili(Integer capiAmmissibili) {
		this.capiAmmissibili = capiAmmissibili;
	}

}
