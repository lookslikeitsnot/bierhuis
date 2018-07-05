package be.vdab.bierhuis.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.bierhuis.entities.Bier;

@Embeddable
public class Bestelbonlijn implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne()
	@JoinColumn(name = "bierid")
	private Bier bier;
	@NotNull
	@Min(0)
	private Integer aantal;
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal prijs;
	
	public Bestelbonlijn() {
	}
	
	public Bestelbonlijn(Bier bier, @NotNull @Min(0) Integer aantal,
			@NotNull @Min(0) @Digits(integer = 10, fraction = 2) BigDecimal prijs) {
		this.bier = bier;
		this.aantal = aantal;
		this.prijs = prijs;
	}

	public Bier getBier() {
		return bier;
	}

	public Integer getAantal() {
		return aantal;
	}

	public BigDecimal getPrijs() {
		return prijs;
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
		Bestelbonlijn other = (Bestelbonlijn) obj;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}
}
