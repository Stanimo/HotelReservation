package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String emailRegEx = "^(.+)@(.+)\\.(.+)$";

    public Customer (String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        setEmail(email);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegEx);
        if(!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Error, Invalid email");
        } else {
            this.email = email;
        }
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer's First Name is: " + firstName + "\n" +
                "Customer's Last Name is: " + lastName + "\n" +
                "Customer's email is: " + email;
     }
}
