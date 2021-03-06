package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Tzoo_circuiti_qualita_id;

@Entity
@Table(name = "DMT_W_TZOO_CIRCUITI_QUALITA")
@IdClass(Dmt_t_Tzoo_circuiti_qualita_id.class)
public class Dmt_t_Tzoo_circuiti_qualita implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -9146410290916979377L;


	@MapsId
	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	private Dmt_t_sessione idSessione;

	@Id
	@Column(name = "CUAA")
	@NotNull
	/*
	 * Id fiscale del proprietario e/o del detentore di un allevamento va cambiato
	 * in 4000 in oracle
	 */
	private String cuaa;

	/*
	 * ID dell'allevamento in BDN
	 */
	@Id
	@Column(name = "ID_ALLEV_BDN")
	private String id_allev_bdn;

	/*
	 * Codice aziendale dell' allevamento
	 */
	@Column(name = "COD_ALLEVAMENTO")
	private String cod_allevamento;

	/*
	 * Data iniziale del periodo di adesione al circuito di qualita
	 */
	@Column(name = "DATA_INIZIO")
	@Temporal(TemporalType.DATE)
	private Date data_inizio;

	/*
	 * Data finale del periodo di adesione al circuito di qualita
	 */
	@Column(name = "DATA_FINE")
	@Temporal(TemporalType.DATE)
	private Date data_fine;

	@Column(name = "COD_CAT_CQ")
	private String cod_cat_cq;

	@Id
	@Column(name = "SCO_CAT_CQ")
	@NotNull
	private String sco_cat_cq;

	@Column(name = "COD_DEMON_CQ")
	private String cod_denom_cq;

	@Id
	@Column(name = "SCO_DEMON_CQ")
	@NotNull
	private String sco_denom_cq;

	@Column(name = "STRUTTURA")
	private String struttura;

	/*
	 * Struttura di controllo
	 */
	@Column(name = "PEC_STRUTTURA")
	private String pec_struttura;

	@Column(name = "REGIONE_SOCIALE_AZIENDA")
	private String ragione_sociale_azienda;

	public String getId_allev_bdn() {
		return id_allev_bdn;
	}

	public void setId_allev_bdn(String id_allev_bdn) {
		this.id_allev_bdn = id_allev_bdn;
	}

	public String getCod_allevamento() {
		return cod_allevamento;
	}

	public void setCod_allevamento(String cod_allevamento) {
		this.cod_allevamento = cod_allevamento;
	}

	public Date getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}

	public Date getData_fine() {
		return data_fine;
	}

	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}

	public String getCod_cat_cq() {
		return cod_cat_cq;
	}

	public void setCod_cat_cq(String cod_cat_cq) {
		this.cod_cat_cq = cod_cat_cq;
	}

	public String getCod_denom_cq() {
		return cod_denom_cq;
	}

	public void setCod_denom_cq(String cod_denom_cq) {
		this.cod_denom_cq = cod_denom_cq;
	}

	public String getStruttura() {
		return struttura;
	}

	public void setStruttura(String struttura) {
		this.struttura = struttura;
	}

	public String getPec_struttura() {
		return pec_struttura;
	}

	public void setPec_struttura(String pec_struttura) {
		this.pec_struttura = pec_struttura;
	}

	public String getRagione_sociale_azienda() {
		return ragione_sociale_azienda;
	}

	public void setRagione_sociale_azienda(String ragione_sociale_azienda) {
		this.ragione_sociale_azienda = ragione_sociale_azienda;
	}

	public String getCuaa() {
		return cuaa;
	}

	public String getSco_cat_cq() {
		return sco_cat_cq;
	}

	public String getSco_denom_cq() {
		return sco_denom_cq;
	}

	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public void setSco_cat_cq(String sco_cat_cq) {
		this.sco_cat_cq = sco_cat_cq;
	}

	public void setSco_denom_cq(String sco_denom_cq) {
		this.sco_denom_cq = sco_denom_cq;
	}

}