package com.webcheckers.ui;

import spark.*;
import java.util.HashMap;
import java.util.Map;

public class GetGameMenuRoute implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();


       return new ModelAndView(vm, "game-menu.ftl");
    }

    public static String getNameString(Request request){
        return request.queryParams("playerName");
    }

}
