package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_controlli_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;

@Repository
public interface Dmt_t_output_controlli_repository extends CrudRepository<Dmt_t_output_controlli, Dmt_t_output_controlli_id> {

	
	@Query( value = "select * from dmt_t_output_controlli select capo_id from dmt_t_output_esclusi where sessione = :sessione and calcolo LIKE CONCAT('%',:calcolo,'%') ",
			nativeQuery = true
			)
	List<Dmt_t_output_controlli> findBySessioneAndCalcolo(@Param("sessione") Long sessione, @Param("calcolo") String calcolo);
	

	@Query(
			value = "SELECT * FROM dmt_t_output_controlli WHERE SESSIONE = :sessione AND cuaa = :cuaa AND ANNO_CAMPAGNA = :anno AND intervento = :codiceIntervento ",
			nativeQuery = true
			)
	Dmt_t_output_controlli findBySessioneAndCuaaAndAnnoCampagnaAndIntervento(@Param("sessione") Dmt_t_sessione sessione, @Param("cuaa") String cuaa, @Param("anno") Long anno, @Param("codiceIntervento") String codiceIntervento);
}
