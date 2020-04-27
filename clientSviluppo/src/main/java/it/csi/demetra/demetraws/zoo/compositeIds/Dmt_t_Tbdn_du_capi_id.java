package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_Tbdn_du_capi_id implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7460887888423277427L;

	private long allevId;
	private long capoId;
	private String codice;
	private long sessione;

	public Dmt_t_Tbdn_du_capi_id() {

	}

	public Dmt_t_Tbdn_du_capi_id(long allevId, long capoId, String codice, long sessione) {

		this.allevId = allevId;
		this.capoId = capoId;
		this.codice = codice;
		this.sessione = sessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (allevId ^ (allevId >>> 32));
		result = prime * result + (int) (capoId ^ (capoId >>> 32));
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
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
		Dmt_t_Tbdn_du_capi_id other = (Dmt_t_Tbdn_du_capi_id) obj;
		if (allevId != other.allevId)
			return false;
		if (capoId != other.capoId)
			return false;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (sessione != other.sessione)
			return false;
		return true;
	}
}
