-- CREAZIONE DELLA TABELLA COEFFICIENTI_UBA
CREATE TABLE Dmt_t_coefficienti_uba(
id_specie INT NOT NULL,
id_categoria INT NOT NULL,
descrizione VARCHAR(400),
CONSTRAINT coefficienti_uba_PK PRIMARY KEY (id_specie, id_categoria),
CONSTRAINT coefficienti_uba_id_specie_FK FOREIGN KEY (id_specie) REFERENCES dec_specie(ID),
CONSTRAINT coefficienti_uba_id_categoria_FK FOREIGN KEY (id_categoria) REFERENCES dec_categoria(ID)
);