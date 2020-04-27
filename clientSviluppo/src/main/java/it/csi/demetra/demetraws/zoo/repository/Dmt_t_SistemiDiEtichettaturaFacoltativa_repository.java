package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_SistemiDiEtichettaturaFacoltativa;

@Repository
public interface Dmt_t_SistemiDiEtichettaturaFacoltativa_repository extends CrudRepository<Dmt_t_SistemiDiEtichettaturaFacoltativa, String>{

	List<Dmt_t_SistemiDiEtichettaturaFacoltativa>findAll();
	
	@Query(value = "return * from Dmt_t_sistemi_etichettatura where cuaa = :cuaa", nativeQuery = true)
	Dmt_t_SistemiDiEtichettaturaFacoltativa findByCuaa(@Param("cuaa") String cuaa);
}
