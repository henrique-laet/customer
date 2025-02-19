package com.laet.customer.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class TelephoneValidator implements ConstraintValidator<ValidTelephone, String> {
    private static final Pattern TELEFONE_PATTERN = Pattern.compile("^(\\+\\d{1,3}[- ]?)?\\d{10,15}$");

    @Override
    public void initialize(ValidTelephone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String telephone, ConstraintValidatorContext context) {
        return telephone == null || TELEFONE_PATTERN.matcher(telephone).matches();
    }
}
