CREATE TABLE Dmt_t_tlatte_vendita_diretta (
    id_azienda          DECIMAL(11, 0) NOT NULL COMMENT 'Identificativo SOP Azienda',
    versione            DECIMAL(11, 0) NOT NULL COMMENT 'Versione del dato',
    progr_riga          DECIMAL(11, 0) NOT NULL COMMENT 'Prgressivo riga',
    matricola           DECIMAL(11, 0) NOT NULL COMMENT 'Matricola',
    codice_mese         VARCHAR(3) DEFAULT 'MES' NOT NULL COMMENT 'Codice mese della tdecodifca_sop= ''MES''',
    sotto_codice_mese   VARCHAR(3) NOT NULL COMMENT 'Sotto codice mese della tdecodifca_sop',
    quantita            DECIMAL(20, 0) COMMENT 'Quantita'' di latte ',
	CONSTRAINT tlatte_vendita_diretta_pk PRIMARY KEY (id_azienda, versione, progr_riga, matricola)
)COMMENT 'Tabella di raccolata dati relativi alle quantità di latte vendute dai produttori in regime di vendita diretta';