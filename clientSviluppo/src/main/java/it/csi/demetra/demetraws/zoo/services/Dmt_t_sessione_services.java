package it.csi.demetra.demetraws.zoo.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_sessione_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_sessione_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_sessione
 * @author Bcsoft
 */
public class Dmt_t_sessione_services {

	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_sessione_repository.
     */
	Dmt_t_sessione_repository rep;

	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo @see Dmt_t_sessione.
     * @see Dmt_t_sessione_repository
     * @return lista degli oggetti di tipo @see Dmt_t_sessione
     */
	public List<Dmt_t_sessione> getAll() {
		return rep.findAll();
	}
	
	/**
	 * Metodo che ritorna un'istanza di tipo @see Dmt_t_sessione in base a dataEora.
	 * @see Dmt_t_sessione_repository
	 * @param dataEora data in cui è stato creata la sessione
	 * @return istanza di tipo @see Dmt_t_sessione
	 */
	public Dmt_t_sessione get(Date dataEora) {
		return rep.findSessioneByDataEora(dataEora);
	}
	
	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo @see Dmt_t_sessione.
	 * @see Dmt_t_sessione_repository.
	 * @param sessione identificativo univoco associato all'esecuzione
	 * @return istanza di tipo @see Dmt_t_sessione da salvare a DB
	 */
	public Dmt_t_sessione saveSession(Dmt_t_sessione sessione) {
		return rep.save(sessione);
	}
	
	/**
	 * Metodo che ritorna un'istanza di tipo @see Dmt_t_sessione in base a idSessione
	 * @see Dmt_t_sessione_repository
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @return istanza di tipo @see Dmt_t_sessione
	 */
	public Dmt_t_sessione getById(Long idSessione) {
		return rep.findById(idSessione).orElseThrow( () ->  new NoSuchElementException());
	}
}
