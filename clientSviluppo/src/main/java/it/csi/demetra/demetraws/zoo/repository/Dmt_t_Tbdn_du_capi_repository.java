package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tbdn_du_capi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_Tbdn_du_capi_repository e le query ad esso associate.
 *
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_Tbdn_du_capi_repository extends CrudRepository<Dmt_t_Tbdn_du_capi, Long> {

    /**
     * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_Tbdn_du_capi
     */
    List<Dmt_t_Tbdn_du_capi> findAll();
}
