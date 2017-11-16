package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class PostSubmitTurnRouteTest {
    //attributes for holding mock objects
    private Request request;
    private Session session;
    private Response response;
    private CheckersCenter checkersCenter;
    private CheckersGame gameMock;

    private String playerName = "julio";
    private String opponentName = "caesar";
    private List<String> mockListPlayerInGame;
    private List<CheckersGame> mockListGames;

    PostSubmitTurnRoute CuT; //= new PostSubmitTurnRoute(new CheckersCenter());

    @Before
    public void setUp() throws Exception {
        checkersCenter = mock(CheckersCenter.class);
        gameMock = mock(CheckersGame.class);

        request = mock(Request.class);
        session = mock(Session.class);

        when(request.session()).thenReturn(session);
        response = mock(Response.class);
        CuT = new PostSubmitTurnRoute(checkersCenter);
        mockListPlayerInGame = new ArrayList<>();
        mockListPlayerInGame.add(playerName);
        mockListPlayerInGame.add(opponentName);

        mockListGames = new ArrayList<>();
        mockListGames.add(gameMock);

    }

    @Test (expected=spark.HaltException.class)
    public void piecesLeft(){
        given(request.session()).willReturn(session);
        given(request.cookie("playerName")).willReturn(playerName);
        given(checkersCenter.getGame(playerName)).willReturn(gameMock);
        given(checkersCenter.getInGamePlayers()).willReturn(mockListPlayerInGame);

        doNothing().when(gameMock).processTurn();
        doNothing().when(gameMock).clearMoves();
        when(gameMock.getWhitePiecesLeft()).thenReturn(0);
        assertTrue(mockListPlayerInGame.contains(playerName));
        assertTrue(mockListPlayerInGame.contains(opponentName));
        assertTrue(mockListGames.contains(gameMock));
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;
    }

    @Test (expected=spark.HaltException.class)
    public void removePieces(){
        given(request.session()).willReturn(session);
        given(request.cookie("playerName")).willReturn(playerName);
        given(checkersCenter.getGame(playerName)).willReturn(gameMock);
        given(checkersCenter.getInGamePlayers()).willReturn(mockListPlayerInGame);

        doNothing().when(gameMock).processTurn();
        doNothing().when(gameMock).clearMoves();
        when(gameMock.getWhitePiecesLeft()).thenReturn(1);
        when(gameMock.getRedPiecesLeft()).thenReturn(1);
        assertTrue(mockListPlayerInGame.contains(playerName));
        assertTrue(mockListPlayerInGame.contains(opponentName));
        assertTrue(mockListGames.contains(gameMock));
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;
    }
}