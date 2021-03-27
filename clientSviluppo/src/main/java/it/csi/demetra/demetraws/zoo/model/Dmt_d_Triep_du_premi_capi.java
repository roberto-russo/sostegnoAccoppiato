package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_Triep_du_premi_capi_id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DMT_D_TRIEP_DU_PREMI_CAPI")
@IdClass(Dmt_d_Triep_du_premi_capi_id.class)
public class Dmt_d_Triep_du_premi_capi implements Serializable {

    private static final long serialVersionUID = -9034733570550933438L;

    @Id
    @Column(name = "id_sessione")
    private Long idSessione;

    @Id
    @Column(name = "id_domanda")
    @NotNull
    private Long idDomanda;

    @Column(name = "id_azienda")
    @NotNull
    private Long idAzienda;

    @Column(name = "cod_attivita")
    @NotNull
    private String codAttivita = "TAT";

    @Id
    @Column(name = "sco_attivita")
    @NotNull
    private String scoAttivita;

    @Id
    @Column(name = "id_richiesta")
    @NotNull
    private Long idRichiesta = 0L;

    @Column(name = "tipo_riga")
    @NotNull
    private Long tipoRiga;

    @Id
    @Column(name = "cod_premio")
    @NotNull
    private String codPremio;

    @Column(name = "importo_base")
    private double importoBase;

    @Column(name = "perc_base")
    private double percBase;

    @Column(name = "perc_present_tard")
    private double percPresentTard;

    @Column(name = "imp_ante_modulazione")
    private double impAnteModulazione;

    @Column(name = "perc_modulazione")
    private double percModulazione;

    @Column(name = "imp_post_modulazione")
    private double impPostModulazione;

    @Column(name = "perc_condizionalita")
    private double percCondizionalita;

    @Column(name = "nr_capi_comp")
    private Long nrCapiComp;

    @Column(name = "nr_capi_corr")
    private double nrCapiCorr;

    @Column(name = "nr_capi_tot_bdn")
    private double nrCapiTotBdn;

    @Column(name = "nr_capi_anomali_bdn")
    private Long nrCapiAnomaliBdn;

    @Column(name = "nr_capi_tot_cil")
    private Long nrCapiTotCil;

    @Column(name = "nr_capi_anomali_cil")
    private Long nrCapiAnomaliCil;

    @Column(name = "nr_capi_vn")
    private Long nrCapiVn;

    @Column(name = "nr_capi_vn2")
    private Long nrCapiVn2;

    @Column(name = "nr_capi_lg")
    private Long nrCapiLg;

    @Column(name = "nr_capi_bo")
    private Long nrCapiBo;

    @Column(name = "nr_capi_ma")
    private Long nrCapiMa;

    @Column(name = "perc_uba_sau")
    private double percUbaSau;

    @Column(name = "perc_pas_for")
    private double percPasFor;

    @Column(name = "importo")
    private double importo;

    @Column(name = "cod_tipo_calcolo")
    @NotNull
    private String codTipoCalcolo = "CLC";

    @Column(name = "sco_tipo_calcolo")
    @NotNull
    private String scoTipoCalcolo = "002";

    @Column(name = "data_calcolo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCalcolo;

    @Column(name = "imp_post_pres_tard")
    private double impPostPresTard;

    // Importo al netto della trattenuta per Disciplina Finanziaria
    @Column(name = "imp_post_df")
    private double impPostDf;

    // utilizzato per salvare il numero di capi ammissibili nel caso di domanda a
    // campione
    @Column(name = "nr_capi_amm_camp")
    private double nrCapiAmmCamp;

    // importo antecedente al riproporzionamento del piccolo agricoltore se
    // l''importo totale dei premi e'' superiore ad un determinato importo
    @Column(name = "importo_pre_taglio")
    private double importoPreTaglio;

    // Esito percentuale calcolato sulla misura
    @Column(name = "esito_perc_art52")
    private double esitoPercArt52;

    // Numero di capi anomali calcolati sulla misura
    @Column(name = "capi_anomali_art52")
    private double capiAnomaliArt52;

    // Scostamento calcolato sulla misura
    @Column(name = "scostamento_perc")
    private double scostamentoPerc;

    public Long getIdDomanda() {
        return idDomanda;
    }

    public Long getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Long idAzienda) {
        this.idAzienda = idAzienda;
    }

    public String getCodAttivita() {
        return codAttivita;
    }

    public void setCodAttivita(String codAttivita) {
        this.codAttivita = codAttivita;
    }

    public String getScoAttivita() {
        return scoAttivita;
    }

    public Long getIdRichiesta() {
        return idRichiesta;
    }

    public Long getTipoRiga() {
        return tipoRiga;
    }

    public void setTipoRiga(Long tipoRiga) {
        this.tipoRiga = tipoRiga;
    }

    public String getCodPremio() {
        return codPremio;
    }

    public double getImportoBase() {
        return importoBase;
    }

    public void setImportoBase(double importoBase) {
        this.importoBase = importoBase;
    }

    public double getPercBase() {
        return percBase;
    }

    public void setPercBase(double percBase) {
        this.percBase = percBase;
    }

    public double getPercPresentTard() {
        return percPresentTard;
    }

    public void setPercPresentTard(double percPresentTard) {
        this.percPresentTard = percPresentTard;
    }

    public double getImpAnteModulazione() {
        return impAnteModulazione;
    }

    public void setImpAnteModulazione(double impAnteModulazione) {
        this.impAnteModulazione = impAnteModulazione;
    }

    public double getPercModulazione() {
        return percModulazione;
    }

    public void setPercModulazione(double percModulazione) {
        this.percModulazione = percModulazione;
    }

    public double getImpPostModulazione() {
        return impPostModulazione;
    }

    public void setImpPostModulazione(double impPostModulazione) {
        this.impPostModulazione = impPostModulazione;
    }

    public double getPercCondizionalita() {
        return percCondizionalita;
    }

    public void setPercCondizionalita(double percCondizionalita) {
        this.percCondizionalita = percCondizionalita;
    }

    public long getNrCapiComp() {
        return nrCapiComp;
    }

    public void setNrCapiComp(Long nrCapiComp) {
        this.nrCapiComp = nrCapiComp;
    }

    public double getNrCapiCorr() {
        return nrCapiCorr;
    }

    public void setNrCapiCorr(double nrCapiCorr) {
        this.nrCapiCorr = nrCapiCorr;
    }

    public double getNrCapiTotBdn() {
        return nrCapiTotBdn;
    }

    public void setNrCapiTotBdn(double nrCapiTotBdn) {
        this.nrCapiTotBdn = nrCapiTotBdn;
    }

    public Long getNrCapiAnomaliBdn() {
        return nrCapiAnomaliBdn;
    }

    public void setNrCapiAnomaliBdn(Long nrCapiAnomaliBdn) {
        this.nrCapiAnomaliBdn = nrCapiAnomaliBdn;
    }

    public Long getNrCapiTotCil() {
        return nrCapiTotCil;
    }

    public void setNrCapiTotCil(Long nrCapiTotCil) {
        this.nrCapiTotCil = nrCapiTotCil;
    }

    public Long getNrCapiAnomaliCil() {
        return nrCapiAnomaliCil;
    }

    public void setNrCapiAnomaliCil(Long nrCapiAnomaliCil) {
        this.nrCapiAnomaliCil = nrCapiAnomaliCil;
    }

    public Long getNrCapiVn() {
        return nrCapiVn;
    }

    public void setNrCapiVn(Long nrCapiVn) {
        this.nrCapiVn = nrCapiVn;
    }

    public Long getNrCapiVn2() {
        return nrCapiVn2;
    }

    public void setNrCapiVn2(Long nrCapiVn2) {
        this.nrCapiVn2 = nrCapiVn2;
    }

    public Long getNrCapiLg() {
        return nrCapiLg;
    }

    public void setNrCapiLg(Long nrCapiLg) {
        this.nrCapiLg = nrCapiLg;
    }

    public Long getNrCapiBo() {
        return nrCapiBo;
    }

    public void setNrCapiBo(Long nrCapiBo) {
        this.nrCapiBo = nrCapiBo;
    }

    public Long getNrCapiMa() {
        return nrCapiMa;
    }

    public void setNrCapiMa(Long nrCapiMa) {
        this.nrCapiMa = nrCapiMa;
    }

    public double getPercUbaSau() {
        return percUbaSau;
    }

    public void setPercUbaSau(double percUbaSau) {
        this.percUbaSau = percUbaSau;
    }

    public double getPercPasFor() {
        return percPasFor;
    }

    public void setPercPasFor(double percPasFor) {
        this.percPasFor = percPasFor;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public String getCodTipoCalcolo() {
        return codTipoCalcolo;
    }

    public void setCodTipoCalcolo(String codTipoCalcolo) {
        this.codTipoCalcolo = codTipoCalcolo;
    }

    public String getScoTipoCalcolo() {
        return scoTipoCalcolo;
    }

    public Date getDataCalcolo() {
        return dataCalcolo;
    }

    public void setDataCalcolo(Date dataCalcolo) {
        this.dataCalcolo = dataCalcolo;
    }

    public double getImpPostPresTard() {
        return impPostPresTard;
    }

    public void setImpPostPresTard(double impPostPresTard) {
        this.impPostPresTard = impPostPresTard;
    }

    public double getImpPostDf() {
        return impPostDf;
    }

    public void setImpPostDf(double impPostDf) {
        this.impPostDf = impPostDf;
    }

    public double getNrCapiAmmCamp() {
        return nrCapiAmmCamp;
    }

    public void setNrCapiAmmCamp(double nrCapiAmmCamp) {
        this.nrCapiAmmCamp = nrCapiAmmCamp;
    }

    public double getImportoPreTaglio() {
        return importoPreTaglio;
    }

    public void setImportoPreTaglio(double importoPreTaglio) {
        this.importoPreTaglio = importoPreTaglio;
    }

    public double getEsitoPercArt52() {
        return esitoPercArt52;
    }

    public void setEsitoPercArt52(double esitoPercArt52) {
        this.esitoPercArt52 = esitoPercArt52;
    }

    public double getCapiAnomaliArt52() {
        return capiAnomaliArt52;
    }

    public void setCapiAnomaliArt52(double capiAnomaliArt52) {
        this.capiAnomaliArt52 = capiAnomaliArt52;
    }

    public double getScostamentoPerc() {
        return scostamentoPerc;
    }

    public void setScostamentoPerc(double scostamentoPerc) {
        this.scostamentoPerc = scostamentoPerc;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione.getIdSessione();
    }

    public void setIdDomanda(Long idDomanda) {
        this.idDomanda = idDomanda;
    }

    public void setScoAttivita(String scoAttivita) {
        this.scoAttivita = scoAttivita;
    }

    public void setIdRichiesta(Long idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    public void setCodPremio(String codPremio) {
        this.codPremio = codPremio;
    }

    public void setScoTipoCalcolo(String scoTipoCalcolo) {
        this.scoTipoCalcolo = scoTipoCalcolo;
    }

}
