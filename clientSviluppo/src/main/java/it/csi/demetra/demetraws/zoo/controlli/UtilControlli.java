package it.csi.demetra.demetraws.zoo.controlli;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;

import java.math.BigDecimal;
import java.util.ArrayList;
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
     * @param b istanza relativa al capo bovino di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
     * @param sessione istanza relativa all'identificazione della sessione di tipo @see Dmt_t_sessione
     * @param motivazione motivazione dell'esclusione del capo dal premio di tipo String
     * @param calcolo calcolo per cui il capo bovino è stato escluso
     * @return istanza di tipo @see Dmt_t_output_esclusi
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
     * @param b           istanza relativa al capo bovino di tipo @see Dmt_t_Tws_bdn_du_capi_bovini 
     * @param listVitelli lista di istanze relative ai vitelli di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
     * @return istanza di tipo Date relativa alla data del vitello più giovane
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
     * @param b           istanza relativa al capo bovino di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
     * @param listVitelli lista di istanze relative ai vitelli di tipo @see Dmt_t_Tws_bdn_du_capi_bovini
     * @return valore booleano che identifica se il capo animale è in detenzione
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
    
    public static List<Dmt_t_clsCapoMacellato> filtraAnimaleMacellato(List<Dmt_t_premio_capi> animaliAmmessi, List<Dmt_t_clsCapoMacellato> animaliDaFiltrare) {
    	
    	List<Dmt_t_clsCapoMacellato> animaliFiltrati = new ArrayList<Dmt_t_clsCapoMacellato>();
    	
    	if(animaliFiltrati != null || !animaliFiltrati.isEmpty())
    		animaliFiltrati.clear();
    	
    	for(Dmt_t_clsCapoMacellato capoMac : animaliDaFiltrare)
    		if(contains(animaliAmmessi, capoMac))
    			animaliFiltrati.add(capoMac);
    	
    	return animaliFiltrati;
    }
    
    public static List<Dmt_t_Tws_bdn_du_capi_bovini> filtraAnimaleBovino(List<Dmt_t_premio_capi> animaliAmmessi, List<Dmt_t_Tws_bdn_du_capi_bovini> animaliDaFiltrare) {
    	
    	List<Dmt_t_Tws_bdn_du_capi_bovini> animaliFiltrati = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
    	
    	if(animaliFiltrati != null || !animaliFiltrati.isEmpty())
    		animaliFiltrati.clear();
    	
    	for(Dmt_t_Tws_bdn_du_capi_bovini capoBov : animaliDaFiltrare)
    		if(contains(animaliAmmessi, capoBov))
    			animaliFiltrati.add(capoBov);
    	
    	return animaliFiltrati;
    }
    
  public static List<Dmt_t_Tws_bdn_du_capi_ovicaprini> filtraAnimaleOvicaprino(List<Dmt_t_premio_capi> animaliAmmessi, List<Dmt_t_Tws_bdn_du_capi_ovicaprini> animaliDaFiltrare) {
    	
    	List<Dmt_t_Tws_bdn_du_capi_ovicaprini> animaliFiltrati = new ArrayList<Dmt_t_Tws_bdn_du_capi_ovicaprini>();
    	
    	if(animaliFiltrati != null || !animaliFiltrati.isEmpty())
    		animaliFiltrati.clear();
    	
    	for(Dmt_t_Tws_bdn_du_capi_ovicaprini capoOvi : animaliDaFiltrare)
    		if(contains(animaliAmmessi, capoOvi))
    			animaliFiltrati.add(capoOvi);
    	
    	return animaliFiltrati;
    }
    
    private static Boolean contains(List<Dmt_t_premio_capi> animaliAmmessi, Dmt_t_clsCapoMacellato animaleDaControllare) {
    	
    	for(Dmt_t_premio_capi animaleAmmesso : animaliAmmessi)
    		if(animaleAmmesso.getIdCapo().equals(animaleDaControllare.getCapoId()))
    				return true;
    		
    	return false;
    }
    
  private static Boolean contains(List<Dmt_t_premio_capi> animaliAmmessi, Dmt_t_Tws_bdn_du_capi_ovicaprini animaleDaControllare) {
    	
    	for(Dmt_t_premio_capi animaleAmmesso : animaliAmmessi)
    		if(animaleAmmesso.getIdCapo().equals(animaleDaControllare.getCapoId()))
    				return true;
    		
    	return false;
    }
    
private static Boolean contains(List<Dmt_t_premio_capi> animaliAmmessi, Dmt_t_Tws_bdn_du_capi_bovini animaleDaControllare) {
    	
    	for(Dmt_t_premio_capi animaleAmmesso : animaliAmmessi)
    		if(animaleAmmesso.getIdCapo().equals(animaleDaControllare.getCapoId()))
    				return true;
    		
    	return false;
    }
}
