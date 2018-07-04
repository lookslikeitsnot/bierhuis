package be.vdab.bierhuis.valueobjects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

import be.vdab.constraints.Naam;

public class WinkelwagenForm {
	@SafeHtml(whitelistType = WhiteListType.NONE)
	@NotNull
	@Naam
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
