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

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Tlatte_sintesi_analisi_id;

/**
 * Tabella che raccoglie i dati qualitativi di Agrinet aggregati per Matricola
 * su cui vengono eseguite le elaborazioni relative alle medie dei 3 parametri
 * 
 * @version 0.1 (02/04/2020)
 * @author Bcsoft
 *
 */
@Entity
@Table(name = "DMT_T_TLATTE_SIN_AN")
@IdClass(Dmt_t_Tlatte_sintesi_analisi_id.class)
public class Dmt_t_Tlatte_sintesi_analisi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7714621328382699088L;


	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@Id
	@Column(name = "CUAA_AZIENDA")
	@NotNull
	/**
	 * Identificativo Fiscale del soggetto che ha presentato la domanda
	 */
	private String cuaa_azienda;

	@Id
	@Column(name = "MATRICOLA_AZIENDA")
	@NotNull
	/**
	 * matricola aziendale
	 */
	private Long matricola_azienda;

	@Id
	@Column(name = "ANNO_RIFERIMENTO")
	@NotNull
	/**
	 * Anno di campagna di riferimento
	 */
	private Long anno_riferimento;

	@Column(name = "CSOM_MED")
	/**
	 * Media Geometrica del valore di Cellule Somatiche
	 */
	private Long csom_med;

	@Column(name = "CMIC_MED")
	/**
	 * Media Geometrica del valore di Carica Microbiotica
	 */
	private Long cmic_med;

	@Column(name = "PP_MED")
	/**
	 * Media Aritmetica del valore di Proteine
	 */
	private Long pp_med;

	@Column(name = "CSOM_01_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 01
	 */
	private Long csom_01_n_an;

	@Column(name = "CSOM_02_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 02
	 */
	private Long csom_02_n_an;

	@Column(name = "CSOM_03_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 03
	 */
	private Long csom_03_n_an;

	@Column(name = "CSOM_04_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 04
	 */
	private Long csom_04_n_an;

	@Column(name = "CSOM_05_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 05
	 */
	private Long csom_05_n_an;

	@Column(name = "CSOM_06_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 06
	 */
	private Long csom_06_n_an;

	@Column(name = "CSOM_07_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 07
	 */
	private Long csom_07_n_an;

	@Column(name = "CSOM_08_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 08
	 */
	private Long csom_08_n_an;

	@Column(name = "CSOM_09_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 09
	 */
	private Long csom_09_n_an;

	@Column(name = "CSOM_10_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 10
	 */
	private Long csom_10_n_an;

	@Column(name = "CSOM_11_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 11
	 */
	private Long csom_11_n_an;

	@Column(name = "CSOM_12_N_AN")
	/**
	 * Numero di analisi per il valore di Cellule Somatiche - mese 12
	 */
	private Long csom_12_n_an;

	@Column(name = "cmic_01_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 01
	 */
	private Long cmic_01_n_an;

	@Column(name = "cmic_02_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 02
	 */
	private Long cmic_02_n_an;

	@Column(name = "cmic_03_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 03
	 */
	private Long cmic_03_n_an;

	@Column(name = "cmic_04_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 04
	 */
	private Long cmic_04_n_an;

	@Column(name = "cmic_05_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 05
	 */
	private Long cmic_05_n_an;

	@Column(name = "cmic_06_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 06
	 */
	private Long cmic_06_n_an;

	@Column(name = "cmic_07_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 07
	 */
	private Long cmic_07_n_an;

	@Column(name = "cmic_08_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 08
	 */
	private Long cmic_08_n_an;

	@Column(name = "cmic_09_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 09
	 */
	private Long cmic_09_n_an;

	@Column(name = "cmic_10_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 10
	 */
	private Long cmic_10_n_an;

	@Column(name = "cmic_11_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 11
	 */
	private Long cmic_11_n_an;

	@Column(name = "cmic_12_n_an")
	/**
	 * Numero di analisi per il valore di Carica Microbiotica - mese 12
	 */
	private Long cmic_12_n_an;

	@Column(name = "PP_01_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 01
	 */
	private Long pp_01_n_an;

	@Column(name = "PP_02_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 02
	 */
	private Long pp_02_n_an;

	@Column(name = "PP_03_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 03
	 */
	private Long pp_03_n_an;

	@Column(name = "PP_04_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 04
	 */
	private Long pp_04_n_an;

	@Column(name = "PP_05_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 05
	 */
	private Long pp_05_n_an;

	@Column(name = "PP_06_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 06
	 */
	private Long pp_06_n_an;

	@Column(name = "PP_07_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 07
	 */
	private Long pp_07_n_an;

	@Column(name = "PP_08_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 07
	 */
	private Long pp_08_n_an;

	@Column(name = "PP_09_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 08
	 */
	private Long pp_09_n_an;

	@Column(name = "PP_10_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 10
	 */
	private Long pp_10_n_an;

	@Column(name = "PP_11_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 11
	 */
	private Long pp_11_n_an;

	@Column(name = "PP_12_N_AN")
	/**
	 * Numero di analisi per il valore di Proteine - mese 12
	 */
	private Long pp_12_n_an;

	@Column(name = "ALL_ASL")
	@NotNull
	/**
	 * Identificativo assegnato dalla BDN all''allevamento
	 */
	private String all_asl;

	/**
	 * Metodo get che ritorna l'identificativo fiscale dell'azienda
	 * 
	 * @return cuaa_azienda identificativo fiscale dell'azienda.
	 */
	public String getCuaa_azienda() {
		return cuaa_azienda;
	}

	/**
	 * Metodo get che ritorna la matricola aziendale.
	 * 
	 * @return matricola_azienda matricola aziendale.
	 */
	public Long getMatricola_azienda() {
		return matricola_azienda;
	}

	/**
	 * Metodo get che ritorna l'anno campagna di riferimento
	 * 
	 * @return anno_riferimento anno campagna di rifeirmenrto.
	 */
	public Long getAnno_riferimento() {
		return anno_riferimento;
	}

	/**
	 * Metodo get che ritorna la Media Geometrica del valore di Cellule Somatiche
	 * 
	 * @return csom_med Media Geometrica del valore di Cellule Somatiche
	 */
	public Long getCsom_med() {
		return csom_med;
	}

	/**
	 * Metodo set che setta la Media Geometrica del valore di Cellule Somatiche
	 * 
	 * @param csom_med Media Geometrica del valore di Cellule Somatiche
	 */
	public void setCsom_med(Long csom_med) {
		this.csom_med = csom_med;
	}

	/**
	 * Metodo get che ritorna la Media Geometrica del valore di Carica Microbiotica
	 * 
	 * @return cmic_med Media Geometrica del valore di Carica Microbiotica
	 */
	public Long getCmic_med() {
		return cmic_med;
	}

	/**
	 * Metodo set che setta la Media Geometrica del valore di Carica Microbiotica
	 * 
	 * @param cmic_med Media Geometrica del valore di Carica Microbiotica
	 */
	public void setCmic_med(Long cmic_med) {
		this.cmic_med = cmic_med;
	}

	/**
	 * Metodo get che ritorna la Media Aritmetica del valore di Proteine
	 * 
	 * @return pp_med Media Aritmetica del valore di Proteine.
	 */
	public Long getPp_med() {
		return pp_med;
	}

	/**
	 * Metodo set che setta la Media Aritmetica del valore di Proteine.
	 * 
	 * @param pp_med Media Aritmetica del valore di Proteine.
	 */
	public void setPp_med(Long pp_med) {
		this.pp_med = pp_med;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Cellule
	 * Somatiche - mese 01
	 * 
	 * @return csom_01_n_an Numero di analisi per il valore di Cellule Somatiche -
	 *         mese 01
	 */
	public Long getCsom_01_n_an() {
		return csom_01_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Cellule Somatiche
	 * - mese 01
	 * 
	 * @param csom_01_n_an Numero di analisi per il valore di Cellule Somatiche -
	 *                     mese 01
	 */
	public void setCsom_01_n_an(Long csom_01_n_an) {
		this.csom_01_n_an = csom_01_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche - mese 02
	 * 
	 * @return csom_02_n_an numero di analisi per il valore di cellule somatiche -
	 *         mese 02
	 */
	public Long getCsom_02_n_an() {
		return csom_02_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * - mese 02
	 * 
	 * @param csom_02_n_an numero di analisi per il valore di cellule somatiche -
	 *                     mese 02
	 */
	public void setCsom_02_n_an(Long csom_02_n_an) {
		this.csom_02_n_an = csom_02_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche - mese 03
	 * 
	 * @return csom_03_n_an numeor di analisi per il valore di cellule somatiche -
	 *         mese03
	 */
	public Long getCsom_03_n_an() {
		return csom_03_n_an;
	}

	/**
	 * Metofo set che setta il numero di analisi per il valore di cellule somatiche
	 * - mese 03
	 * 
	 * @param csom_03_n_an numero di analisi per il valore di cellule somatiche -
	 *                     mese 03
	 */
	public void setCsom_03_n_an(Long csom_03_n_an) {
		this.csom_03_n_an = csom_03_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 04
	 * 
	 * @return csom_04_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 04
	 */
	public Long getCsom_04_n_an() {
		return csom_04_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 04
	 * 
	 * @param csom_04_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 04
	 */
	public void setCsom_04_n_an(Long csom_04_n_an) {
		this.csom_04_n_an = csom_04_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 05
	 * 
	 * @return csom_05_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 05
	 */
	public Long getCsom_05_n_an() {
		return csom_05_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 05
	 * 
	 * @param csom_05_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 05
	 */
	public void setCsom_05_n_an(Long csom_05_n_an) {
		this.csom_05_n_an = csom_05_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 06
	 * 
	 * @return csom_06_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 06
	 */
	public Long getCsom_06_n_an() {
		return csom_06_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 06
	 * 
	 * @param csom_06_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 06
	 */
	public void setCsom_06_n_an(Long csom_06_n_an) {
		this.csom_06_n_an = csom_06_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 07
	 * 
	 * @return csom_07_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 07
	 */
	public Long getCsom_07_n_an() {
		return csom_07_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 07
	 * 
	 * @param csom_07_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 07
	 */
	public void setCsom_07_n_an(Long csom_07_n_an) {
		this.csom_07_n_an = csom_07_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 08
	 * 
	 * @return csom_08_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 08
	 */
	public Long getCsom_08_n_an() {
		return csom_08_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 08
	 * 
	 * @param csom_08_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 08
	 */
	public void setCsom_08_n_an(Long csom_08_n_an) {
		this.csom_08_n_an = csom_08_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 09
	 * 
	 * @return csom_09_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 09
	 */
	public Long getCsom_09_n_an() {
		return csom_09_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 09
	 * 
	 * @param csom_09_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 09
	 */
	public void setCsom_09_n_an(Long csom_09_n_an) {
		this.csom_09_n_an = csom_09_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 10
	 * 
	 * @return csom_10_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 10
	 */
	public Long getCsom_10_n_an() {
		return csom_10_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 10
	 * 
	 * @param csom_10_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 10
	 */
	public void setCsom_10_n_an(Long csom_10_n_an) {
		this.csom_10_n_an = csom_10_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 11
	 * 
	 * @return csom_11_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 11
	 */
	public Long getCsom_11_n_an() {
		return csom_11_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 11
	 * 
	 * @param csom_11_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 11
	 */
	public void setCsom_11_n_an(Long csom_11_n_an) {
		this.csom_11_n_an = csom_11_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di cellule
	 * somatiche mese - 12
	 * 
	 * @return csom_12_n_an numero di analisi per il valore di cellule somatiche
	 *         mese - 12
	 */
	public Long getCsom_12_n_an() {
		return csom_12_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di cellule somatiche
	 * mese - 12
	 * 
	 * @param csom_12_n_an numero di analisi per il valore di cellule somatiche mese
	 *                     - 12
	 */
	public void setCsom_12_n_an(Long csom_12_n_an) {
		this.csom_12_n_an = csom_12_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Carica
	 * Microbiotica - mese 01
	 * 
	 * @return cmic_01_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 01
	 */
	public Long getCmic_01_n_an() {
		return cmic_01_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 01
	 * 
	 * @param cmic_01_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 01
	 */
	public void setCmic_01_n_an(Long cmic_01_n_an) {
		this.cmic_01_n_an = cmic_01_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 02
	 * 
	 * @return cmic_02_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 02
	 */
	public Long getCmic_02_n_an() {
		return cmic_02_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 02
	 * 
	 * @param cmic_02_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 02
	 */
	public void setCmic_02_n_an(Long cmic_02_n_an) {
		this.cmic_02_n_an = cmic_02_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 03
	 * 
	 * @return cmic_03_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 03
	 */
	public Long getCmic_03_n_an() {
		return cmic_03_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 03
	 * 
	 * @param cmic_03_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 03
	 */
	public void setCmic_03_n_an(Long cmic_03_n_an) {
		this.cmic_03_n_an = cmic_03_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 04
	 * 
	 * @return cmic_04_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 04
	 */
	public Long getCmic_04_n_an() {
		return cmic_04_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 04
	 * 
	 * @param cmic_04_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 04
	 */
	public void setCmic_04_n_an(Long cmic_04_n_an) {
		this.cmic_04_n_an = cmic_04_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 05
	 * 
	 * @return cmic_05_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 05
	 */
	public Long getCmic_05_n_an() {
		return cmic_05_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 05
	 * 
	 * @param cmic_05_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 05
	 */
	public void setCmic_05_n_an(Long cmic_05_n_an) {
		this.cmic_05_n_an = cmic_05_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 06
	 * 
	 * @return cmic_05_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 06
	 */
	public Long getCmic_06_n_an() {
		return cmic_06_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 06
	 * 
	 * @param cmic_06_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 06
	 */
	public void setCmic_06_n_an(Long cmic_06_n_an) {
		this.cmic_06_n_an = cmic_06_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 07
	 * 
	 * @return cmic_07_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 07
	 */
	public Long getCmic_07_n_an() {
		return cmic_07_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 07
	 * 
	 * @param cmic_07_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 07
	 */
	public void setCmic_07_n_an(Long cmic_07_n_an) {
		this.cmic_07_n_an = cmic_07_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 08
	 * 
	 * @return cmic_08_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 08
	 */
	public Long getCmic_08_n_an() {
		return cmic_08_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 08
	 * 
	 * @param cmic_08_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 08
	 */
	public void setCmic_08_n_an(Long cmic_08_n_an) {
		this.cmic_08_n_an = cmic_08_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 09
	 * 
	 * @return cmic_09_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 09
	 */
	public Long getCmic_09_n_an() {
		return cmic_09_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 09
	 * 
	 * @param cmic_09_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 09
	 */
	public void setCmic_09_n_an(Long cmic_09_n_an) {
		this.cmic_09_n_an = cmic_09_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 10
	 * 
	 * @return cmic_10_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 10
	 */
	public Long getCmic_10_n_an() {
		return cmic_10_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 10
	 * 
	 * @param cmic_10_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 10
	 */
	public void setCmic_10_n_an(Long cmic_10_n_an) {
		this.cmic_10_n_an = cmic_10_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 11
	 * 
	 * @return cmic_11_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 11
	 */
	public Long getCmic_11_n_an() {
		return cmic_11_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 11
	 * 
	 * @param cmic_11_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 11
	 */
	public void setCmic_11_n_an(Long cmic_11_n_an) {
		this.cmic_11_n_an = cmic_11_n_an;
	}

	/**
	 * Metodo get che ritorna il numero di analisi per il valore di carica
	 * microbiotica - mese 12
	 * 
	 * @return cmic_12_n_an numero di analisi per il valore di carica microbiotica -
	 *         mese 12
	 */
	public Long getCmic_12_n_an() {
		return cmic_12_n_an;
	}

	/**
	 * Metodo set che setta il numero di analisi per il valore di carica
	 * microbiotica - mese 12
	 * 
	 * @param cmic_12_n_an numero di analisi per il valore di carica microbiotica -
	 *                     mese 12
	 */
	public void setCmic_12_n_an(Long cmic_12_n_an) {
		this.cmic_12_n_an = cmic_12_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 01
	 * 
	 * @return pp_01_n_an Numero di analisi per il valore di Proteine - mese 01
	 */
	public Long getPp_01_n_an() {
		return pp_01_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 01
	 * 
	 * @param pp_01_n_an Numero di analisi per il valore di Proteine - mese 01
	 */
	public void setPp_01_n_an(Long pp_01_n_an) {
		this.pp_01_n_an = pp_01_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 02
	 * 
	 * @return pp_02_n_an Numero di analisi per il valore di Proteine - mese 02
	 */
	public Long getPp_02_n_an() {
		return pp_02_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 02
	 * 
	 * @param pp_02_n_an Numero di analisi per il valore di Proteine - mese 02
	 */
	public void setPp_02_n_an(Long pp_02_n_an) {
		this.pp_02_n_an = pp_02_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 03
	 * 
	 * @return pp_03_n_an Numero di analisi per il valore di Proteine - mese 03
	 */
	public Long getPp_03_n_an() {
		return pp_03_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 03
	 * 
	 * @param pp_03_n_an Numero di analisi per il valore di Proteine - mese 03
	 */
	public void setPp_03_n_an(Long pp_03_n_an) {
		this.pp_03_n_an = pp_03_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 04
	 * 
	 * @return pp_04_n_an Numero di analisi per il valore di Proteine - mese 04
	 */
	public Long getPp_04_n_an() {
		return pp_04_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 04
	 * 
	 * @param pp_04_n_an Numero di analisi per il valore di Proteine - mese 04
	 */
	public void setPp_04_n_an(Long pp_04_n_an) {
		this.pp_04_n_an = pp_04_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 05
	 * 
	 * @return pp_05_n_an Numero di analisi per il valore di Proteine - mese 05
	 */
	public Long getPp_05_n_an() {
		return pp_05_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 05
	 * 
	 * @param pp_05_n_an Numero di analisi per il valore di Proteine - mese 05
	 */
	public void setPp_05_n_an(Long pp_05_n_an) {
		this.pp_05_n_an = pp_05_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 06
	 * 
	 * @return pp_06_n_an Numero di analisi per il valore di Proteine - mese 06
	 */
	public Long getPp_06_n_an() {
		return pp_06_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 06
	 * 
	 * @param pp_06_n_an Numero di analisi per il valore di Proteine - mese 06
	 */
	public void setPp_06_n_an(Long pp_06_n_an) {
		this.pp_06_n_an = pp_06_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 07
	 * 
	 * @return pp_07_n_an Numero di analisi per il valore di Proteine - mese 07
	 */
	public Long getPp_07_n_an() {
		return pp_07_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 07
	 * 
	 * @param pp_07_n_an Numero di analisi per il valore di Proteine - mese 07
	 */
	public void setPp_07_n_an(Long pp_07_n_an) {
		this.pp_07_n_an = pp_07_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 08
	 * 
	 * @return pp_08_n_an Numero di analisi per il valore di Proteine - mese 08
	 */
	public Long getPp_08_n_an() {
		return pp_08_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 08
	 * 
	 * @param pp_08_n_an Numero di analisi per il valore di Proteine - mese 08
	 */
	public void setPp_08_n_an(Long pp_08_n_an) {
		this.pp_08_n_an = pp_08_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 09
	 * 
	 * @return pp_09_n_an Numero di analisi per il valore di Proteine - mese 09
	 */
	public Long getPp_09_n_an() {
		return pp_09_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 09
	 * 
	 * @param pp_09_n_an Numero di analisi per il valore di Proteine - mese 09
	 */
	public void setPp_09_n_an(Long pp_09_n_an) {
		this.pp_09_n_an = pp_09_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 10
	 * 
	 * @return pp_10_n_an Numero di analisi per il valore di Proteine - mese 10
	 */
	public Long getPp_10_n_an() {
		return pp_10_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 10
	 * 
	 * @param pp_10_n_an Numero di analisi per il valore di Proteine - mese 10
	 */
	public void setPp_10_n_an(Long pp_10_n_an) {
		this.pp_10_n_an = pp_10_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 11
	 * 
	 * @return pp_11_n_an Numero di analisi per il valore di Proteine - mese 11
	 */
	public Long getPp_11_n_an() {
		return pp_11_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 11
	 * 
	 * @param pp_11_n_an Numero di analisi per il valore di Proteine - mese 11
	 */
	public void setPp_11_n_an(Long pp_11_n_an) {
		this.pp_11_n_an = pp_11_n_an;
	}

	/**
	 * Metodo get che ritorna il Numero di analisi per il valore di Proteine - mese
	 * 12
	 * 
	 * @return pp_12_n_an Numero di analisi per il valore di Proteine - mese 12
	 */
	public Long getPp_12_n_an() {
		return pp_12_n_an;
	}

	/**
	 * Metodo set che setta il Numero di analisi per il valore di Proteine - mese 12
	 * 
	 * @param pp_12_n_an Numero di analisi per il valore di Proteine - mese 12
	 */
	public void setPp_12_n_an(Long pp_12_n_an) {
		this.pp_12_n_an = pp_12_n_an;
	}

	/**
	 * Metodo get che ritorna l'Identificativo assegnato dalla BDN all''allevamento
	 * 
	 * @return all_asl Identificativo assegnato dalla BDN all''allevamento
	 */
	public String getAll_asl() {
		return all_asl;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione.getIdSessione();
	}

	public void setCuaa_azienda(String cuaa_azienda) {
		this.cuaa_azienda = cuaa_azienda;
	}

	public void setMatricola_azienda(Long matricola_azienda) {
		this.matricola_azienda = matricola_azienda;
	}

	public void setAnno_riferimento(Long anno_riferimento) {
		this.anno_riferimento = anno_riferimento;
	}

	public void setAll_asl(String all_asl) {
		this.all_asl = all_asl;
	}
}
