package com.example;

import com.example.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {


    @NotNull(message = "Is Required")
    @Size(min = 1 , message = "Is Required")
    private String firstName;

    @NotNull(message = "Is Required")
    @Size(min = 1 , message = "Is Required")
    private String lastName ;


    @Min(value = 0 , message ="must be greater than or equal to zero")
    @Max(value = 10 , message = "must be less than or equal to ten")
    @NotNull(message = "Is Required")
    private Integer freePasses;


    @Pattern(regexp = "^[a-zA-z0-9]{5}" , message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode
    private String courseCode;


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
