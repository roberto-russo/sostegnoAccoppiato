package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_info_allevamento_beneficiario_id implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5184808797618768665L;

	private Long idCapo;
	private Long allevId;
	private Integer annoCampagna;
	
	public Dmt_t_info_allevamento_beneficiario_id() {
	}
	
	public Dmt_t_info_allevamento_beneficiario_id(Long idCapo, Long allevId, Integer annoCampagna) {
		super();
		this.idCapo = idCapo;
		this.allevId = allevId;
		this.annoCampagna = annoCampagna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allevId == null) ? 0 : allevId.hashCode());
		result = prime * result + ((annoCampagna == null) ? 0 : annoCampagna.hashCode());
		result = prime * result + ((idCapo == null) ? 0 : idCapo.hashCode());
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
		Dmt_t_info_allevamento_beneficiario_id other = (Dmt_t_info_allevamento_beneficiario_id) obj;
		if (allevId == null) {
			if (other.allevId != null)
				return false;
		} else if (!allevId.equals(other.allevId))
			return false;
		if (annoCampagna == null) {
			if (other.annoCampagna != null)
				return false;
		} else if (!annoCampagna.equals(other.annoCampagna))
			return false;
		if (idCapo == null) {
			if (other.idCapo != null)
				return false;
		} else if (!idCapo.equals(other.idCapo))
			return false;
		return true;
	}
}
