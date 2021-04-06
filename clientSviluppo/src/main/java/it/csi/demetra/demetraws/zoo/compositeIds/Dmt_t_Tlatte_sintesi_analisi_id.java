package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_Tlatte_sintesi_analisi_id implements Serializable {

    private static final long serialVersionUID = -5814531776893863009L;

    private String cuaa_azienda;
    private Long matricola_azienda;
    private Long anno_riferimento;
    private Long idSessione;

    public Dmt_t_Tlatte_sintesi_analisi_id() {

    }

    public Dmt_t_Tlatte_sintesi_analisi_id(String cuaa_azienda, Long matricola_azienda, Long anno_riferimento, Long idSessione) {
        this.cuaa_azienda = cuaa_azienda;
        this.matricola_azienda = matricola_azienda;
        this.anno_riferimento = anno_riferimento;
        this.idSessione = idSessione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((anno_riferimento == null) ? 0 : anno_riferimento.hashCode());
        result = prime * result + ((cuaa_azienda == null) ? 0 : cuaa_azienda.hashCode());
        result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
        result = prime * result + ((matricola_azienda == null) ? 0 : matricola_azienda.hashCode());
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
        Dmt_t_Tlatte_sintesi_analisi_id other = (Dmt_t_Tlatte_sintesi_analisi_id) obj;
        if (anno_riferimento == null) {
            if (other.anno_riferimento != null)
                return false;
        } else if (!anno_riferimento.equals(other.anno_riferimento))
            return false;
        if (cuaa_azienda == null) {
            if (other.cuaa_azienda != null)
                return false;
        } else if (!cuaa_azienda.equals(other.cuaa_azienda))
            return false;
        if (idSessione != other.idSessione)
            return false;
        if (matricola_azienda == null) {
            return other.matricola_azienda == null;
        } else return matricola_azienda.equals(other.matricola_azienda);
    }
}
