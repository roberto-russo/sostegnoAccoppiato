package it.csi.demetra.demetraws.zoo.controlli;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import org.springframework.transaction.annotation.Transactional;

public interface ControlliFramework {
    public void handleControlloCUUA(Rpu_V_pratica_zoote azienda, Dmt_t_subentro_zoo subentro, Dmt_t_sessione sessione) throws ControlloException, CalcoloException;


    public Boolean scaricoDati(Rpu_V_pratica_zoote azienda, Dmt_t_subentro_zoo subentro, Dmt_t_sessione sessione, Integer annoCampagna);

    void duplicaSessioneByCuaa(Rpu_V_pratica_zoote s, Dmt_t_sessione sessioneOld, Dmt_t_sessione sessioneNew);
}
