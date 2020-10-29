CREATE TABLE DMT_T_INFO_ALLEV_BENEFICIARIO(
    id_sessione NUMBER(19, 0),
    id_capo     NUMBER(19, 0),
    allev_id    NUMBER(19, 0),
    anno_campagna NUMBER(4, 0),
    
CONSTRAINT PK_DMT_T_INFO_ALLEV_BENEF PRIMARY KEY(id_capo, allev_id, anno_campagna)
);