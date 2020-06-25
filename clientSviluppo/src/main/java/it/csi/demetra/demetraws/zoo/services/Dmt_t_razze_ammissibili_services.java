package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_razze_ammissibili;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_razze_ammissibili_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_razze_ammissibili_repository
 * per la persistenza di oggetti di tipo Dmt_t_razze_ammissibili
 * @author Bcsoft
 */
public class Dmt_t_razze_ammissibili_services {

	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo Dmt_t_premio_capi_repository.
     */
	Dmt_t_razze_ammissibili_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo Dmt_t_razze_ammissibili.
     * @see Dmt_t_razze_ammissibili_repository
     * @return lista degli oggetti di tipo {@link Dmt_t_razze_ammissibili}
     */
	 public List<Dmt_t_razze_ammissibili> getAll() {
	        return rep.findAll();
	    }
}
