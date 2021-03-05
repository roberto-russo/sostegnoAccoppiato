package it.csi.demetra.demetraws.zoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_w_controllo_bean;

/**
 * Interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_w_controllo_bean_repository e le query ad esso associate.
 * @author Bcsoft
 */
@Repository
public interface Dmt_w_controllo_bean_repository extends JpaRepository<Dmt_w_controllo_bean,String> {
	
	/**
	 * Query che ritorna un Container Optional di tipo Dmt_w_controllo_bean_repository in base al codicePremio
	 * @param codicePremio codice intervento
	 * @return collezzione Optional di tipo Dmt_w_controllo_bean
	 */
	@Query(value = "select * from Dmt_w_controllo_bean where codice = :codicePremio", nativeQuery = true)
	Dmt_w_controllo_bean findByCodicePremio(@Param("codicePremio") String codicePremio);
}
