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
		System.out.println("aantal winkelwagenlijnen : " + winkelwagen.size());
		System.out.println("aantal bestelbonlijnen : " + bestelbon.getBestelbonlijnen().size());
		return bestelbon;
	}

	public BigDecimal getPrijs() {
		return winkelwagen.stream().map(lijn -> lijn.getPrijs()).reduce(BigDecimal.ZERO, BigDecimal::add);
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
