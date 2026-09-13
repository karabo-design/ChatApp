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