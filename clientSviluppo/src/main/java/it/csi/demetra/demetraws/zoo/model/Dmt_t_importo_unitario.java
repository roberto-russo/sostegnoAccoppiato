package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_importo_unitario_id;

@Entity
@Table(name = "DMT_T_IMPORTO_UNITARIO")
@IdClass(Dmt_t_importo_unitario_id.class)
public class Dmt_t_importo_unitario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8638592301852966273L;

	@Id
	@Column(name="intervento")
	/**
	 * codice intervento.
	 */
	private String intervento;
	
	@Id
	@Column (name="anno_campagna")
	/**
	 * Anno della campagna
	 */
	private Integer annoCampagna;
	
	@Column(name="importo_unitario")
	/**
	 * importo unitario associato al codice intervento.
	 */
	private Double importoUnitario;

	/**
	 * metodo getter che ritorna il codice intervento.
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
	 * Metodo getter che ritorna l'anno della campagna.
	 * @return annoCampagna anno della campagna.
	 */
	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	/**
	 * Metodo setter che imposta l'anno della campagna
	 * @param annoCampagna anno della campagna.
	 */
	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	/**
	 * Metodo getter che ritorna l'importo unitario associato al codice intervento.
	 * @return importoUnitario importo unitario associato al codice intervento.
	 */
	public Double getImportoUnitario() {
		return importoUnitario;
	}

	/**
	 * Metodo setter che imposta l'importo unitario associato al codice intervento.
	 * @param importoUnitario importo unitario associato al codice intervento.
	 */
	public void setImportoUnitario(Double importoUnitario) {
		this.importoUnitario = importoUnitario;
	}

}
