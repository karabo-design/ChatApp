import java.util.ArrayList;
import java.util.Random;

public class Message {
    //Variable
    private String messageID;
    private int messageNum;
    private String recipient;
    private String messageText;
    private String messageHash;

    //Static lists to store messages during the program run
    public static ArrayList<Message>sentMessageList = new ArrayList<>();
    public static ArrayList<Message>storedMessageList = new ArrayList<>();

    public Message(int messageNum,String recipient,String messageText){
        this.messageNum = messageNum;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateID();
        this.messageHash = createMessageHash();
    }

    // Generates a random 10-digit number
    private String generateID() {
        Random rand = new Random();
        long id = (long) (rand.nextDouble() * 9000000000L) + 1000000000L;
        return String.valueOf(id);
    }

    // 1. Boolean: checkMessageID()
    public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }

    // 2. String: checkRecipientCell()
    public String checkRecipientCell() {
        if (recipient != null && recipient.startsWith("+") && recipient.length() <= 12) {
            return "Cell phone number successfully added.";
        } else {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
    }

    // 3. String: createMessageHash()
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

    // 4. String: SentMessage()
    public String SentMessage(int choice) {
        if (choice == 1) {
            sentMessagesList.add(this);
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            storeMessage();
            return "Message successfully stored.";
        } else {
            return "Invalid choice.";
        }
    }

}
