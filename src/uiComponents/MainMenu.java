package uiComponents;

import api.AdminResource;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {


    public static void main(String[] args) {
        MainMenu.menuItems00();
    }

    public static void menuItems00() {
        System.out.println("\n-------Welcome to Hotel Reservation Application-------");
        System.out.println("1. Find and Reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");

        String input = InputHandler.getNumberInput();
        switch (input) {
            case "1": menuItems01();
            case "2": menuItems02();
            case "3": menuItems03();
            case "4": menuItems04();
            case "5": System.out.println("Thank you & Good Bye"); System.exit(0);
        }
    }

    public static void menuItems01() {
        System.out.println("\n-------Welcome to Room Finder & Reservation Menu-------");
        System.out.println("1. Find a room (by check in & check out dates)\n" +
                "2. Book a room\n" +
                "3. See a specific room (by number)\n" +
                "4. See all customer reservations\n" +
                "5. Back to Main Menu\n");

        switch (InputHandler.getNumberInput()) {
            case "1": ;
            case "2": ;
            case "3": { System.out.println("Please enter a room number (1 - 300)");
                api.HotelResource.getRoom(InputHandler.getRoomNumber()); }
            case "4": api.HotelResource.getCustomerReservations(InputHandler.enterEmail());
            case "5": menuItems00();
        }
    }

    public static void menuItems02() {
        System.out.println("\n-------Welcome to Reservations Info Menu-------");
        System.out.println("Do you have an account with us? \n" +
                "(Please enter y/n)" );
        String email;
        if (InputHandler.checkAnswer().equals("n")) {
            System.out.println("Please create an account first, and then book a room");
            menuItems03();
        } else {
            System.out.println("Please insert your email: ");
            email = InputHandler.enterEmail();
            System.out.println("Your reservations are:");
            api.HotelResource.getCustomerReservations(email);
            System.out.println("Thank you!\n");
            menuItems00();
        }
    }


    public static void menuItems03() {
        System.out.println("\n-------Welcome to Account Creation Menu-------");
        String firstName;
        String lastName;
        String email;
        try {
            System.out.println("Please enter first name:");
            BufferedReader firstNameRead = new BufferedReader(new InputStreamReader(System.in));
            firstName = firstNameRead.readLine();

            System.out.println("Please enter last name:");
            BufferedReader lastNameRead = new BufferedReader(new InputStreamReader(System.in));
            lastName = lastNameRead.readLine();

            System.out.println("Please enter email:");
            email = InputHandler.enterEmail();
            System.out.println("The email is: " + email);

            api.HotelResource.createACustomer(email, firstName, lastName);
            System.out.println("Account Created. \nThank you!");
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        menuItems00();
    }

    public static void menuItems04() {
        System.out.println("\n-------Welcome to Admin Menu-------");
        System.out.println("1. Display all customers accounts\n" +
                "2. View all the rooms in the hotel\n" +
                "3. View all hotel reservations\n" +
                "4. Add a room\n" +
                "5. Back to Main Menu");
        switch(InputHandler.getNumberInput()) {
            case "1": AdminResource.getAllCustomers();
            case "2": {for (IRoom room : AdminResource.getAllRooms()) {
                room.toString();
                } }
            case "3": { AdminResource.displayAllReservations();
                menuItems04();
                }
            case "4": {
                System.out.println("Welcome to room addition menu:");
                List<IRoom> roomsList = new LinkedList<>();
                String roomNumber;
                Double roomPrice;
                RoomType roomType;
                String contInput;

                do {
                    System.out.println("Please insert room number:");
                    roomNumber = InputHandler.getRoomNumber();

                    System.out.println("Please insert room " + roomNumber + " price:");
                    roomPrice = InputHandler.getRoomPrice();

                    System.out.println("Please insert room " + roomNumber + " type:");
                    roomType = InputHandler.getRoomType();

                    roomsList.add(new Room(roomNumber, roomPrice, roomType));
                    System.out.println("Add another a room? (y/n)");
                    contInput = InputHandler.checkAnswer();
                }
                while (contInput.equals("y"));

                AdminResource.addRoom(roomsList);
                menuItems04();
            }
            case "5": menuItems00();
        }

    }
}
