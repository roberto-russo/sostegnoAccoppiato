-- CREAZIONE DELLA TABELLA ESITO_CONTROLLI_PREAMMISSIBILITA
CREATE TABLE Dmt_d_esito_controlli_preammissibilita(
ID INT NOT NULL,
CUAA VARCHAR(16) NOT NULL,
DATA DATE,
ANNO NUMERIC NOT NULL,
id_gestore INT NOT NULL,
esito VARCHAR(1) CHECK (esito = 'S' OR esito = 'N'),
msg VARCHAR(400),
CONSTRAINT esito_controlli_preammissibilita_PK PRIMARY KEY (ID, CUAA, ANNO, id_gestore),
CONSTRAINT esito_controlli_preammissibilita_id_gestore_FK FOREIGN KEY (id_gestore) REFERENCES gestori(ID)
); 