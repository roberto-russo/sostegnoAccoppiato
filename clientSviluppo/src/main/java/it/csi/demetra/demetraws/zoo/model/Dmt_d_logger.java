package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_logger_id;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DMT_D_LOGGER")
@IdClass(Dmt_d_logger_id.class)
public class Dmt_d_logger implements Serializable {


    private static final long serialVersionUID = 1515828060901867701L;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "idSessione", nullable = false)
    private Dmt_t_sessione idSessione;

    @Id
    @GeneratedValue(generator = "seq_dmt_d_logger")
    @SequenceGenerator(name="seq_dmt_d_logger",sequenceName="SEQ_DMT_D_LOGGER", allocationSize=1)
    @Column(name = "id_log")
    private Long idLog;

    @Column(name = "tipo_log")
    @ColumnDefault("'INFO'")
    private String tipoLog;

    @Column(name = "nome_classe_chiamante")
    @NotNull
    private String nomeClasseChiamante;

    @Column(name = "messaggio")
    @ColumnDefault("'no message avaible'")
    private String messaggio;

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

    public Dmt_t_sessione getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione;
    }


}
