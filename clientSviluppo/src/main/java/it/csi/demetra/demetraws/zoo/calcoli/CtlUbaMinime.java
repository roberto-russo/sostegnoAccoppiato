package it.csi.demetra.demetraws.zoo.calcoli;

import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9903;
import it.csi.demetra.demetraws.zoo.calcoli.entity.Capo9903;
import it.csi.demetra.demetraws.zoo.calcoli.entity.Ref;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.interfaces.RefInterface;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_AgnelleRimonta_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_ControlloUbaMinime_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_premio_capi_services;
import it.csi.demetra.demetraws.zoo.shared.Constants;
import it.csi.demetra.demetraws.zoo.util.LocalDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class CtlUbaMinime extends Ref implements RefInterface<ResultCtlUbaMinime>, Calcolo {


    private static final BigDecimal UBA_100 = new BigDecimal(1.0);

    private static final BigDecimal UBA_75 = new BigDecimal(0.75);

    private static final BigDecimal UBA_60 = new BigDecimal(0.6);

    private static final BigDecimal UBA_35 = new BigDecimal(0.35);

    private static final BigDecimal UBA_15 = new BigDecimal(0.15);

    private static final BigDecimal UBA = new BigDecimal(3.0);

    private BigDecimal ubaMinime = new BigDecimal(0.0);

    private Map<String, List<?>> listaCapi = null;

    @Autowired
    private Dmt_t_AgnelleRimonta_services capiOvicapriniService;

    @Autowired
    Dmt_t_premio_capi_services capiAmmessiServices;

    @Autowired
    Dmt_t_ControlloUbaMinime_services ref9903Services;

    Dmt_t_ControlloUbaMinime model = new Dmt_t_ControlloUbaMinime();

    Map<String, List<Dmt_t_premio_capi>> listaCapiResult = null;

    private static final List<String> PREMI = Arrays.asList(
			Constants.PREMIO_310, Constants.PREMIO_311, Constants.PREMIO_312, Constants.PREMIO_313,
			Constants.PREMIO_314, Constants.PREMIO_315, Constants.PREMIO_316, Constants.PREMIO_317,
			Constants.PREMIO_318, Constants.PREMIO_319, Constants.PREMIO_320, Constants.PREMIO_322);

    private static final List<String> PREMI_BOV_LATTE_CARNE = Arrays
            .asList(Constants.PREMIO_310, Constants.PREMIO_311, Constants.PREMIO_312,
					Constants.PREMIO_313, Constants.PREMIO_314, Constants.PREMIO_322);

    private static final List<String> PREMI_BOV_MACELLATI = Arrays.asList(Constants.PREMIO_315,
			Constants.PREMIO_316, Constants.PREMIO_317, Constants.PREMIO_318, Constants.PREMIO_319);

    private static final List<String> PREMI_OVICAPRINI_AGNELLE = Arrays.asList(Constants.PREMIO_320);

    private static final List<String> PREMI_CON_LIMITI = Arrays
            .asList(Constants.PREMIO_310, Constants.PREMIO_311, Constants.PREMIO_312,
					Constants.PREMIO_313, Constants.PREMIO_314, Constants.PREMIO_322);

    private CapiControllati9903 capiControllati = new CapiControllati9903();

    private boolean metodoEseguitoCorrettamente;

    private boolean initEseguitaCorrettamente;

    private boolean salvataggioEseguitoCorrettamente = true;

    private Double quotaCapiPremio;

    private boolean response;

    private Dmt_t_sessione sessione;

    private ResultCtlUbaMinime resultCtlUbaMinime = new ResultCtlUbaMinime();

    private boolean preesecuzioneEseguitaCorrettamente = true;

    public void init(Map<String, List<?>> capiTo9903, Integer annoCampagna, String cuaa, Dmt_t_sessione sessione) {
        if (1==1)
            System.out.println("INIZIO CONTROLLO UBA MINIME");
        listaCapiResult = new HashMap<String, List<Dmt_t_premio_capi>>();
        ubaMinime = BigDecimal.ZERO;
        if (capiTo9903 != null && sessione != null && annoCampagna != null && cuaa != null) {
            if (!capiTo9903.isEmpty()) {
                this.listaCapi = capiTo9903;
                setAnnoCampagna(Long.valueOf(annoCampagna));
                setCuaa(cuaa);
                setIdSessione(sessione.getIdSessione());
                this.sessione = sessione;
                initEseguitaCorrettamente = true;
            } else {
                initEseguitaCorrettamente = false;
            }

        } else {
            initEseguitaCorrettamente = false;
        }

        if (1==1)
            System.out.println("FINE CONTROLLO UBA MINIME");
    }

    /**
     * <h1>CONTROLLI AMMISSIBILITÀ TRASVERSALI</h1> <br>
     * Il Calcolo esegue:<br>
     *
     * <b>preEsecuzione():</b> in cui si associa il corretto tipo di lista passata
     * dall'utente<br>
     * <b>esecuzione():</b> in cui si esegue il calcolo effettivo<br>
     * <b>postEsecuzione():</b> in cui si controlla l'esito del calcolo e lo si
     * salva su DB<br>
     * <br>
     * <p>
     * Il metodo ritorna un oggetto contenente due booleani:<br>
     * <b>response:</b><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;true uba raggiunte<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;false uba non raggiunte<br>
     * <b>errors:</b><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;true se ci sono stati errori<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;false altrimenti<br>
     * <br>
     *
     * @return istanza di tipo {@link ResultCtlUbaMinime}
     * @throws CalcoloException eccezione riferita al calcolo
     *                          {@link CalcoloException}
     */
    @Override
    public ResultCtlUbaMinime calcolo() throws CalcoloException {
        if (1==1)
            System.out.println("CALCOLO REF99.03, INIZIO CALCOLO");

        try {
            if (initEseguitaCorrettamente) {
                preEsecuzione();
                if (preesecuzioneEseguitaCorrettamente) {
                    esecuzione();
                }
            }
            postEsecuzione();
        } catch (CalcoloException e) {

            e.printStackTrace();
            System.out.println("ERRORE CALCOLO REF99.03, ");

        }
        resultCtlUbaMinime.setListaCapi(listaCapiResult);
        resultCtlUbaMinime.setResult(response);
        resultCtlUbaMinime.setErrors(!initEseguitaCorrettamente || !preesecuzioneEseguitaCorrettamente
                || !metodoEseguitoCorrettamente || !salvataggioEseguitoCorrettamente);
        return resultCtlUbaMinime;

    }

    /**
     * CALCOLO UBA Si calcolano le UBA secondo le disposizioni del D.A. Dopo aver
     * recuperato i dati della BDN Si calcolano le uba minime
     * <p>
     * Se l'esecuzione non presenta problemi: return true Se ci sono stati errori
     * durante l'esecuzione: return false
     *
     * @return true/false
     */
    private boolean calcoloUBA() {
        if (1==1)
            System.out.println("CALCOLO REF99.03, INIZIO CALCOLO UBA");

        try {
            Set<Long> capiBovini = new HashSet<>();
            Set<Long> capiOvicaprini = new HashSet<>();
            Set<Long> capiMacellati = new HashSet<>();
            for (String cp : listaCapi.keySet()) {
                if (cp != null && PREMI.contains(cp)) {
                    if (PREMI_BOV_LATTE_CARNE.contains(cp)) {
                        for (Dmt_t_Tws_bdn_du_capi_bovini x : ((List<Dmt_t_Tws_bdn_du_capi_bovini>) listaCapi.get(cp)))
                            capiBovini.add(x.getCapoId());
                    } else if (PREMI_BOV_MACELLATI.contains(cp)) {
                        for (Dmt_t_clsCapoMacellato x : ((List<Dmt_t_clsCapoMacellato>) listaCapi.get(cp)))
                            capiMacellati.add(x.getCapoId());
                    } else if (PREMI_OVICAPRINI_AGNELLE.contains(cp)) {
                        for (Dmt_t_Tws_bdn_du_capi_ovicaprini x : ((List<Dmt_t_Tws_bdn_du_capi_ovicaprini>) listaCapi
                                .get(cp)))
                            capiOvicaprini.add(x.getCapoId());
                    }
                } else {
                    System.out.println("ERRORE REF99.03, ERRORE NEL CALCOLO UBA, IL CODICE INTERVENTO " + cp + " E' ERRATO.");
                    throw new CalcoloException("Errore nel Calcolo UBA : Il codice intervento " + cp + " è errato.");

                }

            }

            ubaMinime = (UBA_100.multiply(new BigDecimal(capiBovini.size())))
                    .add((UBA_60.multiply(new BigDecimal(capiMacellati.size())))
                            .add(UBA_15.multiply(new BigDecimal(capiOvicaprini.size()))));
//			ubaMinime = (UBA_100.multiply(new BigDecimal(capiBovini.size())) + (capiMacellati.size() * UBA_60.doubleValue())
//					+ (capiOvicaprini.size() * UBA_15.doubleValue());

            if (1==1)
                System.out.println("CALCOLO REF99.03, FINE CALCOLO UBA");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRORE CALCOLO REF99.03 ");
            return false;
        }

    }

    /**
     * Metodo preEsecuzione()
     * <p>
     * In questo metodo si associa la corretta tipologia di lista, in base al codice
     * intervento richiesto.
     */
    @Override
    public void preEsecuzione() throws CalcoloException {
        if (1==1)
            System.out.println("CALCOLO UBA MINIME, INIZIO PRE-ESECUZIONE");

        if (listaCapi != null && !listaCapi.isEmpty()) {
            for (String cp : listaCapi.keySet()) {
                System.out.println("\n\n\nHANDLING CP -> " + cp + "\n\n\n");

                listaCapiResult.put(cp, new ArrayList<Dmt_t_premio_capi>());
                if (cp != null && PREMI.contains(cp)) {
                    System.out.println("\n\n\nCP SIZE -> " + listaCapi.get(cp).size() + "\n\n\n");
                    if (PREMI_BOV_LATTE_CARNE.contains(cp)) {
                        if (PREMI_CON_LIMITI.contains(cp)) {
                            LocalDate oggi = LocalDate.now();
                            Period period;
                            if (listaCapi.get(cp) != null && !listaCapi.get(cp).isEmpty()) {
//								setListaCapi9903(listaCapi.get(cp));
                                for (Dmt_t_Tws_bdn_du_capi_bovini capo : ((List<Dmt_t_Tws_bdn_du_capi_bovini>) listaCapi
                                        .get(cp))) {
                                    System.out.println("\n\n HANDLING CAPO -> " + capo.getCapoId());
                                    LocalDate dataNascita;
                                    if (capo.getDataNascita() != null) {
                                        dataNascita = LocalDateConverter
                                                .convertToLocalDateViaInstant(capo.getDataNascita());
                                        period = Period.between(dataNascita, oggi);
                                        if ((period.getMonths() + period.getYears() * 12) < 20
                                                || period.getYears() > 18) {
                                            listaCapi.get(cp).remove(capo);
//											capo.setFlagCapoAmmesso("N");
                                            System.out.println("\n\n CAPO NO ETA' -> " + capo.getCapoId());
                                            Dmt_t_premio_capi tmp = inizializzaCapo(capo, "N",
                                                    "Il capo non ha un'età compresa tra 20 mesi e 18 anni");
                                            listaCapiResult.get(cp).add(tmp);
                                        } else {
                                            LocalDate dataNascitaVitello = LocalDateConverter
                                                    .convertToLocalDateViaInstant(capo.getVitelloDtComAutNascita());
                                            period = Period.between(dataNascitaVitello, oggi);
                                            // int giorniDiVita =
                                            // (period.getDays()+period.getMonths()*30+period.getYears()*365);
                                            long giorniDiVita = ChronoUnit.DAYS.between(dataNascitaVitello, oggi);
                                            if (giorniDiVita < 270) {
                                                listaCapi.get(cp).remove(capo);
//												capo.setFlagCapoAmmesso("N");

                                                System.out.println("\n\n CAPO NO 270 -> " + capo.getCapoId());
                                                Dmt_t_premio_capi tmp = inizializzaCapo(capo, "N",
                                                        "Il periodo minimo di 270 giorni di interparto non � stato rispettato");
                                                listaCapiResult.get(cp).add(tmp);
                                            } else {
                                                System.out.println("\n\n CAPO SI -> " + capo.getCapoId());
                                                Dmt_t_premio_capi tmp = inizializzaCapo(capo, "S",
                                                        "Il capo è stato ammesso a premio");

                                                listaCapiResult.get(cp).add(tmp);
                                            }
                                        }
                                    } else {
                                        preesecuzioneEseguitaCorrettamente = false;
                                        break;
                                    }
                                }
                            }

                        }
                        if (1==1)
                            System.out.println("CALCOLO UBA MINIME, FINE PRE-ESECUZIONE");

                    } else if (PREMI_BOV_MACELLATI.contains(cp)) {

                        for (Dmt_t_clsCapoMacellato capo : ((List<Dmt_t_clsCapoMacellato>) listaCapi.get(cp))) {
                            Dmt_t_premio_capi tmp = inizializzaCapoMacellato(capo, "S",
                                    "Capo macellato ammesso a premio");
                            listaCapiResult.get(cp).add(tmp);
                        }
                        if (1==1)
                            System.out.println("CALCOLO UBA MINIME, FINE PRE-ESECUZIONE");

                    } else if (PREMI_OVICAPRINI_AGNELLE.contains(cp)) {
                        this.quotaCapiPremio = capiOvicapriniService
                                .getQuotaCapiPremioByIdSessioneAndCuaa(getIdSessione(), getCuaa(), cp);
                        for (Dmt_t_Tws_bdn_du_capi_ovicaprini capo : ((List<Dmt_t_Tws_bdn_du_capi_ovicaprini>) listaCapi
                                .get(cp))) {
                            Dmt_t_premio_capi tmp = inizializzaCapoOvicaprino(capo, "S",
                                    "Capo ovicaprino ammesso a premio");
                            listaCapiResult.get(cp).add(tmp);
                        }

                        if (quotaCapiPremio == null) {

                            System.out.println("ERRORE CALCOLO UBA MINIME, ERRRORE PRE-ESECUZIONE: SESSIONE "
                                    + getIdSessione() + " CUAA " + getCuaa() + " QUOTA CAPI PREMIO = NULL.");
                            preesecuzioneEseguitaCorrettamente = false;

                        } else {
                            if (1==1)
                                System.out.println("CALCOLO UBA MINIME, FINE PRE-ESECUZIONE");
                        }

                    } else {

                        System.out.println(
                                "ERRORE CALCOLO UBA MINIME, ERRORE PRE-ESECUZIONE: IL TIPO DEGLI OGGETTI APPARTENENTI ALLA LISTA CAPI NON CORRISPONDE A QUELLI AMMISSIBILI.");
                        preesecuzioneEseguitaCorrettamente = false;

                    }
                } else {

                    System.out.println("ERRORE CALCOLO UBA MININE, ERRORE PRE-ESECUZIONE CODICE INTERVENTO ERRATO");
                    preesecuzioneEseguitaCorrettamente = false;

                }
            }
        } else {
            if (listaCapi == null) {

                System.out.println("ERRORE CALCOLO UBA MINIME, ERRORE PRE-ESECUZIONE PARAMETRO LISTA CAPI = NULL");
                preesecuzioneEseguitaCorrettamente = false;

            } else {

                System.out.println(
                        "ERRORE CALCOLO UBA MINIME, ERRORE PRE-ESECUZIONE LA LISTA DEI CAPI PASSATA PER IL CALCOLO UBA E' VUOTA.");
                preesecuzioneEseguitaCorrettamente = false;

            }
        }

    }

    @Override
    public void esecuzione() throws CalcoloException {
        metodoEseguitoCorrettamente = calcoloUBA();
    }

    @Override
    public void postEsecuzione() throws CalcoloException {
        // SALVATAGGIO DATI

        if (initEseguitaCorrettamente && preesecuzioneEseguitaCorrettamente && metodoEseguitoCorrettamente) {

            saveOnDB();
            if (1==1)
                System.out.println("CALCOLO REF99.03, FINE CALCOLO");

        } else {
            if (!initEseguitaCorrettamente) {
                System.out.println("ERRORE NELLA INIT DEL CALCOLO REF99.03: TUTTI I PARAMETRI DEVONO ESSERE VALORIZZATI");
            } else {
                if (!preesecuzioneEseguitaCorrettamente) {
                    System.out.println("ERRORE NELLA PRE-ESECUZIONE DEL CALCOLO REF99.03");
                } else {
                    if (!metodoEseguitoCorrettamente) {
                        System.out.println("ERRORE NEL CALCOLO DEL REF99.03, ERRORE CALCOLO UBA");
                    } else {
                        if (!salvataggioEseguitoCorrettamente) {
                            System.out.println("ERRORE CALCOLO REF99.03, ERRORE NEL SALVATAGGIO DATI");
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<ResultCtlUbaMinime> calcoloMassivo() throws CalcoloException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Il metodo setListaCapi9901() serve a inizializzare la lista di oggetti di
     * tipo Capo9901 Questa lista sarà utilizzata nell'oggetto di tipo
     * CapiControllati9901 necessaria al calcolo della tempistica di registrazione
     * dei capi.
     *
     * @param listaVacche
     */
    private void setListaCapi9903(List<Dmt_t_Tws_bdn_du_capi_bovini> listaVacche) {
        try {

            List<Capo9903> listaCapi9903 = new ArrayList<Capo9903>();

            for (Dmt_t_Tws_bdn_du_capi_bovini capo : listaVacche) {
                listaCapi9903.add(new Capo9903(capo));
            }

            capiControllati.setListaCapi9903(listaCapi9903);

            if (1==1)
                System.out.println("Fine Recupero Dati: setListaCapi9903() ");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRORE NEL SETLISTACAPI9903(): - ");
        }
    }

    /**
     * inizializzaCapoEscluso()
     * <p>
     * Serve ad inizializzare un oggetto di tipo Dmt_w_Tdu_premio_capi, così da
     * poter aggiungere il capo/vacca alla listaCapiAmmessi, che, tramite service,
     * sarà salvata su DB
     *
     * @param capoVacca
     * @param msg
     * @return capoTmp
     */
    private Dmt_t_premio_capi inizializzaCapo(Dmt_t_Tws_bdn_du_capi_bovini capoVacca, String ammissibile, String msg) {

        Dmt_t_premio_capi capoTmp = new Dmt_t_premio_capi();
        capoTmp.setCodiceAzienda(capoVacca.getAziendaCodice());
        capoTmp.setIdCapo(capoVacca.getCapoId());
        capoTmp.setCuaa(getCuaa());
        capoTmp.setIdSessione(capoVacca.getIdSessione());
        capoTmp.setFlagAmmissibile(ammissibile);
        capoTmp.setCodiceVitello(capoVacca.getCodiceVitello());
        capoTmp.setCodicePremio(capoVacca.getCodicePremio());
        capoTmp.setIdAllevamento(capoVacca.getAllev_id());
        capoTmp.setMsg(msg);
        return capoTmp;

    }

    /**
     * inizializzaCapoEscluso()
     * <p>
     * Serve ad inizializzare un oggetto di tipo Dmt_w_Tdu_premio_capi, così da
     * poter aggiungere il capo/vacca alla listaCapiAmmessi, che, tramite service,
     * sarà salvata su DB
     *
     * @param capoVacca
     * @param msg
     * @return capoTmp
     */
    private Dmt_t_premio_capi inizializzaCapoMacellato(Dmt_t_clsCapoMacellato capo, String ammissibile, String msg) {

        Dmt_t_premio_capi capoTmp = new Dmt_t_premio_capi();
        capoTmp.setCodiceAzienda(capo.getAziendaCodice());
        capoTmp.setIdCapo(capo.getCapoId());
        capoTmp.setCuaa(getCuaa());
        capoTmp.setIdSessione(capo.getIdSessione());
        capoTmp.setFlagAmmissibile(ammissibile);
        capoTmp.setCodicePremio(capo.getCodicePremio());
        capoTmp.setIdAllevamento(capo.getAllevId());
        capoTmp.setMsg(msg);
        capoTmp.setIdSessione(sessione);
        capoTmp.setCodiceVitello("");
        return capoTmp;

    }

    /**
     * inizializzaCapoOvicaprino()
     * <p>
     * Serve ad inizializzare un oggetto di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini,
     * così da poter aggiungere il capo ovicaprino alla listaCapiAmmessi, che,
     * tramite service, sarà salvata su DB
     *
     * @param capoOvicaprino
     * @param msg
     * @return capoTmp
     **/
    private Dmt_t_premio_capi inizializzaCapoOvicaprino(Dmt_t_Tws_bdn_du_capi_ovicaprini capo, String ammissibile,
                                                        String msg) {

        Dmt_t_premio_capi capoTmp = new Dmt_t_premio_capi();
        capoTmp.setCodiceAzienda(capo.getAziendaCodice());
        capoTmp.setIdCapo(capo.getCapoId());
        capoTmp.setCuaa(getCuaa());
        capoTmp.setIdSessione(capo.getIdSessione());
        capoTmp.setFlagAmmissibile(ammissibile);
        capoTmp.setCodicePremio(capo.getCodicePremio());
        capoTmp.setIdAllevamento(capo.getAllevId());
        capoTmp.setMsg(msg);
        capoTmp.setIdSessione(sessione);
        capoTmp.setCodiceVitello("");
        return capoTmp;

    }

    /**
     * Il metodo saveOnDB()
     * <p>
     * Serve a salvare su DB : - listaCapiAmmessi - listaCapiEsclusi - model
     * (Dmt_d_Ref9903)
     */
    private void saveOnDB() {
        try {
            if (1==1)
                System.out.println("Inizio salvataggio capi controllati 9903");

            for (String cp : listaCapiResult.keySet()) {
                if (!listaCapiResult.isEmpty()) {
                    try {
                        System.out.println("\n\n CP -> " + cp);
                        System.out.println("\n\n STO SALVANDO -> " + listaCapiResult.get(cp).size());
                        capiAmmessiServices.saveAll(listaCapiResult.get(cp));
                        salvataggioEseguitoCorrettamente = true;
                        if (1==1)
                            System.out.println("FINE SALVATAGGIO VAPI AMMESSI REF99.03");

                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        salvataggioEseguitoCorrettamente = false;
                        System.out.println("ERRORE DURANTE IL SALVATAGGIO CAPI AMMESSI REF99.03: ");
                    }

                } else {
                    if (!PREMI_OVICAPRINI_AGNELLE.contains(cp)) {
                        if (1==1)
                            System.out.println("NESSUN CAPO AMMESSO AL CALCOLO 9903");
                        // Response false se nessun capo ammesso non si raggiungono le uba minime
                        response = false;
                    }
                }

                if (PREMI_OVICAPRINI_AGNELLE.contains(cp)) {
                    salvataggioEseguitoCorrettamente = true;
                }
            }

            if (1==1)
                System.out.println("FINE SALVATAGGIO CAPI CONTROLLATI REF99.03");

            model.setAnnoCampagna(getAnnoCampagna());
            model.setCuaa(getCuaa());
            model.setIdSessione(sessione);
            model.setUba(ubaMinime.doubleValue());
            if (ubaMinime.doubleValue() >= UBA.doubleValue()) {
                model.setEsito("P");
                model.setMotivazioni(
                        "Si possiedono capi per un totale di " + ubaMinime + "UBA, sufficienti per accedere al premio");
                response = true;
            } else {

                model.setEsito("N");
                model.setMotivazioni("Si possiedono capi per un totale di " + ubaMinime
                        + "UBA, insufficienti per accedere al premio.");
                response = false;
            }
            ubaMinime = BigDecimal.ZERO;
            ref9903Services.save(model);

        } catch (Exception e) {
            e.printStackTrace();
            salvataggioEseguitoCorrettamente = false;
            System.out.println("ERRORE DURANTE IL SALVATAGGIO DEI CAPI CONTROLLATI REF99.03 : ");
        }
    }
}
