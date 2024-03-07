package demo.util;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidatorUtil {

    public static <T> String handleValidator(T valueByRequest) {
        ValidatorFactory ValidatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = ValidatorFactory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(valueByRequest);
        if (!constraintViolations.isEmpty()) {
            String errors = "";
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                errors += "|" + constraintViolation.getPropertyPath() + "-" + constraintViolation.getMessage();
            }
            return errors;
        } else {
            return null;
        }
    }
}
