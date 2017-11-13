package com.webcheckers.appl;

import com.webcheckers.model.CheckersGame;
import org.junit.Before;
import org.junit.Test;

import spark.Request;
import spark.Session;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CheckersCenterTest {

    CheckersCenter checkersCenter;
    CheckersCenter CuT;

    Session session;
    Request request;

    List<String> allPlayers;
    List<CheckersGame> gamesList;

    @Before
    public void setUp() throws Exception {
        checkersCenter = mock(CheckersCenter.class);
        CuT = new CheckersCenter();

        allPlayers = new ArrayList<>();
        gamesList = new ArrayList<>();

        session = mock(Session.class);
        request = mock(Request.class);
    }

    @Test
    public void end(){
        CuT.end(session,request);
    }

    @Test
    public void add(){
        assertEquals(true,CuT.add("Hello"));
    }

    @Test
    public void getGame(){
        checkersCenter.getGamesList().add(new CheckersGame("hey","sweet"));

        assertEquals(null,CuT.getGame("cool"));
        assertEquals(checkersCenter.getGame("hey"), CuT.getGame("hey"));
    }
}
