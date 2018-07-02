package be.vdab.bierhuis.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

import be.vdab.bierhuis.valueobjects.Adres;
import be.vdab.constraints.Naam;

@Entity
@Table(name = "bestelbonnen")
public class Bestelbon implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@SafeHtml(whitelistType=WhiteListType.NONE)
	@NotNull
	@Naam
	private String naam;
	@Valid
	@Embedded
	private Adres adres;
	@OneToMany(mappedBy = "bestelbon")
	private Set<Bestelbonlijn> bestelbonlijnen;
}
