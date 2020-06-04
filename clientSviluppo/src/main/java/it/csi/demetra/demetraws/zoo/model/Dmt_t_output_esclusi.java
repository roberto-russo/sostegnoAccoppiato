package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_esclusi_id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "DMT_T_OUTPUT_ESCLUSI")
@IdClass(Dmt_t_output_esclusi_id.class)
public class Dmt_t_output_esclusi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7409416797878667132L;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	private Dmt_t_sessione idSessione;

	@Id
	@Column(name = "calcolo")
	private String calcolo;

	@Id
	@Column(name = "capo_id")
	private Long capoId;

	@Column(name = "motivazione_esclusione")
	private String motivazioneEsclusione;

	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

	public String getCalcolo() {
		return calcolo;
	}

	public void setCalcolo(String calcolo) {
		this.calcolo = calcolo;
	}

	public Long getCapoId() {
		return capoId;
	}

	public void setCapoId(Long capoId) {
		this.capoId = capoId;
	}

	public String getMotivazioneEsclusione() {
		return motivazioneEsclusione;
	}

	public void setMotivazioneEsclusione(String motivazioneEsclusione) {
		this.motivazioneEsclusione = motivazioneEsclusione;
	}

}
