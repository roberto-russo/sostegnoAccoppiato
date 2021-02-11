package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlAgnelleDaRimonta;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9902;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.util.DEMETRAWSConstants;

/**
 * La classe ClcInt320Mis6 indica i controlli da applicare per il calcolo del
 * premio zootecnia per l’intervento 320 – Misura 6:<br>
 * agnelle da rimonta
 * 
 * @author Bcsoft
 */
@Component("ClcInt320Mis6")
public class ClcInt320Mis6 extends Controllo {

	protected static final Logger logger = Logger.getLogger(DEMETRAWSConstants.LOGGING.LOGGER_NAME + ".zoo");
	
	
	/* MODEL DA INIZIALIZZARE PER I CONTROLLI */
	private ResultCtlUbaMinime ubaMin;
	private List<Dmt_t_contr_loco> estrazioneACampione;
	private Dmt_t_anagrafica_allevamenti modelAllevamenti;
	private BigDecimal numeroCapiAmmissibili;
	private BigDecimal numeroCapiRichiesti;
	private Integer capiSanzionati;
	private Dmt_t_output_controlli oc;
	private Rpu_V_pratica_zoote richiestaDetentore;
	private List<Dmt_t_premio_capi> capiAmmessiUba;
	private List<Dmt_t_Tws_bdn_du_capi_ovicaprini> modelOvicaprini;

	@Autowired
	private CtlUbaMinime ref9903;

	@Autowired
	private CtlAgnelleDaRimonta ref9902;

	/**
	 * nel metodo preEsecuzione vengono effettuate due operazioni principali. La
	 * prima è l'inizializzazione delle variabili di classe. La seconda è
	 * l'esecuzione dei controlli di preammissibilità trasversali. Il risultato di
	 * tali controlli pregiudica l'esecuzione del calcolo stesso. Se l'esecuzione ha
	 * esito positivo, allora si può procedere con il calcolo intervento 320 misura
	 * 6. Se l'esecuzione ha esito negativo, allora viene generato un messaggio di
	 * errore. il metodo preEsecuzione esegue i controlli: <br>
	 * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlAgnelleDaRimonta} e
	 * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void preEsecuzione() throws ControlloException, CalcoloException {
		logger.info("INIZIO CALCOLO INTERVENTO 320 MISURA 6");
		if(logger.isDebugEnabled())
			logger.debug("CALCOLO INTERVENTO 320 MISURA 6, INIZIO PRE-ESECUZIONE");
		
		this.numeroCapiRichiesti = BigDecimal.ZERO;
		this.estrazioneACampione = null;
		this.numeroCapiAmmissibili = new BigDecimal(0);
		this.oc = null;
		this.richiestaDetentore = null;
		this.ubaMin = new ResultCtlUbaMinime();
		this.modelAllevamenti = null;
		this.capiAmmessiUba = null;
		this.capiSanzionati = 0;
		
		try {

			// CALCOLO TRASVERSALE REF9902

			this.modelOvicaprini = this.controlloCapiDichiarati(
					getControlliService().getOvicapriniBySessioneCuaaCodIntervento(getSessione().getIdSessione(),
							getAzienda().getCuaa(), getAzienda().getCodicePremio()));
			ref9902.init(getSessione().getIdSessione(), getAzienda().getCodicePremio(),
					Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());

			CapiControllati9902 esito = ref9902.calcolo();

			if (!esito.isEsito()) {
				// controllare che motivazioni ti da
				logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, ERRORE DURANTE IL CALCOLO AGNELLE DA RIMONTA REF99.02");
				throw new CalcoloException(esito.getMotivazioni());
			}

		} catch (CalcoloException e) {
			logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, ERRORE DURANTE IL CALCOLO ANGELLE DA RIMONTA REF99.02");
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9902", getInput(), e.getMessage()));
		}

		// CALCOLO TRASVERSALE 9903

		ref9903.init(this.modelOvicaprini, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()),
				getAzienda().getCuaa(), getSessione());
		try {
			this.ubaMin = ref9903.calcolo();

			if (ubaMin.isErrors()) {
				logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, ERRORE DURANTE L'ESECUZIONE DEL CONTROLLO DELLE UBA MINIME");
				throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
			}
			else if (!ubaMin.isResult()) {
				logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, CONTROLLO UBA MINIME NON RISPETTATO");
				throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt320Mis6", getInput(),
						"controllo uba minime non rispettato"));
				}

		} catch (CalcoloException e) {
			logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, ERRORE DURANTE L'ESECUZIONE DEI CONTROLLI AMMISSIBILITA' TRASVERSALI REF99.03");
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		}

		// LISTA DI CAPI AMMESSI

		capiAmmessiUba = ubaMin.getListaCapi();
		if(logger.isDebugEnabled())
			logger.debug("CALCOLO INTERVENTO 320 MISURA 6, FINE PRE-ESECUZIONE");
		logger.info("I CONTROLLI DI PRE-CALCOLO PER IL CALCOLO INTERVENTO 320 MISURA 6 SONO STATI ESEGUITI CORRETTAMENTE ✔");

	}

	/**
	 * nel metodo esecuzione vengono eseguiti i controlli per il calcolo intervento
	 * 320 misura 6. Se i controlli per il suddetto calcolo risultano essere
	 * positivi, allora viene incrementato il contatore di capi ammissibili e il
	 * capo sarà visibile in
	 * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli}.
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void esecuzione() throws ControlloException {
		
		if(logger.isDebugEnabled())
			logger.debug("CALCOLO INTERVENTO 320 MISURA 6, INIZIO ESECUZIONE");

//		SIZE DI UNA SELECT * DALLA TABELLA OVICAPRINI IN BASE ALLA SESSIONE, CUAA E CODICE PREMIO DEL RICHIEDENTE CHE SERVE ADAVERE IL NUMERO DI CAPI RICHIESTI
		this.numeroCapiRichiesti = BigDecimal.valueOf(this.modelOvicaprini.size());

//		QUERY SULLA TABELLA DELL'ESTRAZIONE A CAMPIONE "DMT_T_CONTR_LOCO"
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa(),
				getAzienda().getAnnoCampagna());

		if (this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {

			try {
				for (Dmt_t_premio_capi capi : capiAmmessiUba) {

//				CUAA DETENTORE

					String detentore = getControlliService().getCodFiscaleDetenByAziendaCodiceAndIdSessione(
							capi.getCodiceAzienda(), this.getSessione().getIdSessione());

//				CUAA PROPRIETARIO
					String proprietario = capi.getCuaa();

					// SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CAA
					
					if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
							this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), capi.getIdCapo(),
							this.getControlliService())) {

						this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);

					} else {

						// ALTRIMENTI SI PROCEDE ALLA DETERMINAZIONE DEL BENEFICIARIO DEL CAPO DOPPIO IN
						// MANIERA CLASSICA

						if (detentore != null && !detentore.isEmpty()) {

//				SE CUAA DETENTORE E CUAA PROPRIETARIO COINCIDONO IL CONTATORE INCREMENTA
							if (proprietario.equals(detentore)) {
								if (proprietario.equals(getAzienda().getCuaa())) {
									numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
								}

//					SE CUAA DETENTORE E CUAA PROPRIETARIO NON COINCIDONO
							} else {

//					VIENE CONTROLLATO SE IL RICHIEDENTE È IL DENTENTORE
								if (detentore.equals(getAzienda().getCuaa())) {
									numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);

//					SE IL RICHIEDENTE NON È DETENTORE
								} else {

//						QUERY SU RPU_V_PRATICA_ZOOTE CHE CONTROLLA SE LA RICHIESTA È GIÀ STATA FATTA DAL DETENTORE
									richiestaDetentore = getControlliService().getByAnnoCampagnaAndCuaaAndCodicePremio(
											getAzienda().getAnnoCampagna(), detentore, getAzienda().getCodicePremio());

//						SE NON TROVA VALORI NELLA TABELLA 
									if (richiestaDetentore == null) {
										numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);

//							SE TROVA TROVA VALORI
									} else {

//							DA CONTROLLARE SE DEVE FARE ALTRO
										if(logger.isDebugEnabled())
											logger.debug("CALCOLO INTERVENTO 320 MISURA 6, IL PREMIO E' GIA' STATO CHIESTO DAL DETENTORE DELL'ALLEVAMENTO");
									}
								}
							}
						} else {
							logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, ERRORE CUAA PROPRIETARIO/CUAA DETENTORE NON TROVATO");
							new Dmt_t_errore(this.getSessione(), this.getClass().getSimpleName(), "",
									"errore, cuaa proprietario o cuaa detentore non trovato");
						}
					}
				}
				if (numeroCapiAmmissibili.compareTo(BigDecimal.ZERO) == 0) {
					logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, NESSUN CAPO HA SUPERATO IL CONTROLLO PER IL PREMIO");
					throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
							+ " nessun capo ha suprato il controllo per il premio 320 misura 6");
				}

			} catch (ControlloException e) {
				// GESTIONE DEL FALLIMENTO DELL'ESECUZIONE
				logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, ERRORE DURANTE L'ESECUZIONE DEL CALCOLO PER L'INTERVENTO 320 MISURA 6");
				new Dmt_t_errore(getSessione(), "ClcInt320Mis6", getInput(), e.getMessage());
			} catch (NullPointerException e) {
				logger.error("ERRORE CALCOLO INTERVENTO 320 MISURA 6, NESSUN CAPO DISPONIBILE");
				throw new ControlloException(
						new Dmt_t_errore(getSessione(), "esecuzione", getInput(), "nessun capo disponibile"));
			}
		}

		else {
			// verifica controlli in loco
			for (Dmt_t_contr_loco c : this.estrazioneACampione)
				if (!c.getAnomalie_cgo().contains("B"))
					this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
		}
		
		if(logger.isDebugEnabled())
			logger.debug("CALCOLO INTERVENTO 320 MISURA 6, FINE ESECUZIONE");
	}

	/**
	 * nel metodo postEsecuzione vengono salvati a db i dati relativi ai capi
	 * ammessi a premio in
	 * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli}. Per i capi
	 * risultanti idonei al premio in questione, sarà salvata l'informazione
	 * dell'anno campagna per cui concorrono, il numero di capi ammessi a premio, il
	 * cuaa che ha presentato la domanda e il codice premio e il numero dei capi
	 * richiesti a premio.
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void postEsecuzione() throws ControlloException {
		// SALVATAGGIO IN TABELLA OUTPUT CONTROLLI
		if(logger.isDebugEnabled())
			logger.debug("CALCOLO INTERVENTO 320 MISURA 6, INIZIO POST-ESECUZIONE");
		this.oc = new Dmt_t_output_controlli();
		this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
		this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
		this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
		this.oc.setCapiSanzionati(capiSanzionati);
		this.oc.setCuaa(getAzienda().getCuaa());
		this.oc.setIntervento(getAzienda().getCodicePremio());
		this.oc.setIdSessione(getSessione());
		getControlliService().saveOutput(this.oc);
		
		if(logger.isDebugEnabled())
			logger.debug("CALCOLO INTERVENTO 320 MISURA 6, FINE POST-ESECUZIONE");
		logger.info("FINE ESECUZIONE CALCOLO INTERVENTO 320 MISURA 6");
	}

	@Override
	public <T> List<T> controlloCapiDichiarati(List<T> capiBDN) {

		return Collections.emptyList();
	}

}
