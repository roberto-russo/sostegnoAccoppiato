package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_logger_id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DMT_D_LOGGER")
@IdClass(Dmt_d_logger_id.class)
public class Dmt_d_logger implements Serializable {


    private static final long serialVersionUID = 1515828060901867701L;

    @Id
    @Column(name = "id_sessione", nullable = false)
    private Long idSessione;

    @Id
    @GeneratedValue(generator = "seq_dmt_d_logger")
    @SequenceGenerator(name = "seq_dmt_d_logger", sequenceName = "SEQ_DMT_D_LOGGER", allocationSize = 1)
    @Column(name = "id_log")
    private Long idLog;

    @Column(name = "tipo_log")
    private String tipoLog = "INFO";

    @Column(name = "nome_classe_chiamante")
    @NotNull
    private String nomeClasseChiamante;

    @Column(name = "messaggio")
    private String messaggio = "no message avaible";

    @Column(name = "data_generazione_log")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataGenerazioneLog;

    public Dmt_d_logger() {

    }

    public Dmt_d_logger(Long idLog) {
        this.idLog = idLog;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public String getTipoLog() {
        return tipoLog;
    }

    public void setTipoLog(String tipoLog) {
        this.tipoLog = tipoLog;
    }

    public String getNomeClasseChiamante() {
        return nomeClasseChiamante;
    }

    public void setNomeClasseChiamante(String nomeClasseChiamante) {
        this.nomeClasseChiamante = nomeClasseChiamante;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public Date getDataGenerazioneLog() {
        return dataGenerazioneLog;
    }

    public void setDataGenerazioneLog(Date dataGenerazioneLog) {
        this.dataGenerazioneLog = dataGenerazioneLog;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione.getIdSessione();
    }


}
