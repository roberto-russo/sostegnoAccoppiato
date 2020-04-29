package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;

@Repository
public interface Dmt_t_tws_bdn_du_capi_bovini_repository extends CrudRepository<Dmt_t_Tws_bdn_du_capi_bovini, Long> {

	List<Dmt_t_Tws_bdn_du_capi_bovini>findAll();

	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV WHERE id_sessione = :idSessione ", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini>findByIdSession(@Param("idSessione") Long idSessione);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV WHERE id_sessione = :idSessione AND CUAA = :cuaa and CODICE_PREMIO = :codiceIntervento ", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini>findByIdSessionAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV "
				 + "WHERE FK_id_sessione = :idSessione AND CUAA = :cuaa "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))>20 "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))/12 <= 18", 
		   nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini>findByIdSessionAndCuaa9903(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV where id_capo = :idCapo and EXTRACT(YEAR FROM data_nascita_vitello) = :annoCampagna and cuaa = :cuaa and id_sessione = :idSessione", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini>getVitelliOfVacca(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("idCapo") Long idCapo, @Param("annoCampagna") Long annoCampagna);

	@Query(value = "SELECT * FROM dmt_t_tws_bdn_du_capi_bov WHERE id_sessione = :idSessione and id_capo = (" + 
			"    select id_capo from dmt_t_tws_bdn_du_capi_bov where" + 
			"     id_sessione = :idSessione and id_capo = :idCapo and codice_premio = :codiceIntervento  group by id_capo having count(*) > 1 )", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini>findByIdSessioneAndIdCapo(@Param("idSessione") Long idSessione, @Param("idCapo") Long idCapo, @Param("codiceIntervento") String codiceIntervento);
	

	
}
