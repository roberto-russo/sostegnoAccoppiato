package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_consistenza_uba_censim_ovini_id;


@Entity
@Table(name = "DMT_T_CONSIST_UBA_CENSIM_OVINI")
/**
 * Classe model con parametri di ingresso per il metodo Consistenza_UBA_Censim_Ovini
 * @version 0.1 (02/04/2020)
 * @author bcsoft
 */
@IdClass(Dmt_t_consistenza_uba_censim_ovini_id.class)
public class Dmt_t_consistenza_uba_censim_ovini implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6260458970616077053L;

    @Id
  	@Column(name = "id_sessione")
  	private Long idSessione;
  	
  	@MapsId
  	@ManyToOne
  	@JoinColumn(name = "id_sessione", nullable = false)
  	/**
  	 * codice sessione associato all'esecuzione.
  	 */
  	private Dmt_t_sessione sessione;

  	@Id
    @Column(name = "p_cuaa", length = 16)
    @NotNull
    /**
     * Codice fiscale del soggetto proprietario e/o detentore
     */
    private String pCuaa;

    @Column(name = "data_inizio_periodo", length = 400)
    /**
     * Data di inizio del periodo espressa nel formato dd/mm/yyyy
     */
    private String dataInizioPeriodo;

    @Column(name = "data_fine_periodo", length = 400)
    /**
     * Data di fine periodo espressa nel formato dd/mm/yyyy
     */
    private String dataFInePeriodo;

    @Column(name = "p_tipo_responsabilita", length = 400)
    /**
     * Flag che rappresenta il tipo di responsabilità rispetto alla quale si vuole filtrare gli allevamenti
     */
    private String pTipoResponsabilita;


    /**
     * Recupera il codice fiscale del soggetto proprietario e/o detentore
     *
     * @return pCuaa il codice fiscale del detentore
     */
    public String getpCuaa() {
        return pCuaa;
    }

    /**
     * Recupera la data di inizio del periodo
     *
     * @return dataInizioPeriodo la data di inizio del periodo
     */
    public String getDataInizioPeriodo() {
        return dataInizioPeriodo;
    }

    /**
     * Imposta la data di inizio del periodo
     *
     * @param dataInizioPeriodo la data di inizio del periodo
     */
    public void setDataInizioPeriodo(String dataInizioPeriodo) {
        this.dataInizioPeriodo = dataInizioPeriodo;
    }

    /**
     * Recupera la data di fine del periodo
     *
     * @return dataFInePeriodo la data di fine del periodo
     */
    public String getDataFInePeriodo() {
        return dataFInePeriodo;
    }

    /**
     * Imposta la data di fine del periodo
     *
     * @param dataFInePeriodo la data di fine del periodo
     */
    public void setDataFInePeriodo(String dataFInePeriodo) {
        this.dataFInePeriodo = dataFInePeriodo;
    }

    /**
     * Recupera il flag di la responsabilità con il quale si vuole filtrare gli allevamenti
     *
     * @return pTipoResponsabilita il flag di la responsabilità con il quale si vuole filtrare gli allevamenti
     */
    public String getpTipoResponsabilita() {
        return pTipoResponsabilita;
    }

    /**
     * Recupera il flag di responsabilità con il quale si vuole filtrare gli allevamenti
     *
     * @param pTipoResponsabilita il flag di la responsabilità con il quale si vuole filtrare gli allevamenti
     */
    public void setpTipoResponsabilita(String pTipoResponsabilita) {
        this.pTipoResponsabilita = pTipoResponsabilita;
    }

    /**
     * metodo getter che ritorna il codice di sessione associato all'esecuzione
     * @return sessione codice di sessione associato all'esecuzione.
     */
    public Dmt_t_sessione getSessione() {
        return sessione;
    }

    /**
     * metodo setter che imposta il codice di sessione associato all'esecuzione
     * @param sessione codice di sessione associato all'esecuzione.
     */
    public void setSessione(Dmt_t_sessione sessione) {
        this.sessione = sessione;
    }

    /**
     * metodo setter che imposta il codice fiscale del soggetto proprietario e/o detentore
     * @param pCuaa codice fiscale del soggetto proprietario e/o detentore.
     */
	public void setpCuaa(String pCuaa) {
		this.pCuaa = pCuaa;
	}

	/**
	 * metodo getter che ritorna il codice di sessione associato all'esecuzione.
	 * @return idSessione codice di sessione associato all'esecuzione.
	 */
	public Long getIdSessione() {
		return idSessione;
	}

	/**
	 * metodo setter che imposta il codice di sessione associato all'esecuzione
	 * @param idSessione codice di sessione associato all'esecuzione.
	 */
	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}
	
}