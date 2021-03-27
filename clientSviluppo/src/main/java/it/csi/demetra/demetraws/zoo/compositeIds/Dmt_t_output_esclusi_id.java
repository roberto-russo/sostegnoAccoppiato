package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;
import java.util.Objects;

public class Dmt_t_output_esclusi_id implements Serializable {

    private static final long serialVersionUID = 9217875139729319085L;


    private Long idSessione;
    private String cuaa;
    private String calcolo;
    private Long capoId;

    public Dmt_t_output_esclusi_id(Long idSessione, String calcolo, Long capoId, String cuaa) {
        super();
        this.idSessione = idSessione;
        this.calcolo = calcolo;
        this.capoId = capoId;
        this.cuaa = cuaa;
    }

    public Dmt_t_output_esclusi_id() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dmt_t_output_esclusi_id that = (Dmt_t_output_esclusi_id) o;
        return Objects.equals(idSessione, that.idSessione) &&
                Objects.equals(cuaa, that.cuaa) &&
                Objects.equals(calcolo, that.calcolo) &&
                Objects.equals(capoId, that.capoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSessione, cuaa, calcolo, capoId);
    }
}
