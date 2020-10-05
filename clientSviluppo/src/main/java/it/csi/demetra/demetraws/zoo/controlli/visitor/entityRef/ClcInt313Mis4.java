package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_tws_bdn_du_capi_bovini_services;

/**
 * controlli da applicare per il calcolo del premio zootecnia per l’intervento
 * 313 – Misura 4:<br>
 * vacche nutrici di razze da carne o a duplice attitudine iscritte nei Libri
 * genealogici o nel Registro anagrafico delle razze bovine
 * 
 * @author Federico Pomponii
 */
@Component("ClcInt313Mis4")
public class ClcInt313Mis4 extends Controllo {

	@Autowired
	CtlVerificaRegistrazioneCapi ref9901;
	@Autowired
	CtlUbaMinime ref9903;
	@Autowired
	Dmt_t_tws_bdn_du_capi_bovini_services capiBoviniService;

	/* MODEL DA INIZIALIZZARE PER I CONTROLLI */
	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheFiltrate;
	private BigDecimal importoLiquidabile;
	private BigDecimal importoRichiesto;
	private List<Dmt_t_output_esclusi> listEsclusi = new ArrayList<>();
	private ResultCtlUbaMinime ubaMin;

	private void init() {
		listEsclusi = new ArrayList<>();
		importoRichiesto = null != modelVacche ? new BigDecimal(modelVacche.size()) : BigDecimal.ZERO;
		importoLiquidabile = new BigDecimal(0);
		modelVaccheFiltrate = null;
		ubaMin = null;
	}

	/**
	 * il metodo preEsecuzione utilizza i controlli:
	 * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi} e
	 * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void preEsecuzione() throws ControlloException {
		// RECUPERO DATI DALLA BDN
		// modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(),
		// getAzienda().getCuaa(), getAzienda().getCodicePremio());
		modelVacche = this.controlloCapiDichiarati(getControlliService().getAllBoviniSessioneCuua(getSessione(),
				getAzienda().getCuaa(), getAzienda().getCodicePremio()));
		init();
		if (modelVacche != null && modelVacche.size() > 0) {
			try {
				ref9901.init(modelVacche, getSessione().getIdSessione(), getAzienda().getCodicePremio(),
						Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());
				modelVacche = ref9901.calcolo();
			} catch (CalcoloException e) {
				throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9901", getInput(), e.getMessage()));
			}

			try {
				ref9903.init(modelVacche, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()),
						getAzienda().getCuaa(), getSessione());
				ubaMin = ref9903.calcolo();
				if (ubaMin.isErrors())
					throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
				else if (!ubaMin.isResult())
					throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt310Mis1", getInput(),
							"controllo uba minime non rispettato"));
			} catch (CalcoloException e) {
				throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
			}

			this.modelVaccheFiltrate = capiBoviniService.getBoviniUbaMinime(getSessione().getIdSessione(),
					getAzienda().getCuaa(), getAzienda().getCodicePremio());

		}
	}

	/**
	 * il metodo esecuzione effettua l'esecuzione dei controlli per l'intervento 313
	 * Misura 4
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void esecuzione() throws ControlloException {
		if (null == modelVaccheFiltrate)
			return;

		importoLiquidabile = BigDecimal.ZERO;
		try {
			for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVaccheFiltrate) {

				// SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CAA

				if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
						this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), b.getCapoId(),
						this.getControlliService())) {

					importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);

				} else {
					
					//ALTRIMENTI SI PROCEDE ALLA DETERMINAZIONE DEL BENEFICIARIO DEL CAPO DOPPIO IN MANIERA CLASSICA

					List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService()
							.getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());
					if (!UtilControlli.isDetentoreParto(b, listVitelli)) {
						this.listEsclusi.add(UtilControlli.generaEscluso(b, getSessione(),
								"Il richiedente non è detentore del capo al momento del parto",
								getAzienda().getCodicePremio()));
						continue;
					} else
						importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
				}
			}
		} catch (NullPointerException e) {
			throw new ControlloException(
					new Dmt_t_errore(getSessione(), "esecuzione", getInput(), "nessun capo disponibile"));
		}
	}

	/**
	 * il metodo postEsecuzione effettua il salvataggio a db dei risultati
	 * dell'intervento
	 * 
	 * @throws ControlloException eccezione relativa al controllo di tipo
	 *                            {@link ControlloException}
	 */
	@Override
	public void postEsecuzione() throws ControlloException {
		// ESECUZIONI CONTROLLI PER SOGGETTO
		Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
		outputControlli.setIdSessione(getSessione());
		outputControlli.setAnnoCampagna(getAzienda().getAnnoCampagna());
		outputControlli.setCapiAmmissibili(importoLiquidabile);
		outputControlli.setCapiRichiesti(importoRichiesto);
		outputControlli.setCuaa(getAzienda().getCuaa());
		outputControlli.setIntervento(getAzienda().getCodicePremio());

		getControlliService().saveOutput(outputControlli);

		for (Dmt_t_output_esclusi o : listEsclusi)
			getControlliService().saveOutputEscl(o);

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
					&&
					// UtilControlli.controlloAmmissibilitaPremioPerPremiCompatibili(
					// (Dmt_t_Tws_bdn_du_capi_bovini) capo ) &&
					UtilControlli.controlloDemarcazione((Dmt_t_Tws_bdn_du_capi_bovini) capo, this.getControlliService(),
							this.getAzienda().getAnnoCampagna()))
				listaCapiDichiarati.add(capo);

		return listaCapiDichiarati.isEmpty() ? Collections.emptyList() : listaCapiDichiarati;
	}
}
