package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_esclusi_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_output_esclusi e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_output_esclusi_repository extends CrudRepository<Dmt_t_output_esclusi, Dmt_t_output_esclusi_id>{

	

	@Query( value = "select * from dmt_t_output_esclusi where id_sessione = :sessione and calcolo LIKE '%' || :calcolo || '%' ",
			nativeQuery = true
			)
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_output_esclusi in base alla sessione e al calcolo
	 * @param sessione codice di sessione associato all'esecuzione
	 * @param calcolo codice premio per cui il cuaa effettua la richiesta
	 * @return lista di istanze di tipo Dmt_t_output_esclusi
	 */
	List<Dmt_t_output_esclusi> findBySessioneAndCalcolo(@Param("sessione") Long sessione, @Param("calcolo") String calcolo); 
	
	@Query(
			value = "select distinct capo_id from dmt_t_output_esclusi where id_sessione = :idSessione and calcolo LIKE '%' || :calcolo || '%' ",
			nativeQuery = true
		)
	/**
	 * query che ritorna una lista di identificativi di capo animale in base alla sessione e al calcolo
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @param calcolo codice premio per cui il cuaa effettua la richiesta
	 * @return lista di identificativi di capo animale.
	 */
	List<Long> isAnomalo(@Param("idSessione") Long idSessione, @Param("calcolo") String calcolo);
}
