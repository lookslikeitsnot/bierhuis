package be.vdab.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntegerFormValidator.class)
public @interface IntegerForm {
	int min() default 0;
	int max() default Integer.MAX_VALUE;
	String message() default "{be.vdab.constraints.integerForm.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}