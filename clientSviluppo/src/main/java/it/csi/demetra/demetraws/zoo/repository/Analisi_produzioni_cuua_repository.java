package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Analisi_produzioni_cuua_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_T_analisi_produzioni_cuua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_T_analisi_produzioni_cuua e le query ad esso associate.
 * @author Bcsoft
 */
@Repository
public interface Analisi_produzioni_cuua_repository extends JpaRepository<Dmt_T_analisi_produzioni_cuua, Analisi_produzioni_cuua_id> {

	/**
	 * Query che ritorna una lista di istanze di tipo Dmt_T_analisi_produzioni_cuaa in base al cuaa e ad annoCampagna
	 * @param CUUA codice fiscale del richiedente
	 * @param mYear annoCampagna
	 * @return lista di tipo  Dmt_T_analisi_produzioni_cuua
	 */
    @Query(value = "SELECT * FROM Dmt_T_analisi_produzioni_cuua WHERE CUUA = :CUUA AND anno_campagna = :mYear", nativeQuery = true)
    List<Dmt_T_analisi_produzioni_cuua> getByCUUAAndYear(@Param("CUUA") String CUUA, @Param("mYear") int mYear);

}
