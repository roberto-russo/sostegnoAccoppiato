package it.csi.demetra.demetraws.zoo.controlli;

import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeInternalException_Exception;
import it.csi.demetra.demetraws.zoo.BdnWsManagerImpl;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.EntityFactory;
import it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.Controllo;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CtlUbaMinime ref9903;

    private EntityFactory entityFactory;

    public ControlliFrameworkImpl() {
        this.entityFactory = new EntityFactory();
    }

    /**
     * Dopo lo scarico massivo dei dati dalla BDN questo metodo esegue il controllo
     * corrispondente per azienda, codice premio e sessione
     *
     * @param azienda  istanza dell'azienda presentatrice della domanda unica, è
     *                 reperita dalla tabella
     *                 {@link it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote}
     * @param subentro istanza riferita al subetro in azienda di un soggetto, è
     *                 reperita dalla tabella
     *                 {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo}
     * @param sessione istanza riferita all'identificazione della sessione, è
     *                 reperita dalla tabella
     *                 {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione}
     * @throws ControlloException eccezione riferita al controllo
     *                            {@link it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.Controllo}
     * @throws CalcoloException   eccezione riferita al calcolo
     *                            {@link it.csi.demetra.demetraws.zoo.calcoli.CalcoloException}
     */
    @Override
    public void handleControlloCUUA(List<Rpu_V_pratica_zoote> listAziende, String cuaa, Integer annoCampagna,
                                    Dmt_t_subentro_zoo subentro, Dmt_t_sessione sessione) throws ControlloException, CalcoloException {
        System.out.println("\n\n\nHANDLING CUAA -> " + cuaa + "\n\n\n");
        List<Controllo> controlliList = new ArrayList<Controllo>();
        Map<String, List<Dmt_t_premio_capi>> result9903 = new HashMap<String, List<Dmt_t_premio_capi>>();
        Map<String, List<?>> capiTo9903 = new HashMap<>();
        for (Rpu_V_pratica_zoote x : listAziende) {
            try {
                Controllo controllo = entityFactory.getControllo(x, sessione, controlliService, applicationContext);
                capiTo9903.put(x.getCodicePremio(), new ArrayList<>(controllo.preEsecuzione()));
                controlliList.add(controllo);
            } catch (Exception e) {

            }
        }

        System.out.println("\n\n\nControlli elaborati -> " + controlliList.size() + "\n\n\n");

        ref9903.init(capiTo9903, annoCampagna, cuaa, sessione);
        ResultCtlUbaMinime resultCalcolo = ref9903.calcolo();

        if (!resultCalcolo.isResult())
            return;

        result9903 = resultCalcolo.getListaCapi();
        for (Controllo c : controlliList) {
            try {
                c.esecuzione(result9903.get(c.getAzienda().getCodicePremio()));
                c.postEsecuzione();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Questo metodo esegue lo scarico dei dati dalla BDN per ogni singolo soggetto.
     * Viene eseguito dal Controller per ogni singola azienda.
     *
     * @param azienda  istanza relativa all'azienda presentatrice della domanda
     *                 unica, è reperita dalla tabella {@link Rpu_V_pratica_zoote}
     * @param subentro istanza relativa al subentro in azienda di un soggetto, è
     *                 reperita dalla tabella {@link Dmt_t_subentro_zoo}
     * @param sessione istanza relativa all'identificazione della sessione, è
     *                 reperita dalla tabella {@link Dmt_t_sessione}
     * @return valore Booleano: - <b>true</b> se lo scarico è avvenuto -
     * <b>false</b> altrimenti
     */
    @Override

    public Boolean scaricoDati(Rpu_V_pratica_zoote azienda, Dmt_t_subentro_zoo subentro, Dmt_t_sessione sessione,
                               Integer annoCampagna) {
        try {
            bdnImpl.getElencoCapiPremio(azienda.getCodicePremio(), azienda.getCuaa(), azienda.getAnnoCampagna(),
                    sessione);
            bdnImpl.Consistenza_UBA_Censim_Ovini_2012(azienda.getCuaa(), "01/01/" + annoCampagna,
                    "31/12/" + annoCampagna, "D", sessione);
            bdnImpl.Consistenza_UBA_Censim_Ovini_2012(azienda.getCuaa(), "01/01/" + annoCampagna,
                    "31/12/" + annoCampagna, "P", sessione);
            bdnImpl.getAnagraficaAllevamenti(azienda.getCuaa(), null, azienda.getCodicePremio(), sessione);
            if (subentro != null) {
                bdnImpl.getElencoCapiPremio2(0L, azienda.getCodicePremio(), azienda.getCuaa(),
                        subentro.getCuaaSubentro(), subentro.getAnnoCampagna(), sessione);
            }
            return true;
        } catch (JAXBException | WSBridgeInternalException_Exception | ParseException | NullPointerException e) {
            // TODO Auto-generated catch block
            System.out.println("ERRORE: " + e.getCause());
        }
        return false;
    }

    @Override
    public void duplicaSessioneByCuaa(Rpu_V_pratica_zoote azienda, Dmt_t_sessione sessioneOld,
                                      Dmt_t_sessione sessioneNew) {
        bdnImpl.duplicaSessioneByCuaa(azienda, sessioneOld, sessioneNew);
    }
}
