package it.csi.demetra.demetraws.zoo.calcoli;

import it.csi.demetra.demetraws.zoo.calcoli.entity.CalcoloAgnelleDaRimontaPremioIn;
import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9902;
import it.csi.demetra.demetraws.zoo.calcoli.entity.Ref;
import it.csi.demetra.demetraws.zoo.interfaces.RefInterface;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.services.AziendaService;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_AgnelleRimonta_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_DsUBA_censimenti_allevamenti_ovini_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_Tws_bdn_du_capi_ovicaprini_services;
import it.csi.demetra.demetraws.zoo.shared.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Service
public class CtlAgnelleDaRimonta extends Ref implements RefInterface<CapiControllati9902>, Calcolo {

    public final static String ESITO_OK = "OK";
    public final static String ESITO_KO = "KO";
    public final static List<String> codiciPremio = Arrays.asList(Constants.PREMIO_320);
    private static final String LIVELLO_SCRAPIE_L1 = "L1";
    @Autowired
    Dmt_t_Tws_bdn_du_capi_ovicaprini_services bdnCapiOvicapriniService;
    @Autowired
    AziendaService aziendaService;
    @Autowired
    Dmt_t_AgnelleRimonta_services agnelleRimontaService;
    @Autowired
    Dmt_t_DsUBA_censimenti_allevamenti_ovini_services ubaCensimentiOviniService;
    private CapiControllati9902 capiControllati9902;
    private CalcoloAgnelleDaRimontaPremioIn calcoloAgnelleDaRimontaIn;
    private StringBuilder errorMessage;

    private boolean isNotNull(CalcoloAgnelleDaRimontaPremioIn x) {
        boolean res = x != null;
        if (!res) {
            if (1 == 1)
                System.out.println("NULL REFERENCE");
            errorMessage.append("input CalcoloAgnelleDaRimontaPremioIn is null");
        }

        return res;
    }

    //    private Predicate<CalcoloAgnelleDaRimontaPremioIn> isNotNull = x -> {
//        boolean res = x != null;
//        if (!res) {
//            System.out.println("null reference");
//            errorMessage.append("input CalcoloAgnelleDaRimontaPremioIn is null");
//        }
//
//        return res;
//    };
    private boolean hasLivelloScrapie(CalcoloAgnelleDaRimontaPremioIn x) {
        boolean res = x.getUbaOviniCensimento() != null && x.getUbaOviniCensimento().getCodQualificaScrapie() != null;
        if (!res) {
            System.out.println("livello scrapie non presente");
            errorMessage.append("livello scrapie non presente");
        }

        return res;
    }

    //    private Predicate<CalcoloAgnelleDaRimontaPremioIn> hasLivelloScrapie = x -> {
//        boolean res = x.getUbaOviniCensimento() != null && x.getUbaOviniCensimento().getCodQualificaScrapie() != null;
//        if (!res) {
//            System.out.println("livello scrapie non presente");
//            errorMessage.append("livello scrapie non presente");
//        }
//
//        return res;
//    };
    private boolean hasQdrCalcolabile(CalcoloAgnelleDaRimontaPremioIn x) {
        boolean res = x.getUbaOviniCensimento() != null || x.getBdnOviniRegistroStallaList() != null;
        if (!res) {
            if (1 == 1)
                System.out.println("QUOTA DA RIMONTA NON CALCOLABILE");
            errorMessage.append("quota da rimonta non calcolabile");
        }
        return res;
    }
//    private Predicate<CalcoloAgnelleDaRimontaPremioIn> hasQdrCalcolabile = x -> {
//        boolean res = x.getUbaOviniCensimento() != null || x.getBdnOviniRegistroStallaList() != null;
//        if (!res) {
//            System.out.println("quota da rimonta non calcolabile");
//            errorMessage.append("quota da rimonta non calcolabile");
//        }
//        return res;
//    };

    public void init(Long idSessione, String codIntervento, Long annoCampagna, String cuaa) {
        setIdSessione(idSessione);
        setCodIntrervento(codIntervento);
        setAnnoCampagna(annoCampagna);
        setCuaa(cuaa);
    }

    /**
     * Il metodo ritorna un oggetto contenente: la quota dei capi ammessi a premio, un campo booleano esito che indica
     * se il calcolo è andato a buon fine, ed una stringa motivazioneEsitoCalcolo che contiene le motivazioni dell'esito del calcolo.
     *
     * @return capiControllati9902 - istanza di tipo @see capiControllati9902
     * @throws CalcoloException - eccezione relativa al calcolo {@linkplain}
     */
    @Override
    public CapiControllati9902 calcolo() throws CalcoloException {
        if (1 == 1)
            System.out.println("CALCOLO - IN");

        if (hasValidFields()) {
            preEsecuzione();
            esecuzione();
            postEsecuzione();
        } else {
            System.out.println("ERRORE CALCOLO - CAMPI OBBLIGATORI NON VALORIZZATI");
            throw new RuntimeException("calcolo - Campi obbligatori non valorizzati");
        }

        if (1 == 1)
            System.out.println("CALCOLO - OUT");
        return capiControllati9902;
    }

    @Override
    public List<CapiControllati9902> calcoloMassivo() throws CalcoloException {
        if (1 == 1)
            System.out.println("CALCOLO MASSIVO - IN");
        List<CapiControllati9902> capiControllati9902List = new ArrayList<CapiControllati9902>();
        if (hasValidCalcoloFields()) {
            Integer currentYearAnnoCampagna = LocalDate.now().getYear();
            List<Rpu_V_pratica_zoote> aziende = aziendaService.getByCodiciPremioAndAnnoCampagna(codiciPremio, currentYearAnnoCampagna);

            for (Rpu_V_pratica_zoote azienda : aziende) {
                setCuaa(azienda.getCuaa());
                setAnnoCampagna(Long.valueOf(azienda.getAnnoCampagna()));
                setCodIntrervento(azienda.getCodiceMisura());
                try {
                    preEsecuzione();
                    esecuzione();
                    postEsecuzione();
                    capiControllati9902List.add(capiControllati9902);

                } catch (CalcoloException ex) {
                    System.out.println("CALCOLO MASSIVO - " + ex.getMessage());
                }

            }
        } else {
            throw new RuntimeException("calcoloMassivo - Campi obbligatori non valorizzati");
        }

        if (1 == 1)
            System.out.println("CALCOLO - OUT");
        return capiControllati9902List;
    }

    @Override
    public void preEsecuzione() throws CalcoloException {
        System.out.println("preEsecuzione - IN");

        if (hasValidFields()) {
            if (1 == 1) {
                System.out.println("ID_SESSIONE: " + this.getIdSessione());
                System.out.println("CUAA: " + this.getCuaa());
                System.out.println("ANNO_CAMPAGNA: " + this.getAnnoCampagna());
                System.out.println("CODICE_INTERVENTO: " + this.getCodIntrervento());
            }
        }

        errorMessage = new StringBuilder();

        // Inizializzo la variabile d'istanza output del calcolo
        capiControllati9902 = new CapiControllati9902();

        // Inizializzo la variabile d'istanza input del calcolo
        calcoloAgnelleDaRimontaIn = getCalcoloAgnelleDaRimontaIn(this.getIdSessione(), this.getCuaa());

        boolean applicabile = isNotNull(calcoloAgnelleDaRimontaIn) && hasLivelloScrapie(calcoloAgnelleDaRimontaIn) && hasQdrCalcolabile(calcoloAgnelleDaRimontaIn);

        if (!applicabile) {
            if (1 == 1)
                System.out.println(
                        "PRE-ESECUZIONE - NON E' POSSIBILE EFFETTUARE IL CALCOLO, CONDIZIONI PRELIMINARI NON SODDISFATTE. SALVO IL RISULTATO SUL DB.");
            capiControllati9902 = new CapiControllati9902(this.getIdSessione(), this.getCuaa(), false, errorMessage.toString(), new Double(0), this.getAnnoCampagna().intValue(), this.getCodIntrervento());

            postEsecuzione();
            System.out.println("NON E' POSSIBILE EFFETTUARE IL CALCOLO PER ID_SESSIONE: " + this.getIdSessione() + " E CUAA: " + this.getCuaa());
            throw new CalcoloException(
                    "Non è possibile effettuare il calcolo per idSessione " + this.getIdSessione() + " e cuaa " + this.getCuaa());
        }
        if (1 == 1)
            System.out.println("PRE-ESECUZIONE- OUT");
    }

    @Override
    public void esecuzione() throws CalcoloException {
        if (1 == 1)
            System.out.println("ESECUZIONE IN");
        try {
            StringBuilder motivazioniSb = new StringBuilder();

            Double quotaDaRimonta = getQuotaDaRimonta(calcoloAgnelleDaRimontaIn);
            Double quotaCapiPremioRichiesti = calcoloAgnelleDaRimontaIn.getQuotaCapiPremioRichiesti();

            String livelloScrapie = getLivelloScrapie();

            Double capiPagabili = null;
            if (quotaCapiPremioRichiesti > quotaDaRimonta) {
                capiPagabili = quotaDaRimonta * 20 / 100;
                motivazioniSb.append("quotaCapiPremioRichiesti (" + quotaCapiPremioRichiesti + ") > quotaDaRimonta ("
                        + quotaDaRimonta + ")" + " : si applica il 20% della qdr.\n");
            } else {
                capiPagabili = quotaDaRimonta;
                motivazioniSb.append("quotaCapiPremioRichiesti (" + quotaCapiPremioRichiesti + ") <= quotaDaRimonta ("
                        + quotaDaRimonta + ")" + " : si utilizza la quotaCapiPremioRichiesti.\n");
            }

            Double quotaCapiPremioAmmessi = null;
            if (LIVELLO_SCRAPIE_L1.equals(livelloScrapie)) {
                quotaCapiPremioAmmessi = capiPagabili - (capiPagabili * 35 / 100);
                motivazioniSb.append("quotaCapiPremioAmmessi (" + quotaCapiPremioAmmessi + ")  : risanamento scrapie raggiunto, si applica riduzione del 35%.\n");

            } else {
                quotaCapiPremioAmmessi = capiPagabili - (capiPagabili * 75 / 100);
                motivazioniSb.append("quotaCapiPremioAmmessi (" + quotaCapiPremioAmmessi + ")  : risanamento scrapie non raggiunto, si applica riduzione del 75%.\n");
            }


            capiControllati9902 = new CapiControllati9902(calcoloAgnelleDaRimontaIn.getIdSessione(), calcoloAgnelleDaRimontaIn.getCuaa(),
                    true, motivazioniSb.toString(), quotaCapiPremioAmmessi, this.getAnnoCampagna().intValue(), this.getCodIntrervento());

        } catch (Exception ex) {
            System.out.println("ESECUZIONE: " + ex.getMessage());
            capiControllati9902 = new CapiControllati9902(this.getIdSessione(), this.getCuaa(), false, errorMessage.toString(), new Double(0), this.getAnnoCampagna().intValue(), this.getCodIntrervento());

        }
        if (1 == 1)
            System.out.println("ESECUZIONE - OUT");
    }

    @Override
    public void postEsecuzione() throws CalcoloException {
        if (1 == 1)
            System.out.println("POST-ESECUZIONE - IN");

        Dmt_t_AgnelleRimonta agnelleRimonta = new Dmt_t_AgnelleRimonta();

        Dmt_t_sessione sessione = new Dmt_t_sessione();

        sessione.setIdSessione(capiControllati9902.getIdSessione());

        agnelleRimonta.setIdSessione(sessione);
        agnelleRimonta.setEsito(capiControllati9902.isEsito() ? ESITO_OK : ESITO_KO);
        agnelleRimonta.setCuaa(capiControllati9902.getCuaa());
        agnelleRimonta.setMotivazioni(capiControllati9902.getMotivazioni());
        agnelleRimonta.setQuotaCapiPremio(capiControllati9902.getQuotaCapiPremio());
        agnelleRimonta.setAnnoCampagna(capiControllati9902.getAnnoCampagna());
        agnelleRimonta.setCodiceIntervento(capiControllati9902.getCodiceIntervento());

        agnelleRimontaService.save(agnelleRimonta);

        if (1 == 1)
            System.out.println("POST-ESECUZIONE - OUT");

    }

    private Double getQuotaDaRimonta(CalcoloAgnelleDaRimontaPremioIn calcoloAgnelleDaRimontaIn) {
        Double quotaDaRimonta = null;
        if (calcoloAgnelleDaRimontaIn.getUbaOviniCensimento() != null
                && calcoloAgnelleDaRimontaIn.getUbaOviniCensimento().getoCapiTot() != null) {
            quotaDaRimonta = calcoloAgnelleDaRimontaIn.getUbaOviniCensimento().getoCapiTot().doubleValue();
        } else {
            quotaDaRimonta = new Double(calcoloAgnelleDaRimontaIn.getBdnOviniRegistroStallaList().size());
        }

        return quotaDaRimonta;
    }

    private String getLivelloScrapie() {
        return calcoloAgnelleDaRimontaIn.getUbaOviniCensimento().getCodQualificaScrapie();

    }

    private CalcoloAgnelleDaRimontaPremioIn getCalcoloAgnelleDaRimontaIn(Long idSessione, String cuaa) {
        CalcoloAgnelleDaRimontaPremioIn calcoloAgnelleDaRimontaPremioIn = null;

        List<Dmt_t_Tws_bdn_du_capi_ovicaprini> registroStalla = bdnCapiOvicapriniService.getCapiOviByIdSessioneCuaaCodInt(idSessione, cuaa, this.getCodIntrervento());

        // Verificare unicità del censimento data una sessione e il codice azienda
        List<Dmt_t_DsUBA_censimenti_allevamenti_ovini> censimento = ubaCensimentiOviniService.getCensimOviniByIdSessioneAndCodFiscaleDete(idSessione, cuaa);

        if (censimento != null && registroStalla != null) {
            // Verificare corretta valorizzazione dei campi
            calcoloAgnelleDaRimontaPremioIn = new CalcoloAgnelleDaRimontaPremioIn(idSessione, cuaa, registroStalla.size(), censimento != null && !censimento.isEmpty() ? censimento.get(0) : null, registroStalla);


//        	            calcoloAgnelleDaRimontaPremioIn = CalcoloAgnelleDaRimontaPremioIn.builder().idSessione(idSessione)
//                    .bdnOviniRegistroStallaList(registroStalla).cuaa(cuaa)
//                    .quotaCapiPremioRichiesti(registroStalla.size())
//                    .ubaOviniCensimento(censimento.get(0)).build();
        }

        return calcoloAgnelleDaRimontaPremioIn;

    }

    private boolean hasValidCalcoloFields() {
        return this.getIdSessione() != null;

    }

    private boolean hasValidFields(Long idSessione, String codIntervento, Long annoCampagna, String cuaa) {
        boolean validFields = idSessione != null && codIntervento != null && !"".equals(codIntervento) && annoCampagna != null && cuaa != null && !"".equals(cuaa);

        if (validFields)
            return validFields;
        else
            throw new RuntimeException("CtlAgnelleDaRimonta - campi obbligatori non valorizzati");
    }

    private boolean hasValidFields() {
        return hasValidFields(this.getIdSessione(), this.getCodIntrervento(), this.getAnnoCampagna(), this.getCuaa());
    }

    public CapiControllati9902 getCapiControllati9902() {
        return capiControllati9902;
    }

    public void setCapiControllati9902(CapiControllati9902 capiControllati9902) {
        this.capiControllati9902 = capiControllati9902;
    }

    public CalcoloAgnelleDaRimontaPremioIn getCalcoloAgnelleDaRimontaIn() {
        return calcoloAgnelleDaRimontaIn;
    }

    public void setCalcoloAgnelleDaRimontaIn(CalcoloAgnelleDaRimontaPremioIn calcoloAgnelleDaRimontaIn) {
        this.calcoloAgnelleDaRimontaIn = calcoloAgnelleDaRimontaIn;
    }


}
