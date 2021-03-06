--------------------------------------------------------
--  File creato - mercoledý-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_W_TPREMIO_ZOO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" 
   (	"COD_ALLEVAMENTO" VARCHAR2(15 CHAR), 
	"COD_SPECIE" VARCHAR2(3 CHAR) DEFAULT 'TCA', 
	"ID_ALLEV_BDN" VARCHAR2(25 CHAR), 
	"ID_AZIENDA" NUMBER(19,0), 
	"SCO_SPECIE" VARCHAR2(3 CHAR),  
	"VERSIONE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"AGNELLE_RIMONTA" VARCHAR2(1 CHAR), 
	"BOVINI_MACELLATI" VARCHAR2(1 CHAR), 
	"BUFALE" VARCHAR2(1 CHAR), 
	"CAP" VARCHAR2(5 CHAR), 
	"COD_ASL" VARCHAR2(16 CHAR), 
	"COD_ISTAT_COM" VARCHAR2(3 CHAR), 
	"COD_ISTAT_PROV" VARCHAR2(3 CHAR), 
	"COD_TITOLARITA" VARCHAR2(3 CHAR) DEFAULT 'TCP', 
	"DATA_SCARICO" TIMESTAMP (6), 
	"DENOMINAZIONE" VARCHAR2(30 CHAR), 
	"FRAZIONE" VARCHAR2(40 CHAR), 
	"ID_FISCALE" VARCHAR2(16 CHAR), 
	"INDIRIZZO" VARCHAR2(100 CHAR), 
	"MACELLATI_12_MESI" VARCHAR2(1 CHAR), 
	"MACELLATI_ETICHETTATURA" VARCHAR2(1 CHAR), 
	"MACELLATI_IGP" VARCHAR2(1 CHAR), 
	"MACELLATI_QUALITA" VARCHAR2(1 CHAR), 
	"OVICAPRINI_MACELLATI" VARCHAR2(1 CHAR), 
	"SCO_TITOLARITA" VARCHAR2(3 CHAR), 
	"TELEFONO" VARCHAR2(20 CHAR), 
	"VACCHE_CARNE_IBR" VARCHAR2(1 CHAR), 
	"VACCHE_LATTE" VARCHAR2(1 CHAR), 
	"VACCHE_MONTAGNA" VARCHAR2(1 CHAR), 
	"VACCHE_NUTRICI" VARCHAR2(1 CHAR), 
	"VACCHE_NUTRICI_DA" VARCHAR2(1 CHAR), 
	"VACCHE_NUTRICI_NG" VARCHAR2(1 CHAR)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_W_TPREMIO_ZOO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_W_TPREMIO_ZOO" ON "DEMETRA"."DMT_W_TPREMIO_ZOO" ("COD_ALLEVAMENTO", "COD_SPECIE", "ID_ALLEV_BDN", "ID_AZIENDA", "SCO_SPECIE", "ID_SESSIONE", "VERSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_W_TPREMIO_ZOO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_ALLEVAMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("ID_ALLEV_BDN" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("ID_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("SCO_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("VERSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_ASL" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_ISTAT_COM" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("COD_TITOLARITA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("DATA_SCARICO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("DENOMINAZIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("INDIRIZZO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" MODIFY ("SCO_TITOLARITA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" ADD PRIMARY KEY ("COD_ALLEVAMENTO", "COD_SPECIE", "ID_ALLEV_BDN", "ID_AZIENDA", "SCO_SPECIE", "ID_SESSIONE", "VERSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_W_TPREMIO_ZOO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_TPREMIO_ZOO" ADD CONSTRAINT "FK_DMT_T_SESSIONE_33" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
