package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_SistemiDiEtichettaturaFacoltativa;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_SistemiDiEtichettatuaFacoltativa e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_SistemiDiEtichettaturaFacoltativa_repository extends CrudRepository<Dmt_t_SistemiDiEtichettaturaFacoltativa, String>{

	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa
	 */
	List<Dmt_t_SistemiDiEtichettaturaFacoltativa>findAll();
	
	@Query(value = "select * from Dmt_t_sistemi_etichettatura where cuaa = :cuaa", nativeQuery = true)
	/**
	 * Query che ritorna un'istanza di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa in base al cuaa
	 * @param cuaa codice fiscale del richiedente
	 * @return istanza di tipo @see Dmt_t_SistemiDiEtichettaturaFacoltativa
	 */
	Dmt_t_SistemiDiEtichettaturaFacoltativa findByCuaa(@Param("cuaa") String cuaa);
}
