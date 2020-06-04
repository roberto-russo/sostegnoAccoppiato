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
