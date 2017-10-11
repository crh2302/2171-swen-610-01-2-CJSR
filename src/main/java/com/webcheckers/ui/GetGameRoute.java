package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.Board;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * The {@code GET /game} route handler.
 *
 */
public class GetGameRoute implements TemplateViewRoute {


    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> vm = new HashMap<>();
        vm.put("title", HomeController.TITLE_ATTR_MSG);
        final String player = request.queryParams("playerName");
        final String opponent = request.queryParams("opponent");

        vm.put("playerName", player);
        vm.put("opponentName", opponent);

        vm.put("playerColor", "RED");
        vm.put("opponentColor", "WHITE");

        vm.put("isMyTurn", false);

        if(!CheckersCenter.inGamePlayers.contains(player)) {
            CheckersCenter.inGamePlayers.add(player);
        }
        if(!CheckersCenter.inGamePlayers.contains(opponent)) {
            CheckersCenter.inGamePlayers.add(opponent);
        }

        //render the game board
        Board newBoard = new Board();
        vm.put("board", newBoard);

        return new ModelAndView(vm , "game.ftl");
    }
}
