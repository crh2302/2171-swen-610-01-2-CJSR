package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.Board;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 *
 * The {@code GET /game} route handler.
 *
 */
public class GetGameRoute implements TemplateViewRoute {

    private final CheckersCenter checkersCenter;
    static final String VIEW_NAME = "game.ftl";

    public GetGameRoute(final CheckersCenter checkersCenter){
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
        vm.put(HomeController.TITLE_ATTR, HomeController.TITLE_ATTR_MSG);
        final String player = request.queryParams("playerName");
        final String opponent = request.queryParams("opponent");
        final String turn = request.queryParams("myTurn");

        vm.put("playerName", player);
        vm.put("opponentName", opponent);

        setColor(vm, turn);

        vm.put("isMyTurn", setTurn(turn));

        //render the game board
        vm.put("board", new Board());

        return new ModelAndView(vm , VIEW_NAME);
    }

    private boolean setTurn(String turn){
        return turn.equals("true");
    }

    private void setColor(Map<String, Object> vm, String turn){
        if(turn.equals("true")){
            vm.put("playerColor", "RED");
            vm.put("opponentColor", "WHITE");
        }
        else{
            vm.put("playerColor", "WHITE");
            vm.put("opponentColor", "RED");
        }
    }
}
