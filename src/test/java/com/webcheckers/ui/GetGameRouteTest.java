package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;

import org.junit.Before;
import org.junit.Test;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetGameRouteTest {

    private GetGameRoute CuT = new GetGameRoute(new CheckersCenter());

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

    @Test
    public void players_names() throws Exception {

        when(request.queryParams(eq("opponent"))).thenReturn("OpponentPlayer");
        when(request.queryParams(eq("playerName"))).thenReturn("Player");

        //Invoke test
        final ModelAndView result = CuT.handle(request, response);
        final Object model = result.getModel();
        final Map<String, Object> vm = (Map<String, Object>) model;

        assertNotNull(model);
        assertTrue(model instanceof Map);

        //Analyze results
        assertEquals(HomeController.TITLE_ATTR_MSG, vm.get(HomeController.TITLE_ATTR));
        assertEquals("OpponentPlayer", vm.get("opponentName"));
        assertEquals("Player", vm.get("playerName"));
        assertEquals(GetGameRoute.VIEW_NAME, result.getViewName());

    }

}