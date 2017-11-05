package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.appl.CheckersCenter;
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



    static final String VIEW_NAME = "home.ftl";
    private final CheckersCenter checkersCenter;

    public HomeController(final CheckersCenter checkersCenter){
        // validation
        Objects.requireNonNull(checkersCenter, "checkersCenter must not be null");
        this.checkersCenter = checkersCenter;
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put(Message.TITLE_ATTR, Message.TITLE_ATTR_MSG);
        final Session httpSession = request.session();

        if (httpSession.isNew()) {
            return new ModelAndView(vm, VIEW_NAME);
        }
        else {
            return signout(vm, httpSession, request);
        }

    }

    private ModelAndView signout(final Map<String, Object> vm, final Session session, Request request){
        checkersCenter.end(session, request);
        vm.put(Message.TITLE_ATTR, Message.TITLE_ATTR_MSG);

        return new ModelAndView(vm, VIEW_NAME);
    }
}