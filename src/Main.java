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
                case "1": {
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

                    String registrationMessage = loginSystem.registerUser(username, password, cellNumber, fName, lName);
                    System.out.println("\n" + registrationMessage);

                    if (registrationMessage.contains("successfully")) {
                        hasRegistered = true;
                    }
                    break;
                }

                case "2": {
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
                        chatLoop(scanner);
                    }
                    break;
                }

                case "3":
                    System.out.println("\nExiting the application. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid option. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static void chatLoop(Scanner scanner) {
        boolean chatRunning = true;

        while (chatRunning) {
            System.out.println("\n--- QUICKCHAT MENU ---");
            System.out.println("Option 1) Send Messages");
            System.out.println("Option 2) Show recently sent messages");
            System.out.println("Option 3) Quit");
            System.out.print("Choose an option: ");

            String menuChoice = scanner.nextLine().trim();

            switch (menuChoice) {
                case "1": {
                    System.out.print("How many messages do you wish to enter? ");
                    int numMessages;
                    try {
                        numMessages = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                        break;
                    }

                    for (int i = 1; i <= numMessages; i++) {
                        System.out.println("\n--- Message " + i + " ---");
                        System.out.print("Enter recipient number (+27...): ");
                        String recipient = scanner.nextLine().trim();

                        String messageText;
                        while (true) {
                            System.out.print("Enter message (max 250 chars): ");
                            messageText = scanner.nextLine().trim();
                            if (messageText.length() <= 250) {
                                System.out.println("Message sent");
                                break;
                            }
                            System.out.println("Please enter a message of less than 250 characters.");
                        }

                        Message msg = new Message(i, recipient, messageText);
                        System.out.println(msg.checkRecipientCell());

                        System.out.println("1 - Send Message");
                        System.out.println("2 - Disregard Message");
                        System.out.println("3 - Store Message");
                        System.out.print("Choice: ");

                        int action;
                        try {
                            action = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input.");
                            continue;
                        }

                        String response = msg.SentMessage(action);
                        System.out.println(">> " + response);

                        if (action == 1) {
                            System.out.println("\n--- Details ---");
                            System.out.println(msg.printMessages());
                        }
                    }

                    Message tracker = new Message(0, "", "");
                    System.out.println("\nTotal messages sent: " + tracker.returnTotalMessages());
                    break;
                }

                case "2":
                    System.out.println("Coming Soon.");
                    break;

                case "3":
                    System.out.println("Exiting QuickChat...");
                    chatRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
