package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductCostValidator implements ConstraintValidator<ProductCostConstraint, Integer> {

    @Override
    public void initialize(ProductCostConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer cost, ConstraintValidatorContext constraintValidatorContext) {
        return cost % 5 == 0;
    }
}
