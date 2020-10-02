CREATE TABLE DMT_T_BENEFICIARIO_CAPI_DOPPI
(
    anno_campagna     NUMBER(4, 0)     NOT NULL,
    codice_intervento VARCHAR2(3 CHAR) NOT NULL,
    cuaa              VARCHAR2(16 CHAR),
    id_capo           NUMBER(19, 0)    NOT NULL,
    
    CONSTRAINT PK_DMT_T_BENEFI_CAPI_DOP PRIMARY KEY(anno_campagna, codice_intervento, id_capo)
);