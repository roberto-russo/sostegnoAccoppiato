package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_AgnelleRimonta_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_AgnelleRimonta;

@Repository
public interface Dmt_t_AgnelleRimonta_repository extends CrudRepository<Dmt_t_AgnelleRimonta, Dmt_t_AgnelleRimonta_id> {

	
	@Query(value = "SELECT * FROM DMT_T_AGNELLE_RIMONTA dtr WHERE FK_ID_SESSIONE = :idSessione AND cuaa = :cuaa ", nativeQuery = true)
	List<Dmt_t_AgnelleRimonta> findByIdSessioneAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
	
	@Query(value = "SELECT QT_CAPI_PREMIO FROM DMT_T_AGNELLE_RIMONTA dtr WHERE FK_ID_SESSIONE = :idSessione AND cuaa = :cuaa AND CODICE_INTERVENTO = :codiceIntervento", nativeQuery = true)
	Double getQuotaCapiPremioByIdSessioneAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa,  @Param("cuaa") String codiceIntervento);
}
