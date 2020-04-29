package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

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
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_SistemiDiEtichettaturaFacoltativa;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;

@Component("ref02_010")
public class ClcInt318Mis19 extends Controllo {

	private List<Dmt_t_clsCapoMacellato> listaCapiMacellati;
	private List<Dmt_t_clsCapoMacellato> duplicatiMacellati;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClcInt318Mis19.class);
	@Autowired
	private CtlUbaMinime ref9903;
	List<Dmt_t_contr_loco> estrazioneACampione;
	private int numeroCapiAmmissibili;
	private int numeroCapiRichiesti;
	Dmt_t_output_controlli oc;
	private Dmt_t_SistemiDiEtichettaturaFacoltativa etic;
	private int numeroCapiBocciati;
	private String motivazione;
	private List<Dmt_t_clsCapoMacellato> listaCapiBocciati;
	private Dmt_t_output_esclusi outputEsclusi;

	public ClcInt318Mis19() {
		this.listaCapiMacellati = null;
		this.estrazioneACampione = null;
		this.numeroCapiAmmissibili = 0;
		this.numeroCapiBocciati = 0;
		this.numeroCapiRichiesti=0;
		this.motivazione = null;
		this.listaCapiBocciati = new ArrayList<>();
		this.outputEsclusi = null;
	}

	@Override
	public void preEsecuzione() throws ControlloException {
		LOGGER.info("inizio preEsecuzione()");
			// CONTROLLO DI PREAMMISSIBILITA' TRASVERSALE
		
		this.listaCapiMacellati = getControlliService().getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		
		ref9903.init(listaCapiMacellati, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());

			try {
				ref9903.calcolo();
			}catch(CalcoloException e) {
				throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
			}
	}

	@Override
	public void esecuzione() throws ControlloException{
		LOGGER.info("inizio esecuzione()");
		
		
			numeroCapiRichiesti = getControlliService()
				.getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()).size();
		
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa());
		
		
		if(this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {
			
			try {
				
				for (Dmt_t_clsCapoMacellato m : this.listaCapiMacellati) {
				
					
					
					this.etic = getControlliService().getSistemaEtichettarua(getAzienda().getCuaa());
					this.duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(), getSessione().getIdSessione(), getAzienda().getCodicePremio());
					
					/*	Sia stato allevato per un periodo continuativo di 6 mesi
					 * 
					 */
					if((m.getDtIngresso() == null || m.getDtUscita() == null) || (this.differenzaMesi(m.getDtIngresso(), m.getDtUscita()) >= 6)) {
					
							/**
							 * Sia stato allevato in conformità a sistemi di etichettatura facoltativa
							 */
							if(this.etic != null && this.etic.getFlagEtichettatura().equals("S")) {
								/**
								 * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il capo non può essere pagato, salvo rinuncia da parte di uno dei richiedenti.
								 * Il premio alla macellazione viene riconosciuto ai proprietari/detentori dei capi macellati ed in caso di richiesta di aiuti da parte di entrambi,
								 * i capi ammissibili sono pagati esclusivamente al detentore
								 */
								if((this.duplicatiMacellati == null || this.duplicatiMacellati.isEmpty()) &&  (m.getDtInizioDetenzione() != null && m.getDtFineDetenzione() == null)) {
									this.numeroCapiAmmissibili++;
					} else {
						/**
						 *  il capo è stato richiesto in pagamento da più di un soggetto, il capo non può esserepagato a meno di una rinuncia da parte di uno dei richiedenti.
						 */
						this.motivazione = "il capo e' stato richiesto in pagamento da piu' di un soggetto, il capo non puo' esserepagato a meno di una rinuncia da parte di uno dei richiedenti";
						this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(m);
					}
					}else {
						/**
						 * le conformità a sistemi di etichettatura facoltativa non rispettati
						 */
						this.motivazione = "le conformita' a sistemi di etichettatura facoltativa non rispettati";
						this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(m);
					}
					} else {
						/**
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
				new Dmt_t_errore(getSessione(), "ref02_010", getInput(), e.getMessage());
			}
			
		} else {
			  // GESTIONE CONTROLLI BY DMT_CONTR_LOCO
			  for(Dmt_t_contr_loco c : this.estrazioneACampione)
				  if(!c.getAnomalie_cgo().contains("B"))
					  this.numeroCapiAmmissibili++;
		}

	}

	@Override
	public void postEsecuzione() throws ControlloException {
		LOGGER.info("inizio postEsecuzione()");

		
			if (this.numeroCapiAmmissibili != 0) {
				LOGGER.info("il numero di capi ammissibili al premio 318 misura 19 per l'azienda "
						+ getAzienda().getCuaa() + "e': " + this.numeroCapiAmmissibili);
				// SE NON SONO STATI RISCONTRATI ERRORI ALLORA POSSO SALVARE A DB QUI SALVARE
				// SIA I CAPI RICHIESTI CHE I CAPI AMMISSIBILI A PREMIO

				this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
				this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
				this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
				this.oc.setCuaa(getAzienda().getCuaa());
				// PERCHE' QUI ENTRANO SOLO LE AZIENDE CON CODICE PREMIO = 318
				this.oc.setIntervento(getAzienda().getCodicePremio());
				this.oc.setSessione(getSessione());
				getControlliService().saveOutput(this.oc);
			}

			if (this.numeroCapiBocciati != 0) {
				// SALVATAGGIO A DB DEI CAPI BOCCIATI
				this.outputEsclusi = new Dmt_t_output_esclusi();
				
				for(Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {
				
					this.outputEsclusi.setCalcolo("ClcInt318Mis19");
					this.outputEsclusi.setCapoId(x.getCapoId());
					this.outputEsclusi.setSessione(getSessione());
					this.outputEsclusi.setIdSessione(getSessione().getIdSessione());
					this.outputEsclusi.setMotivazioneEsclusione(this.motivazione);
					this.getControlliService().saveOutputEscl(this.outputEsclusi);
				}
			}
	}

	private long differenzaMesi(Date dataInizio, Date dataFine) {
		LocalDate data1 = dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate data2 = dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long monthsBetween = ChronoUnit.MONTHS.between(data1, data2);
		return monthsBetween;
	}
}
