package be.vdab.bierhuis.valueobjects;

import javax.validation.Valid;

import be.vdab.constraints.StringForm;

public class WinkelwagenForm {
	@StringForm(message = "{error.stringForm.naam}")
	private String naam;
	@Valid
	private Adres adres;
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
}
