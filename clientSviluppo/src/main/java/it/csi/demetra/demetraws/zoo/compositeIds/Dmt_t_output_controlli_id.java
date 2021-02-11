package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_output_controlli_id implements Serializable {

	private static final long serialVersionUID = -6572779375292767533L;

    private Long idSessione;
	private String cuaa;
	private Integer annoCampagna;
	private String intervento;
	public Dmt_t_output_controlli_id(Long idSessione, String cuaa, Integer annoCampagna, String intervento) {
		super();
		this.idSessione = idSessione;
		this.cuaa = cuaa;
		this.annoCampagna = annoCampagna;
		this.intervento = intervento;
	}
	public Dmt_t_output_controlli_id() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annoCampagna == null) ? 0 : annoCampagna.hashCode());
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
		result = prime * result + ((intervento == null) ? 0 : intervento.hashCode());
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
		Dmt_t_output_controlli_id other = (Dmt_t_output_controlli_id) obj;
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
		return true;
	}
	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}
	public String getCuaa() {
		return cuaa;
	}
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}
	public Integer getAnnoCampagna() {
		return annoCampagna;
	}
	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}
	public String getIntervento() {
		return intervento;
	}
	public void setIntervento(String intervento) {
		this.intervento = intervento;
	}

}
