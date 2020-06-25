package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_tws_bdn_du_capi_bovini_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_tws_bdn_du_capi_bovini_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_tws_bdn_du_capi_bovini
 * @author Bcsoft
 */
public class Dmt_t_tws_bdn_du_capi_bovini_services {
	
	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_tws_bdn_du_capi_bovini_repository.
     */
	 Dmt_t_tws_bdn_du_capi_bovini_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
     * @return lista degli oggetti di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
     */
	public List< Dmt_t_Tws_bdn_du_capi_bovini> getCapo(){
		return rep.findAll();
	}
	
	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 * @see Dmt_t_Tws_bdn_du_capi_bovini_repository
	 * @param capo subentro istanza da salvare a DB
	 */
	public void saveCapo(List< Dmt_t_Tws_bdn_du_capi_bovini> capo) {
		rep.saveAll(capo);
	}
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 * in base a idSessione, cuaa, idCapo e annoCampagna.
	 * @see Dmt_t_Tws_bdn_du_capi_bovini_repository 
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param idCapo identificativo univoco associato al capo animale
	 * @param annoCampagna anno della campagna
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 */
	public List<Dmt_t_Tws_bdn_du_capi_bovini> getVitelliOfVacca(Long idSessione, String cuaa, Long idCapo, Long annoCampagna) {
		return rep.getVitelliOfVacca(idSessione, cuaa, idCapo, annoCampagna);
	}
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini in base a idSessione, cuaa e codiceIntervento.
	 * @see Dmt_t_Tws_bdn_du_capi_bovini_repository.
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codIntervento codice intervento
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 */
	public List<Dmt_t_Tws_bdn_du_capi_bovini> getByIDSessionCuaaCodInt(Long idSessione, String cuaa, String codIntervento) {
		return rep.findByIdSessionAndCuaa9903(idSessione, cuaa, codIntervento);
	}
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 * in base a idSessione, cuaa e codiceIntervento
	 * @see Dmt_t_Tws_bdn_du_capi_bovini_repository
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codiceIntervento codice intervento
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 */
	public List<Dmt_t_Tws_bdn_du_capi_bovini> getListaCapiAmmessiZonaMontanaInt311Mis2 (Long idSessione, String cuaa, String codiceIntervento) {
		return rep.getListaCapiAmmessiZonaMontanaInt311Mis2(idSessione, cuaa, codiceIntervento);
	}
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see
	 * Dmt_t_Tws_bdn_du_capi_bovini in base a idSessione, cuaa e codiceIntervento.
	 * @see Dmt_t_Tws_bdn_du_capi_bovini
	 * @param idSessione codice identificativo associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codiceIntervento codice intervento
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 */
	public List<Dmt_t_Tws_bdn_du_capi_bovini> getListaCapiEsclusZonaMontanaiInt311Mis2 (Long idSessione, String cuaa, String codiceIntervento) {
		return rep.getListaCapiEsclusZonaMontanaiInt311Mis2(idSessione, cuaa, codiceIntervento);
	}
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see
	 *  Dmt_t_Tws_bdn_du_capi_bovini in base a idSessione, cuaa e codiceIntervento.
	 * @see Dmt_t_Tws_bdn_du_capi_bovini
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codIntervento codice intervento
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 */
	public List<Dmt_t_Tws_bdn_du_capi_bovini>getBoviniIdoneiInt310Mis1ZonaMontana(Long idSessione, String cuaa, String codIntervento) {
		return rep.getBoviniIdoneiInt310Mis1ZonaMontana(idSessione, cuaa, codIntervento);
	}
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 * in base a idSessione, cuaa e codiceIntervento.
	 * @see Dmt_t_Tws_bdn_du_capi_bovini_repository
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codIntervento codice intervento
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 */
	public List<Dmt_t_Tws_bdn_du_capi_bovini>getBoviniIdoneiInt310Mis1NonDiZonaMontana(Long idSessione, String cuaa, String codIntervento) {
		return rep.getBoviniIdoneiInt310Mis1NonDiZonaMontana(idSessione, cuaa, codIntervento);
	}
	
	/**
	 * Metodo che ritorna una lista di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 * in base a idSessione, cuaa e codiceIntervento.
	 * @see Dmt_t_Tws_bdn_du_capi_bovini_repository
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codIntervento codice intervento
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
	 */
	public List<Dmt_t_Tws_bdn_du_capi_bovini>getBoviniUbaMinime(Long idSessione, String cuaa, String codIntervento) {
		return rep.getBoviniUbaMinime(idSessione, cuaa, codIntervento);
	}
}
