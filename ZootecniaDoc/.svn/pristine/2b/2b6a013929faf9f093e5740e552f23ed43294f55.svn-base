CREATE TABLE Dmt_w_tdu_premio_capi (
    id_azienda               DECIMAL(11, 0) NOT NULL COMMENT 'Rif azienda',
    versione                 DECIMAL(11, 0) NOT NULL COMMENT 'Versione',
    cod_allevamento          VARCHAR(15 ) NOT NULL COMMENT 'Codice allevamento BDN',
    id_allev_bdn             VARCHAR(25 ) NOT NULL COMMENT 'ID allevamento BDN',
    codice                   VARCHAR(16 ) NOT NULL COMMENT 'Codice della marca auricolare applicata al capo bovino',
    cod_intervento           VARCHAR(3 ) DEFAULT 'TPZ',
    data_inizio_detenzione   DATE NOT NULL COMMENT 'Data di inizio detenzione. E valorizzata solo se il capo deve verificare in BDN un periodo minimo di detenzione',
    data_fine_detenzione     DATE NOT NULL COMMENT 'Data di fine detenzione. A partire dalla campagna 2010 Ã¿ valorizzata solo se il capo deve verificare in BDN un periodo minimo di detenzione',
    sco_intervento           VARCHAR(3)  NOT NULL,
    flg_conf_premio          VARCHAR(1) NOT NULL,
    flg_ammissibile          VARCHAR(1) COMMENT 'Valorizzato durante calcolo del premio',
	CONSTRAINT tdu_premio_capi_pk PRIMARY KEY (id_azienda, versione, codice, sco_intervento, flg_conf_premio,cod_allevamento, id_allev_bdn) 
)