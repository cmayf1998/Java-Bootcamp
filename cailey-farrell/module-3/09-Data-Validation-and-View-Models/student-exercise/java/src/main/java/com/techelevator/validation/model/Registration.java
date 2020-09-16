package com.techelevator.validation.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Registration {

    @NotBlank(message = "First name is required")
    @Max(value = 20, message = "First name must be less than 20 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Max(value = 20, message = "Last name must be less than 20 characters")
    private String lastName;

    @NotBlank(message = "Email address is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    @AssertTrue(message = "Emails must match")
    public boolean isEmailMatching(){
        if (email != null){
            return email.equals(confirmEmail);
        }
        return true;
    }
    private String confirmEmail;

    @NotBlank(message = "Required")
    @Size(min = 8, message = "Password min is 8 characters")
    private String password;

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordMatching(){
        if (email != null){
            return email.equals(confirmPassword);
        }
        return true;
    }
    private String confirmPassword;


    @NotBlank(message = "Required")
    @DateTimeFormat(pattern = "MM-DD-YYYY")
   // @Pattern(regexp = "^\\\\d{2}\\?\\d{2}/\\d{4}$", message = "Not valid birthdate")
    private LocalDate birthdate;


    @NotNull(message = "Required")
    @Min(value = 1,message = "# of Tickets must be between 1 and 10")
    @Max(value = 10, message = "# of Tickets must be between 1 and 10")
    private Integer numberOfTickets;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
