package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_beneficiario_capi_doppi_id implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6678025958806575230L;

    private Integer annoCampagna;
    private String codiceIntervento;
    private Long idCapo;

    public Dmt_t_beneficiario_capi_doppi_id() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Dmt_t_beneficiario_capi_doppi_id(Integer annoCampagna, String codiceIntervento, Long idCapo) {
        super();
        this.annoCampagna = annoCampagna;
        this.codiceIntervento = codiceIntervento;
        this.idCapo = idCapo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((annoCampagna == null) ? 0 : annoCampagna.hashCode());
        result = prime * result + ((codiceIntervento == null) ? 0 : codiceIntervento.hashCode());
        result = prime * result + ((idCapo == null) ? 0 : idCapo.hashCode());
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
        Dmt_t_beneficiario_capi_doppi_id other = (Dmt_t_beneficiario_capi_doppi_id) obj;
        if (annoCampagna == null) {
            if (other.annoCampagna != null)
                return false;
        } else if (!annoCampagna.equals(other.annoCampagna))
            return false;
        if (codiceIntervento == null) {
            if (other.codiceIntervento != null)
                return false;
        } else if (!codiceIntervento.equals(other.codiceIntervento))
            return false;
        if (idCapo == null) {
            return other.idCapo == null;
        } else return idCapo.equals(other.idCapo);
    }
}
