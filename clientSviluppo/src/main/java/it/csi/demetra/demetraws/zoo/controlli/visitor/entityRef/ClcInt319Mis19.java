package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_clsCapoMacellato_services;

/**
 * i controlli da applicare per il calcolo del premio zootecnia per l’intervento
 * 319 – Misura 19:<br>
 * capi bovini macellati di età compresa tra i 12 e 24 mesi allevati per almeno
 * sei mesi e certificati a denominazione di origine protetta o indicazione
 * geografica protetta di cui al Reg. (UE) n. 1151/2012.
 * 
 * @author Bcsoft
 */
@Component("ClcInt319Mis19")
public class ClcInt319Mis19 extends Controllo {


	
	private List<Dmt_t_clsCapoMacellato> listaCapiMacellati;
	private List<Dmt_t_clsCapoMacellato> duplicatiMacellati;
	private List<Dmt_t_clsCapoMacellato> listaCapiMacellatiFiltrati;
	
	@Autowired
	private CtlUbaMinime ref9903;
	@Autowired
	private Dmt_t_clsCapoMacellato_services capiMacellatiService;
	List<Dmt_t_contr_loco> estrazioneACampione;
	private BigDecimal numeroCapiAmmissibili;
	private BigDecimal numeroCapiRichiesti;
	Dmt_t_output_controlli oc;
	private int numeroCapiBocciati;
	private int contatoreSanzionati;
	Dmt_t_certificato_igp_dop certIgpDop;
	private String motivazione;
	private List<Dmt_t_clsCapoMacellato> listaCapiBocciati;
	private Dmt_t_output_esclusi outputEsclusi;
	private ResultCtlUbaMinime ubaMin;

	/**
	 * nel metodo preEsecuzione vengono effettuate due operazioni principali. La
	 * prima è l'inizializzazione delle variabili di classe. La seconda è
	 * l'esecuzione dei controlli di preammissibilità trasversali. Il risultato di
	 * tali controlli pregiudica l'esecuzione del calcolo stesso. Se l'esecuzione ha
	 * esito positivo, allora si può procedere con il calcolo intervento 319 misura
	 * 19. Se l'esecuzione ha esito negativo, allora viene generato un messaggio di
	 * errore. il metodo preEsecuzione utilizza il controllo:<br>
	 * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void preEsecuzione() throws ControlloException {
		System.out.println("INIZIO CALCOLO INTERVENTO 319 MISURA 19");
		if(1==1)
			System.out.println("CALCOLO INTERVENTO 319 MISURA 19, INIZIO PRE-ESECUZIONE");
		
		this.listaCapiMacellati = null;
		this.duplicatiMacellati = null;
		this.estrazioneACampione = null;
		this.numeroCapiAmmissibili = new BigDecimal(0);
		this.oc = null;
		this.numeroCapiRichiesti = BigDecimal.ZERO;
		this.certIgpDop = null;
		this.motivazione = null;
		this.listaCapiBocciati = new ArrayList<>();
		this.outputEsclusi = null;
		this.ubaMin = new ResultCtlUbaMinime();
		this.listaCapiMacellatiFiltrati = null;
		this.contatoreSanzionati = 0;


		this.listaCapiMacellati = getControlliService().getAllMacellatiSessioneCuua(getSessione(),
				getAzienda().getCuaa(), getAzienda().getCodicePremio());

		ref9903.init(listaCapiMacellati, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()),
				getAzienda().getCuaa(), getSessione());

		try {
			ubaMin = ref9903.calcolo();

			if (ubaMin.isErrors()) {
				System.out.println("ERRORE CALCOLO INTERVENTO 319 MISURA 19, ERRORE DURANTE L'ESECUZIONE DEL CONTROLLO DELLE UBA MINIME");
				throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
			}
			else if (!ubaMin.isResult()) {
				System.out.println("ERRORE CALCOLO INTERVENTO 319 MISURA 19, CONTROLLO UBA MINIME NON RISPETTATO");
				throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt319Mis19", getInput(),
						"controllo uba minime non rispettato"));
			}

		} catch (CalcoloException e) {
			System.out.println("ERRORE CALCOLO INTERVENTO 319 MISURA 19, ERRORE DURANTE L'ESECUZIONE DEI CONTROLLI AMMISSIBILITA' TRASVERSALI REF99.03");
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		}
		this.listaCapiMacellatiFiltrati = capiMacellatiService.getMacellatiUbaMinime(getSessione().getIdSessione(),
				getAzienda().getCuaa(), getAzienda().getCodicePremio());
		
		if(1==1)
			System.out.println("CALCOLO INTERVENTO 319 MISURA 19, FINE PRE-CALCOLO");
		System.out.println("I CONTROLLI DI PRE-CALCOLO PER IL CALCOLO INTERVENTO 319 MISURA 19 SONO STATI ESEGUITI CORRETTAMENTE ✔");

	}

	/**
	 * nel metodo esecuzione vengono eseguiti i controlli per il calcolo intervento
	 * 319 misura 19. Se i controlli per il suddetto calcolo risultano essere
	 * positivi, allora viene incrementato il contatore di capi ammissibili e il
	 * capo sarà visibile in
	 * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli}. Qualora i
	 * capi risultassero non idonei al premio in questione, verrà incrementato il
	 * numero di capi non ammessi a premio e tale capo sarà inserito nella lista di
	 * capi non ammessi a premio. La lista di capi non ammessi a premio sarà
	 * visibile in {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi}.
	 * 
	 * @throws ControlloException eccezione relativa ai controlli di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void esecuzione() throws ControlloException {
		
		if(1==1)
			System.out.println("CALCOLO INTERVENTO 319 MISURA 19, INIZIO CALCOLO");

		if (listaCapiMacellatiFiltrati == null)
			return;

		numeroCapiRichiesti = BigDecimal.valueOf(this.listaCapiMacellati.size());

		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa(),
				getAzienda().getAnnoCampagna());

		if (this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {
			try {
				for (Dmt_t_clsCapoMacellato m : this.listaCapiMacellatiFiltrati) {

					this.duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(),
							getSessione().getIdSessione(), getAzienda().getCodicePremio());
					this.certIgpDop = getControlliService().getCertificatoIgpDop(getAzienda().getCuaa());

					// calcolo giorni festivi tra 2 date
					/*
					 * COMUNICAZIONE DELLA MOVIMENTAZIONE
					 */
					if (UtilControlli.controlloTempisticheDiRegistrazione(m)) {
						/*
						 * TEMPISTICA BDN =< 7 giorni
						 */
						
						this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
					} else {
						/*
						 * Sia stato allevato per un periodo continuativo di 6
						 * mesi;
						 */
						if ((m.getDtUscita() != null && m.getDtInserimentoBdnIngresso() != null) && (UtilControlli
								.differenzaMesi(m.getDtUscita(), m.getDtInserimentoBdnIngresso()) >= 6)) {

							/*
							 * Sia certificato a denominazione di origine
							 * protetta o indicazione geografica protetta
							 */
							if ((this.certIgpDop != null) && (this.certIgpDop.getFlagDop().equals("S")
									|| this.certIgpDop.getFlagIgp().equals("S"))) {

								// SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CAA

								if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
										this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), m.getCapoId(),
										this.getControlliService())) {

									UtilControlli.controlloRegistrazioneStallaDuplicato(m, this.getControlliService(), this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());
									this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);

								} else {
								
								/*
								 * Qualora lo stesso capo sia richiesto in
								 * pagamento da due soggetti, il capo non può
								 * essere pagato, salvo rinuncia da parte di uno
								 * dei richiedenti. il capo è stato richiesto in
								 * pagamento da più di un soggetto, il capo non
								 * può esserepagato a meno di una rinuncia da
								 * parte di uno dei richiedenti. Il premio alla
								 * macellazione viene riconosciuto ai
								 * proprietari/detentori dei capi macellati ed
								 * in caso di richiesta di aiuti da parte di
								 * entrambi, i capi ammissibili sono pagati
								 * esclusivamente al detentore
								 */
								if (UtilControlli.flagDuplicatiRichiedenti(duplicatiMacellati, getAzienda().getCuaa(), this.getControlliService())) {

									UtilControlli.controlloRegistrazioneStallaDuplicato(m, this.getControlliService(), this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());
									this.contatoreSanzionati++;
								} else {
									/*
									 * il capo è stato richiesto in pagamento da
									 * più di un soggetto, il capo non può
									 * esserepagato a meno di una rinuncia da
									 * parte di uno dei richiedenti.
									 * 
									 */
									this.motivazione = "il capo e' stato richiesto in pagamento da piu' di un soggetto, il capo non puo' esserepagato a meno di una rinuncia da parte di uno dei richiedenti";
									this.numeroCapiBocciati++;
									this.listaCapiBocciati.add(m);
								}
								}
							} else {
								/*
								 * non e' certificato a denominaizone di origine
								 * protetta o indicazione geografica protetta
								 */
								this.motivazione = "non e' stato certificato a denominazione di origine protetta o indicazione geografica protetta";
								this.numeroCapiBocciati++;
								this.listaCapiBocciati.add(m);
							}
						} else {
							this.motivazione = "il capo non e' stato allevato per un periodo continuativo di almeno 6 mesi";
							this.numeroCapiBocciati++;
							this.listaCapiBocciati.add(m);
						}

					}
//					---------------------------------------------
					if (numeroCapiAmmissibili.compareTo(BigDecimal.ZERO) == 0) {
						System.out.println("ERRORE CALCOLO INTERVENTO 319 MISURA 19, NESSUN CAPO HA SUPERATO IL CONTROLLO PER IL PREMIO");
						throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
								+ " nessun capo ha suprato il controllo per il premio 319 misura 19");
					}

				}
			} catch (ControlloException e) {
				System.out.println("ERRORE CALCOLO INTERVENTO 319 MISURA 19, ERRORE DURANTE L'ESECUZIONE DEL CALCOLO INTERVENTO 319 MISURA 19");
				new Dmt_t_errore(getSessione(), "ClcInt319Mis19", getInput(), e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("ERRORE DURANTE L'ESECUZIONE DEL CALCOLO INTERVENTO 319 MISURA 19, NESSUN CAPO DISPONIBILE");
				throw new ControlloException(
						new Dmt_t_errore(getSessione(), "esecuzione", getInput(), "nessun capo disponibile"));
			}

		} else {

			// GESTIONE CONTROLLI BY DMT_CONTR_LOCO
			for (Dmt_t_contr_loco c : this.estrazioneACampione)
				if ((c.getAnomalie_cgo() == null) || (c.getAnomalie_cgo().indexOf('B') == -1))
					this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
		}
		
		if(1==1)
			System.out.println("CALCOLO INTERVENTO 319 MISURA 19, FINE CALCOLO");

	}

	/**
	 * nel metodo postEsecuzione vengono salvati a db i dati relativi ai capi
	 * ammessi a premio in
	 * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli} e i
	 * dati relativi ai capi non ammessi a premio in
	 * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi}. Dei capi
	 * non ammessi a premio sarà salvata l'informazione di identificazione del
	 * capo, il premio per cui è stata effettuata la richiesta di amissione e la
	 * motivazione per cui risulta non idoneo al premio. Per i capi risultanti
	 * idonei al premio in questione, sarà salvata l'informazione dell'anno
	 * campagna per cui concorrono, il numero di capi ammessi a premio, il cuaa
	 * che ha presentato la domanda e il codice premio.
	 * 
	 * @throws ControlloException
	 *             eccezione relativa al controllo di tipo
	 *             {@link ControlloException}
	 */
	@Override
	public void postEsecuzione() throws ControlloException {
		
		if(1==1)
			System.out.println("CALCOLO INTERVENTO 319 MISURA 19, INIZIO POST-ESECUZIONE");

		if (this.numeroCapiAmmissibili.compareTo(BigDecimal.ZERO) != 0) {
			// SE NON SONO STATI RISCONTRATI ERRORI ALLORA POSSO SALVARE A DB
			// QUI SALVARE
			// SIA I CAPI RICHIESTI CHE I CAPI AMMISSIBILI A PREMIO

			this.oc = new Dmt_t_output_controlli();

			this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
			this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
			this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
			this.oc.setCapiSanzionati(this.contatoreSanzionati);
			this.oc.setCuaa(getAzienda().getCuaa());
			// PERCHE' QUI ENTRANO SOLO LE AZIENDE CON CODICE PREMIO = 319
			this.oc.setIntervento(getAzienda().getCodicePremio());
			this.oc.setIdSessione(getSessione());
			getControlliService().saveOutput(this.oc);
		}

		if (this.numeroCapiBocciati != 0) {
			// SALVATAGGIO A DB DEI CAPI BOCCIATI

			this.outputEsclusi = new Dmt_t_output_esclusi();

			for (Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {
				this.outputEsclusi.setCalcolo("ClcInt319Mis19");
				this.outputEsclusi.setCapoId(x.getCapoId());
				this.outputEsclusi.setIdSessione(getSessione());
				this.outputEsclusi.setMotivazioneEsclusione(this.motivazione);
				this.getControlliService().saveOutputEscl(this.outputEsclusi);
			}
		}
		
		if(1==1)
			System.out.println("CALCOLO INTERVENTO 319 MISURA 19, FINE POST-ESECUZIONE");
		 System.out.println("FINE ESECUZIONE CALCOLO INTERVENTO 319 MISURA 19");
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
	// LocalDate data1 =
	// dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	// LocalDate data2 =
	// dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
//		if (duplicatiMacellati.size() == 2) {
//
//			// se la vacca compare due volte nello stesso allevamento,
//			// controllare chi è il
//			// proprietario e chi è il detentore
//			if (duplicatiMacellati.get(0).getAllevId().equals(duplicatiMacellati.get(1).getAllevId())) {
//
//				allev1 = getControlliService()
//						.getAnagraficaByIdAllevamento(BigDecimal.valueOf(duplicatiMacellati.get(0).getAllevId()));
//
//				// if (((!allev1.getCod_fiscale_deten().equals(null))
//				// &&
//				// (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(0).getCuaa())
//				// &&
//				// allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(1).getCuaa())))
//				// || ((!allev1.getCod_fiscale_deten().equals(null))
//				// &&
//				// (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(1).getCuaa())
//				// &&
//				// allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(0).getCuaa()))))
//				// if(allev1.getCod_fiscale_deten().equals(cuaa))
//				return allev1.getCod_fiscale_deten() != null && allev1.getCod_fiscale_deten().equals(cuaa);
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
			UtilControlli.controlloDocg((Dmt_t_clsCapoMacellato) capo, this.getControlliService()))
				listaCapiDichiarati.add(capo);

		return listaCapiDichiarati.isEmpty() ? Collections.emptyList() : listaCapiDichiarati;
	}
}
