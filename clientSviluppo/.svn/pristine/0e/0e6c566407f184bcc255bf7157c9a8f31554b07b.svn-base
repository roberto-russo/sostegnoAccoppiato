package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;
import java.util.Date;

public class Dmt_s_sessione_id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2033093729894466812L;

	private Date dataEora;
	private long idSessione;
	
	public Dmt_s_sessione_id() {
		// TODO Auto-generated constructor stub
	}
	
	public Dmt_s_sessione_id(Date dataEora, long idSessione) {
		this.dataEora = dataEora;
		this.idSessione = idSessione;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEora == null) ? 0 : dataEora.hashCode());
		result = prime * result + (int) (idSessione ^ (idSessione>>> 32));
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
		Dmt_s_sessione_id other = (Dmt_s_sessione_id) obj;
		if (dataEora == null) {
			if (other.dataEora != null)
				return false;
		} else if (!dataEora.equals(other.dataEora))
			return false;
		if (idSessione!= other.idSessione)
			return false;
		return true;
	}	
}
