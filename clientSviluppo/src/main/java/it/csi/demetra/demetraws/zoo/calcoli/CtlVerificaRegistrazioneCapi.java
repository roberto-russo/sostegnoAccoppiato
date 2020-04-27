package it.csi.demetra.demetraws.zoo.calcoli;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9901;
import it.csi.demetra.demetraws.zoo.calcoli.entity.Capo9901;
import it.csi.demetra.demetraws.zoo.calcoli.entity.Ref;
import it.csi.demetra.demetraws.zoo.interfaces.RefInterface;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_premio_capi_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_tws_bdn_du_capi_bovini_services;
import it.csi.demetra.demetraws.zoo.util.DateUtilService;
import it.csi.demetra.demetraws.zoo.util.LocalDateConverter;

@Service
public class CtlVerificaRegistrazioneCapi extends Ref implements RefInterface<List<Dmt_t_Tws_bdn_du_capi_bovini>>, Calcolo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CtlVerificaRegistrazioneCapi.class);

	private CapiControllati9901 capiControllati = new CapiControllati9901();
	
	private List<Dmt_t_Tws_bdn_du_capi_bovini> listaVacche = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
	
	private List<Dmt_t_Tws_bdn_du_capi_bovini> listaVaccheAmmesse = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
	
	private List<Dmt_t_Tws_bdn_du_capi_bovini> listaVaccheEscluse = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
	
	private List<Dmt_t_Tws_bdn_du_capi_bovini> output = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
	
	Map<Long,List<Dmt_t_Tws_bdn_du_capi_bovini>> mapVaccaVitelli = new HashMap<>();
	
	private List<Dmt_t_premio_capi> listaCapiResult= new ArrayList<Dmt_t_premio_capi>();
	
	@Autowired
	Dmt_t_premio_capi_services capiAmmessiServices;
	
	@Autowired
	Dmt_t_tws_bdn_du_capi_bovini_services capiServices;
	
	private static final int GIORNI_27 = 27;
	private static final int GIORNI_34 = 34;
	private static final int GIORNI_180 = 180;
	private static final int GIORNI_187 = 187;
	
//	private boolean metodoEseguitoCorrettamente;
	
	public void init(List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapi, Long idBdn, String codIntervento,Long annoCampagna, String cuaa) {
		
		setListaVacche(listaCapi);
		setIdBdn(idBdn);
		setCodIntrervento(codIntervento);
		setAnnoCampagna(annoCampagna);
		setCuaa(cuaa);
		
	}
	
	/**
	 * CALCOLO 9901
	 * 
	 * Il calcolo esegue:
	 * 
	 * -preEsecuzione() in cui si inizializzano tutti i dati che occorrono al calcolo
	 * -esecuzione() in cui si esegue il calcolo effettivo
	 * -postEsecuzione() in cui si controlla l'esito del calcolo e lo si salva su DB
	 * 
	 * Il metodo ritorna un oggetto contenente :
	 * 
	 * 1- la lista dei capi controllati con flagCapoAmmesso = 'S'/'N' e la motivazione
	 * 2- un campo booleano esito che indica se il calcoloTempisticaDiRegistrazione() è andato a buon fine
	 * 3- una stringa motivazioneEsitoCalcolo che contiene le motivazioni dell'esito del calcolo
	 * 
	 * @return capiControllati
	 * @throws CalcoloException 
	 */
	
	@Override
	public List<Dmt_t_Tws_bdn_du_capi_bovini> calcolo() throws CalcoloException {
		
		try {
			
			preEsecuzione();
			esecuzione();
			postEsecuzione();
			
		} catch (CalcoloException e) {
			
			LOGGER.error("Errore Calcolo 9901: ",e);
			
		}
		return output;
		
	}
	
	/**
	 * TEMPISTICA REGISTRAZIONE CAPI
	 * 
	 * tempisticaRegistrazione = tI + tR
	 * 
	 * Il calcolo dei due parametri è dato da:
	 * 
	 *	tI = [Data di identificazione del vitello] - [Data di nascita del vitello] 
	 *	tR = [Data di registrazione in BDN della nascita del capo] - [Data di identificazione del vitello]
	 * 
	 * Se l'esecuzione non presenta problemi: return true
	 * Se ci sono stati errori durante l'esecuzione: return false
	 * 
	 * @param listaCapi 
	 * 
	 * @return true/false
	 * 
	 */
	
	private boolean calcoloTempisticaDiRegistrazione(List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapi) {
		
		setListaCapi9901(listaCapi);

		LOGGER.info("Inizio Calcolo Tempistica di Registrazione 9901: calcoloTempisticaDiRegistrazione() ");
		
		try {
			
			for (Capo9901 capo: capiControllati.getListaCapi9901()) {
				
				if(	   capo.getCapo().getDtNascitaVitello() != null 	  		&& 
					   capo.getCapo().getVitelloDtApplMarchio() != null 		&& 
					   capo.getCapo().getVitelloDtInserBdnNascita() != null	&&
					   !"".equals((capo.getCapo().getFlagDelegato())) 			&&
					   !"".equals((capo.getCapo().getFlagProrogaMarcatura()))		) 
				{
					
					Date dataIdentificazioneVitello = capo.getCapo().getVitelloDtApplMarchio();
					Date dataNascitaVitello = capo.getCapo().getDtNascitaVitello();
					Date dataRegistrazioneVitelloBDN = capo.getCapo().getVitelloDtInserBdnNascita();
					
					String flagDelegato = capo.getCapo().getFlagDelegato()!=null?capo.getCapo().getFlagDelegato():"N";
					String flagProrogaMarcatura = capo.getCapo().getFlagProrogaMarcatura()!=null?capo.getCapo().getFlagProrogaMarcatura():"N";
					int tempisticaRegistrazione;
					int numGiorniFestiviCompresi = 0;

					LocalDate dataIdVit = LocalDateConverter.convertToLocalDateViaInstant(dataIdentificazioneVitello);
					LocalDate dataNascitaVit = LocalDateConverter.convertToLocalDateViaInstant(dataNascitaVitello);
					LocalDate dataRegVit = LocalDateConverter.convertToLocalDateViaInstant(dataRegistrazioneVitelloBDN);
					
					List<Date> giorniFestivi = DateUtilService.getGiorniFestivi(String.valueOf(dataNascitaVit.getYear()));
					
					Date dataRegistrazioneBDNMenoSette = LocalDateConverter.convertToDateViaInstant(dataRegVit.minusDays(7));
					
					Period periodtI = Period.between(dataIdVit, dataNascitaVit);
					Period periodtR = Period.between(dataIdVit, dataRegVit);

					capo.settI(periodtI.getDays());
					capo.settR(periodtR.getDays());
					
					tempisticaRegistrazione = capo.gettI() + capo.gettR();
					
					
					
					if ( flagDelegato.equalsIgnoreCase("N")  && flagProrogaMarcatura.equalsIgnoreCase("N") ) {
						//Caso 1 :
						if( tempisticaRegistrazione <= GIORNI_27 ) {
							capo.setFlagCapoAmmesso("S");
							capo.setMotivazione("Tempistica di registrazione rispettata");
						} else {
							capo.setFlagCapoAmmesso("N");
							capo.setMotivazione("Tempistica di registrazione non rispettata. "
									  		  + "Il capo è stato registrato con un ritardo di "+ ( tempisticaRegistrazione - GIORNI_27 ) +" giorni.");
						}
						
					} else if ( flagDelegato.equalsIgnoreCase("N") && flagProrogaMarcatura.equalsIgnoreCase("S") ) {
						//Caso 2 :
						if( tempisticaRegistrazione <= GIORNI_34 ) {
							
							capo.setFlagCapoAmmesso("S");
							capo.setMotivazione("Tempistica di registrazione rispettata");
							
						} else {
							
							capo.setFlagCapoAmmesso("N");
							capo.setMotivazione("Tempistica di registrazione non rispettata. "
											  + "Il capo è stato registrato con un ritardo di "+ ( tempisticaRegistrazione - GIORNI_34 ) +" giorni.");
						
						}
						
					} else if ( flagDelegato.equalsIgnoreCase("S") && flagProrogaMarcatura.equalsIgnoreCase("N") ) {
						//Caso 3 :
						if( tempisticaRegistrazione <= GIORNI_180 ) {
							
							capo.setFlagCapoAmmesso("S");
							capo.setMotivazione("Tempistica di registrazione rispettata");

				
						} else {
							
							capo.setFlagCapoAmmesso("N");
							capo.setMotivazione("Tempistica di registrazione non rispettata. "
									  		  + "Il capo è stato registrato con un ritardo di "+ ( tempisticaRegistrazione - GIORNI_180 ) +" giorni.");
				
						}
						
					} else if ( flagDelegato.equalsIgnoreCase("S") && flagProrogaMarcatura.equalsIgnoreCase("S") ) {
						//Caso 4 :
						for (Date giorno : giorniFestivi) {
							if( giorno.after(dataRegistrazioneBDNMenoSette) && giorno.before(dataRegistrazioneVitelloBDN )) {
								numGiorniFestiviCompresi += 1;
							}
						}
						
						if( numGiorniFestiviCompresi > 0 ) {
							
							if( tempisticaRegistrazione <= (GIORNI_187 + numGiorniFestiviCompresi) ) {
								
								capo.setFlagCapoAmmesso("S");
								capo.setMotivazione("Tempistica di registrazione rispettata");

							} else {
								
								capo.setFlagCapoAmmesso("N");
								capo.setMotivazione("Tempistica di registrazione non rispettata. "
										  		  + "Il capo è stato registrato con un ritardo di "+ ( tempisticaRegistrazione - ( GIORNI_187 + numGiorniFestiviCompresi) ) +" giorni.");
					
							}
							
						} else {
							
							if( tempisticaRegistrazione <= GIORNI_187 ) {
								
								capo.setFlagCapoAmmesso("S");
								capo.setMotivazione("Tempistica di registrazione rispettata");

							} else {
								
								capo.setFlagCapoAmmesso("N");
								capo.setMotivazione("Tempistica di registrazione non rispettata. "
										  		  + "Il capo è stato registrato con un ritardo di "+ ( tempisticaRegistrazione - GIORNI_187 ) +" giorni.");
					
							}
						}
						
					}
					
					
				} else {
					
					System.err.println("Campi del capo non valorizzati correttamente");
					LOGGER.error("Errore nel Calcolo Tempistica di Registrazione 9901: - Campi del capo non valorizzati correttamente");
					return false;
				}
				
				if("S".equalsIgnoreCase(capo.getFlagCapoAmmesso())) {
					
					Dmt_t_premio_capi capoTmp = inizializzaVitello(capo,"S");
									
					listaCapiResult.add(capoTmp);
					listaVaccheAmmesse.add(capo.getCapo());
					
				} else {
					
					Dmt_t_premio_capi capoTmp = inizializzaVitello(capo,"N");
					
					listaCapiResult.add(capoTmp);
					listaVaccheEscluse.add(capo.getCapo());
					
				}
			}
			
			LOGGER.info("Fine Calcolo Tempistica di Registrazione 9901: calcoloTempisticaDiRegistrazione() ");
			
			
			controllaAmmissibilita(capiControllati);
			
			return true;
			
		} catch (Exception e) {
			
			System.err.println(e);
			LOGGER.error("Errore nel Calcolo Tempistica di Registrazione 9901: - ",e);
			return false;
			
		}
	}
	
	/**
	 * 
	 * VERIFICA DI AMMISSIBILITÀ 
	 * Se tutti i capi sono stati ammessi,
	 * allora la vacca è ammissibile a premio (esito=true),
	 * altrimenti la vacca non è ammissibile a premio (esito=false).
	 * 
	 * @param capiControllati
	 * 
	 */
	private void controllaAmmissibilita(CapiControllati9901 capiControllati) {
		
		LOGGER.info("Inizio Controllo Ammissibilità 9901: controllaAmmissibilita() ");
		
		try {
			for (Capo9901 capo: capiControllati.getListaCapi9901()) {
				if(capo.getFlagCapoAmmesso().equalsIgnoreCase("N")) {
					CapiControllati9901.setEsito(false);
					CapiControllati9901.setMotivazioneEsitoCalcolo("Non tutti i capi hanno superato il controllo di ammissibilità" );
					break;
				}
			}
			
			LOGGER.info("Fine Controllo Ammissibilità 9901: controllaAmmissibilita() ");
			
		} catch (Exception e) {
			
			System.err.println(e);
			LOGGER.error("Errore nel Controllo Ammissibilità 9901: - ",e);
			
		}
		
	}
	
	/**
	 * 
	 * RECUPERO DATI 
	 * Il metodo recuperaDatiCapi() serve a 
	 * recuperare la lista di vitelli per ogni capo.
	 * I dati sono organizzati in una Map contenente:
	 * 	- key -> idCapo
	 * 	- value -> lista dei vitelli
	 * 
	 */
//	private void recuperoDatiCapi() {
//		
//		LOGGER.info("Inizio Recupero Dati: recuperoDatiCapi() ");
//		
//		try {
//			
//			Map<Long,List<Dmt_t_Tws_bdn_du_capi_bovini>> vaccheVitelli = new HashMap<>();
//			
//			Long idTmp = listaVacche.get(0).getCapoId();
//			vaccheVitelli.put(listaVacche.get(0).getCapoId(),getVaccaVitelliFromDB(listaVacche.get(0).getCapoId()));
//			
//			for (Dmt_t_Tws_bdn_du_capi_bovini capo: listaVacche) {
//				if(idTmp != capo.getCapoId()) {
//					idTmp = capo.getCapoId();
//					vaccheVitelli.put(capo.getCapoId(),getVaccaVitelliFromDB(capo.getCapoId()));
//				}
//			}
//			
//			mapVaccaVitelli = vaccheVitelli;	
//			
//			LOGGER.info("Fine Recupero Dati: recuperoDatiCapi() ");
//			
//		} catch (Exception e) {
//			
//			System.err.println(e);
//			LOGGER.error("Errore nel Controllo recuperoDatiCapi 9901: - ",e);
//			
//		}
//		
//	}
	
	/** 
	 * Il metodo setListaCapi9901() serve a 
	 * inizializzare la lista di oggetti di tipo Capo9901
	 * Questa lista sarà utilizzata nell'oggetto di tipo CapiControllati9901
	 * necessaria al calcolo della tempistica di registrazione dei capi.
	 * 
	 * @param listaVacche
	 * 
	 */
	private void setListaCapi9901(List<Dmt_t_Tws_bdn_du_capi_bovini> listaVacche) {
	try {
			
			List<Capo9901> listaCapi9901 = new ArrayList<Capo9901>();
			
			for (Dmt_t_Tws_bdn_du_capi_bovini capo: listaVacche) {
				listaCapi9901.add(new Capo9901(capo,0,0));
			}
			
			capiControllati.setListaCapi9901(listaCapi9901);
			
			
			LOGGER.info("Fine Recupero Dati: recuperoDatiCapi() ");
			
		} catch (Exception e) {
			
			System.err.println(e);
			LOGGER.error("Errore nel recuperoDatiCapi() 9901: - ",e);
			
		}
		
	}
	/**
	 * Metodo setListaVacche()
	 * 
	 * @param listaCapi
	 * */
	private void setListaVacche(List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapi) {
		listaVacche = listaCapi;	
	}
	
	/**
	 * Metodo preEsecuzione()
	 * 
	 * Nella preesecuzione vengono inizializzati i dati necessari al calcolo.
	 * 
	 * */
	@Override
	public void preEsecuzione() throws CalcoloException {
		
//		recuperoDatiCapi();
		
	}
	
	/**
	 * Metodo esecuzione()
	 * 
	 * Nell' esecuzione si effettua il calcolo vero e proprio.
	 * Per ogni lista di vitelli delle vacche, va effettuato il calcoloTempisticaDiRegistrazione().
	 * Se il metodo viene eseguito correttamente, si controlla l'esito e se positivo, la vacca è ammessa a premio,
	 * altrimenti la vacca non è ammessa a premio.
	 * Alla fine dell'esecuzione le liste di vacche ammesse ed escluse saranno popolate.
	 * 
	 * */
	@Override
	public void esecuzione() throws CalcoloException {
		
		LOGGER.info("Inizio Calcolo 9901: calcolo() ");
//		Dmt_t_Tws_bdn_du_capi_bovini capoVacca;
//		for(Dmt_t_Tws_bdn_du_capi_bovini vacca : listaVacche) {
//			capoVacca = null;
//			for(Dmt_t_Tws_bdn_du_capi_bovini capo: listaVacche) {
//				if( capo.getCapoId() == vacca.getKey() ) {
//					capoVacca = capo;
//					break;
//				}
//			}
		calcoloTempisticaDiRegistrazione(listaVacche);
//		if (metodoEseguitoCorrettamente) {
//			if(CapiControllati9901.getEsito()) {
//				if(capoVacca != null) {
//					Dmt_w_Tdu_premio_capi capoTmp = new Dmt_w_Tdu_premio_capi();
//					capoTmp = inizializzaCapoAmmesso(capoVacca);
//					listaCapiAmmessi.add(capoTmp);
//					listaVaccheAmmesse.add(capoVacca);
//				}
//			} else {
//				if(capoVacca != null) {
//					Dmt_w_Tdu_premio_capi_esclusi capoTmp = new Dmt_w_Tdu_premio_capi_esclusi();
//					capoTmp = inizializzaCapoEscluso(capoVacca);
//					listaCapiEsclusi.add(capoTmp);
//					listaVaccheEscluse.add(capoVacca);
//				}
//			}
//			}
//		}
	}
	/**
	 * Metodo postEsecuzione()
	 * 
	 * Nella postesecuzione si provvede al salvataggio dei dati su DB.
	 * Inoltre si setta la lista di vacche ammesse che sarà restituita dal metodo calcolo().
	 * Se nessuna vacca sarà ammessa, allora sarà quest'ultima ad essere restituita dal metodo calcolo().
	 * 
	 * */
	@Override
	public void postEsecuzione() throws CalcoloException {

		saveOnDB();
		
		if (listaVaccheAmmesse != null && !listaVaccheAmmesse.isEmpty()) {
			setListaCapi9901(listaVaccheAmmesse);
			CapiControllati9901.setEsito(true);
			CapiControllati9901.setMotivazioneEsitoCalcolo("Lista delle vacche ammesse a premio");
			output = listaVaccheAmmesse;
		} else {
			if(listaVaccheEscluse != null && !listaVaccheEscluse.isEmpty()) {
				setListaCapi9901(listaVaccheEscluse);
				CapiControllati9901.setEsito(false);
				CapiControllati9901.setMotivazioneEsitoCalcolo("Nessuna vacca è ammessa a premio");
				output = null;
			}
		}

	}
	
	/**
	 * inizializzaVitelloAmmesso()
	 * 
	 * Serve ad inizializzare un oggetto di tipo Dmt_w_Tdu_premio_capi,
	 * così da poter aggiungere il vitello alla listaCapiAmmessi, che, tramite service,
	 * sarà salvata su DB
	 * 
	 * @param capo
	 * 
	 * @return capoTmp
	 * 
	 * */
	private Dmt_t_premio_capi inizializzaVitello(Capo9901 capo, String ammissibile) {
		
		Dmt_t_premio_capi capoTmp = new Dmt_t_premio_capi();
		capoTmp.setCodiceAzienda(capo.getCapo().getAziendaCodice());	
		capoTmp.setIdCapo(capo.getCapo().getCapoId());
		capoTmp.setCuaa(getCuaa());
		capoTmp.setSessione(capo.getCapo().getSessione());
		capoTmp.setFlagAmmissibile(ammissibile);
		capoTmp.setCodiceVitello(capo.getCapo().getCodiceVitello());
		capoTmp.setCodicePremio(capo.getCapo().getCodicePremio());
		capoTmp.setIdAllevamento(capo.getCapo().getAllev_id());
		capoTmp.setMsg(capo.getMotivazione());
		return capoTmp;
		
	}

//
//	/**
//	 * inizializzaCapoEscluso()
//	 * 
//	 * Serve ad inizializzare un oggetto di tipo Dmt_w_Tdu_premio_capi,
//	 * così da poter aggiungere il capo/vacca alla listaCapiAmmessi, che, tramite service,
//	 * sarà salvata su DB
//	 * 
//	 * @param capoVacca
//	 * 
//	 * @return capoTmp
//	 * 
//	 * */
//	private Dmt_t_premio_capi inizializzaCapo(Dmt_t_Tws_bdn_du_capi_bovini capoVacca, String ammissibile) {
//		
//		Dmt_t_premio_capi capoTmp = new Dmt_t_premio_capi();
//		capoTmp.setCodiceAzienda(capoVacca.getAziendaCodice());	
//		capoTmp.setIdCapo(capoVacca.getCapoId());
//		capoTmp.setCuaa(getCuaa());
//		capoTmp.setSessione(capoVacca.getSessione());
//		capoTmp.setFlagAmmissibile(ammissibile);
//		capoTmp.setCodiceVitello(capoVacca.getCodiceVitello());
//		capoTmp.setCodicePremio(capoVacca.getCodicePremio());
//		capoTmp.setIdAllevamento(capoVacca.getAllev_id());
//		return capoTmp;
//		
//	}

	/**
	 * Il metodo saveOnDB()
	 * 
	 * Serve a salvare su DB le liste:
	 * 	- listaCapiAmmessi
	 * 	- listaCapiEsclusi
	 * 
	 * */
	private void saveOnDB() {
		try {
			LOGGER.info("Inizio salvataggio capi controllati 9901");
			
			if(!listaCapiResult.isEmpty()) {
				
				try {
					capiAmmessiServices.saveAll(listaCapiResult);
					LOGGER.info("Fine salvataggio capi ammessi 9901");
				} catch (IllegalArgumentException e) {
					LOGGER.error("Errore durante il salvataggio capi ammessi 9901 : ", e);
				}
				
			}
			
			LOGGER.info("Fine salvataggio capi controllati 9901");
		}catch (Exception e) {
			LOGGER.error("Errore durante il salvataggio capi controllati 9901 : ",e);
		}
	}

	/**
	 * Il metodo getVaccaVitelliFromDB()
	 * 
	 * Serve a recuperare i vitelli partoriti da una vacca nell'anno campagna richiesto nel calcolo
	 * 
	 * @param idCapo
	 * 
	 * */
//	private List<Dmt_t_Tws_bdn_du_capi_bovini> getVaccaVitelliFromDB(Long idCapo) {
//	
//		try {
//			
//			LOGGER.info("Recupero della lista di capi della sessione "+getIdBdn());
//			return capiServices.getVitelliOfVacca(getIdBdn(), getCuaa(), idCapo, getAnnoCampagna());
//		} catch (Exception e) {
//			
//			LOGGER.error("Errore durante il recupero della lista di capi della sessione "+getIdBdn()+": ", e);
//			return null;
//			
//		}
//	}

	@Override
	public List<List<Dmt_t_Tws_bdn_du_capi_bovini>> calcoloMassivo() throws CalcoloException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
