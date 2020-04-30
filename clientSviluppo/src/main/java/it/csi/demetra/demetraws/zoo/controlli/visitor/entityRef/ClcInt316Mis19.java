package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeInternalException_Exception;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;

@Component("ClcInt316Mis19")
/**
 * Calcolo REF02.008 intervento 316 Misura 19
 * 
 * @vesion 0.1 (23/04/2020)
 * @author Bcsoft
 *
 */
public class ClcInt316Mis19 extends Controllo {

	/* MODEL DA INIZIALIZZARE PER I CONTROLLI */
	private List<Dmt_t_clsCapoMacellato> modelMacellato;
	private int importoLiquidabile = 0;
	private List<Dmt_t_clsCapoMacellato> duplicatiMacellati;
	private Dmt_t_output_controlli oc;
	private List<Dmt_t_contr_loco> estrazioneACampione;
	private Dmt_t_output_esclusi oe;
	private ResultCtlUbaMinime ubaMin;
	
	@Autowired
	private CtlUbaMinime ref9903;
	private int numeroCapiBocciati;
	private List<Dmt_t_clsCapoMacellato> listaCapiBocciati;
	private String motivazione;
	long numeroMesi = 0;


	/**
	 * Metodo di calcolo di numero mesi tra date
	 */
	public long differenzaMesi(Date dataInizio, Date dataFine) {
		LocalDate data1 = dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate data2 = dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long monthsBetween = ChronoUnit.MONTHS.between(data1, data2);
		return monthsBetween;
	}

	@Override
	public void preEsecuzione() throws ControlloException {
		this.importoLiquidabile = 0;
		this.numeroCapiBocciati = 0;
		this.modelMacellato = null;
		this.oc = null;
		this.estrazioneACampione = null;
		this.listaCapiBocciati = new ArrayList<>();
		this.oe = null;
		this.motivazione = null;
		this.numeroMesi = 0;
		this.ubaMin = new ResultCtlUbaMinime();

		/**
		 * RECUPERO DATI DALLA BDN
		 */
		modelMacellato = getControlliService().getAllMacellatiSessioneCuua(getSessione(), getAzienda().getCuaa(),
				getAzienda().getCodicePremio());

		/**
		 * passaggio dati attraverso il controllo di ammissibilità REF_9903
		 */
		ref9903.init(this.modelMacellato, getAzienda().getCodicePremio(),
				Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());

		try {
			ubaMin = ref9903.calcolo();
			
			if( ubaMin.isErrors())
				throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
			else
				if(!ubaMin.isResult())
					throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt322Mis20", getInput(), "controllo uba minime non rispettato"));
			
		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		}

	}

	@Override
	public void esecuzione() throws ControlloException {

		/**
		 * if con la condizione se è estratto a campione
		 */
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa());
		if (this.estrazioneACampione == null || estrazioneACampione.isEmpty()) {

			try {
				for (Dmt_t_clsCapoMacellato m : modelMacellato) {

					duplicatiMacellati = getControlliService().getDuplicati(m.getCapoId(),
							getSessione().getIdSessione(), getAzienda().getCodicePremio());

					/**
					 * Qualora lo stesso capo sia richiesto in pagamento da due
					 * soggetti, il capo non può essere pagato, salvo rinuncia
					 * da parte di uno dei richieden
					 */
					if (duplicatiMacellati == null && (m.getDtInizioDetenzione() != null && m.getDtFineDetenzione() == null) && duplicatiMacellati.isEmpty()) {

						/**
						 * calcolo sul numero di mesi continuativi in
						 * allevamento effettuati dal capo
						 */
						numeroMesi = differenzaMesi(m.getDtIngresso(), m.getDtUscita());
						if ((m.getDtIngresso() == null || m.getDtUscita() == null) || (numeroMesi >= 12)) {
							importoLiquidabile++;

						} else
							/**
							 * il capo non è stato allevato per un periodo
							 * minimo di 6 mesi continuativi
							 */
							this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(m);
						this.motivazione = "Il capo " + m.getCapoId()
								+ " non ha effettuato un periodo continuativo in allevamento superiore a 12 mesi  ";
					} else {
						/**
						 * il capo è stato richiesto in pagamento da più di un
						 * soggetto, il capo non può esserepagato a meno di una
						 * rinuncia da parte di uno dei richiedenti.
						 */
						this.motivazione = "il capo e' stato richiesto in pagamento da piu' di un soggetto";
						this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(m);
					}

				}
				if (importoLiquidabile == 0)
					throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
							+ " nessun capo ha suprato il controllo per il premio 316 misura 19");

			} catch (ControlloException e) {
				System.out.println(e.getMessage());
				new Dmt_t_errore(getSessione(), "ref02_008", getInput(), e.getMessage());

			}
		} else {
			/**
			 * dal controllo a campione si evince che il capo preso a campione è
			 * ammissibile a premio
			 */
			for (Dmt_t_contr_loco c : estrazioneACampione) {
				if (!c.getAnomalie_cgo().contains("B")) {
					importoLiquidabile++;

				}
			}
		}
	}

	@Override
	public void postEsecuzione() throws ControlloException {

		try {
			/**
			 * aggiunta informazioni capi accettabili al
			 * model @Dmt_t_output_controlli
			 */
			if (importoLiquidabile != 0) {
				System.out.println("REF02.008 numero capi ammissibili = " + importoLiquidabile + " azienza con cuaa "
						+ getAzienda().getCuaa());
				oc.setSessione(this.getSessione());
				oc.setCuaa(getAzienda().getCuaa());
				oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
				oc.setIntervento(getAzienda().getCodicePremio());
				oc.setCapiRichiesti(modelMacellato.size());
				oc.setCapiAmmissibili(importoLiquidabile);

				getControlliService().saveOutput(oc);

			} else {
				throw new ControlloException(
						"impossibile salvare a db, nessun capo ha superato il controllo per il premio 316 misura 19");
			}

		} catch (ControlloException e) {
			System.out.println(e.getMessage());
		}

		if (this.numeroCapiBocciati != 0) {

			/**
			 * aggiunta informazioni capi esclusi al model @Dmt_t_output_esclusi
			 */
			this.oe = new Dmt_t_output_esclusi();

			for (Dmt_t_clsCapoMacellato x : this.listaCapiBocciati) {

				this.oe.setCalcolo("ClcInt316Mis19");
				this.oe.setCapoId(x.getCapoId());
				this.oe.setSessione(getSessione());
				this.oe.setIdSessione(getSessione().getIdSessione());
				this.oe.setMotivazioneEsclusione(this.motivazione);
				this.getControlliService().saveOutputEscl(this.oe);
			}
		}

	}
}