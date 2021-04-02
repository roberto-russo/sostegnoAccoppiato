package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_premio_capi_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dmt_t_premio_capi_repository extends CrudRepository<Dmt_t_premio_capi, Dmt_t_premio_capi_id> {


    List<Dmt_t_premio_capi> findAll();

    @Query(value = "select distinct id_capo from dmt_t_premio_capi where id_sessione = :idSessione and flag_amissibile = 'S' and cuaa = :cuaa and codice_premio = :codPremio",
            nativeQuery = true)
    List<Long> getListaCapiEsitoByIdSessioneAndFlagAmmissibileAndCuaaAndCodPremio(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codPremio") String codPremio);


    @Query(
            value = "SELECT codice_premio FROM dmt_t_premio_capi c WHERE id_capo = :idCapo and id_sessione = :idSessione and flag_amissibile = 'S' " +
                    " and codice_premio not IN (select codice_premio from DMT_T_OUTPUT_ESCLUSI e where c.id_capo = e.capo_id  AND c.codice_premio = e.codice_premio" +
                    " AND tipologia_esclusione='E' AND id_sessione = :idSessione) ",
            nativeQuery = true
    )
    List<String> findCodiciPremioByIdCapoAndIdSessione(@Param("idCapo") Long idCapo, @Param("idSessione") Long idSessione);

}
