package uiComponents;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {
    private String inputRegex = "^([1-5])"; // Regular expression for receiving digits only.
    private String emailRegex = "^(.+)@(.+)\\.(.+)$";
    private String answerRegex = "^[yn]$";

    public void menuItems00() {
    System.out.println("1. Find and Reserve a room");
    System.out.println("2. See my reservations");
    System.out.println("3. Create an account");
    System.out.println("4. Admin");
    System.out.println("5. Exit");

    switch (getInput()) {
        case "1": menuItems01();
        case "2": menuItems02();
        case "3": menuItems03();
    }
    }

    public void menuItems01() {
        System.out.println("1. Find and Reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
    }

    public void menuItems02() {
        System.out.println("Do you have an account with us? \n" +
                "(Please enter y/n)" );
        Scanner answer = new Scanner(System.in);
        if (checkAnswer(answer.toString()).equals("n")) {
            System.out.println("Please create an account first, and book a room");
            menuItems00();
        } else {
            System.out.println("Please insert your email: ");
            Scanner emailScan = new Scanner(System.in);
            String email = checkEmail(emailScan.toString());
            service.ReservationService.getCustomerReservation(service.CustomerService.getCustomer(email));
        }
    }

    public void menuItems03() {
        System.out.println("-------Welcome to Account Creation Menu-------");
        System.out.println("Please enter your name:");

    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(inputRegex);
        if (!pattern.matcher(scanner.toString()).matches()) {
            throw new IllegalArgumentException("Error, Invalid number");
        } else {
            return scanner.toString();
        }
    }

    public String checkEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegex);
        if(!pattern.matcher(email).matches()) {
            System.out.println("Error, Invalid email. Please try again");
            throw new IllegalArgumentException("Error, Invalid email");
        } else {
           return email;
        }
    }

    public String checkAnswer(String ans) {
        Pattern pattern = Pattern.compile(answerRegex);
        if(!pattern.matcher(ans).matches()) {
            System.out.println("Error, Invalid email. Please try again");
            throw new IllegalArgumentException("Error, Invalid input");
        } else {
            return ans;
        }
    }
}
