package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_premio_capi_id implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idSessione;
    private String cuaa;
    private Long idAllevamento;
    private String codicePremio;
    private Long idCapo;

    public Dmt_t_premio_capi_id() {

    }

    public Dmt_t_premio_capi_id(Long idSessione, String cuaa, Long idAllevamento, String codicePremio, Long idCapo) {
        this.idSessione = idSessione;
        this.cuaa = cuaa;
        this.idAllevamento = idAllevamento;
        this.codicePremio = codicePremio;
        this.idCapo = idCapo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Long idSessione) {
        this.idSessione = idSessione;
    }

    public String getCuaa() {
        return cuaa;
    }

    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    public Long getIdAllevamento() {
        return idAllevamento;
    }

    public void setIdAllevamento(Long idAllevamento) {
        this.idAllevamento = idAllevamento;
    }

    public String getCodicePremio() {
        return codicePremio;
    }

    public void setCodicePremio(String codicePremio) {
        this.codicePremio = codicePremio;
    }

    public Long getIdCapo() {
        return idCapo;
    }

    public void setIdCapo(Long idCapo) {
        this.idCapo = idCapo;
    }


}
