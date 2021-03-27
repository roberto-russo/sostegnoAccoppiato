package it.csi.demetra.demetraws.zoo.services;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_tws_bdn_du_capi_bovini_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_tws_bdn_du_capi_bovini_repository
 * per la persistenza di oggetti di tipo Dmt_t_tws_bdn_du_capi_bovini
 *
 * @author Bcsoft
 */
@Service
public class Dmt_t_tws_bdn_du_capi_bovini_services {

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_tws_bdn_du_capi_bovini_repository.
     */
    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_repository rep;

    /**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#findAll()}
     *
     * @return lista degli oggetti di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getCapo() {
        return rep.findAll();
    }

    /**
     * Metodo che effettua il salvataggio a DB di un'istanza di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#saveAll(Iterable)}
     *
     * @param capo subentro istanza da salvare a DB
     */
    public void saveCapo(List<Dmt_t_Tws_bdn_du_capi_bovini> capo) {
        for (Dmt_t_Tws_bdn_du_capi_bovini c : capo) {
            System.out.println("------- SESSO VITELLO -------");
            System.out.println(c.getVitelloTipoOrigine());
            System.out.println(c.getVitelloTipoOrigine().length());
            rep.save(c);
        }
//		rep.saveAll(capo);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     * in base a idSessione, cuaa, idCapo e annoCampagna.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getVitelliOfVacca(Long, String, Long, Long)}
     *
     * @param idSessione   identificativo univoco associato all'esecuzione
     * @param cuaa         codice fiscale del richiedente
     * @param idCapo       identificativo univoco associato al capo animale
     * @param annoCampagna anno della campagna
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getVitelliOfVacca(Long idSessione, String cuaa, Long idCapo, Long annoCampagna) {
        return rep.getVitelliOfVacca(idSessione, cuaa, idCapo, annoCampagna);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo Dmt_t_Tws_bdn_du_capi_bovini in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#findByIdSessionAndCuaa9903(Long, String, String)}
     *
     * @param idSessione    identificativo univoco associato all'esecuzione
     * @param cuaa          codice fiscale del richiedente
     * @param codIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getByIDSessionCuaaCodInt(Long idSessione, String cuaa, String codIntervento) {
        return rep.findByIdSessionAndCuaa9903(idSessione, cuaa, codIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
     * in base a idSessione, cuaa e codiceIntervento
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getListaCapiAmmessiZonaMontanaInt311Mis2(Long, String, String)}
     *
     * @param idSessione       identificativo univoco associato all'esecuzione
     * @param cuaa             codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getListaCapiAmmessiZonaMontanaInt311Mis2(Long idSessione, String cuaa, String codiceIntervento) {
        return rep.getListaCapiAmmessiZonaMontanaInt311Mis2(idSessione, cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini} in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getListaCapiEsclusZonaMontanaiInt311Mis2(Long, String, String)}
     *
     * @param idSessione       codice identificativo associato all'esecuzione
     * @param cuaa             codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getListaCapiEsclusZonaMontanaiInt311Mis2(Long idSessione, String cuaa, String codiceIntervento) {
        return rep.getListaCapiEsclusZonaMontanaiInt311Mis2(idSessione, cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini} in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getBoviniIdoneiInt310Mis1NonDiZonaMontana(Long, String, String)}
     *
     * @param idSessione    identificativo univoco associato all'esecuzione
     * @param cuaa          codice fiscale del richiedente
     * @param codIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniIdoneiInt310Mis1ZonaMontana(Long idSessione, String cuaa, String codIntervento) {
        return rep.getBoviniIdoneiInt310Mis1ZonaMontana(idSessione, cuaa, codIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini} in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getBoviniIdoneiInt310Mis1NonDiZonaMontana(Long, String, String)}
     *
     * @param idSessione    identificativo univoco associato all'esecuzione
     * @param cuaa          codice fiscale del richiedente
     * @param codIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniIdoneiInt310Mis1NonDiZonaMontana(Long idSessione, String cuaa, String codIntervento) {
        return rep.getBoviniIdoneiInt310Mis1NonDiZonaMontana(idSessione, cuaa, codIntervento);
    }

    /**
     * Metodo che ritorna una lista di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini} in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getBoviniUbaMinime(Long, String, String)}
     *
     * @param idSessione    identificativo univoco associato all'esecuzione
     * @param cuaa          codice fiscale del richiedente
     * @param codIntervento codice intervento
     * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniUbaMinime(Long idSessione, String cuaa, String codIntervento) {
        return rep.getBoviniUbaMinime(idSessione, cuaa, codIntervento);
    }

    public String getFlagZonaMontanaByAllevId(Long allevId) {
        return rep.findFlagZonaMontanaByAllevId(allevId) == null ? "N" : rep.findFlagZonaMontanaByAllevId(allevId);
    }
}
