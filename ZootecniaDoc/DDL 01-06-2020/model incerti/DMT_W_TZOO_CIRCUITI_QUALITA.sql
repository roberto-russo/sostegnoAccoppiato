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
