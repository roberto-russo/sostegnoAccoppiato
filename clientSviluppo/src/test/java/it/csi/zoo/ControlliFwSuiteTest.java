package it.csi.zoo;

import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeInternalException_Exception;
import it.csi.demetra.demetraws.zoo.BdnWsManagerImpl;
import it.csi.demetra.demetraws.zoo.ZooApplication;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.EntityFactory;
import it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.Controllo;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_sessione_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_subentro_zoo_services;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBException;
import java.text.ParseException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Author : Federico Pomponii
 * Suite di test per i principali 'Controlli' dell'applicativo
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZooApplication.class)
public class ControlliFwSuiteTest {
    @Autowired
    Dmt_t_subentro_zoo_services subentroService;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private Dmt_t_sessione_services sessioneService;
    @Autowired
    private BdnWsManagerImpl bdnImpl;
    @Autowired
    private ControlliService controlliService;

    private EntityFactory entityFactory;
    private Dmt_t_sessione sessione;

    @Before
    public void init() {
        sessione = sessioneService.saveSession(new Dmt_t_sessione());
        this.entityFactory = new EntityFactory();
    }

    private Boolean scarico(String codicePremio, String cuaa, int anno, Dmt_t_sessione sessione, Dmt_t_subentro_zoo subentro) {
        try {
            bdnImpl.getElencoCapiPremio(codicePremio, cuaa, anno, sessione);
            bdnImpl.Consistenza_UBA_Censim_Ovini_2012(cuaa, "01/01/" + anno, "31/12/" + anno, "D", sessione);
            bdnImpl.Consistenza_UBA_Censim_Ovini_2012(cuaa, "01/01/" + anno, "31/12/" + anno, "P", sessione);
            bdnImpl.getAnagraficaAllevamenti(cuaa, null, codicePremio, sessione);
            if (subentro != null) {
                bdnImpl.getElencoCapiPremio2(0L, codicePremio, cuaa, subentro.getCuaaSubentro(), subentro.getAnnoCampagna(), sessione);
            }
            return true;
        } catch (JAXBException | WSBridgeInternalException_Exception | ParseException | NullPointerException e) {
            // TODO Auto-generated catch block
            System.out.println("ERRORE: " + e.getCause());
        }
        return false;
    }

    /**
     * Test su bovini
     * CUUA: BRBVCN63M29D205G
     * Anno: 2018
     * Codice premio: 310
     * Capi richiesi: 209
     * Capi ammissibili: 209
     */
    @Test
    public void TestClcInt310Mis1() {
        String cuaa = "BRBVCN63M29D205G";
        String cPremio = "310";
        int anno = 2018;
        int expRichiesti = 209;
        int expAmmissibili = 209;
        Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
        azienda.setAnnoCampagna(anno);
        azienda.setCodicePremio(cPremio);
        azienda.setCuaa(cuaa);
        if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
            Controllo controllo = (Controllo) applicationContext.getBean("ClcInt310Mis1");
            controllo.setSessione(sessione);
            controllo.setControlliService(controlliService);
            controllo.setAzienda(azienda);
            try {
                controllo.preEsecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
//                fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
            } catch (CalcoloException e) {
//                fail(e.getMessage());
            }
            try {
                controllo.esecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
            }
            try {
                controllo.postEsecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
            }
            Dmt_t_output_controlli out = controlliService
                    .getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
            System.out.println(out);
            assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
            assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili()), expAmmissibili == out.getCapiAmmissibili());
        } else {
            fail("Scarico dati non riuscito per CUAA -> " + cuaa);
        }
    }

    /**
     * Test su bovini
     * CUUA: BRBRRT55B21H355J
     * Anno: 2018
     * Codice premio: 313
     * Capi richiesi: 3
     * Capi ammissibili: 3
     */
    @Test
    public void TestClcInt313Mis4() {
        String cuaa = "BRCCNZ74H41G674S";
        String cPremio = "313";
        int anno = 2018;
        int expRichiesti = 20;
        int expAmmissibili = 20;
        Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
        azienda.setAnnoCampagna(anno);
        azienda.setCodicePremio(cPremio);
        azienda.setCuaa(cuaa);
        if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
            Controllo controllo = (Controllo) applicationContext.getBean("ClcInt313Mis4");
            controllo.setSessione(sessione);
            controllo.setControlliService(controlliService);
            controllo.setAzienda(azienda);
            try {
                controllo.preEsecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
//                fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
            } catch (CalcoloException e) {
//                fail(e.getMessage());
            }
            try {
                controllo.esecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
            }
            try {
                controllo.postEsecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
            }
            Dmt_t_output_controlli out = controlliService
                    .getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
            System.out.println(out);
            assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
            assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili()), expAmmissibili == out.getCapiAmmissibili());
        } else {
            fail("Scarico dati non riuscito per CUAA -> " + cuaa);
        }
    }


    /**
     * Test su bovini
     * CUUA: BNDLNZ85S06L304Y
     * Anno: 2018
     * Codice premio: 315
     * Capi richiesi: 10
     * Capi ammissibili: 9
     */
    @Test
    public void TestClcInt315Mis5() {
        String cuaa = "BNDLNZ85S06L304Y";
        String cPremio = "315";
        int anno = 2018;
        int expRichiesti = 10;
        int expAmmissibili = 9;
        Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
        azienda.setAnnoCampagna(anno);
        azienda.setCodicePremio(cPremio);
        azienda.setCuaa(cuaa);
        if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
            Controllo controllo = (Controllo) applicationContext.getBean("ClcInt315Mis5");
            controllo.setSessione(sessione);
            controllo.setControlliService(controlliService);
            controllo.setAzienda(azienda);
            try {
                controllo.preEsecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
//                fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
            } catch (CalcoloException e) {
            }
            try {
                controllo.esecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
            }
            try {
                controllo.postEsecuzione();
            } catch (ControlloException e) {
                e.printStackTrace();
            }
            Dmt_t_output_controlli out = controlliService
                    .getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
            System.out.println(out);
            assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
            assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili()), expAmmissibili == out.getCapiAmmissibili());
        } else {
            fail("Scarico dati non riuscito per CUAA -> " + cuaa);
        }
    }


}
