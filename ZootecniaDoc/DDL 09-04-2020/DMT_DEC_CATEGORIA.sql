--------------------------------------------------------
--  File creato - gioved�-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_DEC_CATEGORIA" 
   (	"ID" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(400 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012711
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012711" ON "ZOOTECNIA"."DMT_DEC_CATEGORIA" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_DEC_CATEGORIA" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_DEC_CATEGORIA" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_DEC_CATEGORIA" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_DEC_CATEGORIA" ADD CONSTRAINT "FK3NAONFT197QTYH650MC6V06T6" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
