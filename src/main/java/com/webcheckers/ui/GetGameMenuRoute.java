package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;
import spark.*;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.halt;

/**
 *
 * The {@code GET /game-menu} route handler.
 *
 */
public class GetGameMenuRoute implements TemplateViewRoute {

    private final CheckersCenter checkersCenter;

    static List<String> playerList;
    static List<String> opponentList;
    private CheckersGame game;

    static final String VIEW_NAME = "game-menu.ftl";

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
        String playerName = request.queryParams("playerName");

        vm.put(Message.TITLE_ATTR,Message.TITLE_ATTR_MSG);
        vm.put("playerName", playerName);
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
            default:
        }
        navigatePlayer(playerName,response);

        return new ModelAndView(vm, VIEW_NAME);
    }

    private void navigatePlayer(String playerName, Response response){
        opponentList = checkersCenter.getGamesList().stream()
                .map(CheckersGame::getOpponent)
                .collect(Collectors.toList());
        playerList = checkersCenter.getGamesList().stream()
                .map(CheckersGame::getPlayer)
                .collect(Collectors.toList());

        if(opponentList.contains(playerName)){
            for(int x = 0; x < opponentList.size(); x++){
                if(opponentList.get(x).equals(playerName)){
                    String opponent = playerList.get(x);
                    response.redirect(String.format("/game?opponent=%s&playerName=%s&myTurn=false",opponent,playerName));
                }
            }
        }
    }
}