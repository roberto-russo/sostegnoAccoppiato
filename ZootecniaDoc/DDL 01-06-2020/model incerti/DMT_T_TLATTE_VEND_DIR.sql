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
   ) 

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
