package it.csi.demetra.demetraws.zoo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_sessione e le query ad esso associate.
 * @author Bcsoft
 */
@Repository 
public interface Dmt_t_sessione_repository  extends JpaRepository<Dmt_t_sessione,Long> {

	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_sessione
	 */
	List<Dmt_t_sessione>findAll();
	
	/**
	 * Query che ritorna un'istanza di tipo @see Dmt_t_sessione in base a dataEora
	 * @param dataEora data in cui viene generato l'idSessione
	 * @return istanza di tipo Dmt_t_sessione
	 */
	@Query(value = "select id_sessione from dmt_t_sessione where data_e_ora = :dataEora ", nativeQuery = true)
	Dmt_t_sessione findSessioneByDataEora(@Param("dataEora") Date dataEora);

	@Query(value = "select * from dmt_t_sessione where id_sessione = :id ", nativeQuery = true)
	Dmt_t_sessione findById(@Param("id") Long id);

	@Query(value = "select * from dmt_t_sessione where id_sessione = :id ", nativeQuery = true)
    Dmt_t_sessione findOldSessione(Long idSessione, String cuaa, String codicePremio);
}
