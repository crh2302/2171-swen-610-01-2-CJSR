package com.webcheckers.ui;

import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PostNameRoute implements TemplateViewRoute {

    public static final String ERROR_ATTR_MSG = "Username already taken. Please enter another.";
    public static List<String> playerNames;

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        // start building the View-Model
        final Map<String, Object> vm = new HashMap<>();
        final Session session = request.session();

        String name = request.queryParams("playerName");
        return storeName(vm, session,name);
    }

    public static boolean nameAvailable(List<String> playerNames, String name){
        return playerNames.contains(name);
    }

    public static ModelAndView storeName(Map<String, Object> vm, Session session, String name){
        playerNames = session.attribute("playerNames");
        if(playerNames == null){
            playerNames = new ArrayList<>();
            session.attribute("playerNames", playerNames);
            playerNames.add(name);

            return successfulAdd(vm, name, playerNames);
        }
        else{
            boolean nameAvailable = PostNameRoute.nameAvailable(playerNames,name);
            if(!nameAvailable){
                playerNames.add(name);
                return successfulAdd(vm, name, playerNames);
            }
            else{
                return PostNameRoute.error();
            }
        }
    }

    public static synchronized ModelAndView error(){
        final Map<String, Object> vm = new HashMap<>();

        vm.put("title", HomeController.TITLE_ATTR_MSG);
        vm.put("loginMessage", GetSigninRoute.LOGIN_ATTR_MSG);
        vm.put("errorMessage", ERROR_ATTR_MSG);
        return new ModelAndView(vm, "signin.ftl");
    }

    public static ModelAndView successfulAdd(Map<String, Object> vm, String name, List<String> playerNames ){
        vm.put("title",HomeController.TITLE_ATTR_MSG);
        vm.put("playerName", name);
        vm.put("playerNames",playerNames);
        return new ModelAndView(vm, "game-menu.ftl");
    }


}
