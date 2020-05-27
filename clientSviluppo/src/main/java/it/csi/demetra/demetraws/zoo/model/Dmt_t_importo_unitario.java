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
	private String intervento;
	
	@Id
	@Column (name="anno_campagna")
	private Integer annoCampagna;
	
	@Column(name="importo_unitario")
	private Double importoUnitario;

	public String getIntervento() {
		return intervento;
	}

	public void setIntervento(String intervento) {
		this.intervento = intervento;
	}

	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	public Double getImportoUnitario() {
		return importoUnitario;
	}

	public void setImportoUnitario(Double importoUnitario) {
		this.importoUnitario = importoUnitario;
	}

}
