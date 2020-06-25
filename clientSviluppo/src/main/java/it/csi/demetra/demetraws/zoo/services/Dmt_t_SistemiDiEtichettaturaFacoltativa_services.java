package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_SistemiDiEtichettaturaFacoltativa;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_SistemiDiEtichettaturaFacoltativa_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_SistemiDiEtichettaturaFacoltativa_repository
 * per la persistenza di oggetti di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa
 * @author Bcsoft
 */
public class Dmt_t_SistemiDiEtichettaturaFacoltativa_services {

	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa_repository.
     */
	Dmt_t_SistemiDiEtichettaturaFacoltativa_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa.
     * {@link Dmt_t_SistemiDiEtichettaturaFacoltativa_repository#findAll()}
     * @return lista degli oggetti di tipo {@link Dmt_t_SistemiDiEtichettaturaFacoltativa}
     */
	public List<Dmt_t_SistemiDiEtichettaturaFacoltativa> getAll(){
		return this.rep.findAll();
	}
}
