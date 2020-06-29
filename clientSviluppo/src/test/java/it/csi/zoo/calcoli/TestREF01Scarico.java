package it.csi.zoo.calcoli;

import it.csi.demetra.demetraws.zoo.BdnWsManagerImpl;
import it.csi.demetra.demetraws.zoo.ZooApplication;
import it.csi.demetra.demetraws.zoo.controlli.ControlliFramework;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.services.AziendaService;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_sessione_services;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZooApplication.class)
public class TestREF01Scarico {

    @Autowired
    private Dmt_t_sessione_services sessioneService;

    @Autowired
    private ControlliFramework controlliFramework;

    @Autowired
    private AziendaService aziendaService;

    @Autowired
    private BdnWsManagerImpl bdnImpl;

    @Autowired
    private ControlliService controlliService;

    @Before
    public void init() {

    }

    @Test
    public void testREF01() {
        Dmt_t_sessione sessione = sessioneService.saveSession(new Dmt_t_sessione());
        bdnImpl.getElencoCapiPremio("313", "BBNNNN60L11D314D", 2019, sessione);
        bdnImpl.getElencoCapiPremio("317", "BBNNNN60L11D314D", 2019, sessione);
        bdnImpl.getElencoCapiPremio("320", "BCCMTT82H02F965K", 2019, sessione);

        List<Dmt_t_Tws_bdn_du_capi_bovini> listBovini_test1 = controlliService.getAllBoviniSessioneCuua(sessione,"BBNNNN60L11D314D","313");
        List<Dmt_t_clsCapoMacellato> listBovini_test2 = controlliService.getAllMacellatiSessioneCuua(sessione,"BBNNNN60L11D314D","317");
        List<Dmt_t_Tws_bdn_du_capi_ovicaprini> listBovini_test3 = controlliService.getOvicapriniBySessioneCuaaCodIntervento(sessione.getIdSessione(),"BCCMTT82H02F965K","320");

        assertTrue("CUAA BBNNNN60L11D314D 313 BOVINI NUMERO ERRATO", listBovini_test1!=null && listBovini_test1.size() == 35);
        assertTrue("CUAA BBNNNN60L11D314D 317 CAPO MACELLATO NUMERO ERRATO", listBovini_test2!=null && listBovini_test2.size() == 19);
        assertTrue("CUAA BCCMTT82H02F965K 320 OVICAPRINI NUMERO ERRATO", listBovini_test3!=null && listBovini_test3.size() == 53);
    }

}
