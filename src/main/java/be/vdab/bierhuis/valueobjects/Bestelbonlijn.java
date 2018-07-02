package be.vdab.bierhuis.valueobjects;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.bierhuis.entities.Bestelbon;

public class Bestelbonlijn {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bestelbonid")
	private Bestelbon bestelbon;
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
	private Integer prijs;
}
