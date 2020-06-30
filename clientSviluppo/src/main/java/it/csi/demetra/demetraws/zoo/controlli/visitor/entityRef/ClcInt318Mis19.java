package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_SistemiDiEtichettaturaFacoltativa;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_clsCapoMacellato_services;

/**
 * Il caso d’uso indica i controlli da applicare per il calcolo del premio zootecnia per l’intervento 318 – Misura 19: <br>
 * capi bovini macellati di età compresa tra i 12 e 24 mesi aderenti a sistemi di etichettatura facoltativa riconosciuti
 * e allevati dal richiedente per un periodo non inferiore a sei mesi prima della macellazione.
 * @author Bcsoft
 */
@Component("ClcInt318Mis19")
public class ClcInt318Mis19 extends Controllo {

	private List<Dmt_t_clsCapoMacellato> listaCapiMacellati;
	private List<Dmt_t_clsCapoMacellato> duplicatiMacellati;
	private List<Dmt_t_clsCapoMacellato> listaCapiMacellatiFiltrati;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClcInt318Mis19.class);
	private ResultCtlUbaMinime ubaMin;
	@Autowired
	private CtlUbaMinime ref9903;
	@Autowired
	private Dmt_t_clsCapoMacellato_services capiMacellatiService;
	List<Dmt_t_contr_loco> estrazioneACampione;
	private int numeroCapiAmmissibili;
	private int numeroCapiRichiesti;
	Dmt_t_output_controlli oc;
	private Dmt_t_SistemiDiEtichettaturaFacoltativa etic;
	private int numeroCapiBocciati;
	private String motivazione;
	private List<Dmt_t_clsCapoMacellato> listaCapiBocciati;
	private Dmt_t_output_esclusi outputEsclusi;


	/**
	 * nel metodo preEsecuzione vengono effettuate due operazioni principali. La prima è l'inizializzazione delle variabili di classe.
	 * La seconda è l'esecuzione dei controlli di preammissibilità trasversali. Il risultato di tali controlli pregiudica l'esecuzione
	 * del calcolo stesso. Se l'esecuzione ha esito positivo, allora si può procedere con il calcolo intervento 318 misura 19.
	 * Se l'esecuzione ha esito negativo, allora viene generato un messaggio di errore.
	 * il metodo preEsecuzione utilizza il controllo:<br>
	 * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
	 */
	@Override
	public void preEsecuzione() throws ControlloException {
		this.listaCapiMacellati = null;
		this.estrazioneACampione = null;
		this.numeroCapiAmmissibili = 0;
		this.numeroCapiBocciati = 0;
		this.numeroCapiRichiesti=0;
		this.motivazione = null;
		this.listaCapiBocciati = new ArrayList<>();
		this.outputEsclusi = null;
		this.ubaMin= new ResultCtlUbaMinime();
		this.listaCapiMacellatiFiltrati = null;
		
		LOGGER.info("inizio preEsecuzione()");
			// CONTROLLO DI PREAMMISSIBILITA' TRASVERSALE
		
		this.listaCapiMacellati = getControlliService().getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		
		ref9903.init(listaCapiMacellati, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());

		try {
			ubaMin = ref9903.calcolo();
			
			if( ubaMin.isErrors())
				throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
			else
				if(!ubaMin.isResult())
					throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt318Mis19", getInput(), "controllo uba minime non rispettato"));
			
		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		}
		
		this.listaCapiMacellatiFiltrati = capiMacellatiService.getMacellatiUbaMinime(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
	}

	@Override
	/**
	 * nel metodo esecuzione vengono eseguiti i controlli per il calcolo intervento 318 misura 19.
	 * Se i controlli per il suddetto calcolo risultano essere positivi, allora viene incrementato il contatore di capi ammissibili
	 * e il capo sarà visibile in @see Dmt_t_output_controlli. Qualora i capi risultassero non idonei al premio in questione,
	 * verrà incrementato il numero di capi non ammessi a premio e tale capo sarà inserito nella lista di capi non ammessi a premio. 
	 * La lista di capi non ammessi a premio sarà visibile in @see Dmt_t_output_esclusi.
	 */
	public void esecuzione() throws ControlloException{
		LOGGER.info("inizio esecuzione()");
		
		if(listaCapiMacellatiFiltrati == null)
			return;
		
		
			numeroCapiRichiesti = getControlliService()
				.getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()).size();
		
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa(), getAzienda().getAnnoCampagna());
		
		
		if(this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {
			
			try {
				
				for (Dmt_t_clsCapoMacellato m : this.listaCapiMacellatiFiltrati) {
				
					
					
					this.etic = getControlliService().getSistemaEtichettarua(getAzienda().getCuaa());
					this.duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(), getSessione().getIdSessione(), getAzienda().getCodicePremio());
					
					/*
					 * 	Sia stato allevato per un periodo continuativo di 6 mesi
					 * 
					 */
					if((m.getDtIngresso() == null || m.getDtUscita() == null) || (this.differenzaMesi(m.getDtIngresso(), m.getDtUscita()) >= 6)) {
					
							/*
							 * Sia stato allevato in conformità a sistemi di etichettatura facoltativa
							 */
							if(this.etic != null && this.etic.getFlagEtichettatura().equals("S")) {
								/*
								 * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il capo non può essere pagato, salvo rinuncia da parte di uno dei richiedenti.
								 * Il premio alla macellazione viene riconosciuto ai proprietari/detentori dei capi macellati ed in caso di richiesta di aiuti da parte di entrambi,
								 * i capi ammissibili sono pagati esclusivamente al detentore
								 */
								if(flagDuplicatiRichiedenti(duplicatiMacellati, getAzienda().getCuaa())) {
									this.numeroCapiAmmissibili++;
					} else {
						/*
						 *  il capo è stato richiesto in pagamento da più di un soggetto, il capo non può esserepagato a meno di una rinuncia da parte di uno dei richiedenti.
						 */
						this.motivazione = "il capo e' stato richiesto in pagamento da piu' di un soggetto, il capo non puo' esserepagato a meno di una rinuncia da parte di uno dei richiedenti";
						this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(m);
					}
					}else {
						/*
						 * le conformità a sistemi di etichettatura facoltativa non rispettati
						 */
						this.motivazione = "le conformita' a sistemi di etichettatura facoltativa non rispettati";
						this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(m);
					}
					} else {
						/*
						 * il capo non è stato allevato per un periodo minimo di 6 mesi continuativi 
						 */
						
						this.motivazione = "il capo non e' stato allevato per un periodo minimo di 6 mesi continuativi ";
						this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(m);
					}
				}
					
				if (numeroCapiAmmissibili == 0)
					throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
							+ " nessun capo ha suprato il controllo per il premio 318 misura 19");
				
			} catch (ControlloException e) {
				//GESTIONE DEL FALLIMENTO DELL'ESECUZIONE
				System.out.println(e.getMessage());
				new Dmt_t_errore(getSessione(), "ClcInt318Mis19", getInput(), e.getMessage());
			}
			
		} else {
			  // GESTIONE CONTROLLI BY DMT_CONTR_LOCO
			  for(Dmt_t_contr_loco c : this.estrazioneACampione)
				  if((c.getAnomalie_cgo() == null) || (c.getAnomalie_cgo().indexOf('B') == -1) )
					  this.numeroCapiAmmissibili++;	
		}
	}

	@Override
	/**
	 * nel metodo postEsecuzione vengono salvati a db i dati relativi ai capi ammessi a premio in @see Dmt_t_output_controlli
	 * e i dati relativi ai capi non ammessi a premio in @see Dmt_t_output_esclusi.
	 * Dei capi non ammessi a premio sarà salvata l'informazione di identificazione del capo, il premio per cui 
	 * è stata effettuata la richiesta di amissione e la motivazione per cui  risulta non idoneo al premio.
	 * Per i capi risultanti idonei al premio in questione, sarà salvata l'informazione dell'anno campagna per cui
	 * concorrono, il numero di capi ammessi a premio, il cuaa che ha presentato la domanda e il codice premio.
	 */
	public void postEsecuzione() throws ControlloException {
		LOGGER.info("inizio postEsecuzione()");

		
			if (this.numeroCapiAmmissibili != 0) {
				LOGGER.info("il numero di capi ammissibili al premio 318 misura 19 per l'azienda "
						+ getAzienda().getCuaa() + "e': " + this.numeroCapiAmmissibili);
				// SE NON SONO STATI RISCONTRATI ERRORI ALLORA POSSO SALVARE A DB QUI SALVARE
				// SIA I CAPI RICHIESTI CHE I CAPI AMMISSIBILI A PREMIO
				
				this.oc = new Dmt_t_output_controlli();

				this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
				this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
				this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
				this.oc.setCuaa(getAzienda().getCuaa());
				// PERCHE' QUI ENTRANO SOLO LE AZIENDE CON CODICE PREMIO = 318
				this.oc.setIntervento(getAzienda().getCodicePremio());
				this.oc.setIdSessione(getSessione());
				getControlliService().saveOutput(this.oc);
			}

			if (this.numeroCapiBocciati != 0) {
				// SALVATAGGIO A DB DEI CAPI BOCCIATI
				this.outputEsclusi = new Dmt_t_output_esclusi();
				
				for(Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {
				
					this.outputEsclusi.setCalcolo("ClcInt318Mis19");
					this.outputEsclusi.setCapoId(x.getCapoId());
					this.outputEsclusi.setIdSessione(getSessione());
					this.outputEsclusi.setMotivazioneEsclusione(this.motivazione);
					this.getControlliService().saveOutputEscl(this.outputEsclusi);
				}
			}
	}

//	/**
//	 * nel metodo differenzaMesi viene calcolata la differenza in mesi tra due date
//	 * @param dataInizio per dataInizio si intende la prima data da inserire per poter effettuare il calcolo.
//	 * @param dataFine per dataFine si intende la seconda data da inserire per poter effettuare il calcolo.
//	 * il metodo calcolerà i mesi che intercorrono tra la prima e la seconda data.
//	 * @return monthsBetween il numero di mesi che intercorrono tra le due date inserite. 
//	 */
	private long differenzaMesi(Date dataInizio, Date dataFine) {
		LocalDate data1 = dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate data2 = dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long monthsBetween = ChronoUnit.MONTHS.between(data1, data2);
		return monthsBetween;
	}
	
//	/**
//	 * nel metodo flagDuplicatiRichiedenti viene analizzata la lista dei cuaa che effettuano una richiesta sullo stesso capo.
//	 * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il capo non può essere pagato, salvo rinuncia da parte di uno dei richiedenti. 
//	 * Il premio alla macellazione viene riconosciuto ai proprietari/detentori dei capi macellati ed in caso di richiesta di aiuti da parte di entrambi, 
//	 * i capi ammissibili sono pagati esclusivamente al detentore.
//	 * @param duplicatiMacellati lista delle richieste effettuate sullo stesso capo
//	 * @param cuaa codice fiscale del richiedente analizzato
//	 * @return boolean true se il capo può essere pagato al cuaa analizzato, false altrimenti
//	 */
	private Boolean flagDuplicatiRichiedenti(List<Dmt_t_clsCapoMacellato> duplicatiMacellati, String cuaa) {

		Dmt_t_anagrafica_allevamenti allev1;

		if (duplicatiMacellati.size() == 1 && duplicatiMacellati.get(0).getCuaa().equals(cuaa))
			return true;
		
		if (duplicatiMacellati.size() == 2) {

			// se la vacca compare due volte nello stesso allevamento, controllare chi è il
			// proprietario e chi è il detentore
			if (duplicatiMacellati.get(0).getAllevId().equals(duplicatiMacellati.get(1).getAllevId())) {

				allev1 = getControlliService()
						.getAnagraficaByIdAllevamento(BigDecimal.valueOf(duplicatiMacellati.get(0).getAllevId()));

//				if (((!allev1.getCod_fiscale_deten().equals(null))
//						&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(0).getCuaa())
//								&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(1).getCuaa())))
//						|| ((!allev1.getCod_fiscale_deten().equals(null))
//								&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(1).getCuaa())
//										&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(0).getCuaa()))))
//					if(allev1.getCod_fiscale_deten().equals(cuaa))
						return allev1.getCod_fiscale_deten() != null && allev1.getCod_fiscale_deten().equals(cuaa);
				
			} 
		} 
			
		return false;
	}
}
