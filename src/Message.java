import java.util.ArrayList;
import java.util.Random;

public class Message {
    private String messageID;
    private int messageNum;
    private String recipient;
    private String messageText;
    private String messageHash;

    public static ArrayList<Message> sentMessageList = new ArrayList<>();
    public static ArrayList<Message> storedMessageList = new ArrayList<>();

    public Message(int messageNum, String recipient, String messageText) {
        this.messageNum = messageNum;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateID();
        this.messageHash = createMessageHash();
    }

    private String generateID() {
        Random rand = new Random();
        long id = (long) (rand.nextDouble() * 9000000000L) + 1000000000L;
        return String.valueOf(id);
    }

    public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }

    public String checkRecipientCell() {
        if (recipient != null && recipient.matches("\\+27[0-9]{9}")) {
            return "Cell phone number successfully added.";
        }
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    public String createMessageHash() {
        if (messageText == null || messageText.trim().isEmpty()) {
            return "";
        }

        String firstTwoID = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();

        return firstTwoID + ":" + messageNum + ":" + firstWord + lastWord;
    }

    public String SentMessage(int choice) {
        if (choice == 1) {
            sentMessageList.add(this);
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            storeMessage();
            return "Message successfully stored.";
        }
        return "Invalid choice.";
    }

    public String printMessages() {
        return "Message ID: " + messageID + "\n"
                + "Message Hash: " + messageHash + "\n"
                + "Recipient: " + recipient + "\n"
                + "Message: " + messageText;
    }

    public int returnTotalMessages() {
        return sentMessageList.size();
    }

    public void storeMessage() {
        storedMessageList.add(this);
        System.out.println("\n[Saved to JSON File]:");
        System.out.println("{");
        System.out.println("  \"messageID\": \"" + messageID + "\",");
        System.out.println("  \"recipient\": \"" + recipient + "\",");
        System.out.println("  \"message\": \"" + messageText + "\"");
        System.out.println("}");
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }
}