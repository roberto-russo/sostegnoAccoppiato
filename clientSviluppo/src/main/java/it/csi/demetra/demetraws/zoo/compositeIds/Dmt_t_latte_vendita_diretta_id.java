package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;
import java.util.Objects;

public class Dmt_t_latte_vendita_diretta_id implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6671288667490072801L;

    private Long cuua;
    private Long annoCampagna;
    private Long mese;

    public Dmt_t_latte_vendita_diretta_id() {

    }

    public Long getCuua() {
        return cuua;
    }

    public void setCuua(Long cuua) {
        this.cuua = cuua;
    }

    public Long getAnnoCampagna() {
        return annoCampagna;
    }

    public void setAnnoCampagna(Long annoCampagna) {
        this.annoCampagna = annoCampagna;
    }

    public Long getMese() {
        return mese;
    }

    public void setMese(Long mese) {
        this.mese = mese;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dmt_t_latte_vendita_diretta_id that = (Dmt_t_latte_vendita_diretta_id) o;
        return Objects.equals(cuua, that.cuua) &&
                Objects.equals(annoCampagna, that.annoCampagna) &&
                Objects.equals(mese, that.mese);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuua, annoCampagna, mese);
    }
}
