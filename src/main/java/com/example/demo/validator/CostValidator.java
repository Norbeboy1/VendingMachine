package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CostValidator implements ConstraintValidator<CostConstraint, Integer> {

    @Override
    public void initialize(CostConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer cost, ConstraintValidatorContext constraintValidatorContext) {
        return cost == 5 || cost == 10 || cost == 20 || cost == 50 || cost == 100;
    }
}
