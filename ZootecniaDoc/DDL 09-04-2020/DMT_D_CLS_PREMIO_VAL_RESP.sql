--------------------------------------------------------
--  File creato - gioved�-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" 
   (	"CODICE_ERRORE" VARCHAR2(400 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"NUMERO_CAPI" NUMBER(19,0), 
	"DESCRIZIONE_ERRORE" VARCHAR2(400 CHAR), 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012689
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012689" ON "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" ("CODICE_ERRORE", "ID_SESSIONE", "NUMERO_CAPI") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("CODICE_ERRORE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("NUMERO_CAPI" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" ADD PRIMARY KEY ("CODICE_ERRORE", "ID_SESSIONE", "NUMERO_CAPI")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_CLS_PREMIO_VAL_RESP
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" ADD CONSTRAINT "FK9HLK7HV2L0O8JF96A24CHBUVY" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
