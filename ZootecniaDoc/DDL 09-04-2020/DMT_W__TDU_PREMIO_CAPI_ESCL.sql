--------------------------------------------------------
--  File creato - gioved�-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_W__TDU_PREMIO_CAPI_ESCL
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" 
   (	"ANNO_RIFERIMENTO" NUMBER(19,0), 
	"COD_INTERVENTO" VARCHAR2(3 CHAR), 
	"CODICE_CAPO" VARCHAR2(16 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"CUAA" VARCHAR2(16 CHAR), 
	"NOTE" VARCHAR2(500 CHAR), 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012806
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012806" ON "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" ("ANNO_RIFERIMENTO", "COD_INTERVENTO", "CODICE_CAPO", "ID_SESSIONE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_W__TDU_PREMIO_CAPI_ESCL
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" MODIFY ("ANNO_RIFERIMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" MODIFY ("COD_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" MODIFY ("CODICE_CAPO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" ADD PRIMARY KEY ("ANNO_RIFERIMENTO", "COD_INTERVENTO", "CODICE_CAPO", "ID_SESSIONE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_W__TDU_PREMIO_CAPI_ESCL
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_W__TDU_PREMIO_CAPI_ESCL" ADD CONSTRAINT "FKMBBVJHGFEFIGAQ2L4FCXWGIXT" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
