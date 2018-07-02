package be.vdab.bierhuis.valueobjects;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

import be.vdab.constraints.Naam;

public class Soort implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long brouwerNr;
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotNull
	@Naam
	private String naam;
}
