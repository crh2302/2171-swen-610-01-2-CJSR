package com.webcheckers.ui;


import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * The {@code GET /signin} route handler.
 *
 */
public class GetSigninRoute implements TemplateViewRoute {

    //
    // Constants
    //

    static final String LOGIN_ATTR_MSG = "Welcome player! Please enter your username below!";
    static final String VIEW_NAME = "signin.ftl";



    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put(Message.TITLE_ATTR, Message.TITLE_ATTR_MSG);
        vm.put(PostNameRoute.LOGIN_ATTR, LOGIN_ATTR_MSG);

        return new ModelAndView(vm, VIEW_NAME);
    }
}