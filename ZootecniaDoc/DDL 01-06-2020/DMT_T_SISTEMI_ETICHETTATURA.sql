--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_SISTEMI_ETICHETTATURA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_SISTEMI_ETICHETTATURA" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"FLAG_ETICHETTATURA" VARCHAR2(1 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_SISTEMI_ETICHETTATURA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_SIST_ETICHET" ON "DEMETRA"."DMT_T_SISTEMI_ETICHETTATURA" ("CUAA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_SISTEMI_ETICHETTATURA
--------------------------------------------------------
 
  ALTER TABLE "DEMETRA"."DMT_T_SISTEMI_ETICHETTATURA" ADD CONSTRAINT "PK_DMT_T_SIST_ETICHET" PRIMARY KEY ("CUAA");
