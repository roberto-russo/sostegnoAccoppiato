package it.csi.demetra.demetraws.zoo.compositeIds;
//
//import java.io.Serializable;
//
//public class Dmt_d_clsPremio_ValidazioneResponse_id implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -494256279763787346L;
//
//	private String ErrCod;
//	private Long numeroCapi;
//	private long sessione;
//
//	public Dmt_d_clsPremio_ValidazioneResponse_id() {
//
//	}
//
//	public Dmt_d_clsPremio_ValidazioneResponse_id(String ErrCod, Long numeroCapi, long idSessione) {
//
//		this.ErrCod = ErrCod;
//		this.numeroCapi = numeroCapi;
//		this.sessione = idSessione;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((ErrCod == null) ? 0 : ErrCod.hashCode());
//		result = prime * result + (int) (sessione ^ (sessione >>> 32));
//		result = prime * result + ((numeroCapi == null) ? 0 : numeroCapi.hashCode());
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
//		Dmt_d_clsPremio_ValidazioneResponse_id other = (Dmt_d_clsPremio_ValidazioneResponse_id) obj;
//		if (ErrCod == null) {
//			if (other.ErrCod != null)
//				return false;
//		} else if (!ErrCod.equals(other.ErrCod))
//			return false;
//		if (sessione != other.sessione)
//			return false;
//		if (numeroCapi == null) {
//			if (other.numeroCapi != null)
//				return false;
//		} else if (!numeroCapi.equals(other.numeroCapi))
//			return false;
//		return true;
//	}
//}
