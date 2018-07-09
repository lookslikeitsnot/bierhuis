package be.vdab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerFormValidator implements ConstraintValidator<IntegerForm, Integer> {
	private Integer min;
	private Integer max;

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		if(value < min || value > max) {
			return false;
		}
		return true;
	}

	@Override
	public void initialize(IntegerForm constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

}
