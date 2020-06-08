package it.csi.demetra.demetraws.zoo.transformer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.JAXBException;

import it.csi.demetra.demetraws.srmanags.wsbridge2.Capo;
import it.csi.demetra.demetraws.srmanags.wsbridge2.CapoMacellato;
import it.csi.demetra.demetraws.srmanags.wsbridge2.CapoOvicaprino;
import it.csi.demetra.demetraws.srmanags.wsbridge2.CapoVacca;
import it.csi.demetra.demetraws.srmanags.wsbridge2.Response;
import it.csi.demetra.demetraws.srmanags.wsbridge2.WbAnagraficaAllevamentoVO;
import it.csi.demetra.demetraws.srmanags.wsbridge2.WbUbaCensimentoOvino2012VO;
import it.csi.demetra.demetraws.zoo.model.Dmt_d_clsPremio_ValidazioneResponse;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tbdn_du_capi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
public class TransformerData {
	public TransformerData() {
	}
	public Date transformDate(String date) throws ParseException {
		if (date == null)
			return null;
		if (date.contains("T"))
			date = date.replace("T", " ");

		List<String> formatterStrings = Arrays.asList("dd/MM/yyyy", "yyyy-MM-dd");
		for (String s : formatterStrings)
			try {
				return new SimpleDateFormat(s).parse(date);
			} catch (ParseException ignored) {
			}

		return null;
	}
	public Dmt_t_DsUBA_censimenti_allevamenti_ovini TransformDsUBA_censimenti_allevamenti_ovini(Response response, Dmt_t_sessione sessione)
			throws JAXBException {
		Dmt_t_DsUBA_censimenti_allevamenti_ovini model = new Dmt_t_DsUBA_censimenti_allevamenti_ovini();
		List<WbUbaCensimentoOvino2012VO> censimOvini = response.getVUbaCensimentoOvino2012();
		for (WbUbaCensimentoOvino2012VO x : censimOvini) {
			model.setCensimentoId(x.getIdCensimento());
			model.setpAllevId(x.getIdAllevamento());
			model.setAziendaCodice(x.getCodiceAzienda());
			model.setCodFiscaleProp(x.getCodFiscProprietario());
			model.setCodFiscaleDete(x.getCodFiscDetentore());
			model.setSpecieCodice(x.getCodiceSpecie());
			model.setSpecieDescrizione(x.getDescrizioneSpecie());
			model.setDataInizioPeriodo(x.getDataInizioPeriodo().toGregorianCalendar().getTime());
			model.setDataFinePeriodo(x.getDataFinePeriodo().toGregorianCalendar().getTime());
			model.setoMaschiAdulti(x.getOviniMaschiAdulti());
			model.setoMaschiAdultiLib(x.getOviniMaschiAdultiLib());
			model.setoFemmineAdulte(x.getOviniFemmineAdulte());
			model.setoFemmineAdulteLib(x.getOviniFemmineAdulteLib());
			model.setoMaschiRimonta(x.getOviniMaschiRimonta());
			model.setoMaschiRimontaLib(x.getOviniMaschiRimontaLib());
			model.setoFemmineRimonta(x.getOviniFemmineRimonta());
			model.setoFemmineRimontaLib(x.getOviniFemmineRimontaLib());
			model.setoCapiTot(x.getOviniCapiTotali());
			model.setoAgnelliMacTot(x.getAgnelliMacellatiTotali());
			model.setcMaschiAdulti(x.getCapriniMaschiAdulti());
			model.setcMaschiAdultiLib(x.getCapriniMaschiAdultiLib());
			model.setcFemmineAdulte(x.getCapriniFemmineAdulte());
			model.setcFemmineAdulteLib(x.getCapriniFemmineAdulteLib());
			model.setcMaschiRimonta(x.getCapriniMaschiRimonta());
			model.setcMaschiRimontaLib(x.getCapriniMaschiRimontaLib());
			model.setcFemmineRimonta(x.getCapriniFemmineRimonta());
			model.setcFemmineRimontaLib(x.getCapriniFemmineRimontaLib());
			model.setcCapiTot(x.getCapriniCapiTotali());
			model.setcCaprettiMacTot(x.getCaprettiMacellatiTotali());
			model.setDataCensimento(x.getDataCensimento().toGregorianCalendar().getTime());
			model.setDtComAutorita(x.getDataComunicazioneAutorita().toGregorianCalendar().getTime());
			model.setCodQualificaScrapie(x.getCodiceQualificaScrapie());
			model.setDescrQualificaScrapie(x.getDescrQualificaScrapie());
			model.setDataRilevazioneQualifica(x.getDataRilevazioneQualifica().toGregorianCalendar().getTime());
			model.setIdSessione(sessione);
		}
		return model;
	}
	public Dmt_d_clsPremio_ValidazioneResponse TransformDmt_d_clsPremio_ValidazioneResponse(Response response, Dmt_t_sessione sessione, String codiceIntervento)
			throws JAXBException, ParseException {
		
//		System.out.println("ID SESSIONE IN TransformerData: " + sessione.getIdSessione());
		
		
		List<Capo> listaCapi = response.getVCapi(); // DEPRECARIATA E NON MOSTRATA SULLA DOCUMENTAZIONE BDN
		List<CapoOvicaprino> listaCapiOvicaprini = response.getVCapiOvicaprini();
		List<CapoMacellato> listaCapoMacellato = response.getVCapiMacellati();
		List<CapoVacca> listaCapoVacca = response.getVCapiVacche();
		long numeroCapi = listaCapi.size() + listaCapiOvicaprini.size() + listaCapoMacellato.size()
				+ listaCapoVacca.size();
		Dmt_d_clsPremio_ValidazioneResponse model = new Dmt_d_clsPremio_ValidazioneResponse();
		List<Dmt_t_Tws_bdn_du_capi_ovicaprini> ovicaprini = new ArrayList<Dmt_t_Tws_bdn_du_capi_ovicaprini>();
		List<Dmt_t_clsCapoMacellato> capiMacellati = new ArrayList<Dmt_t_clsCapoMacellato>();
		List<Dmt_t_Tws_bdn_du_capi_bovini> capiBovini = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();
		List<Dmt_t_Tbdn_du_capi> capi = new ArrayList<Dmt_t_Tbdn_du_capi>();
		
		if(! ( listaCapiOvicaprini.isEmpty() ) )
			for (CapoOvicaprino x : listaCapiOvicaprini) {
				Dmt_t_Tws_bdn_du_capi_ovicaprini temp = new Dmt_t_Tws_bdn_du_capi_ovicaprini();
				temp.setAllevId(x.getAllevId());
				temp.setCapoId(x.getCapoId());
				temp.setAziendaCodice(x.getAziendaCodice());
				temp.setCodice(x.getCodice());
				temp.setConsMedia(x.getConsMedia());
				temp.setCuaa(x.getCuaa());
				temp.setDtApplMarchio(transformDate(x.getDtApplMarchio()));
				temp.setDtComMacellazione(transformDate(x.getDtComMacellazione()));
				temp.setDtComNascita(transformDate(x.getDtComNascita()));
				temp.setDtFineDetenzione(transformDate(x.getDtFineDetenzione()));
				temp.setDtInizioDetenzione(transformDate(x.getDtInizioDetenzione()));
				temp.setDtInserimentoBdnNascita(transformDate(x.getDtInserimentoBdnNascita()));
				temp.setDtMacellazione(transformDate(x.getDtMacellazione()));
				temp.setDtNascita(transformDate(x.getDtNascita()));
				temp.setDtRegistrMacellazione(transformDate(x.getDtRegistrMacellazione()));
				temp.setDtUltimoPrelProfilassi(transformDate(x.getDtUltimoPrelProfilassi()));
				temp.setFlagDelegatoNascita(x.getFlagDelegatoNascita());
				temp.setGenotipo(x.getGenotipo());
				temp.setRazzaCodice(x.getRazzaCodice());
				temp.setRuoloUtenteNascita(x.getRuoloUtenteNascita());
				temp.setSesso(x.getSesso());
				temp.setIdSessione(sessione);
				temp.setCodicePremio(codiceIntervento);
				ovicaprini.add(temp);
			}
		if(! ( listaCapoMacellato.isEmpty() ) )
			for (CapoMacellato x : listaCapoMacellato) {
				Dmt_t_clsCapoMacellato temp = new Dmt_t_clsCapoMacellato();
				temp.setCapoId(x.getCapoId());
				temp.setAllevId(x.getAllevId());
				temp.setCodice(x.getCodice());
				temp.setRazzaCodice(x.getRazzaCodice());
				temp.setSesso(x.getSesso());
				temp.setDtNascita(transformDate(x.getDtNascita()));
				temp.setAziendaCodice(x.getAziendaCodice());
				temp.setAziendaLatitudine(x.getAziendaLatitudine());
				temp.setAziendaLongitudine(x.getAziendaLongitudine());
				temp.setDtIngresso(transformDate(x.getDtIngresso()));
				temp.setDtMacellazione(transformDate(x.getDtMacellazione()));
				temp.setCodLibro(x.getCodLibro());
				temp.setDescrLibro(x.getDescrLibro());
				temp.setDtComAutoritaIngresso(transformDate(x.getDtComAutoritaIngresso()));
				temp.setDtInserimentoBdnIngresso(transformDate(x.getDtInserimentoBdnIngresso()));
				temp.setCuaa(x.getCuaa());
				temp.setDtComAutoritaUscita(transformDate(x.getDtComAutoritaUscita()));
				temp.setDtUscita(transformDate(x.getDtUscita()));
				temp.setDtInserimentoBdnUscita(transformDate(x.getDtInserimentoBdnUscita()));
				temp.setDtInizioDetenzione(transformDate(x.getDtInizioDetenzione()));
				temp.setDtFineDetenzione(transformDate(x.getDtFineDetenzione()));
				temp.setFlagDelegatoUscita(x.getFlagDelegatoUscita());
				temp.setFlagDelegatoIngresso(x.getFlagDelegatoIngresso());
				temp.setIdSessione(sessione);
				temp.setCodicePremio(codiceIntervento);
				capiMacellati.add(temp);
			}
		if(! ( listaCapoVacca.isEmpty() ) )
			for (CapoVacca x : listaCapoVacca) {
				Dmt_t_Tws_bdn_du_capi_bovini temp = new Dmt_t_Tws_bdn_du_capi_bovini();
				temp.setAllev_id(x.getAllevId());
				temp.setAziendaCodice(x.getAziendaCodice());
				temp.setAziendaLatitudine(x.getAziendaLatitudine());
				temp.setAziendaLongitudine(x.getAziendaLongitudine());
				temp.setCapoId(x.getCapoId());
				temp.setCodLibro(x.getCodLibro());
				temp.setCodice(x.getCodice());
				temp.setCodiceVitello(x.getCodiceVitello());
				temp.setCuaa(x.getCuaa());
				temp.setDescLibro(x.getDescrlibro());
				temp.setDtFineDetenzione(transformDate(x.getDtFineDetenzione()));
				temp.setDtInizioDetenzione(transformDate(x.getDtInizioDetenzione()));
				temp.setDataNascita(transformDate(x.getDtNascita()));
				temp.setDtNascitaVitello(transformDate(x.getDtNascitaVitello()));
				temp.setFlagDelegato(x.getFlagDelegato());
				temp.setFlagDelegatoIngressoVacca(x.getFlagDelegatoIngressoVacca());
				temp.setFlagDelegatoIngressoVitello(x.getFlagDelegatoIngressoVitello());
				temp.setFlagDelegatoNascitaVitello(x.getFlagDelegatoNascitaVitello());
				temp.setFlagIbr(x.getFlagIBR());
				temp.setFlagProrogaMarcatura(x.getFlagProrogaMarcatura());
				temp.setFlagRispettoPrevalenzaIbr(x.getFlagRispettoPrevalenzaIBR());
				temp.setRazzaCodice(x.getRazzaCodice());
				temp.setSesso(x.getSesso());
				temp.setSessoVitello(x.getSessoVitello());
				temp.setVaccaDtComAutIngresso(transformDate(x.getVaccaDtComAutoritaIngresso()));
				temp.setVaccaDtIngresso(transformDate(x.getVaccaDtIngresso()));
				temp.setVaccaDtInserBdnIngresso(transformDate(x.getVaccaDtInserimentoBdnIngresso()));
				temp.setVitelloCapoId(x.getVitelloCapoId());
				temp.setVitelloDtApplMarchio(transformDate(x.getVitelloDtApplMarchio()));
				temp.setVitelloDtComAutIngresso(transformDate(x.getVitelloDtComAutoritaIngresso()));
				temp.setVitelloDtComAutNascita(transformDate(x.getVitelloDtComAutoritaNascita()));
				temp.setVitello_data_ins_bdn_ingresso(transformDate(x.getVitelloDtInserimentoBdnIngresso()));
				temp.setVitelloDtInserBdnNascita(transformDate(x.getVitelloDtInserimentoBdnNascita()));
				temp.setVitelloTipoOrigine(x.getVitelloTipoOrigine());
				temp.setIdSessione(sessione);
				temp.setCodicePremio(codiceIntervento);
				capiBovini.add(temp);
			}
		if(! ( listaCapi.isEmpty() ) )
			for (Capo x : listaCapi) {
				Dmt_t_Tbdn_du_capi temp = new Dmt_t_Tbdn_du_capi();
				temp.setAllevId(x.getAllevId());
				temp.setAziendaCodice(x.getAziendaCodice());
				temp.setCapoCodMadre(x.getCapoCodMadre());
				temp.setCapoId(x.getCapoId());
				temp.setCodLibroMadre(x.getCodLibroMadre());
				temp.setCodice(x.getCodice());
				temp.setDescLibroMadre(x.getDescLibroMadre());
				temp.setDtFineDetenzione(transformDate(x.getDtFineDetenzione()));
				temp.setDtInizioDetenzione(transformDate(x.getDtInizioDetenzione()));
				temp.setDtMacellazione(transformDate(x.getDtMacellazione()));
				temp.setDtNascita(transformDate(x.getDtNascita()));
				temp.setRazzaCodice(x.getRazzaCodice());
				temp.setSesso(x.getSesso());
				temp.setIdSessione(sessione);
				temp.setCodicePremio(codiceIntervento);
				capi.add(temp);
			}
		
		if(Objects.isNull(response)) {
//			System.out.println("RESPONSE NULL");
			model.setErrCod("-1");
			model.setErrDescr("dati non disponibili");
		}
		else {
			model.setErrCod("0");
			model.setErrDescr("nessun errore occorso");
//			System.out.println("RESPONSE NOT NULL");
		}
			model.setNumeroCapi(numeroCapi);
			
			model.setIdSessione(sessione);
//			System.out.println("MODEL ID SESSIONE: " + model.getSessione().getIdSessione());
		
		if(!( capiMacellati.isEmpty() ) ) {
			
			model.setClsCapoMacellato(capiMacellati);
		}
		
		if(!( ovicaprini.isEmpty() ) ) {
		
			model.setClsCapoOvicaprino(ovicaprini);
		}
		
		
		if(!( capiBovini.isEmpty() ) ) {
			model.setClsCapoVacca(capiBovini);
		}
		
		if(!( capi.isEmpty() ) ) {
			model.setClsCapo(capi);
		}
		return model;
	}

	public List<Dmt_t_anagrafica_allevamenti> getWbAnagraficaAllevamenti(Response response, Dmt_t_sessione sessione,
			String codiceIntervento) throws ParseException {
		List<Dmt_t_anagrafica_allevamenti> anagraficaAllevamenti = new ArrayList<>();
		List<WbAnagraficaAllevamentoVO> anagraficaAllevamentiBdn = response.getVAnagAllevamenti();

		for (WbAnagraficaAllevamentoVO anagrafica : anagraficaAllevamentiBdn) {

			Dmt_t_anagrafica_allevamenti model = new Dmt_t_anagrafica_allevamenti();

			model.setAutorizzazioneLatte(anagrafica.getAutorizzazioneLatte());
			model.setAllevId(anagrafica.getIdAllevamento());
			model.setAziendacodice(anagrafica.getCodiceAzienda());
			model.setCap(anagrafica.getCap());
			model.setCapiTotali(anagrafica.getCapiTotali());
			model.setCod_fiscale_deten(anagrafica.getCodiceFiscaleDetentore());
			model.setCodFiscaleProp(anagrafica.getCodiceFiscaleProprietario());
			model.setComune(anagrafica.getComune());
			model.setDataCalcoloCapi(this.transformDate(anagrafica.getDataCalcoloCapi()));
			model.setDenomDetentore(anagrafica.getDenominazioneDetentore());
			model.setDenominazione(anagrafica.getDenominazione());
			model.setDenomProprietario(anagrafica.getDenominazioneProprietario());
			model.setDtFineAttivita(this.transformDate(anagrafica.getDataFineAttivita()));
			model.setDtFineDetentore(this.transformDate(anagrafica.getDataFineDetentore()));
			model.setDtInizioAttivita(this.transformDate(anagrafica.getDataInizioAttivita()));
			model.setDtInizoDetentore(this.transformDate(anagrafica.getDataInizioDetentore()));
			model.setFoglioCatastale(anagrafica.getFoglioCatastale());
			model.setIndirizzo(anagrafica.getIndirizzo());
			model.setLatitudine(anagrafica.getLatitudine());
			model.setLocalita(anagrafica.getLocalita());
			model.setLongitudine(anagrafica.getLongitudine());
			model.setOrientamentoProduttivo(anagrafica.getOrientamentoProduttivo());
			model.setParticella(anagrafica.getParticella());
			model.setIdSessione(sessione);
			model.setSezione(anagrafica.getSezione());
			model.setSoccida(anagrafica.getSoccida());
			model.setSpeCodice(anagrafica.getCodiceSpecie());
			model.setSubalterno(anagrafica.getSubAlterno());
			model.setTipoAllevCod(anagrafica.getTipoAllevamentoCodice());
			model.setTipoAllevDescr(anagrafica.getTipoAllevamentoDescrizione());
			model.setTipoProduzione(anagrafica.getTipoProduzione());

			anagraficaAllevamenti.add(model);
		}

			return anagraficaAllevamenti;
	}
}