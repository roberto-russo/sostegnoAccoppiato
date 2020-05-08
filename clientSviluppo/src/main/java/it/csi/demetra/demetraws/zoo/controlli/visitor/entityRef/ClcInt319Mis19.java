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
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;

@Component("ClcInt319Mis19")
/**
 * Classe per il calcolo intervento 319 misura 19
 * @author Bcsoft
 *
 */
public class ClcInt319Mis19 extends Controllo {

	private List<Dmt_t_clsCapoMacellato> listaCapiMacellati;
	private List<Dmt_t_clsCapoMacellato> duplicatiMacellati;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClcInt319Mis19.class);
	@Autowired
	private CtlUbaMinime ref9903;
	List<Dmt_t_contr_loco> estrazioneACampione;
	private int numeroCapiAmmissibili;
	private int numeroCapiRichiesti; 
	Dmt_t_output_controlli oc;
	private int numeroCapiBocciati;
	Dmt_t_certificato_igp_dop certIgpDop;
	private String motivazione;
	private List<Dmt_t_clsCapoMacellato> listaCapiBocciati;
	private Dmt_t_output_esclusi outputEsclusi;
	private ResultCtlUbaMinime ubaMin;

	@Override
	/**
	 * metodo in cui vengono recuperati i dati, provenienti dalla BDN, dal db e vengono elaborati i controlli massivamente per soggetto
	 */
	public void preEsecuzione() throws ControlloException {
		this.listaCapiMacellati = null;
		this.duplicatiMacellati = null;
		this.estrazioneACampione = null;
		this.numeroCapiAmmissibili = 0;
		this.oc = null;
		this.numeroCapiAmmissibili = 0;
		this.numeroCapiRichiesti = 0;
		this.certIgpDop = null;
		this.motivazione = null;
		this.listaCapiBocciati = new ArrayList<>();
		this.outputEsclusi = null;
		this.ubaMin = new ResultCtlUbaMinime();
		LOGGER.info("inizio preEsecuzione()");

		this.listaCapiMacellati = getControlliService().getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		
		ref9903.init(listaCapiMacellati, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());

		try {
			ubaMin = ref9903.calcolo();
			
			if( ubaMin.isErrors())
				throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
			else
				if(!ubaMin.isResult())
					throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt319Mis19", getInput(), "controllo uba minime non rispettato"));
			
		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		}
	}

	@Override
	/**
	 * metodo in cui vengono eseguiti i controlli per il calcolo intervento 319 misura 19.
	 * Se i controlli per il suddetto calcolo risultano essere positivi, allora viene incrementato il contatore di capi ammissibili
	 * e il capo sarà visibile in @see Dmt_t_output_controlli. Qualora i capi risultassero non idonei al premio in questione,
	 * verrà incrementato il numero di capi non ammessi a premio e tale capo sarà inserito nella lista di capi non ammessi a premio. 
	 * La lista di capi non ammessi a premio sarà visibile in @see Dmt_t_output_esclusi.
	 */
	public void esecuzione() throws ControlloException {
		LOGGER.info("inizio esecuzione()");
		
		if(listaCapiMacellati == null)
			return;

		
		numeroCapiRichiesti = getControlliService()
				.getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()).size();
		
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa());
		
		
		if (this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {
			try {
				for (Dmt_t_clsCapoMacellato m : this.listaCapiMacellati) {

					this.duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(),
							getSessione().getIdSessione(), getAzienda().getCodicePremio());
					this.certIgpDop = getControlliService().getCertificatoIgpDop(getAzienda().getCuaa());

					/**
					 * Sia stato allevato per un periodo continuativo di 6 mesi;
					 */
					if ((m.getDtIngresso() == null || m.getDtUscita() == null)
							|| (this.differenzaMesi(m.getDtIngresso(), m.getDtUscita()) >= 6)) {

						/**
						 * Sia certificato a denominazione di origine protetta o indicazione geografica
						 * protetta
						 */
						if ((this.certIgpDop != null) && (this.certIgpDop.getFlagDop().equals("S") || this.certIgpDop.getFlagIgp().equals("S"))) {

							/**
							 * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il capo
							 * non può essere pagato, salvo rinuncia da parte di uno dei richiedenti.
							 * il capo è stato richiesto in pagamento da più di un soggetto, il capo non può
							 * esserepagato a meno di una rinuncia da parte di uno dei richiedenti.
							 * Il premio alla macellazione viene riconosciuto ai proprietari/detentori dei capi
							 *  macellati ed in caso di richiesta di aiuti da parte di entrambi,
							 * i capi ammissibili sono pagati esclusivamente al detentore
							 */
							if (flagDuplicatiRichiedenti(duplicatiMacellati, getAzienda().getCuaa())) {

								this.numeroCapiAmmissibili++;
							} else {
								/**
								 * il capo è stato richiesto in pagamento da più di un soggetto, il capo non può
								 * esserepagato a meno di una rinuncia da parte di uno dei richiedenti.
								 * 
								 */
								this.motivazione = "il capo e' stato richiesto in pagamento da piu' di un soggetto, il capo non puo' esserepagato a meno di una rinuncia da parte di uno dei richiedenti";
								this.numeroCapiBocciati++;
								this.listaCapiBocciati.add(m);
							}

						} else {
							/**
							 * non e' certificato a denominaizone di origine protetta o indicazione
							 * geografica protetta
							 */
							this.motivazione = "non e' stato certificato a denominazione di origine protetta o indicazione geografica protetta";
							this.numeroCapiBocciati++;
							this.listaCapiBocciati.add(m);
						}
					} else {
						this.motivazione = "iil capo non e' stato allevato per un periodo continuativo di almeno 6 mesi";
						this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(m);
					}

				}
				if (numeroCapiAmmissibili == 0)
					throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
							+ " nessun capo ha suprato il controllo per il premio 319 misura 19");

			} catch (ControlloException e) {
				System.out.println(e.getMessage());
				new Dmt_t_errore(getSessione(), "ClcInt319Mis19", getInput(), e.getMessage());
			}

		} else {

			// GESTIONE CONTROLLI BY DMT_CONTR_LOCO
			for (Dmt_t_contr_loco c : this.estrazioneACampione)
				if ((c.getAnomalie_cgo() == null) || (c.getAnomalie_cgo().indexOf('B') == -1))
					this.numeroCapiAmmissibili++;
		}

	}

	@Override
	/**
	 * metodo in cui vengono salvati a db i dati relativi ai capi ammessi a premio in @see Dmt_t_output_controlli
	 * e i dati relativi ai capi non ammessi a premio in @see Dmt_t_output_esclusi.
	 * Dei capi non ammessi a premio sarà salvata l'informazione di identificazione del capo, il premio per cui 
	 * è stata effettuata la richiesta di amissione e la motivazione per cui  risulta non idoneo al premio.
	 * Per i capi risultanti idonei al premio in questione, sarà salvata l'informazione dell'anno campagna per cui
	 * concorrono, il numero di capi ammessi a premio, il cuaa che ha presentato la domanda e il codice premio.
	 */
	public void postEsecuzione() throws ControlloException {
		LOGGER.info("inizio postEsecuzione()");

		if (this.numeroCapiAmmissibili != 0) {
			LOGGER.info("il numero di capi ammissibili al premio 319 misura 19 per l'azienda " + getAzienda().getCuaa()
					+ "e': " + this.numeroCapiAmmissibili);
			// SE NON SONO STATI RISCONTRATI ERRORI ALLORA POSSO SALVARE A DB QUI SALVARE
			// SIA I CAPI RICHIESTI CHE I CAPI AMMISSIBILI A PREMIO

			this.oc = new Dmt_t_output_controlli();
			
			this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
			this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
			this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
			this.oc.setCuaa(getAzienda().getCuaa());
			// PERCHE' QUI ENTRANO SOLO LE AZIENDE CON CODICE PREMIO = 319
			this.oc.setIntervento(getAzienda().getCodicePremio());
			this.oc.setSessione(getSessione());
			getControlliService().saveOutput(this.oc);
		}

		if (this.numeroCapiBocciati != 0) {
			// SALVATAGGIO A DB DEI CAPI BOCCIATI
			
			this.outputEsclusi = new Dmt_t_output_esclusi();
			
			for (Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {
				this.outputEsclusi.setCalcolo("ClcInt319Mis19");
				this.outputEsclusi.setCapoId(x.getCapoId());
				this.outputEsclusi.setSessione(getSessione());
				this.outputEsclusi.setMotivazioneEsclusione(this.motivazione);
				this.getControlliService().saveOutputEscl(this.outputEsclusi);
			}
		}
	}

	/**
	 * metodo in cui viene calcolata la differenza in mesi tra due date
	 * @param dataInizio per dataInizio si intende la prima data da inserire per poter effettuare il calcolo.
	 * @param dataFine per dataFine si intende la seconda data da inserire per poter effettuare il calcolo.
	 * il metodo calcolerà i mesi che intercorrono tra la prima e la seconda data.
	 * @return monthsBetween il numero di mesi che intercorrono tra le due date inserite. 
	 */
	private long differenzaMesi(Date dataInizio, Date dataFine) {
		LocalDate data1 = dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate data2 = dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long monthsBetween = ChronoUnit.MONTHS.between(data1, data2);
		return monthsBetween;
	}
	
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
