package it.csi.demetra.demetraws.zoo.calcoli.entity;
/**
 * Questa classe serve a gestire il singolo 
 * capo all'interno della lista dei
 * capi da controllare
 * 
 * */
public class Capo <T>{
	
	/**
	 * Capo da esaminare
	 */
	private T capo;

	/**
	 * Flag capo ammesso
	 */
	private String flagCapoAmmesso = "";
	
	/**
	 * Motivazione
	 */
	private String motivazione = "";
	
	public T getCapo() {
		return capo;
	}

	public void setCapo(T capo) {
		this.capo = capo;
	}
	
	public String getFlagCapoAmmesso() {
		return flagCapoAmmesso;
	}

	public void setFlagCapoAmmesso(String flagCapoAmmesso) {
		this.flagCapoAmmesso = flagCapoAmmesso;
	}

	public String getMotivazione() {
		return motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}
}
