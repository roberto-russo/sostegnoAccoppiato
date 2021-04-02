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

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_clsPremio_Validazione_PP_id;

/**
 * Classe model con parametri di ingresso per il metodo getElencoCapiPremio2New
 *
 * @version 0.1 (02/04/2020)
 * @author bcsoft
 */
@Entity
@Table(name = "DMT_T_CLS_PREMIO_VALID_PP")
@IdClass(Dmt_t_clsPremio_Validazione_PP_id.class)
public class Dmt_t_clsPremio_Validazione_PP implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8112440981387660017L;

	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@Id
	@Column(name = "id_alle_bdn")
	@NotNull
	/**
	 * Identificativo univoco in BDN dell’allevamento che presenta richiesta di
	 * premio
	 */
	private Long IdAlleBDN;

	@Column(name = "codice_intervento")
	@NotNull
	/**
	 * Codice Intervento codificato nella tabella PREMI in BDN.
	 */
	private String codiceIntervento;

	@Column(name = "cuaa")
	@NotNull
	/**
	 * Identificativo Fiscale del soggetto che ha presentato la domanda
	 */
	private String cuaa;

	@Column(name = "anno_campagna")
	@NotNull
	/**
	 * Anno della campagna
	 */
	private Integer annoCampagna;

	@Column(name = "cuaa2")
	@NotNull
	/**
	 * Identificativo Fiscale del secondo soggetto subentrato al primo nella
	 * richiesta di premio
	 */
	private String cuaa2;

	/**
	 * Costruttore vuoto della classe
	 */
	public Dmt_t_clsPremio_Validazione_PP() {

	}

	/**
	 * Costruttore che serve a Impostare il parametro IdAlleBdn
	 * @param IdAlleBDN identificativo univoco in BDN dell’allevamento
	 */
	public Dmt_t_clsPremio_Validazione_PP(Long IdAlleBDN) {
		this.IdAlleBDN = IdAlleBDN;
	}

	/**
	 * Recupera identificativo univoco in BDN dell’allevamento
	 *
	 * @return idAlleBdn dentificativo univoco in BDN dell’allevamento
	 */
	public Long getIdAlleBDN() {
		return IdAlleBDN;
	}

	/**
	 * Recupera il codice Intervento codificato nella tabella PREMI in BDN.
	 *
	 * @return codiceIntervento il codice Intervento codificato nella tabella PREMI
	 *         in BDN.
	 */
	public String getCodiceIntervento() {
		return codiceIntervento;
	}

	/**
	 * Imposta Codice Intervento codificato nella tabella PREMI in BDN.
	 *
	 * @param codiceIntervento il codice Intervento codificato nella tabella PREMI
	 *                         in BDN.
	 */
	public void setCodiceIntervento(String codiceIntervento) {
		this.codiceIntervento = codiceIntervento;
	}

	/**
	 * Recupera l'identificativo Fiscale del soggetto che ha presentato la domanda
	 *
	 * @return cuaa identificativo Fiscale del soggetto che ha presentato la domanda
	 */
	public String getCuaa() {
		return cuaa;
	}

	/**
	 * Imposta l'identificativo Fiscale del soggetto che ha presentato la domanda
	 *
	 * @param cuaa identificativo Fiscale del soggetto che ha presentato la domanda
	 */
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	/**
	 * Recupera l'anno della campagna
	 *
	 * @return l'anno della campagna
	 */
	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	/**
	 * Imposta l'anno della campagna
	 *
	 * @param annoCampagna l'anno della campagna
	 */
	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	/**
	 * Recupera l'dentificativo Fiscale del secondo soggetto subentrato al primo
	 * nella richiesta di premio
	 *
	 * @return cuaa l'identeificativo fiscale del richiedente
	 */
	public String getCuaa2() {
		return cuaa2;
	}

	/**
	 * Imposta l'dentificativo Fiscale del secondo soggetto subentrato al primo
	 * nella richiesta di premio
	 *
	 * @param cuaa2 l'identeificativo fiscale del richiedente
	 */
	public void setCuaa2(String cuaa2) {
		this.cuaa2 = cuaa2;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione.getIdSessione();
	}

	public void setIdAlleBDN(Long idAlleBDN) {
		IdAlleBDN = idAlleBDN;
	}
}
