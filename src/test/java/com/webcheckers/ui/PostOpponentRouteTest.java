package com.webcheckers.ui;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.webcheckers.Application;
import org.junit.Before;
import org.junit.Test;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import com.webcheckers.appl.CheckersCenter;


public class PostOpponentRouteTest {

    //attributes
    private PostOpponentRoute CuT = new PostOpponentRoute(new CheckersCenter());
    private final String OPPONENT_STR = "hello";
	private final String OPPONENT_STR_2 = "dkslfk";
    private List inGamePlayerAvailable;
    private CheckersCenter checkersCenter;

    //attributes for holding mock objects
    private Request request;
    private Session session;
    private Response response;

    /**
     * set up mock objects
     */
    @Before
    public void setup() {
        checkersCenter = mock(CheckersCenter.class);
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);

        inGamePlayerAvailable = new ArrayList();
        inGamePlayerAvailable.add(OPPONENT_STR);
    }

    /**
     * test invalid opponent condition, i.e. opponent chosen is in game
     */
    @Test (expected=spark.HaltException.class)
    public void invalid_opponent_not_in_game() {
        //Invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //Analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(inGamePlayerAvailable.contains(OPPONENT_STR_2), false);

        assertEquals(Message.TITLE_ATTR_MSG, vm.get(Message.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }

    @Test (expected=spark.HaltException.class)
    public void invalid_opponent_in_game() {
        //Invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //Analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(inGamePlayerAvailable.contains(OPPONENT_STR), true);

        assertEquals(Message.TITLE_ATTR_MSG, vm.get(Message.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }

    /**
     * test opponent doesn't exist condition
     */
    @Test (expected=spark.HaltException.class)
    public void invalid_opponent_does_not_exist(){
        //invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(CuT.isInList(OPPONENT_STR), false);

        assertEquals(Message.TITLE_ATTR_MSG, vm.get(Message.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }

    /**
     * test opponent chosen is self condition
     */
    @Test (expected=spark.HaltException.class)
    public void is_playing_self(){
        //invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(CuT.isSelf(OPPONENT_STR, OPPONENT_STR), true);

        assertEquals(Message.TITLE_ATTR_MSG, vm.get(Message.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }

    /**
     * test opponent chosen is not self condition
     */
    @Test (expected=spark.HaltException.class)
    public void is_not_playing_self(){
        //invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(CuT.isSelf(OPPONENT_STR, OPPONENT_STR_2), false);

        assertEquals(Message.TITLE_ATTR_MSG, vm.get(Message.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }
}
