package it.csi.demetra.demetraws.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_ControlloUbaMinime;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_ControlloUbaMinime_repository;

/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_ControlloUbaMinime_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_ControlloUbaMinime
 * @author Bcsoft
 */
@Service
public class Dmt_t_ControlloUbaMinime_services {

	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_ControlloUbaMinime_repository.
	 */
	@Autowired
	Dmt_t_ControlloUbaMinime_repository repo;
	
	/**
	 * Metodo che esegue il salvataggio a DB di un'istanza di tipo Dmt_t_controlloUbaMinime.
	 * @see Dmt_t_ControlloUbaMinime_repository
	 * @param model istanza da salvare a DB
	 */
	public void save (Dmt_t_ControlloUbaMinime model ) {
		repo.save(model);
	}
	
}
