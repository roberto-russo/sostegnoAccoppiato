package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlAgnelleDaRimonta;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9902;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;

@Component("ClcInt320Mis6")
/**
 * La classe ClcInt320Mis6 indica i controlli da applicare per il calcolo del premio zootecnia
 * per l’intervento 320 – Misura 6 agnelle da rimonta
 * @author Bcsoft
 *
 */
public class ClcInt320Mis6 extends Controllo {

	/* MODEL DA INIZIALIZZARE PER I CONTROLLI */
	private ResultCtlUbaMinime ubaMin;
	private List<Dmt_t_contr_loco> estrazioneACampione;
	private Dmt_t_anagrafica_allevamenti modelAllevamenti;
	private int numeroCapiAmmissibili;
	private int numeroCapiRichiesti;
	private Dmt_t_output_controlli oc;
	private Rpu_V_pratica_zoote richiestaDetentore;
	private List<Dmt_t_Tws_bdn_du_capi_ovicaprini> capiOvicaprini;
	private List<Dmt_t_premio_capi> capiAmmessiUba;

	@Autowired
	private CtlUbaMinime ref9903;

	@Autowired
	private CtlAgnelleDaRimonta ref9902;

	@Override
	/**
	 * nel metodo preEsecuzione vengono effettuate due operazioni principali. La prima è l'inizializzazione delle variabili di classe.
	 * La seconda è l'esecuzione dei controlli di preammissibilità trasversali. Il risultato di tali controlli pregiudica l'esecuzione
	 * del calcolo stesso. Se l'esecuzione ha esito positivo, allora si può procedere con il calcolo intervento 320 misura 6.
	 * Se l'esecuzione ha esito negativo, allora viene generato un messaggio di errore.
	 */
	public void preEsecuzione() throws ControlloException, CalcoloException {
		this.numeroCapiRichiesti = 0;
		this.estrazioneACampione = null;
		this.numeroCapiAmmissibili = 0;
		this.oc = null;
		this.richiestaDetentore = null;
		this.ubaMin = new ResultCtlUbaMinime();
		this.modelAllevamenti = null;
		this.capiOvicaprini = null;
		this.capiAmmessiUba = null;

		try {

			ref9902.init(getSessione().getIdSessione(), getAzienda().getCodicePremio(),
					Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());

			CapiControllati9902 esito = ref9902.calcolo();

			if (!esito.isEsito())
				// controllare che motivazioni ti da
				throw new CalcoloException(esito.getMotivazioni());

		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9902", getInput(), e.getMessage()));
		}

		this.capiOvicaprini = getControlliService().getOvicapriniBySessioneCuaaCodIntervento(
				getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());

		ref9903.init(this.capiOvicaprini, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()),
				getAzienda().getCuaa(), getSessione());
		try {
			this.ubaMin = ref9903.calcolo();

			if (ubaMin.isErrors())
				throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
			else if (!ubaMin.isResult())
				throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt320Mis6", getInput(),
						"controllo uba minime non rispettato"));

		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		}

		capiAmmessiUba = ubaMin.getListaCapi();

	}

	@Override
	/**
	 * nel metodo esecuzione vengono eseguiti i controlli per il calcolo intervento 320 misura 6.
	 * Se i controlli per il suddetto calcolo risultano essere positivi, allora viene incrementato il contatore di capi ammissibili
	 * e il capo sarà visibile in @see Dmt_t_output_controlli.
	 */
	public void esecuzione() throws ControlloException {

		this.numeroCapiRichiesti = getControlliService().getOvicapriniBySessioneCuaaCodIntervento(
				getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()).size();
		
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa());

		if (this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {

			for (Dmt_t_premio_capi capi : capiAmmessiUba) {

				this.modelAllevamenti = getControlliService().getAllevIdAndSessione(BigDecimal.valueOf(3362330), getSessione().getIdSessione());
//						.getAnagraficaByIdAllevamento(BigDecimal.valueOf(capi.getIdAllevamento()));

				String proprietario = modelAllevamenti.getCodFiscaleProp();
				String detentore = modelAllevamenti.getCod_fiscale_deten();

				if (proprietario.equals(detentore)) {
					if (proprietario.equals(getAzienda().getCuaa())) {
						numeroCapiAmmissibili++;
					}

				} else {
					if (detentore.equals(getAzienda().getCuaa())) {
						numeroCapiAmmissibili++;

					} else {

						richiestaDetentore = getControlliService().getByAnnoCampagnaAndCuaaAndCodicePremio(
								getAzienda().getAnnoCampagna(), detentore, getAzienda().getCodicePremio());

						if (richiestaDetentore == null) {
							numeroCapiAmmissibili++;

						} else if (richiestaDetentore != null) {
							System.out.println("il premio è già stato chiesto dal detentore dell'allevamento");
						}
					}
				}
			}
		} else {
			// verifica controlli in loco
			for (Dmt_t_contr_loco c : this.estrazioneACampione)
				if (!c.getAnomalie_cgo().contains("B"))
					this.numeroCapiAmmissibili++;
		}
	}

	@Override
	/**
	 * nel metodo postEsecuzione vengono salvati a db i dati relativi ai capi ammessi a premio in @see Dmt_t_output_controlli.
	 * Per i capi risultanti idonei al premio in questione, sarà salvata l'informazione dell'anno campagna per cui
	 * concorrono, il numero di capi ammessi a premio, il cuaa che ha presentato la domanda e il codice premio e il numero
	 * dei capi richiesti a premio.
	 */
	public void postEsecuzione() throws ControlloException {

		this.oc = new Dmt_t_output_controlli();
		this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
		this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
		this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
		this.oc.setCuaa(getAzienda().getCuaa());
		this.oc.setIntervento(getAzienda().getCodicePremio());
		this.oc.setIdSessione(getSessione());
		getControlliService().saveOutput(this.oc);
	}

}
