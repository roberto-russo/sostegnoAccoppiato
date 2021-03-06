--------------------------------------------------------
--  DDL for Table DMT_T_IRREG_INTEN
--------------------------------------------------------

  CREATE TABLE DEMETRA.DMT_T_IRREG_INTEN 
   (	PROGR NUMBER(19,0),
   CUAA VARCHAR2(16 CHAR), 
	COD_STALLA VARCHAR2(20 CHAR), 
	INTENZIONALITA VARCHAR2(1 CHAR), 
	MARCA_AURICOLARE VARCHAR2(20 CHAR), 
	N_ANIMALI_ANOMALI NUMBER(10,0),
	ANNO_CAMPAGNA NUMBER(4,0)
   )
  TABLESPACE DEMETRA_TBL ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_IRREG_INTEN
--------------------------------------------------------

  CREATE UNIQUE INDEX DEMETRA.IE_DMT_T_IRREG_INTEN ON DEMETRA.DMT_T_IRREG_INTEN (CUAA, COD_STALLA,PROGR, ANNO_CAMPAGNA) 
  TABLESPACE DEMETRA_IDX ;
--------------------------------------------------------
--  Constraints for Table DMT_T_IRREG_INTEN
--------------------------------------------------------

  ALTER TABLE DEMETRA.DMT_T_IRREG_INTEN ADD CHECK (INTENZIONALITA = 'S' OR INTENZIONALITA = 'N') ENABLE;
 
  ALTER TABLE DEMETRA.DMT_T_IRREG_INTEN MODIFY (CUAA NOT NULL ENABLE);
 
  ALTER TABLE DEMETRA.DMT_T_IRREG_INTEN MODIFY (COD_STALLA NOT NULL ENABLE);
  
  ALTER TABLE DEMETRA.DMT_T_IRREG_INTEN MODIFY (PROGR NOT NULL ENABLE);
  
  ALTER TABLE DEMETRA.DMT_T_IRREG_INTEN MODIFY (ANNO_CAMPAGNA NOT NULL ENABLE);
  
  ALTER TABLE DEMETRA.DMT_T_IRREG_INTEN ADD CONSTRAINT PK_DMT_T_IRREG_INTEN PRIMARY KEY (CUAA, COD_STALLA, PROGR, ANNO_CAMPAGNA);