package uiComponents;

import model.RoomType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public abstract class InputHandler {
    private static String emailRegex = "^(.+)@(.+)\\.(.+)$";
    private static String inputRegex = "^([1-5])$"; // Regular expression for receiving digits only, between 1 and 5.
    private static String answerRegex = "^[yn]$";
    private static String roomTypeRegex = "^([sd])$";

    public static String checkEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegex);
        String userInput = null;
        try {
            BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = inputRead.readLine();
            while (!pattern.matcher(userInput).matches()) {
                System.out.println("This input is illegal.\n" +
                        "Please enter a legal email (john@gmail.com)");
                userInput = inputRead.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return userInput;
    }

    public static String enterEmail() {
        Pattern pattern = Pattern.compile(emailRegex);
        String userInput = null;
        try {
            BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = inputRead.readLine();
            while (!pattern.matcher(userInput).matches()) {
                System.out.println("This input is illegal.\n" +
                        "Please enter a legal email (john@gmail.com)");
                userInput = inputRead.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return userInput;
    }

    public static String getNumberInput() {
        Pattern pattern = Pattern.compile(inputRegex);
        String userInput = null;
        try {
            BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = inputRead.readLine();
            while (!pattern.matcher(userInput).matches()) {
                System.out.println("This input is illegal.\n" +
                        "Please enter one of the menu's corresponding number");
                userInput = inputRead.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return userInput;
    }

    public static String checkAnswer() {
        Pattern pattern = Pattern.compile(answerRegex);
        String userInput = null;
        try {
            BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = inputRead.readLine();
            while (!pattern.matcher(userInput).matches()) {
                System.out.println("This input is illegal.\n" +
                        "Please enter either 'Y' for YES ot 'N' for NO");
                userInput = inputRead.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return userInput;
    }

    public static String getRoomNumber() {
        String userInput = "0";
        try {
                BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
            try { //TODO an implementation needed that runs through this loop and catches exceptions every time.
                    userInput = inputRead.readLine();
                 while (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 300) {

                    System.out.println("This input is illegal.\n" +
                            "Please enter a room number in range between 1 - 300:");
                    userInput = inputRead.readLine();
                    }
                } catch (NumberFormatException e) {
                System.out.println("Exception " + e + "occurred\n" +
                        "The input should be an integer number between 1 and 300");
                userInput = inputRead.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return userInput;
    }

    public static Double getRoomPrice() {
        String userInput = "0.0";
        try {
            BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
            try {
            userInput = inputRead.readLine();
                while (Double.parseDouble(userInput) < 0 || Double.parseDouble(userInput) > 5000) {
                    System.out.println("This input is illegal.\n" +
                            "Please enter a price in range $0 - $5000");
                    userInput = inputRead.readLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e + "occurred\n" +
                        "The input should be a number.");
                userInput = inputRead.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return Double.parseDouble(userInput);
    }

    public static RoomType getRoomType() {
        Pattern pattern = Pattern.compile(roomTypeRegex);
        String userInput = null;
            System.out.println("Please enter a `s` for Single room or `d` for Double room");
            BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            userInput = inputRead.readLine();
            while (!pattern.matcher(userInput.toString()).matches()) {
                System.out.println("This input is illegal.\n" +
                        "Please enter a `s` for Single room or `d` for Double room");
                userInput = inputRead.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        if(userInput.equals("s")){
            return RoomType.SINGLE;
        } else {
            return RoomType.DOUBLE;
        }

    }
}
