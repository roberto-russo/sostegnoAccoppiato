package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
	/**
	 * Identificativo univoco associato all'esecuzione
	 */
	private Dmt_t_sessione idSessione;

	@Id
	@Column(name = "cuaa")
	/**
	 * Codice fiscale del richiedente.
	 */
	private String cuaa;

	@Id
	@Column(name = "anno_campagna")
	/**
	 * Anno della campagna
	 */
	private Integer annoCampagna;

	@Id
	@Column(name = "intervento")
	/**
	 * Codice intervento
	 */
	private String intervento;
	
	@Column(name = "imp_pagato_lordo_decurt")
	/**
	 * importo pagato al richiedente.
	 */
	private BigDecimal importoPagatoLordoDecurtazione;
	
	@Column(name = "capi_pagabili")
	/**
	 * numero di capi ammessi al pagamento
	 */
	private BigDecimal capiPagabili;
	
	@Column(name = "percentuale_riduzione")
	/**
	 * percentuale di riduzione del pagamento del premio
	 */
	private BigDecimal percentualeRiduzione;
	
	@Column(name = "esito")
	private BigDecimal esito;
	
	@Column(name = "capi_accertati")
	/**
	 * Numero di capi accertati per il codice intervento
	 */
	private BigDecimal capiAccertati;
	
	@Column(name = "capi_anomali")
	/**
	 * capi anomali che non hanno superato i controlli e che non possono essere ammessi a premio
	 */
	private BigDecimal capiAnomali;
	
	@Column(name = "capi_richiesti")
	/**
	 * Capi richiesti a premio dal richiedente
	 */
	private BigDecimal capiRichiesti;
	
	@Column(name = "diff_richiesti_accertati", nullable = true)
	/**
	 * Differenza tra i capi richiesti e i capi ammessi a premio.
	 */
	private BigDecimal differenzaCapiRichiestiAccertati;
	
	@Column(name = "imp_pagato_netto_decurt")
	/**
	 * Importo pagato al netto della decurtazione calcolata.
	 */
	BigDecimal importoPagatoNettoDecurtazione;
	
	@Column(name = "percentuale_decurtazione")
	/**
	 * Percentuale di decurtazione calcolata.
	 */
	BigDecimal percentualeDecurtazione;
	
	@Column(name = "importo_a_recupero")
	private BigDecimal importoARecupero;
	
	
	public BigDecimal getImportoARecupero() {
		return importoARecupero;
	}

	public void setImportoARecupero(BigDecimal importoARecupero) {
		this.importoARecupero = importoARecupero;
	}

	/**
	 * Metodo getter che ritorna la percentuale di decurtazione calcolata.
	 * La percentuale di decurtazione e' calcolata in base ai giorni di ritardo
	 * di presentazione della domanda.
	 * @return percentualeDecurtazioneCalcolata percentuale di decurtazione del premio.
	 */
	public BigDecimal getPercentualeDecurtazione() {
		return percentualeDecurtazione;
	}

	/**
	 * Metodo setter che imposta la percentuale di decurtazione calcolata.
	 * La percentuale di decurtazione e' calcolata in base ai giorni di ritardo
	 * di presentazione della domanda.
	 * @param percentualeDecurtazione percentuale di decurtazione del premio.
	 */
	public void setPercentualeDecurtazione(BigDecimal percentualeDecurtazione) {
		this.percentualeDecurtazione = percentualeDecurtazione;
	}

	/**
	 * Metodo getter che ritorna l'importo pagato al netto della decurtazione calcolata.
	 * La decurtazione viene calcolata in base al numero di giorni di ritardo di presentazione della domanda.
	 * @return importoPagatoNettoDecurtazione importo pagato al netto della decurtazione calcolata.
	 */
	public BigDecimal getImportoPagatoNettoDecurtazione() {
		return importoPagatoNettoDecurtazione;
	}

	/**
	 * Metodo getter che ritorna l'importo pagato al netto della decurtazione calcolata.
	 * La decurtazione viene calcolata in base al numero di giorni di ritardo di presentazione della domanda.
	 * @param importoPagatoNettoDecurtazione importo pagato al netto della decurtazione calcolata.
	 */
	public void setImportoPagatoNettoDecurtazione(BigDecimal importoPagatoNettoDecurtazione) {
		this.importoPagatoNettoDecurtazione = importoPagatoNettoDecurtazione;
	}

	/**
	 * Metodo getter che imposta l'identificativo univoco associato all'esecuzione
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
	 * Metodo getter che ritorna il codice fiscale del richiedente.
	 * @return cuaa codice fiscale del richiedente.
	 */
	public String getCuaa() {
		return cuaa;
	}

	/**
	 * Metodo setter che imposta il codice fiscale del richiedente.
	 * @param cuaa codice fiscale del richiedente.
	 */
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	/**
	 * Metodo getter che ritorna l'anno della campagna.
	 * @return annoCampagna anno della campagna.
	 */
	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	/**
	 * Metodo setter che imposta l'anno della campagna.
	 * @param annoCampagna anno della campagna.
	 */
	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	/**
	 * Metodo getter che ritorna il codice intervento.
	 * @return intervento codice intervento.
	 */
	public String getIntervento() {
		return intervento;
	}

	/**
	 * Metodo setter che imposta il codice intervento.
	 * @param intervento codice intervento
	 */
	public void setIntervento(String intervento) {
		this.intervento = intervento;
	}

	/**
	 * Metodo getter che ritorna l'importo pagato al richiedente
	 * @return importoPagato importo pagato al richiedente.
	 */
	public BigDecimal getImportoPagatoLordoDecurtazione() {
		return importoPagatoLordoDecurtazione;
	}

	/**
	 * Metodo setter che imposta l'importo pagato al richiedente.
	 * @param importoPagatoLordoDecurtazione importo pagato al richiedente.
	 */
	public void setImportoPagatoLordoDecurtazione(BigDecimal importoPagatoLordoDecurtazione) {
		this.importoPagatoLordoDecurtazione = importoPagatoLordoDecurtazione;
	}

	/**
	 * Metodo getter che ritorna il numero di capi ammessi al pagamento
	 * @return capiPagaBili numero di capi ammessi al premio
	 */
	public BigDecimal getCapiPagabili() {
		return capiPagabili;
	}

	/**
	 * Metodo setter che imposta il numero di capi ammessi al pagamento.
	 * @param capiPagabili numero di capi ammessi al pagamento.
	 */
	public void setCapiPagabili(BigDecimal capiPagabili) {
		this.capiPagabili = capiPagabili;
	}

	/**
	 * Metodo getter che ritorna la percentuale di riduzione del pagamento del premio
	 * @return percentualeRiduzione percentuale di riduzione del pagamento del premio
	 */
	public BigDecimal getPercentualeRiduzione() {
		return percentualeRiduzione;
	}

	/**
	 * Metodo setter che imposta la percentuale di riduzione del pagamento del premio
	 * @param percentualeRiduzione  percentuale di riduzione del pagamento del premio
	 */
	public void setPercentualeRiduzione(BigDecimal percentualeRiduzione) {
		this.percentualeRiduzione = percentualeRiduzione;
	}

	public BigDecimal getEsito() {
		return esito;
	}

	public void setEsito(BigDecimal esito) {
		this.esito = esito;
	}

	/**
	 * Metodo getter che ritorna il numero di capi accertati per il codice intervento
	 * @return capiAccertati numero di capi accertati per il codice intervento.
	 */
	public BigDecimal getCapiAccertati() {
		return capiAccertati;
	}

	/**
	 * Metodo setter che imposta il numero di capi accertati per il codice premio
	 * @param capiAccertati numero di capi accertati per il codice premio
	 */
	public void setCapiAccertati(BigDecimal capiAccertati) {
		this.capiAccertati = capiAccertati;
	}

	/**
	 * Metodo getter che ritorna il numero di capi anomali.
	 * @return capiAnomali numero di capi anomali, non ammessi per il pagamento a premio
	 */
	public BigDecimal getCapiAnomali() {
		return capiAnomali;
	}

	/**
	 * Metodo setter che imposta il numero di capi anomali.
	 * @param capiAnomali numero di capi anomali, non ammessi per il pagamento a premio
	 */
	public void setCapiAnomali(BigDecimal capiAnomali) {
		this.capiAnomali= capiAnomali;
	}

	/**
	 * Metodo getter che imposta il numero di capi richiesti dal richiedente.
	 * @return capiRichiesti numero di capi richiesti dal richiedente
	 */
	public BigDecimal getCapiRichiesti() {
		return capiRichiesti;
	}

	/**
	 * Metodo setter che imposta il numero di capi richiesti dal richiedente.
	 * @param capiRichiesti numero di capi richiesti dal richiedente.
	 */
	public void setCapiRichiesti(BigDecimal capiRichiesti) {
		this.capiRichiesti = capiRichiesti;
	}

	/**
	 * Metodo getter che ritorna la differenza tra il numero di capi richiesti ed il numero di capi ammissibili
	 * @return differenzaCapiRichiestiAccertati differenza tra il numero di capi richiesti ed il numero di capi ammissibili.
	 */
	public BigDecimal getDifferenzaCapiRichiestiAccertati() {
		return differenzaCapiRichiestiAccertati;
	}

	/**
	 * Metodo setter che imposta la differenza tra il numero di capi richiesti ed il numero di capi ammissibili
	 * @param differenzaCapiRichiestiAccertati differenza tra il numero di capi richiesti ed il numero di capi ammissibili
	 */
	public void setDifferenzaCapiRichiestiAccertati(BigDecimal differenzaCapiRichiestiAccertati) {
		this.differenzaCapiRichiestiAccertati = differenzaCapiRichiestiAccertati;
	}
}
