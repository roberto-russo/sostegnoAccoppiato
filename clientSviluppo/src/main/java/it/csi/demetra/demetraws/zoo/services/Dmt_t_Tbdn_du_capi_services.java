package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tbdn_du_capi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_Tbdn_du_capi_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_Tbdn_du_capi_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_Tbdn_du_capi
 * @author Bcsoft
 */
public class Dmt_t_Tbdn_du_capi_services {
	
	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_Tbdn_du_capi_repository.
     */
	Dmt_t_Tbdn_du_capi_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo @see Dmt_t_Tbdn_du_capi.
     * @see Dmt_t_Tbdn_du_capi_repository
     * @return lista degli oggetti di tipo @see Dmt_t_Tbdn_du_capi
     */
	public List<Dmt_t_Tbdn_du_capi> getCapo(){
		return rep.findAll();
	}
	
	/**
	 * Metodo che effettua il salvataggio a DB di una lista di istanze di tipo @see Dmt_t_Tbdn_du_capi
	 * @see Dmt_t_Tbdn_du_capi_repository
	 * @param capo subentro istanza da salvare a DB
	 */
	public void saveCapo(List<Dmt_t_Tbdn_du_capi> capo) {
		rep.saveAll(capo);
	}
}
