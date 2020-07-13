package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_premio_capi_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;

@Repository
public interface Dmt_t_premio_capi_repository extends CrudRepository<Dmt_t_premio_capi, Dmt_t_premio_capi_id>{
	
	
	public List<Dmt_t_premio_capi>findAll();
	
	@Query(value = "select distinct id_capo from dmt_t_premio_capi where id_sessione = :idSessione and flag_amissibile = 'S' and cuaa = :cuaa and codice_premio = :codPremio",
			nativeQuery = true)
	public List<Long>getListaCapiEsitoByIdSessioneAndFlagAmmissibileAndCuaaAndCodPremio(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codPremio") String codPremio);
	
}
