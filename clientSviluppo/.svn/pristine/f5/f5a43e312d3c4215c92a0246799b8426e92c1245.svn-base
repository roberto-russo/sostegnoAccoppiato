package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_clsPremio_Validazione_PP_id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5236761307926831527L;

	private long sessione;
	private Long IdAlleBDN;
	
	
	public Dmt_t_clsPremio_Validazione_PP_id() {
		super();
	}
	
	public Dmt_t_clsPremio_Validazione_PP_id(long sessione, Long idAlleBDN) {
		super();
		this.sessione = sessione;
		IdAlleBDN = idAlleBDN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdAlleBDN == null) ? 0 : IdAlleBDN.hashCode());
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
		Dmt_t_clsPremio_Validazione_PP_id other = (Dmt_t_clsPremio_Validazione_PP_id) obj;
		if (IdAlleBDN == null) {
			if (other.IdAlleBDN != null)
				return false;
		} else if (!IdAlleBDN.equals(other.IdAlleBDN))
			return false;
		if (sessione != other.sessione)
			return false;
		return true;
	}
}
