package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

public class GetGameRouteTest {
    CheckersCenter checkersCenter;
    Request request;
    Response response;
    ArrayList inGamePlayers;
    Board board;
    ModelAndView mv;

    @Before
    public void setUp() throws Exception {
        checkersCenter=mock(CheckersCenter.class);
        request=mock(Request.class);
        response=mock(Response.class);
        inGamePlayers=new ArrayList();
        inGamePlayers.add("Rucha");
        inGamePlayers.add("Shinchan");
        board=mock(Board.class);
        mv=mock(ModelAndView.class);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void handle() throws Exception {



        assertNotNull(checkersCenter); //assert checkerCenter is not null
        assertNotNull(response); //assert response is not null
        assertNotNull(request); //assert request is not null

        //player is not playing a game assertFalse
        when(request.queryParams("playerName")).thenReturn("Ross");
        when(checkersCenter.getInGamePlayers()).thenReturn(inGamePlayers);
        assertFalse(checkersCenter.getInGamePlayers().contains(request.queryParams("playerName")));

        //when opponent is not playing a game assertFalse
        when(request.queryParams("opponent")).thenReturn("Kirr");
        when(checkersCenter.getInGamePlayers()).thenReturn(inGamePlayers);
        assertFalse(checkersCenter.getInGamePlayers().contains(request.queryParams("opponent")));

        //when player with same name is already in a game assertTrue
        when(request.queryParams("playerName")).thenReturn("Shinchan");
        when(checkersCenter.getInGamePlayers()).thenReturn(inGamePlayers);
        assertTrue(checkersCenter.getInGamePlayers().contains(request.queryParams("playerName")));

        //when opponent is already playing a game assertTrue
        when(request.queryParams("opponent")).thenReturn("Rucha");
        when(checkersCenter.getInGamePlayers()).thenReturn(inGamePlayers);
        assertTrue(checkersCenter.getInGamePlayers().contains(request.queryParams("opponent")));



        assertNotNull(board);
        CheckersCenter ck=new CheckersCenter();
        GetGameRoute CuT=new GetGameRoute(ck);
        when(mv.getViewName()).thenReturn("game.ftl");
        assertEquals(mv.getViewName(),CuT.handle(request,response).getViewName());

    }

}