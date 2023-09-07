package com.springdemo.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Customer {

    @NotBlank(message = "Firstname is required")
    @Size(min = 2, message = "Firstname can't me shorter than 2 characters")
    private String firstName;

    @NotBlank(message = "Lastname is required")
    @Size(min = 3, message = "Firstname can't me shorter than 2 characters")
    private String lastName;

    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to ten")
    private int freePasses;

//    Getters / Setters
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

    public int getFreePasses() {
        return freePasses;
    }
    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
