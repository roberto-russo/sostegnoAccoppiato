package it.csi.demetra.demetraws.zoo.controlli;

import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeInternalException_Exception;
import it.csi.demetra.demetraws.zoo.BdnWsManagerImpl;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.EntityFactory;
import it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.Controllo;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.text.ParseException;

/*
 * Author : Federico Pomponii
 * Date: 18/03/2019
 * */
@Component("controlliFramework")
public class ControlliFrameworkImpl implements ControlliFramework {



    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ControlliService controlliService;

    @Autowired
    private BdnWsManagerImpl bdnImpl;

    private EntityFactory entityFactory;

    public ControlliFrameworkImpl() {
        this.entityFactory = new EntityFactory();
    }

    /**
     *
     * @param azienda
     * @param subentro
     * @param sessione
     * @return
     * @throws ControlloException
     * @throws CalcoloException
     * Dopo lo scarico massivo dei dati dalla BDN questo metodo eseguo il controllo corrispondente per
     * azienda, codice premio e sessione
     */
    @Override
    public Integer handleControlloCUUA(Rpu_V_pratica_zoote azienda, Dmt_t_subentro_zoo subentro, Dmt_t_sessione sessione) throws ControlloException,CalcoloException {
            Controllo controllo = entityFactory.getControllo(azienda, sessione, controlliService, applicationContext);
            controllo.preEsecuzione();
            controllo.esecuzione();
            controllo.postEsecuzione();
        return -1;
    }

    /**
     *
     * @param azienda
     * @param subentro
     * @param sessione
     * @return
     * Questo metodo prende esegue lo scarico dei dati dalla BDN per ogni singolo soggetto.
     * Viene eseguito dal Controller per ogni singola azienda.
     */
    @Override
    public Boolean scaricoDati(Rpu_V_pratica_zoote azienda, Dmt_t_subentro_zoo subentro, Dmt_t_sessione sessione) {
        try {
            bdnImpl.getElencoCapiPremio(azienda.getCodicePremio(), azienda.getCuaa(), azienda.getAnnoCampagna(), sessione);
            bdnImpl.Consistenza_UBA_Censim_Ovini_2012(azienda.getCuaa(), "01/01/2018", "31/12/2018", "D", sessione);
            bdnImpl.Consistenza_UBA_Censim_Ovini_2012(azienda.getCuaa(), "01/01/2018", "31/12/2018", "P", sessione);
            if (subentro != null) {
                bdnImpl.getElencoCapiPremio2(0L, azienda.getCodicePremio(), azienda.getCuaa(), subentro.getCuaaSubentro(), subentro.getAnnoCampagna(), sessione);
            }
            return true;
        } catch (JAXBException | WSBridgeInternalException_Exception | ParseException | NullPointerException e) {
            // TODO Auto-generated catch block
            System.out.println("ERRORE: " + e.getCause());
        }
        return false;
    }
}
