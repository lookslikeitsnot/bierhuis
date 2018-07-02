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
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 50)
	private String straat;
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 10)
	private String huisNr;
	@NotNull
	@NumberFormat(style = Style.NUMBER) // opmaak annotation die er al stond
	@NotNull
	@Min(1000)
	@Max(9999)
	private Integer postcode;
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotBlank
	@Length(min = 1, max = 50)
	private String gemeente;	
}
