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

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_w_controlli_preammissibilita_id;

@Entity
@Table(name = "DMT_W_CONTR_PREAM")
@IdClass(Dmt_w_controlli_preammissibilita_id.class)
public class Dmt_w_controlli_preammissibilita implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6971116035802038379L;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	/**
	 * Identificativo univoco associato all'esecuzione
	 */
	private Dmt_t_sessione idSessione;
	
	@Id
	@Column(name = "nome_classe_calcolo")
	@NotNull
	/**
	 * nome del calcolo eseguito
	 */
	private String nomeClasseCalcolo;

	@Id
	@Column(name = "id_intervento")
	@NotNull
	/**
	 * codice intervento
	 */
	private Long idIntervento;

	@Id
	@Column(name = "ordine_esecuzione")
	private String ordineEsecuzione;

	public String getNomeClasseCalcolo() {
		return nomeClasseCalcolo;
	}

	/**
	 * Metodo getter che ritorna il codice intervento
	 * @return idIntervento codice intervento
	 */
	public Long getIdIntervento() {
		return idIntervento;
	}

	public String getOrdineEsecuzione() {
		return ordineEsecuzione;
	}

	public void setOrdineEsecuzione(String ordineEsecuzione) {
		this.ordineEsecuzione = ordineEsecuzione;
	}

	/**
	 * Metodo getter che ritorna l'identificativo univoco associato all'esecuzione
	 * @return idSessione identificativo univoco associato all'esecuzione
	 */
	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	/**
	 * Metodo setter che imposta l'identificativo univoco associato all'esecuzione.
	 * <b>ATTENZIONE</b> l'identificativo univoco associato all'esecuzione viene 
	 * impostato automaticamente.
	 * @param sessione identificativo univoco associato all'esecuzione.
	 */
	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

	/**
	 * Metodo setter che imposta il nome del calcolo eseguito
	 * @param nomeClasseCalcolo nome del calcolo eseguito
	 */
	public void setNomeClasseCalcolo(String nomeClasseCalcolo) {
		this.nomeClasseCalcolo = nomeClasseCalcolo;
	}

	/**
	 * Metodo setter che imposta il codice intervento
	 * @param idIntervento codice intervento
	 */
	public void setIdIntervento(Long idIntervento) {
		this.idIntervento = idIntervento;
	}

}
