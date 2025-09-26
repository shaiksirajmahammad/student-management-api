package com.apis.LearningApis.DTO;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.*;

@Email(
        message = "Please provide a valid email address.",
        regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"
)
@NotEmpty(message = "Email cannot be empty.")

// 2. Add standard boilerplate for creating a custom constraint annotation
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {}) // validatedBy is empty for composite constraints
@Documented
public @interface EmailMust {
    String message() default "Invalid email format. Must not be empty and follow the correct pattern.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
