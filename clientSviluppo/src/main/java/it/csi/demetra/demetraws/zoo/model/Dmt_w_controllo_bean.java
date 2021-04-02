package it.csi.demetra.demetraws.zoo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Dmt_w_controllo_bean")
public class Dmt_w_controllo_bean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9043782102493365039L;

    @Id
    private String codice;
    /**
     * Codice intervento
     */

    private String bean;
    /**
     * Classe di calcolo associata al codice intervento
     * @return
     */

    /**
     * Metodo getter che ritorna il codice intervento
     * @return codice codice intervento
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Metodo setter che imposta il codice intervento
     * @param codice codice intervento
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * Metodo getter che ritorna la classe di calcolo associata al codice intervento
     * @return bean classe di calcolo associata al codice intervento
     */
    public String getBean() {
        return bean;
    }

    /**
     * Metodo getter che imposta la classe di calcolo associata al codice intervento
     * @param bean classe di calcolo associata al codice intervento
     */
    public void setBean(String bean) {
        this.bean = bean;
    }
}
