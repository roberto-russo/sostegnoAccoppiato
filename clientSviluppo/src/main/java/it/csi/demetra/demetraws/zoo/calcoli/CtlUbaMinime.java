package it.csi.demetra.demetraws.zoo.calcoli;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9903;
import it.csi.demetra.demetraws.zoo.calcoli.entity.Capo9903;
import it.csi.demetra.demetraws.zoo.calcoli.entity.Ref;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.interfaces.RefInterface;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_ControlloUbaMinime;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_AgnelleRimonta_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_ControlloUbaMinime_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_premio_capi_services;
import it.csi.demetra.demetraws.zoo.shared.Constants;
import it.csi.demetra.demetraws.zoo.util.LocalDateConverter;


@Service
public class CtlUbaMinime extends Ref implements RefInterface<ResultCtlUbaMinime>, Calcolo{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CtlUbaMinime.class);
	
	private static final Double UBA_100 = 1.0;
	
	private static final Double UBA_75 = 0.75;

	private static final Double UBA_60 = 0.6;
	
	private static final Double UBA_35 = 0.35;

	private static final Double UBA_15 = 0.15;
	
	private static final Double UBA = 3.0;
	
	private Double ubaMinime = 0.0;
	
	private List<?> listaCapi = null;

	private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiVacche = null;
	
	private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiVaccheEscluse = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
	
	private List<Dmt_t_clsCapoMacellato> listaCapiMacellati = null;
	
	private List<Dmt_t_Tws_bdn_du_capi_ovicaprini> listaCapiOvicaprini = null;
	
	@Autowired
	private Dmt_t_AgnelleRimonta_services capiOvicapriniService;
	
	@Autowired
	Dmt_t_premio_capi_services capiAmmessiServices;
	
	@Autowired
	Dmt_t_ControlloUbaMinime_services ref9903Services;
	
	Dmt_t_ControlloUbaMinime model = new Dmt_t_ControlloUbaMinime();
	
	List<Dmt_t_premio_capi> listaCapiResult = new ArrayList<Dmt_t_premio_capi>();
	
	private static final List<String> PREMI = Arrays.asList(new String[]{Constants.PREMIO_310,Constants.PREMIO_311,Constants.PREMIO_312,
																		 Constants.PREMIO_313,Constants.PREMIO_314,Constants.PREMIO_315,
																		 Constants.PREMIO_316,Constants.PREMIO_317,Constants.PREMIO_318,
																		 Constants.PREMIO_319,Constants.PREMIO_320,Constants.PREMIO_322});
	
	private static final List<String> PREMI_BOV_LATTE_CARNE = Arrays.asList(new String[]{Constants.PREMIO_310,Constants.PREMIO_311,Constants.PREMIO_312,Constants.PREMIO_313,Constants.PREMIO_314,Constants.PREMIO_322});
		
	private static final List<String> PREMI_BOV_MACELLATI = Arrays.asList(new String[]{Constants.PREMIO_315,Constants.PREMIO_316,Constants.PREMIO_317,Constants.PREMIO_318,Constants.PREMIO_319});
	
	private static final List<String> PREMI_OVICAPRINI_AGNELLE = Arrays.asList(new String[]{Constants.PREMIO_320});
	
	private static final List<String> PREMI_CON_LIMITI = Arrays.asList(new String[]{Constants.PREMIO_310,Constants.PREMIO_311,Constants.PREMIO_312,
																		   Constants.PREMIO_313,Constants.PREMIO_314,Constants.PREMIO_322});
	
	private CapiControllati9903 capiControllati = new CapiControllati9903();
	
	private boolean metodoEseguitoCorrettamente;

	private boolean initEseguitaCorrettamente;
	
	private boolean salvataggioEseguitoCorrettamente = true;
	
	private Double quotaCapiPremio;
	
	private boolean response;
	
	private Dmt_t_sessione sessione;
	
	private ResultCtlUbaMinime resultCtlUbaMinime = new ResultCtlUbaMinime();

	private boolean preesecuzioneEseguitaCorrettamente = true;
	
	public void init(List<?> listaCapi, String codIntervento,Long annoCampagna, String cuaa, Dmt_t_sessione sessione) {
		if( listaCapi!=null && sessione!=null && codIntervento!=null && annoCampagna!=null && cuaa!=null ){
			if( !listaCapi.isEmpty() ) {
						
				this.listaCapi = listaCapi;		
				setCodIntrervento(codIntervento);
				setAnnoCampagna(annoCampagna);
				setCuaa(cuaa);
				setIdSessione(sessione.getIdSessione());
				this.sessione = sessione;
				initEseguitaCorrettamente = true;
				
			} else {
				
				initEseguitaCorrettamente = false;
				
			}
			
		} else {

			initEseguitaCorrettamente = false;
			
		}
	}

	/**
	 * CONTROLLI AMMISSIBILITÀ TRASVERSALI
	 * 
	 * Il Calcolo esegue:
	 * 
	 * -preEsecuzione() in cui si associa il corretto tipo di lista passata dall'utente
	 * -esecuzione() in cui si esegue il calcolo effettivo
	 * -postEsecuzione() in cui si controlla l'esito del calcolo e lo si salva su DB
	 * 
	 * Il metodo ritorna un oggetto contenente due booleani:
	 * - response true uba raggiunte - false uba non raggiunte
	 * - errors true se ci sono stati errori - false altrimenti
	 * 
	 * @return resultCtlUbaMinime
	 * @throws CalcoloException 
	 */
	@Override
	public ResultCtlUbaMinime calcolo() throws CalcoloException {
		
		LOGGER.info("Inizio Calcolo 9903: calcolo() ");
		
		try {
			if(initEseguitaCorrettamente) {
				preEsecuzione();
				if(preesecuzioneEseguitaCorrettamente) {
					esecuzione();
				}
			}
			postEsecuzione();
			
		} catch (CalcoloException e) {
			
			LOGGER.error("Errore Calcolo 9903: ",e);
			
		}
		
		resultCtlUbaMinime.setResult(response);
		resultCtlUbaMinime.setErrors(!initEseguitaCorrettamente|| !preesecuzioneEseguitaCorrettamente || !metodoEseguitoCorrettamente || !salvataggioEseguitoCorrettamente);
		return resultCtlUbaMinime;
	}
	
	/**
	 * CALCOLO UBA
	 * Si calcolano le UBA secondo le disposizioni del D.A.
	 * Dopo aver recuperato i dati della BDN
	 * Si calcolano le uba minime
	 * 
	 * Se l'esecuzione non presenta problemi: return true
	 * Se ci sono stati errori durante l'esecuzione: return false
	 * 
	 * @return true/false
	 * 
	 * */
	private boolean calcoloUBA() {
			
			LOGGER.info("Inizio Calcolo 9903: calcoloUBA() ");
			
			try {
				
				if (getCodIntrervento() != null && PREMI.contains(getCodIntrervento())) {
					
					if (PREMI_BOV_LATTE_CARNE.contains(getCodIntrervento())) {
						if(!listaCapiVacche.isEmpty()) {
							ubaMinime += listaCapiVacche.size()*UBA_100;
						} else {
							LOGGER.info("Fine Calcolo UBA : Tutti i capi richiesti sono stati esclusi dal premio "+getCodIntrervento()+".");
						}
					} else if (PREMI_BOV_MACELLATI.contains(getCodIntrervento())) {
						ubaMinime += listaCapiMacellati.size()*UBA_60;
					} else if (PREMI_OVICAPRINI_AGNELLE.contains(getCodIntrervento())) {
						ubaMinime += quotaCapiPremio*UBA_15;
					}
						
				} else {
					
					LOGGER.error("Errore nel Calcolo UBA : Il codice intervento "+getCodIntrervento()+" è errato.");
					throw new CalcoloException ("Errore nel Calcolo UBA : Il codice intervento "+getCodIntrervento()+" è errato.");
					
					
				}
				
				controlloUBA();
				LOGGER.info("Fine Calcolo 9903: calcoloUBA() ");
				return true;
				
			} catch (Exception e) {
				LOGGER.error("Errore Calcolo 9903: - ",e);
				return false;
			}
		
	}
	
	
	/**
	 * Si controlla l'esito del calcolo
	 * e si settano i parametri esito e motivazioneCalcolo
	 * */
	private void controlloUBA() {
		LOGGER.info("Inizio Controllo UBA: controlloUBA() ");
		if(ubaMinime >= UBA) {
			CapiControllati9903.setEsito(true);
			CapiControllati9903.setMotivazioneEsitoCalcolo("Si è raggiunto il numero necessario di UBA per accedere al premio");
		} else {
			CapiControllati9903.setEsito(false);
			CapiControllati9903.setMotivazioneEsitoCalcolo("Non si è raggiunto il numero necessario di UBA per accedere al premio");
		}
		LOGGER.info("Fine Controllo UBA: controlloUBA() ");
	}
	
	/**
	 * Metodo preEsecuzione()
	 * 
	 * In questo metodo si associa la corretta tipologia di lista,
	 * in base al codice intervento richiesto.
	 * 
	 * */
	@Override
	public void preEsecuzione() throws CalcoloException {
		
		LOGGER.info("Inizio Preesecuzione : preEsecuzione() ");
	
		
		if ( listaCapi != null && !listaCapi.isEmpty() ) {
			
			
			if (getCodIntrervento() != null && PREMI.contains(getCodIntrervento())) {
				
				if( PREMI_BOV_LATTE_CARNE.contains(getCodIntrervento()) ) {
					
					this.listaCapiVacche = (List<Dmt_t_Tws_bdn_du_capi_bovini>) listaCapi;
					
					
					
					if(PREMI_CON_LIMITI.contains(getCodIntrervento())) {
						
						LocalDate oggi = LocalDate.now();
						Period period;
						
						if (listaCapiVacche != null && !listaCapiVacche.isEmpty()) {
							
							setListaCapi9903(listaCapiVacche);
							
							for (Capo9903 capo: capiControllati.getListaCapi9903()) {
								LocalDate dataNascita;
								if( capo.getCapo().getDataNascita() != null ) {
									dataNascita = LocalDateConverter.convertToLocalDateViaInstant(capo.getCapo().getDataNascita());
									period = Period.between(dataNascita, oggi);
									if( (period.getMonths()+period.getYears()*12) < 20 || period.getYears() > 18) {
										listaCapiVacche.remove(capo.getCapo());
										listaCapiVaccheEscluse.add(capo.getCapo());
										capo.setFlagCapoAmmesso("N");
										Dmt_t_premio_capi tmp = inizializzaCapo(capo.getCapo(), "N","Il capo non ha un'età compresa tra 20 mesi e 18 anni");
										listaCapiResult.add(tmp);
									} else {
										LocalDate dataNascitaVitello = LocalDateConverter.convertToLocalDateViaInstant(capo.getCapo().getVitelloDtComAutNascita());
										period = Period.between(dataNascitaVitello, oggi);
										//int giorniDiVita = (period.getDays()+period.getMonths()*30+period.getYears()*365);
										long giorniDiVita = ChronoUnit.DAYS.between(dataNascitaVitello, oggi);
										if( giorniDiVita < 270 ) {
											
											listaCapiVacche.remove(capo.getCapo());
											listaCapiVaccheEscluse.add(capo.getCapo());
											capo.setFlagCapoAmmesso("N");
											Dmt_t_premio_capi tmp = inizializzaCapo(capo.getCapo(), "N","Il periodo minimo di 270 giorni di interparto non è stato rispettato");
											listaCapiResult.add(tmp);
											
										} else {
											
											Dmt_t_premio_capi tmp = inizializzaCapo(capo.getCapo(), "S","Il capo è stato ammesso a premio");
											listaCapiResult.add(tmp);
											
										}
									}
								} else {
									
									preesecuzioneEseguitaCorrettamente = false;
									break;
									
								}
							}
						}
						
					}
					LOGGER.info("Fine della Preesecuzione.");
					
				} else if ( PREMI_BOV_MACELLATI.contains(getCodIntrervento()) ) {
					
					this.listaCapiMacellati = (List<Dmt_t_clsCapoMacellato>) listaCapi;
					for (Dmt_t_clsCapoMacellato capo : listaCapiMacellati ) {
						Dmt_t_premio_capi tmp = inizializzaCapoMacellato(capo, "S", "Capo macellato ammesso a premio");
						listaCapiResult.add(tmp);
					}
					LOGGER.info("Fine della Preesecuzione.");
					
				} else if ( PREMI_OVICAPRINI_AGNELLE.contains(getCodIntrervento()) ) {
					
					this.listaCapiOvicaprini = (List<Dmt_t_Tws_bdn_du_capi_ovicaprini>) listaCapi;
					this.quotaCapiPremio = capiOvicapriniService.getQuotaCapiPremioByIdSessioneAndCuaa(getIdSessione(), getCuaa(),getCodIntrervento());
					
					if( quotaCapiPremio == null ) {
						
						LOGGER.error("Errore nella Preesecuzione : Sessione "+getIdSessione()+" Cuaa "+getCuaa()+" quotaCapiPremio = null.");
						preesecuzioneEseguitaCorrettamente = false;
						
					} else {
						LOGGER.info("Fine della Preesecuzione.");
					}
					
				} else {
					
					LOGGER.error("Errore nella Preesecuzione : Il tipo degli oggetti appartenenti alla listaCapi non corrisponde a quelli ammissibili.");
					preesecuzioneEseguitaCorrettamente = false;
					
				}
			} else {
				
				LOGGER.error("Errore nella Preesecuzione : Codice intervento errato.");
				preesecuzioneEseguitaCorrettamente = false;
				
			}
		} else {
			if (listaCapi == null) {
				
				LOGGER.error("Errore nella Preesecuzione : parametro listaCapi = null.");
				preesecuzioneEseguitaCorrettamente = false;
				
			} else {
				
				LOGGER.error("Errore nella Preesecuzione : La lista di capi passata per il Calcolo UBA è vuota.");
				preesecuzioneEseguitaCorrettamente = false;
				
			}
		}
		
	}
	
	@Override
	public void esecuzione() throws CalcoloException {
				
		metodoEseguitoCorrettamente = calcoloUBA();
		
	}
	
	@Override
	public void postEsecuzione() throws CalcoloException {
		// SALVATAGGIO DATI
		
		if(initEseguitaCorrettamente && preesecuzioneEseguitaCorrettamente && metodoEseguitoCorrettamente) {
			
			saveOnDB();
			LOGGER.info("Fine Calcolo9903: calcolo() ");
			
		} else {
			if(!initEseguitaCorrettamente) {
				LOGGER.error("Errore nella init del Calcolo 9903: tutti i parametri devono essere valorizzati");
			} else {
				if(!preesecuzioneEseguitaCorrettamente) {
					LOGGER.error("Errore nella preesecuzione del Calcolo 9903.");
				} else {
					if(!metodoEseguitoCorrettamente ) {
						LOGGER.error("Errore nella esecuzione del Calcolo 9903: calcoloUBA() ");
					} else {
						if(!salvataggioEseguitoCorrettamente) {
							LOGGER.error("Errore nel salvataggio dei dati Calcolo 9903: saveOnDB() ");
						}
					}
				}
			}
		}
	}

	@Override
	public List<ResultCtlUbaMinime> calcoloMassivo() throws CalcoloException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** 
	 * Il metodo setListaCapi9901() serve a 
	 * inizializzare la lista di oggetti di tipo Capo9901
	 * Questa lista sarà utilizzata nell'oggetto di tipo CapiControllati9901
	 * necessaria al calcolo della tempistica di registrazione dei capi.
	 * 
	 * @param listaVacche
	 * 
	 */
	private void setListaCapi9903(List<Dmt_t_Tws_bdn_du_capi_bovini> listaVacche) {
	try {
			
			List<Capo9903> listaCapi9903 = new ArrayList<Capo9903>();
			
			for (Dmt_t_Tws_bdn_du_capi_bovini capo: listaVacche) {
				listaCapi9903.add(new Capo9903(capo));
			}
			
			capiControllati.setListaCapi9903(listaCapi9903);
			
			
			LOGGER.info("Fine Recupero Dati: setListaCapi9903() ");
			
		} catch (Exception e) {
			
			System.err.println(e);
			LOGGER.error("Errore nel setListaCapi9903(): - ",e);
			
		}
	}
	
	

	/**
	 * inizializzaCapoEscluso()
	 * 
	 * Serve ad inizializzare un oggetto di tipo Dmt_w_Tdu_premio_capi,
	 * così da poter aggiungere il capo/vacca alla listaCapiAmmessi, che, tramite service,
	 * sarà salvata su DB
	 * 
	 * @param capoVacca
	 * @param msg 
	 * 
	 * @return capoTmp
	 * 
	 * */
	private Dmt_t_premio_capi inizializzaCapo(Dmt_t_Tws_bdn_du_capi_bovini capoVacca, String ammissibile, String msg) {
		
		Dmt_t_premio_capi capoTmp = new Dmt_t_premio_capi();
		capoTmp.setCodiceAzienda(capoVacca.getAziendaCodice());	
		capoTmp.setIdCapo(capoVacca.getCapoId());
		capoTmp.setCuaa(getCuaa());
		capoTmp.setSessione(capoVacca.getSessione());
		capoTmp.setFlagAmmissibile(ammissibile);
		capoTmp.setCodiceVitello(capoVacca.getCodiceVitello());
		capoTmp.setCodicePremio(capoVacca.getCodicePremio());
		capoTmp.setIdAllevamento(capoVacca.getAllev_id());
		capoTmp.setMsg(msg);
		return capoTmp;
		
	}
	
	/**
	 * inizializzaCapoEscluso()
	 * 
	 * Serve ad inizializzare un oggetto di tipo Dmt_w_Tdu_premio_capi,
	 * così da poter aggiungere il capo/vacca alla listaCapiAmmessi, che, tramite service,
	 * sarà salvata su DB
	 * 
	 * @param capoVacca
	 * @param msg 
	 * 
	 * @return capoTmp
	 * 
	 * */
	private Dmt_t_premio_capi inizializzaCapoMacellato(Dmt_t_clsCapoMacellato capo, String ammissibile, String msg) {
		
		Dmt_t_premio_capi capoTmp = new Dmt_t_premio_capi();
		capoTmp.setCodiceAzienda(capo.getAziendaCodice());	
		capoTmp.setIdCapo(capo.getCapoId());
		capoTmp.setCuaa(getCuaa());
		capoTmp.setSessione(capo.getSessione());
		capoTmp.setFlagAmmissibile(ammissibile);
		capoTmp.setCodicePremio(capo.getCodicePremio());
		capoTmp.setIdAllevamento(capo.getAllevId());
		capoTmp.setMsg(msg);
		capoTmp.setSessione(sessione);
		capoTmp.setCodiceVitello("");
		return capoTmp;
		
	}
	
	/**
	 * Il metodo saveOnDB()
	 * 
	 * Serve a salvare su DB :
	 * 	- listaCapiAmmessi
	 * 	- listaCapiEsclusi
	 *  - model (Dmt_d_Ref9903)
	 * 
	 * */
	private void saveOnDB() {
		try {
			
			LOGGER.info("Inizio salvataggio capi controllati 9903");
			
			if(!listaCapiResult.isEmpty()) {
				
				try {
					capiAmmessiServices.saveAll(listaCapiResult);
					salvataggioEseguitoCorrettamente = true;
					LOGGER.info("Fine salvataggio capi ammessi 9903");
				} catch (IllegalArgumentException e) {
					salvataggioEseguitoCorrettamente = false;
					LOGGER.error("Errore durante il salvataggio capi ammessi 9903 : ", e);
				}
				
			} else {
				if ( !PREMI_OVICAPRINI_AGNELLE.contains(getCodIntrervento()) ) {
					LOGGER.info("Nessun capo ammesso 9903");
					//Response false se nessun capo ammesso non si raggiungono le uba minime
					response = false;
				}
			}
			
			if (PREMI_OVICAPRINI_AGNELLE.contains(getCodIntrervento())) {
				salvataggioEseguitoCorrettamente = true;
			}
			
			LOGGER.info("Fine salvataggio capi controllati 9903");
			
			model.setAnnoCampagna(getAnnoCampagna());
			model.setCodiceIntervento(getCodIntrervento());
			model.setCuaa(getCuaa());
			model.setSessione(sessione);
			model.setUba(ubaMinime);
			
			if(ubaMinime >= UBA) {
				
				model.setEsito("P");
				model.setMotivazioni("Si possiedono capi per un totale di "+ubaMinime+"UBA, sufficienti per accedere al premio");
				response = true;
			} else {
				
				model.setEsito("N");
				model.setMotivazioni("Si possiedono capi per un totale di "+ubaMinime+"UBA, insufficienti per accedere al premio.");
				response = false;
			}
			ubaMinime = 0.0;
			ref9903Services.save(model);
			
		}catch (Exception e) {
			salvataggioEseguitoCorrettamente = false;
			LOGGER.error("Errore durante il salvataggio capi controllati 9903 : ",e);
		}
	}
	
}
