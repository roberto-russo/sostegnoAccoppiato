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

	@Query(value = "SELECT * FROM dmt_t_tws_bdn_du_capi_bov WHERE id_sessione = :idSessione and id_capo = :idCapo and CODICE_PREMIO = :codiceIntervento ", 
		   nativeQuery = true)
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
			"        OE.SESSIONE = :idSessione AND " + 
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
			"        OE.SESSIONE = :idSessione AND " + 
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
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV WHERE ID_CAPO IN (SELECT ID_CAPO FROM DMT_T_PREMIO_CAPI WHERE DMT_T_PREMIO_CAPI.SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento AND FLAG_AMISSIBILE='S') "
			+ " AND id_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento ", nativeQuery = true )
	List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniUbaMinime(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
	
	
	@Query(value = "SELECT DISTINCT ID_ALLEVAMENTO FROM DMT_T_TWS_BDN_DU_CAPI_BOV " + 
			" WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento ", nativeQuery = true)
	List<Integer> getAllevamentiBySessioneCuaaCodIntervento(@Param("idSessione") Long idSessione, @Param("cuaa")String cuaa,@Param("codiceIntervento")String codiceIntervento);

	
	@Query(value =  " SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV DMT_BOV " + 
			" WHERE " + 
			" dmt_bov.id_sessione = :idSessione " + 
			" and dmt_bov.id_allevamento in (     " + 
			"    SELECT DISTINCT dmt_allev.allev_id " + 
			"    FROM dmt_t_anagrarfica_allev dmt_allev " + 
			"    WHERE dmt_allev.id_autogenerato  in ( " + 
			"                                                        SELECT DISTINCT  dmt_allev2.id_autogenerato " + 
			"                                                        FROM dmt_t_anagrarfica_allev  dmt_allev2 " + 
			"                                                        WHERE " + 
			"                                                        dmt_allev2.allev_id in (" + 
			"                                                                                SELECT DISTINCT dcb.ID_ALLEVAMENTO " + 
			"                                                                                FROM DMT_T_TWS_BDN_DU_CAPI_BOV  dcb " + 
			"                                                                                WHERE dcb.ID_SESSIONE = :idSessione " + 
			"                                                                                AND dcb.CUAA = :cuaa " + 
			"                                                                                AND dcb.CODICE_PREMIO = :codiceIntervento " + 
			"                                                                                )" + 
			"                                                        AND dmt_allev2.ID_SESSIONE =:idSessione" + 
			"                                                        AND dmt_allev2.DT_FINE_DETENTORE IS NULL " + 
			"                                                        AND dmt_allev2.DT_FINE_ATTIVITA IS NULL " + 
			"                                )" + 
			"     AND NVL(dmt_allev.COD_FISCALE_DETEN,dmt_allev.COD_FISCALE_PROP) in ( " + 
			"					                                                       SELECT DISTINCT NVL(a.cod_fiscale_deten,a.cod_fiscale_prop) as detentore  " + 
			"					                                                       FROM dmt_t_anagrarfica_allev  a " + 
			"					                                                       WHERE  " + 
			"					                                                       a.allev_id in ( " + 
			"					                                                                               SELECT DISTINCT d.ID_ALLEVAMENTO  " + 
			"					                                                                               FROM DMT_T_TWS_BDN_DU_CAPI_BOV  d  " + 
			"					                                                                               WHERE d.ID_SESSIONE = :idSessione  " + 
			"					                                                                               AND d.CUAA = :cuaa  " + 
			"					                                                                               AND d.CODICE_PREMIO = :codiceIntervento " + 
			"					                                                                               ) " + 
			"					                                                       AND a.ID_SESSIONE =:idSessione " + 
			"					                                                   ) " + 
			"    )" + 
			" and dmt_bov.cuaa = :cuaa " + 
			" and dmt_bov.codice_premio = :codiceIntervento ", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniOfDetentoriAllevamentiAttivi(@Param("idSessione") Long idSessione, @Param("cuaa")String cuaa,@Param("codiceIntervento")String codiceIntervento);
	
	@Query(value =  " SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV DMT_BOV " + 
			" WHERE " + 
			" dmt_bov.id_sessione = :idSessione " + 
			" and dmt_bov.id_allevamento in (     " + 
			"    SELECT DISTINCT dmt_allev.allev_id " + 
			"    FROM dmt_t_anagrarfica_allev dmt_allev " + 
			"    WHERE dmt_allev.id_autogenerato not in ( " + 
			"                                                        SELECT DISTINCT  dmt_allev2.id_autogenerato " + 
			"                                                        FROM dmt_t_anagrarfica_allev  dmt_allev2 " + 
			"                                                        WHERE " + 
			"                                                        dmt_allev2.allev_id in (" + 
			"                                                                                SELECT DISTINCT dcb.ID_ALLEVAMENTO " + 
			"                                                                                FROM DMT_T_TWS_BDN_DU_CAPI_BOV  dcb " + 
			"                                                                                WHERE dcb.ID_SESSIONE = :idSessione " + 
			"                                                                                AND dcb.CUAA = :cuaa " + 
			"                                                                                AND dcb.CODICE_PREMIO = :codiceIntervento " + 
			"                                                                                )" + 
			"                                                        AND dmt_allev2.ID_SESSIONE =:idSessione" + 
			"                                                        AND dmt_allev2.DT_FINE_DETENTORE IS NULL " + 
			"                                                        AND dmt_allev2.DT_FINE_ATTIVITA IS NULL " + 
			"                                )" + 
			"     AND NVL(dmt_allev.COD_FISCALE_DETEN,dmt_allev.COD_FISCALE_PROP) in ( " + 
			"					                                                       SELECT DISTINCT NVL(a.cod_fiscale_deten,a.cod_fiscale_prop) as detentore  " + 
			"					                                                       FROM dmt_t_anagrarfica_allev  a " + 
			"					                                                       WHERE  " + 
			"					                                                       a.allev_id in ( " + 
			"					                                                                               SELECT DISTINCT d.ID_ALLEVAMENTO  " + 
			"					                                                                               FROM DMT_T_TWS_BDN_DU_CAPI_BOV  d  " + 
			"					                                                                               WHERE d.ID_SESSIONE = :idSessione  " + 
			"					                                                                               AND d.CUAA = :cuaa  " + 
			"					                                                                               AND d.CODICE_PREMIO = :codiceIntervento " + 
			"					                                                                               ) " + 
			"					                                                       AND a.ID_SESSIONE =:idSessione " + 
			"					                                                   ) " + 
			"    )" + 
			" and dmt_bov.cuaa = :cuaa " + 
			" and dmt_bov.codice_premio = :codiceIntervento ", nativeQuery = true)
	List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniOfDetentoriAllevamentiNonAttivi(@Param("idSessione") Long idSessione, @Param("cuaa")String cuaa,@Param("codiceIntervento")String codiceIntervento);

	@Query(
			value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_BOV WHERE ID_SESSIONE = :idSessione and CUAA = :cuaa ",
			nativeQuery = true
		)
	List<Dmt_t_Tws_bdn_du_capi_bovini> findBySessioneAndCuaa(@Param("idSessione")Long idSessione, @Param("cuaa") String cuaa);

	
	@Query(
			value = "SELECT DISTINCT codice_premio FROM dmt_t_tws_bdn_du_capi_bov WHERE id_capo = :idCapo and id_sessione = :idSessione ",
			nativeQuery = true
		)
	List<String> findCodiciPremioByIdCapoAndIdSessione(@Param("idCapo") Long idCapo, @Param("idSessione") Long idSessione);
	
}
