package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class CuaaScaricoManuale_id implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1089093280492056141L;

    private int annoCampagna;
    private String cuaa;
    private String codicePremio;

    public CuaaScaricoManuale_id() {

    }

    public CuaaScaricoManuale_id(int annoCampagna, String cuaa, String codicePremio) {
        this.annoCampagna = annoCampagna;
        this.cuaa = cuaa;
        this.codicePremio = codicePremio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + annoCampagna;
        result = prime * result + ((codicePremio == null) ? 0 : codicePremio.hashCode());
        result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
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
        CuaaScaricoManuale_id other = (CuaaScaricoManuale_id) obj;
        if (annoCampagna != other.annoCampagna)
            return false;
        if (codicePremio == null) {
            if (other.codicePremio != null)
                return false;
        } else if (!codicePremio.equals(other.codicePremio))
            return false;
        if (cuaa == null) {
            return other.cuaa == null;
        } else return cuaa.equals(other.cuaa);
    }
}
