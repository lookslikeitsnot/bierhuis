package be.vdab.bierhuis.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.constraints.IntegerForm;
import be.vdab.constraints.StringForm;

@Embeddable
public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;

	@StringForm(maxLength = 50, message="{error.stringForm.straat}")
	private String straat;
	
	@StringForm(maxLength=10, pattern="[0-9]+[a-zA-Z]?", message="{error.stringForm.huisnr}")
	private String huisnr;
	
	@NumberFormat(style = Style.NUMBER)
	@IntegerForm(min = 1000, max = 9999, message = "{error.integerForm.postcode}")
	private Integer postcode;
	
	@StringForm(maxLength = 50, message="{error.stringForm.gemeente}")
	private String gemeente;

	public Adres() {
	}

	public Adres(String straat, String huisnr, Integer postcode, String gemeente) {
		this.straat = straat;
		this.huisnr = huisnr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisnr;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public String getHuisnr() {
		return huisnr;
	}

	public void setHuisnr(String huisnr) {
		this.huisnr = huisnr;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemeente == null) ? 0 : gemeente.hashCode());
		result = prime * result + ((huisnr == null) ? 0 : huisnr.hashCode());
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
		if (huisnr == null) {
			if (other.huisnr != null)
				return false;
		} else if (!huisnr.equals(other.huisnr))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (straat == null) {
			if (other.straat != null)
				return false;
		} else if (!straat.equals(other.straat)) {
			return false;}
		return true;
	}
}
