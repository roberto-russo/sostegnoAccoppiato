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

import org.hibernate.annotations.ColumnDefault;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Tlatte_vendita_diretta_id;

@Entity
@Table(name = "DMT_T_TLATTE_VEND_DIR")
/**
 * Tabella di raccolata dati relativi alle quantità di latte vendute dai
 * produttori in regime di vendita diretta
 * 
 * @vesion 0.1 (03/04/2020)
 * @author Bcsoft
 *
 */
@IdClass(Dmt_t_Tlatte_vendita_diretta_id.class)
public class Dmt_t_Tlatte_vendita_diretta implements Serializable {

	private static final long serialVersionUID = -617789964633488044L;

	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	private Dmt_t_sessione sessione;

	@Id
	@Column(name = "id_azienda")
	@NotNull
	/**
	 * Identificativo SOP Azienda
	 */
	private Long idAzienda;

	@Id
	@Column(name = "versione")
	@NotNull
	/**
	 * Versione del dato
	 */
	private Long versione;

	@Id
	@Column(name = "progr_riga")
	@NotNull
	/**
	 * Progressivo riga
	 */
	private Long progrRiga;

	@Id
	@Column(name = "matricola")
	@NotNull
	/**
	 * Matricola
	 */
	private Long matricola;

	@Column(name = "codice_mese", length = 3)
	@NotNull
	@ColumnDefault("'MES'")
	/**
	 * Codice mese della tdecodifca_sop= ''MES''
	 */
	private String codiceMese;

	@Column(name = "sotto_codice_mese", length = 3)
	@NotNull
	/**
	 * Sotto codice mese della tdecodifca_sop
	 */
	private String sottoCodiceMese;

	@Column(name = "quantita", length = 3)
	/**
	 * Quantita di latte
	 */
	private Long quantita;

	/**
	 * Metodo get che ritorna l'Identificativo SOP Azienda
	 *
	 * @return idAzienda Identificativo SOP Azienda
	 */
	public Long getIdAzienda() {
		return idAzienda;
	}

	/**
	 * Metodo get che ritorna la versione del dato
	 *
	 * @return versione versione del dato
	 */
	public Long getVersione() {
		return versione;
	}

	/**
	 * Metodo get che ritorna il numero progressivo di riga
	 *
	 * @return progrRiga numero progressivodi riga
	 */
	public Long getProgrRiga() {
		return progrRiga;
	}

	/**
	 * Metodo get che ritorna la matricola
	 *
	 * @return matricola
	 */
	public Long getMatricola() {
		return matricola;
	}

	/**
	 * Metodo get che ritorna il codice mese della decodifica_sop = ''MES''
	 *
	 * @return codiceMese codice mese della decodifica_sop = ''MES''
	 */
	public String getCodiceMese() {
		return codiceMese;
	}

	/**
	 * Metodo set che setta il codice mese della decodifica_sop = ''MES''
	 *
	 * @param codiceMese codice mese della decodifica_sop = ''MES''
	 */
	public void setCodiceMese(String codiceMese) {
		this.codiceMese = codiceMese;
	}

	/**
	 * Metodo get che ritorna il sotto codice mese della decodifica_sop
	 *
	 * @return sottoCodiceMese sotto codice mese della decodifica sop
	 */
	public String getSottoCodiceMese() {
		return sottoCodiceMese;
	}

	/**
	 * Metodo set che setta il sotto codice mese della decodifica_sop
	 *
	 * @param sottoCodiceMese
	 */
	public void setSottoCodiceMese(String sottoCodiceMese) {
		this.sottoCodiceMese = sottoCodiceMese;
	}

	/**
	 * Metodo get che ritorna la quantità di latte
	 *
	 * @return quantita quantita di latte
	 */
	public Long getQuantita() {
		return quantita;
	}

	/**
	 * Metodo set che setta la quantità di latte
	 *
	 * @param quantita quantità di latte
	 */
	public void setQuantita(Long quantita) {
		this.quantita = quantita;
	}

	public Dmt_t_sessione getSessione() {
		return sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public void setIdAzienda(Long idAzienda) {
		this.idAzienda = idAzienda;
	}

	public void setVersione(Long versione) {
		this.versione = versione;
	}

	public void setProgrRiga(Long progrRiga) {
		this.progrRiga = progrRiga;
	}

	public void setMatricola(Long matricola) {
		this.matricola = matricola;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}
}