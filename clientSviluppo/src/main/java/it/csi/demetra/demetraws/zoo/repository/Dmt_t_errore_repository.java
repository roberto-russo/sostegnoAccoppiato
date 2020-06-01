package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_errore_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_errore e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_errore_repository extends JpaRepository<Dmt_t_errore, Dmt_t_errore_id> {

	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_errore
	 */
    List<Dmt_t_errore> findAll();
}
