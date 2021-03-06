--------------------------------------------------------
--  File creato - gioved�-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" 
   (	"ANNO" FLOAT(126), 
	"CUAA" VARCHAR2(16 CHAR), 
	"ID" NUMBER(19,0), 
	"ID_GESTORE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"DATA" DATE, 
	"ESITO" VARCHAR2(1 CHAR), 
	"MSG" VARCHAR2(400 CHAR), 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012696
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012696" ON "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" ("ANNO", "CUAA", "ID", "ID_GESTORE", "ID_SESSIONE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ANNO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID_GESTORE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" ADD PRIMARY KEY ("ANNO", "CUAA", "ID", "ID_GESTORE", "ID_SESSIONE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_D_ESITO_CONTR_PREAMM" ADD CONSTRAINT "FKTADBCOBMLBRHIH6U61TC5CKMF" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
