package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

import spark.*;

import static spark.Spark.halt;

/**
 *
 * The {@code GET /} route handler, aka the home page
 *
 * Landing page for when user first enters application, and when user signs out
 *
 */
public class HomeController implements TemplateViewRoute {

    //
    // Constants
    //

    static final String TITLE_ATTR_MSG = "Welcome!";

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", TITLE_ATTR_MSG);

        return new ModelAndView(vm , "home.ftl");
    }
}