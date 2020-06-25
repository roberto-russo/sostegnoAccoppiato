package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_controlli_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_output_controlli e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_output_controlli_repository extends CrudRepository<Dmt_t_output_controlli, Dmt_t_output_controlli_id> {

	
	@Query( value = "select * from dmt_t_output_controlli select capo_id from dmt_t_output_esclusi where id_sessione = :sessione and calcolo LIKE CONCAT('%',:calcolo,'%') ",
			nativeQuery = true
			)
	/**
	 * query che ritorna una lista di tipo Dmt_t_output_controlli in base allla sessione e al calcolo.
	 * @param sessione codice di sessione associato all'esecuzione
	 * @param calcolo nome del calcolo che ha prodotto l'output in Dmt_t_output_controlli.
	 * @return lista di istanze di tipo @see Dmt_t_output_controlli
	 */
	List<Dmt_t_output_controlli> findBySessioneAndCalcolo(@Param("sessione") Long sessione, @Param("calcolo") String calcolo);
	

	@Query(
			value = "SELECT * FROM dmt_t_output_controlli where id_sessione = :sessione AND cuaa = :cuaa AND ANNO_CAMPAGNA = :anno AND intervento = :codiceIntervento ",
			nativeQuery = true
			)
	/**
	 * query che ritorna un'istanza di tipo Dmt_t_output_controlli in base alla sessione, il cuaa, l'annoCampagna e l'intervento.
	 * @param sessione codice di sessione associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param anno anno di campagna per cui viene effettuato lo scarico
	 * @param codiceIntervento codice premio per cui il cuaa effettua la richiesta
	 * @return istanza di tipo @see Dmt_t_output_controlli
	 */
	Dmt_t_output_controlli findBySessioneAndCuaaAndAnnoCampagnaAndIntervento(@Param("sessione") Dmt_t_sessione sessione, @Param("cuaa") String cuaa, @Param("anno") Long anno, @Param("codiceIntervento") String codiceIntervento);

}
