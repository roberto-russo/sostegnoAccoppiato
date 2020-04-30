package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;

@Component("ClcInt322Mis20")
public class ClcInt322Mis20 extends Controllo {

	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
	private List<Dmt_t_Tws_bdn_du_capi_bovini> listaFigliVacca;
	private int numeroCapiAmmissibili;
	private int numeroCapiRichiesti;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClcInt322Mis20.class);
	@Autowired
	private CtlVerificaRegistrazioneCapi ref9901;
	@Autowired
	private CtlUbaMinime ref9903;
	private Dmt_t_output_controlli oc;
	private List<Dmt_t_contr_loco> estrazioneACampione;
	private int numeroCapiBocciati;
	private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiBocciati;
	private Dmt_t_output_esclusi outputEsclusi;
	private String motivazione;

	public ClcInt322Mis20() {
		this.numeroCapiAmmissibili = 0;
		this.numeroCapiBocciati = 0;
		this.numeroCapiRichiesti = 0;
		this.modelVacche = null;
		this.listaFigliVacca = null;
		this.oc = null;
		this.estrazioneACampione = null;
		this.listaCapiBocciati = new ArrayList<>();
		this.outputEsclusi = null;
		this.motivazione = null;
	}

	@Override
	public void preEsecuzione() throws ControlloException {
		this.numeroCapiAmmissibili = 0;
		this.numeroCapiBocciati = 0;
		this.numeroCapiRichiesti = 0;
		LOGGER.info("inizio preEsecuzione()");

		// LE VACCHE CHE SUPERANO QUESTI CONTROLLI SARANNO NELLA LISTA modelVacche

		ref9901.init(
				getControlliService().getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(),
						getAzienda().getCodicePremio()),
				getSessione().getIdSessione(), getAzienda().getCodicePremio(),
				Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());

		try {
			this.modelVacche = ref9901.calcolo();
		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9901", getInput(), e.getMessage()));
		}

		ref9903.init(this.modelVacche, getAzienda().getCodicePremio(),
				Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());

		try {
			ref9903.calcolo();
		} catch (CalcoloException e) {
			throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
		}
	}

	@Override
	public void esecuzione() throws ControlloException {
		LOGGER.info("inizio esecuzione()");
//this.modelVacche=getControlliService().getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(),
//		getAzienda().getCodicePremio());
		// SE E' NULL ALLORA NON E' ESTRATTO A CAMPIONE
		this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa());
		numeroCapiRichiesti = getControlliService()
				.getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()).size();
		
		
		if (this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {

			try {
				for (Dmt_t_Tws_bdn_du_capi_bovini b : this.modelVacche) {

					System.out.println("QUI NON MI VEDI PIU'");
					this.listaFigliVacca = getControlliService().getVitelliNatiDaBovini(getSessione().getIdSessione(),
							b.getCapoId(), getAzienda().getCodicePremio());
					Date giovane = b.getDtNascitaVitello()!=null?b.getDtNascitaVitello():null;

					for (Dmt_t_Tws_bdn_du_capi_bovini b2 : listaFigliVacca)
						if(giovane==null && null != b2.getDtNascitaVitello()) {
							giovane = b2.getDtNascitaVitello();
						} else if (null != b2.getDtNascitaVitello() && b2.getDtNascitaVitello().after(giovane)) {
							giovane = b2.getDtNascitaVitello();
//							else if (b2.getDtNascitaVitello().before(giovane))
//								giovane = b.getDtNascitaVitello();
						}
					/*
					 * L’aiuto spetta al richiedente detentore della vacca al momento del parto.
					 * Qualora la vacca abbia partorito più di una volta nel corso dell’anno presso
					 * la stalla di diversi detentori susseguitisi nel tempo, il premio è erogato al
					 * detentore presso il quale è nato il primo capo.
					 */
					if ((b.getDtFineDetenzione().after(giovane) && b.getDtInizioDetenzione().before(giovane))) {
						this.numeroCapiAmmissibili++;
						LOGGER.info("controllo superato");
					} else {
						// CONTROLLO FALLITO
						LOGGER.info("controllo fallito");
						this.numeroCapiBocciati++;
						this.listaCapiBocciati.add(b);
						this.motivazione = " il richiedente " + getAzienda().getCuaa()
								+ " non e' il detentore dell'allevamento presso cui e'nato il primo capo";
					}
				}
				LOGGER.info("prima di lanciare l'eccezione");
				if (numeroCapiAmmissibili == 0) {
					LOGGER.info("eccezione lanciata");
					throw new ControlloException("per il cuaa " + getAzienda().getCuaa() + " nessun capo ha suprato il controllo per il premio 322 misura 20");	
				}
					
			} catch (ControlloException e) {
				// GESTIONE DEL FALLIMENTO DELL'ESECUZIONE
				System.out.println(e.getMessage());
				new Dmt_t_errore(getSessione(), "ref02_006", getInput(), e.getMessage());
			}

		} else
			// GESTIONE CONTROLLI BY DMT_CONTR_LOCO
			for (Dmt_t_contr_loco c : this.estrazioneACampione)
				if (!c.getAnomalie_cgo().contains("B"))
					this.numeroCapiAmmissibili++;
	}

	@Override
	public void postEsecuzione() throws ControlloException {

		LOGGER.info("inizio esecuzione metodo -> postEsecuzione()");
		
		LOGGER.info("capi ammissibili: " + this.numeroCapiAmmissibili);
		LOGGER.info("capi bocciati: " + this.numeroCapiBocciati);
		LOGGER.info("capi richiesti: " + this.numeroCapiRichiesti);

		if (this.numeroCapiAmmissibili != 0) {
			
			LOGGER.info("salvo a db le informazioni dei capi ammessi a premio");
			LOGGER.info("il numero di capi ammissibili al premio 322 misura 20 per l'azienda " + getAzienda().getCuaa()
					+ "e': " + this.numeroCapiAmmissibili);
			// SE NON SONO STATI RISCONTRATI ERRORI ALLORA POSSO SALVARE A DB QUI SALVARE
			// SIA I CAPI RICHIESTI CHE I CAPI AMMISSIBILI A PREMIO
			this.oc = new Dmt_t_output_controlli();
			this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
			this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
			this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
			this.oc.setCuaa(getAzienda().getCuaa());
			// PERCHE' QUI ENTRANO SOLO LE AZIENDE CON CODICE PREMIO = 322
			this.oc.setIntervento(getAzienda().getCodicePremio());
			this.oc.setSessione(getSessione());
			getControlliService().saveOutput(this.oc);

		}

		if (this.numeroCapiBocciati != 0) {
			// SALVARE A DB IL NUMERO DI CAPI BOCCIATI
			LOGGER.info("salvo a db le informazioni dei capi non ammessi a premio");
			this.outputEsclusi = new Dmt_t_output_esclusi();

			for (Dmt_t_Tws_bdn_du_capi_bovini x : this.listaCapiBocciati) {

				this.outputEsclusi.setCalcolo("ClcInt322Mis20");
				this.outputEsclusi.setCapoId(x.getCapoId());
				this.outputEsclusi.setSessione(getSessione());
				this.outputEsclusi.setIdSessione(getSessione().getIdSessione());
				this.outputEsclusi.setMotivazioneEsclusione(this.motivazione);
				this.getControlliService().saveOutputEscl(this.outputEsclusi);
			}

		}
	}
}