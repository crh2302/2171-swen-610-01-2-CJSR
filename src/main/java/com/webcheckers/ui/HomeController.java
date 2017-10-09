package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

import spark.*;

import static spark.Spark.halt;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class HomeController implements TemplateViewRoute {

  static final String TITLE_ATTR_MSG = "Welcome!";

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", TITLE_ATTR_MSG);

    final Session httpSession = request.session();
    if (httpSession.isNew()){
      vm.put("playerNames", PostNameRoute.playerNames);
      return new ModelAndView(vm, "home.ftl");
    }
    else {
      // there is a game already being played
      // so redirect the user to the Game view
      response.redirect(WebServer.GAMEMENU_URL);
      halt();
    }

    return new ModelAndView(vm , "home.ftl");
  }
}