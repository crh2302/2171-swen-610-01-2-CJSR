package com.webcheckers.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;


public class PostNameRoute implements TemplateViewRoute {


    static final String NAME_PARAM = "playersName";
    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        // start building the View-Model
        final Map<String, Object> vm = new HashMap<>();
        final Session session = request.session();

        //request player name
        final String nameString = request.queryParams(NAME_PARAM);
        error(vm, nameString);

        if(nameString.equals("jeff")) {
            return new ModelAndView(vm, "signin.ftl");
        }
        else{
            return new ModelAndView(vm, "signin.ftl");
        }
    }


    private ModelAndView error(final Map<String, Object> vm, final String nameString){

        vm.put("title", HomeController.TITLE_ATTR_MSG);
        vm.put("loginMessage", GetSigninRoute.LOGIN_ATTR_MSG);
        vm.put("playerName",nameString);
        return new ModelAndView(vm, "signin.ftl");
    }


}
