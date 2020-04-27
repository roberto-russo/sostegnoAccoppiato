package it.csi.demetra.demetraws.zoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_w_controllo_bean;

@Repository
public interface Dmt_w_controllo_bean_repository extends JpaRepository<Dmt_w_controllo_bean,String> {
	
	@Query(value = "select * from Dmt_w_controllo_bean where codice = :codicePremio", nativeQuery = true)
	Optional<Dmt_w_controllo_bean>findByCodicePremio(@Param("codicePremio") String codicePremio);
}
