package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_AgnelleRimonta_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_AgnelleRimonta;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_agnelleRimonta e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_AgnelleRimonta_repository extends CrudRepository<Dmt_t_AgnelleRimonta, Dmt_t_AgnelleRimonta_id> {

	
	@Query(value = "SELECT * FROM DMT_T_AGNELLE_RIMONTA dtr where id_sessione = :idSessione AND cuaa = :cuaa ", nativeQuery = true)
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_agnelleRimonta in base all'idSessione e cuaa.
	 * @param idSessione id della sessione associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @return List<Dmt_t_agnelleRimonta> lista delle occorrenze di agnelleRimonta.
	 */
	List<Dmt_t_AgnelleRimonta> findByIdSessioneAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
	
	@Query(value = "SELECT QT_CAPI_PREMIO FROM DMT_T_AGNELLE_RIMONTA dtr where id_sessione = :idSessione AND cuaa = :cuaa AND CODICE_INTERVENTO = :codiceIntervento", nativeQuery = true)
	/**
	 * query che ritorna la quotaCapiPremio in base all'idSessione, il cuaa e il codiceIntervento.
	 * @param idSessione codice sessione associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codiceIntervento codice premio per cui il richiedente effettua la richiesta.
	 * @return wuotaCapiPremio
	 */
	Double getQuotaCapiPremioByIdSessioneAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa,  @Param("codiceIntervento") String codiceIntervento);

	@Query(value = "SELECT * FROM DMT_T_AGNELLE_RIMONTA dtr where id_sessione = :idSessione AND cuaa = :cuaa AND ANNO_CAMPAGNA= :annoCampagna", nativeQuery = true)
	/**
	 * quey che ritorna una lista di istanze di tipo Dmt_t_agnelleRimonta in base all'idSessione, il cuaa e annoCampagna.
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param annoCampagna anno di campagna per cui viene effettuato lo scarico.
	 * @return List<Dmt_t_agnelleRimonta> lista delle istanze di Dmt_t_AgnelleRimonta.
	 */
	List<Dmt_t_AgnelleRimonta> findByIdSessioneAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("annoCampagna") Integer annoCampagna);
}
