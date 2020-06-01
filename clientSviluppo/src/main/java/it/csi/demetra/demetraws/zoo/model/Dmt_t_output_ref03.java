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
import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_ref03_id;

@Entity
@Table(name = "Dmt_t_output_ref03")
@IdClass(Dmt_t_output_ref03_id.class)
public class Dmt_t_output_ref03 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3035054461744829200L;
	
	@MapsId
	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	private Dmt_t_sessione idSessione;

	@Id
	@Column(name = "cuaa")
	private String cuaa;

	@Id
	@Column(name = "anno_campagna")
	private Integer annoCampagna;

	@Id
	@Column(name = "intervento")
	private String intervento;
	
	@Column(name = "importo_pagato")
	private Double importoPagato;
	
	@Column(name = "capi_pagabili")
	private Double capiPagabili;
	
	@Column(name = "percentuale_riduzione")
	private Double percentualeRiduzione;
	
	@Column(name = "esito")
	private Double esito;
	
	@Column(name = "capi_accertati")
	private Integer capiAccertati;
	
	@Column(name = "capi_anomali")
	private Integer capiAnomali;
	
	@Column(name = "capi_richiesti")
	private Integer capiRichiesti;
	
	@Column(name = "diff_richiesti_accertati", nullable = true)
	private Integer differenzaCapiRichiestiAccertati;

	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
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

	public Double getImportoPagato() {
		return importoPagato;
	}

	public void setImportoPagato(Double importoPagato) {
		this.importoPagato = importoPagato;
	}

	public Double getCapiPagabili() {
		return capiPagabili;
	}

	public void setCapiPagabili(Double capiPagabili) {
		this.capiPagabili = capiPagabili;
	}

	public Double getPercentualeRiduzione() {
		return percentualeRiduzione;
	}

	public void setPercentualeRiduzione(Double percentualeRiduzione) {
		this.percentualeRiduzione = percentualeRiduzione;
	}

	public Double getEsito() {
		return esito;
	}

	public void setEsito(Double esito) {
		this.esito = esito;
	}

	public Integer getCapiAccertati() {
		return capiAccertati;
	}

	public void setCapiAccertati(Integer capiAccertati) {
		this.capiAccertati = capiAccertati;
	}

	public Integer getCapiAnomali() {
		return capiAnomali;
	}

	public void setCapiAnomali(Integer capiAnomali) {
		this.capiAnomali = capiAnomali;
	}

	public Integer getCapiRichiesti() {
		return capiRichiesti;
	}

	public void setCapiRichiesti(Integer capiRichiesti) {
		this.capiRichiesti = capiRichiesti;
	}

	public Integer getDifferenzaCapiRichiestiAccertati() {
		return differenzaCapiRichiestiAccertati;
	}

	public void setDifferenzaCapiRichiestiAccertati(Integer differenzaCapiRichiestiAccertati) {
		this.differenzaCapiRichiestiAccertati = differenzaCapiRichiestiAccertati;
	}
}
