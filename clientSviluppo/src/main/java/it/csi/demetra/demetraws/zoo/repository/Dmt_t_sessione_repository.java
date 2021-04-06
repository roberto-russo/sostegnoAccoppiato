package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_sessione e le query ad esso associate.
 *
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_sessione_repository extends JpaRepository<Dmt_t_sessione, Long> {

    /**
     * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_sessione
     */
    List<Dmt_t_sessione> findAll();

    /**
     * Query che ritorna un'istanza di tipo @see Dmt_t_sessione in base a dataEora
     *
     * @param dataEora data in cui viene generato l'idSessione
     * @return istanza di tipo Dmt_t_sessione
     */
    @Query(value = "select id_sessione from dmt_t_sessione where data_e_ora = :dataEora ", nativeQuery = true)
    Dmt_t_sessione findSessioneByDataEora(@Param("dataEora") Date dataEora);

    @Query(value = "select * from dmt_t_sessione where id_sessione = :id ", nativeQuery = true)
    Optional<Dmt_t_sessione> findById(@Param("id") Long id);

    @Query(value = "WITH my_view AS (" +
            " select distinct id_sessione,cuaa,codice_premio from dmt_t_tws_bdn_du_capi_bov bo" +
            " UNION ALL" +
            " select distinct id_sessione,cuaa,codice_premio from dmt_t_tws_bdn_du_capi_ovica ov" +
            " UNION ALL" +
            " select distinct id_sessione,cuaa,codice_premio from dmt_t_cls_capo_macellato mac" +
            " ) select * from dmt_t_sessione where id_sessione IN (select MAX (id_sessione) from my_view where id_sessione != :idSessione AND cuaa = :cuaa AND codice_premio = :codicePremio)", nativeQuery = true)
    Dmt_t_sessione findOldSessione(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codicePremio") String codicePremio);
}
