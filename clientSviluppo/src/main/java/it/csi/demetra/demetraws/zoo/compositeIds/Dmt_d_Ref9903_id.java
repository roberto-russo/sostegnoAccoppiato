package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;
import java.util.Objects;

public class Dmt_d_Ref9903_id implements Serializable {

    private static final long serialVersionUID = -8487247615949600950L;

    private String cuaa;
    private Long idSessione;
    private Long annoCampagna;

    public Dmt_d_Ref9903_id() {
        super();
    }

    public Dmt_d_Ref9903_id(String cuaa, Long idSessione, Long annoCampagna) {
        this.cuaa = cuaa;
        this.idSessione = idSessione;
        this.annoCampagna = annoCampagna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dmt_d_Ref9903_id that = (Dmt_d_Ref9903_id) o;
        return Objects.equals(cuaa, that.cuaa) &&
                Objects.equals(idSessione, that.idSessione) &&
                Objects.equals(annoCampagna, that.annoCampagna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuaa, idSessione, annoCampagna);
    }
}
