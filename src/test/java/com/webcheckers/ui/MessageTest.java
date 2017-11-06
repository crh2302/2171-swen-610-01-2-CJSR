package com.webcheckers.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {
    String messageText = "Hi";
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void CreateMessageTest()
    {
        Message message = new Message(messageText);
        assertNotNull(message);
        assertEquals(message.getText(),messageText);
    }
    @Test
    public void GetTextTest()
    {
        Message message = new Message(messageText);
        assertEquals(message.getText(),messageText);
    }
}
