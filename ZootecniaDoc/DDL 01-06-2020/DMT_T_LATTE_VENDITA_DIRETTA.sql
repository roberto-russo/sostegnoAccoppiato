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
   )

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
