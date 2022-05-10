package com.example.demo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CostValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CostConstraint {
    public String message() default "must be 5, 10, 20, 50 and 100 cents";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
