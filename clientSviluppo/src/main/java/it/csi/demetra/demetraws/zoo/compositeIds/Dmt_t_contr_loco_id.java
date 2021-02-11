package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_contr_loco_id implements Serializable{

	private static final long serialVersionUID = 4925379903968029451L;

	private String cuaa;
	private String marchio;
	private Integer anno;
	
	public Dmt_t_contr_loco_id() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dmt_t_contr_loco_id(String cuaa, String marchio, Integer anno) {
		super();
		this.cuaa = cuaa;
		this.marchio = marchio;
		this.anno = anno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
		result = prime * result + ((marchio == null) ? 0 : marchio.hashCode());
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
		Dmt_t_contr_loco_id other = (Dmt_t_contr_loco_id) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		if (marchio == null) {
			if (other.marchio != null)
				return false;
		} else if (!marchio.equals(other.marchio))
			return false;
		return true;
	}
	
}
