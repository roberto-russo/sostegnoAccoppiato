package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_demarcazione_PSR_id implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2720017660835828783L;

    private Integer anno;
    private String marchioAuricolare;

    public Dmt_t_demarcazione_PSR_id() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Dmt_t_demarcazione_PSR_id(Integer anno, String marchioAuricolare) {
        super();
        this.anno = anno;
        this.marchioAuricolare = marchioAuricolare;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((anno == null) ? 0 : anno.hashCode());
        result = prime * result + ((marchioAuricolare == null) ? 0 : marchioAuricolare.hashCode());
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
        Dmt_t_demarcazione_PSR_id other = (Dmt_t_demarcazione_PSR_id) obj;
        if (anno == null) {
            if (other.anno != null)
                return false;
        } else if (!anno.equals(other.anno))
            return false;
        if (marchioAuricolare == null) {
            return other.marchioAuricolare == null;
        } else return marchioAuricolare.equals(other.marchioAuricolare);
    }
}
