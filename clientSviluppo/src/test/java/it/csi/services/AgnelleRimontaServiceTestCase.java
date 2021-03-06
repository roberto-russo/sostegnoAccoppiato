package it.csi.services;

import it.csi.demetra.demetraws.zoo.ZooApplication;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_AgnelleRimonta;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_AgnelleRimonta_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_sessione_services;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZooApplication.class)
public class AgnelleRimontaServiceTestCase {

    @Autowired
    Dmt_t_AgnelleRimonta_services agnelleRimontaServices;

    @Autowired
    Dmt_t_sessione_services sessioneService;

    @Test
    public void saveTest() {
        Dmt_t_AgnelleRimonta agnelleRimonta = new Dmt_t_AgnelleRimonta();

        Long idSessione = 1L;
        String cuaa = "SPSRVH91A23G383R";
        Integer annoCampagna = 2020;
        String codiceIntervento = "320";


        Dmt_t_sessione sessione = null;

        try {
            sessione = sessioneService.getById(idSessione);

        } catch (Exception ex) {
            fail("caught exception while retrieving sessione");
        }

        assertNotNull("sessione is null", sessione);

        agnelleRimonta.setCuaa(cuaa);
        agnelleRimonta.setEsito("OK");
        agnelleRimonta.setMotivazioni("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vel fringilla urna. Phasellus eget tortor elit. Morbi dictum quam mollis, pharetra augue sit amet, lacinia lectus. Sed placerat massa arcu, eu maximus orci mollis sit amet. Quisque eget massa sit amet purus lobortis euismod. Praesent eleifend purus purus, vitae posuere metus aliquam a. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mauris erat, faucibus quis ante eget, aliquet faucibus mi. Donec lectus lectus, mollis quis dui sit amet, maximus feugiat sem. Praesent id justo vitae purus rhoncus dignissim. Donec eu vulputate orci, eget scelerisque libero");
        agnelleRimonta.setIdSessione(sessione);
        agnelleRimonta.setAnnoCampagna(annoCampagna);
        agnelleRimonta.setCodiceIntervento(codiceIntervento);
        agnelleRimonta.setQuotaCapiPremio(new Double(25));

        try {
            agnelleRimontaServices.save(agnelleRimonta);

        } catch (Exception ex) {
            fail("caught exception while saving ref9902 model");
        }


        try {
            Dmt_t_AgnelleRimonta model = Optional.of(agnelleRimontaServices.getByIdSessioneAndCuaa(idSessione, cuaa)).orElse(null).get(0);

            assertNotNull("model is null", model);

            assertTrue("cuaa mismatching", model.getCuaa().equals(agnelleRimonta.getCuaa()));

        } catch (Exception ex) {
            fail("caught exception while retrieving ref9902 model");
        }


    }

}

