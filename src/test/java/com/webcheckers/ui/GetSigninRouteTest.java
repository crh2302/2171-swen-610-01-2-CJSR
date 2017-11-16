package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class GetSigninRouteTest
{

  private GetSigninRoute  CuT;
  private Request requestMock;
  private Response responseMock;
  private CheckersCenter checkersCenterMock;
  @Before
  public void setUp() throws Exception
  {
    requestMock = mock(Request.class);
    responseMock = mock(Response.class);
    checkersCenterMock = mock(CheckersCenter.class);
    CuT = new GetSigninRoute();
  }

  @Test
  public void handle() throws Exception
  {
    final ModelAndView result = CuT.handle(requestMock,responseMock);

    assertNotNull(result);

    //   * model is a non-null Map
    final Object model = result.getModel();
    assertNotNull(model);
    assertTrue(model instanceof Map);
    //   * model contains all necessary View-Model data
    @SuppressWarnings("unchecked")
    final Map<String, Object> vm = (Map<String, Object>) model;
    assertEquals(Message.TITLE_ATTR_MSG,vm.get(Message.TITLE_ATTR));
    assertEquals(GetSigninRoute.LOGIN_ATTR_MSG,vm.get(PostNameRoute.LOGIN_ATTR));

  }

}