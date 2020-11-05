package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.CuaaScaricoManuale_id;
import it.csi.demetra.demetraws.zoo.model.CuaaScaricoManuale;

@Repository
public interface CuaaScaricoManuale_repository extends CrudRepository<CuaaScaricoManuale, CuaaScaricoManuale_id> {

	
	@Query(
			value = " SELECT * FROM CUAA_SCARICO_MANUALE WHERE ANNO_CAMPAGNA = :annoCampagna", 
			nativeQuery = true
		  )
	List<CuaaScaricoManuale> findAll(@Param("annoCampagna") Integer annoCampagna);
}
