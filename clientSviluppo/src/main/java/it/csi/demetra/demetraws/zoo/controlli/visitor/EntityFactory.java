package it.csi.demetra.demetraws.zoo.controlli.visitor;

import it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.Controllo;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_w_controllo_bean;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

public class EntityFactory {

    public EntityFactory() {
    }

    /**
     * il metodo getControllo si occupa di associare ad un codicePremio il corrispondente controllo (bean) da eseguire.
     * La corrispondenza tra codice premio e controllo è inserita in db nell'Entity {@link it.csi.demetra.demetraws.zoo.model.Dmt_w_controllo_bean}
     *
     * @param azienda  istanza relativa all'azienda presentatrice della domanda unica, è reperita dalla tabella  {@link Rpu_V_pratica_zoote}
     * @param sessione istanza relativa all'identificazione della sessione, è reperita dalla tabella  {@link Dmt_t_sessione}
     * @param controlliService istanza relativa al servizio di persistenza e recupero dal database
     * @param ctx application context di tipo {@link org.springframework.context.ApplicationContext}
     * @return istanza di tipo {@link Controllo} 
     * @throws ControlloException eccezione riferita al controllo di tipo {@link ControlloException}
     */
    public Controllo getControllo(Rpu_V_pratica_zoote azienda, Dmt_t_sessione sessione, ControlliService controlliService, ApplicationContext ctx) throws ControlloException {
        Dmt_w_controllo_bean c = controlliService.findByIdControlloBean(azienda.getCodicePremio());
        Controllo res = null;
        if (null != c)
            res = (Controllo) ctx.getBean(c.getBean());
        else throw new ControlloException("Bean corrispondente non trovato -> " + azienda.getCodicePremio());

        res.setSessione(sessione);
        res.setControlliService(controlliService);
        res.setAzienda(azienda);

        return res;
    }

}
