package it.csi.demetra.demetraws.zoo;

import it.csi.demetra.demetraws.srmanags.wsbridge2.Response;
import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridge2;
import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeInternalException_Exception;
import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeService;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_errore_services;
import it.csi.demetra.demetraws.zoo.services.SaveOnDbService;
import it.csi.demetra.demetraws.zoo.transformer.TransformerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Component
public class BdnWsManagerImpl {


    @Autowired
    SaveOnDbService save;

    @Autowired
    Dmt_t_errore_services erroreService;

    WSBridge2 wsBridge2;

    Response response;

    public BdnWsManagerImpl() {
        connectWsBridge2();
    }

    public void connectWsBridge2() {


        this.wsBridge2 = new WSBridgeService().getWSBridge2Port();

        System.out.println("[BdnWsManagerImpl.connectWsBridge2] - END.");
    }

    public void getAnagraficaAllevamenti(String cuaa, Date dataRichiesta, String codiceIntervento, Dmt_t_sessione sessione) {
        try {
            String dataRichiestaString;

            if (dataRichiesta != null)
                dataRichiestaString = String.valueOf(dataRichiesta);
            else
                dataRichiestaString = "";

            response = wsBridge2.getAnagraficaAllevamenti(cuaa, dataRichiestaString);

            if (response.getInfo().equals("0"))
                throw new NullPointerException();

            TransformerData transform = new TransformerData();

            List<Dmt_t_anagrafica_allevamenti> bean = transform.getWbAnagraficaAllevamenti(this.response, sessione, codiceIntervento);

            save.saveOnDb(bean);


        } catch (WSBridgeInternalException_Exception | NullPointerException | ParseException e) {
            System.out.println(e.getMessage());

            Dmt_t_errore errore = new Dmt_t_errore();
            String input = codiceIntervento + " | " + cuaa + " | " + dataRichiesta + " | " + codiceIntervento + " | " + sessione.getIdSessione();
            errore.setErrorecodice("-1");
            errore.setErroreDesc("dati non disponibili");
            errore.setNomeMetodo("getAnagraficaAllevamenti");
            errore.setInput(input);
            errore.setIdSessione(sessione);
            erroreService.saveError(errore);
        }
    }


    public void getElencoCapiPremio(String codiceIntervento, String cuaa, Integer anno_campagna, Dmt_t_sessione sessione) {

        try {
            response = wsBridge2.getElencoCapiPremioNew(codiceIntervento, cuaa, anno_campagna);

//			System.out.println("RESPONSE INFO: " + response.getInfo());
//			System.out.println("RESPONSE COD RET: " + response.getCodRet());
//			System.out.println("RESPONSE CODICE ERRORE: " + response.getCodiceErrore());
//			System.out.println("RESPONSE DESCRIZIONE ERRORE: " + response.getDescrizioneErrore());
//			System.out.println("RESPONSE ESITO: " + response.getEsito());
//			
//			System.out.println("ID SESSIONE IN BdnWsManagerImpl METODO GET_ELENCO_CAPI_PREMIO: " + sessione.getIdSessione());


            if (response.getInfo().equals("0"))
                throw new NullPointerException();

            TransformerData transform = new TransformerData();
            Dmt_d_clsPremio_ValidazioneResponse bean = transform.TransformDmt_d_clsPremio_ValidazioneResponse(response, sessione, codiceIntervento);
            // lavora i dati raccolti
            save.saveOnDb(bean);
        } catch (WSBridgeInternalException_Exception | NullPointerException | IndexOutOfBoundsException | IllegalStateException e1) {
            /* SALVARE A DB RESPONSE.GETCODICEERRORE E RESPONSE.GETDESCRIZIONEERRORE */
//			System.out.println("LA CHIAMATA AL METODO DELLA BDN E' NULL GET ELENCO CAPI PREMIO");
            Dmt_t_errore errore = new Dmt_t_errore();

            String input = codiceIntervento + " | " + cuaa + " | " + anno_campagna + " | " + sessione.getIdSessione();

            errore.setErrorecodice("-1");
            errore.setErroreDesc("dati non disponibili");
            errore.setNomeMetodo("getElencoCapiPremioNew");
            errore.setInput(input);
//			System.out.println("ID SESSIONE ERRORE: " + sessione.getIdSessione());
            errore.setIdSessione(sessione);
            erroreService.saveError(errore);

//			System.out.println("FINE SALVATAGGIO A DB DELL'ERRORE");

        } catch (JAXBException | ParseException e) {
            System.out.println(e.getCause() + ", " + e.getMessage());
        }
    }

    public void getElencoCapiPremio2(Long idAlleBdn, String codiceIntervento, String cuaa, String cuua2,
                                     Integer annoCampagna, Dmt_t_sessione sessione) throws JAXBException, WSBridgeInternalException_Exception, ParseException {
        // prendi i dati con chiamata http dalla bdn
        try {
            response = wsBridge2.getElencoCapiPremio2New(idAlleBdn, codiceIntervento, cuaa, cuua2, annoCampagna);
//				System.out.println("RESPONSE INFO: " + response.getInfo());
//				System.out.println("RESPONSE COD RET: " + response.getCodRet());
//				System.out.println("RESPONSE CODICE ERRORE: " + response.getCodiceErrore());
//				System.out.println("RESPONSE DESCRIZIONE ERRORE: " + response.getDescrizioneErrore());
//				System.out.println("RESPONSE ESITO: " + response.getEsito());
//				
//				System.out.println("ID SESSIONE IN BdnWsManagerImpl METODO GET_ELENCO_CAPI_PREMIO 2: " + sessione.getIdSessione());

            if (response.getInfo().equals("0"))
                throw new NullPointerException();

            TransformerData transform = new TransformerData();
            Dmt_d_clsPremio_ValidazioneResponse bean = transform.TransformDmt_d_clsPremio_ValidazioneResponse(response, sessione, codiceIntervento);
            save.saveOnDb(bean);

        } catch (WSBridgeInternalException_Exception | NullPointerException | IndexOutOfBoundsException | IllegalStateException | WebServiceException e1) {
            /* SALVARE A DB RESPONSE.GETCODICEERRORE E RESPONSE.GETDESCRIZIONEERRORE */
//			System.out.println("LA CHIAMATA AL METODO DELLA BDN E' NULL METODO GET ELENCO CAPI PREMIO 2");
            Dmt_t_errore errore = new Dmt_t_errore();

            String input = idAlleBdn + " | " + codiceIntervento + " | " + cuaa + " | " + cuua2 + " | " + annoCampagna + " | " + sessione.getIdSessione();

            errore.setErrorecodice("-1");
            errore.setErroreDesc("dati non disponibili");
            errore.setNomeMetodo("getElencoCapiPremioNew");
            errore.setNomeMetodo("getElencoCapiPremio2New");
            errore.setInput(input);
//			System.out.println("ID SESSIONE ERRORE: " + sessione.getIdSessione());
            errore.setIdSessione(sessione);
            erroreService.saveError(errore);

//			System.out.println("FINE SALVATAGGIO A DB DELL'ERRORE");

        } catch (JAXBException | ParseException e) {
            System.out.println(e.getCause() + ", " + e.getMessage());
        }
    }

    public void Consistenza_UBA_Censim_Ovini_2012(String p_cuaa, String data_inizio_periodo, String Data_fine_periodo,
                                                  String p_tipo_responsabilita, Dmt_t_sessione sessione) {
        try {
            response = wsBridge2.getConsistenzaUbaCensimOvini2012(p_cuaa, data_inizio_periodo, Data_fine_periodo, p_tipo_responsabilita);

//				System.out.println("RESPONSE INFO: " + response.getInfo());
//				System.out.println("RESPONSE COD RET: " + response.getCodRet());
//				System.out.println("RESPONSE CODICE ERRORE: " + response.getCodiceErrore());
//				System.out.println("RESPONSE DESCRIZIONE ERRORE: " + response.getDescrizioneErrore());
//				System.out.println("RESPONSE ESITO: " + response.getEsito());
//				
//				System.out.println("ID SESSIONE IN BdnWsManagerImpl METODO CENSIM_UBA: " + sessione.getIdSessione());

            if (response.getInfo().equals("0"))
                throw new NullPointerException();

            TransformerData transform = new TransformerData();
            Dmt_t_DsUBA_censimenti_allevamenti_ovini bean = transform.TransformDsUBA_censimenti_allevamenti_ovini(response, sessione);
            save.saveOnDb(bean, sessione);
        } catch (WSBridgeInternalException_Exception | NullPointerException | IndexOutOfBoundsException | IllegalStateException | ConstraintViolationException e1) {

            /* SALVARE A DB RESPONSE.GETCODICEERRORE E RESPONSE.GETDESCRIZIONEERRORE */
//			System.out.println("LA CHIAMATA AL METODO DELLA BDN E' NULL UBA CENSIM OVINI");
            Dmt_t_errore errore = new Dmt_t_errore();

//			if(response.getCodiceErrore().equals(""))
//				System.out.println("CODICE ERRORE VUOTO");
//			else
//				System.out.println("CODICE ERRORE PIENO");

            String input = p_cuaa + " | " + data_inizio_periodo + " | " + Data_fine_periodo + " | " + p_tipo_responsabilita + " | " + sessione.getIdSessione();

            errore.setErrorecodice("-1");
            errore.setErroreDesc("dati non disponibili");
            errore.setNomeMetodo("GetConsistenzaUbaCensimOVini2012");
            errore.setInput(input);
//			System.out.println("ID SESSIONE ERRORE: " + sessione.getIdSessione());
            errore.setIdSessione(sessione);
            System.out.println("---  PRINT ERRORE -----");
            System.out.println(sessione);
            System.out.println(errore);
            erroreService.saveError(errore);

//			System.out.println("FINE SALVATAGGIO A DB DELL'ERRORE");

        } catch (JAXBException e) {
            System.out.println(e.getCause() + ", " + e.getMessage());

        }
    }

    public void duplicaSessioneByCuaa(Rpu_V_pratica_zoote azienda, Dmt_t_sessione sessioneOld, Dmt_t_sessione sessioneNew) {
        save.duplicaSessioneByCuaa(azienda, sessioneOld, sessioneNew);
    }
}
