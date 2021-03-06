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
	/**
	 * Identificativo univoco associato all'esecuzione.
	 */
	private Dmt_t_sessione idSessione;

	@Id
	@Column(name = "calcolo")
	/**
	 * Calcolo intervento eseguito.
	 */
	private String calcolo;

	@Id
	@Column(name = "capo_id")
	/**
	 * identificativo univoco del capo animale.
	 */
	private Long capoId;

	@Column(name = "motivazione_esclusione")
	/**
	 * descrizione della motivazione dell'esclusione a premio.
	 */
	private String motivazioneEsclusione;

	/**
	 * Metodo getter che ritorna l'identificativo univoco associato all'esecuzione
	 * @return idSessione identificativo univoco associato all'esecuzione.
	 */
	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	/**
	 * Metodo setter che imposta l'identificativo univoco associato all'esecuzione.
	 * @param sessione identificativo univoco associato all'esecuzione.
	 */
	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

	/**
	 * Metodo getter che ritorna il calcolo intervento eseguito.
	 * @return calcolo calcolo intervento eseguito.
	 */
	public String getCalcolo() {
		return calcolo;
	}

	/**
	 * Metodo setter che imposta il calcolo intervento eseguito.
	 * @param calcolo calcolo intervento eseguito.
	 */
	public void setCalcolo(String calcolo) {
		this.calcolo = calcolo;
	}

	/**
	 * Metodo getter che ritorna l'identificativo univoco del capo animale.
	 * @return capoId identificativo univoco del capo animale.
	 */
	public Long getCapoId() {
		return capoId;
	}

	/**
	 * Metodo setter che imposta l'identificativo univoco del capo animale.
	 * @param capoId identificativo univoco del capo animale.
	 */
	public void setCapoId(Long capoId) {
		this.capoId = capoId;
	}

	/**
	 * Metodo getter che ritorna la descrizione della motivazione dell'esclusione a premio.
	 * @return motivazioneEsclusione descrizione della motivazione dell'esclusione a premio.
	 */
	public String getMotivazioneEsclusione() {
		return motivazioneEsclusione;
	}

	/**
	 * Metodo setter che imposta la descrizione della motivazione dell'esclusione a premio.
	 * @param motivazioneEsclusione descrizione della motivazione dell'esclusione a premio.
	 */
	public void setMotivazioneEsclusione(String motivazioneEsclusione) {
		this.motivazioneEsclusione = motivazioneEsclusione;
	}

}
