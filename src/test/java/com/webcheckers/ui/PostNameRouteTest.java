package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.*;

import java.util.ArrayList;
import java.util.Map;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class PostNameRouteTest
{
    private PostNameRoute  CuT;
    private Request request;
    private Response response;
    private CheckersCenter checkersCenter;
    private final String playerName = "Joseph";

    //private ArrayList allPlayerEmpty;
    private ArrayList allPlayerNotAvailable;
    private ArrayList allPlayerAvailable;

    @Before
    public void setUp() throws Exception
    {
        checkersCenter = mock(CheckersCenter.class);
        CuT = new PostNameRoute(checkersCenter);
        request = mock(Request.class);
        response = mock(Response.class);

//    allPlayerEmpty = new ArrayList();

        allPlayerAvailable = new ArrayList();
        allPlayerAvailable.add("Peter");

        allPlayerNotAvailable = new ArrayList();
        allPlayerNotAvailable.add(playerName);
        allPlayerNotAvailable.add("Peter");

    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test (expected=spark.HaltException.class)
    public void testStoreName_playerListEmpty() //Verify
    {
        when(request.queryParams("playerName")).thenReturn(playerName);
        final ModelAndView result = CuT.handle(request,response);
        assertNull(result);
        verify(response).redirect(String.format("/game-menu?playerName=%s&%s=none", playerName, PostOpponentRoute.ERROR_PATH_TYPE));
    }

    @Test (expected=spark.HaltException.class)
    public void testStoreName_nameAvailable()
    {
        when(request.queryParams("playerName")).thenReturn(playerName);
        when(checkersCenter.getAllPlayers()).thenReturn(allPlayerAvailable);
        final ModelAndView result = CuT.handle(request,response);
        assertNull(result);
        verify(response).redirect(String.format("/game-menu?playerName=%s&%s=none", playerName, PostOpponentRoute.ERROR_PATH_TYPE));
    }

    @Test
    public void testStoreName_nameNotAvailable()
    {

        when(request.queryParams("playerName")).thenReturn(playerName);
        when(checkersCenter.getAllPlayers()).thenReturn(allPlayerNotAvailable);
        final ModelAndView result = CuT.handle(request,response);
        assertNotNull(result);

        //   * model is a non-null Map
        final Object model = result.getModel();
        assertNotNull(model);
        assertTrue(model instanceof Map);
        //   * model contains all necessary View-Model data
        @SuppressWarnings("unchecked")
        final Map<String, Object> vm = (Map<String, Object>) model;
        assertEquals(Message.TITLE_ATTR_MSG,vm.get("title"));
        assertEquals(GetSigninRoute.LOGIN_ATTR_MSG,vm.get("loginMessage"));
    }
}