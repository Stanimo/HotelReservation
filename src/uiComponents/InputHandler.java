package uiComponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public abstract class InputHandler {
    private static String emailRegex = "^(.+)@(.+)\\.(.+)$";
    private static String inputRegex = "^([1-5]$)"; // Regular expression for receiving digits only, between 1 and 5.
    private static String answerRegex = "^[yn]$";
    private static String roomNumRegex = "^([1-300])"; // Hotel has max 300 rooms.
//    private static String dateRegex = ;

    public static String checkEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegex);
        String userInput = null;
        try {
            BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = inputRead.readLine();
            while (!pattern.matcher(userInput.toString()).matches()) {
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
            while (!pattern.matcher(userInput.toString()).matches()) {
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
            while (!pattern.matcher(userInput.toString()).matches()) {
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
            while (!pattern.matcher(userInput.toString()).matches()) {
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
        Pattern pattern = Pattern.compile(roomNumRegex);
        String userInput = null;
        try {
            BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = inputRead.readLine();
            while (!pattern.matcher(userInput.toString()).matches()) {
                System.out.println("This input is illegal.\n" +
                        "Please enter a room number in range between 1 - 300");
                userInput = inputRead.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return userInput;
    }
}
