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
	private Dmt_t_sessione idSessione;
	
	@Id
	@Column(name = "nome_classe_calcolo", length = 30)
	@NotNull
	private String nomeClasseCalcolo;

	@Id
	@Column(name = "id_intervento")
	@NotNull
	private Long idIntervento;

	@Id
	@Column(name = "ordine_esecuzione", length = 10)
	private String ordineEsecuzione;

	public String getNomeClasseCalcolo() {
		return nomeClasseCalcolo;
	}

	public Long getIdIntervento() {
		return idIntervento;
	}

	public String getOrdineEsecuzione() {
		return ordineEsecuzione;
	}

	public void setOrdineEsecuzione(String ordineEsecuzione) {
		this.ordineEsecuzione = ordineEsecuzione;
	}

	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

	public void setNomeClasseCalcolo(String nomeClasseCalcolo) {
		this.nomeClasseCalcolo = nomeClasseCalcolo;
	}

	public void setIdIntervento(Long idIntervento) {
		this.idIntervento = idIntervento;
	}

}
