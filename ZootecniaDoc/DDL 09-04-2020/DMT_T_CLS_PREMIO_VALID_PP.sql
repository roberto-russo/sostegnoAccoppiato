--------------------------------------------------------
--  File creato - gioved�-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" 
   (	"ID_ALLE_BDN" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CODICE_INTERVENTO" VARCHAR2(400 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"CUAA2" VARCHAR2(16 CHAR), 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012730
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012730" ON "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" ("ID_ALLE_BDN", "ID_SESSIONE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ID_ALLE_BDN" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CODICE_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CUAA2" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" ADD PRIMARY KEY ("ID_ALLE_BDN", "ID_SESSIONE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_CLS_PREMIO_VALID_PP" ADD CONSTRAINT "FKD6JNXV9Q2W1SI3KCCNY3HEYQN" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
