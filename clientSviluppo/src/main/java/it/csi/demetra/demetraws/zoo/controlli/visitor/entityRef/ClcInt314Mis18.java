package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9901;
import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9903;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import org.springframework.stereotype.Component;

@Component("ref02_005")
public class ClcInt314Mis18 extends Controllo {
    //Lista di capi da recuperare dalla BDN
//	private List<> listaCapi;

    public void controlliPreAmmissibilita() throws ControlloException {
        // Bisogna ancora definire i parametri da passare
        // Inizializzazione
//		CtlVerificaRegistrazioneCapi ref9901 = new CtlVerificaRegistrazioneCapi();
//		CtlUbaMinime ref9903 = new CtlUbaMinime();

//		// Calcolo delle tempistiche di registrazione
//		CapiControllati9901 capiControllati9901 = ref9901.calcolo();
//		// Calcolo dei controlli di ammissibilità trasversali
//		CapiControllati9903 capiControllati9903 = ref9903.calcolo();

        //Esito del calcolo sulle tempistiche di registrazione
        boolean ctrlTempisticaReg = CapiControllati9901.getEsito();
        //Esito del calcolo sui controlli di ammissibilità trasversali
        boolean ctrlAmmissTrasv = CapiControllati9903.getEsito();

        if (ctrlAmmissTrasv && ctrlTempisticaReg) {
            //se entrambi i calcoli sono finiti senza errori

        } else if (!ctrlTempisticaReg) {
            //se ci sono stati errori nel calcolo sulle tempistiche di registrazione
        } else if (!ctrlTempisticaReg) {
            //se ci sono stati errori nel calcolo sui controlli di ammissibilità trasversali
        }

    }


    @Override
    public void preEsecuzione() throws ControlloException {

    }

    @Override
    public void esecuzione() throws ControlloException {

    }

    @Override
    public void postEsecuzione() throws ControlloException {

    }
}
