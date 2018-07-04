package be.vdab.bierhuis.valueobjects;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
	
	public BigDecimal getPrijs() {
		return winkelwagen.stream().map(lijn -> lijn.getPrijs()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public boolean isEmpty() {
		if(winkelwagen == null) {
			return true;
		}
		if(winkelwagen.isEmpty()) {
			return true;
		}
		return false;
	}
}
