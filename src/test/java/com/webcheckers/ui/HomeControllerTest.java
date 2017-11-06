package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.*;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomeControllerTest
{
    private HomeController CuT ;
    private CheckersCenter checkersCenterMock;
    private Request requestMock;
    private Response responseMock;
    private Session sessionMock;


    @Before
    public void setUp() throws Exception
    {
        //Given
        checkersCenterMock = mock(CheckersCenter.class);
        CuT = new HomeController(checkersCenterMock);
        requestMock = mock(Request.class);
        responseMock = mock(Response.class);
        sessionMock = mock(Session.class);


    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void test_contructor()
    {
        assertNotNull(CuT);
    }

    @Test(expected = NullPointerException.class)
    public void test_contructor_nullParameter()
    {
        new HomeController(null);
    }

    @Test
    public void test_newSession()
    {
        //When
        when(requestMock.session()).thenReturn(sessionMock);
        when(sessionMock.isNew()).thenReturn(true);
        //Then
        final ModelAndView result = CuT.handle(requestMock,responseMock);

        //   * model is a non-null Map
        final Object model = result.getModel();
        assertNotNull(model);
        assertTrue(model instanceof Map);

        final Map<String, Object> vm = (Map<String, Object>) model;
        assertEquals(Message.TITLE_ATTR_MSG,vm.get(Message.TITLE_ATTR));

    }
    @Test
    public void test_NotnewSession()
    {
        //When
        when(requestMock.session()).thenReturn(sessionMock);
        when(sessionMock.isNew()).thenReturn(false);
        //Then
        final ModelAndView result = CuT.handle(requestMock,responseMock);

        //   * model is a non-null Map
        final Object model = result.getModel();
        assertNotNull(model);
        assertTrue(model instanceof Map);

        final Map<String, Object> vm = (Map<String, Object>) model;
        assertEquals(Message.TITLE_ATTR_MSG,vm.get(Message.TITLE_ATTR));

    }
}
