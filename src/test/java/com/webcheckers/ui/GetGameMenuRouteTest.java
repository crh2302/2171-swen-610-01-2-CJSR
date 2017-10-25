package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Response;
import spark.Request;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetGameMenuRouteTest {
    CheckersCenter checkersCenter;
    CheckersCenter checkersCenterTest;
    GetGameMenuRoute CuT;
    GetGameMenuRoute getGameMenuRouteTest;
    Request request;
    Response response;
    ModelAndView mv;
    @Before
    public void setUp() throws Exception {
        checkersCenter=new CheckersCenter();
        CuT=new GetGameMenuRoute(checkersCenter);
        request=mock(Request.class);
        response=mock(Response.class);
        checkersCenterTest=mock(CheckersCenter.class);
        getGameMenuRouteTest= new GetGameMenuRoute(checkersCenterTest);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void handle() throws Exception {
    }

    @Test
    public void getPlayerNameString() throws Exception {

        when(request.queryParams("errorPathType")).thenReturn("inGame");
        final ModelAndView result=CuT.handle(request,response);
        final ModelAndView mv=getGameMenuRouteTest.handle(request,response);

        when(mv.getViewName()).thenReturn("game-menu.ftl");
        assertEquals(mv.getViewName(),result.getViewName());

    }

}