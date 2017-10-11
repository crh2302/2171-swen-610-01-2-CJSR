package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import spark.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The code for signing a user out and rendering the home page "/"
 */
public class GetSignoutRoute implements TemplateViewRoute {

    //
    // attributes
    //

    private final CheckersCenter checkersCenter;

    //
    // Constructor
    //

    /**
     *
     * @param checkersCenter
     *    The {@link CheckersCenter} for the applicatio
     */
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

        return signout(vm, session, request, response);
    }

    private ModelAndView signout(final Map<String, Object> vm, final Session session, Request request, Response response){
        checkersCenter.end(session, request);
        response.redirect("/");
        return new ModelAndView(vm, "home.ftl");
    }
}
