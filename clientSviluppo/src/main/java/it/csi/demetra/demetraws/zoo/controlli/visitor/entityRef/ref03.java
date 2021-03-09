package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Classe per la verifica di eventuali riduzioni da applicare per il pagamento
 * del premio zootecnia.
 *
 * @author Bcsoft
 */
@Component("ref03")
public class ref03 {


    @Autowired
    ControlliService controlliService;
    private Rpu_V_pratica_zoote azienda;
    private Dmt_t_sessione sessione;
    private Boolean isIrregolaritaIntenzionale;
    private BigDecimal importoUnit;

    /**
     * inizializzatore delle variabili di classe.
     *
     * @param sessione sessione generata per l'esecuzione corrente.
     * @param azienda  azienda per la quale si effettua il calcolo.
     */
    public void inizializzazione(Dmt_t_sessione sessione, Rpu_V_pratica_zoote azienda) {
        System.out.println("INIZIO CALCOLO REF03 AMMISIBILITA' PREMIO E SANZIONI");
        this.azienda = azienda;
        this.sessione = sessione;
    }

    /**
     * nel metodo esecuzione vengono calcolati il numero di capi pagabili, la quota
     * pagata, l'esito del calcolo e la percentuale di riduzione premio. Per
     * effettuare tali calcoli, vengono utilizzati i capi appartenenti all'azienda
     * analizzata e dei codici premio per cui tale azienda concorre. Dopo aver
     * effettuato tali calcoli, verranno salvati a db nella rispettiva tabella di
     * output.
     *
     * @throws CalcoloException     eccezione riferita al calcolo di tipo {@link CalcoloException}
     * @throws NullPointerException eccezione riferita al passaggio di un valore null {@link NullPointerException}
     */
    public void esecuzione() throws CalcoloException {
        if (1 == 1)
            System.out.println("CALCOLO REF03, INIZIO ESECUZIONE");
        this.importoUnit = new BigDecimal(0);
        this.isIrregolaritaIntenzionale = false;
        Dmt_t_output_ref03 outputCalcolo = null;
        List<String> codiciPremio = this.controlliService.getCodicePremioPerCuaa(this.azienda.getCuaa());
        BigDecimal capiAnomali = new BigDecimal(0);
        BigDecimal capiAccertati = new BigDecimal(0);
        BigDecimal capiRichiesti = new BigDecimal(0);
        BigDecimal capiSanzionati = new BigDecimal(0);
        BigDecimal esito = new BigDecimal(0);
        BigDecimal percentualeRiduzione = new BigDecimal(0);
        BigDecimal capiPagabili = new BigDecimal(0);
        BigDecimal importoPagatoLordoDecurtazione = new BigDecimal(0);
        HashMap<String, List<Long>> capiPerPremio = new HashMap<String, List<Long>>();
        HashMap<String, List<Long>> capiPerPremioFiltrati = new HashMap<String, List<Long>>();
        HashMap<String, BigDecimal> result = new HashMap<String, BigDecimal>();
        Integer giorniRitardo = this.controlliService.getGiorniRitardoPresentazioneDomanda(this.azienda.getCuaa(),
                this.azienda.getCodicePremio(), this.azienda.getAnnoCampagna());
        BigDecimal percDecurtazione = null;
        BigDecimal importoPagatoNettoDecurtazione = null;

        capiPerPremio = buildMap(codiciPremio);

        try {
            capiPerPremioFiltrati = updateMap(capiPerPremio);
        } catch (NullPointerException e) {
            System.out.println("ERRORE CALCOLO REF03, ERRORE DURANTE IL RECUPERO DEGLI IMPORTI UNITARI");
            throw new CalcoloException("errore durante il recupero degli importi unitari");
        }

        for (String cp : capiPerPremio.keySet()) {
            result = this.precalcolo(capiPerPremioFiltrati, cp);
            capiAccertati = result.get("accertati");
            capiAnomali = result.get("anomali");
            capiRichiesti = result.get("richiesti");
            capiSanzionati = result.get("sanzionati");

            result.clear();


            try {
                result = UtilControlli.calcoloEsito(capiAccertati, capiAnomali, capiSanzionati, capiRichiesti);
                esito = result.get("esito");
            } catch (ArithmeticException e) {
            }

            percentualeRiduzione = calcoloRiduzione(capiAnomali, esito);

            try {
                System.out.println(this.azienda.getAnnoCampagna());
                System.out.println(cp);
                Dmt_t_importo_unitario o = this.controlliService
                        .getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), cp);
                System.out.println("CHECK IMPORTO NULL -> ");
                System.out.println(o);
                this.importoUnit = new BigDecimal(o
                        .getImportoUnitario());
            } catch (Exception e) {
                System.out.println("ERRORE CALCOLO REF03, ERRORE DURANTE IL RECUPERO DELL'IMPORTO UNITARIO, CP -> " + cp);
                e.printStackTrace();
                throw new CalcoloException("errore durante il recupero dell'importo unitario");
            }

            if (cp.equals("320") && capiPagabili.compareTo(BigDecimal.ZERO) > 0) {
                try {
                    importoPagatoLordoDecurtazione = this.controlliService
                            .getQuotaCapiPremioByCuaaAndIdSessioneAndAnnoCampagnaAndCodInt(this.azienda.getCuaa(),
                                    this.sessione.getIdSessione(), this.azienda.getAnnoCampagna(), cp).multiply(this.importoUnit);
                } catch (NullPointerException e) {
                    System.out.println("ERRORE CALCOLO REF03, ERRORE DURANTE IL CALCOLO DELL'IMPORTO PAGATO AL LORDO DELLA DECURTAZIONE");
                    e.printStackTrace();
                    throw new CalcoloException("errore durante il calcolo dell'importo pagato al lordo della decurtazione");
                }

            } else {
                try {
                    capiPagabili = result.get("capiPagabili") != null ? result.get("capiPagabili") : BigDecimal.ZERO;
                    importoPagatoLordoDecurtazione = capiPagabili.multiply(this.importoUnit);

                } catch (NullPointerException e) {
                    System.out.println("ERRORE CALCOLO REF03, ERRORE DURANTE IL CALCOLO DELL'IMPORTO PAGATO AL LORDO DELLA DECURTAZIONE");
                    e.printStackTrace();
                    throw new CalcoloException("errore durante il calcolo dell'importo pagato al lordo della decurtazione");
                }
            }
            if (giorniRitardo != null && !giorniRitardo.equals(new Integer(0))) {
                try {
                    percDecurtazione = this.controlliService
                            .getPercentualeDiDecurtazione(this.azienda.getAnnoCampagna(), giorniRitardo);
                    importoPagatoNettoDecurtazione = percDecurtazione != null ? importoPagatoLordoDecurtazione.subtract(
                            (importoPagatoLordoDecurtazione.multiply(percDecurtazione)).divide(new BigDecimal(100)), MathContext.DECIMAL128)
                            : BigDecimal.ZERO;
                } catch (NullPointerException e) {
                    System.out.println("ERRORE CALCOLO REF03, ERRORE DURANTE IL CALCOLO DELL'IMPORTO PAGATO AL NETTO DELLA DECURTAZIONE");
                    throw new CalcoloException("errore durante il calcolo dell'importo pagato al netto della decurtazione");
                }
            }

            outputCalcolo = new Dmt_t_output_ref03();
            outputCalcolo.setAnnoCampagna(this.azienda.getAnnoCampagna());
            outputCalcolo.setCapiAccertati(capiAccertati);
            outputCalcolo.setCapiAnomali(capiAnomali);
            outputCalcolo.setCapiPagabili(capiPagabili);
            outputCalcolo.setCapiRichiesti(capiRichiesti);
            outputCalcolo.setCapiSanzionati(capiSanzionati);
            outputCalcolo.setCuaa(this.azienda.getCuaa());
            outputCalcolo.setEsito(esito);
            outputCalcolo.setImportoPagatoLordoDecurtazione(importoPagatoLordoDecurtazione);
            outputCalcolo.setImportoPagatoNettoDecurtazione(importoPagatoNettoDecurtazione);
            outputCalcolo.setIntervento(cp);
            outputCalcolo.setPercentualeRiduzione(percentualeRiduzione);
            outputCalcolo.setPercentualeDecurtazione(percDecurtazione);
            outputCalcolo.setIdSessione(this.sessione);

            if (esito.compareTo(new BigDecimal("0.5")) > 0 || this.isIrregolaritaIntenzionale) {
                outputCalcolo.setDifferenzaCapiRichiestiAccertati(capiRichiesti.subtract(capiAccertati));
                outputCalcolo.setImportoARecupero(
                        outputCalcolo.getDifferenzaCapiRichiestiAccertati().multiply(this.importoUnit));
                this.isIrregolaritaIntenzionale = false;
            }

            this.controlliService.saveOutputRef03(outputCalcolo);
        }

        //RESET DELLE VARIABILI

        capiAccertati = BigDecimal.ZERO;
        capiAnomali = BigDecimal.ZERO;
        capiRichiesti = BigDecimal.ZERO;
        capiSanzionati = BigDecimal.ZERO;
        this.importoUnit = BigDecimal.ZERO;
        esito = BigDecimal.ZERO;
        importoPagatoLordoDecurtazione = BigDecimal.ZERO;
        importoPagatoNettoDecurtazione = BigDecimal.ZERO;
        percentualeRiduzione = BigDecimal.ZERO;
        percDecurtazione = BigDecimal.ZERO;
        result.clear();

        if (1 == 1)
            System.out.println("CALCOLO REF03, FINE ESECUZIONE");
        System.out.println("FINE CALCOLO REF03 AMMISIBILITA' AL PREMIO E SANZIONI");
    }

    //	/**
//	 * nel metodo precalcolo vengono valorizzate le seguenti variabili in base alla
//	 * mappa di hash e al codice premio preso in esame: <br>
//	 * capiAnomali - capi valorizzati nella tabella dmt_t_output_esclusi,
//	 * capiAccertati - capi che possono concorrere al premio in questione,
//	 * capiRichiesti - capi presenti nella richiesta a premio del richiedente.
//	 * 
//	 * @param capiPerPremio tabella di hash contentente i codici premio e la lista degli animali concorrenti a premio di tipo {@link HashMap}
//	 * @param cp codice premio da analizzare di tipo {@link String}
//	 * @return result - mappa di hash in cui sono presenti le variabili valorizzate di tipo {@link HashMap}.
//	 */
    private HashMap<String, BigDecimal> precalcolo(HashMap<String, List<Long>> capiPerPremio, String cp) {

        BigDecimal capiAnomali = new BigDecimal(0);
        BigDecimal capiAccertati = new BigDecimal(0);
        BigDecimal capiRichiesti = new BigDecimal(0);
        BigDecimal capiSanzionati = new BigDecimal(0);
        HashMap<String, BigDecimal> result = new HashMap<String, BigDecimal>();
        List<Long> capiAnomaliPerCodicePremio = new ArrayList<Long>();
        List<Long> listaCapiEsito = new ArrayList<Long>();


//		capiRichiesti = new BigDecimal(capiPerPremio.get(cp).size());
//		capiAnomaliPerCodicePremio = this.controlliService.isAnomalo(this.sessione.getIdSessione(), cp);
//		
//		for (Long c : capiPerPremio.get(cp)) {
//			try {
//					for(Long capoAnomalo : capiAnomaliPerCodicePremio)
//						if(c.compareTo(capoAnomalo) == 0)
//							capiAnomali = capiAnomali.add(BigDecimal.ONE);
//						
//				
//			} catch (NullPointerException e) {
//			}
//		}
//		
//		capiAccertati = capiRichiesti.subtract(capiAnomali);

        resetVariables(capiRichiesti, capiAccertati, capiAnomali, capiSanzionati, capiAnomaliPerCodicePremio, listaCapiEsito);
        listaCapiEsito = this.getListaCapiEsito(cp);
        capiRichiesti = new BigDecimal(capiPerPremio.get(cp).size());
        if (listaCapiEsito != null && !listaCapiEsito.isEmpty()) {
            for (Long e : capiPerPremio.get(cp)) {
                Boolean trovato = false;
                for (Object capo : listaCapiEsito) {
                    System.out.println("CAPO CLASS -> " + capo.getClass().getName());
                    if (((BigDecimal) capo).longValue() == e.longValue()) {
                        trovato = true;
                        break;
                    }
                }
                if (trovato) {
                    capiAccertati = capiAccertati.add(BigDecimal.ONE);
                    if (isSanzionato(e, cp)) {
                        capiSanzionati = capiSanzionati.add(BigDecimal.ONE);
                    }
                }
            }
            capiAnomali = capiRichiesti.subtract(capiAccertati);
        }

        result.put("accertati", capiAccertati);
        result.put("anomali", capiAnomali);
        result.put("richiesti", capiRichiesti);
        result.put("sanzionati", capiSanzionati);

        return result;
    }

    //	/**
//	 * nel metodo viene valorizzata la seguente variabile in base
//	 * al numero di capi anomali e all'esito: percentuale di riduzione a premio.
//	 * Tale variabile sara' necessaria al calcolo della quota pagata al richiedente.
//	 * 
//	 * @param capiAnomali - numero di capi che non hanno passato i controlli di tipo {@link BigDecimal}.
//	 * @param esito - esito del calcolo di tipo {@link BigDecimal}
//	 * @return percRid - percentuale di riduzione della quota riconosciuta al richiedente di tipo {@link BigDecimal}
//	 */
    private BigDecimal calcoloRiduzione(BigDecimal capiAnomali, BigDecimal esito) {

        if (isIrregolaritaIntenzionale().compareTo(BigDecimal.ZERO) > 0) {

            if (esito.compareTo(new BigDecimal("0.2")) <= 0) {
                this.isIrregolaritaIntenzionale = false;
                return BigDecimal.ZERO;
            } else if (esito.compareTo(new BigDecimal("0.2")) > 0) {
                this.isIrregolaritaIntenzionale = true;
                return BigDecimal.ONE;
            }
        }

        if ((capiAnomali.compareTo(BigDecimal.ZERO) >= 0 && capiAnomali.compareTo(new BigDecimal(3)) <= 0)
                || (capiAnomali.compareTo(new BigDecimal(3)) == 1 && esito.compareTo(new BigDecimal("0.1")) <= 0))
            return esito;

        if (capiAnomali.compareTo(new BigDecimal(3)) == 1) {

            if (esito.compareTo(new BigDecimal("0.1")) > 0 && esito.compareTo(new BigDecimal("0.2")) <= 0)
                return esito.multiply(new BigDecimal(2));

            if (esito.compareTo(new BigDecimal("0.2")) > 0 && esito.compareTo(new BigDecimal("0.5")) <= 0)
                return BigDecimal.ONE;

            if (esito.compareTo(new BigDecimal("0.5")) > 0)
                return BigDecimal.ONE;
        }

        return BigDecimal.ZERO;
    }

    /**
     * nel metodo buildùmap viene costruita la tabella di hash in base alla lista
     * dei capi bovini, ovicaprini e macellati. Le chiavi sono i codici_premio e i
     * valori sono le liste di capi concorrenti a tali codici premio. La lista di
     * capi e' costruita in modo tale da conservare l'informazione del capoId, utile
     * al riconosciumento del singolo capo. Le altre informazioni vengono ignorate
     * poiche' ritenute non necessarie ai fini del calcolo.
     *
     * @param listaCapiBovini     - lista degli animali di tipo bovino appartenenti all'azienda che si sta analizzando.
     * @param listaCapiOvicaprini - lista degli animali di tipo ovicaprino appartenenti all'azienda che si sta analizzando.
     * @param listaCapiMacellati  - lista degli animali di tipo macellato appartenenti all'azienda che si sta analizzando.
     * @param codiciPremio        - codici premio per cui concorre l'azienda che si sta analizzando.
     * @return tempHashmap - istanza di tipo {@link HashMap}
     */
    public HashMap<String, List<Long>> buildMap(List<String> codiciPremio) {
        HashMap<String, List<Long>> tempHashmap = new HashMap<String, List<Long>>();
        List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiBovini;
        List<Dmt_t_clsCapoMacellato> listaCapiMacellati;
        List<Dmt_t_Tws_bdn_du_capi_ovicaprini> listaCapiOvicaprini;
        String cp = azienda.getCodicePremio();
        Boolean isM19 = cp.equals("316") || cp.equals("317") || cp.equals("318") || cp.equals("319");

        if (isM19) {
            listaCapiBovini = this.controlliService.getCapiBoviniM19DaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
            listaCapiMacellati = this.controlliService.getCapiMacellatiM19DaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
            listaCapiOvicaprini = this.controlliService.getCapiOvicapriniM19DaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
        } else {
            listaCapiBovini = this.controlliService.getCapiBoviniDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa(), this.azienda.getCodicePremio());
            listaCapiMacellati = this.controlliService.getCapiMacellatiDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa(), this.azienda.getCodicePremio());
            listaCapiOvicaprini = this.controlliService.getCapiOvicapriniDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa(), this.azienda.getCodicePremio());
        }

        Dmt_t_output_controlli outConctrolli = new Dmt_t_output_controlli();

//		COSTRUZIONE HASHMAP
        for (String c : codiciPremio) {
            if (c.equals("316") || c.equals("317") || c.equals("318") || c.equals("319"))
                tempHashmap.put("M19", new ArrayList<Long>());
            else
                tempHashmap.put(c, new ArrayList<Long>());
        }

        for (String c : codiciPremio) {

            outConctrolli = this.controlliService.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(this.sessione, this.azienda.getCuaa(), Long.valueOf(this.azienda.getAnnoCampagna()), c);

            if (listaCapiBovini != null && !listaCapiBovini.isEmpty())
                for (Dmt_t_Tws_bdn_du_capi_bovini b : listaCapiBovini)
                    if (b.getCodicePremio().equals(c) && outConctrolli != null)
                        if (c.equals("316") || c.equals("317") || c.equals("318") || c.equals("319"))
                            tempHashmap.get("M19").add(b.getCapoId());
                        else
                            tempHashmap.get(c).add(b.getCapoId());

            if (listaCapiOvicaprini != null && !listaCapiOvicaprini.isEmpty())
                for (Dmt_t_Tws_bdn_du_capi_ovicaprini o : listaCapiOvicaprini)
                    if (o.getCodicePremio().equals(c) && outConctrolli != null)
                        if (c.equals("316") || c.equals("317") || c.equals("318") || c.equals("319"))
                            tempHashmap.get("M19").add(o.getCapoId());
                        else
                            tempHashmap.get(c).add(o.getCapoId());

            if (listaCapiMacellati != null && !listaCapiMacellati.isEmpty())
                for (Dmt_t_clsCapoMacellato m : listaCapiMacellati)
                    if (m.getCodicePremio().equals(c) && outConctrolli != null)
                        if (c.equals("316") || c.equals("317") || c.equals("318") || c.equals("319"))
                            tempHashmap.get("M19").add(m.getCapoId());
                        else
                            tempHashmap.get(c).add(m.getCapoId());
        }

        listaCapiBovini.clear();
        listaCapiMacellati.clear();
        listaCapiOvicaprini.clear();

        return tempHashmap;
    }

    /**
     * nel metodo updateMap viene effettuato l'aggiornamento dei capi in base al
     * codice premio. i premi zootecnici non sono tutti tra loro cumulabili. I soli
     * interventi che sono cumulabili tra di loro sono le seguenti coppie di misure: <br>
     * - Misura 1 (310) {@link ClcInt310Mis1} con la misura 2 (311) {@link ClcInt311Mis2} <br>
     * - Misura 4 (313) {@link ClcInt313Mis4} con la misura 18(314) {@link ClcInt314Mis18} . <br>
     * Pertanto, qualora un capo dovesse risultare ammissibile al pagamento
     * per una pluralità di misure zootecniche tra loro non cumulabili, il sostegno
     * è erogato con riferimento alla misura per la quale è previsto l’importo
     * unitario più elevato (o alla somma dei importi unitari nel caso di misure
     * cumulabili).
     *
     * @param capiPerPremio - tabella di hash degli animali concorrenti a premio.
     * @return tempHash - tabella di hash con valori aggiornati.
     */
    public HashMap<String, List<Long>> updateMap(HashMap<String, List<Long>> capiPerPremio) {

        List<String> codiciPremioFiltratiPerAnimali = new ArrayList<String>();
        HashMap<String, List<Long>> tempHash = new HashMap<String, List<Long>>();
        Dmt_t_importo_unitario maxImportoUnitario = new Dmt_t_importo_unitario();

        for (String k : capiPerPremio.keySet())
            tempHash.put(k, new ArrayList<Long>());

        for (String k : capiPerPremio.keySet())
            for (Long e : capiPerPremio.get(k)) {

                codiciPremioFiltratiPerAnimali = this.controlliService.getCodiciPremioPerCapo(e,
                        this.sessione.getIdSessione());


                this.unificazionePremiMis19(codiciPremioFiltratiPerAnimali);

                if (codiciPremioFiltratiPerAnimali.size() == 1) {
                    tempHash.get(k).add(e);
                } else if (codiciPremioFiltratiPerAnimali.size() >= 2) {

                    List<Dmt_t_importo_unitario> importiUnitariPerAnimale = this.controlliService.getListImportiUnitariByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), codiciPremioFiltratiPerAnimali);

                    double max = Double.MIN_VALUE;

                    for (int i = 0; i < importiUnitariPerAnimale.size(); i++)
                        if (importiUnitariPerAnimale.get(i).getImportoUnitario() >= max) {
                            max = importiUnitariPerAnimale.get(i).getImportoUnitario();
                            maxImportoUnitario = importiUnitariPerAnimale.get(i);
                        }

                    List<Dmt_t_importo_unitario> listaImportiMassimi = impostaImportiMassimi(maxImportoUnitario, codiciPremioFiltratiPerAnimali, importiUnitariPerAnimale);


                    for (Dmt_t_importo_unitario imp : listaImportiMassimi)
                        if (imp.getIntervento().equals(k))
                            tempHash.get(k).add(e);

                    listaImportiMassimi.clear();
                    importiUnitariPerAnimale.clear();
                }
                codiciPremioFiltratiPerAnimali.clear();
            }
        return tempHash;
    }

    /**
     * nel metodo contains viene confrontato un dato codice premio con i valori
     * presenti nella lista dei codici premio per cui un dato animale concorre. Se
     * il codice premio ricercato viene trovato nella lista dei codici premio
     * associati al dato animale, allora viene ritornato un valore booleano true,
     * altrimenti viene ritornato un valore booleano false.
     *
     * @param codiciPremioFiltratiPerAnimaliAPremio - lista dei codici premio per cui un dato animale concorre.
     * @param codPremio                             - codice premio che si sta analizzando.
     * @return <b>true:</b> se codPremio si trova in codiciPremioFiltratiPerAnimaliAPremio, <b>false:</b> altrimenti.
     */
    public Boolean contains(List<String> codiciPremioFiltratiPerAnimaliAPremio, String codPremio) {

        for (String cp : codiciPremioFiltratiPerAnimaliAPremio)
            if (cp.equals(codPremio))
                return true;

        return false;
    }

    //	/**
//	 * Metodo che verifica se il cuaa fornito ha commesso delle irregolarità intenzionali, {@link Dmt_t_irregolarita_intenzionale}.
//	 * @return il numero di animali anomali a causa di una irregolarità intenzionale di tipo {@link BigDecimal}.
//	 */
    private BigDecimal isIrregolaritaIntenzionale() {
        BigDecimal numeroAnimaliAnomali = new BigDecimal(0);
        List<Dmt_t_irregolarita_intenzionale> listaIrregolaritaIntenzionali = this.controlliService
                .getIrregolaritaByCuaaAndAnnoCampagna(this.azienda.getCuaa(), new Integer(this.azienda.getAnnoCampagna()));

        if (listaIrregolaritaIntenzionali != null && !listaIrregolaritaIntenzionali.isEmpty()
                && listaIrregolaritaIntenzionali.size() == 1)
            return listaIrregolaritaIntenzionali.get(0).getIntenzionalitaRiscontrata().equals("S")
                    ? new BigDecimal(listaIrregolaritaIntenzionali.get(0).getNumeroAnimaliAnomali())
                    : BigDecimal.ZERO;
        else if (listaIrregolaritaIntenzionali != null && !listaIrregolaritaIntenzionali.isEmpty()
                && listaIrregolaritaIntenzionali.size() > 1)
            for (Dmt_t_irregolarita_intenzionale ir : listaIrregolaritaIntenzionali)
                if (ir.getIntenzionalitaRiscontrata().equals("S"))
                    numeroAnimaliAnomali.add(BigDecimal.ONE);

        listaIrregolaritaIntenzionali.clear();
        return numeroAnimaliAnomali;
    }

    private Dmt_t_importo_unitario getImporto(List<Dmt_t_importo_unitario> importiUnitariPerAnimale, String codicePremio) {

        Dmt_t_importo_unitario importoDaTornare = null;

        for (Dmt_t_importo_unitario imp : importiUnitariPerAnimale)
            if (imp.getIntervento().equals(codicePremio))
                importoDaTornare = imp;

        return importoDaTornare;
    }

    private List<Dmt_t_importo_unitario> impostaImportiMassimi(Dmt_t_importo_unitario importoUnitarioMax, List<String> codiciPremioFiltratiPerAnimali, List<Dmt_t_importo_unitario> importiUnitariPerAnimale) {
        List<Dmt_t_importo_unitario> importiDaRitornare = new ArrayList<Dmt_t_importo_unitario>();

        switch (importoUnitarioMax.getIntervento()) {
            case "310":
                if (this.contains(codiciPremioFiltratiPerAnimali, "311"))
                    importiDaRitornare.add(getImporto(importiUnitariPerAnimale, "311"));
                importiDaRitornare.add(importoUnitarioMax);

                break;
            case "311":
                if (this.contains(codiciPremioFiltratiPerAnimali, "310"))
                    importiDaRitornare.add(getImporto(importiUnitariPerAnimale, "310"));
                importiDaRitornare.add(importoUnitarioMax);

                break;
            case "313":
                if (this.contains(codiciPremioFiltratiPerAnimali, "314"))
                    importiDaRitornare.add(getImporto(importiUnitariPerAnimale, "314"));
                importiDaRitornare.add(importoUnitarioMax);

                break;
            case "314":
                if (this.contains(codiciPremioFiltratiPerAnimali, "313"))
                    importiDaRitornare.add(getImporto(importiUnitariPerAnimale, "313"));
                importiDaRitornare.add(importoUnitarioMax);

                break;

            default:
                importiDaRitornare.add(importoUnitarioMax);
                break;
        }

        return importiDaRitornare;
    }

    private void resetVariables(BigDecimal capiRichiesti, BigDecimal capiAccertati, BigDecimal capiAnomali, BigDecimal capiSanzionati, List<Long> capiAnomaliPerCodicePremio, List<Long> listaCapiEsito) {

        if (capiRichiesti.compareTo(BigDecimal.ZERO) != 0)
            capiRichiesti = BigDecimal.ZERO;

        if (capiAccertati.compareTo(BigDecimal.ZERO) != 0)
            capiAccertati = BigDecimal.ZERO;

        if (capiAnomali.compareTo(BigDecimal.ZERO) != 0)
            capiAnomali = BigDecimal.ZERO;
        if (capiSanzionati.compareTo(BigDecimal.ZERO) != 0)
            capiSanzionati = BigDecimal.ZERO;

        if (!capiAnomaliPerCodicePremio.isEmpty())
            capiAnomaliPerCodicePremio.clear();

        if (!listaCapiEsito.isEmpty())
            listaCapiEsito.clear();

    }

    private boolean contienePremiDa316A319(List<String> premi) {
        return premi.contains("316") || premi.contains("317") || premi.contains("318") || premi.contains("319");
    }

    private void removePremiDa316A319(List<String> premi) {
        if (premi.indexOf("316") != -1)
            premi.remove(premi.indexOf("316"));
        if (premi.indexOf("317") != -1)
            premi.remove(premi.indexOf("317"));
        if (premi.indexOf("318") != -1)
            premi.remove(premi.indexOf("318"));
        if (premi.indexOf("319") != -1)
            premi.remove(premi.indexOf("319"));
    }

    private void unificazionePremiMis19(List<String> premi) {
        if (this.contienePremiDa316A319(premi)) {
            this.removePremiDa316A319(premi);
            premi.add("M19");
        }
    }

    private List<Long> getListaCapiEsito(String cp) {
        List<Long> capi = new ArrayList<Long>();

        if (cp.equals("M19")) {
            capi.addAll(this.controlliService.getListaCapiEsito(this.sessione, this.azienda.getCuaa(), "316"));
            capi.addAll(this.controlliService.getListaCapiEsito(this.sessione, this.azienda.getCuaa(), "317"));
            capi.addAll(this.controlliService.getListaCapiEsito(this.sessione, this.azienda.getCuaa(), "318"));
            capi.addAll(this.controlliService.getListaCapiEsito(this.sessione, this.azienda.getCuaa(), "319"));
        } else
            capi = this.controlliService.getListaCapiEsito(this.sessione, this.azienda.getCuaa(), cp);

        return !capi.isEmpty() ? capi : Collections.emptyList();
    }

    private BigDecimal getSanzionati(String cp) {
        BigDecimal sanzionati = BigDecimal.ZERO;

        if (cp.equals("M19")) {
            sanzionati = sanzionati.add(BigDecimal.valueOf(controlliService.getCapiSanzionati(this.azienda.getCuaa(), "316", this.sessione.getIdSessione())));
            sanzionati = sanzionati.add(BigDecimal.valueOf(controlliService.getCapiSanzionati(this.azienda.getCuaa(), "317", this.sessione.getIdSessione())));
            sanzionati = sanzionati.add(BigDecimal.valueOf(controlliService.getCapiSanzionati(this.azienda.getCuaa(), "318", this.sessione.getIdSessione())));
            sanzionati = sanzionati.add(BigDecimal.valueOf(controlliService.getCapiSanzionati(this.azienda.getCuaa(), "319", this.sessione.getIdSessione())));
        } else
            sanzionati = BigDecimal.valueOf(controlliService.getCapiSanzionati(this.azienda.getCuaa(), cp, this.sessione.getIdSessione()));

        return sanzionati;
    }

    private Dmt_t_clsCapoMacellato getCapoMacellatoSanzionabile(Long idCapo, String codicePremio) {
        return controlliService.getMacellatoById(idCapo, codicePremio, this.azienda.getCuaa(), this.sessione.getIdSessione());
    }

    private Dmt_t_Tws_bdn_du_capi_bovini getCapoBovinoSanzionabile(Long idCapo, String codicePremio) {
        return controlliService.getBovinoById(idCapo, codicePremio, this.azienda.getCuaa(), this.sessione.getIdSessione());
    }

//	private Dmt_t_Tws_bdn_du_capi_ovicaprini getCapoOvicaprinoSanzionabile (Long idCapo, String codicePremio) {
//		return controlliService.getOviCaprinoById(idCapo, codicePremio , sessione.getIdSessione());
//	}

    private Boolean isSanzionato(Long idCapo, String codicePremio) {
        Dmt_t_clsCapoMacellato capoMacellato = getCapoMacellatoSanzionabile(idCapo, codicePremio);
        Dmt_t_Tws_bdn_du_capi_bovini capoBovino = getCapoBovinoSanzionabile(idCapo, codicePremio);
//		Dmt_t_Tws_bdn_du_capi_ovicaprini capoOvicaprino = getCapoOvicaprinoSanzionabile(idCapo , codicePremio);

        if (capoMacellato != null)
            if (!UtilControlli.controlloTempisticheDiRegistrazione(capoMacellato))
                return true;
        if (capoBovino != null)
            if (!UtilControlli.controlloTempisticheDiRegistrazione(capoBovino))
                return true;
//	    if (capoOvicaprino != null) 
//			return true;

        return false;

    }
}
