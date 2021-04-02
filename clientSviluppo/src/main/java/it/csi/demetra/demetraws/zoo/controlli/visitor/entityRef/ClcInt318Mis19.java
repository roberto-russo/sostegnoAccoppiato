package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_clsCapoMacellato_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * Il caso d’uso indica i controlli da applicare per il calcolo del premio
 * zootecnia per l’intervento 318 – Misura 19: <br>
 * capi bovini macellati di età compresa tra i 12 e 24 mesi aderenti a sistemi
 * di etichettatura facoltativa riconosciuti e allevati dal richiedente per un
 * periodo non inferiore a sei mesi prima della macellazione.
 *
 * @author Bcsoft
 */
@Component("ClcInt318Mis19")
public class ClcInt318Mis19 extends Controllo {

    List<Dmt_t_contr_loco> estrazioneACampione;
    Dmt_t_output_controlli oc;
    private List<Dmt_t_clsCapoMacellato> listaCapiMacellati;
    private List<Dmt_t_clsCapoMacellato> duplicatiMacellati;
    private List<Dmt_t_clsCapoMacellato> listaCapiMacellatiFiltrati;
    private ResultCtlUbaMinime ubaMin;
    @Autowired
    private Dmt_t_clsCapoMacellato_services capiMacellatiService;
    private BigDecimal numeroCapiAmmissibili;
    private BigDecimal numeroCapiRichiesti;
    private List<Dmt_t_SistemiDiEtichettaturaFacoltativa> sistemiEtichettatura;
    private int numeroCapiBocciati;
    private int contatoreSanzionati;
    private String motivazione;
    private List<Dmt_t_clsCapoMacellato> listaCapiBocciati;
    private List<Dmt_t_clsCapoMacellato> capiSanzionati;
    private Dmt_t_output_esclusi outputEsclusi;

    /**
     * nel metodo preEsecuzione vengono effettuate due operazioni principali. La
     * prima è l'inizializzazione delle variabili di classe. La seconda è
     * l'esecuzione dei controlli di preammissibilità trasversali. Il risultato di
     * tali controlli pregiudica l'esecuzione del calcolo stesso. Se l'esecuzione ha
     * esito positivo, allora si può procedere con il calcolo intervento 318 misura
     * 19. Se l'esecuzione ha esito negativo, allora viene generato un messaggio di
     * errore. il metodo preEsecuzione utilizza il controllo:<br>
     * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
     *
     * @return
     */
    @Override
    public List<Dmt_t_clsCapoMacellato> preEsecuzione() throws ControlloException {
        System.out.println("INIZIO CALCOLO INTERVENTO 318 MISURA 19");
        if (1 == 1)
            System.out.println("CALCOLO INTERVENTO 318 MISURA 19, INIZIO PRE-ESECUZIONE");
        this.listaCapiMacellati = null;
        this.estrazioneACampione = null;
        this.numeroCapiAmmissibili = new BigDecimal(0);
        this.numeroCapiBocciati = 0;
        this.contatoreSanzionati = 0;
        this.numeroCapiRichiesti = BigDecimal.ZERO;
        this.motivazione = null;
        this.listaCapiBocciati = new ArrayList<>();
        this.capiSanzionati = new ArrayList<>();
        this.outputEsclusi = null;
        this.ubaMin = new ResultCtlUbaMinime();
        this.listaCapiMacellatiFiltrati = null;

        // CONTROLLO DI PREAMMISSIBILITA' TRASVERSALE

        this.listaCapiMacellati = this.controlloCapiDichiarati(getControlliService()
                .getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()));
        if (1 == 1)
            System.out.println("CALCOLO INTERVENTO 318 MISURA 19, FINE PRE-CALCOLO");
        System.out.println(
                "I CONTROLLI DI PRE-CALCOLO PER IL CALCOLO INTERVENTO 318 MISURA 19 SONO STATI ESEGUITI CORRETTAMENTE ✔");

        return listaCapiMacellati;
    }

    @Override
    /**
     * nel metodo esecuzione vengono eseguiti i controlli per il calcolo intervento
     * 318 misura 19. Se i controlli per il suddetto calcolo risultano essere
     * positivi, allora viene incrementato il contatore di capi ammissibili e il
     * capo sarà visibile in @see Dmt_t_output_controlli. Qualora i capi
     * risultassero non idonei al premio in questione, verrà incrementato il numero
     * di capi non ammessi a premio e tale capo sarà inserito nella lista di capi
     * non ammessi a premio. La lista di capi non ammessi a premio sarà visibile
     * in @see Dmt_t_output_esclusi.
     */
    public void esecuzione(List<Dmt_t_premio_capi> listUbaMinime) throws ControlloException {

        this.listaCapiMacellatiFiltrati = capiMacellatiService.getMacellatiUbaMinime(getSessione().getIdSessione(),
                getAzienda().getCuaa(), getAzienda().getCodicePremio());

        if (1 == 1)
            System.out.println("CALCOLO INTERVENTO 318 MISURA 19, INIZIO CALCOLO");

        if (listaCapiMacellatiFiltrati == null)
            return;

        List<Dmt_t_clsCapoMacellato> newListModel = new ArrayList<Dmt_t_clsCapoMacellato>();
        for (Dmt_t_clsCapoMacellato x : listaCapiMacellatiFiltrati) {
            if (UtilControlli.isControlloRegistrazioneUscita(x, getAzienda().getAnnoCampagna()) && UtilControlli
                    .controlloDemarcazioneCapoMacellato(x, getControlliService(), getAzienda().getAnnoCampagna()))
                newListModel.add(x);
            else {
                x.setTipologiaEsclusione("E");
                x.setMotivazioneEsclusione("Capo anomalo per registrazione tardiva  (no sanzione).");
                numeroCapiBocciati++;
                listaCapiBocciati.add(x);
            }
        }

        listaCapiMacellatiFiltrati = newListModel;

        numeroCapiRichiesti = BigDecimal.valueOf(this.listaCapiMacellati.size());

        try {
            for (Dmt_t_clsCapoMacellato m : this.listaCapiMacellatiFiltrati) {
                this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa(),
                        getAzienda().getAnnoCampagna());

                if (this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {

                    this.sistemiEtichettatura = getControlliService().getSistemaEtichettarua(getAzienda().getCuaa());
                    this.duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(),
                            getSessione().getIdSessione(), getAzienda().getCodicePremio());
                    // SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CUAA
                    UtilControlli.controlloRegistrazioneStallaDuplicato(m, this.getControlliService(),
                            this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());
                    if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
                            this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), m.getCapoId(),
                            this.getControlliService())) {

                        UtilControlli.controlloRegistrazioneStallaDuplicato(m, this.getControlliService(),
                                this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());
                        this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
                    } else {
                        if (UtilControlli.controlloTempisticheDiRegistrazione(m)
                                && controlloAdesioneEtichettatura(m, sistemiEtichettatura)) {
                            this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
                        } else {
                            if (controlloAdesioneEtichettatura(m, sistemiEtichettatura)) {
                                if (UtilControlli.controlloTempisticheDiRegistrazione(m)) {
                                    this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
                                } else {
                                    if (UtilControlli.flagDuplicatiRichiedenti(duplicatiMacellati,
                                            getAzienda().getCuaa(), this.getControlliService())) {
                                        UtilControlli.controlloRegistrazioneStallaDuplicato(m,
                                                this.getControlliService(), this.getAzienda().getCuaa(),
                                                this.getAzienda().getAnnoCampagna(), this.getSessione());
                                        this.contatoreSanzionati++;
                                        capiSanzionati.add(m);
                                    } else {
                                        this.numeroCapiBocciati++;
                                        m.setMotivazioneEsclusione("Tempistiche di pagamento non rispettate");
                                        this.listaCapiBocciati.add(m);
                                        m.setTipologiaEsclusione("E"); // QUI E Perchè non deve essere considerato negli
                                        // altri premi
                                    }
//		                            if ((m.getDtUscita() != null && m.getDtInserimentoBdnIngresso() != null) && (UtilControlli
//		                                    .differenzaMesi(m.getDtUscita(), m.getDtInserimentoBdnIngresso()) >= 6)) {
//		                                if (this.etic != null && this.etic.getFlagEtichettatura().equals("S")) {
                                    //
//		                                } else {
//		                                    this.motivazione = "le conformita' a sistemi di etichettatura facoltativa non rispettati";
//		                                    this.numeroCapiBocciati++;
//		                                    this.listaCapiBocciati.add(m);
//		                                }
//		                            } else {
//		                                this.motivazione = "il capo non e' stato allevato per un periodo minimo di 6 mesi continuativi ";
//		                                this.numeroCapiBocciati++;
//		                                this.listaCapiBocciati.add(m);
//		                            }
                                }
                            } else {
                                this.numeroCapiBocciati++;
                                m.setMotivazioneEsclusione("Sistema di etichettatura non rispettato");
                                this.listaCapiBocciati.add(m);
                                m.setTipologiaEsclusione("A");
                            }
                        }

//							if (numeroCapiAmmissibili.compareTo(BigDecimal.ZERO) == 0) {
//								System.out.println(
//										"ERRORE CALCOLO INTERVENTO 318 MISURA 19, NESSUN CAPO HA SUPERATO IL CONTROLLO PER IL PREMIO");
//								throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
//										+ " nessun capo ha suprato il controllo per il premio 318 misura 19");
//							}
                    }
                } else {
                    // GESTIONE CONTROLLI BY DMT_CONTR_LOCO
                    for (Dmt_t_contr_loco c : this.estrazioneACampione)
                        if ((c.getAnomalie_cgo() == null) || (c.getAnomalie_cgo().indexOf('B') == -1))
                            this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
                }

            }
        } catch (NullPointerException e) {
            System.out.println(
                    "ERRORE DURANTE L'ESECUZIONE DEL CALCOLO INTERVENTO 318 MISURA 19, NESSUN CAPO DISPONIBILE");
            throw new ControlloException(
                    new Dmt_t_errore(getSessione(), "esecuzione", getInput(), "nessun capo disponibile"));
        }
        System.out.println("CALCOLO INTERVENTO 318 MISURA 19, FINE CALCOLO");
    }

    private boolean controlloAdesioneEtichettatura(Dmt_t_clsCapoMacellato capoMacellato,
                                                   List<Dmt_t_SistemiDiEtichettaturaFacoltativa> sistemiEtichettatura) {
        boolean res = false;
        // SE NON ESISTE NEMMENO UNA STALLA CHE ADERISCE NON PROSEGUO
        if (null == sistemiEtichettatura || sistemiEtichettatura.size() == 0)
            return false;

        // PRENDO TUTTE LE PERMANENZE DI UN CAPO NELLE STALLE DEL CUAA
        List<Dmt_t_clsCapoMacellato> capiList = new ArrayList<>();
        for (Dmt_t_SistemiDiEtichettaturaFacoltativa et : sistemiEtichettatura) {
            capiList.addAll(capiMacellatiService.getCapiMacellatiByStalla(getSessione().getIdSessione(),
                    getAzienda().getCuaa(), et.getCodiceAsl(), capoMacellato.getCapoId()));
        }

        // PRENDO LA DATA DI PERMANENZA PIU' RECENTE
        Date recentDate = null;
        for (Dmt_t_clsCapoMacellato m : capiList) {
            if (null == recentDate)
                recentDate = m.getDtUscita();
            else if (recentDate.compareTo(m.getDtUscita()) <= 0)
                recentDate = m.getDtUscita();
        }

        // SOTTRAGGO 6 MESI DALLA DATA PIU' RECENTE
        Date compareDate = subtractMonth(recentDate, 6);
        String lastCodiceAsl = null;

        Date lastDate = null;
        for (Dmt_t_clsCapoMacellato m : capiList) {
            if (null == m.getDtUscita())
                continue;
            if (compareDate.compareTo(m.getDtUscita()) <= 0) {
                for (Dmt_t_SistemiDiEtichettaturaFacoltativa et : sistemiEtichettatura) {
                    if (et.getCodiceAsl().equals(m.getAziendaCodice())
                            && getDifferenceInMonth(et.getDataInizioAdesione(), m.getDtUscita()) > 6) {
                        if (null == lastDate || lastDate.compareTo(m.getDtUscita()) <= 0) {
                            lastDate = m.getDtUscita();
                            lastCodiceAsl = et.getCodiceAsl();
                        }
                    }
                }
            }
        }

        if (null == lastDate)
            return false;

        for (Dmt_t_SistemiDiEtichettaturaFacoltativa etic : sistemiEtichettatura) {
            if (!etic.getCodiceAsl().equals(lastCodiceAsl))
                continue;

            if (null == etic.getDataFineAdesione())
                return true;
            else if (lastDate.compareTo(etic.getDataFineAdesione()) <= 0)
                return true;
        }

        return false;
    }

    int getDifferenceInMonth(Date dateOne, Date dateTwo) {
        if (null == dateOne || null == dateTwo)
            return -1;
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(dateOne);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(dateTwo);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return diffMonth;
    }

    Date subtractMonth(Date referenceDate, int month) {
        if (null == referenceDate)
            return null;
        // SOTTRAGGO 6 MESI ALLA DATA RECENTE
        Calendar c = Calendar.getInstance();
        c.setTime(referenceDate);
        c.add(Calendar.MONTH, -month);
        return c.getTime();
    }

    @Override
    /**
     * nel metodo postEsecuzione vengono salvati a db i dati relativi ai capi
     * ammessi a premio in @see Dmt_t_output_controlli e i dati relativi ai capi non
     * ammessi a premio in @see Dmt_t_output_esclusi. Dei capi non ammessi a premio
     * sarà salvata l'informazione di identificazione del capo, il premio per cui è
     * stata effettuata la richiesta di amissione e la motivazione per cui risulta
     * non idoneo al premio. Per i capi risultanti idonei al premio in questione,
     * sarà salvata l'informazione dell'anno campagna per cui concorrono, il numero
     * di capi ammessi a premio, il cuaa che ha presentato la domanda e il codice
     * premio.
     */
    public void postEsecuzione() throws ControlloException {

        if (1 == 1)
            System.out.println("CALCOLO INTERVENTO 318 MISURA 19, INIZIO POST-ESECUZIONE");

        if (null != this.numeroCapiRichiesti && numeroCapiRichiesti.longValue() != 0) {
            // SE NON SONO STATI RISCONTRATI ERRORI ALLORA POSSO SALVARE A DB QUI SALVARE
            // SIA I CAPI RICHIESTI CHE I CAPI AMMISSIBILI A PREMIO

            this.oc = new Dmt_t_output_controlli();
            this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
            this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
            this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
            this.oc.setCapiSanzionati(this.contatoreSanzionati);
            this.oc.setCuaa(getAzienda().getCuaa());
            // PERCHE' QUI ENTRANO SOLO LE AZIENDE CON CODICE PREMIO = 318
            this.oc.setIntervento(getAzienda().getCodicePremio());
            this.oc.setIdSessione(getSessione());
            getControlliService().saveOutput(this.oc);
        }

        if (this.numeroCapiBocciati != 0) {
            // SALVATAGGIO A DB DEI CAPI BOCCIATI
            this.outputEsclusi = new Dmt_t_output_esclusi();

            for (Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {

                this.outputEsclusi.setCalcolo(getClass().getSimpleName());
                this.outputEsclusi.setCapoId(x.getCapoId());
                this.outputEsclusi.setIdSessione(getSessione());
                outputEsclusi.setCuaa(getAzienda().getCuaa());
                outputEsclusi.setTipologiaEsclusione(x.getTipologiaEsclusione());
                outputEsclusi.setCodicePremio(getAzienda().getCodicePremio());
                this.outputEsclusi.setMotivazioneEsclusione(x.getMotivazioneEsclusione());
                this.getControlliService().saveOutputEscl(this.outputEsclusi);
            }
        }

        for (Dmt_t_clsCapoMacellato x : this.capiSanzionati) {
            Dmt_t_output_esclusi oe = new Dmt_t_output_esclusi();
            oe.setCalcolo(getClass().getSimpleName());
            oe.setCapoId(x.getCapoId());
            oe.setIdSessione(getSessione());
            oe.setCuaa(getAzienda().getCuaa());
            oe.setTipologiaEsclusione("S");
            oe.setCodicePremio(getAzienda().getCodicePremio());
            oe.setMotivazioneEsclusione(x.getMotivazioneEsclusione());
            getControlliService().saveOutputEscl(oe);
        }

        if (1 == 1)
            System.out.println("CALCOLO INTERVENTO 318 MISURA 19, FINE POST ESECUZIONE");
        System.out.println("FINE ESECUZIONE CALCOLO INTERVENTO 318 MISURA 19");
    }

//	/**
//	 * nel metodo differenzaMesi viene calcolata la differenza in mesi tra due date
//	 * @param dataInizio per dataInizio si intende la prima data da inserire per poter effettuare il calcolo.
//	 * @param dataFine per dataFine si intende la seconda data da inserire per poter effettuare il calcolo.
//	 * il metodo calcolerà i mesi che intercorrono tra la prima e la seconda data.
//	 * @return monthsBetween il numero di mesi che intercorrono tra le due date inserite. 
//	 */
//	private long differenzaMesi(Date dataInizio, Date dataFine) {
//		LocalDate data1 = dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		LocalDate data2 = dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		long monthsBetween = ChronoUnit.MONTHS.between(data1, data2);
//		return monthsBetween;
//	}

    // /**
//	 * nel metodo flagDuplicatiRichiedenti viene analizzata la lista dei cuaa che effettuano una richiesta sullo stesso capo.
//	 * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il capo non può essere pagato, salvo rinuncia da parte di uno dei richiedenti. 
//	 * Il premio alla macellazione viene riconosciuto ai proprietari/detentori dei capi macellati ed in caso di richiesta di aiuti da parte di entrambi, 
//	 * i capi ammissibili sono pagati esclusivamente al detentore.
//	 * @param duplicatiMacellati lista delle richieste effettuate sullo stesso capo
//	 * @param cuaa codice fiscale del richiedente analizzato
//	 * @return boolean true se il capo può essere pagato al cuaa analizzato, false altrimenti
//	 */
//	private Boolean flagDuplicatiRichiedenti(List<Dmt_t_clsCapoMacellato> duplicatiMacellati, String cuaa) {
//
//		Dmt_t_anagrafica_allevamenti allev1;
//
//		if (duplicatiMacellati.size() == 1 && duplicatiMacellati.get(0).getCuaa().equals(cuaa))
//			return true;
//		
//		if (duplicatiMacellati.size() == 2) {
//
//			// se la vacca compare due volte nello stesso allevamento, controllare chi è il
//			// proprietario e chi è il detentore
//			if (duplicatiMacellati.get(0).getAllevId().equals(duplicatiMacellati.get(1).getAllevId())) {
//
//				allev1 = getControlliService()
//						.getAnagraficaByIdAllevamento(BigDecimal.valueOf(duplicatiMacellati.get(0).getAllevId()));
//
////				if (((!allev1.getCod_fiscale_deten().equals(null))
////						&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(0).getCuaa())
////								&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(1).getCuaa())))
////						|| ((!allev1.getCod_fiscale_deten().equals(null))
////								&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(1).getCuaa())
////										&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(0).getCuaa()))))
////					if(allev1.getCod_fiscale_deten().equals(cuaa))
//						return allev1.getCod_fiscale_deten() != null && allev1.getCod_fiscale_deten().equals(cuaa);
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

        for (T capo : capiBDN)
            if ( // UtilControlli.controlloAmmissibilitaPremioPerPremiCompatibili(
                // (Dmt_t_clsCapoMacellato) capo ) &&
                    UtilControlli.controlloIscrizioneconsorzioEtichettatura((Dmt_t_clsCapoMacellato) capo,
                            getControlliService()))
                listaCapiDichiarati.add(capo);

        return listaCapiDichiarati.isEmpty() ? Collections.emptyList() : listaCapiDichiarati;
    }
}
