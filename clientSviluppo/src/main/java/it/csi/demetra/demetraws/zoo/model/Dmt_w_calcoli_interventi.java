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

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_w_calcoli_interventi_id;

@Entity
@Table(name = "DMT_W_CALCOLI_INTERVENTI")
@IdClass(Dmt_w_calcoli_interventi_id.class)
public class Dmt_w_calcoli_interventi implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2204240524598028161L;

	@Id
	@Column(name = "id_sessione")
	/**
	 * Identificativo univoco associato all'esecuzione
	 */
	private Long idSessione;

	@Id
	@Column(name = "id_gestore")
	@NotNull
	private Long idGestore;

	@Id
	@Column(name = "id_intervento")
	@NotNull
	/**
	 * Codice intervento
	 */
	private Long idIntervento;

	@Id
	@Column(name = "ordine_esecuzione")
	private String ordineEsecuzione;

	public Long getIdGestore() {
		return idGestore;
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

	/**
	 * Metodo getter che ritorna l'identificativo univoco associato all'esecuzione
	 * @return idSessione identificativo univoco associato all'esecuzione
	 */
	public Long getIdSessione() {
		return idSessione;
	}

	/**
	 * Metodo setter che imposta l'identificativo univoco associato all'esecuzione.
	 * <b>ATTENZIONE</b> questo metodo non viene utilizzato in quanto l'identificativo univoco
	 * associato all'esecuzione viene impostato automaticamente. @see Dmt_t_sessione
	 * @param sessione identificativo univoco associato all'esecuzione
	 */
	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione.getIdSessione();
	}

	public void setIdGestore(Long idGestore) {
		this.idGestore = idGestore;
	}

	/**
	 * Metodo setter che imposta il codice intervento
	 * @param idIntervento codice intervento
	 */
	public void setIdIntervento(Long idIntervento) {
		this.idIntervento = idIntervento;
	}

	public void setOrdineEsecuzione(String ordineEsecuzione) {
		this.ordineEsecuzione = ordineEsecuzione;
	}

}
