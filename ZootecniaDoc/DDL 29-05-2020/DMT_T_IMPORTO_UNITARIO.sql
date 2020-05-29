--------------------------------------------------------
--  File creato - venerdì-maggio-29-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"IMPORTO_UNITARIO" FLOAT(126), 
	"INTERVENTO" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "DEMETRA_TBL" ;
REM INSERTING into DEMETRA.DMT_T_IMPORTO_UNITARIO
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_IMPORTO_UNITARIO" ON "DEMETRA"."DMT_T_IMPORTO_UNITARIO" ("ANNO_CAMPAGNA", "IMPORTO_UNITARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_IMPORTO_UNITARIO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" MODIFY ("INTERVENTO"    NOT NULL ENABLE);
  ALTER TABLE "DEMETRA"."DMT_T_IMPORTO_UNITARIO" ADD PRIMARY KEY ("ANNO_CAMPAGNA", "INTERVENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "DEMETRA_TBL"  ENABLE;
