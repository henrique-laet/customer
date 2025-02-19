package com.laet.customer.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class RgValidator implements ConstraintValidator<ValidRg, String> {

    @Override
    public void initialize(ValidRg constraintAnnotation) {
    }

    @Override
    public boolean isValid(String rg, ConstraintValidatorContext context) {
        if (rg == null || rg.isEmpty()) {
            return false;
        }

        return rg.matches("\\d{9}");
    }
}
