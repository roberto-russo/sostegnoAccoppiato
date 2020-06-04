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