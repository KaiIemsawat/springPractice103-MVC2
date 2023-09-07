package com.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// CourseCodeConstraintValidator.class <- helper class that contain business rules / validate logic
@Target({ElementType.METHOD, ElementType.FIELD}) // Where can this annotation apply
@Retention(RetentionPolicy.RUNTIME) // When would this annotation be processed
public @interface CourseCode {

//    define default course code
    public String value() default "ZUK";

//    define default error message
    public String message() default "Must start with ZUK";

//    define default groups
    public Class<?>[] groups() default{};

//    define default payloads
    public Class<? extends Payload>[] payload() default{};

}

