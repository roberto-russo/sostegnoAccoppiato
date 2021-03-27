package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_coefficienti_uba_id implements Serializable {

    private static final long serialVersionUID = -5621454556915205458L;

    private Long idSpecie;
    private Long idCategoria;
    private Long idSessione;

    public Dmt_t_coefficienti_uba_id() {
    }

    public Dmt_t_coefficienti_uba_id(Long idSpecie, Long idCategoria, Long idSessione) {
        this.idSpecie = idSpecie;
        this.idCategoria = idCategoria;
        this.idSessione = idSessione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
        result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
        result = prime * result + ((idSpecie == null) ? 0 : idSpecie.hashCode());
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
        Dmt_t_coefficienti_uba_id other = (Dmt_t_coefficienti_uba_id) obj;
        if (idCategoria == null) {
            if (other.idCategoria != null)
                return false;
        } else if (!idCategoria.equals(other.idCategoria))
            return false;
        if (idSessione != other.idSessione)
            return false;
        if (idSpecie == null) {
            return other.idSpecie == null;
        } else return idSpecie.equals(other.idSpecie);
    }
}
