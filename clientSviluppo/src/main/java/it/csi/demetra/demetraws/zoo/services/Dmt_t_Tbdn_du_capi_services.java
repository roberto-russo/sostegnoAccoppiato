package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tbdn_du_capi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_Tbdn_du_capi_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_Tbdn_du_capi_repository
 * per la persistenza di oggetti di tipo Dmt_t_Tbdn_du_capi
 * @author Bcsoft
 */
public class Dmt_t_Tbdn_du_capi_services {
	
	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo Dmt_t_Tbdn_du_capi_repository.
     */
	Dmt_t_Tbdn_du_capi_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo Dmt_t_Tbdn_du_capi.
     * {@link Dmt_t_Tbdn_du_capi_repository#findAll()}
     * @return lista degli oggetti di tipo {@link Dmt_t_Tbdn_du_capi}
     */
	public List<Dmt_t_Tbdn_du_capi> getCapo(){
		return rep.findAll();
	}
	
	/**
	 * Metodo che effettua il salvataggio a DB di una lista di istanze di tipo {@link Dmt_t_Tbdn_du_capi}
	 * @param capo subentro istanza da salvare a DB
	 */
	public void saveCapo(List<Dmt_t_Tbdn_du_capi> capo) {
		rep.saveAll(capo);
	}
}
