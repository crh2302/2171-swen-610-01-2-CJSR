package com.webcheckers.appl;

import com.sun.tools.javac.comp.Check;
import com.webcheckers.model.CheckersGame;
import com.webcheckers.model.Move;
import com.webcheckers.model.Piece;
import com.webcheckers.model.Position;
import org.junit.Before;
import org.junit.Test;

import spark.Request;
import spark.Session;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CheckersCenterTest {

    CheckersCenter checkersCenter;
    CheckersCenter CuT;
    CheckersGame game;

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
