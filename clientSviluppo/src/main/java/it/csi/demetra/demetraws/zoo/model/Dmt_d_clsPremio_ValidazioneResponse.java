package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "DMT_D_CLS_PREMIO_VAL_RESP")
/**
 * Classe model di response alle chiamate dei metodi getElencoCapiPremioNew e
 * getElencoCapiPremio2New
 *
 * @version 1.0 (02/04/2020)
 * @author bcsoft
 */
public class Dmt_d_clsPremio_ValidazioneResponse implements Serializable {
   
    private static final long serialVersionUID = 5904304924784953743L;
    /**
     * Elenco dettagliato dei capi bovini eventualmente determinati dal filtro
     * in BDN.
     */
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name= "id_autogenerato")
    private Long idAutogenerato;
    
    @OneToMany(mappedBy = "dmt_d_clsPremio_ValidazioneResponse")
    public List<Dmt_t_Tbdn_du_capi> clsCapo;
   
    @OneToMany(mappedBy = "dmt_d_clsPremio_ValidazioneResponse")
    /**
     * Elenco dettagliato dei capi ovicaprini eventualmente determinati dal
     * filtro in BDN.
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> ClsCapoOvicaprino;
    
    @OneToMany(mappedBy = "dmt_d_clsPremio_ValidazioneResponse")
    /**
     * Elenco dettagliato delle vacche determinati dal filtro in BDN.
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> ClsCapoVacca;
  
    @OneToMany(mappedBy = "dmt_d_clsPremio_ValidazioneResponse")
    /**
     * Elenco dettagliato dei capi bovini macellati determinati dal filtro BDN
     */
    public List<Dmt_t_clsCapoMacellato> ClsCapoMacellato;

	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	private Dmt_t_sessione idSessione;

    @Column(name = "codice_errore", length = 400)
    /**
     * Codice dell’errore verificatosi in BDN qualora l’operazione non fosse
     * andata a buon fine.
     */
    private String ErrCod;
    /**
     * Descrizione dell’errore verificatosi in BDN qualora l’operazione non
     * fosse andata a buon fine.
     */
    @Column(name = "descrizione_errore", length = 400)
    private String ErrDescr;
    /**
     * Numero dei capi eleggibili a premio sulla base del filtro applicato alla
     * BDN.
     */
    @Column(name = "numero_capi")
    private Long numeroCapi;

    /**
     * Metodo get che ritorna il codice dell'eventuale errore
     *
     * @return ErrCod codice dell'eventuale errore
     */
    public String getErrCod() {
        return ErrCod;
    }

    /**
     * Metodo set che imposta il codice dell'eventuale errore
     *
     * @param errCod codice dell'eventuale errore
     */
    public void setErrCod(String errCod) {
        ErrCod = errCod;
    }

    /**
     * Metodo get che ritorna la descrizione dell'eventuale errore
     *
     * @return ErrDescr descrizione dell'eventuale errore
     */
    public String getErrDescr() {
        return ErrDescr;
    }

    /**
     * Metodo set che imposta il codice dell'eventuale errore
     *
     * @param errCod codice dell'eventuale errore
     */
    public void setErrDescr(String errDescr) {
        ErrDescr = errDescr;
    }

    /**
     * Metodo get che ritorna il numero dei capi eleggibili a premio
     *
     * @return numeroCapi il numero dei capi eleggibili a premio
     */
    public Long getNumeroCapi() {
        return numeroCapi;
    }

    /**
     * Metodo set che imposta il numero dei capi eleggibili a premio
     *
     * @param numeroCapi il numero dei capi eleggibili a premio
     */
    public void setNumeroCapi(Long numeroCapi) {
        this.numeroCapi = numeroCapi;
    }

    /**
     * Metodo get che ritorna l'elenco dei capi bovini determinati dal filtro
     *
     * @return clsCapo l'elenco degli eventuali capi bovini determinati dal
     * filtro
     */
    public List<Dmt_t_Tbdn_du_capi> getClsCapo() {
        return clsCapo;
    }

    /**
     * Metodo set che imposta l'elenco degli eventuali capi bovini determinati
     * dal filtro
     *
     * @param clsCapo l'elenco dei capi bovini determinati dal filtro
     */
    public void setClsCapo(List<Dmt_t_Tbdn_du_capi> clsCapo) {
        this.clsCapo = clsCapo;
    }

    /**
     * Metodo get che ritorna l'elenco dei capi ovicaprini accettabili
     *
     * @return ClsCapoOvicaprino l'elenco dei capi ovicaprini accettabili
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getClsCapoOvicaprino() {
        return ClsCapoOvicaprino;
    }

    /**
     * Metodo set che imposta l'elenco dei capi ovicaprini accettabili
     *
     * @param ClsCapoOvicaprino l'elenco degli eventuali capi ovicaprini
     */
    public void setClsCapoOvicaprino(List<Dmt_t_Tws_bdn_du_capi_ovicaprini> clsCapoOvicaprino) {
        ClsCapoOvicaprino = clsCapoOvicaprino;
    }

    /**
     * Metodo get che ritorna l'elenco delle vacche accettabili
     *
     * @return ClsCapoVacca l'elenco delle eventuali vacche
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getClsCapoVacca() {
        return ClsCapoVacca;
    }

    /**
     * Metodo set che imposta l'elenco delle vacche accettabili
     *
     * @param clsCapoVacca elenco delle vacche accettabili
     */
    public void setClsCapoVacca(List<Dmt_t_Tws_bdn_du_capi_bovini> clsCapoVacca) {
        ClsCapoVacca = clsCapoVacca;
    }

    /**
     * Metodo get che ritorna l'elenco dei capi bovini macellati ammessi
     *
     * @return ClsCapoMacellato elenco dei capi bovini macellati ammessi
     */
    public List<Dmt_t_clsCapoMacellato> getClsCapoMacellato() {
        return ClsCapoMacellato;
    }

    /**
     * Metodo set che imposta l'elenco dei capi bovini macellati ammessi
     *
     * @param clsCapoMacellato elenco dei capi bovini macellati ammessi
     */
    public void setClsCapoMacellato(List<Dmt_t_clsCapoMacellato> clsCapoMacellato) {
        ClsCapoMacellato = clsCapoMacellato;
    }

    public Dmt_t_sessione getIdSessione() {
        return this.idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione;
    }


	public Long getIdAutogenerato() {
		return idAutogenerato;
	}
    
}
