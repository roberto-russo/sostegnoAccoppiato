package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_anagrafica_allevamenti e le query ad esso associate.
 *
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_anagrafica_allevamenti_repository extends CrudRepository<Dmt_t_anagrafica_allevamenti, Long> {


    @Query(value = "SELECT COUNT(*) FROM dmt_t_anagrafica_allev where id_sessione = :idSessione  and allev_id = :allevId and azienda_codice = :aziendaCodice",
            nativeQuery = true)
    Integer findByIdSessioneAndAllevIdAndAziendaCodice(@Param("idSessione") Long idSessione, @Param("allevId") BigDecimal allevId, @Param("aziendaCodice") String aziendaCodice);

    /**
     * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_anagrafica_allevamenti
     */
    List<Dmt_t_anagrafica_allevamenti> findAll();

    /**
     * query che ritorna l'istanza di tipo Dmt_t_anagrafica_allevamenti in base all'identificativo dell'allevamento
     *
     * @param allevId - identificativo dell'allevamento
     * @return Dmt_t_anagrafica_allevamenti
     */
    @Query(value = "SELECT * FROM Dmt_t_anagrafica_allev WHERE allev_id = :allevId", nativeQuery = true)
    Dmt_t_anagrafica_allevamenti findByAllevId(@Param("allevId") BigDecimal allevId);

    /**
     * query che ritorna il codice fiscale del detentore in base all'identificativo dell'allevamento e al codice aziendale
     *
     * @param aziendaCodice codice univoco dell'azienda in BDN
     * @param idSessione    identificativo univoco associato all'esecuzione
     * @return Dmt_t_anagrafica_allevamenti
     */
    @Query(value = "SELECT distinct cod_fiscale_deten FROM Dmt_t_anagrafica_allev WHERE azienda_codice = :aziendaCodice AND id_sessione = :idSessione", nativeQuery = true)
    String findByAziendaCodiceAndIdSessione(@Param("aziendaCodice") String aziendaCodice, @Param("idSessione") Long idSessione);

    /**
     * query che ritorna l'istanza di tipo Dmt_t_anagrafica_allevamenti in base all'identificativo dell'allevamento
     *
     * @param allevId    - identificativo dell'allevamento
     * @param idSessione identificativo univoco associato all'esecuzione
     * @return Dmt_t_anagrafica_allevamenti
     */
    @Query(value = "SELECT * FROM Dmt_t_anagrafica_allev WHERE allev_id = :allevId and id_sessione = :idSessione", nativeQuery = true)
    Dmt_t_anagrafica_allevamenti findByAllevIdAndSessione(@Param("allevId") BigDecimal allevId, @Param("idSessione") Long idSessione);

    /**
     * query che ritorna la lista delle listanze di tipo Dmt_t_anagrafica_allevamenti in base al codice fiscale del proprietario dell'allevamento
     *
     * @param cuaa codice fiscale del proprietario dell'allevamento
     * @return lista di istanze di tipo @see Dmt_t_anagrafica_allevamenti
     */
    @Query(value = "SELECT * FROM Dmt_t_anagrafica_allev WHERE cod_fiscale_prop = :cuaa ", nativeQuery = true)
    List<Dmt_t_anagrafica_allevamenti> findPropByCuaa(@Param("cuaa") String cuaa);

    /**
     * query che ritorna il codice fiscale del detentore degli aimali presenti in allevamento in base all'identificativo dell'allevamento
     * per cui risulta detentore
     *
     * @param allevId - identificativo dell'allevamento
     * @return cod_fiscale_deten codice fiscale del detentore aka cuaa
     */
    @Query(value = "SELECT cod_fiscale_deten FROM Dmt_t_anagrafica_allev WHERE allev_id = :allevId ", nativeQuery = true)
    String findDeteByCuaa(@Param("allevId") BigDecimal allevId);


    @Query(value = "SELECT distinct allev_id FROM dmt_t_anagrafica_allev WHERE cod_fiscale_prop = :cuaa and id_sessione = :idSessione", nativeQuery = true)
    List<Long> getListaAllevamentiPerCuaa(@Param("cuaa") String cuaa, @Param("idSessione") Long idSessione);

}
