package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_w_controlli_preammissibilita_id implements Serializable {

    private static final long serialVersionUID = 5395829384273424696L;

    private String nomeClasseCalcolo;
    private Long idIntervento;
    private String ordineEsecuzione;
    private Long idSessione;

    public Dmt_w_controlli_preammissibilita_id() {

    }

    public Dmt_w_controlli_preammissibilita_id(String nomeClasseCalcolo, Long idIntervento, String ordineEsecuzione, Long idSessione) {
        this.nomeClasseCalcolo = nomeClasseCalcolo;
        this.idIntervento = idIntervento;
        this.ordineEsecuzione = ordineEsecuzione;
        this.idSessione = idSessione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idIntervento == null) ? 0 : idIntervento.hashCode());
        result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
        result = prime * result + ((nomeClasseCalcolo == null) ? 0 : nomeClasseCalcolo.hashCode());
        result = prime * result + ((ordineEsecuzione == null) ? 0 : ordineEsecuzione.hashCode());
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
        Dmt_w_controlli_preammissibilita_id other = (Dmt_w_controlli_preammissibilita_id) obj;
        if (idIntervento == null) {
            if (other.idIntervento != null)
                return false;
        } else if (!idIntervento.equals(other.idIntervento))
            return false;
        if (idSessione != other.idSessione)
            return false;
        if (nomeClasseCalcolo == null) {
            if (other.nomeClasseCalcolo != null)
                return false;
        } else if (!nomeClasseCalcolo.equals(other.nomeClasseCalcolo))
            return false;
        if (ordineEsecuzione == null) {
            if (other.ordineEsecuzione != null)
                return false;
        } else if (!ordineEsecuzione.equals(other.ordineEsecuzione))
            return false;
        return true;
    }
}
