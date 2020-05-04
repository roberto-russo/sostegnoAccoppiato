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
     * getControllo() si occupa di associare ad un codicePremio il corrispondente controllo (bean) da eseguire.
     * La corrispondenza tra codice premio e controllo è inserita in db nell'Entity Dmt_s_controllo_bean
     *
     * @param azienda
     * @param sessione
     * @param controlliService
     * @param ctx
     * @return
     * @throws ControlloException
     */
    public Controllo getControllo(Rpu_V_pratica_zoote azienda, Dmt_t_sessione sessione, ControlliService controlliService, ApplicationContext ctx) throws ControlloException {
        Optional<Dmt_w_controllo_bean> c = controlliService.findByIdControlloBean(azienda.getCodicePremio());
        Controllo res = null;
        if (c.isPresent())
            res = (Controllo) ctx.getBean(c.get().getBean());
        else throw new ControlloException("Bean corrispondente non trovato");

        res.setSessione(sessione);
        res.setControlliService(controlliService);
        res.setAzienda(azienda);

        return res;
    }

}
