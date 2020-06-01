package it.csi.demetra.demetraws.zoo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_dsScarico_allevamenti;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_dsScarico_allevamenti e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_dsScarico_allevamenti_repository extends CrudRepository<Dmt_t_dsScarico_allevamenti, BigDecimal>{
	
	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_dsScarico_allevamenti
	 */
	List<Dmt_t_dsScarico_allevamenti>findAll();
	
	@Query(value = "SELECT * FROM dmt_t_dsScarico_allevamenti WHERE allev_id = :allevId", nativeQuery = true)
	/**
	 * query che ritorna un'istanza di tipo Dmt_t_dsScarico_allevamenti in base all'allevId
	 * @param allevId identificativo dell'allevamento
	 * @return Dmt_t_dsScarico_allevamenti
	 */
	Dmt_t_dsScarico_allevamenti findByAllevId(@Param("allevId")long allevId);
}
