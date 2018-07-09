package be.vdab.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

public class StringFormValidator implements ConstraintValidator<StringForm, String>{
	private int min;
	private int max;
	private Pattern pattern;
	
	@Override
	public boolean isValid(@SafeHtml(whitelistType = WhiteListType.NONE) String stringForm, ConstraintValidatorContext context) {
		if(stringForm == null) {
			return false;
		}
		if(stringForm.trim().isEmpty()) {
			return false;
		}
		if(stringForm.length() < min || stringForm.length() > max) {
			return false;
		}
		Matcher matcher = pattern.matcher(stringForm);
		return matcher.matches();
	}

	@Override
	public void initialize(StringForm constraintAnnotation) {
		min = constraintAnnotation.minLength();
		max = constraintAnnotation.maxLength();
		pattern = Pattern.compile(constraintAnnotation.pattern());
	}
}
