--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" 
   (	"ANNO_CAMPAGNA_INIZIO" NUMBER(10,0), 
	"IMPORTO_PREMIO" NUMBER(*,0), 
	"CODICE" VARCHAR2(3 CHAR)
   )

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_IMPORTO_UNITARIO" ON "DEMETRA"."DMT_T_IMPORTO_UNITARIO" ("ANNO_CAMPAGNA_INIZIO", "CODICE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" MODIFY ("ANNO_CAMPAGNA_INIZIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" MODIFY ("CODICE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" ADD CONSTRAINT "PK_DMT_T_IMPORTO_UNITARIO" PRIMARY KEY ("ANNO_CAMPAGNA_INIZIO", "CODICE");