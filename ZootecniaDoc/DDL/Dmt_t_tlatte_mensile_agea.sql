CREATE TABLE Dmt_t_tlatte_mensile_agea (
    primo_anno_campagna      DECIMAL(4, 0) COMMENT 'Primo anno della campagna',
    anno_solare              DECIMAL(11, 0) COMMENT 'Anno Solare',
    mese                     VARCHAR(10) COMMENT 'Mese di riferimento',
    matr_acquirente          DECIMAL(10, 0) COMMENT 'Matricola settoriale acquirente',
    cuaa_acquirente          VARCHAR(16) COMMENT 'CUAA acquirente',
    denom_acquirente         VARCHAR(150) COMMENT 'Denominazione acquirente',
    matr_azienda             DECIMAL(11, 0) COMMENT 'Matricola settoriale azienda',
    cuaa_azienda             VARCHAR(16) COMMENT 'CUAA azienda',
    denom_azienda            VARCHAR(500) COMMENT 'Denominazione azienda',
    qt_consegnata            DECIMAL(10, 0) COMMENT 'Quantità consegnata',
    ten_mat_grassa_periodo   DECIMAL(11, 2) COMMENT 'Tenore di materia grassa di periodo',
    anno_riferimento         DECIMAL(4, 0) COMMENT 'Anno di riferimento dei dati ricevuti da Agea',
    flag_subentro            VARCHAR(1) COMMENT 'Flag che indica se le Produzioni del CUAA sono state oggetto di subentro con le produzioni di altri CUAA',
    cod_mese                 VARCHAR(3) DEFAULT 'MES' COMMENT 'Codice mese della tdecodifca_sop = ''MES''',
    sco_mese                 VARCHAR(3) COMMENT ''Sotto codice mese della tdecodifca_sop',
	CONSTRAINT TLATTE_MENSILE_AGEA_U01 UNIQUE (MATR_AZIENDA , ANNO_SOLARE , ANNO_RIFERIMENTO , SCO_MESE , MATR_ACQUIRENTE )	
) COMMENT 'Tabella che raccoglie i dati quantitativi, MENSILI, relativi alle produzioni e alle quote latte inviati da AGEA';
 