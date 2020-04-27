CREATE TABLE Dmt_t_tzoo_circuiti_qualita (
    cuaa                      VARCHAR(16) NOT NULL COMMENT 'Id fiscale del proprietario e/o del detentore di un allevamento',
    id_allev_bdn              VARCHAR(25) COMMENT 'ID dell’allevamento in BDN',
    cod_allevamento           VARCHAR(26) COMMENT 'Codice aziendale dell''allevamento',
    data_inizio               DATE COMMENT 'Data iniziale del periodo di adesione al circuito di qualita',
    data_fine                 DATE COMMENT 'Data finale del periodo di adesione al circuito di qualita',
    cod_cat_cq                VARCHAR(3),
    sco_cat_cq                VARCHAR(3) NOT NULL,
    cod_denom_cq              VARCHAR(3),
    sco_denom_cq              VARCHAR(3) NOT NULL,
    struttura                 VARCHAR(100) COMMENT 'Struttura di controllo',
    pec_struttura             VARCHAR(100),
    ragione_sociale_azienda   VARCHAR(200),
	CONSTRAINT tzoo_circuiti_qualita_pk PRIMARY KEY (cuaa, sco_denom_cq, sco_cat_cq)
)