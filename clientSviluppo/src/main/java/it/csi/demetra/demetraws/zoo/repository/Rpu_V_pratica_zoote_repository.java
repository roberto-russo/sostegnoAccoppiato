package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Rpu_V_pratica_zoote_id;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;

@Repository
public interface Rpu_V_pratica_zoote_repository extends CrudRepository<Rpu_V_pratica_zoote, Rpu_V_pratica_zoote_id>{

	@Query(
			value = " SELECT * FROM RPU_V_PRATICA_ZOOTE PZ WHERE PZ.ANNO_CAMPAGNA = :annoCampagna", 
			nativeQuery = true
		  )
	List<Rpu_V_pratica_zoote> findAll(@Param("annoCampagna") Integer annoCampagna);
	
	@Query(
			value = "SELECT R FROM Rpu_V_pratica_zoote R WHERE R.codicePremio IN (:codiciPremio) AND R.annoCampagna = :annoCampagna"	
		)
	List<Rpu_V_pratica_zoote> findByCodiciPremioAndAnnoCampagna(@Param("codiciPremio") List<String> codiciPremioList, @Param("annoCampagna") Integer annoCampagna);
	
	@Query(
			value = " SELECT * FROM RPU_V_PRATICA_ZOOTE PZ WHERE PZ.ANNO_CAMPAGNA = :annoCampagna and Cuaa = :cuaa and Codice_premio = :codicePremio", 
			nativeQuery = true
		  )
	Rpu_V_pratica_zoote findByAnnoCampagnaAndCuaaAndCodicePremio(@Param("annoCampagna") Integer annoCampagna, @Param("cuaa") String cuaa, @Param("codicePremio") String codicePremio);

	@Query(
			value = "SELECT codice_premio FROM RPU_V_PRATICA_ZOOTE WHERE cuaa = :cuaa", 
			nativeQuery = true
		)
	List<String> findByCuaa(@Param("cuaa") String cuaa);

}