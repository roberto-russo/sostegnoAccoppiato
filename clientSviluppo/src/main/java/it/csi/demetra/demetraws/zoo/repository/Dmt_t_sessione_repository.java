package it.csi.demetra.demetraws.zoo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_sessione e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_sessione_repository  extends JpaRepository<Dmt_t_sessione,Long> {

	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_sessione
	 */
	List<Dmt_t_sessione>findAll();
	
	@Query(value = "select id_sessione from sessione where data_e_ora = :dataEora ", nativeQuery = true)
	/**
	 * Query che ritorna un'istanza di tipo @see Dmt_t_sessione in base a dataEora
	 * @param dataEora data in cui viene generato l'idSessione
	 * @return dmt_t_sessione
	 */
	Dmt_t_sessione findSessioneByDataEora(@Param("dataEora") Date dataEora);
}
