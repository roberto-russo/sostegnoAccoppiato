package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_d_logger_id implements Serializable {

    private static final long serialVersionUID = -4381086099452384189L;

    private Long idSessione;
    private Long idLog;


    public Dmt_d_logger_id() {
        super();
    }

    public Dmt_d_logger_id(Long idSessione, Long idLog) {
        super();
        this.idSessione = idSessione;
        this.idLog = idLog;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idLog == null) ? 0 : idLog.hashCode());
        result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
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
        Dmt_d_logger_id other = (Dmt_d_logger_id) obj;
        if (idLog == null) {
            if (other.idLog != null)
                return false;
        } else if (!idLog.equals(other.idLog))
            return false;
        return idSessione == other.idSessione;
    }
}
