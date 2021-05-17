package com.h2.api.interfaces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.h2.api.validator.PasswordValidatorCustom;

@Documented
@Constraint(validatedBy = PasswordValidatorCustom.class)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Password Invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
