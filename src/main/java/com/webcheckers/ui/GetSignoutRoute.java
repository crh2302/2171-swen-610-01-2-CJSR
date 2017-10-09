package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetSignoutRoute implements TemplateViewRoute {


    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        final Session session = request.session();

        return signout(vm, session, request);
    }

    private ModelAndView signout(final Map<String, Object> vm, final Session session, Request request){
        CheckersCenter game = new CheckersCenter();
        game.end(session, request);

        vm.put("title", HomeController.TITLE_ATTR_MSG);
        return new ModelAndView(vm, "home.ftl");
    }
}
