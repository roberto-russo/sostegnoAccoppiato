package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo DsUBA_censimenti_allevamenti_ovini_repository e le query ad esso associate.
 * @author Bcsoft
 */
@Repository
public interface DsUBA_censimenti_allevamenti_ovini_repository extends CrudRepository<Dmt_t_DsUBA_censimenti_allevamenti_ovini, Long>{

	/**
	 * Query che ritorna una lista di istanze di tipo DsUBA_censimenti_allevamenti_ovini_repository in base ad idSessione e codiceAzienda
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param codFiscaleDete codice fiscale del detentore
	 * @return lista di istanze di tipo Dmt_t_DsUBA_censimenti_allevamenti_ovini
	 */
	@Query(value = "SELECT * FROM DMT_T_UBA_CENSIM_ALLEV_OVINI  where id_sessione = :idSessione AND COD_FISCALE_DETE  = :codFiscaleDete", nativeQuery = true)
	List<Dmt_t_DsUBA_censimenti_allevamenti_ovini> findByIdSessioneAndCodFiscaleDete(@Param("idSessione") Long idSessione, @Param("codFiscaleDete") String codFiscaleDete);
	

}
