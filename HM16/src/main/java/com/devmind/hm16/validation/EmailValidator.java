package com.devmind.hm16.validation;

import com.devmind.hm16.models.MyDatabase;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    @Autowired
    MyDatabase myDatabase;
    @Override
    public void initialize(EmailConstraint user) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        return value != null && myDatabase.getMyUsers().containsKey(value) == false;
    }
}
