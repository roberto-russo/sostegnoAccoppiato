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

import org.hibernate.annotations.ColumnDefault;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Tlatte_mensile_arpea_id;

@Entity
@Table(name = "DMT_T_TLATTE_MENSILE_ARPEA")
/**
 * Tabella che raccoglie i dati quantitativi, MENSILI, relativi alle produzioni
 * e alle quote latte inviati da ARPEA
 *
 * @version 0.1 (02/04/2020)
 * @author Bcsoft
 *
 */
@IdClass(Dmt_t_Tlatte_mensile_arpea_id.class)
public class Dmt_t_Tlatte_mensile_arpea implements Serializable {

	private static final long serialVersionUID = -3584487512539450047L;

	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	private Dmt_t_sessione sessione;

	@Column(name = "primo_anno_campagna")
	/**
	 * Anno della campagna rispetto alla quale si sta effettuando la richiesta
	 */
	private Long primoAnnoCampagna;

	@Id
	@Column(name = "anno_solare", unique = true)
	/**
	 * Anno solare della campagna rispetto alla quale si sta effettuando la
	 * richiesta.
	 */
	private Long annoSolare;

	@Column(name = "mese", length = 10)
	/**
	 * Mese di riferimento
	 */
	private String mese;

	@Id
	@Column(name = "matr_acquirente", unique = true)
	/**
	 * Matricola settoriale acquirente
	 */
	private Long matrAcquirente;

	@Column(name = "cuaa_acquirente", length = 16)
	/**
	 * Identificativo Fiscale del soggetto che ha presentato la domanda
	 */
	private String cuaaAcquirente;

	@Column(name = "denom_acquirente", length = 150)
	/**
	 * Denominazione dell'acquirente
	 */
	private String denomAcquirente;

	@Id
	@Column(name = "matr_azienda", unique = true)
	/**
	 * Matricola settoriale azienda
	 */
	private Long matrAzienda;

	@Column(name = "cuaa_azienda", length = 16)
	/**
	 * Identificativo fiscale dell'azienda
	 */
	private String cuaaAzienda;

	@Column(name = "denom_azienda", length = 500)
	/**
	 * Denominazione azienda
	 */
	private String denomAzienda;

	@Column(name = "qt_consegnata")
	/**
	 * Quantità consegnata
	 */
	private Long qtConsegnata;

	@Column(name = "ten_mat_grassa_periodo", length = 11, precision = 2)
	/**
	 * Tenore di materia grassa di periodo
	 */
	private double tentMatGrassaPeriodo;

	@Id
	@Column(name = "anno_riferimento", unique = true, length = 4)
	/**
	 * Anno di riferimento dei dati ricevuti da Arpea
	 */
	private Long annoRiferimentro;

	/*
	 * Flag che indica se le Produzioni del CUAA sono state oggetto di subentro con
	 * le produzioni di altri CUAA
	 */
	@Column(name = "flag_subentro", length = 1)
	private String flagSubentro;

	@Column(name = "cod_mese", length = 3)
	@ColumnDefault("'MES'")
	/**
	 * Codice mese della decodifca_sop = ''MES''
	 */
	private String codMese;

	@Id
	@Column(name = "sco_mese", length = 3, unique = true)
	/**
	 * Sotto codice mese della decodifca_sop
	 */
	private String scoMese;

	/**
	 * Metodo get che ritorna il primo Anno della campagna rispetto alla quale si
	 * sta effettuando la richiesta
	 *
	 * @return primoAnnoCampagna primo anno della campagna rispetto alla quale si
	 *         sta effettuando la richiesta di tipo long
	 */
	public Long getPrimoAnnoCampagna() {
		return primoAnnoCampagna;
	}

	/**
	 * Metodo set che setta il primo anno della campagna rispetto alla quale si sta
	 * effettuando la richiesta
	 *
	 * @param primoAnnoCampagna primo anno della campagna rispetto alla quale si sta
	 *                          effettuando la richiesta di tipo long.
	 */
	public void setPrimoAnnoCampagna(Long primoAnnoCampagna) {
		this.primoAnnoCampagna = primoAnnoCampagna;
	}

	/**
	 * Metodo get che ritorna l'Anno solare della campagna rispetto alla quale si
	 * sta effettuando la richiesta.
	 *
	 * @return annosolare anno solare della campagna rispetto alla quale si sta
	 *         effettuando la richiesta di tipo long.
	 */
	public Long getAnnoSolare() {
		return annoSolare;
	}

	/**
	 * Metodo set che setta l'anno solare della campagna rispetto alla quale si sta
	 * effettuando la richiesta.
	 *
	 * @param annoSolare anno solare della campagna rispetto alla quale si sta
	 *                   effettuando la richiesta di tipo long.
	 */
	public void setAnnoSolare(Long annoSolare) {
		this.annoSolare = annoSolare;
	}

	/**
	 * Metodo get che ritorna il mese di riferimento.
	 *
	 * @return mese mese di riferimento di tpo String.
	 */
	public String getMese() {
		return mese;
	}

	/**
	 * Metodo set che setta il mese di riferimento
	 *
	 * @param mese mese di riferimento di tipo String
	 */
	public void setMese(String mese) {
		this.mese = mese;
	}

	/**
	 * Metodo get che ritorna la matricola settoriale dell'acquirente
	 *
	 * @return matrAquirente matricola settoriale dell'acaquirente di tipo long.
	 */
	public Long getMatrAcquirente() {
		return matrAcquirente;
	}

	/**
	 * Metodo set che setta la matricola settoriale dell'acquirente.
	 *
	 * @param matrAcquirente matricola settoriale dell'acquirente di tipo long.
	 */
	public void setMatrAcquirente(Long matrAcquirente) {
		this.matrAcquirente = matrAcquirente;
	}

	/**
	 * Metodo get che ritorna l'identificativo fiscale dell'acquirente.
	 *
	 * @return cuaaAquirente identificativo fiscale dell'aquirente di tipo String.
	 */
	public String getCuaaAcquirente() {
		return cuaaAcquirente;
	}

	/**
	 * Metodo set che setta l'identificativo fiscale dell'acquirente.
	 *
	 * @param cuaaAcquirente identificativo fiscale dell'aquirente di tipo String.
	 */
	public void setCuaaAcquirente(String cuaaAcquirente) {
		this.cuaaAcquirente = cuaaAcquirente;
	}

	/**
	 * Metodo get che ritorna la denominazione dell'acquirente.
	 *
	 * @return denomAquirente denominazione dell'acquirente di tipo String.
	 */
	public String getDenomAcquirente() {
		return denomAcquirente;
	}

	/**
	 * Metodo set che setta la denominazione dell'aquirente.
	 *
	 * @param denomAcquirente denominazione dell'acquirente di tipo String.
	 */
	public void setDenomAcquirente(String denomAcquirente) {
		this.denomAcquirente = denomAcquirente;
	}

	/**
	 * Metodo get che ritorna la matricola aziendale
	 *
	 * @return matrAzienda matricola aziendale di tipo long.
	 */
	public Long getMatrAzienda() {
		return matrAzienda;
	}

	/**
	 * Metodo set che setta la matricola aziendale.
	 *
	 * @param matrAzienda matricola aziendale.
	 */
	public void setMatrAzienda(Long matrAzienda) {
		this.matrAzienda = matrAzienda;
	}

	/**
	 * Metodo get che ritorna l'identificativo fiscale dell'azienda.
	 *
	 * @return cuaaAzienda identificativo fiscale dell'azienda di tipo Stirng.
	 */
	public String getCuaaAzienda() {
		return cuaaAzienda;
	}

	/**
	 * Metodo set che setta l'identificativo fiscale dell'azienda.
	 *
	 * @param cuaaAzienda identificativo fiscale dell'azienda di tipo Stirng.
	 */
	public void setCuaaAzienda(String cuaaAzienda) {
		this.cuaaAzienda = cuaaAzienda;
	}

	/**
	 * Metodo get che ritorna la denominazione dell'azienda.
	 *
	 * @return denomAzienda denominazione dell'azienda di tipo String.
	 */
	public String getDenomAzienda() {
		return denomAzienda;
	}

	/**
	 * metodo set che setta la denominazione dell'azienda.
	 *
	 * @param denomAzienda denominazione dell'azienda di tipo String
	 */
	public void setDenomAzienda(String denomAzienda) {
		this.denomAzienda = denomAzienda;
	}

	/**
	 * Metodo get che ritorna la quantità consegnata.
	 *
	 * @return qtConsegnata quantità consegnata di tipo long.
	 */
	public Long getQtConsegnata() {
		return qtConsegnata;
	}

	/**
	 * Metodo set che setta la quantità consegnata.
	 *
	 * @param qtConsegnata quantità consegnata.
	 */
	public void setQtConsegnata(Long qtConsegnata) {
		this.qtConsegnata = qtConsegnata;
	}

	/**
	 * Metodo get che ritorna il Tenore di materia grassa di periodo.
	 *
	 * @return tentMatGrassaPeriodo tenore di materia grassa di periodo.
	 */
	public double getTentMatGrassaPeriodo() {
		return tentMatGrassaPeriodo;
	}

	/**
	 * Metodo set che setta il tenore di materia grassa di perodo.
	 *
	 * @param tentMatGrassaPeriodo tenore di materia grassa di periodo.
	 */
	public void setTentMatGrassaPeriodo(double tentMatGrassaPeriodo) {
		this.tentMatGrassaPeriodo = tentMatGrassaPeriodo;
	}

	/**
	 * Metodo get che ritorna l'anno di riferimento
	 *
	 * @return annoRiferimento anno di riferimento.
	 */
	public Long getAnnoRiferimentro() {
		return annoRiferimentro;
	}

	/**
	 * Metodo set che setta l'anno di riferimento.
	 *
	 * @param annoRiferimentro anno di riferimento.
	 */
	public void setAnnoRiferimentro(Long annoRiferimentro) {
		this.annoRiferimentro = annoRiferimentro;
	}

	/**
	 * Metodo get che ritorna il flag che indica se le Produzioni del CUAA sono
	 * state oggetto di subentro con le produzioni di altri CUAA
	 *
	 * @return flagSubentro flag che indica se le produzioni del cuua sono state
	 *         oggetto di subentro con le produzioni di altri cuua.
	 */
	public String getFlagSubentro() {
		return flagSubentro;
	}

	/**
	 * Metodo set che setta il flag che indica se le produzioni del cuaa sono state
	 * oggetto di subentro con le produzioni di altri cuaa.
	 *
	 * @param flagSubentro flag che indica se le produzioni del cuuaa sono state
	 *                     oggetto di subentro con le produzioni di altri cuaa.
	 */
	public void setFlagSubentro(String flagSubentro) {
		this.flagSubentro = flagSubentro;
	}

	/**
	 * Metodo get che ritorna il Codice mese della decodifca_sop = ''MES''
	 *
	 * @return codice mese della decodifica_sop = ''MES''
	 */
	public String getCodMese() {
		return codMese;
	}

	/**
	 * Metodo set che setta il codice della decodifica_sop = ''MES''
	 *
	 * @param codMese
	 */
	public void setCodMese(String codMese) {
		this.codMese = codMese;
	}

	/**
	 * Metodo get che ritorna il Sotto codice mese della decodifca_sop
	 *
	 * @return scoMese sotto codice mese della decodifica_sop
	 */
	public String getScoMese() {
		return scoMese;
	}

	/**
	 * Metodo set che setta il sotto codice mese della decodifica_sop
	 *
	 * @param scoMese sotto codice mese della decodifica_sop
	 */
	public void setScoMese(String scoMese) {
		this.scoMese = scoMese;
	}

	public Dmt_t_sessione getSessione() {
		return sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}
	

}
