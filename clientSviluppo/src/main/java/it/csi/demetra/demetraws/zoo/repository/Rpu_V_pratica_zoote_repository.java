package it.csi.demetra.demetraws.zoo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Rpu_V_pratica_zoote_id;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Rpu_V_pratica_zoote_repository e le query ad esso associate.
 * @author Bcsoft
 */
public interface Rpu_V_pratica_zoote_repository extends CrudRepository<Rpu_V_pratica_zoote, Rpu_V_pratica_zoote_id>{

	@Query(
			value = " SELECT * FROM RPU_V_PRATICA_ZOOTE PZ WHERE PZ.ANNO_CAMPAGNA = :annoCampagna", 
			nativeQuery = true
		  )
	/**
	 * Query che ritorna una lista di istanze di tipo @see Rpu_V_pratica_zoote_repository in base ad annoCampagna
	 * @param annoCampagna anno della campagna
	 * @return  List<Rpu_V_pratica_zoote_repository>
	 */
	List<Rpu_V_pratica_zoote> findAll(@Param("annoCampagna") Integer annoCampagna);
	
	@Query(
			value = "SELECT R FROM Rpu_V_pratica_zoote R WHERE R.codicePremio IN (:codiciPremio) AND R.annoCampagna = :annoCampagna"	
		)
	/**
	 * Query che ritorna una lista di istanze di tipo @see Rpu_V_pratica_zoote_repository in base ad una lista di codiciPremio e ad annoCampagna
	 * @param codiciPremioList lista dei codici premio 
	 * @param annoCampagna anno della campagna
	 * @return List<Rpu_V_pratica_zoote_repository>
	 */
	List<Rpu_V_pratica_zoote> findByCodiciPremioAndAnnoCampagna(@Param("codiciPremio") List<String> codiciPremioList, @Param("annoCampagna") Integer annoCampagna);
	
	@Query(
			value = " SELECT * FROM RPU_V_PRATICA_ZOOTE PZ WHERE PZ.ANNO_CAMPAGNA = :annoCampagna and Cuaa = :cuaa and Codice_premio = :codicePremio", 
			nativeQuery = true
		  )
		  /**
	 * Query che ritorna un'istanza di tipo @see Rpu_V_pratica_zoote_repository in base ad annoCampagna, cuaa e codicePremio
	 * @param annoCampagna anno della campagna
	 * @param cuaa codice fiscale del detentore
	 * @param codicePremio codice intervento
	 * @return Rpu_V_pratica_zoote_repository
	 */
	Rpu_V_pratica_zoote findByAnnoCampagnaAndCuaaAndCodicePremio(@Param("annoCampagna") Integer annoCampagna, @Param("cuaa") String cuaa, @Param("codicePremio") String codicePremio);

	@Query(
			value = "SELECT codice_premio FROM RPU_V_PRATICA_ZOOTE WHERE cuaa = :cuaa", 
			nativeQuery = true
		)
	/**
	 * Query che ritorna una lista di codici premio in base a cuaa
	 * @param cuaa codice fiscale del detentore
	 * @return List<String> lista dei codici premio associati al codice fiscale del richiedente
	 */
	List<String> findByCuaa(@Param("cuaa") String cuaa);
	
	
	@Query(value = "SELECT giorni_di_ritardo FROM rpu_v_pratica_zoote WHERE cuaa = :cuaa AND codice_premio = :codicePremio AND anno_campagna = :annoCampagna",
			nativeQuery = true)
	Integer findByCuaaAndCodicePremioAndAnnoCampagna(@Param("cuaa") String cuaa, @Param("codicePremio") String codicePremio, @Param("annoCampagna") Integer annoCampagna);

}