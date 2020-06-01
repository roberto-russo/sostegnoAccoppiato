package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_tws_bdn_du_capi_bovini_services;
import it.csi.demetra.demetraws.zoo.util.LocalDateConverter;
/**
 * Author: 
 * Title: Intervento 311 - Misura 2
 */
@Component("ClcInt311Mis2")
public class ClcInt311Mis2 extends Controllo{

	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
	
	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesseInt310Mis1;
	
	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesse;
    
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheEscluse;
    
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesseUba;
    
    private List<Dmt_t_output_esclusi> listEsclusi = new ArrayList<>();
    
    ResultCtlUbaMinime resultCtlUba;
    
    boolean ubaMinimeRaggiunte;
    
    private int importoLiquidabile = 0;
    
    private static final int DETENZIONE_MINIMA = 6;
    
    @Autowired
    CtlUbaMinime ref9903;
    
    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_services capiBoviniService;
    
    
	@Override
	public void preEsecuzione() throws ControlloException, CalcoloException {
		/*
		 * Prendo dal DB tutte le vacche richieste per sessione cua e codice Intervento
		 * */
        modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
        /*
		 * Prendo dal DB tutte le vacche che hanno superato il controllo del premio per l'Intervento 310 Misura 1
		 * */
        modelVaccheAmmesseInt310Mis1 = capiBoviniService.getListaCapiAmmessiZonaMontanaInt311Mis2(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
        /*
		 * Prendo dal DB tutte le vacche che hanno superato il controllo del premio per l'Intervento 310 Misura 1 e che appartengono ad una zona montana
		 * */
		modelVaccheAmmesse = capiBoviniService.getBoviniIdoneiInt310Mis1ZonaMontana(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		/*
		 * Prendo dal DB tutte le vacche che hanno superato il controllo del premio per l'Intervento 310 Misura 1 ma che non appartengono ad una zona montana
		 * */
		modelVaccheEscluse = capiBoviniService.getBoviniIdoneiInt310Mis1NonDiZonaMontana(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());

		
		
		if(modelVaccheAmmesse != null && !modelVaccheAmmesse.isEmpty()) {
			
			if( modelVaccheEscluse == null ) {
				
				modelVaccheEscluse = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
				
			}
			/*
			 * Dalla lista delle vacche ammesse si eliminano le vacche che sono state 
			 * in detenzione presso l'allevamento montano per un periodo minore di 6 mesi,
			 * ai sensi del Reg. (CE) n. 1257/1999.
			 * */
			for ( Dmt_t_Tws_bdn_du_capi_bovini capo: modelVaccheAmmesse ) {
				
				if(capo.getDtInizioDetenzione() != null & capo.getDtFineDetenzione() != null && capo.getDtNascitaVitello() != null ) {
					
					LocalDate inizioDetenzione =	LocalDateConverter.convertToLocalDateViaInstant(capo.getDtInizioDetenzione());
					LocalDate fineDetenzione =		LocalDateConverter.convertToLocalDateViaInstant(capo.getDtFineDetenzione());
					LocalDate dtNascitaVitello =	LocalDateConverter.convertToLocalDateViaInstant(capo.getDtNascitaVitello());
					
					long mesiDiDetenzione = ChronoUnit.MONTHS.between(inizioDetenzione, fineDetenzione);
					
					if ( mesiDiDetenzione < DETENZIONE_MINIMA) {
						
						modelVaccheAmmesse.remove(capo);
						modelVaccheEscluse.add(capo);
						if(modelVaccheAmmesse.isEmpty())
							break;
						
					}
					
				} else {
					
					modelVaccheAmmesse.remove(capo);
					modelVaccheEscluse.add(capo);
					if(modelVaccheAmmesse.isEmpty())
						break;
				}
				
			}
			
		    try {
		    	/*
		    	 * Se c'è qualche vacca che è stata ammessa inizializzo il
		    	 * ref9903 per il contrrollo delle Uba Minime.
		    	 * */
		    	if(!modelVaccheAmmesse.isEmpty()) {
					
					ref9903.init(modelVaccheAmmesse, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());
				
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
		
		} else {
			
			if(modelVaccheAmmesseInt310Mis1 != null && modelVaccheAmmesseInt310Mis1.isEmpty()) {
				
				setListEsclusi(modelVacche,"Il capo non risulta a premio per l'Intervento 310 Misura 1.");
				
			} 
			
		}
		
		if(modelVaccheEscluse != null && !modelVaccheEscluse.isEmpty()) {
			
			setListEsclusi(modelVacche,"Il capo è escluso dal premio perchè l'allevamento non è situato in una zona montana. ");
			
		}
	}

	@Override
	public void esecuzione() throws ControlloException {
		/*
    	 *	Se ci sono vacche ammesse si può, infine, calcolare il premio per l'Intervento 311 Misura 2
    	 * */
		if(modelVaccheAmmesse != null && !modelVaccheAmmesse.isEmpty()) {
			
			if(ubaMinimeRaggiunte) {
				
			    /*
			     * L’aiuto spetta al richiedente detentore della vacca al momento del parto.
			     * Qualora la vacca abbia partorito più di una volta nel corso dell’anno presso
			     * la stalla di diversi detentori susseguitisi nel tempo, il premio è erogato
			     * al detentore presso il quale è nato il primo capo.
			     * 
			     * */
		        for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVaccheAmmesseUba) {
		        	
		            List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService().getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());

		        	if(UtilControlli.isDetentoreParto(b, listVitelli)){
		        		
		        		importoLiquidabile++;
		        		
		        	} else {
		        		
		        		listEsclusi.add(UtilControlli.generaEscluso(b, getSessione(), "", getAzienda().getCodicePremio()));
		        		
		        	}

		        }		
				
			} else {
				
				throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_02002", getInput(), "Non è stato ragginuto il numero delle Uba minime necessarie al raggiungimento del premio"));
			
			}
		} else {
			
            throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_02002", getInput(), "Nessuna vacca è stata ammessa a premio"));
            
		}
	}

	@Override
	public void postEsecuzione() throws ControlloException {
		// ESECUZIONI CONTROLLI PER SOGGETTO
        Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
        outputControlli.setIdSessione(getSessione());
        outputControlli.setAnnoCampagna(getAzienda().getAnnoCampagna());
        outputControlli.setCapiAmmissibili(importoLiquidabile);
        outputControlli.setCapiRichiesti(modelVacche.size());
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

}
