package uiComponents;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {
    String inputRegex = "^([1-5])"; // Regular expression for recieving digits only.
    public void menuItems() {
    System.out.println("1. Find and Reserve a room");
    System.out.println("2. See my reservations");
    System.out.println("3. Create an account");
    System.out.println("4. Admin");
    System.out.println("5. Exit");
    }

    Scanner scanner = new Scanner(System.in);
    Pattern pattern = Pattern.compile(inputRegex);
    Matcher matcher = pattern.matcher(scanner.toString());
}
