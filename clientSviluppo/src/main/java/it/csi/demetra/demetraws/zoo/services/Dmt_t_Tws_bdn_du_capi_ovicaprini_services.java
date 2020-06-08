package it.csi.demetra.demetraws.zoo.services;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_Tws_bdn_du_capi_ovicaprini_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini
 * @author Bcsoft
 */
public class Dmt_t_Tws_bdn_du_capi_ovicaprini_services {

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.
     */
    Dmt_t_Tws_bdn_du_capi_ovicaprini_repository rep;

    /**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini.
     * @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.findAll
     * @return List<Dmt_t_Tws_bdn_du_capi_ovicaprini> lista degli oggetti di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapo() {
        return rep.findAll();
    }

    /**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini
	 * @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.saveAll
	 * @param subentro istanza da salvare a DB
	 */
    public void saveCapo(List<Dmt_t_Tws_bdn_du_capi_ovicaprini> capo) {
        rep.saveAll(capo);
    }

//    public void print() {
//        System.out.println("OGGI R? UNA BELLA GIORNATA");
//    }

    /**
     * Metodo che ritorna una lista di istanze di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini in base a idSessione, cuaa e codiceIntervento.
     * @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.findByIdSessionAndCuaa
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codIntervento codice intervento
     * @return List<Dmt_t_Tws_bdn_du_capi_ovicaprini>
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapiOviByIdSessioneCuaaCodInt(Long idSessione, String cuaa, String codIntervento) {
        return rep.findByIdSessionAndCuaa(idSessione, cuaa, codIntervento);
    }
}
