-- CREAZIONE DELLA TABELLA INTERVENTO
CREATE TABLE Dmt_t_Intervento(
 ID INT NOT NULL,
 Intervento VARCHAR(3),
 Misura NUMERIC,
 id_Specie INT NOT NULL,
 id_Categoria INT NOT NULL,
 CONSTRAINT Intervento_PK PRIMARY KEY(ID, id_Specie, id_Categoria),
 CONSTRAINT intervento_id_Specie_FK FOREIGN KEY (id_Specie) REFERENCES dec_specie(ID) ON DELETE CASCADE,
 CONSTRAINT intervento_id_Categoria_FK FOREIGN KEY(id_Categoria) REFERENCES dec_categoria(ID) ON DELETE CASCADE
);

