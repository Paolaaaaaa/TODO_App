package com.todo.demo.domain.service.validator;

import com.todo.demo.persistence.entities.Person;

public class PersonValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static void validate(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        if (person.getEmail() == null || !person.getEmail().matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid or missing email format");
        }

        if (person.getDescription() == null || person.getDescription().isBlank()) {
            throw new IllegalArgumentException("Every person should have a description");
        }

        if (person.getCellphone() == null ) {
            throw new IllegalArgumentException("Cellphone number must be 10 digits");
        }

        if (person.getPassword() == null || person.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
    }
}
