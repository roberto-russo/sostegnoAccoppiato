-- CREAZIONE DELLA TABELLA CALCOLI INTERVENTI
CREATE TABLE Dmt_w_calcoli_interventi(
id_gestore INT NOT NULL,
id_intervento INT NOT NULL,
ordine_esecuzione VARCHAR(10),
CONSTRAINT calcoli_interventi_PK PRIMARY KEY (id_gestore, id_intervento),
CONSTRAINT calcoli_interventi_id_gestore_FK FOREIGN KEY (id_gestore) REFERENCES dec_tipologia_gestore(ID),
CONSTRAINT calcoli_interventi_id_intervento_FK FOREIGN KEY (id_intervento) REFERENCES Intervento(ID)
);