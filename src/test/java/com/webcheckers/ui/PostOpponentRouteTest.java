package com.webcheckers.ui;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    //attributes for holding mock objects
    private Request request;
    private Session session;
    private Response response;

    /**
     * set up mock objects
     */
    @Before
    public void setup() {
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);
    }

    /**
     * test invalid opponent condition, i.e. opponent chosen is in game
     */
    @Test
    public void invalid_opponent_not_in_game() {
        //Invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //Analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(CuT.isInGame(OPPONENT_STR), false);

        assertEquals(HomeController.TITLE_ATTR_MSG, vm.get(HomeController.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }

    @Test
    public void invalid_opponent_in_game() {
        //Invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //Analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(CuT.isInGame("sweet"), true);

        assertEquals(HomeController.TITLE_ATTR_MSG, vm.get(HomeController.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }

    /**
     * test opponent doesn't exist condition
     */
    @Test
    public void invalid_opponent_does_not_exist(){
        //invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(CuT.isInList(OPPONENT_STR), false);

        assertEquals(HomeController.TITLE_ATTR_MSG, vm.get(HomeController.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }

    /**
     * test opponent chosen is self condition
     */
    @Test
    public void is_playing_self(){
        //invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(CuT.isSelf(OPPONENT_STR, OPPONENT_STR), true);

        assertEquals(HomeController.TITLE_ATTR_MSG, vm.get(HomeController.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }

    /**
     * test opponent chosen is not self condition
     */
    @Test
    public void is_not_playing_self(){
        //invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        //analyze results
        assertNotNull(model);
        assertTrue(model instanceof Map);

        assertEquals(CuT.isSelf(OPPONENT_STR, "glabbidy"), false);

        assertEquals(HomeController.TITLE_ATTR_MSG, vm.get(HomeController.TITLE_ATTR));
        assertEquals(GetGameMenuRoute.VIEW_NAME, result.getViewName());
    }
}
