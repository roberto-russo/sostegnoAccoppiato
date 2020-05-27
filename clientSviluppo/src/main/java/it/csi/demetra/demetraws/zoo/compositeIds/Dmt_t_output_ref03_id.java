package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_output_ref03_id implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 838933985875477157L;
	
	private long sessione;
	private String cuaa;
	private Integer annoCampagna;
	private String intervento;
	
	public Dmt_t_output_ref03_id(long sessione, String cuaa, Integer annoCampagna, String intervento) {
		super();
		this.sessione = sessione;
		this.cuaa = cuaa;
		this.annoCampagna = annoCampagna;
		this.intervento = intervento;
	}

	public Dmt_t_output_ref03_id() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annoCampagna == null) ? 0 : annoCampagna.hashCode());
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
		result = prime * result + ((intervento == null) ? 0 : intervento.hashCode());
		result = prime * result + (int) (sessione ^ (sessione >>> 32));
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
		Dmt_t_output_ref03_id other = (Dmt_t_output_ref03_id) obj;
		if (annoCampagna == null) {
			if (other.annoCampagna != null)
				return false;
		} else if (!annoCampagna.equals(other.annoCampagna))
			return false;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		if (intervento == null) {
			if (other.intervento != null)
				return false;
		} else if (!intervento.equals(other.intervento))
			return false;
		if (sessione != other.sessione)
			return false;
		return true;
	}
}
