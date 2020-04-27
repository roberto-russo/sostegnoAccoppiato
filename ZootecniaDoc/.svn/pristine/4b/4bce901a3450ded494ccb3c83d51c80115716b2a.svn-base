-- CREAZIONE DELLA TABELLA controlli_preammissibilita
CREATE TABLE Dmt_w_controlli_preammissibilita(
nome_classe_calcolo VARCHAR(30) NOT NULL,
id_intervento INT NOT NULL,
ordine_esecuzione VARCHAR(10),
CONSTRAINT controlli_preammissibilita_PK PRIMARY KEY (nome_classe_calcolo, id_intervento),
CONSTRAINT id_intervento_FK FOREIGN KEY (id_intervento) REFERENCES Intervento(ID)
);