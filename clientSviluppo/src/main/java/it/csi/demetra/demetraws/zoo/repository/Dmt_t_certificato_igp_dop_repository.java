package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_certificato_igp_dop e le query ad esso associate.
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_certificato_igp_dop_repository extends CrudRepository<Dmt_t_certificato_igp_dop, String>{

	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_certificato_igp_dop
	 */
	List<Dmt_t_certificato_igp_dop>findAll();
	
	/**
	 * query che ritorna l'istanza di tipo Dmt_t_certificato_igp_dop in base al codice fiscale del richiedente
	 * @param cuaa - codice fiscale del richiedente
	 * @return Dmt_t_certificato_igp_dop
	 */
	@Query(value = "select * from Dmt_t_certif_igp_dop where cuaa = :cuaa", nativeQuery = true)
	Dmt_t_certificato_igp_dop findByCuaa(@Param("cuaa") String cuaa);
}
