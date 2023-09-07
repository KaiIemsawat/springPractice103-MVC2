package com.springdemo.mvc;

import com.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

//    Since we have a method that will trim out any whitespace (front and back), we can use either @NotBlank or @NotNull
    @NotBlank(message = "Firstname is required")
    @Size(min = 2, message = "Firstname can't me shorter than 2 characters")
    private String firstName;

//    Since we have a method that will trim out any whitespace (front and back), we can use either @NotBlank or @NotNull
    @NotNull(message = "Lastname is required")
    @Size(min = 3, message = "Firstname can't me shorter than 2 characters")
    private String lastName;

    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to ten")
    @NotNull(message = "Free passes cannot be empty")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "need to be 5 characters/digits and no special character")
    private String code;

//    Add custom annotation
//    We already added message and expected value in CourseCode annotation class. So, message and value are optional here
    @CourseCode(value = "TANN", message = "Must start with 'TANN'")
    private String courseCode;

//   ----- Getters / Setters -----
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }
    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
