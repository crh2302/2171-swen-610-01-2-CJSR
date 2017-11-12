package com.webcheckers.ui;
import com.webcheckers.appl.CheckersCenter;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class WebServerTest {


    TemplateEngine templateEngineMock;
    CheckersCenter checkersCenterMock;

    WebServer CuT;
    Request request;
    Response response;

    @Before
    public void setUp() throws Exception {
        checkersCenterMock = mock(CheckersCenter.class);
        templateEngineMock = mock(TemplateEngine.class);
        request = mock(Request.class);
        response = mock(Response.class);
        CuT = new WebServer(checkersCenterMock, templateEngineMock);
    }

    @Test
    public void test_initialize()
    {
        assertNotNull(CuT);
        CuT.initialize();
        assertNotNull(CuT);
    }
}