package com.laet.customer.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

    @Constraint(validatedBy = RgValidator.class)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidRg{
        String message() default "RG inválido";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

