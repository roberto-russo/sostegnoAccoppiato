package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
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
 * controlli da applicare per il calcolo del premio zootecnia per l’intervento
 * 311 – Misura 2:<br>
 * vacche da latte associate ad allevamenti situati in zone montane
 * 
 * @author bcsoft
 */
@Component("ClcInt311Mis2")
public class ClcInt311Mis2 extends Controllo {

	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;

	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesseInt310Mis1;

	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesse;

	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheEscluse;

	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesseUba;

	private List<Dmt_t_output_esclusi> listEsclusi = new ArrayList<>();

	ResultCtlUbaMinime resultCtlUba;

	boolean ubaMinimeRaggiunte;

	private BigDecimal importoLiquidabile = new BigDecimal(0);
	
	private Integer capiSanzionati;

	private static final int DETENZIONE_MINIMA = 6;

	@Autowired
	CtlUbaMinime ref9903;

	@Autowired
	Dmt_t_tws_bdn_du_capi_bovini_services capiBoviniService;

	/**
	 * il metodo preEsecuzione utilizza il controllo:
	 * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 * @throws CalcoloException   eccezione relativa al calcolo di tipo
	 *                            {@link CalcoloException}
	 */
	@Override
	public void preEsecuzione() throws ControlloException, CalcoloException {

		this.capiSanzionati = 0;
		/*
		 * pulizia delle liste prima dell'esecuzione.
		 */
		this.resetLists();
		/*
		 * Prendo dal DB tutte le vacche richieste per sessione cua e codice Intervento
		 */
		// modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(),
		// getAzienda().getCuaa(), getAzienda().getCodicePremio());
		modelVacche = this.controlloCapiDichiarati(getControlliService().getAllBoviniSessioneCuua(getSessione(),
				getAzienda().getCuaa(), getAzienda().getCodicePremio()));
		/*
		 * Prendo dal DB tutte le vacche che hanno superato il controllo del premio per
		 * l'Intervento 310 Misura 1
		 */
		modelVaccheAmmesseInt310Mis1 = capiBoviniService.getListaCapiAmmessiZonaMontanaInt311Mis2(
				getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
		/*
		 * Prendo dal DB tutte le vacche che hanno superato il controllo del premio per
		 * l'Intervento 310 Misura 1 e che appartengono ad una zona montana
		 */
		modelVaccheAmmesse = capiBoviniService.getBoviniIdoneiInt310Mis1ZonaMontana(getSessione().getIdSessione(),
				getAzienda().getCuaa(), getAzienda().getCodicePremio());
		/*
		 * Prendo dal DB tutte le vacche che hanno superato il controllo del premio per
		 * l'Intervento 310 Misura 1 ma che non appartengono ad una zona montana
		 */
		modelVaccheEscluse = capiBoviniService.getBoviniIdoneiInt310Mis1NonDiZonaMontana(getSessione().getIdSessione(),
				getAzienda().getCuaa(), getAzienda().getCodicePremio());

		if (modelVaccheAmmesse != null && !modelVaccheAmmesse.isEmpty()) {

			if (modelVaccheEscluse == null) {

				modelVaccheEscluse = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();

			}
			/*
			 * Dalla lista delle vacche ammesse si eliminano le vacche che sono state in
			 * detenzione presso l'allevamento montano per un periodo minore di 6 mesi, ai
			 * sensi del Reg. (CE) n. 1257/1999.
			 */
			for (Dmt_t_Tws_bdn_du_capi_bovini capo : modelVaccheAmmesse) {

				if (capo.getDtInizioDetenzione() != null & capo.getDtFineDetenzione() != null
						&& capo.getDtNascitaVitello() != null) {

					LocalDate inizioDetenzione = LocalDateConverter
							.convertToLocalDateViaInstant(capo.getDtInizioDetenzione());
					LocalDate fineDetenzione = LocalDateConverter
							.convertToLocalDateViaInstant(capo.getDtFineDetenzione());
					LocalDate dtNascitaVitello = LocalDateConverter
							.convertToLocalDateViaInstant(capo.getDtNascitaVitello());

					long mesiDiDetenzione = ChronoUnit.MONTHS.between(inizioDetenzione, fineDetenzione);

					if (mesiDiDetenzione < DETENZIONE_MINIMA) {

						// modelVaccheAmmesse.remove(capo);
						modelVaccheEscluse.add(capo);
						if (modelVaccheAmmesse.isEmpty())
							break;

					}

				} else {

					// modelVaccheAmmesse.remove(capo);
					modelVaccheEscluse.add(capo);
					if (modelVaccheAmmesse.isEmpty())
						break;
				}

			}

			for (Dmt_t_Tws_bdn_du_capi_bovini capo : modelVaccheEscluse)
				if (modelVaccheAmmesse.contains(capo))
					modelVaccheAmmesse.remove(capo);

			try {
				/*
				 * Se c'è qualche vacca che è stata ammessa inizializzo il ref9903 per il
				 * contrrollo delle Uba Minime.
				 */
				if (!modelVaccheAmmesse.isEmpty()) {

					ref9903.init(modelVaccheAmmesse, getAzienda().getCodicePremio(),
							Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());

					resultCtlUba = ref9903.calcolo();

					/*
					 * Se non ci sono stati errori durante il calcolo e si hanno le uba minimie
					 * necessarie, si setta la variabile booleana ubaMinime = true e si prendono dal
					 * db i capi ammessi nel calcolo delle uba.
					 * 
					 */
					if (!resultCtlUba.isErrors()) {

						if (resultCtlUba.isResult()) {

							ubaMinimeRaggiunte = true;

							modelVaccheAmmesseUba = capiBoviniService.getBoviniUbaMinime(getSessione().getIdSessione(),
									getAzienda().getCuaa(), getAzienda().getCodicePremio());

						} else {

							ubaMinimeRaggiunte = false;

						}

					} else {

						throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(),
								"Ci sono stati errori durante il calcolo della UBA minime"));

					}
				} else {

					throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(),
							"Non è possibile calcolare le UBA minime, nessuna vacca presente."));

				}

			} catch (CalcoloException e) {

				throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
			}

		} else {

			if (modelVaccheAmmesseInt310Mis1 != null && modelVaccheAmmesseInt310Mis1.isEmpty()) {

				setListEsclusi(modelVacche, "Il capo non risulta a premio per l'Intervento 310 Misura 1.");

			}

		}

		if (modelVaccheEscluse != null && !modelVaccheEscluse.isEmpty()) {

			setListEsclusi(modelVacche,
					"Il capo è escluso dal premio perchè l'allevamento non è situato in una zona montana. ");

		}
	}

	/**
	 * il metodo esecuzione effettua l'esecuzione dei controlli per l'intervento 311
	 * Misura 2
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void esecuzione() throws ControlloException {
		/*
		 * Se ci sono vacche ammesse si può, infine, calcolare il premio per
		 * l'Intervento 311 Misura 2
		 */
		if (modelVaccheAmmesse != null && !modelVaccheAmmesse.isEmpty()) {

			if (ubaMinimeRaggiunte) {

				/*
				 * L’aiuto spetta al richiedente detentore della vacca al momento del parto.
				 * Qualora la vacca abbia partorito più di una volta nel corso dell’anno presso
				 * la stalla di diversi detentori susseguitisi nel tempo, il premio è erogato al
				 * detentore presso il quale è nato il primo capo.
				 * 
				 */
				for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVaccheAmmesseUba) {

					int contatoreFestivita = 0;
	        		contatoreFestivita= UtilControlli.contaFestivi(b.getVaccaDtInserBdnIngresso(), b.getVaccaDtComAutIngresso());
	        		

					List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService()
							.getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());

					//SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CAA
					
					if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
							this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), b.getCapoId(),
							this.getControlliService())) {
						
						if(UtilControlli.differenzaGiorni(b.getVaccaDtComAutIngresso(), b.getVaccaDtIngresso()) <= 7){
		        			if(UtilControlli.differenzaGiorni(b.getVaccaDtInserBdnIngresso(), b.getVaccaDtComAutIngresso()) + contatoreFestivita <= 7){
		        				this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
		        			}else{
		        				this.capiSanzionati++;
		        				}
		        		}else{
		        			this.capiSanzionati++;
		        		}

					} else {

						//ALTRIMENTI SI PROCEDE ALLA DETERMINAZIONE DEL BENEFICIARIO DEL CAPO DOPPIO IN MANIERA CLASSICA
						
						if (UtilControlli.isDetentoreParto(b, listVitelli)) {

							if(UtilControlli.differenzaGiorni(b.getVaccaDtComAutIngresso(), b.getVaccaDtIngresso()) <= 7){
		            			if(UtilControlli.differenzaGiorni(b.getVaccaDtInserBdnIngresso(), b.getVaccaDtComAutIngresso()) + contatoreFestivita <= 7){
		            				this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
		            			}else{
		            				this.capiSanzionati++;
		            				}
		            		}else{
		            			this.capiSanzionati++;
		            		}

						} else {

							listEsclusi.add(
									UtilControlli.generaEscluso(b, getSessione(), "", getAzienda().getCodicePremio()));

						}
					}

				}

			} else {

				throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_02002", getInput(),
						"Non è stato ragginuto il numero delle Uba minime necessarie al raggiungimento del premio"));

			}
		} else {

			throw new ControlloException(
					new Dmt_t_errore(getSessione(), "REF_02002", getInput(), "Nessuna vacca è stata ammessa a premio"));

		}
	}

	/**
	 * il metodo postEsecuzione effettua il salvataggio a db dei risultati
	 * dell'intervento
	 * 
	 * @throws ControlloException eccezione riferita al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void postEsecuzione() throws ControlloException {
		// ESECUZIONI CONTROLLI PER SOGGETTO
		Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
		outputControlli.setIdSessione(getSessione());
		outputControlli.setAnnoCampagna(getAzienda().getAnnoCampagna());
		outputControlli.setCapiAmmissibili(importoLiquidabile);
		outputControlli.setCapiSanzionati(capiSanzionati);
		outputControlli.setCapiRichiesti(new BigDecimal(modelVacche.size()));
		outputControlli.setCuaa(getAzienda().getCuaa());
		outputControlli.setIntervento(getAzienda().getCodicePremio());

		getControlliService().saveOutput(outputControlli);

		for (Dmt_t_output_esclusi o : listEsclusi)
			getControlliService().saveOutputEscl(o);
	}

	private void setListEsclusi(List<Dmt_t_Tws_bdn_du_capi_bovini> bovini, String motivazione) {

		for (Dmt_t_Tws_bdn_du_capi_bovini b : bovini) {

			Dmt_t_output_esclusi escluso = new Dmt_t_output_esclusi();
			escluso.setCalcolo(ClcInt311Mis2.class.getSimpleName());
			escluso.setCapoId(b.getCapoId());
			escluso.setMotivazioneEsclusione(motivazione);
			escluso.setIdSessione(getSessione());
//	        escluso.setIdSessione(getSessione().getIdSessione());
			listEsclusi.add(escluso);

		}

	}

	private void resetLists() {

		if (this.listEsclusi != null)
			this.listEsclusi.clear();

		if (this.modelVacche != null)
			this.modelVacche.clear();

		if (this.modelVaccheAmmesse != null)
			this.modelVaccheAmmesse.clear();

		if (this.modelVaccheAmmesseInt310Mis1 != null)
			this.modelVaccheAmmesseInt310Mis1.clear();

		if (this.modelVaccheAmmesseUba != null)
			this.modelVaccheAmmesseUba.clear();

		if (this.modelVaccheEscluse != null)
			this.modelVaccheEscluse.clear();

		if (this.importoLiquidabile.compareTo(BigDecimal.ZERO) > 0)
			this.importoLiquidabile = BigDecimal.ZERO;
	}

	@Override
	public <T> List<T> controlloCapiDichiarati(List<T> capiBDN) {

		List<T> listaCapiDichiarati = new ArrayList<T>();

		UtilControlli.clearList(listaCapiDichiarati);

		for (T capo : capiBDN)
			if (UtilControlli.controlloDataInterpartoBovino((Dmt_t_Tws_bdn_du_capi_bovini) capo,
					this.getControlliService(), this.getSessione().getIdSessione())
					&& UtilControlli.controlloRegistrazioneVitello((Dmt_t_Tws_bdn_du_capi_bovini) capo,
							getControlliService(), this.getSessione().getIdSessione(),
							this.getAzienda().getCodicePremio())
					&& UtilControlli.controlloStallaMontana((Dmt_t_Tws_bdn_du_capi_bovini) capo, this.capiBoviniService)
					&&
					// UtilControlli.controlloAmmissibilitaPremioPerPremiCompatibili(
					// (Dmt_t_Tws_bdn_du_capi_bovini) capo ) &&
					UtilControlli.controlloDemarcazione((Dmt_t_Tws_bdn_du_capi_bovini) capo, this.getControlliService(),
							this.getAzienda().getAnnoCampagna())
					&& UtilControlli.controlloParametriIgienicoSanitari((Dmt_t_Tws_bdn_du_capi_bovini) capo,
							this.getAzienda(), this.getControlliService())
					&& UtilControlli
							.controlloDetenzioneMinimaPerTempisticheRegistrazione((Dmt_t_Tws_bdn_du_capi_bovini) capo))
				listaCapiDichiarati.add(capo);

		return listaCapiDichiarati.isEmpty() ? Collections.emptyList() : listaCapiDichiarati;
	}

}
