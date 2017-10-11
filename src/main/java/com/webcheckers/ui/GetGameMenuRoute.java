package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import spark.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * The {@code GET /game-menu} route handler.
 *
 */
public class GetGameMenuRoute implements TemplateViewRoute {


    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();

        vm.put("title",HomeController.TITLE_ATTR_MSG);
        vm.put("playerName", request.queryParams("playerName"));
        vm.put("playerNames", CheckersCenter.allPlayers);

        if(request.queryParams("errorPath").equals("true")){
            vm.put("opponentError", GetOpponentRoute.OPPONENT_ERROR_MSG);
        }

        return new ModelAndView(vm, "game-menu.ftl");
    }

    /**
     *
     * @param request
     *
     *
     * @return
     *      the value of playerName in URL parameters
     */
    public static String getPlayerNameString(Request request){
        return request.queryParams("playerName");
    }

}
