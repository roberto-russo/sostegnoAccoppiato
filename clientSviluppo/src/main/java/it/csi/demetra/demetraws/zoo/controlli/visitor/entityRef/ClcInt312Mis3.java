package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_tws_bdn_du_capi_bovini_services;
import it.csi.demetra.demetraws.zoo.util.LocalDateConverter;
/**
 * Author: 
 * Title: Intervento 312 - Misura 3
 */
@Component("ClcInt312Mis3")
public class ClcInt312Mis3 extends Controllo{
	
	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;

	private List<Dmt_t_Tws_bdn_du_capi_bovini> listVaccheDetentoriAllevAttivi;

	private int importoLiquidabile = 0;
	
	private int sizeModelVacche = 0;
	
	private static final int ETA_RICHIESTA_IN_MESI = 30;
	
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesseRegCapi;
	
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesseUba;
    
    private List<Dmt_t_output_esclusi> listEsclusi = new ArrayList<Dmt_t_output_esclusi>();
    
    List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheTmp = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
    	
    ResultCtlUbaMinime resultCtlUba;
    
    boolean ubaMinimeRaggiunte;
	
    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_services capiBoviniService;
    
	@Autowired
	private CtlVerificaRegistrazioneCapi ref9901;
    
	@Autowired
    CtlUbaMinime ref9903;

	private List<Dmt_t_Tws_bdn_du_capi_bovini> listVaccheDetentoriAllevNonAttivi;

	
	@Override
	public void preEsecuzione() throws ControlloException, CalcoloException {
		/*
		 * Prendo dal DB tutte le vacche richieste per sessione cua e codice Intervento
		 * */
        modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
        /*
		 * Prendo dal DB tutte le vacche appartenenti ad un detentore di allevamenti attivi
		 * */
		listVaccheDetentoriAllevAttivi = getControlliService().getBoviniOfDetentoriAllevamentiAttivi(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		listVaccheDetentoriAllevNonAttivi = getControlliService().getBoviniOfDetentoriAllevamentiNonAttivi(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		
		if(modelVacche == null) {
			
            throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_02003", getInput(), "Non è stato possibile recuperare i dati"));
            
		}
		
		sizeModelVacche = modelVacche.size();
		
		if (listVaccheDetentoriAllevAttivi == null) {
			
            throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_02003", getInput(), "Nessun allevamento attivo"));
            
		}	
		
		if (listVaccheDetentoriAllevNonAttivi != null && !listVaccheDetentoriAllevNonAttivi.isEmpty()) {
			
            setListEsclusi(listVaccheDetentoriAllevNonAttivi, "Il capo è escluso poichè appartenente ad un allevamento non attivo");
            
		}	
		
		try {
			
			ref9901.init(
					listVaccheDetentoriAllevAttivi,
					getSessione().getIdSessione(), getAzienda().getCodicePremio(),
					Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());

			
			this.modelVaccheAmmesseRegCapi = ref9901.calcolo();
			
			if(this.modelVaccheAmmesseRegCapi == null)
				throw new CalcoloException("si e' verificato un errore durante l'esecuzione del controllo tempistica di registrazione dei capi");
			else
				if(this.modelVaccheAmmesseRegCapi.isEmpty()) {
					throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt312Mis3", getInput(), "Nessun capo ha superato il controllo: tempistica di registrazione capi"));
				}			
			
		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9901", getInput(), e.getMessage()));
		}
		
		try {
		    	/*
		    	 * Se c'è qualche vacca che è stata ammessa inizializzo il
		    	 * ref9903 per il contrrollo delle Uba Minime.
		    	 * */
		    	if(!modelVaccheAmmesseRegCapi.isEmpty()) {
							    		
					ref9903.init(modelVaccheAmmesseRegCapi, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());
				
					resultCtlUba = ref9903.calcolo();
		            
					/*
			    	 * Se non ci sono stati errori durante il calcolo e si hanno le uba minimie necessarie,
			    	 * si setta la variabile booleana ubaMinime = true e si prendono dal db i capi ammessi nel calcolo delle uba.
			    	 * 
			    	 * */
		            if(!resultCtlUba.isErrors()) {
		            	
		            	if(resultCtlUba.isResult()) {
		            		
		            		ubaMinimeRaggiunte = true;
		            		
		            		modelVaccheAmmesseUba = capiBoviniService.getBoviniUbaMinime(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		            		
		            	} else {
		            		
		            		ubaMinimeRaggiunte = false;
		            		
		            	}
		            	
		            } else {
		            	
		            	 throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), "Ci sono stati errori durante il calcolo della UBA minime"));
		            
		            }
		    	} else {
		    		
		    		throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), "Non è possibile calcolare le UBA minime, nessuna vacca presente."));
		    		
		    	}
		            
		  } catch (CalcoloException e) {
		        	
			  throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		  }
		
	}

	@Override
	public void esecuzione() throws ControlloException {
		if (modelVaccheAmmesseUba != null && !modelVaccheAmmesseUba.isEmpty()) {
			

			for ( Dmt_t_Tws_bdn_du_capi_bovini bufala : modelVaccheAmmesseUba ) {
				if( bufala.getDtNascitaVitello() != null ) {
					LocalDate dataNascitaVitello = LocalDateConverter.convertToLocalDateViaInstant(bufala.getDtNascitaVitello());
					if (dataNascitaVitello.getYear() == getAzienda().getAnnoCampagna()) {
						LocalDate dataNascita = LocalDateConverter.convertToLocalDateViaInstant(bufala.getDataNascita());
						LocalDate oggi = LocalDateConverter.convertToLocalDateViaInstant(new Date());
						long mesiDiVita = ChronoUnit.MONTHS.between(dataNascita, oggi);
						if ( mesiDiVita > ETA_RICHIESTA_IN_MESI) {
			        		importoLiquidabile ++;
						} else {
							addEscluso(bufala, "I mesi di vita del capo sono inferiori o uguali a 30.");
						}
					} else {
						addEscluso(bufala, "Il capo non ha partorito nell'anno.");
					}
				} else {
					addEscluso(bufala, "Il capo non ha partorito nell'anno.");
				}
			}
			
		} else {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_02003", getInput(), "Nessuna vacca presente impossibile eseguire il calcolo del premio"));
		}
		
		
	}

	@Override
	public void postEsecuzione() throws ControlloException {
		// ESECUZIONI CONTROLLI PER SOGGETTO
        Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
        outputControlli.setIdSessione(getSessione());
        outputControlli.setAnnoCampagna(getAzienda().getAnnoCampagna());
        outputControlli.setCapiAmmissibili(importoLiquidabile);
        outputControlli.setCapiRichiesti(sizeModelVacche);
        outputControlli.setCuaa(getAzienda().getCuaa());
        outputControlli.setIntervento(getAzienda().getCodicePremio());

        getControlliService().saveOutput(outputControlli);

        for (Dmt_t_output_esclusi o : listEsclusi)
            getControlliService().saveOutputEscl(o);
		
	}
	
	private void setListEsclusi(List<Dmt_t_Tws_bdn_du_capi_bovini> bovini, String motivazione) {
		
		for  (Dmt_t_Tws_bdn_du_capi_bovini b: bovini) {
			
	        Dmt_t_output_esclusi escluso = new Dmt_t_output_esclusi();
	        escluso.setCalcolo(ClcInt311Mis2.class.getName());
	        escluso.setCapoId(b.getCapoId());
	        escluso.setMotivazioneEsclusione(motivazione);
	        escluso.setIdSessione(getSessione());
//	        escluso.setIdSessione(getSessione().getIdSessione());
	        listEsclusi.add(escluso);
	        
		}
        
	}
	
	private void addEscluso(Dmt_t_Tws_bdn_du_capi_bovini capo,String motivazione) {
		Dmt_t_output_esclusi escluso = new Dmt_t_output_esclusi();
        escluso.setCalcolo(ClcInt312Mis3.class.getSimpleName());
        escluso.setCapoId(capo.getCapoId());
        escluso.setMotivazioneEsclusione(motivazione);
        escluso.setIdSessione(getSessione());
//      escluso.setIdSessione(getSessione().getIdSessione());
        listEsclusi.add(escluso);
	}
	
}