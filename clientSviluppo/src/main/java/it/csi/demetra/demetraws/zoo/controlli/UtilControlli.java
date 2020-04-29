package it.csi.demetra.demetraws.zoo.controlli;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;

import java.util.Date;
import java.util.List;

public class UtilControlli {

    public static Date getVitelloGiovane(Dmt_t_Tws_bdn_du_capi_bovini b, List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli) {
        Date dataGiovane = null;
        for (Dmt_t_Tws_bdn_du_capi_bovini b2 : listVitelli)
            if (null != b2.getDtNascitaVitello())
                if (null == dataGiovane)
                    dataGiovane = b2.getDtNascitaVitello();
                else if (b2.getDtNascitaVitello().before(dataGiovane))
                    dataGiovane = b.getDtNascitaVitello();

        return dataGiovane;
    }
}
