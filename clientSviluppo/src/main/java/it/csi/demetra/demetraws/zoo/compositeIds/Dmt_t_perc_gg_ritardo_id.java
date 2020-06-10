package it.csi.demetra.demetaws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_perc_gg_ritardo_id implements Serializable{

	private static final long serialVersionUID = 6864759385219321045L;
	
	private Long anno;
	private Long giorniRitardo;
	
	public Dmt_t_perc_gg_ritardo_id() {
		super();
	}

	public Dmt_t_perc_gg_ritardo_id(Long anno, Long giorniRitardo) {
		super();
		this.anno = anno;
		this.giorniRitardo = giorniRitardo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((giorniRitardo == null) ? 0 : giorniRitardo.hashCode());
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
		Dmt_t_perc_gg_ritardo_id other = (Dmt_t_perc_gg_ritardo_id) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (giorniRitardo == null) {
			if (other.giorniRitardo != null)
				return false;
		} else if (!giorniRitardo.equals(other.giorniRitardo))
			return false;
		return true;
	}
}
