package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_subentro_zoo_repository e le query ad esso associate.
 *
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_subentro_zoo_repository extends CrudRepository<Dmt_t_subentro_zoo, Long> {

    /**
     * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_subentro_zoo
     */
    List<Dmt_t_subentro_zoo> findAll();

    /**
     * Query che ritorna un'istanza di tipo Dmt_t_subentro_zoo in base ad annoCampagna e cuaaDomanda
     *
     * @param annoCampagna anno della campagna
     * @param cuaaDomanda  codice fiscale del richiedente
     * @return istanza di tipo Dmt_t_subentro_zoo
     */
    @Query(value = "select * from dmt_t_subentro_zoo where anno_campagna = :annoCampagna and cuaa_domanda = :cuaaDomanda and data_fine is null", nativeQuery = true)
    Dmt_t_subentro_zoo findSubentroByData(@Param("annoCampagna") long annoCampagna, @Param("cuaaDomanda") String cuaaDomanda);
}
