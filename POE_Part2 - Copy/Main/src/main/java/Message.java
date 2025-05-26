/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class Message {

    private static int messageCount = 0;

    private String messageId;
    private int messageNum;
    private String recipient;
    private String messageContent;
    private String messageHash;

    // Constructor
    public Message(String recipient, String messageContent) {
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.messageNum = ++messageCount;
        this.messageId = generateMessageId();
        this.messageHash = createMessageHash();

        storeMessage();  // Uncommented to store on creation
    }

    // Generate a random numeric Message ID
    private String generateMessageId() {
        return String.valueOf((int)(Math.random() * 1_000_000_000));
    }

    // Check if the generated message ID is valid
    public boolean checkMessageID() {
        return messageId != null && messageId.length() <= 10;
    }

    // Check if recipient cell number is valid (starts with + and has 10–15 digits after that)
    public static boolean checkRecipientCell(String recipient) {
        return recipient != null &&
               recipient.startsWith("+") &&
               recipient.substring(1).matches("\\d{10,15}");
    }

    // Create a message hash using first/last words and part of the message ID
    public String createMessageHash() {
        String[] words = messageContent.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        return messageId.substring(0, 2) + ":" + messageNum + ":" + firstWord + lastWord;
    }

    // Return a user-facing message based on input option
    public static boolean sendMessageOption(String option) {
        return "1".equals(option);  // Only option "1" is valid for sending
    }

    // Print message info (can be improved or formatted into JSON if needed)
    public String printMessages() {
        return "Message ID: " + messageId +
               "\nMessage Hash: " + messageHash +
               "\nRecipient: " + recipient +
               "\nMessage Content: " + messageContent;
    }

    // Static method to return total messages sent
    public static int returnTotalMessages() {
        return messageCount;
    }

    // Store message info in a JSON file
    public void storeMessage() {
        JSONObject messageJson = new JSONObject();
        messageJson.put("messageId", messageId);
        messageJson.put("messageNum", messageNum);
        messageJson.put("recipient", recipient);
        messageJson.put("messageContent", messageContent);
        messageJson.put("messageHash", messageHash);

        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(messageJson.toString() + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error writing message to JSON: " + e.getMessage());
        }
    }
}
