package it.csi.demetra.demetraws.zoo.compositeIds;
//
//import java.io.Serializable;
//
//public class Dmt_t_Tws_bdn_du_capi_bovini_id implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 8878396543995412106L;
//
//	private long allev_id;
//	private long capoId;
//	private long vitelloCapoId;
//	private long sessione;
//
//	public Dmt_t_Tws_bdn_du_capi_bovini_id() {
//
//	}
//
//	public Dmt_t_Tws_bdn_du_capi_bovini_id(long allev_id, long capoId, long vitelloCapoId, long idSessione) {
//
//		this.allev_id = allev_id;
//		this.capoId = capoId;
//		this.vitelloCapoId = vitelloCapoId;
//		this.sessione = idSessione;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (allev_id ^ (allev_id >>> 32));
//		result = prime * result + (int) (capoId ^ (capoId >>> 32));
//		result = prime * result + (int) (sessione ^ (sessione >>> 32));
//		result = prime * result + (int) (vitelloCapoId ^ (vitelloCapoId >>> 32));
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
//		Dmt_t_Tws_bdn_du_capi_bovini_id other = (Dmt_t_Tws_bdn_du_capi_bovini_id) obj;
//		if (allev_id != other.allev_id)
//			return false;
//		if (capoId != other.capoId)
//			return false;
//		if (sessione != other.sessione)
//			return false;
//		if (vitelloCapoId != other.vitelloCapoId)
//			return false;
//		return true;
//	}
//}
