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
			+ "WHERE id_sessione = :idSessione AND CUAA = :cuaa "
			+ "AND codice_premio = :codIntervento",
			nativeQuery = true)
			List<Dmt_t_Tws_bdn_du_capi_bovini>findByIdSessionAndCuaa9903(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codIntervento") String codIntervento);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV where id_capo = :idCapo and EXTRACT(YEAR FROM data_nascita_vitello) = :annoCampagna and cuaa = :cuaa and id_sessione = :idSessione", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini>getVitelliOfVacca(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("idCapo") Long idCapo, @Param("annoCampagna") Long annoCampagna);

	@Query(value = "SELECT * FROM dmt_t_tws_bdn_du_capi_bov WHERE id_sessione = :idSessione and id_capo = :idCapo and CODICE_PREMIO = :codiceIntervento "
				 + "GROUP BY id_autogenerato having count(*) > 1", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini>findByIdSessioneAndIdCapo(@Param("idSessione") Long idSessione, @Param("idCapo") Long idCapo, @Param("codiceIntervento") String codiceIntervento);
	
	@Query(value = "SELECT * " + 
			"    FROM DMT_T_TWS_BDN_DU_CAPI_BOV " + 
			"WHERE " + 
			"    ID_ALLEVAMENTO NOT IN " + 
			"    	(SELECT ALLEV_ID FROM DMT_T_INFO_ALLEVAMENTI WHERE ALLEV_ID IN " + 
			"    		(   SELECT DISTINCT ID_ALLEVAMENTO FROM DMT_T_TWS_BDN_DU_CAPI_BOV " + 
			"       	 WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento) " + 
			"        AND FLAG_ZONA_MONTANA = 'N') " + 
			"    AND ID_SESSIONE = :idSessione " + 
			"    AND CUAA = :cuaa " + 
			"    AND CODICE_PREMIO = :codiceIntervento", nativeQuery = true )
	List<Dmt_t_Tws_bdn_du_capi_bovini> getListaCapiAmmessiZonaMontanaInt311Mis2(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);

	@Query(value = "SELECT * " + 
			"    FROM DMT_T_TWS_BDN_DU_CAPI_BOV " + 
			"WHERE " + 
			"    ID_ALLEVAMENTO IN " + 
			"    	(SELECT ALLEV_ID FROM DMT_T_INFO_ALLEVAMENTI WHERE ALLEV_ID IN " + 
			"    		(   SELECT DISTINCT ID_ALLEVAMENTO FROM DMT_T_TWS_BDN_DU_CAPI_BOV " + 
			"        	WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento) " + 
			"        AND FLAG_ZONA_MONTANA = 'N') " + 
			"    AND ID_SESSIONE = :idSessione " + 
			"    AND CUAA = :cuaa " + 
			"    AND CODICE_PREMIO = :codiceIntervento", nativeQuery = true )
	List<Dmt_t_Tws_bdn_du_capi_bovini> getListaCapiEsclusZonaMontanaiInt311Mis2(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);

	
	
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV WHERE ID_CAPO IN (SELECT ID_CAPO FROM DMT_T_PREMIO_CAPI PC " + 
			" WHERE PC.CODICE_PREMIO = '310'" + 
			" AND PC.ID_CAPO " + 
			" NOT IN (SELECT capo_id " + 
			"        FROM DMT_T_OUTPUT_ESCLUSI OE " + 
			"        WHERE" + 
			"        OE.ID_SESSIONE = :idSessione AND " + 
			"        OE.CALCOLO LIKE ('%Int310Mis1') " + 
			"        )" + 
			" AND PC.SESSIONE = :idSessione " + 
			" AND PC.CUAA = :cuaa ) " +
		    " AND id_sessione = :idSessione AND CUAA = :cuaa and CODICE_PREMIO = :codiceIntervento " +
		    " AND ID_ALLEVAMENTO NOT IN " + 
		    "	(SELECT ALLEV_ID FROM DMT_T_INFO_ALLEVAMENTI WHERE ALLEV_ID IN " + 
		    " (   SELECT DISTINCT ID_ALLEVAMENTO FROM DMT_T_TWS_BDN_DU_CAPI_BOV " + 
		    " WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento) " + 
		    " AND FLAG_ZONA_MONTANA = 'N') ", nativeQuery = true )
	List<Dmt_t_Tws_bdn_du_capi_bovini>getBoviniIdoneiInt310Mis1ZonaMontana(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV WHERE ID_CAPO IN (SELECT ID_CAPO FROM DMT_T_PREMIO_CAPI PC " + 
			" WHERE PC.CODICE_PREMIO = '310'" + 
			" AND PC.ID_CAPO " + 
			" NOT IN (SELECT capo_id " + 
			"        FROM DMT_T_OUTPUT_ESCLUSI OE " + 
			"        WHERE" + 
			"        OE.ID_SESSIONE = :idSessione AND " + 
			"        OE.CALCOLO LIKE ('%Int310Mis1') " + 
			"        )" + 
			" AND PC.SESSIONE = :idSessione " + 
			" AND PC.CUAA = :cuaa ) " +
		    " AND id_sessione = :idSessione AND CUAA = :cuaa and CODICE_PREMIO = :codiceIntervento " +
		    " AND ID_ALLEVAMENTO IN " + 
		    "	(SELECT ALLEV_ID FROM DMT_T_INFO_ALLEVAMENTI WHERE ALLEV_ID IN " + 
		    " (   SELECT DISTINCT ID_ALLEVAMENTO FROM DMT_T_TWS_BDN_DU_CAPI_BOV " + 
		    " WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento) " + 
		    " AND FLAG_ZONA_MONTANA = 'N') ", nativeQuery = true )
	List<Dmt_t_Tws_bdn_du_capi_bovini>getBoviniIdoneiInt310Mis1NonDiZonaMontana(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV WHERE ID_CAPO IN (SELECT ID_CAPO FROM DMT_T_PREMIO_CAPI WHERE SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento AND FLAG_AMMISSIBILE='S') "
			+ " AND SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento ", nativeQuery = true )
	List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniUbaMinime(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
	
}
