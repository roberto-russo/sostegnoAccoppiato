package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_Tws_bdn_du_capi_ovicaprini_repository extends CrudRepository<Dmt_t_Tws_bdn_du_capi_ovicaprini, Long>{
	
	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_Tws_bdn_du_capi_bovini
	 */
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini> findAll();
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA where id_sessione = :idSessione ", nativeQuery = true)
	/**
	 * Query che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini in base adidSessione
	 * @param idSessione codice identificativo univoco associato all'esecuzione
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini
	 */
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini>findByIdSession(@Param("idSessione") Long idSessione);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA where id_sessione = :idSessione AND CUAA = :cuaa AND codice_premio = :codicePremio", nativeQuery = true)
	/**
	 * Query che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini in base ad idSessione, cuaa e codicePremio
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codicePremio codice intervento
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini
	 */
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini>findByIdSessionAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codicePremio") String codicePremio);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA "
				 + "where id_sessione = :idSessione AND CUAA = :cuaa "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))>20 "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))/12 <= 18", 
		   nativeQuery = true)
	/**
	 * Query che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini in base ad idSessione e cuaa
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del detentore
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini
	 */
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini>findByIdSessionAndCuaa9903(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
	
	
	@Query(
			value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA where id_sessione = :idSessione and CUAA = :cuaa ",
			nativeQuery = true
		)
	/**
	 * Query che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini in base ad idSessione e cuaa
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @return lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini
	 */
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini> findBySessioneAndCuaa(@Param("idSessione")Long idSessione, @Param("cuaa") String cuaa);
	
	@Query(value = "SELECT * FROM DMT_T_TWS_BDN_DU_CAPI_OVICA WHERE ID_CAPO IN (SELECT ID_CAPO FROM DMT_T_PREMIO_CAPI WHERE DMT_T_PREMIO_CAPI.ID_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento) "
			+ " AND id_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento ", nativeQuery = true )
	List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getOvicapriniUbaMinime(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
}
