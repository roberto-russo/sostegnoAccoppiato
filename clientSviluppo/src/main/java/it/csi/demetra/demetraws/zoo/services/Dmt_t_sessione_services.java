package it.csi.demetra.demetraws.zoo.services;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_sessione_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_sessione_repository
 * per la persistenza di oggetti di tipo Dmt_t_sessione
 *
 * @author Bcsoft
 */
@Service
public class Dmt_t_sessione_services {

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_sessione_repository.
     */
    @Autowired
    Dmt_t_sessione_repository rep;

    /**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo Dmt_t_sessione.
     * {@link Dmt_t_sessione_repository#findSessioneByDataEora(Date)}
     *
     * @return lista degli oggetti di tipo {@link Dmt_t_sessione}
     */
    public List<Dmt_t_sessione> getAll() {
        return rep.findAll();
    }

    /**
     * Metodo che ritorna un'istanza di tipo @see Dmt_t_sessione in base a dataEora.
     *
     * @param dataEora data in cui è stato creata la sessione
     * @return istanza di tipo @see Dmt_t_sessione
     * @see Dmt_t_sessione_repository
     */
    public Dmt_t_sessione get(Date dataEora) {
        return rep.findSessioneByDataEora(dataEora);
    }

    /**
     * Metodo che effettua il salvataggio a DB di un'istanza di tipo Dmt_t_sessione.
     *
     * @param sessione identificativo univoco associato all'esecuzione
     * @return istanza di tipo {@link Dmt_t_sessione} da salvare a DB
     */

    public Dmt_t_sessione saveSession(Dmt_t_sessione sessione) {
        Dmt_t_sessione o = rep.save(sessione);
        return o;
    }

    /**
     * Metodo che ritorna un'istanza di tipo {@link Dmt_t_sessione} in base a idSessione
     *
     * @param idSessione identificativo univoco associato all'esecuzione
     * @return istanza di tipo {@link Dmt_t_sessione}
     */
    public Dmt_t_sessione getById(Long idSessione) {
        // return rep.findById(idSessione).orElseThrow( () ->  new NoSuchElementException());
        Dmt_t_sessione sessione = rep.findById(idSessione).get();
        if (null == sessione)
            throw new NoSuchElementException();
        else return sessione;
    }

    public Dmt_t_sessione getOldSessione(Long idSessione, String cuaa, String codicePremio) {
        Dmt_t_sessione sessione = rep.findOldSessione(idSessione,cuaa,codicePremio);
        return sessione;
    }
}
