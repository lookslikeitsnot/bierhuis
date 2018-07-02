package be.vdab.bierhuis.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AantalForm {
	@NotNull
	@Min(0)
	private Integer aantal;

	public Integer getAantal() {
		return aantal;
	}

	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}
}
