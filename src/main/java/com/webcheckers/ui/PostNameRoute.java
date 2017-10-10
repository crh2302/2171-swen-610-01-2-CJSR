package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import spark.*;

import java.util.*;


public class PostNameRoute implements TemplateViewRoute {

    private static final String ERROR_ATTR_MSG = "Username already taken. Please enter another.";

    /**
     * {@inheritDoc}
     */

    //
    // Attributes
    //

    private final CheckersCenter checkersCenter;

    //
    // Constructor
    //

    /**
     * The constructor for the {@code POST /name} route handler.
     *
     * @param checkersCenter
     *    The {@link CheckersCenter} for the application.
     *
     * @throws NullPointerException
     *    when the {@code gameCenter} parameter is null
     */
    PostNameRoute(final CheckersCenter checkersCenter) {
        // validation
        Objects.requireNonNull(checkersCenter, "gameCenter must not be null");
        //
        this.checkersCenter = checkersCenter;
    }


    @Override
    public ModelAndView handle(Request request, Response response) {
        // start building the View-Model
        final Map<String, Object> vm = new HashMap<>();
        final Session session = request.session();

        String name = request.queryParams("playerName");
        return storeName(vm, session,name);
    }

    public boolean nameAvailable(List<String> playerNames, String name){
        return playerNames.contains(name);
    }

    public  ModelAndView storeName(Map<String, Object> vm, Session session, String name){
        if(this.checkersCenter.isPlayerListEmpty())
        {
            checkersCenter.add(name);
            return successfulAdd(vm, name, this.checkersCenter.getAllPlayers());
        }
        else
        {
            boolean nameAvailable = nameAvailable(this.checkersCenter.getAllPlayers(),name);
            if(!nameAvailable)
            {
                checkersCenter.add(name);
                return successfulAdd(vm, name, this.checkersCenter.getAllPlayers());
            }
            else
            {
                return error();
            }
        }
    }

    public synchronized ModelAndView error(){
        final Map<String, Object> vm = new HashMap<>();

        vm.put("title", HomeController.TITLE_ATTR_MSG);
        vm.put("loginMessage", GetSigninRoute.LOGIN_ATTR_MSG);
        vm.put("errorMessage", ERROR_ATTR_MSG);
        return new ModelAndView(vm, "signin.ftl");
    }

    public ModelAndView successfulAdd(Map<String, Object> vm, String name, List<String> playerNames ){
        vm.put("title",HomeController.TITLE_ATTR_MSG);
        vm.put("playerName", name);
        vm.put("playerNames",playerNames);
        return new ModelAndView(vm, "game-menu.ftl");
    }


}
