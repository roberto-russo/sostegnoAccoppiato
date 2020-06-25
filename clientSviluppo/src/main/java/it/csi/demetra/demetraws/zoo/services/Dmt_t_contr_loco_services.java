package it.csi.demetra.demetraws.zoo.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_clsCapoMacellato_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_contr_loco_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_contr_loco_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_contr_loco
 * @author Bcsoft
 */
public class Dmt_t_contr_loco_services implements Serializable{

	private static final long serialVersionUID = 3537895581798649771L;

	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_contr_loco_repository.
     */
	Dmt_t_contr_loco_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo @see Dmt_t_contr_loco in base ad annoCampagna.
     * @return lista degli oggetti di tipo @see Dmt_t_contr_loco
     */
	public List<Dmt_t_contr_loco>getAll(){
		return rep.findAll();
	}
	
}
