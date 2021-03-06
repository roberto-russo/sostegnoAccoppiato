CREATE TABLE Dmt_t_tbdn_du_capi (
    id_domanda                   DECIMAL(11, 0) NOT NULL,
    id_allev_bdn                 VARCHAR(25) NOT NULL COMMENT 'Identificativo assegnato dalla BDN all''allevamento',
    cod_intervento               VARCHAR(3) NOT NULL COMMENT 'Codice del Premio richiesto per l''allevamento',
    id_capo_bdn                  VARCHAR(25) NOT NULL COMMENT 'Identificativo assegnato dalla BDN al Capo',
    num_auricolare               VARCHAR(15) NOT NULL COMMENT 'Numero auricolare del Capo',
    sesso                        VARCHAR(1),
    data_nascita                 DATE COMMENT 'Data di nascita del Capo',
    cod_razza                    VARCHAR(3) DEFAULT 'TRB' NOT NULL,
    sco_razza                    VARCHAR(3) COMMENT 'Codice della razza del Capo',
    data_inizio_detenz           DATE COMMENT 'Data Inizio Detenzione del Capo presso l''allevamento',
    data_fine_detenz             DATE COMMENT 'Data Fine Detenzione del Capo presso l''allevamento',
    data_mac                     DATE,
    cod_azienda                  VARCHAR(16),
    capo_cod_madre               VARCHAR(25),
    cod_libro_madre              VARCHAR(25),
    desc_libro_madre             VARCHAR(50),
    azienda_latitudine           DECIMAL(11, 4) COMMENT 'Latitudine azienda',
    azienda_longitudine          DECIMAL(11, 4) COMMENT 'Longitudine azienda',
    data_ingresso                DATE COMMENT 'Data di ingresso del capo',
    data_com_autorita_ingresso   DATE COMMENT 'Data di comunicazione all autorita competente dell ingresso di stalla',
    data_inser_bdn_ingresso      DATE COMMENT 'Data di registrazione in BDN dell ingresso in stalla',
    flag_delegato                VARCHAR(10) COMMENT 'Flag che indica se il detentore ha delegato altri organismi per la gestione dei dati in BDN',
    cuaa                         VARCHAR(16) COMMENT 'Codice fiscale del richiedente',
    data_com_autorita_uscita     DATE COMMENT 'Data di comunicazione all autorita competente dell uscita edl capo verso macello',
    data_uscita                  DATE COMMENT 'Data di uscita',
    data_inser_bdn_uscita        DATE COMMENT 'Data di registrazione in BDN dell uscita del capo verso macello',
    flag_delegato_ingresso       VARCHAR(10),
    ruolo_utente_ingresso        VARCHAR(10),
    flag_delegato_uscita         VARCHAR(10),
    ruolo_utente_uscita          VARCHAR(10),
	CONSTRAINT tbdn_du_capi_pk PRIMARY KEY (id_domanda, id_allev_bdn, cod_intervento, id_capo_bdn, num_auricolare)
)COMMENT 'Tabella dei Capi per Premio ed allevamento scaricati da BDN con Web Service relativi alle Domande Uniche';
