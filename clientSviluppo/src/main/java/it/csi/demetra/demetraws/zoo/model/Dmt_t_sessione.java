package it.csi.demetra.demetraws.zoo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "DMT_T_SESSIONE")
/**
 * Model per la storicizzazione della sessione. Tutti  gli oggetti salvati
 * a db sono storicizzati attraverso questa classe.
 * @version 0.1 (02-04-2020)
 * @author Bcsoft
 */
public class Dmt_t_sessione implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8933409933588617983L;


    @Column(name = "data_e_ora")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    /**
     * data e ora in cui viene effettuata la sessione.
     */
    private Date dataEora;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sessione")
    @NotNull
    /**
     * id univoco associato all'istanza di sessione.
     */
    private long idSessione;



    /* CHIAVI ESTERNE */

    @OneToMany(mappedBy = "sessione")
    /**
     * lista degli elementi di tipo Dmt_d_clsPremio_ValidazioneResponse
     * associati all'id di sessione attraverso la chiave esterna.
     */
    private List<Dmt_d_clsPremio_ValidazioneResponse> validResp;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_d_esito_controlli_preammissibilita> esitoContr;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_d_Triep_du_premi_capi> premiCapi;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_clsCapoMacellato> capiMacellati;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_clsPremio_Validazione_PP> premioValidazionePP;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_clsPremio_Validazione> premioValidazione;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_coefficienti_uba> coefficientiUBA;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_consistenza_uba_censim_ovini> consistCensimUBAOvini;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_dec_categoria> categoria;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_dec_specie> specie;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_dec_tipologia_gestore> tipologiaGestore;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_errore> errore;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_gestori> gestori;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_Intervento> intervento;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_Tbdn_du_capi> capi;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_Tlatte_mensile_arpea> mensArpea;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_Tlatte_sintesi_analisi> sintesiAnalisi;


    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_Tws_bdn_du_capi_bovini> bovini;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_Tws_bdn_du_capi_ovicaprini> ovicaprini;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_Tzoo_circuiti_qualita> circuitiQualita;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_w_calcoli_interventi> calcoloInterventi;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_w_controlli_preammissibilita> contrPreamm;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_premio_capi> premioCapi;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_w_Tpremio_zoo> premioZoo;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_DsUBA_censimenti_allevamenti_ovini> ubaCensimOvini;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_d_logger> logger;

    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_output_controlli> outputControlli;
    
    @OneToMany(mappedBy = "sessione")
    private List<Dmt_t_output_esclusi> outputEsclusi;

//	@Column(name = "lista_zoote")
//	@OneToMany(mappedBy= "sessione")
//	private List<Rpu_V_pratica_zoote> zoote;



    /* FINE CHIAVI ESTERNE */


    @PrePersist
    public void onCreate() {
        this.dataEora = new Date();
    }

    /**
     * metodo get che ritorna la data e l'ora di storicizzazione
     *
     * @return dataEora data e ora di inserimento elemento di sessione di tipo Date
     */
    public Date getDataEora() {
        return dataEora;
    }

    /**
     * metodo set che imposta l'attributo dataEora.
     *
     * @param dataEora data e ora di inserimento dell'elemento di sessione di tipo Date
     */
    public void setDataEora(Date dataEora) {
        this.dataEora = dataEora;
    }

    /**
     * metodo get che ritorna l'id associato all'elemento di sessione
     *
     * @return idSessione id dell'elemento di sessione di tipo long
     */
    public long getIdSessione() {
        return idSessione;
    }

    /**
     * metodo set che imposta l'attributo idStorico.
     *
     * @oaram idSessione id dell'elemento di sessione.
     */
    public void setIdSessione(long idSessione) {
        this.idSessione = idSessione;
    }
}
