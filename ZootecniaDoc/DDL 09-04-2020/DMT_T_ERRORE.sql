--------------------------------------------------------
--  File creato - giovedì-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_ERRORE
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_ERRORE" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"NOME_METODO" VARCHAR2(255 CHAR), 
	"INPUT" VARCHAR2(255 CHAR), 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012749
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012749" ON "ZOOTECNIA"."DMT_T_ERRORE" ("ID_SESSIONE", "NOME_METODO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_ERRORE
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_ERRORE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_ERRORE" MODIFY ("NOME_METODO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_ERRORE" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_ERRORE" ADD PRIMARY KEY ("ID_SESSIONE", "NOME_METODO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_ERRORE
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_ERRORE" ADD CONSTRAINT "FKE75SLXMEJ6T0O1M6NS8O5U4QS" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
