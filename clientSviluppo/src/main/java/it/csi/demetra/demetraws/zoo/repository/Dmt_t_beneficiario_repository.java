package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_beneficiario_capi_doppi_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_beneficiario_capi_doppi;

@Repository
public interface Dmt_t_beneficiario_repository extends CrudRepository<Dmt_t_beneficiario_capi_doppi, Dmt_t_beneficiario_capi_doppi_id> {

	
	@Query(value = "SELECT cuaa FROM dmt_t_beneficiario_capi_doppi where anno_campagna = :annoCampagna and codice_premio = :codicePremio and id_capo = :idCapo ",
			nativeQuery = true)
	public String findCuaaByAnnoCampagnaAndCodcePremioAndIdCapo(@Param("annoCampagna") Integer annoCampagna, @Param("codicePremio") String codicePremio, @Param("idCapo") Long idCapo);
}
