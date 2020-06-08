package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import it.csi.demetra.demetraws.zoo.compositeIds.Rpu_V_pratica_zoote_id;

@Entity
@Table(name = "RPU_V_PRATICA_ZOOTE")
@IdClass(Rpu_V_pratica_zoote_id.class)
public class Rpu_V_pratica_zoote implements Serializable {
    /**
     *
     */
   
	private static final long serialVersionUID = -3507870865737703825L;


	@Id
    @Column(name = "ANNO_CAMPAGNA")
    @NotNull
    /**
     * Anno della campagna
     */
    private int annoCampagna;

    @Column(name = "CODICE_MISURA")
    @NotNull
    /**
     * Codice della misura associata al codice premio
     */
    private String codiceMisura;

    @Column(name = "ID_PRATICA")
    /**
     * Identificativo univoco associato alla pratica
     */
    private int idPratica;

    @Column(name = "IDENTIFICATIVO")
    /**
     * Identificativo univoco dell'allevamento
     */
    private long identificativo;

    @Column(name = "ID_FASE_AVANZAMENTO")
    private int idFaseAvanzamento;

    @Column(name = "TIPO_FASE")
    private int tipoFase;

    @Column(name = "EXT_ID_AZIENDA")
    private int extIdAzienda;

    @Id
    @Column(name = "CUAA")
    @NotNull
    /**
     * Codice fiscale del richiedente
     */
    private String cuaa;

    @Column(name = "DENOMINAZIONE")
    /**
     * Denominazione del richiedente
     */
    private String denominazione;

    @Column(name = "ID_STATO_PRATICA")
    private int idStatoPratica;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @Id
    @Column(name = "CODICE_PREMIO")
    @NotNull
    /**
     * Codice intervento
     */
    private String codicePremio;

    
    
    
    public void setIdentificativo(long identificativo) {
		this.identificativo = identificativo;
	}

    /**
     * Metodo getter che ritorna l'anno della campagna
     * @return annoCampagna anno della campagna
     */
	public int getAnnoCampagna() {
        return annoCampagna;
    }

	/**
	 * Metodo setter che imposta l'anno della campagna
	 * @param annoCampagna anno della campagna
	 */
    public void setAnnoCampagna(int annoCampagna) {
        this.annoCampagna = annoCampagna;
    }

    /**
     * Metodo getter che imposta il codice misura
     * @return codiceMisura codice della misucra associato al codice intervento
     */
    public String getCodiceMisura() {
        return codiceMisura;
    }

    /**
     * Metodo setter che imposta il codice misura associato al codice intervento
     * @param codiceMisura codice misura associato al codice intervento
     */
    public void setCodiceMisura(String codiceMisura) {
        this.codiceMisura = codiceMisura;
    }

    public int getIdPratica() {
        return idPratica;
    }

    public void setIdPratica(int idPratica) {
        this.idPratica = idPratica;
    }

    public long getIdentificativo() {
        return identificativo;
    }

    public void setIdentificativo(int identificativo) {
        this.identificativo = identificativo;
    }

    public int getIdFaseAvanzamento() {
        return idFaseAvanzamento;
    }

    public void setIdFaseAvanzamento(int idFaseAvanzamento) {
        this.idFaseAvanzamento = idFaseAvanzamento;
    }

    public int getTipoFase() {
        return tipoFase;
    }

    public void setTipoFase(int tipoFase) {
        this.tipoFase = tipoFase;
    }

    public int getExtIdAzienda() {
        return extIdAzienda;
    }

    public void setExtIdAzienda(int extIdAzienda) {
        this.extIdAzienda = extIdAzienda;
    }

    /**
     * Metodo getter che ritorna il codice fiscale del richiedente
     * @return
     */
    public String getCuaa() {
        return cuaa;
    }

    /**
     * Metodo setter che imposta il codice fiscale del richiedente
     * @param cuaa
     */
    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    /**
     * Metodo getter che ritorna la denomionazione del richiedente
     * @return
     */
    public String getDenominazione() {
        return denominazione;
    }

    /**
     * Metodo setter che imposta la denominazione del richiedente
     * @param denominazione
     */
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public int getIdStatoPratica() {
        return idStatoPratica;
    }

    public void setIdStatoPratica(int idStatoPratica) {
        this.idStatoPratica = idStatoPratica;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Metodo getter che ritorna il codice intervento
     * @return codicePremio codice dell'intervento
     */
    public String getCodicePremio() {
        return codicePremio;
    }
    
    /**
     * Metodo setter che imposta il codice intervento 
     * @param codicePremio codice intervento
     */
    public void setCodicePremio(String codicePremio) {
        this.codicePremio = codicePremio;
    }

	@Override
	public String toString() {
		return "Rpu_V_pratica_zoote [annoCampagna=" + annoCampagna + ", codiceMisura=" + codiceMisura + ", idPratica="
				+ idPratica + ", identificativo=" + identificativo + ", idFaseAvanzamento=" + idFaseAvanzamento
				+ ", tipoFase=" + tipoFase + ", extIdAzienda=" + extIdAzienda + ", cuaa=" + cuaa + ", denominazione="
				+ denominazione + ", idStatoPratica=" + idStatoPratica + ", descrizione=" + descrizione
				+ ", codicePremio=" + codicePremio + "]";
	}
}
