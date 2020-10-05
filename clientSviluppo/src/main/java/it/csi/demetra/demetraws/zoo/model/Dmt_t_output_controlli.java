package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_controlli_id;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

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
	@JoinColumn(name = "idSessione", nullable = false)
	/**
	 * Identificativo univodo associato all'esecuzione.
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
	 * Anno della campagna.
	 */
	private Integer annoCampagna;

	@Id
	@Column(name = "intervento")
	/**
	 * Codice premio
	 */
	private String intervento;

	@Column(name = "capi_richiesti")
	/**
	 * Numero di capi richiesti a premio dal richiedente.
	 */
	private BigDecimal capiRichiesti;

	@Column(name = "capi_ammissibili")
	/**
	 * capi ammessi a premio
	 */
	private BigDecimal capiAmmissibili;
	
	@Column(name = "capi_sanzionati")
	/**
	 * numero capi sanzionati
	 */
	private Integer capiSanzionati;

	public Integer getCapiSanzionati() {
		return capiSanzionati;
	}

	public void setCapiSanzionati(Integer capiSanzionati) {
		this.capiSanzionati = capiSanzionati;
	}
		
	/**
	 * Metodo getter che ritorna l'identificativo univoco associato all'esecuzione.
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
	 * @return cuaa Codice fiscale del richiedente.
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
	 * @param intervento codice intervento.
	 */
	public void setIntervento(String intervento) {
		this.intervento = intervento;
	}

	/**
	 * Metodo getter che ritorna il numero di capi richiesti dal richiedente.
	 * @return capiRichiesti numero di capi richiesti dal richiedente.
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
	 * Metodo getter che ritorna il numero di capi ammessi a premio.
	 * @return capiAmmissibili numero di capi ammessi a premio.
	 */
	public BigDecimal getCapiAmmissibili() {
		return capiAmmissibili;
	}

	/**
	 * Metodo setter che imposta il numero di capi ammessi a premio.
	 * @param capiAmmissibili numero di capi richiesti a premio.
	 */
	public void setCapiAmmissibili(BigDecimal capiAmmissibili) {
		this.capiAmmissibili = capiAmmissibili;
	}

}
