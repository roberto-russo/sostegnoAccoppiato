package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_subentro_zoo_repository;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_subentro_zoo_repository
 * per la persistenza di oggetti di tipo Dmt_t_subentro_zoo
 * @author Bcsoft
 */
@Service
public class Dmt_t_subentro_zoo_services {

	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_subentro_zoo_repository.
	 */
	@Autowired
	Dmt_t_subentro_zoo_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo Dmt_t_subentro_zoo.
     * {@link Dmt_t_subentro_zoo_repository#findAll()}
     * @return lista degli oggetti di tipo {@link Dmt_t_subentro_zoo}
     */
	public List<Dmt_t_subentro_zoo> getAll() {
		return rep.findAll();
	}
	/**
	 * Metodo che ritorna un'istanza di tipo {@link Dmt_t_subentro_zoo} in base ad annoCampagna e a cuaaDomanda.
	 * {@link Dmt_t_subentro_zoo_repository#findSubentroByData(long, String)}
	 * @param annoCampagna anno della campagna
	 * @param cuaaDomanda codice fiscale del richiedente
	 * @return istanza di tipo {@link Dmt_t_subentro_zoo}
	 */
	public Dmt_t_subentro_zoo getSubentro(long annoCampagna, String cuaaDomanda) {
		return rep.findSubentroByData(annoCampagna, cuaaDomanda);
	}
	
	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo {@link Dmt_t_subentro_zoo}
	 * @param subentro istanza da salvare a DB
	 */
	public void saveSubentro(Dmt_t_subentro_zoo subentro) {
		rep.save(subentro);
	}
}
