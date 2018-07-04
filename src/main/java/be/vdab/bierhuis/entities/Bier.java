package be.vdab.bierhuis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.constraints.Naam;

@Entity
@Table(name = "bieren")
public class Bier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@SafeHtml(whitelistType = WhiteListType.NONE)
	@NotNull
	@Naam
	private String naam;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brouwerid")
	private Brouwer brouwer;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "soortid")
	private Soort soort;
	@NotNull
	@Min(0)
	private Integer alcohol;
	@org.springframework.format.annotation.NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal prijs;

	public Bier() {
	}

	public Bier(@SafeHtml(whitelistType = WhiteListType.NONE) @NotNull String naam, Brouwer brouwer, Soort soort,
			@NotNull @Min(0) Integer alcohol, @NotNull @Min(0) @Digits(integer = 10, fraction = 2) BigDecimal prijs) {
		this.naam = naam;
		this.brouwer = brouwer;
		this.soort = soort;
		this.alcohol = alcohol;
		this.prijs = prijs;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Brouwer getBrouwer() {
		return brouwer;
	}

	public void setBrouwer(Brouwer brouwer) {
		this.brouwer = brouwer;
	}

	public Soort getSoort() {
		return soort;
	}

	public void setSoort(Soort soort) {
		this.soort = soort;
	}

	public Integer getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(Integer alcohol) {
		this.alcohol = alcohol;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public long getId() {
		return id;
	}
	
	

	@Override
	public String toString() {
		return "Bier [id=" + id + ", naam=" + naam + ", brouwer=" + brouwer + ", soort=" + soort + ", alcohol="
				+ alcohol + ", prijs=" + prijs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alcohol == null) ? 0 : alcohol.hashCode());
		result = prime * result + ((brouwer == null) ? 0 : brouwer.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result + ((soort == null) ? 0 : soort.hashCode());
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
		Bier other = (Bier) obj;
		if (alcohol == null) {
			if (other.alcohol != null)
				return false;
		} else if (!alcohol.equals(other.alcohol))
			return false;
		if (brouwer == null) {
			if (other.brouwer != null)
				return false;
		} else if (!brouwer.equals(other.brouwer))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (soort == null) {
			if (other.soort != null)
				return false;
		} else if (!soort.equals(other.soort))
			return false;
		return true;
	}
}
