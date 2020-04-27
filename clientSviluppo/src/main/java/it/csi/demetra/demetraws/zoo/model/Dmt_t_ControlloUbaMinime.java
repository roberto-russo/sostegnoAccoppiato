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

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_Ref9903_id;

@Entity
@Table(name = "DMT_T_CONTROLLO_UBA_MINIME")
@IdClass(Dmt_d_Ref9903_id.class)
public class Dmt_t_ControlloUbaMinime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5957063405415650073L;

	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	private Dmt_t_sessione sessione;

	@Id
	private String cuaa;

	@Column(name = "esito")
	private String esito;

	@Column(name = "uba")
	private Double uba;

	@Column(name = "motivazioni", length = 1000)
	private String motivazioni;

	@Column(name = "anno_campagna")
	@NotNull
	private Long annoCampagna;

	@Column(name = "codice_intervento", length = 400)
	@NotNull
	private String codiceIntervento;

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

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public Double getUba() {
		return uba;
	}

	public void setUba(Double uba) {
		this.uba = uba;
	}

	public String getMotivazioni() {
		return motivazioni;
	}

	public void setMotivazioni(String motivazioni) {
		this.motivazioni = motivazioni;
	}

	public Long getAnnoCampagna() {
		return annoCampagna;
	}

	public void setAnnoCampagna(Long annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	public String getCodiceIntervento() {
		return codiceIntervento;
	}

	public void setCodiceIntervento(String codiceIntervento) {
		this.codiceIntervento = codiceIntervento;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}

}
