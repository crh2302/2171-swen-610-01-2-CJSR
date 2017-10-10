package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetSignoutRoute implements TemplateViewRoute {
    private final CheckersCenter checkersCenter;

    GetSignoutRoute(final CheckersCenter checkersCenter) {
        // validation
        Objects.requireNonNull(checkersCenter, "gameCenter must not be null");
        //
        this.checkersCenter = checkersCenter;
    }


    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        final Session session = request.session();

        return signout(vm, session, request);
    }

    private ModelAndView signout(final Map<String, Object> vm, final Session session, Request request){
        checkersCenter.end(session, request);
        vm.put("title", HomeController.TITLE_ATTR_MSG);
        return new ModelAndView(vm, "home.ftl");
    }
}
