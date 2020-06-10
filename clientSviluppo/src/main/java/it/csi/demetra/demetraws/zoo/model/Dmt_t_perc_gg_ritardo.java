package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import it.csi.demetra.demetaws.zoo.compositeIds.Dmt_t_perc_gg_ritardo_id;

@Entity
@Table(name = "DMT_T_PERC_GG_RITARDO")
@IdClass(Dmt_t_perc_gg_ritardo_id.class)
public class Dmt_t_perc_gg_ritardo implements Serializable{

	private static final long serialVersionUID = 3918443416865403194L;
	
	@Id
	@Column(name = "ANNO")
	/**
	 * anno della campagna in cui viene presentata la richiesta per la domanda
	 */
	private Long anno;
	
	@Id
	@Column(name = "GIORNI_RITARDO")
	/**
	 * giorni di ritardo per la presentazione della domanda
	 */
	private Long giorniRitardo;
	
	@Column(name = "PERC_DECURTAZIONE")
	/**
	 * percentuale di decurtazione del premio calcolato espressa in decimali, esempio: 0.50 (50%) 
	 */
	private BigDecimal percDecurtazione;

	/**
	 * Metodo getter che ritorna l'anno della campagna in cui viene presentata la richiesta per la domanda
	 * @return anno anno della campagna in cui viene presentata la richiesta per la domanda.
	 */
	public Long getAnno() {
		return anno;
	}

	/**
	 * Metodo setter che imposta l'anno della campagna ion cui viene presentata la richiesta per la domanda.
	 * @param anno anno della campagna in cui viene presentata la richiesta per la domanda.
	 */
	public void setAnno(Long anno) {
		this.anno = anno;
	}

	/**
	 * Metodo getter che ritorna il numero di giorni di ritardo per la presentazione della domanda
	 * @return giorniRitardo numero di giorni di ritardo per la presentazione della domanda
	 */
	public Long getGiorniRitardo() {
		return giorniRitardo;
	}

	/**
	 * Metodo setter che imposta il numero di giorni di ritardo per la presentazione della domanda
	 * @param giorniRitardo numero di giorni di ritardo per la presentazione della domanda
	 */
	public void setGiorniRitardo(Long giorniRitardo) {
		this.giorniRitardo = giorniRitardo;
	}

	/**
	 * Metodo getter che ritorna la percentuale di decurtazione del premio calcolato espressa in decimali, esempio: 0.50 (50%) 
	 * @return percDecurtazione pertentuale di decurtazione del premio calcolato espressa in decimali, esempio: 0.50 (50%)
	 */
	public BigDecimal getPercDecurtazione() {
		return percDecurtazione;
	}

	/**
	 * Metodo setter che imposta la percentuale di decurtazione del premio calcolato espressa in decimali, esempio: 0.50 (50%)
	 * @param percDecurtazione percentuale di decurtazione del premio calcolato espressa in decimali, esempio: 0.50 (50%)
	 */
	public void setPercDecurtazione(BigDecimal percDecurtazione) {
		this.percDecurtazione = percDecurtazione;
	}
}
