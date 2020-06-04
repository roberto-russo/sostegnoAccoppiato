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

	@MapsId
	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	private Dmt_t_sessione idSessione;

	@Id
	@Column(name = "id_gestore")
	@NotNull
	private Long idGestore;

	@Id
	@Column(name = "id_intervento")
	@NotNull
	private Long idIntervento;

	@Id
	@Column(name = "ordine_esecuzione")
	private String ordineEsecuzione;

	public Long getIdGestore() {
		return idGestore;
	}

	public Long getIdIntervento() {
		return idIntervento;
	}

	public String getOrdineEsecuzione() {
		return ordineEsecuzione;
	}

	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

	public void setIdGestore(Long idGestore) {
		this.idGestore = idGestore;
	}

	public void setIdIntervento(Long idIntervento) {
		this.idIntervento = idIntervento;
	}

	public void setOrdineEsecuzione(String ordineEsecuzione) {
		this.ordineEsecuzione = ordineEsecuzione;
	}

}
