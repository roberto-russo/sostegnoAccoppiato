package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_irregolarita_intenzionale_id implements Serializable{

	private static final long serialVersionUID = 3327885232967479253L;
	
	private String cuaa;
	private String codiceStalla;
	 private Long progressivo;
	
	public Dmt_t_irregolarita_intenzionale_id(String cuaa, String codiceStalla, Long progressivo) {
		super();
		this.cuaa = cuaa;
		this.codiceStalla = codiceStalla;
		this.progressivo = progressivo;
	}

	public Dmt_t_irregolarita_intenzionale_id() {}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceStalla == null) ? 0 : codiceStalla.hashCode());
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
		result = prime * result + ((progressivo == null) ? 0 : progressivo.hashCode());
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
		Dmt_t_irregolarita_intenzionale_id other = (Dmt_t_irregolarita_intenzionale_id) obj;
		if (codiceStalla == null) {
			if (other.codiceStalla != null)
				return false;
		} else if (!codiceStalla.equals(other.codiceStalla))
			return false;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		if (progressivo == null) {
			if (other.progressivo != null)
				return false;
		} else if (!progressivo.equals(other.progressivo))
			return false;
		return true;
	}	
}
