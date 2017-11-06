package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.Board;
import com.webcheckers.model.CheckersGame;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PostValidateMoveRouteTest {

    private CheckersCenter checkersCenter;
    private CheckersGame game;
    private Board board;
    private PostValidateMoveRoute CuT = new PostValidateMoveRoute(new CheckersCenter());

    //attributes for holding mock objects
    private Request request;
    private Session session;
    private Response response;

    @Before
    public void setup() {
        checkersCenter = mock(CheckersCenter.class);
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);


    }

    @Test (expected = NullPointerException.class)
    public void handle() throws Exception {
        //Invoke test
        final Object result = CuT.handle(request, response);

        //Analyze results
        assertNotNull(result);
    }

    @Test (expected = NullPointerException.class)
    public void getting_board() throws Exception {
        when(request.cookie("playerName")).thenReturn("player");

        //do more tests here
    }
}