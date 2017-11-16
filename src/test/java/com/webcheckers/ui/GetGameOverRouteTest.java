package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetGameOverRouteTest {
    CheckersCenter checkersCenter;
    CheckersCenter checkersCenterTest;
    GetGameOverRoute CuT;
    GetGameOverRoute getGameMenuRouteTest;
    Request request;
    Response response;

    @Before
    public void setUp() throws Exception {
        checkersCenter = new CheckersCenter();
        CuT = new GetGameOverRoute(checkersCenter);
        request=mock(Request.class);
        response=mock(Response.class);
        checkersCenterTest=mock(CheckersCenter.class);
        getGameMenuRouteTest= new GetGameOverRoute(checkersCenterTest);
    }

    @Test
    public void you_lost_test(){
        when(request.queryParams("message")).thenReturn("lost");
        final ModelAndView result=CuT.handle(request,response);
        final ModelAndView mv = getGameMenuRouteTest.handle(request,response);

        assertEquals(mv.getViewName(),result.getViewName());
    }

    @Test
    public void you_won_test(){
        when(request.queryParams("message")).thenReturn("won");
        final ModelAndView result = CuT.handle(request,response);
        final ModelAndView mv = getGameMenuRouteTest.handle(request,response);

        assertEquals(mv.getViewName(),result.getViewName());
    }

    @Test
    public void resigned_game_test(){
        when(request.queryParams("message")).thenReturn("forfeit");
        final ModelAndView result = CuT.handle(request,response);
        final ModelAndView mv = getGameMenuRouteTest.handle(request,response);

        assertEquals(mv.getViewName(),result.getViewName());
    }
}