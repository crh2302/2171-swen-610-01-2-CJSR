package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class WebServerTest {
    TemplateEngine templateEngine;
    CheckersCenter checkersCenter;

    TemplateEngine templateEngineTest;
    CheckersCenter checkersCenterTest;

    WebServer CuT;
    WebServer webServerTest;

    Request request;
    Response response;

    @Before
    public void setUp() throws Exception {
        checkersCenter = new CheckersCenter();
        checkersCenterTest = mock(CheckersCenter.class);

        request = mock(Request.class);
        response = mock(Response.class);

        CuT = new WebServer(checkersCenter, templateEngine);
        webServerTest = new WebServer(checkersCenterTest, templateEngineTest);
    }
}