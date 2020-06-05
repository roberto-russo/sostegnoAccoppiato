--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_TLATTE_MENSILE_ARPEA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" 
   (	"ANNO_RIFERIMENTO" NUMBER(19,0) UNIQUE, 
	"ANNO_SOLARE" NUMBER(19,0) UNIQUE, 
	"MATR_ACQUIRENTE" NUMBER(19,0) UNIQUE, 
	"MATR_AZIENDA" NUMBER(19,0) UNIQUE, 
	"SCO_MESE" VARCHAR2(3 CHAR) UNIQUE, 
	"SESSIONE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"COD_MESE" VARCHAR2(3 CHAR) DEFAULT 'MES', 
	"CUAA_ACQUIRENTE" VARCHAR2(16 CHAR), 
	"CUAA_AZIENDA" VARCHAR2(16 CHAR), 
	"DENOM_ACQUIRENTE" VARCHAR2(150 CHAR), 
	"DENOM_AZIENDA" VARCHAR2(255 CHAR), 
	"FLAG_SUBENTRO" VARCHAR2(1 CHAR), 
	"MESE" VARCHAR2(10 CHAR), 
	"PRIMO_ANNO_CAMPAGNA" NUMBER(19,0), 
	"QT_CONSEGNATA" NUMBER(19,0), 
	"TEN_MAT_GRASSA_PERIODO" NUMBER(*,2)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_01
--------------------------------------------------------

 -- CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_01" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("ANNO_RIFERIMENTO") 

  --TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_02
--------------------------------------------------------

 -- CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_02" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("ANNO_SOLARE") 

 -- TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_03
--------------------------------------------------------

 -- CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_03" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("MATR_ACQUIRENTE") 
  
 -- TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_04
--------------------------------------------------------

 -- CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_04" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("MATR_AZIENDA") 

 -- TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_05
--------------------------------------------------------

--  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_05" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("SCO_MESE") 

 -- TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TLATTE_MENSILE_ARPEA_06
--------------------------------------------------------

 -- CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TLAT_MENS_ARPEA_06" ON "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ("ANNO_RIFERIMENTO", "ANNO_SOLARE", "MATR_ACQUIRENTE", "MATR_AZIENDA", "SCO_MESE", "SESSIONE") 
 -- TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TLATTE_MENSILE_ARPEA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("ANNO_RIFERIMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("ANNO_SOLARE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("MATR_ACQUIRENTE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("MATR_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("SCO_MESE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ADD PRIMARY KEY ("ANNO_RIFERIMENTO", "ANNO_SOLARE", "MATR_ACQUIRENTE", "MATR_AZIENDA", "SCO_MESE", "SESSIONE");

--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TLATTE_MENSILE_ARPEA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TLATTE_MENSILE_ARPEA" ADD CONSTRAINT "FK_DMT_T_SESSIONE_28" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
