package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_irregolarita_intenzionale_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_irregolarita_intenzionale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dmt_t_irregolarita_intenzionale_repository extends CrudRepository<Dmt_t_irregolarita_intenzionale, Dmt_t_irregolarita_intenzionale_id> {

    List<Dmt_t_irregolarita_intenzionale> findAll();

    /**
     * Query che ritorna una lista di istanze di tipo Dmt_t_irregolarita_intenzionale in base al cuaa ed annoCampagna
     *
     * @param cuaa         codice fiscale del richiedente
     * @param annoCampagna anno della campagna
     * @return lista di istanze di tipo Dmt_t_irregolarita_intenzionale
     */
    @Query(value = "SELECT * FROM dmt_t_irreg_inten where cuaa = :cuaa and anno_campagna = :annoCampagna",
            nativeQuery = true)
    List<Dmt_t_irregolarita_intenzionale> findIrregByCuaaAndAnnoCampagna(@Param("cuaa") String cuaa, @Param("annoCampagna") Integer annoCampagna);
}
