package it.csi.demetra.demetraws.zoo.controlli;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Classe utilizzato per raggruppare metodi comuni a più contrlli
 */
public class UtilControlli {

    /**
     * Questo metodo genera l'oggetto 'escluso', che verrà successivamente salvato in db in modo tale da avere
     * uno storico dei capi non liquidabili per un controllo
     *
     * @param b
     * @param sessione
     * @param motivazione
     * @param calcolo
     * @return
     */
    public static Dmt_t_output_esclusi generaEscluso(Dmt_t_Tws_bdn_du_capi_bovini b, Dmt_t_sessione sessione, String motivazione, String calcolo) {
        Dmt_t_output_esclusi escluso = new Dmt_t_output_esclusi();
        escluso.setCalcolo(calcolo);
        escluso.setCapoId(b.getCapoId());
        escluso.setMotivazioneEsclusione(motivazione);
        escluso.setIdSessione(sessione);

        return escluso;
    }

    /**
     * Metodo che restituisce la data di nascita del vitello più giovane nel caso in cui un bovino abbia partorito più
     * volte
     *
     * @param b
     * @param listVitelli
     * @return
     */
    public static Date getVitelloGiovane(Dmt_t_Tws_bdn_du_capi_bovini b, List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli) {
        Date dataGiovane = b.getDtNascitaVitello();
        for (Dmt_t_Tws_bdn_du_capi_bovini b2 : listVitelli)
            if (null != b2.getDtNascitaVitello())
                if (null == dataGiovane)
                    dataGiovane = b2.getDtNascitaVitello();
                else if (b2.getDtNascitaVitello().before(dataGiovane))
                    dataGiovane = b2.getDtNascitaVitello();

        return dataGiovane;
    }

    /**
     * Controllo che il cuaa sia il detentore dell'allevamento al momento del parto
     * e Qualora la vacca abbia partorito più di una volta nel corso dell’anno presso
     * la stalla di diversi detentori susseguitisi nel tempo, il premio è erogato al
     * detentore presso il quale è nato il primo capo.
     *
     * @param b
     * @param listVitelli
     * @return
     */
    public static Boolean isDetentoreParto(Dmt_t_Tws_bdn_du_capi_bovini b, List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli) {
        Date dataGiovane = UtilControlli.getVitelloGiovane(b, listVitelli);
        return (b.getDtFineDetenzione().after(dataGiovane)
                && b.getDtInizioDetenzione().before(dataGiovane));
    }

    public static double mediaGeometrica(List<BigDecimal> valori) {
        double n = 0.00;
        double res = 1.00;
        for (BigDecimal v : valori) {
            n += 1.00;
            res = res * v.doubleValue();
        }
        return Math.pow(res, n);
    }

    public static double mediaAritmetica(List<BigDecimal> valori) {
        int n = 0;
        double res = 0.00;
        for (BigDecimal v : valori) {
            n++;
            res += v.doubleValue();
        }
        return res / n;
    }

    public static Integer convertCodiceMeseInt(String codiceMese) {
        switch (codiceMese) {
            case "GEN":
                return 1;

            case "FEB":
                return 2;

            case "MAR":
                return 3;

            case "APR":
                return 4;

            case "MAG":
                return 5;

            case "GIU":
                return 6;
            case "LUG":
                return 7;
            case "AGO":
                return 8;
            case "SET":
                return 9;
            case "OTT":
                return 10;
            case "NOV":
                return 11;
            case "DIC":
                return 12;
        }
        return 0;
    }
}
