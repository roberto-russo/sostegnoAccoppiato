package it.csi.demetra.demetraws.zoo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe degli ovicaprini
 *
 * @author Bcsoft
 * @version 0.1 (3/04/2020)
 */
@Entity
@Table(name = "DMT_T_TWS_BDN_DU_CAPI_OVICA")
public class Dmt_t_Tws_bdn_du_capi_ovicaprini implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8829170877502816563L;

    public Dmt_t_Tws_bdn_du_capi_ovicaprini() {
    }

    public Dmt_t_Tws_bdn_du_capi_ovicaprini(Dmt_t_Tws_bdn_du_capi_ovicaprini dmt_t_Tws_bdn_du_capi_ovicaprini) {
        this.allevId = dmt_t_Tws_bdn_du_capi_ovicaprini.getAllevId();
        this.capoId = dmt_t_Tws_bdn_du_capi_ovicaprini.getCapoId();
        this.codicePremio = dmt_t_Tws_bdn_du_capi_ovicaprini.getCodicePremio();
        this.codice = dmt_t_Tws_bdn_du_capi_ovicaprini.getCodice();
        this.sesso = dmt_t_Tws_bdn_du_capi_ovicaprini.getSesso();
        this.razzaCodice = dmt_t_Tws_bdn_du_capi_ovicaprini.getRazzaCodice();
        this.dtNascita = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtNascita();
        this.dtInizioDetenzione = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtInizioDetenzione();
        this.dtFineDetenzione = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtFineDetenzione();
        this.dtMacellazione = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtMacellazione();
        this.aziendaCodice = dmt_t_Tws_bdn_du_capi_ovicaprini.getAziendaCodice();
        this.dtRegistrMacellazione = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtRegistrMacellazione();
        this.genotipo = dmt_t_Tws_bdn_du_capi_ovicaprini.getGenotipo();
        this.consMedia = dmt_t_Tws_bdn_du_capi_ovicaprini.getConsMedia();
        this.dtComMacellazione = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtComMacellazione();
        this.dtUltimoPrelProfilassi = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtUltimoPrelProfilassi();
        this.dtComNascita = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtComNascita();
        this.dtInserimentoBdnNascita = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtInserimentoBdnNascita();
        this.dtApplMarchio = dmt_t_Tws_bdn_du_capi_ovicaprini.getDtApplMarchio();
        this.cuaa = dmt_t_Tws_bdn_du_capi_ovicaprini.getCuaa();
        this.flagDelegatoNascita = dmt_t_Tws_bdn_du_capi_ovicaprini.getFlagDelegatoNascita();
        this.ruoloUtenteNascita = dmt_t_Tws_bdn_du_capi_ovicaprini.getRuoloUtenteNascita();
    }

    @Id
    @GeneratedValue(generator = "seq_dmt_t_bdn_du_capi_ov")
    @SequenceGenerator(name = "seq_dmt_t_bdn_du_capi_ov", sequenceName = "SEQ_DMT_T_BDN_DU_CAPI_OV", allocationSize = 1)
    @Column(name = "id_autogenerato")
    private Long idAutogenerato;


    @ManyToOne
    @JoinColumn(name = "id_sessione", nullable = false)
    /**
     * Identificativo univoco associato all'esecuzione
     */
    private Dmt_t_sessione idSessione;

    @ManyToOne
    @JoinColumn(name = "FK_DMT_D_CLS_PREM_VALID", nullable = true)
    private Dmt_d_clsPremio_ValidazioneResponse dmt_d_clsPremio_ValidazioneResponse;

    @Column(name = "ID_ALLEVAMENTO")
    @NotNull
    /**
     * Identificativo univoco in BDN dell'allevamento
     */
    private long allevId;

    @Column(name = "ID_CAPO")
    @NotNull
    /**
     * Identificativo univoco in BDN del capo animale
     */
    private long capoId;

    @Column(name = "CODICE_PREMIO")
    @NotNull
    /**
     * Codice intervento
     */
    private String codicePremio;

    @Column(name = "CODICE")
    /**
     * Codice della marca auricolare applicata al capo animale
     */
    private String codice;

    @Column(name = "SESSO")
    /**
     * sesso del capo animale
     */
    private String sesso;

    @Column(name = "COD_RAZZA")
    /**
     * Codice della razza del capo animale
     */
    private String razzaCodice;

    @Column(name = "DATA_NASCITA")
    @Temporal(TemporalType.DATE)
    /**
     * Data di nascita del capo animale
     */
    private Date dtNascita;

    @Column(name = "DATA_INIZIO_DETENZIONE")
    @Temporal(TemporalType.DATE)
    /**
     * Data di inizio detenzione. E' valorizzata solo se il capo deve verificare in
     * BDN un periodo minimo di detenzione
     */
    private Date dtInizioDetenzione;

    @Column(name = "DATA_FINE_DETENZIONE")
    @Temporal(TemporalType.DATE)
    /**
     * Data di fine detenzione. E' valorizzata solo se il capo deve verificare in
     * BDN un periodo minimo di detenzione
     */
    private Date dtFineDetenzione;

    @Column(name = "DATA_MACELLAZIONE")
    @Temporal(TemporalType.DATE)
    /**
     * Data di macellazione del capo. E' valorizzata solo per i capi che concorrono
     * ai premi di macellazione
     */
    private Date dtMacellazione;

    @Column(name = "COD_AZIENDA")
    /**
     * codice aziendale.
     */
    private String aziendaCodice;

    @Column(name = "DATA_REGISTR_MACELL")
    @Temporal(TemporalType.DATE)
    /**
     * Data di registrazione della macellazione del capo animale
     */
    private Date dtRegistrMacellazione;

    @Column(name = "GENOTIPO")
    /**
     * Genotipo di appartenenza del capo animale
     */
    private String genotipo;

    @Column(name = "CONS_MEDIA")
    /**
     * Media aritmetica dei giorni di presenza del capo rispetto al numero dei
     * giorni dell anno campagna
     */
    private float consMedia;

    @Column(name = "DATA_COM_MACELLAZIONE")
    @Temporal(TemporalType.DATE)
    /**
     * Data di comunicazione all autorita competente della macellazione
     */
    private Date dtComMacellazione;

    @Column(name = "DATA_ULTIMO_PREL_PROFILASSI")
    @Temporal(TemporalType.DATE)
    /**
     * Data dell eventuale ultimo prelievo di profilassi effettuato
     */
    private Date dtUltimoPrelProfilassi;

    @Column(name = "DATA_COM_NASCITA")
    @Temporal(TemporalType.DATE)
    /**
     * Data di comunicazione all autorita competente della nascita del capo
     */
    private Date dtComNascita;

    @Column(name = "DATA_INSERIMENTO_BDN_NASCITA")
    @Temporal(TemporalType.DATE)
    /**
     * Data di registrazione in BDN della nascita del capo
     */
    private Date dtInserimentoBdnNascita;

    @Column(name = "DATA_APPL_MARCHIO")
    @Temporal(TemporalType.DATE)
    /**
     * Data di identificazione del capo
     */
    private Date dtApplMarchio;

    @Column(name = "CUAA")
    /**
     * Codice fiscale del richiedente
     */
    private String cuaa;

    @Column(name = "FLAG_DELEGATO_NASCITA")
    /**
     * Flag che assume i seguenti valori: N= se il capo è stato iscritto dal
     * detentore (e quindi non ha delegato altri ad operare in BDN) R= se la delega
     * è regionale. In questo caso esiste un polo regionale che ha registrato la
     * nascita del capo S= in tutti gli altri casi in cui il delegato è uno dei
     * soggetti previsti dalla normativa in grado di operare in BDN su delega
     * implicita o esplicita dell’allevatore (Associazione Professionale, Servizio
     * Veterinario o Veterinario Aziendale )
     */
    private String flagDelegatoNascita;

    @Column(name = "RUOLO_UTENTE_NASCITA")
    /**
     * Acronimo che rappresenta il tipo delegato che ha effettuato l’iscrizione del
     * capo in BDN. Può assumere i seguenti valori: REG = il delegato è la regione
     * che possiede il polo regionale. La delega reale va recuperata dalle BDR in
     * questione ASS = Associazione professionale ASL = Servizio veterinario
     * competente sull’azienda VET = Veterinario Aziendale DET = Detentore
     * dell’allevamento
     */
    private String ruoloUtenteNascita;

    public Dmt_d_clsPremio_ValidazioneResponse getDmt_d_clsPremio_ValidazioneResponse() {
        return dmt_d_clsPremio_ValidazioneResponse;
    }

    public void setDmt_d_clsPremio_ValidazioneResponse(
            Dmt_d_clsPremio_ValidazioneResponse dmt_d_clsPremio_ValidazioneResponse) {
        this.dmt_d_clsPremio_ValidazioneResponse = dmt_d_clsPremio_ValidazioneResponse;
    }

    public Long getIdAutogenerato() {
        return idAutogenerato;
    }

    public void setIdAutogenerato(Long idAutogenerato) {
        this.idAutogenerato = idAutogenerato;
    }

    /**
     * Metodo get che ritorna l'identificativo univoco dell'allevamento
     *
     * @return allevId identificativo univoco dell'allevamento
     */
    public long getAllevId() {
        return allevId;
    }

    /**
     * Metodo set che setta l'identificativo univoco dell'allevamento
     *
     * @param allevId identificativo univoco dell'allevamento
     */
    public void setAllevId(long allevId) {
        this.allevId = allevId;
    }

    /**
     * Metodo get che ritorna l'identificativo univoco del capo ovino
     *
     * @return capoId identificativo univoco del capo ovino
     */
    public long getCapoId() {
        return capoId;
    }

    /**
     * Metodo set che setta l'identificativo univoco del capo ovino
     *
     * @param capoId identificativo del capo univoco.
     */
    public void setCapoId(long capoId) {
        this.capoId = capoId;
    }

    /**
     * Metodo get che ritorna il codice della marca auricolare applicata al capo
     * ovino
     *
     * @return codice codice della marca auricolare applicata al capo ovino
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Metodo set che setta il codice della marca auricolare applicata al capo ovino
     *
     * @param codice codice della marca auricolare applicata al capo ovino
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * Metodo get che ritorna il sesso del capo ovino
     *
     * @return sesso sesso del capo ovino
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * Metodo set che setta il sesso del capo ovino
     *
     * @param sesso sesso del capo ovino
     */
    public void setSesso(String obj) {
        this.sesso = null != obj ? obj.trim() : null;
    }

    /**
     * Metodo get che ritorna il codice della razza del capo ovino
     *
     * @return razzaCodice codice della razza del capo ovino
     */
    public String getRazzaCodice() {
        return razzaCodice;
    }

    /**
     * Metodo set che setta il ocdice della razza del capo ovino
     *
     * @param razzaCodice codice della razza del capo ovino
     */
    public void setRazzaCodice(String obj) {
        this.razzaCodice = null != obj ? obj.trim() : null;
    }

    /**
     * Metodo get che ritorna la data di nascita del capo ovino
     *
     * @return dtNascita data di nascita del capo ovino
     */
    public Date getDtNascita() {
        return dtNascita;
    }

    /**
     * Metodo set che setta la data di nascita del capo ovino
     *
     * @param dtNascita data di nascita del capo ovino
     */
    public void setDtNascita(Date dtNascita) {
        this.dtNascita = dtNascita;
    }

    /**
     * Metodo get che ritorna la data di inizio detenzione
     *
     * @return dtInizioDetenzione data di inizio detenzione
     */
    public Date getDtInizioDetenzione() {
        return dtInizioDetenzione;
    }

    /**
     * Metodo che setta la data di inizio detenzione
     *
     * @param dtInizioDetenzione data di inizio detenzione
     */
    public void setDtInizioDetenzione(Date dtInizioDetenzione) {
        this.dtInizioDetenzione = dtInizioDetenzione;
    }

    /**
     * Metodo get che ritorna la data di fine detenzione
     *
     * @return dtFineDetenzione data di fine detenzione
     */
    public Date getDtFineDetenzione() {
        return dtFineDetenzione;
    }

    /**
     * Metodo set che setta la data di fine detenzione
     *
     * @param dtFineDetenzione data di fine detenzione
     */
    public void setDtFineDetenzione(Date dtFineDetenzione) {
        this.dtFineDetenzione = dtFineDetenzione;
    }

    /**
     * Metodo get che ritorna la data di macellazione
     *
     * @return dtMacellazione data di macellazione
     */
    public Date getDtMacellazione() {
        return dtMacellazione;
    }

    /**
     * Metodo set che setta la data di macellazione
     *
     * @param dtMacellazione data di macellazione
     */
    public void setDtMacellazione(Date dtMacellazione) {
        this.dtMacellazione = dtMacellazione;
    }

    /**
     * Metodo get che ritorna il codice aziendale
     *
     * @return aziendaCodice codice aziendale
     */
    public String getAziendaCodice() {
        return aziendaCodice;
    }

    /**
     * Metodo set che setta il codice aziendale
     *
     * @param aziendaCodice codice aziendale
     */
    public void setAziendaCodice(String aziendaCodice) {
        this.aziendaCodice = aziendaCodice;
    }

    /**
     * Metodo get che ritorna il genotipo di appartenenza del capo ovino
     *
     * @return genotipo genotipo di appartenenza del capo ovino
     */
    public String getGenotipo() {
        return genotipo;
    }

    /**
     * Metodo set che setta il genotipo di appartenenza del capo ovino
     *
     * @param genotipo genotipo di appartenenza del capo ovino
     */
    public void setGenotipo(String genotipo) {
        this.genotipo = genotipo;
    }

    /**
     * Metodo get che ritorna la Media aritmetica dei giorni di presenza del capo
     * rispetto al numero dei giorni dell anno campagna
     *
     * @return consMedia Media aritmetica dei giorni di presenza del capo rispetto
     * al numero dei giorni dell anno campagna
     */
    public float getConsMedia() {
        return consMedia;
    }

    /**
     * Metodo set che setta la Media aritmetica dei giorni di presenza del capo
     * rispetto al numero dei giorni dell anno campagna
     *
     * @param consMedia Media aritmetica dei giorni di presenza del capo rispetto al
     *                  numero dei giorni dell anno campagna
     */
    public void setConsMedia(float consMedia) {
        this.consMedia = consMedia;
    }

    /**
     * Metodo get che ritorna la Data di comunicazione all autorita competente della
     * macellazione
     *
     * @return dtComMacellazione Data di comunicazione all autorita competente della
     * macellazione
     */
    public Date getDtComMacellazione() {
        return dtComMacellazione;
    }

    /**
     * Metodo set che setta la Data di comunicazione all autorita competente della
     * macellazione
     *
     * @param dtComMacellazione Data di comunicazione all autorita competente della
     *                          macellazione
     */
    public void setDtComMacellazione(Date dtComMacellazione) {
        this.dtComMacellazione = dtComMacellazione;
    }

    /**
     * Metodo get che ritorna la Data dell eventuale ultimo prelievo di profilassi
     * effettuato
     *
     * @return dtUltimoPrelProfilassi Data dell eventuale ultimo prelievo di
     * profilassi effettuato
     */
    public Date getDtUltimoPrelProfilassi() {
        return dtUltimoPrelProfilassi;
    }

    /**
     * Metodo set che ritorna la Data dell eventuale ultimo prelievo di profilassi
     * effettuato
     *
     * @param dtUltimoPrelProfilassi Data dell eventuale ultimo prelievo di
     *                               profilassi effettuato
     */
    public void setDtUltimoPrelProfilassi(Date dtUltimoPrelProfilassi) {
        this.dtUltimoPrelProfilassi = dtUltimoPrelProfilassi;
    }

    /**
     * Metodo get che ritorna la Data di comunicazione all autorita competente della
     * nascita del capo
     *
     * @return dtComNascita Data di comunicazione all autorita competente della
     * nascita del capo
     */
    public Date getDtComNascita() {
        return dtComNascita;
    }

    /**
     * Metodo set che setta la Data di comunicazione all autorita competente della
     * nascita del capo
     *
     * @param dtComNascita Data di comunicazione all autorita competente della
     *                     nascita del capo
     */
    public void setDtComNascita(Date dtComNascita) {
        this.dtComNascita = dtComNascita;
    }

    /**
     * Metodo get che ritorna Data di registrazione in BDN della nascita del capo
     *
     * @return dtInserimentoBdnNascita Data di registrazione in BDN della nascita
     * del capo
     */
    public Date getDtInserimentoBdnNascita() {
        return dtInserimentoBdnNascita;
    }

    /**
     * Metodo set che setta la Data di registrazione in BDN della nascita del capo
     *
     * @param dtInserimentoBdnNascita Data di registrazione in BDN della nascita del
     *                                capo
     */
    public void setDtInserimentoBdnNascita(Date dtInserimentoBdnNascita) {
        this.dtInserimentoBdnNascita = dtInserimentoBdnNascita;
    }

    /**
     * Metodo get che ritorna la Data di identificazione del capo
     *
     * @return dtApplMarchio Data di identificazione del capo
     */
    public Date getDtApplMarchio() {
        return dtApplMarchio;
    }

    /**
     * Metodo set che setta la Data di identificazione del capo
     *
     * @param dtApplMarchio Data di identificazione del capo
     */
    public void setDtApplMarchio(Date dtApplMarchio) {
        this.dtApplMarchio = dtApplMarchio;
    }

    /**
     * Metodo get che ritorna l'dentificativo fiscale
     *
     * @return cuaa identificativo fiscale
     */
    public String getCuaa() {
        return cuaa;
    }

    /**
     * Metodo set che setta l'identificativo fiscale
     *
     * @param cuaa identificativo fiscale
     */
    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    /**
     * Metodo get che ritorna i seguenti valori: N R S, maggiori dettagli vedere
     * descrizione attributo
     *
     * @return flagDelegatoNascita
     */
    public String getFlagDelegatoNascita() {
        return flagDelegatoNascita;
    }

    /**
     * Metodo che ritorna i seguenti valori: N R S.
     *
     * @param flagDelegatoNascita flag che può assumere i seguenti valori: N R S
     */
    public void setFlagDelegatoNascita(String obj) {
        this.flagDelegatoNascita = null != obj ? obj.trim() : null;
    }

    /**
     * Metodo get che ritorna l'Acronimo che rappresenta il tipo delegato che ha
     * effettuato l’iscrizione del capo in BDN.
     *
     * @return ruoloUtenteNascita
     */
    public String getRuoloUtenteNascita() {
        return ruoloUtenteNascita;
    }

    /**
     * Metodo set che setta l'Acronimo che rappresenta il tipo delegato che ha
     * effettuato l’iscrizione del capo in BDN.
     *
     * @param ruoloUtenteNascita acronimo che rappresenta il tipo delegato.
     *                           effettuato l'iscrizione del capo in BDN
     */
    public void setRuoloUtenteNascita(String obj) {
        this.ruoloUtenteNascita = null != obj ? obj.trim() : null;
    }

    /**
     * Metodo get che ritorna la Data di registrazione della macellazione del capo
     * ovino
     *
     * @return dtRegistrMacellazione Data di registrazione della macellazione del
     * capo ovino
     */
    public Date getDtRegistrMacellazione() {
        return dtRegistrMacellazione;
    }

    /**
     * Metodo set che setta la Data di registrazione della macellazione del capo
     * ovino
     *
     * @param dtRegistrMacellazione Data di registrazione della macellazione del
     *                              capo ovino
     */
    public void setDtRegistrMacellazione(Date dtRegistrMacellazione) {
        this.dtRegistrMacellazione = dtRegistrMacellazione;
    }

    /**
     * Metodo getter che ritorna l'identificativo univoco associato all'esecuzione
     *
     * @return idSessione identificativo univoco associato all'esecuzione
     */
    public Dmt_t_sessione getIdSessione() {
        return this.idSessione;
    }

    /**
     * Metodo setter che imposta il codice indetificativo associato all'esecuzione
     *
     * @param sessione identificativo univoco associato all'esecuzione
     */
    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione;
    }

    /**
     * Metodo getter che ritorna il codice intervento
     *
     * @return codicePremio codice intervento
     */
    public String getCodicePremio() {
        return codicePremio;
    }

    /**
     * Metodo setter che imposta il codice intervento
     *
     * @param codicePremio codice intervento
     */
    public void setCodicePremio(String codicePremio) {
        this.codicePremio = codicePremio;
    }

}
