package com.laet.customer.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class CepValidator implements ConstraintValidator<ValidCep, String> {
    private static  final Pattern CEP_PATTERN = Pattern.compile("^[0-9]{5}-?[0-9]{3}$");

    @Override
    public void initialize(ValidCep constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext constraintValidatorContext) {
        return cep == null || CEP_PATTERN.matcher(cep).matches();
    }
}
