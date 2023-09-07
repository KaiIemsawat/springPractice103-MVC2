package com.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value(); // assign value from theCourseCode to coursePrefix
    }

//    Business logic here, can add custom validation in this method
    @Override
//                               'theCode' <-- HTML From Data entered by the user
    public boolean isValid(String theCode, ConstraintValidatorContext context) {
//                   We can place additional error messages here --> 'context'
        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }
        else {
            result = true;
        }
        return result;
    }
}
