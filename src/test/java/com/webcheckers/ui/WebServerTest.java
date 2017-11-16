package com.webcheckers.ui;
import com.webcheckers.appl.CheckersCenter;
import org.junit.Before;
import org.junit.Test;
import spark.TemplateEngine;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class WebServerTest {
    TemplateEngine templateEngineMock;
    CheckersCenter checkersCenterMock;
    WebServer CuT;

    @Before
    public void setUp() throws Exception {
        checkersCenterMock = mock(CheckersCenter.class);
        templateEngineMock = mock(TemplateEngine.class);
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