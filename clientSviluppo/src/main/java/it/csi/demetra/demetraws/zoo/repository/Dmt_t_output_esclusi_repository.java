package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_esclusi_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;

@Repository
public interface Dmt_t_output_esclusi_repository extends CrudRepository<Dmt_t_output_esclusi, Dmt_t_output_esclusi_id>{

	

	@Query( value = "select * from dmt_t_output_esclusi where sessione = :sessione and calcolo LIKE '%' || :calcolo || '%' ",
			nativeQuery = true
			)
	List<Dmt_t_output_esclusi> findBySessioneAndCalcolo(@Param("sessione") Long sessione, @Param("calcolo") String calcolo); 
	
	@Query(
			value = "select distinct capo_id from dmt_t_output_esclusi where sessione = :idSessione and calcolo LIKE '%' || :calcolo || '%' ",
			nativeQuery = true
		)
	List<Long> isAnomalo(@Param("idSessione") Long idSessione, @Param("calcolo") String calcolo);
}
