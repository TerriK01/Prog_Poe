/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Message class.
 */
public class MessageTest {

    private Message message;

    @BeforeEach
    public void setUp() {
        message = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
    }

    @Test
    public void testMessageIDLength() {
        assertTrue(message.checkMessageID(), "Message ready to send");
    }

    @Test
    public void testValidRecipientNumber() {
        assertTrue(Message.checkRecipientCell("+27718693002"), "Cellphone number successfully captured");
    }

    @Test
    public void testInvalidRecipientNumber() {
        assertFalse(Message.checkRecipientCell("0838968976"), "Missing '+' should fail");
        assertFalse(Message.checkRecipientCell("+2783896"), "Too short should fail");
        assertFalse(Message.checkRecipientCell(null), "Null input should fail");
    }

    @Test
    public void testSendMessageOption() {
        assertTrue(Message.sendMessageOption("1"), "Option '1' should be valid");
        assertFalse(Message.sendMessageOption("2"), "Option other than '1' should be invalid");
    }

    @Test
    public void testTotalMessagesCountIncreases() {
        int initialCount = Message.returnTotalMessages();
        new Message("+27820000001", "Test message");
        assertEquals(initialCount + 1, Message.returnTotalMessages(), "Message count should increase by 1");
    }

    @Test
    public void testJsonFileIsCreated() {
        File file = new File("messages.json");
        assertTrue(file.exists(), "messages.json should be created after storing a message");
    }

    @Test
    public void testJsonFileIsNotEmpty() throws Exception {
        File file = new File("messages.json");
        assertTrue(file.exists(), "messages.json file should exist");
        assertTrue(Files.size(Paths.get("messages.json")) > 0, "messages.json should not be empty");
    }
}
