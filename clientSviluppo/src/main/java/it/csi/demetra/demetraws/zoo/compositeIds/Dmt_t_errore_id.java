package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_errore_id implements Serializable {

	private static final long serialVersionUID = -8891708525889181529L;

    private Long idSessione;
    private String nomeMetodo;
    private String input;

    public Dmt_t_errore_id() {
    }

    public Dmt_t_errore_id(Long idSessione, String nomeMetodo, String input) {
        this.idSessione = idSessione;
        this.nomeMetodo = nomeMetodo;
        this.input = input;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Long idSessione) {
        this.idSessione = idSessione;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
        result = prime * result + ((input == null) ? 0 : input.hashCode());
        result = prime * result + ((nomeMetodo == null) ? 0 : nomeMetodo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dmt_t_errore_id other = (Dmt_t_errore_id) obj;
        if (idSessione != other.idSessione)
            return false;
        if (input == null) {
            if (other.input != null)
                return false;
        } else if (!input.equals(other.input))
            return false;
        if (nomeMetodo == null) {
            if (other.nomeMetodo != null)
                return false;
        } else if (!nomeMetodo.equals(other.nomeMetodo))
            return false;
        return true;
    }
}
