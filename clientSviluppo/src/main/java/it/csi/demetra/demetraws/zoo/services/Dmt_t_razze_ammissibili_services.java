package it.csi.demetra.demetraws.zoo.services;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_razze_ammissibili;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_razze_ammissibili_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_razze_ammissibili_repository
 * per la persistenza di oggetti di tipo Dmt_t_razze_ammissibili
 *
 * @author Bcsoft
 */
@Service
public class Dmt_t_razze_ammissibili_services {

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_premio_capi_repository.
     */
    @Autowired
    Dmt_t_razze_ammissibili_repository rep;

    /**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo Dmt_t_razze_ammissibili.
     *
     * @return lista degli oggetti di tipo {@link Dmt_t_razze_ammissibili}
     * @see Dmt_t_razze_ammissibili_repository
     */
    public List<Dmt_t_razze_ammissibili> getAll() {
        return rep.findAll();
    }
}
