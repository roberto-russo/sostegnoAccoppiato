CREATE TABLE Dmt_t_Demarcazione_PSR
(
    anno                     NUMBER(4,0),
    operazione               VARCHAR2(10 CHAR),
    nr_procedimento          LONG,
    cuaa                     VARCHAR2(16 CHAR),
    ragione_sociale          VARCHAR2(50 CHAR),
    stato_procedimento       VARCHAR2(35 CHAR),
    specie_animale           VARCHAR2(20 CHAR),
	categoria 				 VARCHAR2(20 CHAR),
    razza                    VARCHAR2(25 CHAR),
    numero_capi              NUMBER,
    numero_capi_pagabili     NUMBER,
    marchio_auricolare       VARCHAR2(16 CHAR),
    nr_capi_sostituiti       NUMBER,
    
    
    CONSTRAINT PK_Dmt_t_Demarcazione_PSR PRIMARY KEY(anno, marchio_auricolare)
);