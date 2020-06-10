--------------------------------------------------------
--  File creato - mercoledì -giugno 10-05-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_PERC_GG_RITARDO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_PERC_GG_RITARDO" 
   (
    "ANNO" NUMBER(19,0), 
	"GIORNI_RITARDO" NUMBER(19,0), 
	"PERC_DECURTAZIONE" DECIMAL(5,2)
   ) SEGMENT CREATION IMMEDIATE 
  TABLESPACE "DEMETRA_TBL" ;
  
--------------------------------------------------------
--  DDL for Index IE_DMT_T_PERC_GG_RITARDO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_PERC_GG_RITARDO" ON "DEMETRA"."DMT_T_PERC_GG_RITARDO" ("ANNO","GIORNI_RITARDO") 
  TABLESPACE "DEMETRA_IDX" ;
  
--------------------------------------------------------
--  Constraints for Table DMT_T_PERC_GG_RITARDO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_PERC_GG_RITARDO" MODIFY ("ANNO" NOT NULL ENABLE);
  ALTER TABLE "DEMETRA"."DMT_T_PERC_GG_RITARDO" MODIFY ("GIORNI_RITARDO" NOT NULL ENABLE);
  ALTER TABLE "DEMETRA"."DMT_T_PERC_GG_RITARDO"  ADD CHECK("PERC_DECURTAZIONE" <= 100.00);
  ALTER TABLE "DEMETRA"."DMT_T_PERC_GG_RITARDO" ADD CONSTRAINT "PK_DMT_T_PERC_GG_RITARDO" PRIMARY KEY ("ANNO", "GIORNI_RITARDO");
