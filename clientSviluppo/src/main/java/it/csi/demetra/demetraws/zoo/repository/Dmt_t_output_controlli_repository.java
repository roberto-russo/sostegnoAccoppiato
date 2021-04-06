package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_controlli_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_output_controlli e le query ad esso associate.
 *
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_output_controlli_repository extends CrudRepository<Dmt_t_output_controlli, Dmt_t_output_controlli_id> {


    /**
     * query che ritorna una lista di tipo Dmt_t_output_controlli in base allla sessione e al calcolo.
     *
     * @param sessione codice di sessione associato all'esecuzione
     * @param calcolo  nome del calcolo che ha prodotto l'output in Dmt_t_output_controlli.
     * @return lista di istanze di tipo Dmt_t_output_controlli
     */
    @Query(value = "select * from dmt_t_output_controlli select capo_id from dmt_t_output_esclusi where id_sessione = :sessione and calcolo LIKE CONCAT('%',:calcolo,'%') ",
            nativeQuery = true
    )
    List<Dmt_t_output_controlli> findBySessioneAndCalcolo(@Param("sessione") Long sessione, @Param("calcolo") String calcolo);


    /**
     * query che ritorna un'istanza di tipo Dmt_t_output_controlli in base alla sessione, il cuaa, l'annoCampagna e l'intervento.
     *
     * @param sessione         codice di sessione associato all'esecuzione
     * @param cuaa             codice fiscale del richiedente
     * @param anno             anno di campagna per cui viene effettuato lo scarico
     * @param codiceIntervento codice premio per cui il cuaa effettua la richiesta
     * @return istanza di tipo Dmt_t_output_controlli
     */
    @Query(
            value = "SELECT * FROM dmt_t_output_controlli where id_sessione = :sessione AND cuaa = :cuaa AND ANNO_CAMPAGNA = :anno AND intervento = :codiceIntervento ",
            nativeQuery = true
    )
    Dmt_t_output_controlli findBySessioneAndCuaaAndAnnoCampagnaAndIntervento(@Param("sessione") Dmt_t_sessione sessione, @Param("cuaa") String cuaa, @Param("anno") Long anno, @Param("codiceIntervento") String codiceIntervento);

    @Query(value = "select distinct anno_campagna, cuaa, 'M19' as intervento,\n" +
            "id_sessione, sum (capi_ammissibili) as capi_ammissibili,\n" +
            "sum (capi_richiesti) as capi_richiesti,\n" +
            "sum (capi_sanzionati) as capi_sanzionati\n" +
            "from dmt_t_output_controlli\n" +
            "where id_sessione=:sessione\n" +
            "and cuaa=:cuaa\n" +
            "and anno_campagna=:anno\n" +
            "and intervento in ('316','317','318','319')\n" +
            "group by anno_campagna, cuaa, id_sessione"
            ,
            nativeQuery = true
    )
    Dmt_t_output_controlli findBySessioneAndCuaaAndAnnoCampagnaAndInterventoM19(@Param("sessione") Dmt_t_sessione sessione, @Param("cuaa") String cuaa, @Param("anno") Long anno);

    @Query(value = "select capi_sanzionati from dmt_t_output_controlli where cuaa = :cuaa and intervento = :intervento and id_sessione=:idSessione", nativeQuery = true)
    Long findCapiSanzionati(@Param("cuaa") String cuaa, @Param("intervento") String intervento, @Param("idSessione") Long idSessione);
}
