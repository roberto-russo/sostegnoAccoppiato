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
    private int annoCampagna;

    @Column(name = "CODICE_MISURA")
    @NotNull
    private String codiceMisura;

    @Column(name = "ID_PRATICA")
    private int idPratica;

    @Column(name = "IDENTIFICATIVO")
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
    private String cuaa;

    @Column(name = "DENOMINAZIONE")
    private String denominazione;

    @Column(name = "ID_STATO_PRATICA")
    private int idStatoPratica;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @Id
    @Column(name = "CODICE_PREMIO")
    @NotNull
    private String codicePremio;

    
    
    
    public void setIdentificativo(long identificativo) {
		this.identificativo = identificativo;
	}

	public int getAnnoCampagna() {
        return annoCampagna;
    }

    public void setAnnoCampagna(int annoCampagna) {
        this.annoCampagna = annoCampagna;
    }

    public String getCodiceMisura() {
        return codiceMisura;
    }

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

    public String getCuaa() {
        return cuaa;
    }

    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    public String getDenominazione() {
        return denominazione;
    }

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

    public String getCodicePremio() {
        return codicePremio;
    }

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
