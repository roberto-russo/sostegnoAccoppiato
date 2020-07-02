package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_clsCapoMacellato_services;

/**
 * i controlli da applicare per il calcolo del premio zootecnia per l’intervento 317 – Misura 19:<br>
 * capi bovini macellati di età compresa tra i 12 e 24 mesi aderenti a sistemi di qualità nazionale o regionale
 * e allevati dal richiedente per un periodo non inferiore a sei mesi prima della macellazione.
 * @author Bcsoft
 */
@Component("ClcInt317Mis19")
public class ClcInt317Mis19 extends Controllo {

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
	private CtlUbaMinime ref9903;
	@Autowired
	private Dmt_t_clsCapoMacellato_services capiMacellatiService;
	private int numeroCapiRichiesti;
	private int contatoreBocciati;
	private List<Dmt_t_clsCapoMacellato> listaCapiBocciati;
	private String motivazione;


	/**
	 * nel metodo preEsecuzione vengono effettuate due operazioni principali. La prima è l'inizializzazione delle variabili di classe.
	 * La seconda è l'esecuzione dei controlli di preammissibilità trasversali. Il risultato di tali controlli pregiudica l'esecuzione
	 * del calcolo stesso. Se l'esecuzione ha esito positivo, allora si può procedere con il calcolo intervento 317 misura 19.
	 * Se l'esecuzione ha esito negativo, allora viene generato un messaggio di errore.
	 * Il metodo preEsecuzione utilizza il controllo:<br>
	 * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
	 * @throws ControlloException eccezione relativa al controllo di tipo {@link ControlloException}
	 */
	@Override
	public void preEsecuzione() throws ControlloException {
		this.importoLiquidabile = new BigDecimal(0);
		this.contatoreBocciati = 0;
		this.modelMacellato = null;
		this.oc = null;
		this.numeroCapiRichiesti=0;
		this.estrazioneACampione = null;
		this.listaCapiBocciati = new ArrayList<>();
		this.oe = null;
		this.motivazione = null;
		this.ubaMin = new ResultCtlUbaMinime();
		this.modelMacellatoFiltrato = null;
	
	// controlli di preammissibilità
		
		this.modelMacellato = getControlliService().getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		
		ref9903.init(modelMacellato, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());

		try {
			ubaMin = ref9903.calcolo();
			
			if( ubaMin.isErrors())
				throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
			else
				if(!ubaMin.isResult())
					throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt317Mis19", getInput(), "controllo uba minime non rispettato"));
			
		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		}
		
		this.modelMacellatoFiltrato = capiMacellatiService.getMacellatiUbaMinime(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
	}

	/**
	 * nel metodo esecuzione vengono eseguiti i controlli per il calcolo intervento 317 misura 19.
	 * Se i controlli per il suddetto calcolo risultano essere positivi, allora viene incrementato il contatore di importo liquidabile
	 * e il capo sarà visibile in {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli}. Qualora i capi risultassero non idonei al premio in questione,
	 * verrà incrementato il numero di capi non ammessi a premio e tale capo sarà inserito nella lista di capi non ammessi a premio. 
	 * La lista di capi non ammessi a premio sarà visibile in {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi} .
	 * @throws ControlloException eccezione relativa al controllo di tipo {@link ControlloException}
	 */
	@Override
	public void esecuzione() throws ControlloException{
		
		
			numeroCapiRichiesti = getControlliService()
				.getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()).size();
		
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa(), getAzienda().getAnnoCampagna());
		
		
		if(this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {
			
			try {
				
				for (Dmt_t_clsCapoMacellato m : this.modelMacellatoFiltrato) {
				
					
					
					this.duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(), getSessione().getIdSessione(), getAzienda().getCodicePremio());
					
					/*
					 * 	Sia stato allevato per un periodo continuativo di 6 mesi
					 * 
					 */
					if((m.getDtIngresso() == null || m.getDtUscita() == null) || (UtilControlli.differenzaMesi(m.getDtIngresso(), m.getDtUscita()) >= 6)) {
								/*
								 * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il capo non può essere pagato, salvo rinuncia da parte di uno dei richiedenti.
								 * Il premio alla macellazione viene riconosciuto ai proprietari/detentori dei capi macellati ed in caso di richiesta di aiuti da parte di entrambi,
								 * i capi ammissibili sono pagati esclusivamente al detentore
								 */
								if(flagDuplicatiRichiedenti(duplicatiMacellati, getAzienda().getCuaa())) {
									this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
					} else {
						/*
						 *  il capo è stato richiesto in pagamento da più di un soggetto, il capo non può esserepagato a meno di una rinuncia da parte di uno dei richiedenti.
						 */
						this.motivazione = "il capo e' stato richiesto in pagamento da piu' di un soggetto, il capo non puo' esserepagato a meno di una rinuncia da parte di uno dei richiedenti";
						this.contatoreBocciati++;
						this.listaCapiBocciati.add(m);
					}
					} else {
						/*
						 * il capo non è stato allevato per un periodo minimo di 6 mesi continuativi 
						 */
						
						this.motivazione = "il capo non e' stato allevato per un periodo minimo di 12 mesi continuativi ";
						this.contatoreBocciati++;
						this.listaCapiBocciati.add(m);
					}
				}
					
				if (importoLiquidabile.compareTo(BigDecimal.ZERO) == 0)
					throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
							+ " nessun capo ha suprato il controllo per il premio 317 misura 19");
				
			} catch (ControlloException e) {
		
				System.out.println(e.getMessage());
				new Dmt_t_errore(getSessione(), "ref02_009", getInput(), e.getMessage());
			}
			
		} else {
		 // verifica controlli in loco 
			  for(Dmt_t_contr_loco c : this.estrazioneACampione)
				  if(!c.getAnomalie_cgo().contains("B"))
					  this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
		}

	}

	/**
	 * nel metodo postEsecuzione vengono salvati a db i dati relativi ai capi ammessi a premio in {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli}
	 * e i dati relativi ai capi non ammessi a premio in {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi}.
	 * Dei capi non ammessi a premio sarà salvata l'informazione di identificazione del capo, il premio per cui 
	 * è stata effettuata la richiesta di amissione e la motivazione per cui  risulta non idoneo al premio.
	 * Per i capi risultanti idonei al premio in questione, sarà salvata l'informazione dell'anno campagna per cui
	 * concorrono, il numero di capi ammessi a premio, il cuaa che ha presentato la domanda e il codice premio.
	 * @throws ControlloException eccezione relativa ai controlli di tipo {@link ControlloException}
	 */
	@Override
	public void postEsecuzione() throws ControlloException {

		
			if (this.importoLiquidabile.compareTo(BigDecimal.ZERO) != 0) {
				this.oc = new Dmt_t_output_controlli();
				// salvataggio capi ammissibili
				this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
				this.oc.setCapiAmmissibili(this.importoLiquidabile);
				this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
				this.oc.setCuaa(getAzienda().getCuaa());
				this.oc.setIntervento(getAzienda().getCodicePremio());
				this.oc.setIdSessione(getSessione());
				getControlliService().saveOutput(this.oc);
			}


			if (this.contatoreBocciati != 0) {
				//salvataggio capi esclusi
				this.oe = new Dmt_t_output_esclusi();
				
				for(Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {
				
					this.oe.setCalcolo("ClcInt317Mis19");
					this.oe.setCapoId(x.getCapoId());
					this.oe.setIdSessione(getSessione());
					this.oe.setMotivazioneEsclusione(this.motivazione);
					this.getControlliService().saveOutputEscl(this.oe);
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
//	private long differenzaMesi(Date dataInizio, Date dataFine) {
//		LocalDate data1 = dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		LocalDate data2 = dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		long monthsBetween = ChronoUnit.MONTHS.between(data1, data2);
//		return monthsBetween;
//	}
	
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
		
		else if (duplicatiMacellati.size() == 2) {

			// se la vacca compare due volte nello stesso allevamento, controllare chi è il
			// proprietario e chi è il detentore
			if (duplicatiMacellati.get(0).getAllevId().equals(duplicatiMacellati.get(1).getAllevId())) {

				allev1 = getControlliService()
						.getAnagraficaByIdAllevamento(BigDecimal.valueOf(duplicatiMacellati.get(0).getAllevId()));

				if (((!allev1.getCod_fiscale_deten().equals(null))
						&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(0).getCuaa())
								&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(1).getCuaa())))
						|| ((!allev1.getCod_fiscale_deten().equals(null))
								&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(1).getCuaa())
										&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(0).getCuaa()))))
					if(allev1.getCod_fiscale_deten().equals(cuaa))
						return true;
				
			} 
		} 
			
		return false;
	}
}