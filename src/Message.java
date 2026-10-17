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



}
