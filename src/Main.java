import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        boolean running = true;
        boolean hasRegistered = false;

        System.out.println("Welcome to the Chat App Registration System.");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Quit");
            System.out.print("Please select an option (1-3): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Register Option
                    System.out.println("\n--- REGISTRATION ---");

                    System.out.print("Enter First Name: ");
                    String fName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lName = scanner.nextLine();

                    System.out.print("Enter Username (must contain '_' and <= 5 chars): ");
                    String username = scanner.nextLine();

                    System.out.print("Enter Password (>= 8 chars, 1 capital, 1 number, 1 special): ");
                    String password = scanner.nextLine();

                    System.out.print("Enter Cell Phone Number (with international code, e.g.,+27838968976):");
                    String cellNumber = scanner.nextLine();

                    // Call the registration method and print the result
                    String registrationMessage = loginSystem.registerUser(username, password, cellNumber, fName, lName);
                    System.out.println("\n" + registrationMessage);

                    if (registrationMessage.contains("successfully")) {
                        hasRegistered = true;
                    }
                    break;
            }
        }
    }
}