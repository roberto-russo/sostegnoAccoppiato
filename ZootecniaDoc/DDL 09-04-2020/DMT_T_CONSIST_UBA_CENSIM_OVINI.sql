--------------------------------------------------------
--  File creato - gioved�-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"P_CUAA" VARCHAR2(16 CHAR), 
	"DATA_FINE_PERIODO" VARCHAR2(400 CHAR), 
	"DATA_INIZIO_PERIODO" VARCHAR2(400 CHAR), 
	"P_TIPO_RESPONSABILITA" VARCHAR2(400 CHAR), 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012739
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012739" ON "ZOOTECNIA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ("ID_SESSIONE", "P_CUAA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" MODIFY ("P_CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ADD PRIMARY KEY ("ID_SESSIONE", "P_CUAA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ADD CONSTRAINT "FKSJATIDR9QVBP5HR76SX7JRMUV" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
