import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        // ==========================================
        // --- PART 3: PRE-LOAD TEST DATA ---
        // ==========================================
        loadPart3TestData();
        // ==========================================

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
                    System.out.println("\n--- REGISTRATION ---");
                    System.out.print("Enter First Name: ");
                    String fName = scanner.nextLine().trim();
                    System.out.print("Enter Last Name: ");
                    String lName = scanner.nextLine().trim();
                    System.out.print("Enter Username (must contain '_' and <= 5 chars): ");
                    String username = scanner.nextLine().trim();
                    System.out.print("Enter Password (>= 8 chars, 1 capital, 1 number, 1 special): ");
                    String password = scanner.nextLine().trim();
                    System.out.print("Enter Cell Phone Number: ");
                    String cellNumber = scanner.nextLine().trim();

                    String registrationMessage = loginSystem.registerUser(username, password, cellNumber, fName, lName);
                    System.out.println("\n" + registrationMessage);

                    if (registrationMessage.contains("successfully")) {
                        hasRegistered = true;
                    }
                    break;

                case "2":
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

                    if (isAuthenticated) {
                        System.out.println("\nWelcome to QuickChat.");
                        boolean chatRunning = true;

                        while (chatRunning) {
                            // UPDATED: Added 4th Option for Part 3
                            System.out.println("\n--- QUICKCHAT MENU ---");
                            System.out.println("Option 1) Send Messages");
                            System.out.println("Option 2) Show recently sent messages");
                            System.out.println("Option 3) Stored Messages (Part 3)");
                            System.out.println("Option 4) Quit");
                            System.out.print("Choose an option: ");
                            String menuChoice = scanner.nextLine().trim();

                            switch (menuChoice) {
                                case "1":
                                    System.out.print("How many messages do you wish to enter? ");
                                    int numMessages = Integer.parseInt(scanner.nextLine().trim());

                                    for (int i = 1; i <= numMessages; i++) {
                                        System.out.println("\n--- Message " + i + " ---");
                                        System.out.print("Enter recipient number (+27...): ");
                                        String recipient = scanner.nextLine().trim();

                                        String messageText = "";
                                        while (true) {
                                            System.out.print("Enter message (max 250 chars): ");
                                            messageText = scanner.nextLine().trim();
                                            if (messageText.length() <= 250) break;
                                            System.out.println("Please enter a message of less than 250 characters.");
                                        }

                                        System.out.println("1 - Send Message | 2 - Disregard Message | 3 - Store Message");
                                        int action = Integer.parseInt(scanner.nextLine().trim());

                                        String flag = "";
                                        if (action == 1) flag = "Sent";
                                        else if (action == 2) flag = "Disregard";
                                        else if (action == 3) flag = "Stored";

                                        // Create message (This automatically populates the arrays)
                                        new Message(i, recipient, messageText, flag);

                                        if (action == 1) System.out.println("Message successfully sent.");
                                        else if (action == 2) System.out.println("Press 0 to delete the message.");
                                        else if (action == 3) System.out.println("Message successfully stored.");
                                    }
                                    break;

                                case "2":
                                    System.out.println("Coming Soon.");
                                    break;

                                case "3":
                                    // PART 3 SUB-MENU
                                    boolean storedMenu = true;
                                    while (storedMenu) {
                                        System.out.println("\n--- STORED MESSAGES MENU ---");
                                        System.out.println("a. Display sender & recipient");
                                        System.out.println("b. Display longest message");
                                        System.out.println("c. Search by Message ID");
                                        System.out.println("d. Search by Recipient");
                                        System.out.println("e. Delete a message using Hash");
                                        System.out.println("f. Display full report");
                                        System.out.println("g. Back to Main Menu");
                                        System.out.print("Choice: ");
                                        String subChoice = scanner.nextLine().trim().toLowerCase();

                                        switch (subChoice) {
                                            case "a": Message.displaySenderAndRecipient(); break;
                                            case "b": Message.displayLongestMessage(); break;
                                            case "c":
                                                System.out.print("Enter Message ID: ");
                                                Message.searchByID(scanner.nextLine().trim());
                                                break;
                                            case "d":
                                                System.out.print("Enter Recipient: ");
                                                Message.searchByRecipient(scanner.nextLine().trim());
                                                break;
                                            case "e":
                                                System.out.print("Enter Message Hash: ");
                                                Message.deleteByHash(scanner.nextLine().trim());
                                                break;
                                            case "f": Message.displayFullReport(); break;
                                            case "g": storedMenu = false; break;
                                            default: System.out.println("Invalid choice.");
                                        }
                                    }
                                    break;

                                case "4":
                                    System.out.println("Exiting QuickChat...");
                                    chatRunning = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                            }
                        }
                    }
                    break;

                case "3":
                    System.out.println("\nExiting the application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid option.");
            }
        }
        scanner.close();
    }

    // Helper method to populate arrays with the exact test data from the rubric
    private static void loadPart3TestData() {
        new Message(1, "+27834557896", "Did you get the cake?", "Sent");
        new Message(2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        new Message(3, "+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        new Message(4, "0838884567", "It is dinner time !", "Sent");
        new Message(5, "+27838884567", "Ok, I am leaving without you.", "Stored");
    }
}