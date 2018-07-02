package be.vdab.bierhuis.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Embeddable
public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;

	@SafeHtml(whitelistType = WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 50)
	private String straat;
	@SafeHtml(whitelistType = WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 10)
	private String huisNr;
	@NotNull
	@NumberFormat(style = Style.NUMBER) // opmaak annotation die er al stond
	@NotNull
	@Min(1000)
	@Max(9999)
	private Integer postcode;
	@SafeHtml(whitelistType = WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 50)
	private String gemeente;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemeente == null) ? 0 : gemeente.hashCode());
		result = prime * result + ((huisNr == null) ? 0 : huisNr.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((straat == null) ? 0 : straat.hashCode());
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
		Adres other = (Adres) obj;
		if (gemeente == null) {
			if (other.gemeente != null)
				return false;
		} else if (!gemeente.equals(other.gemeente))
			return false;
		if (huisNr == null) {
			if (other.huisNr != null)
				return false;
		} else if (!huisNr.equals(other.huisNr))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (straat == null) {
			if (other.straat != null)
				return false;
		} else if (!straat.equals(other.straat))
			return false;
		return true;
	}
}
