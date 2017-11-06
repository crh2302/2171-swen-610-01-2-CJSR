package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckersGameTest
{
    private CheckersGame checkersGame;
    final private String COLOR_RED = "RED";
    final private String COLOR_WHITE = "WHITE";

    @Before
    public void setUp() throws Exception
    {
        checkersGame = new CheckersGame("hey", "cool");
        checkersGame.setTurnColor(COLOR_RED);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getTurnColor() throws Exception
    {
        assertEquals(COLOR_RED,checkersGame.getTurnColor());
    }

    @Test
    public void setTurnColor() throws Exception
    {
        checkersGame.setTurnColor(COLOR_WHITE);
        assertEquals(COLOR_WHITE,checkersGame.getTurnColor());

        checkersGame.setTurnColor(COLOR_RED);
        assertEquals(COLOR_RED,checkersGame.getTurnColor());

    }

}
