package it.csi.demetra.demetraws.zoo.controlli;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;

import java.util.List;

public interface ControlliFramework {
    void handleControlloCUUA(List<Rpu_V_pratica_zoote> listAziende, String cuaa, Integer annoCampagna, Dmt_t_subentro_zoo subentro, Dmt_t_sessione sessione) throws ControlloException, CalcoloException;


    Boolean scaricoDati(Rpu_V_pratica_zoote azienda, Dmt_t_subentro_zoo subentro, Dmt_t_sessione sessione, Integer annoCampagna);

    void duplicaSessioneByCuaa(Rpu_V_pratica_zoote s, Dmt_t_sessione sessioneOld, Dmt_t_sessione sessioneNew);
}
