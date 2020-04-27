--------------------------------------------------------
--  File creato - martedì-aprile-14-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_RPU_V_PRATICA_ZOOTE
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_RPU_V_PRATICA_ZOOTE" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CODICE_PREMIO" VARCHAR2(255 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"CODICE_MISURA" VARCHAR2(255 CHAR), 
	"DENOMINAZIONE" VARCHAR2(50 CHAR), 
	"DESCRIZIONE" VARCHAR2(400 CHAR), 
	"EXT_ID_AZIENDA" NUMBER(10,0), 
	"ID_FASE_AVANZAMENTO" NUMBER(10,0), 
	"ID_PRATICA" NUMBER(10,0), 
	"ID_STATO_PRATICA" NUMBER(10,0), 
	"IDENTIFICATIVO" NUMBER(19,0), 
	"TIPO_FASE" NUMBER(10,0)
   ) 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_RPU_V_PRATICA_ZOOTE_05
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."IE_DMT_T_RPU_V_PRATICA_ZOOTE_05" ON "ZOOTECNIA"."DMT_T_RPU_V_PRATICA_ZOOTE" ("ANNO_CAMPAGNA", "CODICE_PREMIO", "CUAA") 
  
  TABLESPACE "DEMETRA_IDX " ;
--------------------------------------------------------
--  Constraints for Table DMT_T_RPU_V_PRATICA_ZOOTE
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_RPU_V_PRATICA_ZOOTE" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_RPU_V_PRATICA_ZOOTE" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_RPU_V_PRATICA_ZOOTE" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_RPU_V_PRATICA_ZOOTE" MODIFY ("CODICE_MISURA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_RPU_V_PRATICA_ZOOTE" ADD CONSTRAINT "PK_DMT_T_RPU_V_PRATICA_ZOOTE" PRIMARY KEY ("ANNO_CAMPAGNA", "CODICE_PREMIO", "CUAA")
