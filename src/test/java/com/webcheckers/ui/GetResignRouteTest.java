package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.HaltException;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetResignRouteTest {

    private CheckersCenter checkersCenter;
    private CheckersGame game;
    private GetResignRoute CuT=new GetResignRoute(new CheckersCenter());

    //attributes for holding mock objects
    private Request request;
    private Session session;
    private Response response;

    @Before
    public void setUp() throws Exception {
        checkersCenter = mock(CheckersCenter.class);
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test (expected=spark.HaltException.class)
    public void handle() throws Exception {

        when(request.cookie("playerName")).thenReturn("Ross");
        when(request.cookie("opponent")).thenReturn("Rucha");
        //Invoke test
        final Object result = CuT.handle(request, response);

        //Analyze results
        assertNotNull(result);
        verify(response).redirect(String.format("/game-menu?playerName=%s&opponent=%s&errorPathType=none", "playerName", PostOpponentRoute.ERROR_PATH_TYPE));
    }

}