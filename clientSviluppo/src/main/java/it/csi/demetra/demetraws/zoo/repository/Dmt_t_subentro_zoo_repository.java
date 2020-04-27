package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;

@Repository
public interface Dmt_t_subentro_zoo_repository extends CrudRepository<Dmt_t_subentro_zoo, Long>{

	
	List<Dmt_t_subentro_zoo>findAll();
	
	@Query(value = "select * from dmt_t_subentro_zoo where anno_campagna = :annoCampagna and cuaa_domanda = :cuaaDomanda and data_fine is null", nativeQuery = true)
	Dmt_t_subentro_zoo findSubentroByData(@Param("annoCampagna") long annoCampagna, @Param("cuaaDomanda") String cuaaDomanda);
}
