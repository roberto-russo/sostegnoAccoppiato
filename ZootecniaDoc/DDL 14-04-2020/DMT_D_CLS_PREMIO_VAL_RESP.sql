--------------------------------------------------------
--  File creato - martedì-aprile-14-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" 
   (	"CODICE_ERRORE" VARCHAR2(400 CHAR), 
	"NUMERO_CAPI" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"DESCRIZIONE_ERRORE" VARCHAR2(400 CHAR)
   )
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_D_CLS_PREMIO_VAL_RESP_01
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_D_CLS_PR_VAL_RESP_01" ON "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ("CODICE_ERRORE", "NUMERO_CAPI", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("CODICE_ERRORE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("NUMERO_CAPI" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ADD CONSTRAINT "PK_DMT_D_CLS_PREMIO_VAL_RESP" PRIMARY KEY ("CODICE_ERRORE", "NUMERO_CAPI", "ID_SESSIONE")
;
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ADD CONSTRAINT "FK_DMT_T_SESSIONE_01" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
