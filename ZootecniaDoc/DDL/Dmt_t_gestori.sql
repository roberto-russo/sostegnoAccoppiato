-- CREAZIONE DELLA TABELLA gestori
CREATE TABLE Dmt_t_gestori(
ID INT NOT NULL,
id_Tipologia INT NOT NULL,
nome_service VARCHAR(30),
CONSTRAINT gestori_PK PRIMARY KEY (ID, id_Tipologia),
CONSTRAINT gestori_id_Tipologia_FK FOREIGN KEY (id_Tipologia) REFERENCES dec_tipologia_gestore(ID)
);