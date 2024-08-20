package com.sandro.ecommercebackendspring.validator;

import com.sandro.ecommercebackendspring.user.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Set;

@Component
public class ObjectValidator {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    public Set<String> validate(User objectToValidate) {
        Set<ConstraintViolation<User>> violations = validator.validate(objectToValidate);
//        if (!violations.isEmpty()) {
//            return violations
//                    .stream()
//                    .map(ConstraintViolation::getMessage)
//                    .collect(Collectors.toSet());
//        }
        if (!violations.isEmpty()) {
            var errorMessage = violations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .reduce((s1, s2) -> s1 + "\n" + s2)
                    .orElse("Invalid object");
            throw new IllegalArgumentException(errorMessage);
        }
        return Collections.emptySet();

    }
}
