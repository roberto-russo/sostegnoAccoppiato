package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_clsCapoMacellato_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * i controlli da applicare per il calcolo del premio zootecnia per
 * l’intervento 316 – Misura 19:<br>
 * capi bovini macellati di età compresa tra i 12 e 24 mesi allevati dal
 * richiedente per un periodo non inferiore ai dodici mesi.
 *
 * @author Bcsoft
 */
@Component("ClcInt316Mis19")
public class ClcInt316Mis19 extends Controllo {


    /* MODEL DA INIZIALIZZARE PER I CONTROLLI */
    private List<Dmt_t_clsCapoMacellato> modelMacellato;
    private List<Dmt_t_clsCapoMacellato> modelMacellatoFiltrato;
    private BigDecimal importoLiquidabile;
    private List<Dmt_t_clsCapoMacellato> duplicatiMacellati;
    private Dmt_t_output_controlli oc;
    private List<Dmt_t_contr_loco> estrazioneACampione;
    private Dmt_t_output_esclusi oe;
    private ResultCtlUbaMinime ubaMin;
    @Autowired
    private Dmt_t_clsCapoMacellato_services capiMacellatiService;
    private BigDecimal numeroCapiRichiesti;
    private int contatoreBocciati;
    private int contatoreSanzionati;
    private List<Dmt_t_clsCapoMacellato> listaCapiBocciati;
    private List<Dmt_t_clsCapoMacellato> capiSanzionati;
    private String motivazione;

    /**
     * nel metodo preEsecuzione vengono effettuate due operazioni principali. La
     * prima è l'inizializzazione delle variabili di classe. La seconda è
     * l'esecuzione dei controlli di preammissibilità trasversali. Il risultato di
     * tali controlli pregiudica l'esecuzione del calcolo stesso. Se l'esecuzione ha
     * esito positivo, allora si può procedere con il calcolo intervento 316 misura
     * 19. Se l'esecuzione ha esito negativo, allora viene generato un messaggio di
     * errore. Il metodo preEsecuzione utilizza il controllo:<br>
     * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
     *
     * @return
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public List<Dmt_t_clsCapoMacellato> preEsecuzione() throws ControlloException {
        System.out.println("INIZIO CALCOLO INTERVENTO 316 MISURA 19");
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 316 MISURA 19, INIZIO PRE-ESECUZIONE");
        this.importoLiquidabile = new BigDecimal(0);
        this.contatoreBocciati = 0;
        this.modelMacellato = null;
        this.oc = null;
        this.numeroCapiRichiesti = BigDecimal.ZERO;
        this.estrazioneACampione = null;
        this.listaCapiBocciati = new ArrayList<>();
        this.capiSanzionati = new ArrayList<>();
        this.oe = null;
        this.motivazione = null;
        this.ubaMin = new ResultCtlUbaMinime();
        this.modelMacellatoFiltrato = null;
        this.contatoreSanzionati = 0;

        // controlli di preammissibilità

        // this.modelMacellato =
        // getControlliService().getAllMacellatiSessioneCuua(getSessione(),
        // getAzienda().getCuaa(), getAzienda().getCodicePremio());
        this.modelMacellato = this.controlloCapiDichiarati(getControlliService()
                .getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()));

        if (1==1)
            System.out.println("CALCOLO INTERVENTO 316 MISURA 19, FINE PRE-ESECUZIONE");
        System.out.println(
                "I CONTROLLI DI PRE-CALCOLO PER IL CALCOLO INTERVENTO 316 MISURA 19 SONO STATI ESEGUITI CORRETTAMENTE ✔");

        return modelMacellato;

    }

    /**
     * nel metodo esecuzione vengono eseguiti i controlli per il calcolo intervento
     * 316 misura 19. Se i controlli per il suddetto calcolo risultano essere
     * positivi, allora viene incrementato il contatore di importo liquidabile e il
     * capo sarà visibile in
     * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli}. Qualora i
     * capi risultassero non idonei al premio in questione, verrà incrementato il
     * numero di capi non ammessi a premio e tale capo sarà inserito nella lista di
     * capi non ammessi a premio. La lista di capi non ammessi a premio sarà
     * visibile in {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi}.
     *
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public void esecuzione(List<Dmt_t_premio_capi> listUbaMinime) throws ControlloException {

        this.modelMacellatoFiltrato = capiMacellatiService.getMacellatiUbaMinime(getSessione().getIdSessione(),
                getAzienda().getCuaa(), getAzienda().getCodicePremio());
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 316 MISURA 19, INIZIO ESECUZIONE");

        List<Dmt_t_clsCapoMacellato> newListModel = new ArrayList<Dmt_t_clsCapoMacellato>();
        for (Dmt_t_clsCapoMacellato x : modelMacellatoFiltrato) {
            if (UtilControlli.isControlloRegistrazioneUscita(x, getAzienda().getAnnoCampagna()) && UtilControlli
                    .controlloDemarcazioneCapoMacellato(x, getControlliService(), getAzienda().getAnnoCampagna()))
                newListModel.add(x);
            else {
                x.setTipologiaEsclusione("E");
                x.setMotivazioneEsclusione("Capo anomalo per registrazione tardiva  (no sanzione).");
                contatoreBocciati++;
                listaCapiBocciati.add(x);
            }
        }

        modelMacellatoFiltrato = newListModel;

        numeroCapiRichiesti = BigDecimal.valueOf(this.modelMacellatoFiltrato.size());
        try {

            for (Dmt_t_clsCapoMacellato m : this.modelMacellatoFiltrato) {

                this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa(),
                        getAzienda().getAnnoCampagna());

                if (this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {

                    this.duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(),
                            getSessione().getIdSessione(), getAzienda().getCodicePremio());

                    // SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CAA

                    if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
                            this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), m.getCapoId(),
                            this.getControlliService())) {

                        UtilControlli.controlloRegistrazioneStallaDuplicato(m, this.getControlliService(),
                                this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());

                        importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);

                    } else {

                        /*
                         * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il capo
                         * non può essere pagato, salvo rinuncia da parte di uno dei richiedenti. Il
                         * premio alla macellazione viene riconosciuto ai proprietari/detentori dei capi
                         * macellati ed in caso di richiesta di aiuti da parte di entrambi, i capi
                         * ammissibili sono pagati esclusivamente al detentore
                         */
                        if (UtilControlli.flagDuplicatiRichiedenti(duplicatiMacellati, getAzienda().getCuaa(),
                                this.getControlliService())) {

                            // calcolo giorni festivi tra 2 date
                            /*
                             * COMUNICAZIONE DELLA MOVIMENTAZIONE
                             */
                            if (UtilControlli.controlloTempisticheDiRegistrazione(m)) {

                                /*
                                 * TEMPISTICA BDN =< 7 giorni
                                 */
                                UtilControlli.controlloRegistrazioneStallaDuplicato(m, this.getControlliService(),
                                        this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(),
                                        this.getSessione());
                                this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);

                            } else {

                                /*
                                 * Sia stato allevato per un periodo continuativo di 12 mesi
                                 *
                                 */
                                if ((m.getDtUscita() != null && m.getDtIngresso() != null) && (UtilControlli
                                        .differenzaMesi(m.getDtUscita(), m.getDtInserimentoBdnIngresso()) >= 12)) {
                                    /*
                                     * OK: Periodo di detenzione soddisfatto, nonostante presenza del ritardo nella
                                     * registrazione della movimentazione del capo
                                     *
                                     * CAPO PAGATO E SANZIONATO
                                     */
                                    UtilControlli.controlloRegistrazioneStallaDuplicato(m, this.getControlliService(),
                                            this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(),
                                            this.getSessione());
                                    this.contatoreSanzionati++;
                                    capiSanzionati.add(m);

                                } else {
                                    /*
                                     * il capo non è stato allevato per un periodo minimo di 12 mesi continuativi
                                     */
                                    this.contatoreBocciati++;
                                    m.setMotivazioneEsclusione(
                                            "il capo non e' stato allevato per un periodo minimo di 12 mesi continuativi ");
                                    this.listaCapiBocciati.add(m);
                                    m.setTipologiaEsclusione("A");
                                }
                            }
                        } else {

                            /*
                             * il capo è stato richiesto in pagamento da più di un soggetto, il capo non
                             * può esserepagato a meno di una rinuncia da parte di uno dei richiedenti.
                             */

                            this.contatoreBocciati++;
                            m.setMotivazioneEsclusione(
                                    "il capo e' stato richiesto in pagamento da piu' di un soggetto, il capo non puo' esserepagato a meno di una rinuncia da parte di uno dei richiedenti");
                            this.listaCapiBocciati.add(m);
                            m.setTipologiaEsclusione("A");
                        }
                    }
                } else {
                    // verifica controlli in loco
                    for (Dmt_t_contr_loco c : this.estrazioneACampione)
                        if (!c.getAnomalie_cgo().contains("B"))
                            this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
                }
            }

            if (importoLiquidabile.compareTo(BigDecimal.ZERO) == 0) {
                System.out.println(
                        "ERRORE CALCOLO INTERVENTO 316 MISURA 19, NESSUN CAPO HA SUPERATO IL CONTROLLO PER IL PREMIO");
                throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
                        + " nessun capo ha suprato il controllo per il premio 316 misura 19");
            }

        } catch (ControlloException e) {
            System.out.println(
                    "ERRORE CALCOLO INTERVENTO 316 MISURA 19, ERRORE DURANTE L'ESECUZIONE DEL CALCOLO INTERVENTO 316 MISURA 19 REF02.008");
            new Dmt_t_errore(getSessione(), "ref02_008", getInput(), e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("ERRORE DURANTE L'ESECUZIONE DEL CALCOLO INTERVENTO 316 MISURA 19, NESSUN CAPO DISPONIBILE");
            throw new ControlloException(
                    new Dmt_t_errore(getSessione(), "esecuzione", getInput(), "nessun capo disponibile"));

        }

        if (1==1)
            System.out.println("CALCOLO INTERVENTO 316 MISURA 19, FINE ESECUZIONE");

    }

    /**
     * nel metodo postEsecuzione vengono salvati a db i dati relativi ai capi
     * ammessi a premio in
     * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli} e i dati
     * relativi ai capi non ammessi a premio in {@link Dmt_t_output_esclusi}. Dei
     * capi non ammessi a premio sarà salvata l'informazione di identificazione del
     * capo, il premio per cui è stata effettuata la richiesta di amissione e la
     * motivazione per cui risulta non idoneo al premio. Per i capi risultanti
     * idonei al premio in questione, sarà salvata l'informazione dell'anno
     * campagna per cui concorrono, il numero di capi ammessi a premio, il cuaa che
     * ha presentato la domanda e il codice premio.
     *
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public void postEsecuzione() throws ControlloException {

        if (1==1)
            System.out.println("CALCOLO INTERVENTO 316 MISURA 19, INIZIO POST-ESECUZIONE");

        if (null != this.numeroCapiRichiesti && numeroCapiRichiesti.longValue() != 0) {
            this.oc = new Dmt_t_output_controlli();
            // salvataggio capi ammissibili
            this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
            this.oc.setCapiAmmissibili(this.importoLiquidabile);
            this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
            this.oc.setCapiSanzionati(this.contatoreSanzionati);
            this.oc.setCuaa(getAzienda().getCuaa());
            this.oc.setIntervento(getAzienda().getCodicePremio());
            this.oc.setIdSessione(getSessione());
            getControlliService().saveOutput(this.oc);
        }
        System.out.println("Contatore bocciati -> " + getAzienda().getCodicePremio() + " -> " + contatoreBocciati);

        if (this.contatoreBocciati != 0) {
            // salvataggio capi esclusi
            this.oe = new Dmt_t_output_esclusi();

            for (Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {
                this.oe.setCalcolo(getClass().getSimpleName());
                this.oe.setCapoId(x.getCapoId());
                this.oe.setIdSessione(getSessione());
                oe.setCuaa(getAzienda().getCuaa());
                oe.setCodicePremio(getAzienda().getCodicePremio());
                oe.setTipologiaEsclusione(x.getTipologiaEsclusione());
                this.oe.setMotivazioneEsclusione(x.getMotivazioneEsclusione());
                this.getControlliService().saveOutputEscl(this.oe);
            }

        }

        for (Dmt_t_clsCapoMacellato x : this.capiSanzionati) {
            this.oe = new Dmt_t_output_esclusi();
            this.oe.setCalcolo(getClass().getSimpleName());
            this.oe.setCapoId(x.getCapoId());
            this.oe.setIdSessione(getSessione());
            oe.setCuaa(getAzienda().getCuaa());
            oe.setTipologiaEsclusione("S");
            oe.setCodicePremio(getAzienda().getCodicePremio());
            this.oe.setMotivazioneEsclusione(x.getMotivazioneEsclusione());
            this.getControlliService().saveOutputEscl(this.oe);
        }

        if (1==1)
            System.out.println("CALCOLO INTERVENTO 316 MISURA 19, FINE POST-ESECUZIONE");
        System.out.println("FINE ESECUZIONE CALCOLO INTERVENTO 316 MISURA 19");
    }

    // /**
    // * nel metodo differenzaMesi viene calcolata la differenza in mesi tra due
    // date
    // * @param dataInizio per dataInizio si intende la prima data da inserire
    // per poter effettuare il calcolo.
    // * @param dataFine per dataFine si intende la seconda data da inserire per
    // poter effettuare il calcolo.
    // * il metodo calcolerà i mesi che intercorrono tra la prima e la seconda
    // data.
    // * @return monthsBetween il numero di mesi che intercorrono tra le due
    // date inserite.
    // */
    // private long differenzaMesi(Date dataInizio, Date dataFine) {
    // LocalDate data1 = LocalDate.parse(dataInizio.toString());
    // //dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    // LocalDate data2 = LocalDate.parse(dataFine.toString());
    // //dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    // long monthsBetween = ChronoUnit.MONTHS.between(data1, data2);
    // return monthsBetween;
    // }

    // /**
    // * nel metodo flagDuplicatiRichiedenti viene analizzata la lista dei cuaa
    // che effettuano una richiesta sullo stesso capo.
    // * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il
    // capo non può essere pagato, salvo rinuncia da parte di uno dei
    // richiedenti.
    // * Il premio alla macellazione viene riconosciuto ai proprietari/detentori
    // dei capi macellati ed in caso di richiesta di aiuti da parte di entrambi,
    // * i capi ammissibili sono pagati esclusivamente al detentore.
    // * @param duplicatiMacellati lista delle richieste effettuate sullo stesso
    // capo
    // * @param cuaa codice fiscale del richiedente analizzato
    // * @return boolean true se il capo può essere pagato al cuaa analizzato,
    // false altrimenti
    // */
//	private Boolean flagDuplicatiRichiedenti(List<Dmt_t_clsCapoMacellato> duplicatiMacellati, String cuaa) {
//
//		Dmt_t_anagrafica_allevamenti allev1;
//
//		if (duplicatiMacellati.size() == 1 && duplicatiMacellati.get(0).getCuaa().equals(cuaa))
//			return true;
//
//		else if (duplicatiMacellati.size() == 2) {
//
//			// se la vacca compare due volte nello stesso allevamento,
//			// controllare chi è il
//			// proprietario e chi è il detentore
//			if (duplicatiMacellati.get(0).getAllevId().equals(duplicatiMacellati.get(1).getAllevId())) {
//
//				allev1 = getControlliService()
//						.getAnagraficaByIdAllevamento(BigDecimal.valueOf(duplicatiMacellati.get(0).getAllevId()));
//
//				if (((!allev1.getCod_fiscale_deten().equals(null))
//						&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(0).getCuaa())
//								&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(1).getCuaa())))
//						|| ((!allev1.getCod_fiscale_deten().equals(null))
//								&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(1).getCuaa())
//										&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(0).getCuaa()))))
//					if (allev1.getCod_fiscale_deten().equals(cuaa))
//						return true;
//
//			}
//		}
//
//		return false;
//	}
    @Override
    public <T> List<T> controlloCapiDichiarati(List<T> capiBDN) {

        List<T> listaCapiDichiarati = new ArrayList<T>();

        UtilControlli.clearList(listaCapiDichiarati);

//		for( T capo : capiBDN)
//			if( UtilControlli.controlloAmmissibilitaPremioPerPremiCompatibili( (Dmt_t_clsCapoMacellato) capo) )
//					listaCapiDichiarati.add(capo);

        // return listaCapiDichiarati.isEmpty() ? Collections.emptyList() :
        // listaCapiDichiarati;
        return capiBDN;
    }
}
