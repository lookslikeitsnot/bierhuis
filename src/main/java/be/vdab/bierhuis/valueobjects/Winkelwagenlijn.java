package be.vdab.bierhuis.valueobjects;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PathVariable;

import be.vdab.bierhuis.entities.Bier;

public class Winkelwagenlijn {
	@NotNull
	@Valid
	private Bier bier;
	@NotNull
	@Min(value=1)
	private Integer aantal;

	public Bier getBier() {
		return bier;
	}

	public Integer getAantal() {
		return aantal;
	}

	public BigDecimal getPrijs() {
		return bier.getPrijs();
	}

	public BigDecimal getTeBetalen() {
		return bier.getPrijs().multiply(BigDecimal.valueOf(aantal));
	}

	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}
	
	public void addAantal(Integer aantal) {
		this.aantal += aantal;
	}
	
	public void setBier(@PathVariable Bier bier) {
		this.bier = bier;
	}

	@Override
	public String toString() {
		return "Winkelwagenlijn [bier=" + bier.getNaam() + ", aantal=" + aantal + "]";
	}
	
	public Bestelbonlijn toBestelbonlijn() {
		return new Bestelbonlijn(bier, aantal, bier.getPrijs());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bier == null) ? 0 : bier.hashCode());
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
		Winkelwagenlijn other = (Winkelwagenlijn) obj;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
		{
			return false;
		}
		return true;
	}
}
