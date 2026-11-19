import java.util.ArrayList;
import java.util.Random;

public class Message {
    // Variables
    private String messageID;
    private int messageNum;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String flag; // Sent, Stored, Disregard

    // 1. Arrays to populate (Using ArrayList for dynamic sizing)
    public static ArrayList<Message> sentMessagesArray = new ArrayList<>();
    public static ArrayList<Message> disregardedMessagesArray = new ArrayList<>();
    public static ArrayList<Message> storedMessagesArray = new ArrayList<>();
    public static ArrayList<String> messageHashesArray = new ArrayList<>();
    public static ArrayList<String> messageIDsArray = new ArrayList<>();

    public Message(int messageNum, String recipient, String messageText, String flag) {
        this.messageNum = messageNum;
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
        this.messageID = generateID();
        this.messageHash = createMessageHash();

        // Populate the arrays based on the flag
        messageIDsArray.add(this.messageID);
        messageHashesArray.add(this.messageHash);

        if (flag.equalsIgnoreCase("Sent")) {
            sentMessagesArray.add(this);
        } else if (flag.equalsIgnoreCase("Stored")) {
            storedMessagesArray.add(this);
        } else if (flag.equalsIgnoreCase("Disregard")) {
            disregardedMessagesArray.add(this);
        }
    }

    private String generateID() {
        Random rand = new Random();
        long id = (long) (rand.nextDouble() * 9000000000L) + 1000000000L;
        return String.valueOf(id);
    }

    public String createMessageHash() {
        if (messageText == null || messageText.trim().isEmpty()) return "";
        String firstTwoID = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();
        return firstTwoID + ":" + messageNum + ":" + firstWord + lastWord;
    }

    // ==========================================
    // --- PART 3 STORED MESSAGES MENU METHODS ---
    // ==========================================

    // a. Display sender and recipient of all stored messages
    public static void displaySenderAndRecipient() {
        System.out.println("\n--- Senders and Recipients ---");
        if (storedMessagesArray.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
        for (Message msg : storedMessagesArray) {
            // Assuming "Sender" is the logged-in user (Developer)
            System.out.println("Sender: Developer | Recipient: " + msg.recipient);
        }
    }

    // b. Display the longest stored message
    public static void displayLongestMessage() {
        System.out.println("\n--- Longest Stored Message ---");
        if (storedMessagesArray.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
        Message longest = storedMessagesArray.get(0);
        for (Message msg : storedMessagesArray) {
            if (msg.messageText.length() > longest.messageText.length()) {
                longest = msg;
            }
        }
        System.out.println("Longest Message: \"" + longest.messageText + "\"");
    }

    // c. Search for a message ID and display the corresponding recipient and message.
    public static void searchByID(String searchID) {
        System.out.println("\n--- Search by Message ID ---");
        for (Message msg : storedMessagesArray) {
            if (msg.messageID.equals(searchID)) {
                System.out.println("Recipient: " + msg.recipient);
                System.out.println("Message: " + msg.messageText);
                return;
            }
        }
        System.out.println("Message ID not found in stored messages.");
    }

    // d. Search for all messages stored for a particular recipient.
    public static void searchByRecipient(String searchRecipient) {
        System.out.println("\n--- Search by Recipient: " + searchRecipient + " ---");
        boolean found = false;
        for (Message msg : storedMessagesArray) {
            if (msg.recipient.equals(searchRecipient)) {
                System.out.println("Message: " + msg.messageText);
                found = true;
            }
        }
        if (!found) System.out.println("No messages found for this recipient.");
    }

    // e. Delete a message using the message hash.
    public static void deleteByHash(String searchHash) {
        System.out.println("\n--- Delete by Hash ---");
        for (int i = 0; i < storedMessagesArray.size(); i++) {
            if (storedMessagesArray.get(i).messageHash.equals(searchHash)) {
                System.out.println("Message \"" + storedMessagesArray.get(i).messageText + "\" successfully deleted.");
                storedMessagesArray.remove(i);
                return;
            }
        }
        System.out.println("Message Hash not found.");
    }

    // f. Display a report that lists the full details of all the stored messages.
    public static void displayFullReport() {
        System.out.println("\n--- FULL STORED MESSAGES REPORT ---");
        if (storedMessagesArray.isEmpty()) {
            System.out.println("No stored messages available.");
            return;
        }
        for (Message msg : storedMessagesArray) {
            System.out.println("Message Hash: " + msg.messageHash);
            System.out.println("Recipient: " + msg.recipient);
            System.out.println("Message: " + msg.messageText);
            System.out.println("-----------------------------------");
        }
    }

    // Method to simulate reading JSON into the Array
    public static void loadJSONIntoArray() {
        System.out.println("\n[System] Reading JSON file and populating Stored Messages Array...");
        // In a real app, you would read a .json file here.
        // We will simulate this by directly using the Message constructor.
    }

    // Getters
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
}