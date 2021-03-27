package it.csi.demetra.demetraws.zoo.services;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_Tws_bdn_du_capi_ovicaprini_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_Tws_bdn_du_capi_ovicaprini_repository
 * per la persistenza di oggetti di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini
 *
 * @author Bcsoft
 */
@Service
public class Dmt_t_Tws_bdn_du_capi_ovicaprini_services {

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.
     */
    @Autowired
    Dmt_t_Tws_bdn_du_capi_ovicaprini_repository rep;

    /**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini.
     * {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_repository#findAll()}
     *
     * @return lista degli oggetti di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapo() {
        return rep.findAll();
    }

    /**
     * Metodo che effettua il salvataggio a DB di un'istanza di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini}
     * {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_repository#saveAll(Iterable)}
     *
     * @param capo - subentro istanza da salvare a DB
     */
    public void saveCapo(List<Dmt_t_Tws_bdn_du_capi_ovicaprini> capo) {
        for (Dmt_t_Tws_bdn_du_capi_ovicaprini c : capo)
            rep.save(c);
//        rep.saveAll(capo);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini} in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_repository#findByIdSessionAndCuaa(Long, String String)}
     *
     * @param idSessione    identificativo univoco associato all'esecuzione
     * @param cuaa          codice fiscale del richiedente
     * @param codIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapiOviByIdSessioneCuaaCodInt(Long idSessione, String cuaa, String codIntervento) {
        return rep.findBySessioneAndCuaa(idSessione, cuaa, codIntervento);
    }

    /**
     * Metodo che ritorna una lista di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini} in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_repository#getOvicapriniUbaMinime(Long, String, String)}
     *
     * @param idSessione    identificativo univoco associato all'esecuzione
     * @param cuaa          codice fiscale del richiedente
     * @param codIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getOvicapriniUbaMinime(Long idSessione, String cuaa, String codIntervento) {
        return rep.getOvicapriniUbaMinime(idSessione, cuaa, codIntervento);
    }
}
