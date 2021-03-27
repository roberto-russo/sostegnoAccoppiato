package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_Ref9903_id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "DMT_T_CONTROLLO_UBA_MINIME")
@IdClass(Dmt_d_Ref9903_id.class)
public class Dmt_t_ControlloUbaMinime implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5957063405415650073L;

    @Id
    @Column(name = "id_sessione")
    /**
     * codice sessione associato all'esecuzione
     */
    private Long idSessione;

    @Id
    /**
     * codice fiscale del richiedente
     */
    private String cuaa;

    @Column(name = "esito")
    /**
     * esito del controllo
     */
    private String esito;

    @Column(name = "uba")
    /**
     * unità bovina adulta
     */
    private Double uba;

    @Column(name = "motivazioni")
    /**
     * nel caso in cui il controllo delle uba minime fallisce, viene fornita una
     * descrizione delle motivazioni del fallimento
     */
    private String motivazioni;

    @Column(name = "anno_campagna")
    @NotNull
    /**
     * anno campagna
     */
    private Long annoCampagna;

    /**
     * metodo getter che ritorna il codice di sessione associato all'esecuzione
     *
     * @return sessione codice di sessione associato all'esecuzione
     */
    public Long getIdSessione() {
        return idSessione;
    }

    /**
     * metodo setter che imposta il codice di sessione associato all'esecuzione.
     *
     * @param sessione codice di sessione associato all'esecuzione.
     */
    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione.getIdSessione();
    }

    /**
     * metodo getter che ritorna il codice fiscale del richiedente
     *
     * @return cuaa codice fiscale del richiedente
     */
    public String getCuaa() {
        return cuaa;
    }

    /**
     * metodo setter che imposta il codice fiscale del richiedente
     *
     * @param cuaa codice fiscale del richiedente.
     */
    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    /**
     * metodo getter che ritorna l'esito del controllo
     *
     * @return esito esito del controllo delle uba minime richieste
     */
    public String getEsito() {
        return esito;
    }

    /**
     * metodo setter che imposta l'esito del controllo
     *
     * @param esito esito del controllo delle uba minime richieste
     */
    public void setEsito(String esito) {
        this.esito = esito;
    }

    /**
     * metodo getter che ritorna il numero delle unità bovine aulte
     *
     * @return uba unità bovina adulta
     */
    public Double getUba() {
        return uba;
    }

    /**
     * metodo setter che ritorna il numero delle unità bovine adulte
     *
     * @param uba unità bovina adulta
     */
    public void setUba(Double uba) {
        this.uba = uba;
    }

    /**
     * metodo getter che ritorna le motivazioni di fallimento del controllo
     *
     * @return motivazioni motivazioni di fallimento del controllo
     */
    public String getMotivazioni() {
        return motivazioni;
    }

    /**
     * metodo setter che imposta le motivazioni di fallimento del controllo
     *
     * @param motivazioni motivazioni di fallimento del controllo
     */
    public void setMotivazioni(String motivazioni) {
        this.motivazioni = motivazioni;
    }

    /**
     * metodo getter che ritorna l'anno campagna
     *
     * @return annoCampagna anno campagna
     */
    public Long getAnnoCampagna() {
        return annoCampagna;
    }

    /**
     * metodo setter che imposta l'anno campagna
     *
     * @param annoCampagna anno della campagna
     */
    public void setAnnoCampagna(Long annoCampagna) {
        this.annoCampagna = annoCampagna;
    }

//	public Long getIdSessione() {
//		return idSessione;
//	}
//
//	public void setIdSessione(Long idSessione) {
//		this.idSessione = idSessione;
//	}

}
