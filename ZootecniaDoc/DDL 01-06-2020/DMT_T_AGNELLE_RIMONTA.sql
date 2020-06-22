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
