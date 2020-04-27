package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;

@Component("ref02_011")
public class ClcInt319Mis19 extends Controllo {

	private List<Dmt_t_clsCapoMacellato> listaCapiMacellati;
	private List<Dmt_t_clsCapoMacellato> duplicatiMacellati;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClcInt318Mis19.class);
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

	public ClcInt319Mis19() {
		this.listaCapiMacellati = null;
		this.duplicatiMacellati = null;
		this.estrazioneACampione = null;
		this.numeroCapiAmmissibili = 0;
		this.oc = null;
		this.numeroCapiAmmissibili = 0;
		this.numeroCapiRichiesti = 0;
		this.certIgpDop = null;
		this.motivazione = null;
		this.listaCapiBocciati = null;
		this.outputEsclusi = null;
	}

	@Override
	public void preEsecuzione() throws ControlloException {
		LOGGER.info("inizio preEsecuzione()");

		this.listaCapiMacellati = getControlliService().getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		
		ref9903.init(listaCapiMacellati, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());

			try {
				ref9903.calcolo();
			}catch(CalcoloException e) {
				throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
			}
	}

	@Override
	public void esecuzione() throws ControlloException {
		LOGGER.info("inizio esecuzione()");

		
		numeroCapiRichiesti = getControlliService()
				.getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()).size();
		
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa());
		
		
		if (this.estrazioneACampione == null) {
			try {
				for (Dmt_t_clsCapoMacellato m : this.listaCapiMacellati) {

					this.duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(),
							getSessione().getIdSessione(), getAzienda().getCodicePremio());
					this.certIgpDop = getControlliService().getCertificatoIgpDop(getAzienda().getCuaa());

					/*
					 * Sia stato allevato per un periodo continuativo di 6 mesi;
					 */
					if ((m.getDtIngresso() == null || m.getDtUscita() == null)
							|| (this.differenzaMesi(m.getDtIngresso(), m.getDtUscita()) >= 6)) {

						/*
						 * Sia certificato a denominazione di origine protetta o indicazione geografica
						 * protetta
						 */
						if ((this.certIgpDop.getFlagDop().equals("S") || this.certIgpDop.getFlagIgp().equals("S"))) {

							/*
							 * Qualora lo stesso capo sia richiesto in pagamento da due soggetti, il capo
							 * non può essere pagato, salvo rinuncia da parte di uno dei richiedenti
							 */
							if (this.duplicatiMacellati == null
									&& (m.getDtInizioDetenzione() != null && m.getDtFineDetenzione() == null)) {

								this.numeroCapiAmmissibili++;
							} else {
								/*
								 * il capo è stato richiesto in pagamento da più di un soggetto, il capo non può
								 * esserepagato a meno di una rinuncia da parte di uno dei richiedenti.
								 */
								this.motivazione = "il capo e' stato richiesto in pagamento da piu' di un soggetto, il capo non puo' esserepagato a meno di una rinuncia da parte di uno dei richiedenti";
								this.numeroCapiBocciati++;
								this.listaCapiBocciati.add(m);
							}

						} else {
							/*
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
				new Dmt_t_errore(getSessione(), "ref02_011", getInput(), e.getMessage());
			}

		} else {

			// GESTIONE CONTROLLI BY DMT_CONTR_LOCO
			for (Dmt_t_contr_loco c : this.estrazioneACampione)
				if (!c.getAnomalie_cgo().contains("B"))
					this.numeroCapiAmmissibili++;
		}

	}

	@Override
	public void postEsecuzione() throws ControlloException {
		LOGGER.info("inizio postEsecuzione()");

		if (this.numeroCapiAmmissibili != 0) {
			LOGGER.info("il numero di capi ammissibili al premio 319 misura 19 per l'azienda " + getAzienda().getCuaa()
					+ "e': " + this.numeroCapiAmmissibili);
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
			for (Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {
				this.outputEsclusi.setCalcolo("ClcInt319Mis19");
				this.outputEsclusi.setCapoId(x.getCapoId());
				this.outputEsclusi.setSessione(getSessione());
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
