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
