package be.vdab.bierhuis.valueobjects;

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
