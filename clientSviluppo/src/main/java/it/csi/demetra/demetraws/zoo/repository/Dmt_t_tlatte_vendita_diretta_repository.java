package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_latte_vendita_diretta_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_latte_vendita_diretta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_tlatte_vendita_diretta_repository e le query ad esso associate.
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_tlatte_vendita_diretta_repository extends CrudRepository<Dmt_t_latte_vendita_diretta, Dmt_t_latte_vendita_diretta_id> {

    @Query(value = "SELECT * FROM Dmt_t_latte_vendita_diretta WHERE cuua = :cuua AND anno_campagna = :annoCampagna", nativeQuery = true)
    /**
     * Query che ritorna una lista di istanze di tipo @see Dmt_t_tlatte_vendita_diretta in base al cuaa e ad annoCampagna
     * @param cuua codice fiscale del richiedente
     * @param annoCampagna anno della campagna
     * @return lista di istanze di tipo @see Dmt_t_latte_vendita_diretta
     */
    List<Dmt_t_latte_vendita_diretta> findByCUUAAndAnnoCampagna(@Param("cuua") String cuua, @Param("annoCampagna") int annoCampagna);
}
