package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_importo_unitario_id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2112366051331850859L;
	
	private Double importoUnitario;
	private Integer annoCampagna;
	
	public Dmt_t_importo_unitario_id(Double importoUnitario, Integer annoCampagna) {
		this.importoUnitario = importoUnitario;
		this.annoCampagna = annoCampagna;
	}

	public Dmt_t_importo_unitario_id() {}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annoCampagna == null) ? 0 : annoCampagna.hashCode());
		result = prime * result + ((importoUnitario == null) ? 0 : importoUnitario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dmt_t_importo_unitario_id other = (Dmt_t_importo_unitario_id) obj;
		if (annoCampagna == null) {
			if (other.annoCampagna != null)
				return false;
		} else if (!annoCampagna.equals(other.annoCampagna))
			return false;
		if (importoUnitario == null) {
			if (other.importoUnitario != null)
				return false;
		} else if (!importoUnitario.equals(other.importoUnitario))
			return false;
		return true;
	}
}
