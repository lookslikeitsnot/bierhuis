package be.vdab.bierhuis.valueobjects;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import be.vdab.bierhuis.entities.Bestelbon;

public class Winkelwagen {
	Set<Winkelwagenlijn> winkelwagen;

	public Winkelwagen() {
		winkelwagen = new HashSet<>();
	}

	public void add(Winkelwagenlijn winkelwagenlijn) {
		if(winkelwagen.contains(winkelwagenlijn)) {
			for(Winkelwagenlijn lijn : winkelwagen) {
				if(lijn.equals(winkelwagenlijn)) {
					lijn.addAantal(winkelwagenlijn.getAantal());
				}
			}
		}
		winkelwagen.add(winkelwagenlijn);
	}

	public void remove(Winkelwagenlijn winkelwagenlijn) {
		winkelwagen.remove(winkelwagenlijn);
	}

	public Set<Winkelwagenlijn> getWinkelwagen() {
		return winkelwagen;
	}

	public Bestelbon toBestelbon(WinkelwagenForm winkelwagenForm) {
		Bestelbon bestelbon = new Bestelbon();
		bestelbon.setAdres(winkelwagenForm.getAdres());
		bestelbon.setNaam(winkelwagenForm.getNaam());
		bestelbon.setBestelbonlijnen(
				winkelwagen.stream().map(lijn -> lijn.toBestelbonlijn()).collect(Collectors.toSet()));
		return bestelbon;
	}

	public BigDecimal getPrijs() {
		return winkelwagen.stream().map(lijn -> lijn.getTeBetalen()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public boolean isEmpty() {
		if (winkelwagen == null) {
			return true;
		}
		if (winkelwagen.isEmpty()) {
			return true;
		}
		return false;
	}
}
