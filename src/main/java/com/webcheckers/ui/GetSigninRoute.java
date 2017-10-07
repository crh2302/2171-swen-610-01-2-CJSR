package com.webcheckers.ui;


import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GetSigninRoute implements TemplateViewRoute {

    static final String LOGIN_ATTR_MSG = "Welcome player! Please enter your username below!";

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", HomeController.TITLE_ATTR_MSG);
        vm.put("loginMessage", LOGIN_ATTR_MSG);
        vm.put("playerName", "  ");
        return new ModelAndView(vm, "signin.ftl");
    }
}