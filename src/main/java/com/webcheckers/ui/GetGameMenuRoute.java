package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import spark.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * The {@code GET /game-menu} route handler.
 *
 */
public class GetGameMenuRoute implements TemplateViewRoute {

    private final CheckersCenter checkersCenter;

    public GetGameMenuRoute(final CheckersCenter checkersCenter){
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

        vm.put("title",HomeController.TITLE_ATTR_MSG);
        vm.put("playerName", request.queryParams("playerName"));
        vm.put("playerNames", checkersCenter.getAllPlayers());

        //determining which error to display
        switch(request.queryParams("errorPathType")){
            case "inGame":
                vm.put("opponentError", PostOpponentRoute.OPPONENT_ERROR_MSG);
                break;
            case "selfPlay":
                vm.put("opponentError", PostOpponentRoute.SELF_PLAY_ERROR_MSG);
                break;
            case "noExistence":
                vm.put("opponentError", PostOpponentRoute.INVALID_OPP_MSG);
                break;
            case "leftGame":
                this.checkersCenter.getInGamePlayers().remove(request.queryParams(("playerName")));
                this.checkersCenter.getInGamePlayers().remove(request.queryParams(("opponent")));
                break;
            default:
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
