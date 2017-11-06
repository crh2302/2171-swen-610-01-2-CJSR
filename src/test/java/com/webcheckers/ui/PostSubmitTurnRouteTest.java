package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostSubmitTurnRouteTest {
    //attributes for holding mock objects
    private Request request;
    private Session session;
    private Response response;
    private CheckersCenter checkersCenter;
    private CheckersGame game;

    private String playerName = "julio";
    private String opponentName = "caesar";

    PostSubmitTurnRoute cut = new PostSubmitTurnRoute(new CheckersCenter());

    @Before
    public void setUp() throws Exception {
        checkersCenter = mock(CheckersCenter.class);
        game = mock(CheckersGame.class);

        request = mock(Request.class);
        session = mock(Session.class);

        when(request.session()).thenReturn(session);
        response = mock(Response.class);

    }

    @Test (expected=NullPointerException.class)
    public void is_Player_Turn(){
        final ModelAndView result = cut.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        assertNotNull(model);
        assertTrue(model instanceof Map);
    }

    @Test
    public void process_turn(){
        assertFalse(game.processTurn());
    }
}