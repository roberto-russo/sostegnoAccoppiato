--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_SESSIONE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_SESSIONE" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DATA_E_ORA" TIMESTAMP (6)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_SESSIONE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_SESSIONE" ON "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") 
 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_SESSIONE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_SESSIONE" MODIFY ("DATA_E_ORA" NOT NULL ENABLE);

  ALTER TABLE "DEMETRA"."DMT_T_SESSIONE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_SESSIONE" ADD CONSTRAINT "PK_DMT_T_SESSIONE" PRIMARY KEY ("ID_SESSIONE");

  
  
  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP";

--------------------------------------------------------
--  DDL for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"CODICE_ERRORE" VARCHAR2(20 CHAR), 
	"DESCRIZIONE_ERRORE" VARCHAR2(255 CHAR), 
	"NUMERO_CAPI" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0)
   ) 
  
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_D_CLS_PREMIO_VAL_RESP" ON "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ("ID_AUTOGENERATO") 
 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ADD CONSTRAINT "PK_DMT_D_CLS_PREMIO_VAL_RESP" PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ADD CONSTRAINT "FK_DMT_T_SESSIONE_08" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;




--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" 
   (	"ANNO" NUMBER(4,0), 
	"CUAA" VARCHAR2(16 CHAR), 
	"ID" NUMBER(19,0), 
	"ID_GESTORE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"DATA" DATE, 
	"ESITO" VARCHAR2(1 CHAR), 
	"MSG" VARCHAR2(400 CHAR)
   ) SEGMENT CREATION DEFERRED 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_D_ESITO_CONTR_PREAMM" ON "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" ("ANNO", "CUAA", "ID", "ID_GESTORE", "ID_SESSIONE") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ANNO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID_GESTORE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" ADD CONSTRAINT "PK_DMT_D_ESITO_CONTR_PREAMM" PRIMARY KEY ("ANNO", "CUAA", "ID", "ID_GESTORE", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" ADD CONSTRAINT "FK_DMT_T_SESSIONE_01" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_D_LOGGER
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_D_LOGGER" 
   (	"ID_LOG" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"DATA_GENERAZIONE_LOG" DATE, 
	"MESSAGGIO" VARCHAR2(255 CHAR) DEFAULT 'no message avaible', 
	"NOME_CLASSE_CHIAMANTE" VARCHAR2(50 CHAR), 
	"TIPO_LOG" VARCHAR2(10 CHAR) DEFAULT 'INFO'
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_D_LOGGER
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_D_LOGGER" ON "DEMETRA"."DMT_D_LOGGER" ("ID_LOG", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_LOGGER
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" MODIFY ("ID_LOG" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" MODIFY ("DATA_GENERAZIONE_LOG" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" MODIFY ("NOME_CLASSE_CHIAMANTE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" ADD CONSTRAINT "PK_DMT_D_LOGGER" PRIMARY KEY ("ID_LOG", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_LOGGER
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" ADD CONSTRAINT "FK_DMT_T_SESSIONE_17" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_D_TRIEP_DU_PREMI_CAPI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" 
   (	"COD_PREMIO" VARCHAR2(3 CHAR), 
	"ID_DOMANDA" NUMBER(19,0), 
	"ID_RICHIESTA" NUMBER(19,0) DEFAULT '0', 
	"SCO_ATTIVITA" VARCHAR2(3 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"CAPI_ANOMALI_ART52" FLOAT(126), 
	"COD_ATTIVITA" VARCHAR2(3 CHAR) DEFAULT 'TAT', 
	"COD_TIPO_CALCOLO" VARCHAR2(3 CHAR) DEFAULT 'CLC', 
	"DATA_CALCOLO" TIMESTAMP (6), 
	"ESITO_PERC_ART52" FLOAT(126), 
	"ID_AZIENDA" NUMBER(19,0), 
	"IMP_ANTE_MODULAZIONE" FLOAT(126), 
	"IMP_POST_DF" FLOAT(126), 
	"IMP_POST_MODULAZIONE" FLOAT(126), 
	"IMP_POST_PRES_TARD" FLOAT(126), 
	"IMPORTO" FLOAT(126), 
	"IMPORTO_BASE" FLOAT(126), 
	"IMPORTO_PRE_TAGLIO" FLOAT(126), 
	"NR_CAPI_AMM_CAMP" FLOAT(126), 
	"NR_CAPI_ANOMALI_BDN" NUMBER(19,0), 
	"NR_CAPI_ANOMALI_CIL" NUMBER(19,0), 
	"NR_CAPI_BO" NUMBER(19,0), 
	"NR_CAPI_COMP" NUMBER(19,0), 
	"NR_CAPI_CORR" FLOAT(126), 
	"NR_CAPI_LG" NUMBER(19,0), 
	"NR_CAPI_MA" NUMBER(19,0), 
	"NR_CAPI_TOT_BDN" FLOAT(126), 
	"NR_CAPI_TOT_CIL" NUMBER(19,0), 
	"NR_CAPI_VN" NUMBER(19,0), 
	"NR_CAPI_VN2" NUMBER(19,0), 
	"PERC_BASE" FLOAT(126), 
	"PERC_CONDIZIONALITA" FLOAT(126), 
	"PERC_MODULAZIONE" FLOAT(126), 
	"PERC_PAS_FOR" FLOAT(126), 
	"PERC_PRESENT_TARD" FLOAT(126), 
	"PERC_UBA_SAU" FLOAT(126), 
	"SCO_TIPO_CALCOLO" VARCHAR2(3 CHAR) DEFAULT '002', 
	"SCOSTAMENTO_PERC" FLOAT(126), 
	"TIPO_RIGA" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_D_TRIEP_DU_PREMI_CAPI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_D_TRIEP_DU_PREMI_CAPI" ON "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" ("COD_PREMIO", "ID_DOMANDA", "ID_RICHIESTA", "SCO_ATTIVITA", "ID_SESSIONE") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_TRIEP_DU_PREMI_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("COD_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("ID_DOMANDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("ID_RICHIESTA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("SCO_ATTIVITA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("COD_ATTIVITA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("COD_TIPO_CALCOLO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("ID_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("SCO_TIPO_CALCOLO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" MODIFY ("TIPO_RIGA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" ADD CONSTRAINT "PK_DMT_D_TRIEP_DU_PREMI_CAPI" PRIMARY KEY ("COD_PREMIO", "ID_DOMANDA", "ID_RICHIESTA", "SCO_ATTIVITA", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_TRIEP_DU_PREMI_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_TRIEP_DU_PREMI_CAPI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_02" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_DEC_CATEGORIA" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(255 CHAR), 
	"ID" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_DEC_CATEGORIA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_DEC_CATEGORIA" ON "DEMETRA"."DMT_DEC_CATEGORIA" ("ID_SESSIONE") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_DEC_CATEGORIA" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_DEC_CATEGORIA" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_DEC_CATEGORIA" ADD CONSTRAINT "PK_DMT_DEC_CATEGORIA" PRIMARY KEY ("ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_DEC_CATEGORIA" ADD CONSTRAINT "FK_DMT_T_SESSIONE_18" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CLS_PREMIO_VALID
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CODICE_INTERVENTO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CLS_PREMIO_VALID
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CLS_PREMIO_VALID" ON "DEMETRA"."DMT_T_CLS_PREMIO_VALID" ("ANNO_CAMPAGNA", "CODICE_INTERVENTO", "CUAA", "ID_SESSIONE") 
  
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CLS_PREMIO_VALID
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" MODIFY ("CODICE_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" ADD CONSTRAINT "PK_DMT_T_CLS_PREMIO_VALID" PRIMARY KEY ("ANNO_CAMPAGNA", "CODICE_INTERVENTO", "CUAA", "ID_SESSIONE");

--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CLS_PREMIO_VALID
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" ADD CONSTRAINT "FK_DMT_T_SESSIONE_05" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" 
   (	"ID_ALLE_BDN" NUMBER(19,0),  
	"ID_SESSIONE" NUMBER(19,0), 
	"ANNO_CAMPAGNA" NUMBER(4,0), 
	"CODICE_INTERVENTO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"CUAA2" VARCHAR2(16 CHAR)
   ) SEGMENT CREATION DEFERRED 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CLS_PREMIO_VALID_PP" ON "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" ("ID_ALLE_BDN", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ID_ALLE_BDN" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CODICE_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CUAA2" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" ADD CONSTRAINT "PK_DMT_T_CLS_PREMIO_VALID_PP" PRIMARY KEY ("ID_ALLE_BDN", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" ADD CONSTRAINT "FK_DMT_T_SESSIONE_34" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" 
   (	"ID_CATEGORIA" NUMBER(19,0), 
	"ID_SPECIE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"COEFFICIENTE" NUMBER(*,2)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_COEFFICIENTI_UBA" ON "DEMETRA"."DMT_T_COEFFICIENTI_UBA" ("ID_CATEGORIA", "ID_SPECIE", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_CATEGORIA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" ADD CONSTRAINT "PK_DMT_T_COEFFICIENTI_UBA" PRIMARY KEY ("ID_CATEGORIA", "ID_SPECIE", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" ADD CONSTRAINT "FK_DMT_T_SESSIONE_20" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" 
   (	"P_CUAA" VARCHAR2(16 CHAR),  
	"ID_SESSIONE" NUMBER(19,0), 
	"DATA_FINE_PERIODO" VARCHAR2(12 CHAR), 
	"DATA_INIZIO_PERIODO" VARCHAR2(12 CHAR), 
	"P_TIPO_RESPONSABILITA" VARCHAR2(1 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CONSIST_UBA_CENSIM_OVINI" ON "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ("P_CUAA", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" MODIFY ("P_CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ADD CONSTRAINT "PK_DMT_T_CONS_UBA_CENS_OV" PRIMARY KEY ("P_CUAA", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_21" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_DEC_SPECIE" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(255 CHAR), 
	"ID" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_DEC_SPECIE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_DEC_SPECIE" ON "DEMETRA"."DMT_T_DEC_SPECIE" ("ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DEC_SPECIE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DEC_SPECIE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DEC_SPECIE" ADD CONSTRAINT "PK_DMT_T_DEC_SPECIE" PRIMARY KEY ("ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DEC_SPECIE" ADD CONSTRAINT "FK_DMT_T_SESSIONE_22" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(255 CHAR), 
	"ID" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_DEC_TIPOLOGIA_GESTORE" ON "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ("ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ADD CONSTRAINT "PK_DMT_T_DEC_TIPOLOGIA_GESTORE" PRIMARY KEY ("ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ADD CONSTRAINT "FK_DMT_T_SESSIONE_23" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_DS_SCARICO_ALLEVAMENTI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_DS_SCARICO_ALLEVAMENTI" 
   (	"ALLEV_ID" NUMBER(10,0), 
	"AUTORIZZAZIONE_LATTE" VARCHAR2(1 CHAR), 
	"AZIENDA_CODICE" VARCHAR2(12 CHAR), 
	"BUFALINI" NUMBER(*,2), 
	"CAP" VARCHAR2(5 CHAR), 
	"CAPI_0_6_MESI" NUMBER(*,2), 
	"CAPI_6_24_MESI" NUMBER(*,2), 
	"CAPI_OLTRE_24_MESI" NUMBER(*,2), 
	"CAPI_TOTALI" NUMBER(19,2), 
	"CAPRINI" NUMBER(*,2), 
	"COD_FISCALE_PROP" VARCHAR2(16 CHAR), 
	"COD_TIPO_ALLEV" VARCHAR2(10 CHAR), 
	"CODICE_FISCALE_DETEN" VARCHAR2(16 CHAR), 
	"COM_CODICE" VARCHAR2(6 CHAR), 
	"CONS_MEDIA_CAPI_0_6_MESI" NUMBER(*,2), 
	"CONS_MEDIA_CAPI_6_24_MESI" NUMBER(*,2), 
	"CONS_MEDIA_CAPI_OLTRE_24_MESI" NUMBER(*,2), 
	"CONS_MEDIA_TOTALE" NUMBER(*,2), 
	"CONS_MEDIA_VACCHE_OLTRE_20" NUMBER(*,2), 
	"DATA_CALCOLO_CAPI" DATE, 
	"DATA_INIZIO_AUTORIZZAZIONE" DATE, 
	"DATA_REVOCA_AUTORIZZAZIONE" DATE, 
	"DATA_ULTIMO_CENSIMENTO" DATE, 
	"DENOM_DETENTORE" VARCHAR2(50 CHAR), 
	"DENOM_PROPRIETARIO" VARCHAR2(50 CHAR), 
	"DENOMINAZIONE" VARCHAR2(50 CHAR), 
	"DESCR_TIPO_ALLEV" VARCHAR2(255 CHAR), 
	"DT_FINE_ATTIVITA" DATE, 
	"DT_FINE_DETENTORE" DATE, 
	"DT_FINE_PERIODO" DATE, 
	"DT_INIZIO_ATTIVITA" DATE, 
	"DT_INIZIO_DETENTORE" DATE, 
	"DT_INIZIO_PERIODO" DATE, 
	"FLAG_LIBRI_GENEALOGICI" VARCHAR2(1 CHAR), 
	"FOGLIO_CATASTALE" VARCHAR2(10 CHAR), 
	"ID_FISCALE" VARCHAR2(16 CHAR), 
	"INDIRIZZO" VARCHAR2(50 CHAR), 
	"LATITUDINE" NUMBER(11,6), 
	"LOCALITA" VARCHAR2(50 CHAR), 
	"LONGITUDINE" NUMBER(11,6), 
	"ORIENTAMENTO_PRODUTTIVO" VARCHAR2(10 CHAR), 
	"OVINI" NUMBER(*,2), 
	"PARTICELLA" VARCHAR2(10 CHAR), 
	"PRO_CODICE" VARCHAR2(6 CHAR), 
	"SEZIONE" VARCHAR2(10 CHAR), 
	"SOCCIDA" VARCHAR2(1 CHAR), 
	"SPE_CODICE" VARCHAR2(10 CHAR), 
	"SUBALTERNO" VARCHAR2(10 CHAR), 
	"TIPO_PRODUZIONE" VARCHAR2(10 CHAR), 
	"VACCHE_DA_LATTE" NUMBER(*,2), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_DS_SCARICO_ALLEVAMENTI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_DS_SCARICO_ALLEVAMENTI" ON "DEMETRA"."DMT_T_DS_SCARICO_ALLEVAMENTI" ("ALLEV_ID") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_DS_SCARICO_ALLEVAMENTI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DS_SCARICO_ALLEVAMENTI" MODIFY ("ALLEV_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DS_SCARICO_ALLEVAMENTI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DS_SCARICO_ALLEVAMENTI" ADD CONSTRAINT "PK_DMT_T_DS_SCA_ALLEV" PRIMARY KEY ("ALLEV_ID");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_DS_SCARICO_ALLEVAMENTI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DS_SCARICO_ALLEVAMENTI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_24" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_GESTORI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_GESTORI" 
   (	"ID" NUMBER(19,0), 
	"ID_TIPOLOGIA" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"NOME_SERVICE" VARCHAR2(30 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_GESTORI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_GESTORI" ON "DEMETRA"."DMT_T_GESTORI" ("ID", "ID_TIPOLOGIA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_GESTORI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_GESTORI" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_GESTORI" MODIFY ("ID_TIPOLOGIA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_GESTORI" ADD CONSTRAINT "PK_DMT_T_GESTORI" PRIMARY KEY ("ID", "ID_TIPOLOGIA");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_GESTORI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_GESTORI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_26" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_INTERVENTO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_INTERVENTO" 
   (	"ID" NUMBER(19,0), 
	"ID_CATEGORIA" NUMBER(10,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"ID_SPECIE" NUMBER(10,0), 
	"INTERVENTO" VARCHAR2(3 CHAR), 
	"MISURA" NUMBER(*,2)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_INTERVENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_INTERVENTO" ON "DEMETRA"."DMT_T_INTERVENTO" ("ID", "ID_CATEGORIA", "ID_SESSIONE", "ID_SPECIE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_INTERVENTO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" MODIFY ("ID_CATEGORIA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" MODIFY ("ID_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" ADD CONSTRAINT "PK_DMT_T_INTERVENTO" PRIMARY KEY ("ID", "ID_CATEGORIA", "ID_SESSIONE", "ID_SPECIE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_INTERVENTO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" ADD CONSTRAINT "FK_DMT_T_SESSIONE_27" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_RAZZE_AMMISSIBILI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_RAZZE_AMMISSIBILI" 
   (	"SEZIONE_RAZZA" VARCHAR2(20 CHAR), 
	"ASSOCIAZIONE" VARCHAR2(20 CHAR), 
	"DENOM_UFF_LG" VARCHAR2(50 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_RAZZE_AMMISSIBILI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_RAZZE_AMMISSIBILI" ON "DEMETRA"."DMT_T_RAZZE_AMMISSIBILI" ("SEZIONE_RAZZA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_RAZZE_AMMISSIBILI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_RAZZE_AMMISSIBILI" MODIFY ("SEZIONE_RAZZA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_RAZZE_AMMISSIBILI" ADD CONSTRAINT "PK_DMT_T_RAZZE_AMMISSIBILI" PRIMARY KEY ("SEZIONE_RAZZA");

  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_TLATTE_MENSILE_ARPEA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" 
   (	"ANNO_RIFERIMENTO" NUMBER(19,0) UNIQUE, 
	"ANNO_SOLARE" NUMBER(19,0) UNIQUE, 
	"MATR_ACQUIRENTE" NUMBER(19,0) UNIQUE, 
	"MATR_AZIENDA" NUMBER(19,0) UNIQUE, 
	"SCO_MESE" VARCHAR2(3 CHAR) UNIQUE, 
	"SESSIONE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"COD_MESE" VARCHAR2(3 CHAR) DEFAULT 'MES', 
	"CUAA_ACQUIRENTE" VARCHAR2(16 CHAR), 
	"CUAA_AZIENDA" VARCHAR2(16 CHAR), 
	"DENOM_ACQUIRENTE" VARCHAR2(150 CHAR), 
	"DENOM_AZIENDA" VARCHAR2(255 CHAR), 
	"FLAG_SUBENTRO" VARCHAR2(1 CHAR), 
	"MESE" VARCHAR2(10 CHAR), 
	"PRIMO_ANNO_CAMPAGNA" NUMBER(19,0), 
	"QT_CONSEGNATA" NUMBER(19,0), 
	"TEN_MAT_GRASSA_PERIODO" NUMBER(*,2)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_01
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_01" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("ANNO_RIFERIMENTO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_02
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_02" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("ANNO_SOLARE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_03
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_03" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("MATR_ACQUIRENTE") 
  
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_04
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_04" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("MATR_AZIENDA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_05
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_05" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("SCO_MESE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_06
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_06" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("ANNO_RIFERIMENTO", "ANNO_SOLARE", "MATR_ACQUIRENTE", "MATR_AZIENDA", "SCO_MESE", "SESSIONE") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TLATTE_MENSILE_ARPEA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("ANNO_RIFERIMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("ANNO_SOLARE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("MATR_ACQUIRENTE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("MATR_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("SCO_MESE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ADD PRIMARY KEY ("ANNO_RIFERIMENTO", "ANNO_SOLARE", "MATR_ACQUIRENTE", "MATR_AZIENDA", "SCO_MESE", "SESSIONE");

--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TLATTE_MENSILE_ARPEA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ADD CONSTRAINT "FK_DMT_T_SESSIONE_28" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_TLATTE_SIN_AN
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_TLATTE_SIN_AN" 
   (	"ANNO_RIFERIMENTO" NUMBER(19,0), 
	"CUAA_AZIENDA" VARCHAR2(16 CHAR), 
	"MATRICOLA_AZIENDA" NUMBER(19,0),  
	"ID_SESSIONE" NUMBER(19,0), 
	"ALL_ASL" VARCHAR2(10 CHAR), 
	"CMIC_01_N_AN" NUMBER(19,0), 
	"CMIC_02_N_AN" NUMBER(19,0), 
	"CMIC_03_N_AN" NUMBER(19,0), 
	"CMIC_04_N_AN" NUMBER(19,0), 
	"CMIC_05_N_AN" NUMBER(19,0), 
	"CMIC_06_N_AN" NUMBER(19,0), 
	"CMIC_07_N_AN" NUMBER(19,0), 
	"CMIC_08_N_AN" NUMBER(19,0), 
	"CMIC_09_N_AN" NUMBER(19,0), 
	"CMIC_10_N_AN" NUMBER(19,0), 
	"CMIC_11_N_AN" NUMBER(19,0), 
	"CMIC_12_N_AN" NUMBER(19,0), 
	"CMIC_MED" NUMBER(19,0), 
	"CSOM_01_N_AN" NUMBER(19,0), 
	"CSOM_02_N_AN" NUMBER(19,0), 
	"CSOM_03_N_AN" NUMBER(19,0), 
	"CSOM_04_N_AN" NUMBER(19,0), 
	"CSOM_05_N_AN" NUMBER(19,0), 
	"CSOM_06_N_AN" NUMBER(19,0), 
	"CSOM_07_N_AN" NUMBER(19,0), 
	"CSOM_08_N_AN" NUMBER(19,0), 
	"CSOM_09_N_AN" NUMBER(19,0), 
	"CSOM_10_N_AN" NUMBER(19,0), 
	"CSOM_11_N_AN" NUMBER(19,0), 
	"CSOM_12_N_AN" NUMBER(19,0), 
	"CSOM_MED" NUMBER(19,0), 
	"PP_01_N_AN" NUMBER(19,0), 
	"PP_02_N_AN" NUMBER(19,0), 
	"PP_03_N_AN" NUMBER(19,0), 
	"PP_04_N_AN" NUMBER(19,0), 
	"PP_05_N_AN" NUMBER(19,0), 
	"PP_06_N_AN" NUMBER(19,0), 
	"PP_07_N_AN" NUMBER(19,0), 
	"PP_08_N_AN" NUMBER(19,0), 
	"PP_09_N_AN" NUMBER(19,0), 
	"PP_10_N_AN" NUMBER(19,0), 
	"PP_11_N_AN" NUMBER(19,0), 
	"PP_12_N_AN" NUMBER(19,0), 
	"PP_MED" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_SIN_AN
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLATTE_SIN_AN" ON "DEMETRA"."DMT_T_TLATTE_SIN_AN" ("ANNO_RIFERIMENTO", "CUAA_AZIENDA", "MATRICOLA_AZIENDA", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TLATTE_SIN_AN
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_SIN_AN" MODIFY ("ANNO_RIFERIMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_SIN_AN" MODIFY ("CUAA_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_SIN_AN" MODIFY ("MATRICOLA_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_SIN_AN" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_SIN_AN" MODIFY ("ALL_ASL" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_SIN_AN" ADD CONSTRAINT "PK_DMT_T_TLATTE_SIN_AN" PRIMARY KEY ("ANNO_RIFERIMENTO", "CUAA_AZIENDA", "MATRICOLA_AZIENDA", "ID_SESSIONE");
  
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TLATTE_SIN_AN
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_SIN_AN" ADD CONSTRAINT "FK_DMT_T_SESSIONE_29" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_TLATTE_VEND_DIR
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" 
   (	"ID_AZIENDA" NUMBER(19,0), 
	"MATRICOLA" NUMBER(19,0), 
	"PROGR_RIGA" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"VERSIONE" NUMBER(19,0), 
	"CODICE_MESE" VARCHAR2(3 CHAR) DEFAULT 'MES', 
	"QUANTITA" NUMBER(19,0), 
	"SOTTO_CODICE_MESE" VARCHAR2(3 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_VEND_DIR
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLATTE_VEND_DIR" ON "DEMETRA"."DMT_T_TLATTE_VEND_DIR" ("ID_AZIENDA", "MATRICOLA", "PROGR_RIGA", "ID_SESSIONE", "VERSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TLATTE_VEND_DIR
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" MODIFY ("ID_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" MODIFY ("MATRICOLA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" MODIFY ("PROGR_RIGA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" MODIFY ("VERSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" MODIFY ("CODICE_MESE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" MODIFY ("SOTTO_CODICE_MESE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" ADD CONSTRAINT "PK_DMT_T_TLATTE_VEND_DIR" PRIMARY KEY ("ID_AZIENDA", "MATRICOLA", "PROGR_RIGA", "ID_SESSIONE", "VERSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TLATTE_VEND_DIR
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_VEND_DIR" ADD CONSTRAINT "FK_DMT_T_SESSIONE_30" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_W_CALCOLI_INTERVENTI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" 
   (	"ID_GESTORE" NUMBER(19,0), 
	"ID_INTERVENTO" NUMBER(19,0), 
	"ORDINE_ESECUZIONE" VARCHAR2(10 CHAR),
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_W_CALCOLI_INTERVENTI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_W_CALCOLI_INTERVENTI" ON "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" ("ID_GESTORE", "ID_INTERVENTO", "ORDINE_ESECUZIONE", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_W_CALCOLI_INTERVENTI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" MODIFY ("ID_GESTORE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" MODIFY ("ID_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" MODIFY ("ORDINE_ESECUZIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" ADD PRIMARY KEY ("ID_GESTORE", "ID_INTERVENTO", "ORDINE_ESECUZIONE", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_W_CALCOLI_INTERVENTI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_31" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_W_CONTR_PREAM
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_W_CONTR_PREAM" 
   (	"ID_INTERVENTO" NUMBER(19,0), 
	"NOME_CLASSE_CALCOLO" VARCHAR2(30 CHAR), 
	"ORDINE_ESECUZIONE" VARCHAR2(10 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_W_CONTR_PREAM
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_W_CONTR_PREAM" ON "DEMETRA"."DMT_W_CONTR_PREAM" ("ID_INTERVENTO", "NOME_CLASSE_CALCOLO", "ORDINE_ESECUZIONE", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_W_CONTR_PREAM
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" MODIFY ("ID_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" MODIFY ("NOME_CLASSE_CALCOLO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" MODIFY ("ORDINE_ESECUZIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" ADD CONSTRAINT "PK_DMT_W_CONTR_PREAM" PRIMARY KEY ("ID_INTERVENTO", "NOME_CLASSE_CALCOLO", "ORDINE_ESECUZIONE", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_W_CONTR_PREAM
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" ADD CONSTRAINT "FK_DMT_T_SESSIONE_32" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_W_TPREMIO_ZOO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" 
   (	"COD_ALLEVAMENTO" VARCHAR2(15 CHAR), 
	"COD_SPECIE" VARCHAR2(3 CHAR) DEFAULT 'TCA', 
	"ID_ALLEV_BDN" VARCHAR2(25 CHAR), 
	"ID_AZIENDA" NUMBER(19,0), 
	"SCO_SPECIE" VARCHAR2(3 CHAR),  
	"VERSIONE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"AGNELLE_RIMONTA" VARCHAR2(1 CHAR), 
	"BOVINI_MACELLATI" VARCHAR2(1 CHAR), 
	"BUFALE" VARCHAR2(1 CHAR), 
	"CAP" VARCHAR2(5 CHAR), 
	"COD_ASL" VARCHAR2(16 CHAR), 
	"COD_ISTAT_COM" VARCHAR2(3 CHAR), 
	"COD_ISTAT_PROV" VARCHAR2(3 CHAR), 
	"COD_TITOLARITA" VARCHAR2(3 CHAR) DEFAULT 'TCP', 
	"DATA_SCARICO" TIMESTAMP (6), 
	"DENOMINAZIONE" VARCHAR2(30 CHAR), 
	"FRAZIONE" VARCHAR2(40 CHAR), 
	"ID_FISCALE" VARCHAR2(16 CHAR), 
	"INDIRIZZO" VARCHAR2(100 CHAR), 
	"MACELLATI_12_MESI" VARCHAR2(1 CHAR), 
	"MACELLATI_ETICHETTATURA" VARCHAR2(1 CHAR), 
	"MACELLATI_IGP" VARCHAR2(1 CHAR), 
	"MACELLATI_QUALITA" VARCHAR2(1 CHAR), 
	"OVICAPRINI_MACELLATI" VARCHAR2(1 CHAR), 
	"SCO_TITOLARITA" VARCHAR2(3 CHAR), 
	"TELEFONO" VARCHAR2(20 CHAR), 
	"VACCHE_CARNE_IBR" VARCHAR2(1 CHAR), 
	"VACCHE_LATTE" VARCHAR2(1 CHAR), 
	"VACCHE_MONTAGNA" VARCHAR2(1 CHAR), 
	"VACCHE_NUTRICI" VARCHAR2(1 CHAR), 
	"VACCHE_NUTRICI_DA" VARCHAR2(1 CHAR), 
	"VACCHE_NUTRICI_NG" VARCHAR2(1 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_W_TPREMIO_ZOO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_W_TPREMIO_ZOO" ON "DEMETRA"."DMT_W_TPREMIO_ZOO" ("COD_ALLEVAMENTO", "COD_SPECIE", "ID_ALLEV_BDN", "ID_AZIENDA", "SCO_SPECIE", "ID_SESSIONE", "VERSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_W_TPREMIO_ZOO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_ALLEVAMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("ID_ALLEV_BDN" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("ID_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("SCO_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("VERSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_ASL" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_ISTAT_COM" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_TITOLARITA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("DATA_SCARICO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("DENOMINAZIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("INDIRIZZO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("SCO_TITOLARITA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" ADD PRIMARY KEY ("COD_ALLEVAMENTO", "COD_SPECIE", "ID_ALLEV_BDN", "ID_AZIENDA", "SCO_SPECIE", "ID_SESSIONE", "VERSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_W_TPREMIO_ZOO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" ADD CONSTRAINT "FK_DMT_T_SESSIONE_33" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_W_TZOO_CIRCUITI_QUALITA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_W_TZOO_CIRCUITI_QUALITA" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"ID_ALLEV_BDN" VARCHAR2(25 CHAR), 
	"SCO_CAT_CQ" VARCHAR2(3 CHAR), 
	"SCO_DEMON_CQ" VARCHAR2(3 CHAR),  
	"ID_SESSIONE" NUMBER(19,0), 
	"COD_ALLEVAMENTO" VARCHAR2(26 CHAR), 
	"COD_CAT_CQ" VARCHAR2(3 CHAR), 
	"COD_DEMON_CQ" VARCHAR2(3 CHAR), 
	"DATA_FINE" DATE, 
	"DATA_INIZIO" DATE, 
	"PEC_STRUTTURA" VARCHAR2(100 CHAR), 
	"RAGIONE_SOCIALE_AZIENDA" VARCHAR2(50 CHAR), 
	"STRUTTURA" VARCHAR2(100 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_W_TZOO_CIRCUITI_QUALITA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_W_TZOO_CIRCUITI_QUALITA" ON "DEMETRA"."DMT_W_TZOO_CIRCUITI_QUALITA" ("CUAA", "ID_ALLEV_BDN", "SCO_CAT_CQ", "SCO_DEMON_CQ", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
	
	
	CREATE TABLE demetra.dmt_t_analisi_produzioni_cuua
(
    cuua varchar2(16) NOT NULL,
    anno_campagna number(4) NOT NULL,
    data_analisi timestamp NOT NULL,
    carica_batterica number(19,2),
    cellule_somatiche number(19,2),
    codice_asl varchar2(16),
    partita_iva varchar2(11),
    proteine numeric(19,2),
    ragione_sociale varchar2(100)
) TABLESPACE "DEMETRA_TBL";

ALTER TABLE demetra.dmt_t_analisi_produzioni_cuua ADD CONSTRAINT "PK_DMT_T_Analisi_cuaa"  PRIMARY KEY ("CUUA","ANNO_CAMPAGNA","DATA_ANALISI");

  CREATE TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" 
   (	"ANNO_CAMPAGNA" NUMBER(4) not null, 
	"IMPORTO_UNITARIO" NUMBER(10,2) not null, 
	"INTERVENTO" NUMBER(3) not null
   ) 
  TABLESPACE "DEMETRA_TBL" ;
  
  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_IMPORTO_UNITARIO" ON "DEMETRA"."DMT_T_IMPORTO_UNITARIO" ("ANNO_CAMPAGNA", "IMPORTO_UNITARIO") 
  TABLESPACE "DEMETRA_IDX" ;

  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" ADD PRIMARY KEY ("ANNO_CAMPAGNA", "INTERVENTO")
  USING INDEX  TABLESPACE "DEMETRA_TBL"  ENABLE;

  
  --------------------------------------------------------
--  File creato - lunedì-maggio-18-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_INFO_ALLEVAMENTI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_INFO_ALLEVAMENTI" 
   (	"FLAG_ZONA_MONTANA" VARCHAR2(1 CHAR) NOT NULL , 
	"ALLEV_ID" NUMBER NOT NULL 
   ) 
  TABLESPACE "DEMETRA_TBL" ;

--------------------------------------------------------
--  Constraints for Table DMT_T_INFO_ALLEVAMENTI
--------------------------------------------------------
 ALTER TABLE "DEMETRA"."DMT_T_INFO_ALLEVAMENTI" ADD PRIMARY KEY ("ALLEV_ID")
  USING INDEX
  TABLESPACE "DEMETRA_TBL"  ENABLE;

  
  -- Table: public.dmt_t_latte_vendita_diretta

-- DROP TABLE public.dmt_t_latte_vendita_diretta;

CREATE TABLE demetra.dmt_t_latte_vendita_diretta
(
    cuua varchar2(16) NOT NULL,
    anno_campagna number(4) NOT NULL,
    mese varchar(12) NOT NULL,
    matricola varchar(20),
    quantita number(10)
)TABLESPACE "DEMETRA_TBL" ;

ALTER TABLE demetra.dmt_t_latte_vendita_diretta ADD CONSTRAINT "PK_dmt_t_latte_vendita" PRIMARY KEY (anno_campagna, cuua, mese);

  CREATE TABLE "DEMETRA"."DMT_T_SISTEMI_ETICHETTATURA" 
   (	"CUAA" VARCHAR2(16 CHAR) NOT NULL, 
	"FLAG_ETICHETTATURA" VARCHAR2(1 CHAR) NOT NULL
   )
  TABLESPACE "DEMETRA_TBL" ;
 
  ALTER TABLE "DEMETRA"."DMT_T_SISTEMI_ETICHETTATURA" ADD PRIMARY KEY ("CUAA")
  USING INDEX
  TABLESPACE "DEMETRA_TBL"  ENABLE;

    CREATE TABLE "DEMETRA"."DMT_W_CONTROLLO_BEAN" 
   (	"CODICE" VARCHAR2(255 CHAR) NOT NULL ENABLE, 
	"BEAN" VARCHAR2(255 CHAR)
   )
  TABLESPACE "DEMETRA_TBL" ;
  
  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_W_CONTROLLO_BEAN" ON "DEMETRA"."DMT_W_CONTROLLO_BEAN" ("CODICE") 
  TABLESPACE "DEMETRA_IDX" ;
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTROLLO_BEAN" ADD CONSTRAINT "PK_DMT_W_CONTROLLO_BEAN" PRIMARY KEY ("CODICE");

  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_UBA_CENSIM_ALLEV_OVINI
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI";

--------------------------------------------------------
--  DDL for Table DMT_T_UBA_CENSIM_ALLEV_OVINI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"AZIENDA_CODICE" VARCHAR2(12 CHAR), 
	"C_CAPI_TOT" NUMBER(19,2), 
	"C_CAPRETTI_MAC_TOT" NUMBER(19,2), 
	"C_FEMMINE_ADULTE" NUMBER(19,2), 
	"C_FEMMINE_ADULTE_LIB" NUMBER(19,2), 
	"C_FEMMINE_RIMONTA" NUMBER(19,2), 
	"C_FEMMINE_RIMONTA_LIB" NUMBER(19,2), 
	"C_MASCHI_ADULTI" NUMBER(19,2), 
	"C_MASCHI_ADULTI_LIB" NUMBER(19,2), 
	"C_MASCHI_RIMONTA" NUMBER(19,2), 
	"C_MASCHI_RIMONTA_LIB" NUMBER(19,2), 
	"CENSIMENTO_ID" NUMBER(19,2), 
	"COD_FISCALE_DETE" VARCHAR2(16 CHAR), 
	"COD_FISCALE_PROP" VARCHAR2(16 CHAR), 
	"CODICE_QUALIFICA_SCRAPIE" VARCHAR2(10 CHAR), 
	"DATA_CENSIMENTO" DATE, 
	"DATA_FINE_PERIODO" DATE, 
	"DATA_INIZIO_PERIODO" DATE, 
	"DATA_RILEVAZIONE_QUALIFICA" DATE, 
	"DESCR_QUALIFICA_SCRAPIE" VARCHAR2(255 CHAR), 
	"DT_COM_AUTORITA" DATE, 
	"O_AGNELLI_MAC_TOT" NUMBER(19,2), 
	"O_CAPI_TOT" NUMBER(19,2), 
	"O_FEMMINE_ADULTE" NUMBER(19,2), 
	"O_FEMMINE_ADULTE_LIB" NUMBER(19,2), 
	"O_FEMMINE_RIMONTA" NUMBER(19,2), 
	"O_FEMMINE_RIMONTA_LIB" NUMBER(19,2), 
	"O_MASCHI_ADULTI" NUMBER(19,2), 
	"O_MASCHI_ADULTI_LIB" NUMBER(19,2), 
	"O_MASCHI_RIMONTA" NUMBER(19,2), 
	"O_MASCHI_RIMONTA_LIB" NUMBER(19,2), 
	"P_ALLEV_ID" NUMBER(19,2), 
	"SPECIE_CODICE" VARCHAR2(25 CHAR), 
	"SPECIE_DESCRIZIONE" VARCHAR2(255 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_UBA_CENSIM_ALLEV_OVINI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_UBA_CENSIM_ALLEV_OVINI" ON "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI" ("ID_AUTOGENERATO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_UBA_CENSIM_ALLEV_OVINI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI" MODIFY ("CENSIMENTO_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI" MODIFY ("P_ALLEV_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI" ADD CONSTRAINT "PK_DMT_T_UBA_CENSIM_ALLEV_OVINI" PRIMARY KEY ("ID_AUTOGENERATO")

  TABLESPACE "DEMETRA_TBL"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_UBA_CENSIM_ALLEV_OVINI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_UBA_CENSIM_ALLEV_OVINI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_16" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CONTROLLI_SSVV
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CONTROLLI_SSVV" 
   (	"CGO6_CGO7_CGO8" VARCHAR2(10 CHAR), 
	"COD_FISCALE_PROP" VARCHAR2(16 CHAR), 
	"ANOMALIA_MIN" VARCHAR2(255 CHAR), 
	"AZIENDA_COD" VARCHAR2(12 CHAR), 
	"COD_FISCALE_DETEN" VARCHAR2(16 CHAR), 
	"COD_IRREGOLARITA" NUMBER(10,0), 
	"DETEN_BENEFICIARI" VARCHAR2(16 CHAR), 
	"DETTAGLIO_IRREGOLARITA" VARCHAR2(255 CHAR), 
	"DT_CONTROLLO" TIMESTAMP (6), 
	"DT_VERIFICA" TIMESTAMP (6), 
	"ESITO_VERIFICA" VARCHAR2(255 CHAR), 
	"FLAG_CAPI_PRESENTI_CONTROLLATI" NUMBER(1,0), 
	"GRUPPO_ANOMALIA" VARCHAR2(255 CHAR), 
	"INCIDENZA_CAPI_ANOMALI" NUMBER(10,0), 
	"IRREGOLARITA_RISCONTRATA" VARCHAR2(255 CHAR), 
	"NUM_CAPI_ANOMALI" NUMBER(10,0), 
	"NUM_CAPI_ANOMALI_PROPORZIONE" NUMBER(*,2), 
	"NUM_CAPI_CONFORMI" NUMBER(10,0), 
	"NUM_CAPI_CONTROLLATI" NUMBER(10,0), 
	"NUM_CAPI_PRESENTI" NUMBER(10,0), 
	"NUM_IRREGOLARITA" NUMBER(10,0), 
	"PARAMETRI_VALUTAZIONE" NUMBER(10,0), 
	"PROPR_BENEFICIARI" VARCHAR2(16 CHAR), 
	"SPECIE_ALLEVATA" VARCHAR2(25 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CONTROLLI_SSVV
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CONTROLLI_SSVV" ON "DEMETRA"."DMT_T_CONTROLLI_SSVV" ("CGO6_CGO7_CGO8", "COD_FISCALE_PROP") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CONTROLLI_SSVV
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLI_SSVV" MODIFY ("CGO6_CGO7_CGO8" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLI_SSVV" MODIFY ("COD_FISCALE_PROP" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLI_SSVV" ADD CONSTRAINT "PK_DMT_T_CONTROLLI_SSVV" PRIMARY KEY ("CGO6_CGO7_CGO8", "COD_FISCALE_PROP");

  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_AGNELLE_RIMONTA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_AGNELLE_RIMONTA" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CODICE_INTERVENTO" VARCHAR2(3 CHAR), 
	"ESITO" VARCHAR2(10 CHAR), 
	"MOTIVAZIONI" VARCHAR2(255 CHAR), 
	"QT_CAPI_PREMIO" NUMBER(*,2)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_AGNELLE_RIMONTA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_AGNELLE_RIMONTA" ON "DEMETRA"."DMT_T_AGNELLE_RIMONTA" ("CUAA", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_AGNELLE_RIMONTA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_AGNELLE_RIMONTA" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_AGNELLE_RIMONTA" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_AGNELLE_RIMONTA" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_AGNELLE_RIMONTA" MODIFY ("CODICE_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_AGNELLE_RIMONTA" ADD CONSTRAINT "PK_DMT_T_AGNELLE_RIMONTA" PRIMARY KEY ("CUAA", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_AGNELLE_RIMONTA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_AGNELLE_RIMONTA" ADD CONSTRAINT "FK_DMT_T_SESSIONE_19" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_ERRORE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_ERRORE" 
   (	"INPUT" VARCHAR2(255 CHAR), 
	"NOME_METODO" VARCHAR2(50 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"ERRORE_DESCRIZIONE" VARCHAR2(100 CHAR), 
	"ERRORE_CODICE" VARCHAR2(100 CHAR)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_ERRORE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_ERRORE" ON "DEMETRA"."DMT_T_ERRORE" ("INPUT", "NOME_METODO", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_ERRORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("INPUT" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("NOME_METODO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" ADD CONSTRAINT "PK_DMT_T_ERRORE" PRIMARY KEY ("INPUT", "NOME_METODO", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_ERRORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" ADD CONSTRAINT "FK_DMT_T_SESSIONE_25" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP for Table DMT_T_TWS_BDN_DU_CAPI_BOV
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV";

--------------------------------------------------------
--  DDL for Table DMT_T_TWS_BDN_DU_CAPI_BOV
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"ID_ALLEVAMENTO" NUMBER(19,0), 
	"COD_AZIENDA" VARCHAR2(12 CHAR), 
	"AZIENDA_LATITUDINE" NUMBER(11,6), 
	"AZIENDA_LONGITUDINE" NUMBER(11,6), 
	"ID_CAPO" NUMBER(19,0), 
	"COD_LIBRO" VARCHAR2(3 CHAR), 
	"CODICE" VARCHAR2(16 CHAR), 
	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"CODICE_VITELLO" VARCHAR2(16 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"DATA_NASCITA" DATE, 
	"DESCR_LIBRO" VARCHAR2(255 CHAR), 
	"DATA_FINE_DETENZIONE" DATE, 
	"DATA_INIZIO_DETENZIONE" DATE, 
	"DATA_NASCITA_VITELLO" DATE, 
	"FLAG_DELEGATO" VARCHAR2(10 CHAR), 
	"FLAG_DELEGATO_INGRESSO_VACCA" VARCHAR2(1 CHAR), 
	"FLAG_DELEGATO_INGRESSO_VITELLO" VARCHAR2(1 CHAR), 
	"FLAG_DELEGATO_NASCITA_VITELLO" VARCHAR2(1 CHAR), 
	"FLAG_IBR" VARCHAR2(1 CHAR), 
	"FLAG_PROROGA_MARCATURA" VARCHAR2(1 CHAR), 
	"FLAG_RISPETTO_PREVALENZA_IBR" VARCHAR2(10 CHAR), 
	"COD_RAZZA" VARCHAR2(3 CHAR), 
	"RUOLO_UTENTE_INGR_VACCA" VARCHAR2(3 CHAR), 
	"RUOLO_UTENTE_INGR_VITELLO" VARCHAR2(3 CHAR), 
	"RUOLO_UTENTE_NASC_VITELLO" VARCHAR2(3 CHAR), 
	"SESSO" VARCHAR2(1 CHAR), 
	"SESSO_VITELLO" VARCHAR2(1 CHAR), 
	"VACCA_DATA_COM_AUT_INGRESSO" DATE, 
	"VACCA_DATA_INGRESSO" DATE, 
	"VACCA_DATA_INSER_BDN_INGRESSO" DATE, 
	"VITELLO_CAPO_ID" NUMBER(19,0), 
	"VITELLO_DATA_APPL_MARCHIO" DATE, 
	"VITELLO_DATA_COM_AUT_INGRESSO" DATE, 
	"VITELLO_DATA_COM_AUT_NASCITA" DATE, 
	"VITELLO_DATA_INSER_BDN_NASCITA" DATE, 
	"VITELLO_TIPO_ORIGINE" VARCHAR2(1 CHAR), 
	"VITELLO_DATA_INS_BDN_INGRESSO" DATE, 
	"FK_DMT_D_CLS_PREM_VALID" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TWS_BDN_DU_CAPI_BOV
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TWS_BDN_DU_CAPI_BOV" ON "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" ("ID_AUTOGENERATO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TWS_BDN_DU_CAPI_BOV
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("ID_ALLEVAMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("ID_CAPO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" ADD CONSTRAINT "PK_DMT_T_TWS_BDN_DU_CAP_BOV" PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TWS_BDN_DU_CAPI_BOV
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" ADD CONSTRAINT "FK_DMT_T_SESSIONE_14" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_BOV" ADD CONSTRAINT "FK_DMT_D_CLS_PREM_VAL_RESP_02" FOREIGN KEY ("FK_DMT_D_CLS_PREM_VALID")
	  REFERENCES "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ("ID_AUTOGENERATO") ENABLE;
	
	
	--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_TWS_BDN_DU_CAPI_OVICA
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA";

--------------------------------------------------------
--  DDL for Table DMT_T_TWS_BDN_DU_CAPI_OVICA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"ID_ALLEVAMENTO" NUMBER(19,0), 
	"COD_AZIENDA" VARCHAR2(16 CHAR), 
	"ID_CAPO" NUMBER(19,0), 
	"CODICE" VARCHAR2(16 CHAR), 
	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"CONS_MEDIA" FLOAT(126), 
	"CUAA" VARCHAR2(16 CHAR), 
	"DATA_APPL_MARCHIO" DATE, 
	"DATA_COM_MACELLAZIONE" DATE, 
	"DATA_COM_NASCITA" DATE, 
	"DATA_FINE_DETENZIONE" DATE, 
	"DATA_INIZIO_DETENZIONE" DATE, 
	"DATA_INSERIMENTO_BDN_NASCITA" DATE, 
	"DATA_MACELLAZIONE" DATE, 
	"DATA_NASCITA" DATE, 
	"DATA_REGISTR_MACELL" DATE, 
	"DATA_ULTIMO_PREL_PROFILASSI" DATE, 
	"FLAG_DELEGATO_NASCITA" VARCHAR2(1 CHAR), 
	"GENOTIPO" VARCHAR2(50 CHAR), 
	"COD_RAZZA" VARCHAR2(3 CHAR), 
	"RUOLO_UTENTE_NASCITA" VARCHAR2(3 CHAR), 
	"SESSO" VARCHAR2(1 CHAR), 
	"FK_DMT_D_CLS_PREM_VALID" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TWS_BDN_DU_CAPI_OVICA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TWS_BDN_DU_CAPI_OVICA" ON "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" ("ID_AUTOGENERATO") 
 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TWS_BDN_DU_CAPI_OVICA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" MODIFY ("ID_ALLEVAMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" MODIFY ("ID_CAPO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" ADD CONSTRAINT "PK_DMT_T_TWS_BDN_DU_CAPI_OVICA" PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TWS_BDN_DU_CAPI_OVICA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" ADD CONSTRAINT "FK_DMT_D_CLS_PREM_VAL_RESP_03" FOREIGN KEY ("FK_DMT_D_CLS_PREM_VALID")
	  REFERENCES "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ("ID_AUTOGENERATO") ENABLE;
 
  ALTER TABLE "DEMETRA"."DMT_T_TWS_BDN_DU_CAPI_OVICA" ADD CONSTRAINT "FK_DMT_T_SESSIONE_15" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_ANAGRARFICA_ALLEV"; 

--------------------------------------------------------
--  DDL for Table DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"ALLEV_ID" NUMBER(19,2), 
	"AUTORIZZAZIONE_LATTE" VARCHAR2(1 CHAR), 
	"AZIENDA_CODICE" VARCHAR2(15 CHAR), 
	"CAP" VARCHAR2(5 CHAR), 
	"CAPI_TOTALI" NUMBER(19,2), 
	"COD_FISCALE_PROP" VARCHAR2(16 CHAR), 
	"COD_FISCALE_DETEN" VARCHAR2(16 CHAR), 
	"COMUNE" VARCHAR2(50 CHAR), 
	"DATA_CALCOLO_CAPI" DATE, 
	"DENOM_DETENTORE" VARCHAR2(100 CHAR), 
	"DENOM_PROPRIETARIO" VARCHAR2(100 CHAR), 
	"DENOMINAZIONE" VARCHAR2(100 CHAR), 
	"DT_FINE_ATTIVITA" DATE, 
	"DT_FINE_DETENTORE" DATE, 
	"DT_INIZIO_ATTIVITA" DATE, 
	"DT_INIZIO_DETENTORE" DATE, 
	"FOGLIO_CATASTALE" VARCHAR2(255 CHAR), 
	"INDIRIZZO" VARCHAR2(100 CHAR), 
	"LATITUDINE" NUMBER(11,6), 
	"LOCALITA" VARCHAR2(50 CHAR), 
	"LONGITUDINE" NUMBER(11,6), 
	"ORIENTAMENTO_PRODUTTIVO" VARCHAR2(50 CHAR), 
	"PARTICELLA" VARCHAR2(255 CHAR), 
	"SEZIONE" VARCHAR2(255 CHAR), 
	"SOCCIDA" VARCHAR2(255 CHAR), 
	"SPE_CODICE" VARCHAR2(15 CHAR), 
	"SUBALTERNO" VARCHAR2(255 CHAR), 
	"TIPO_ALLEV_COD" VARCHAR2(5 CHAR), 
	"TIPO_ALLEV_DESCR" VARCHAR2(25 CHAR), 
	"TIPO_PRODUZIONE" VARCHAR2(5 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) 
  
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_ANAGRAFICA_ALLEV" ON "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" ("ID_AUTOGENERATO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" ADD CONSTRAINT PK_DMT_T_ANAGRAFICA_ALLEV PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" ADD CONSTRAINT "FK_DMT_T_SESSIONE_12" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
	
	
	--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI";

--------------------------------------------------------
--  DDL for Table DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"ALLEV_ID" NUMBER(19,0), 
	"COD_AZIENDA" VARCHAR2(16 CHAR), 
	"CAPO_COD_MADRE" VARCHAR2(25 CHAR), 
	"ID_CAPO" NUMBER(19,0), 
	"COD_LIBRO" VARCHAR2(25 CHAR), 
	"CODICE" VARCHAR2(15 CHAR), 
	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"DESC_LIBRO_MADRE" VARCHAR2(50 CHAR), 
	"DATA_FINE_DETENZ" DATE, 
	"DATA_INIZIO_DETENZ" DATE, 
	"DATA_MACELLAZIONE" DATE, 
	"DATA_NASCITA" DATE, 
	"COD_RAZZA" VARCHAR2(3 CHAR) DEFAULT 'TRB', 
	"SESSO" VARCHAR2(1 CHAR), 
	"FK_DMT_D_CLS_PREM_VALID" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TBDN_DU_CAPI" ON "DEMETRA"."DMT_T_TBDN_DU_CAPI" ("ID_AUTOGENERATO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("ALLEV_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("ID_CAPO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("CODICE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("COD_RAZZA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" ADD CONSTRAINT PK_DMT_T_TBDN_DU_CAPI PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" ADD CONSTRAINT "FK_DMT_D_CLS_PREM_VAL_RESP" FOREIGN KEY ("FK_DMT_D_CLS_PREM_VALID")
	  REFERENCES "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ("FK_dmt_d_clsPrem_Valid") ENABLE;
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_13" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_SUBENTRO_ZOO
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO";
  
--------------------------------------------------------
--  DDL for Table DMT_T_SUBENTRO_ZOO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" 
   (	"ID_SUBENTRO_ZOO" NUMBER(19,0), 
	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CUAA_DOMANDA" VARCHAR2(16 CHAR), 
	"CUAA_SUBENTRO" VARCHAR2(16 CHAR), 
	"DATA_FINE" DATE, 
	"DATA_INIZIO" DATE, 
	"EXT_ID_UTENTE_AGGIORNAMENTO" NUMBER(19,0), 
	"NOTE" VARCHAR2(255 CHAR)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_SUBENTRO_ZOO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_SUBENTRO_ZOO" ON "DEMETRA"."DMT_T_SUBENTRO_ZOO" ("ID_SUBENTRO_ZOO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_SUBENTRO_ZOO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" MODIFY ("ID_SUBENTRO_ZOO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" MODIFY ("CUAA_DOMANDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" MODIFY ("CUAA_SUBENTRO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" ADD CONSTRAINT "PK_DMT_T_SUBENTRO_ZOO" PRIMARY KEY ("ID_SUBENTRO_ZOO");
  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_OUTPUT_REF03
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_OUTPUT_REF03"; 
  
--------------------------------------------------------
--  DDL for Table DMT_T_OUTPUT_REF03
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CUAA" VARCHAR2(16 CHAR), 
	"INTERVENTO" VARCHAR2(3 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"CAPI_ACCERTATI" NUMBER(10,0), 
	"CAPI_ANOMALI" NUMBER(10,0), 
	"CAPI_PAGABILI" NUMBER(15,5), 
	"CAPI_RICHIESTI" NUMBER(10,0), 
	"DIFF_RICHIESTI_ACCERTATI" NUMBER(10,0), 
	"ESITO" NUMBER(10,2), 
	"IMPORTO_PAGATO" NUMBER(10,2), 
	"PERCENTUALE_RIDUZIONE" NUMBER(10,2)
   ) 
 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_OUTPUT_REF03
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_OUTPUT_REF03" ON "DEMETRA"."DMT_T_OUTPUT_REF03" ("ANNO_CAMPAGNA", "CUAA", "INTERVENTO", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_OUTPUT_REF03
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" MODIFY ("INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" ADD CONSTRAINT "PK_DMT_T_OUTPUT_REF03" PRIMARY KEY ("ANNO_CAMPAGNA", "CUAA", "INTERVENTO", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_OUTPUT_REF03
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" ADD CONSTRAINT "FK_DMT_T_SESSIONE_35" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI";
  
--------------------------------------------------------
--  DDL for Table DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CUAA" VARCHAR2(16 CHAR), 
	"INTERVENTO" VARCHAR2(3 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"CAPI_AMMISSIBILI" NUMBER(*,2), 
	"CAPI_RICHIESTI" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_OUTPUT_CONTROLLI" ON "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" ("ANNO_CAMPAGNA", "CUAA", "INTERVENTO", "ID_SESSIONE") 
  
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" MODIFY ("INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" ADD CONSTRAINT "PK_DMT_T_OUTPUT_CONTROLLI" PRIMARY KEY ("ANNO_CAMPAGNA", "CUAA", "INTERVENTO", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_10" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_CONTROLLO_UBA_MINIME
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME";

--------------------------------------------------------
--  DDL for Table DMT_T_CONTROLLO_UBA_MINIME
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"ANNO_CAMPAGNA" NUMBER(4,0), 
	"CODICE_INTERVENTO" VARCHAR2(3 CHAR), 
	"ESITO" VARCHAR2(5 CHAR), 
	"MOTIVAZIONI" VARCHAR2(255 CHAR), 
	"UBA" NUMBER(10,2)
   ) SEGMENT CREATION DEFERRED 
  
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CONTROLLO_UBA_MINIME
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CONTROLLO_UBA_MINIME" ON "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME" ("CUAA", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CONTROLLO_UBA_MINIME
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME" MODIFY ("CODICE_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME" ADD CONSTRAINT "PK_DMT_T_CONTROLLO_UBA_MINIME" PRIMARY KEY ("CUAA", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CONTROLLO_UBA_MINIME
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONTROLLO_UBA_MINIME" ADD CONSTRAINT "FK_DMT_T_SESSIONE_09" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  Drop Table DMT_T_CONTR_LOCO
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_CONTR_LOCO";

--------------------------------------------------------
--  DDL for Table DMT_T_CONTR_LOCO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CONTR_LOCO" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"MARCHIO" VARCHAR2(14 CHAR), 
	"ANNO" NUMBER(10,0), 
	"ANOMALIE_ZOO" NUMBER(10,0), 
	"ANOMALIE_CGO" VARCHAR2(10 CHAR), 
	"COD_ASL" VARCHAR2(16 CHAR), 
	"COD_CAI" VARCHAR2(16 CHAR), 
	"COD_UTE" VARCHAR2(5 CHAR), 
	"CUAA_NORMALIZZATO" VARCHAR2(20 CHAR), 
	"DESCRIZIONE_ANOMALIA" VARCHAR2(400 CHAR), 
	"DATA_NASCITA" DATE, 
	"NOTE" VARCHAR2(400 CHAR), 
	"PROVINCIA" VARCHAR2(25 CHAR), 
	"PROVINCIA_ISTAT" NUMBER(10,0), 
	"REGIONE" VARCHAR2(25 CHAR), 
	"REGIONE_ISTAT" NUMBER(19,0), 
	"SESSO" VARCHAR2(1 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CONTR_LOCO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CONTR_LOCO" ON "DEMETRA"."DMT_T_CONTR_LOCO" ("CUAA", "MARCHIO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CONTR_LOCO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONTR_LOCO" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTR_LOCO" MODIFY ("MARCHIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTR_LOCO" ADD CONSTRAINT "PK_DMT_T_CONTR_LOCO" PRIMARY KEY ("CUAA", "MARCHIO");

  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CERTIF_IGP_DOP
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_CERTIF_IGP_DOP";

--------------------------------------------------------
--  DDL for Table DMT_T_CERTIF_IGP_DOP
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CERTIF_IGP_DOP" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"FLAG_DOP" VARCHAR2(1 CHAR), 
	"FLAG_IGP" VARCHAR2(1 CHAR), 
	"ALPEGGIO" VARCHAR2(1 CHAR), 
	"ZONA" VARCHAR2(1 CHAR)
   ) SEGMENT CREATION DEFERRED 
   
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CERTIF_IGP_DOP
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CERTIF_IGP_DOP" ON "DEMETRA"."DMT_T_CERTIF_IGP_DOP" ("CUAA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CERTIF_IGP_DOP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CERTIF_IGP_DOP" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CERTIF_IGP_DOP" ADD CONSTRAINT "PK_DMT_T_CERTIF_IGP_DOP" PRIMARY KEY ("CUAA");

  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_PREMIO_CAPI
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_PREMIO_CAPI";

--------------------------------------------------------
--  DDL for Table DMT_T_PREMIO_CAPI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" 
   (	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"ID_ALLEVAMENTO" NUMBER(19,0), 
	"ID_CAPO" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"COD_AZIENDA" VARCHAR2(15 CHAR), 
	"CODICE_VITELLO" VARCHAR2(20 CHAR), 
	"FLAG_AMISSIBILE" VARCHAR2(1 CHAR), 
	"MSG" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_PREMIO_CAPI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_PREMIO_CAPI" ON "DEMETRA"."DMT_T_PREMIO_CAPI" ("CODICE_PREMIO", "CUAA", "ID_ALLEVAMENTO", "ID_CAPO", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_PREMIO_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("ID_ALLEVAMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("ID_CAPO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("COD_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("FLAG_AMISSIBILE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" ADD CONSTRAINT "PK_DMT_T_PREMIO_CAPI" PRIMARY KEY ("CODICE_PREMIO", "CUAA", "ID_ALLEVAMENTO", "ID_CAPO", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_PREMIO_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_07" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI";

--------------------------------------------------------
--  DDL for Table DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" 
   (	"CALCOLO" VARCHAR2(20 CHAR), 
	"CAPO_ID" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"MOTIVAZIONE_ESCLUSIONE" VARCHAR2(400 CHAR)
   ) SEGMENT CREATION DEFERRED 
  
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_OUTPUT_ESCLUSI" ON "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" ("CALCOLO", "CAPO_ID", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" MODIFY ("CALCOLO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" MODIFY ("CAPO_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" ADD CONSTRAINT "PK_DMT_T_OUTPUT_ESCLUSI" PRIMARY KEY ("CALCOLO", "CAPO_ID", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_06" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - lunedì-giugno-01-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP TABLE DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO";

--------------------------------------------------------
--  DDL for Table DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"ALLEV_ID" NUMBER(19,0), 
	"AZIENDA_CODICE" VARCHAR2(12 CHAR), 
	"AZIENDA_LATITUDINE" NUMBER(11,6), 
	"AZIENDA_LONGITUDINE" NUMBER(11,6), 
	"CAPO_ID" NUMBER(19,0), 
	"COD_LIBRO" VARCHAR2(5 CHAR), 
	"CODICE" VARCHAR2(20 CHAR), 
	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"DESCR_LIBRO" VARCHAR2(255 CHAR), 
	"DT_COM_AUTORITA_INGRESSO" DATE, 
	"DT_COM_AUTORITA_USCITA" DATE, 
	"DT_FINE_DETENZIONE" DATE, 
	"DT_INGRESSO" DATE, 
	"DT_INIZIO_DETENZIONE" DATE, 
	"DT_INSERIMENTO_BDN_INGRESSO" DATE, 
	"DT_INSERIMENTO_BDN_USCITA" DATE, 
	"DT_MACELLAZIONE" DATE, 
	"DT_NASCITA" DATE, 
	"DT_USCITA" DATE, 
	"FLAG_DELEGATO_INGRESSO" VARCHAR2(10 CHAR), 
	"FLAG_DELEGATO_USCITA" VARCHAR2(10 CHAR), 
	"RAZZA_CODICE" VARCHAR2(5 CHAR), 
	"RUOLO_UTENTE_INGRESSO" VARCHAR2(10 CHAR), 
	"RUOLO_UTENTE_USCITA" VARCHAR2(10 CHAR), 
	"SESSO" VARCHAR2(1 CHAR), 
	"FK_DMT_D_CLS_PREM_VALID" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CLS_CAPO_MACELLATO" ON "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" ("ID_AUTOGENERATO") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("ALLEV_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("CAPO_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" ADD CONSTRAINT "PK_DMT_T_CLS_CAPO_MACELLATO" PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" ADD CONSTRAINT "FK_DMT_T_SESSIONE_04" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" ADD CONSTRAINT "FK_DMT_D_CLS_PREMIO_VAL_RESP_01" FOREIGN KEY ("FK_DMT_D_CLS_PREM_VALID")
	  REFERENCES "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ("ID_AUTOGENERATO") ENABLE;

	  
	  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table RPU_V_PRATICA_ZOOTE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."RPU_V_PRATICA_ZOOTE" 
   (	"ANNO_CAMPAGNA" NUMBER(4,0), 
	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"CODICE_MISURA" VARCHAR2(3 CHAR), 
	"DENOMINAZIONE" VARCHAR2(50 CHAR), 
	"DESCRIZIONE" VARCHAR2(255 CHAR), 
	"EXT_ID_AZIENDA" NUMBER(10,0), 
	"ID_FASE_AVANZAMENTO" NUMBER(10,0), 
	"ID_PRATICA" NUMBER(10,0), 
	"ID_STATO_PRATICA" NUMBER(10,0), 
	"IDENTIFICATIVO" NUMBER(19,0), 
	"TIPO_FASE" NUMBER(10,0)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_RPU_V_PRATICA_ZOOTE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_RPU_V_PRATICA_ZOOTE" ON "DEMETRA"."RPU_V_PRATICA_ZOOTE" ("ANNO_CAMPAGNA", "CODICE_PREMIO", "CUAA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table RPU_V_PRATICA_ZOOTE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."RPU_V_PRATICA_ZOOTE" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."RPU_V_PRATICA_ZOOTE" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."RPU_V_PRATICA_ZOOTE" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."RPU_V_PRATICA_ZOOTE" MODIFY ("CODICE_MISURA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."RPU_V_PRATICA_ZOOTE" ADD CONSTRAINT "PK_RPU_V_PRATICA_ZOOTE" PRIMARY KEY ("ANNO_CAMPAGNA", "CODICE_PREMIO", "CUAA");

  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_SISTEMI_ETICHETTATURA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_SISTEMI_ETICHETTATURA" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"FLAG_ETICHETTATURA" VARCHAR2(1 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_SISTEMI_ETICHETTATURA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_SISTEMI_ETICHETTATURA" ON "DEMETRA"."DMT_T_SISTEMI_ETICHETTATURA" ("CUAA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_SISTEMI_ETICHETTATURA
--------------------------------------------------------
 
  ALTER TABLE "DEMETRA"."DMT_T_SISTEMI_ETICHETTATURA" ADD CONSTRAINT "PK_DMT_T_SISTEMI_ETICHETTATURA" PRIMARY KEY ("CUAA");

  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_LATTE_VENDITA_DIRETTA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_LATTE_VENDITA_DIRETTA" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CUUA" VARCHAR2(16 CHAR), 
	"MESE" VARCHAR2(10 CHAR), 
	"MATRICOLA" VARCHAR2(25 CHAR), 
	"QUANTITA" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_LATTE_VENDITA_DIRETTA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_LATTE_VENDITA_DIRETTA" ON "DEMETRA"."DMT_T_LATTE_VENDITA_DIRETTA" ("ANNO_CAMPAGNA", "CUUA", "MESE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_LATTE_VENDITA_DIRETTA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_LATTE_VENDITA_DIRETTA" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_LATTE_VENDITA_DIRETTA" MODIFY ("CUUA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_LATTE_VENDITA_DIRETTA" MODIFY ("MESE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_LATTE_VENDITA_DIRETTA" ADD CONSTRAINT "PK_DMT_T_LATTE_VENDITA_DIRETTA" PRIMARY KEY ("ANNO_CAMPAGNA", "CUUA", "MESE");

  
  --------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"IMPORTO_UNITARIO" NUMBER(*,0), 
	"INTERVENTO" VARCHAR2(3 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_IMPORTO_UNITARIO" ON "DEMETRA"."DMT_T_IMPORTO_UNITARIO" ("ANNO_CAMPAGNA", "IMPORTO_UNITARIO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" MODIFY ("IMPORTO_UNITARIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" ADD CONSTRAINT "PK_DMT_T_IMPORTO_UNITARIO" PRIMARY KEY ("ANNO_CAMPAGNA", "IMPORTO_UNITARIO");
  
  
  
  ALTER TABLE "DEMETRA"."DMT_T_INFO_ALLEVAMENTI"  MODIFY "ALLEV_ID" NUMBER(19,0) NOT NULL;

  
  
    ALTER TABLE "DEMETRA"."DMT_W_CONTROLLO_BEAN"  MODIFY "CODICE" VARCHAR2(3 CHAR) NOT NULL ENABLE;
    ALTER TABLE "DEMETRA"."DMT_W_CONTROLLO_BEAN"  MODIFY "BEAN" VARCHAR2(20 CHAR) NOT NULL ENABLE;