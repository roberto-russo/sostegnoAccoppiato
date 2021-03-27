package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_w_Tpremio_zoo_id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DMT_W_TPREMIO_ZOO")
@IdClass(Dmt_w_Tpremio_zoo_id.class)
public class Dmt_w_Tpremio_zoo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8597274421755170023L;

    @Id
    @Column(name = "id_sessione")
    private Long idSessione;

    /*
     * Rif azienda
     */
    @Id
    @Column(name = "ID_AZIENDA")
    @NotNull
    private Long id_azienda;

    /*
     * Versione
     */
    @Id
    @Column(name = "VERSIONE")
    @NotNull
    private Long versione;

    /*
     * Codice allevamento BDN
     */
    @Id
    @Column(name = "COD_ALLEVAMENTO")
    @NotNull
    private String cod_allevamento;

    /*
     * ID allevamento BDN
     */
    @Id
    @Column(name = "ID_ALLEV_BDN")
    @NotNull
    private String id_allev_bdn;

    /*
     * Codice specie
     */
    @Id
    @Column(name = "SCO_SPECIE")
    @NotNull
    private String sco_specie;

    /*
     * sottcodice specie
     */
    @Id
    @Column(name = "COD_SPECIE")
    @NotNull
    private String cod_specie = "TCA";

    /*
     * Denominazione
     */
    @Column(name = "DENOMINAZIONE")
    @NotNull
    private String denominazione;

    /*
     * Codice Titolarità
     */
    @Column(name = "COD_TITOLARITA")
    @NotNull
    private String cod_titolarita = "TCP";

    /*
     * Sottocodice Titolarità
     */
    @Column(name = "SCO_TITOLARITA")
    @NotNull
    private String sco_titolarita;

    /*
     * Indirizzo
     */
    @Column(name = "INDIRIZZO")
    @NotNull
    private String indirizzo;

    /*
     * Frazione
     */
    @Column(name = "FRAZIONE")
    private String frazione;

    /*
     * Provincia
     */
    @Column(name = "COD_ISTAT_PROV")
    private String cod_istat_prov;

    /*
     * Comune
     */
    @Column(name = "COD_ISTAT_COM")
    @NotNull
    private String cod_istat_com;

    /*
     * CAP
     */
    @Column(name = "CAP")
    private String cap;

    /*
     * Telefono
     */
    @Column(name = "TELEFONO")
    private String telefono;

    /*
     * Codice ASL
     */
    @Column(name = "COD_ASL")
    @NotNull
    private String cod_asl;

    /*
     * Data scarico da BDN
     */
    @Column(name = "DATA_SCARICO")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date data_scarico;

    /*
     * Id fiscale da BDN
     */
    @Column(name = "ID_FISCALE")
    private String id_fiscale;

    /*
     * Premio Vacche da Latte (art. 20)
     */
    @Column(name = "VACCHE_LATTE")
    private String vacche_latte;

    /*
     * premio Aggiuntivo Vacche da Latte, presenti per almeno 6 mesi in zone montane
     * (art. 20)
     */
    @Column(name = "VACCHE_MONTAGNA")
    private String vacche_montagna;

    /*
     * Premio Bufale (art. 20)
     */
    @Column(name = "BUFALE")
    private String bufale;

    /*
     * Premio Vacche nutrici da carne (art. 21)
     */
    @Column(name = "VACCHE_NUTRICI")
    private String vacche_nutrici;

    /*
     * Premio Vacche nutrici a duplice attitudine (art. 21)
     */
    @Column(name = "VACCHE_NUTRICI_DA")
    private String vacche_nutrici_da;

    /*
     * Premio Aggiuntivo vacche nutrici di allevamenti che aderiscono a piani di
     * gestione della razza finalizzati al risanamento dal virus responsabile della
     * IBR (art. 21)
     */
    @Column(name = "VACCHE_CARNE_IBR")
    private String vacche_carne_ibr;

    /*
     * Premio Bovini macellati di almeno 6 mesi (art. 21)
     */
    @Column(name = "BOVINI_MACELLATI")
    private String bovini_macellati;

    /*
     * Premio Aggiuntivo Bovini macellati di almeno 12 mesi (art. 21)
     */
    @Column(name = "MACELLATI_12_MESI")
    private String macellati_12_mesi;

    /*
     * Premio Aggiuntivo Bovini macellati aderenti a sistemi di qualità nazionale o
     * regionale (art. 21)
     */
    @Column(name = "MACELLATI_QUALITA")
    private String macellati_qualita;

    /*
     * Premio Aggiuntivo Bovini macellati allevati in conformità ad un disciplinare
     * di etichettatura facoltativa approvato dal Mipaaf (art. 21)
     */
    @Column(name = "MACELLATI_ETICHETTATURA")
    private String macellati_etichettatura;

    /*
     * Premio Aggiuntivo Bovini macellati certificati ai sensi del reg. UE 1151/2012
     * (art. 21)
     */
    @Column(name = "MACELLATI_IGP")
    private String macellati_igp;

    /*
     * premio Agnelle da rimonta
     */
    @Column(name = "AGNELLE_RIMONTA")
    private String agnelle_rimonta;

    /*
     * Premio Capi Ovini e Caprini macellati
     */
    @Column(name = "OVICAPRINI_MACELLATI")
    private String ovicaprini_macellati;

    /*
     * Premio Vacche nutrici non iscritte nei Libri genialogici o registro
     * anagrafico - premio 322
     */
    @Column(name = "VACCHE_NUTRICI_NG")
    private String vacche_nutrici_ng;

    /**
     * Metodo getter che ritorna il Rif azienda
     *
     * @return id_azienda Rif azienda
     */
    public Long getId_azienda() {
        return id_azienda;
    }

    /**
     * Metodo getter che ritorna la versione
     *
     * @return versione
     */
    public Long getVersione() {
        return versione;
    }

    /**
     * Meotdo getter che ritorna il codice allevamento in BDN
     *
     * @return cod_allevamento codice allevamento in BDN
     */
    public String getCod_allevamento() {
        return cod_allevamento;
    }

    /**
     * Metodo getter che ritorna l'id alevamento in BDN
     *
     * @return id_allev_bdn id allevamento in BDN
     */
    public String getId_allev_bdn() {
        return id_allev_bdn;
    }

    /**
     * Metodo getter che ritorna il codice specie
     *
     * @return sco_specie codice specie
     */
    public String getSco_specie() {
        return sco_specie;
    }

    /**
     * Metodo getter che ritorna il sottocodice specie
     *
     * @return cod_specie sottocodice specie
     */
    public String getCod_specie() {
        return cod_specie;
    }

    /**
     * Metodo getter che ritorna la denominaizone
     *
     * @return denominazione
     */
    public String getDenominazione() {
        return denominazione;
    }

    /**
     * Metodo setter che imposta la denominazione
     *
     * @param denominazione denominazione
     */
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    /**
     * Metodo getter che ritorna il codice titolarità
     *
     * @return cod_titolarità
     */
    public String getCod_titolarita() {
        return cod_titolarita;
    }

    /**
     * Metodo setter che imposta il codice titolarità
     *
     * @param cod_titolarita codice di ritolarità
     */
    public void setCod_titolarita(String cod_titolarita) {
        this.cod_titolarita = cod_titolarita;
    }

    /**
     * Metodo getter che ritorna il sottocodice di titolarità
     *
     * @return sco_titolarita
     */
    public String getSco_titolarita() {
        return sco_titolarita;
    }

    /**
     * Metodoo setter che imposta il sottocodice di titolarità
     *
     * @param sco_titolarita sottocodice di titolarità
     */
    public void setSco_titolarita(String sco_titolarita) {
        this.sco_titolarita = sco_titolarita;
    }

    /**
     * Metodo getter che ritorna l'indirizzo dell'azienda
     *
     * @return indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Metodo setter che ritorna l'indirizzo dell'azienda
     *
     * @param indirizzo indirizzo dell'azienda
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getFrazione() {
        return frazione;
    }

    public void setFrazione(String frazione) {
        this.frazione = frazione;
    }

    public String getCod_istat_prov() {
        return cod_istat_prov;
    }

    public void setCod_istat_prov(String cod_istat_prov) {
        this.cod_istat_prov = cod_istat_prov;
    }

    public String getCod_istat_com() {
        return cod_istat_com;
    }

    public void setCod_istat_com(String cod_istat_com) {
        this.cod_istat_com = cod_istat_com;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCod_asl() {
        return cod_asl;
    }

    public void setCod_asl(String cod_asl) {
        this.cod_asl = cod_asl;
    }

    public Date getData_scarico() {
        return data_scarico;
    }

    public void setData_scarico(Date data_scarico) {
        this.data_scarico = data_scarico;
    }

    public String getId_fiscale() {
        return id_fiscale;
    }

    public void setId_fiscale(String id_fiscale) {
        this.id_fiscale = id_fiscale;
    }

    public String getVacche_latte() {
        return vacche_latte;
    }

    public void setVacche_latte(String vacche_latte) {
        this.vacche_latte = vacche_latte;
    }

    public String getVacche_montagna() {
        return vacche_montagna;
    }

    public void setVacche_montagna(String vacche_montagna) {
        this.vacche_montagna = vacche_montagna;
    }

    public String getBufale() {
        return bufale;
    }

    public void setBufale(String bufale) {
        this.bufale = bufale;
    }

    public String getVacche_nutrici() {
        return vacche_nutrici;
    }

    public void setVacche_nutrici(String vacche_nutrici) {
        this.vacche_nutrici = vacche_nutrici;
    }

    public String getVacche_nutrici_da() {
        return vacche_nutrici_da;
    }

    public void setVacche_nutrici_da(String vacche_nutrici_da) {
        this.vacche_nutrici_da = vacche_nutrici_da;
    }

    public String getVacche_carne_ibr() {
        return vacche_carne_ibr;
    }

    public void setVacche_carne_ibr(String vacche_carne_ibr) {
        this.vacche_carne_ibr = vacche_carne_ibr;
    }

    public String getBovini_macellati() {
        return bovini_macellati;
    }

    public void setBovini_macellati(String bovini_macellati) {
        this.bovini_macellati = bovini_macellati;
    }

    public String getMacellati_12_mesi() {
        return macellati_12_mesi;
    }

    public void setMacellati_12_mesi(String macellati_12_mesi) {
        this.macellati_12_mesi = macellati_12_mesi;
    }

    public String getMacellati_qualita() {
        return macellati_qualita;
    }

    public void setMacellati_qualita(String macellati_qualita) {
        this.macellati_qualita = macellati_qualita;
    }

    public String getMacellati_etichettatura() {
        return macellati_etichettatura;
    }

    public void setMacellati_etichettatura(String macellati_etichettatura) {
        this.macellati_etichettatura = macellati_etichettatura;
    }

    public String getMacellati_igp() {
        return macellati_igp;
    }

    public void setMacellati_igp(String macellati_igp) {
        this.macellati_igp = macellati_igp;
    }

    public String getAgnelle_rimonta() {
        return agnelle_rimonta;
    }

    public void setAgnelle_rimonta(String agnelle_rimonta) {
        this.agnelle_rimonta = agnelle_rimonta;
    }

    public String getOvicaprini_macellati() {
        return ovicaprini_macellati;
    }

    public void setOvicaprini_macellati(String ovicaprini_macellati) {
        this.ovicaprini_macellati = ovicaprini_macellati;
    }

    public String getVacche_nutrici_ng() {
        return vacche_nutrici_ng;
    }

    public void setVacche_nutrici_ng(String vacche_nutrici_ng) {
        this.vacche_nutrici_ng = vacche_nutrici_ng;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione.getIdSessione();
    }

    public void setId_azienda(Long id_azienda) {
        this.id_azienda = id_azienda;
    }

    public void setVersione(Long versione) {
        this.versione = versione;
    }

    public void setCod_allevamento(String cod_allevamento) {
        this.cod_allevamento = cod_allevamento;
    }

    public void setId_allev_bdn(String id_allev_bdn) {
        this.id_allev_bdn = id_allev_bdn;
    }

    public void setSco_specie(String sco_specie) {
        this.sco_specie = sco_specie;
    }

    public void setCod_specie(String cod_specie) {
        this.cod_specie = cod_specie;
    }
}
