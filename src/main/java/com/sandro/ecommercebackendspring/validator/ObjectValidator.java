package com.sandro.ecommercebackendspring.validator;

import com.sandro.ecommercebackendspring.user.model.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ObjectValidator {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    public Map<String, Map<String, List<String>>> validate(User objectToValidate) {
        Set<ConstraintViolation<User>> violations = validator.validate(objectToValidate);

        Map<String, Map<String, List<String>>> errors = new HashMap<>();
        Map<String, List<String>> fieldErrors = new HashMap<>();

        if (!violations.isEmpty()) {
            for (ConstraintViolation<User> violation : violations) {
                String field = violation.getPropertyPath().toString();
                String errorMessage = violation.getMessage();

                // If the field already has errors, add to the list; otherwise, create a new list
                fieldErrors.computeIfAbsent(field, k -> new ArrayList<>()).add(errorMessage);
            }
        }

        if (!fieldErrors.isEmpty()) {
            errors.put("errors", fieldErrors);
        }
        return errors;
    }
}
