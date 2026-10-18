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

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    // Register Option
                    System.out.println("\n--- REGISTRATION ---");

                    System.out.print("Enter First Name: ");
                    String fName = scanner.nextLine().trim();

                    System.out.print("Enter Last Name: ");
                    String lName = scanner.nextLine().trim();

                    System.out.print("Enter Username (must contain '_' and <= 5 chars): ");
                    String username = scanner.nextLine().trim();

                    System.out.print("Enter Password (>= 8 chars, 1 capital, 1 number, 1 special): ");
                    String password = scanner.nextLine().trim();

                    System.out.print("Enter Cell Phone Number (with international code, e.g.,+27838968976):");
                    String cellNumber = scanner.nextLine().trim();

                    // Call the registration method and print the result
                    String registrationMessage = loginSystem.registerUser(username, password, cellNumber, fName, lName);
                    System.out.println("\n" + registrationMessage);

                    if (registrationMessage.contains("successfully")) {
                        hasRegistered = true;
                    }
                    break;

                case "2":
                    // Login Option
                    if (!hasRegistered) {
                        System.out.println("\nYou need to register a user before you can log in.");
                        break;
                    }

                    System.out.println("\n--- LOGIN ---");
                    System.out.print("Enter Username: ");
                    String loginUser = scanner.nextLine().trim();

                    System.out.print("Enter Password: ");
                    String loginPass = scanner.nextLine().trim();

                    boolean isAuthenticated = loginSystem.loginUser(loginUser, loginPass);
                    System.out.println("\n" + loginSystem.returnLoginStatus(isAuthenticated));
                    break;
                case "3":
                    // Quit Option
                    System.out.println("\nExiting the application. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid option. Please enter 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}

//Part 2

 if (isAuthenticated) {
        System.out.println("\nWelcome to QuickChat.");
boolean chatRunning = true;

                        while (chatRunning) {
        System.out.println("\n--- QUICKCHAT MENU ---");
                            System.out.println("Option 1) Send Messages");
                            System.out.println("Option 2) Show recently sent messages");
                            System.out.println("Option 3) Quit");
                            System.out.print("Choose an option: ");
String menuChoice = scanner.nextLine().trim();
