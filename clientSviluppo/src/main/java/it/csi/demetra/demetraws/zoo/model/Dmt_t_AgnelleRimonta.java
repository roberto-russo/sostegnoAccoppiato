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

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_AgnelleRimonta_id;

@Entity
@Table(name = "DMT_T_AGNELLE_RIMONTA")
@IdClass(Dmt_t_AgnelleRimonta_id.class)
public class Dmt_t_AgnelleRimonta implements Serializable {

	private static final long serialVersionUID = 5643073399146782350L;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	 /**
     * id univoco associato all'istanza di sessione.
     */
	private Dmt_t_sessione idSessione;

	@Id
	/**
	 * Codice fiscale del richiedente
	 */
	private String cuaa;

	@Column(name = "esito")
	/**
	 * esito del controllo. Può essere positivo o negativo.
	 */
	private String esito;

	@Column(name = "qt_capi_premio")
	/**
	 * la quota effettiva dei capi ammessi a premio.
	 */
	private Double quotaCapiPremio;

	@Column(name = "motivazioni")
	/**
	 * nel caso in cui l'esito risulta essere negativo, verrà 
	 * valorizzato il campo motivazioni con le motivazioni del
	 * fallimento.
	 */
	private String motivazioni;

	@Column(name = "anno_campagna")
	@NotNull
	/**
	 * Anno della campagna premi per cui si è formulata la
	 * richiesta di estrazione
	 */
	private Integer annoCampagna;

	@Column(name = "codice_intervento")
	@NotNull
	/**
	 * Codice intervento, ovvero codice del premio per il
     * quale si richiede l’estrazione dei capi.
	 */
	private String codiceIntervento;

	public Dmt_t_AgnelleRimonta() {
	}

	/**
	 * metodo getter che ritorna la sessione.
	 * @return sessione codice di sessione associato all'esecuzione.
	 */
	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	/**
	 * metodo setter che imposta la sessione.
	 * @param sessione codice di sessione associato all'esecuzione
	 */
	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

	/**
	 * metodo getter che ritorna il codice fiscale del richiedente
	 * @return cuaa codice fiscale del richiedente
	 */
	public String getCuaa() {
		return cuaa;
	}

	/**
	 * metodo setter che imposta il cuaa
	 * @param cuaa codice fiscale del richiedente
	 */
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	/**
	 * metodo getter che ritorna l'esito
	 * @return esito
	 */
	public String getEsito() {
		return esito;
	}

	/**
	 * metodo setter che imposta l'esito
	 * @param esito
	 */
	public void setEsito(String esito) {
		this.esito = esito;
	}

	/**
	 * metodo getter che ritorna la quota capi premio
	 * @return quotaCapiPremio
	 */
	public Double getQuotaCapiPremio() {
		return quotaCapiPremio;
	}

	/**
	 * metodo setter che imposta la quotaCapiPremio
	 * @param quotaCapiPremio
	 */
	public void setQuotaCapiPremio(Double quotaCapiPremio) {
		this.quotaCapiPremio = quotaCapiPremio;
	}

	/**
	 * metodo getter che ritorna le motivazioni
	 * @return motivazioni
	 */
	public String getMotivazioni() {
		return motivazioni;
	}

	/**
	 * metodo setter che imposta le motivazioni
	 * @param motivazioni
	 */
	public void setMotivazioni(String motivazioni) {
		this.motivazioni = motivazioni;
	}

	/**
	 * metodo getter che ritorna l'anno campagna
	 * @return annoCampagna anno della campagna premi per cui si è formulata la
	 * richiesta di estrazione
	 */
	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	/**
	 * metodo setter che imposta l'anno campagna
	 * @param annoCampagna anno della campagna premi per cui si è formulata la
	 * richiesta di estrazione 
	 */
	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	/**
	 * metodo getter che ritorna il codiceIntervento
	 * @return codiceIntervento il codice del premio per il
     * quale si richiede l’estrazione dei capi.
	 */
	public String getCodiceIntervento() {
		return codiceIntervento;
	}

	/**
	 * metodo setter che imposta il codiceIntervento
	 * @param codiceIntervento codiceIntervento il codice del premio per il
     * quale si richiede l’estrazione dei capi.
	 */
	public void setCodiceIntervento(String codiceIntervento) {
		this.codiceIntervento = codiceIntervento;
	}
}
