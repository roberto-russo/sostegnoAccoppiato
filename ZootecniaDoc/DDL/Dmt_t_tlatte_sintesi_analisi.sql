CREATE TABLE Dmt_t_tlatte_sintesi_analisi (
    cuaa_azienda        VARCHAR(16 ) NOT NULL COMMENT 'CUAA azienda',
    matricola_azienda   DECIMAL(11, 0) NOT NULL COMMENT 'Matricola settoriale azienda',
    anno_riferimento    DECIMAL(4, 0) NOT NULL COMMENT 'Anno di campagna',
    csom_med            DECIMAL(11, 3) COMMENT'Media Geometrica del valore di Cellule Somatiche',
    cmic_med            DECIMAL(11, 3) COMMENT'Media Geometrica del valore di Carica Microbiotica',
    pp_med              DECIMAL(11, 3) COMMENT'Media Aritmetica del valore di Proteine',
    csom_01_n_an        DECIMAL(3, 0) COMMENT'Numero di analisi per il valore di Cellule Somatiche - mese 01',
    csom_02_n_an        DECIMAL(3, 0),
    csom_03_n_an        DECIMAL(3, 0),
    csom_04_n_an        DECIMAL(3, 0),
    csom_05_n_an        DECIMAL(3, 0),
    csom_06_n_an        DECIMAL(3, 0),
    csom_07_n_an        DECIMAL(3, 0),
    csom_08_n_an        DECIMAL(3, 0),
    csom_09_n_an        DECIMAL(3, 0),
    csom_10_n_an        DECIMAL(3, 0),
    csom_11_n_an        DECIMAL(3, 0),
    csom_12_n_an        DECIMAL(3, 0),
    cmic_01_n_an        DECIMAL(3, 0) COMMENT'Numero di analisi per il valore di Carica Microbiotica - mese 01',
    cmic_02_n_an        DECIMAL(3, 0),
    cmic_03_n_an        DECIMAL(3, 0),
    cmic_04_n_an        DECIMAL(3, 0),
    cmic_05_n_an        DECIMAL(3, 0),
    cmic_06_n_an        DECIMAL(3, 0),
    cmic_07_n_an        DECIMAL(3, 0),
    cmic_08_n_an        DECIMAL(3, 0),
    cmic_09_n_an        DECIMAL(3, 0),
    cmic_10_n_an        DECIMAL(3, 0),
    cmic_11_n_an        DECIMAL(3, 0),
    cmic_12_n_an        DECIMAL(3, 0),
    pp_01_n_an          DECIMAL(3, 0) COMMENT'Numero di analisi per il valore di Proteine - mese 01',
    pp_02_n_an          DECIMAL(3, 0),
    pp_03_n_an          DECIMAL(3, 0),
    pp_04_n_an          DECIMAL(3, 0),
    pp_05_n_an          DECIMAL(3, 0),
    pp_06_n_an          DECIMAL(3, 0),
    pp_07_n_an          DECIMAL(3, 0),
    pp_08_n_an          DECIMAL(3, 0),
    pp_09_n_an          DECIMAL(3, 0),
    pp_10_n_an          DECIMAL(3, 0),
    pp_11_n_an          DECIMAL(3, 0),
    pp_12_n_an          DECIMAL(3, 0),
    all_asl             VARCHAR(10 ) DEFAULT 0 NOT NULL,
	CONSTRAINT tlatte_sintesi_analisi_pk1 PRIMARY KEY (cuaa_azienda, matricola_azienda, anno_riferimento, all_asl)
)COMMENT 'Tabella che raccoglie i dati qualitativi di Agrinet aggregati per Matricola su cui vengono eseguite le elaborazioni relative alle medie dei 3 parametri';