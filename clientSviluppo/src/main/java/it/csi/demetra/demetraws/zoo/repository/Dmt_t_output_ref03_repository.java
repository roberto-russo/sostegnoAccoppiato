package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_ref03_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_ref03;

@Repository
public interface Dmt_t_output_ref03_repository extends CrudRepository<Dmt_t_output_ref03, Dmt_t_output_ref03_id> {
	
	@Query(value = "SELECT * FROM dmt_t_output_Ref03 WHERE ANNO_CAMPAGNA = :annoCampagna and CUAA = :cuaa and ID_SESSIONE = :idSessione and INTERVENTO = :codicePremio",
			nativeQuery = true)
	public Dmt_t_output_ref03 findCapiPagabiliByAnnoCampagnaAndCuaaAndIdSessioneAndIntervento(@Param("annoCampagna") Integer annoCampagna, @Param("cuaa") String cuaa, @Param("idSessione") Long idSessione, @Param("codicePremio") String codicePremio);

}
