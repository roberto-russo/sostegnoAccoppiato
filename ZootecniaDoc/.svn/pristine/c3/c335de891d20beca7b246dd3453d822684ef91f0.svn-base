--------------------------------------------------------
--  File creato - giovedì-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_DEC_TIPOLOGIA_GESTORE" 
   (	"ID" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(400 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012745
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012745" ON "ZOOTECNIA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_DEC_TIPOLOGIA_GESTORE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_DEC_TIPOLOGIA_GESTORE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ADD CONSTRAINT "FKLMUBANSXLIE6DPC9OJL36XD4T" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
