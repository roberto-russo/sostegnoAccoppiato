package it.csi.demetra.demetraws.zoo.compositeIds;
//
//import java.io.Serializable;
//
//public class Dmt_t_clsCapoMacellato_id  implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 7144485431496273712L;
//	
//	private Long capoId;
//	private Long allevId;
//	private long sessione;
//	
//	public Dmt_t_clsCapoMacellato_id() {
//		
//	}
//
//	public Dmt_t_clsCapoMacellato_id(Long capoId, Long allevId, long sessione) {
//		this.capoId = capoId;
//		this.allevId = allevId;
//		this.sessione = sessione;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((allevId == null) ? 0 : allevId.hashCode());
//		result = prime * result + ((capoId == null) ? 0 : capoId.hashCode());
//		result = prime * result + (int) (sessione ^ (sessione >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Dmt_t_clsCapoMacellato_id other = (Dmt_t_clsCapoMacellato_id) obj;
//		if (allevId == null) {
//			if (other.allevId != null)
//				return false;
//		} else if (!allevId.equals(other.allevId))
//			return false;
//		if (capoId == null) {
//			if (other.capoId != null)
//				return false;
//		} else if (!capoId.equals(other.capoId))
//			return false;
//		if (sessione != other.sessione)
//			return false;
//		return true;
//	}
//}
