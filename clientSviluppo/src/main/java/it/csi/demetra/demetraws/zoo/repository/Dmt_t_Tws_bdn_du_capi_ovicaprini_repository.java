package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;

@Repository
public interface Dmt_t_Tws_bdn_du_capi_ovicaprini_repository extends CrudRepository<Dmt_t_Tws_bdn_du_capi_ovicaprini, Long>{
	
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini> findAll();
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA WHERE ID_SESSIONE = :idSessione ", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini>findByIdSession(@Param("idSessione") Long idSessione);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa AND codice_premio = :codicePremio", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini>findByIdSessionAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codicePremio") String codicePremio);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA "
				 + "WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))>20 "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))/12 <= 18", 
		   nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini>findByIdSessionAndCuaa9903(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
	
	
	@Query(
			value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA WHERE ID_SESSIONE = :idSessione and CUAA = :cuaa ",
			nativeQuery = true
		)
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini> findBySessioneAndCuaa(@Param("idSessione")Long idSessione, @Param("cuaa") String cuaa);
	
}
