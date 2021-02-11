package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;
import java.math.BigDecimal;

public class Dmt_t_dsScarico_allevamenti_id implements Serializable {

	private static final long serialVersionUID = 453482555835079292L;
	
	 private long sessione;
	 private BigDecimal allevId;
	 
	 
	 
	public Dmt_t_dsScarico_allevamenti_id() {
	}


	public Dmt_t_dsScarico_allevamenti_id(long sessione, BigDecimal allevId) {
		super();
		this.sessione = sessione;
		this.allevId = allevId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allevId == null) ? 0 : allevId.hashCode());
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
		Dmt_t_dsScarico_allevamenti_id other = (Dmt_t_dsScarico_allevamenti_id) obj;
		if (allevId == null) {
			if (other.allevId != null)
				return false;
		} else if (!allevId.equals(other.allevId))
			return false;
		if (sessione != other.sessione)
			return false;
		return true;
	}
}
