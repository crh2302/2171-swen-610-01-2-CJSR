package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The {@code GET /gameOver} route handler.
 *
 * Class used when player wins a game
 */
public class GetGameOverRoute implements TemplateViewRoute {

    private CheckersCenter checkersCenter;

    public GetGameOverRoute(final CheckersCenter checkersCenter){
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
        vm.put("title",Message.TITLE_ATTR_MSG);

        String playerName = request.queryParams("playerName");
        String opponentName = request.queryParams("opponent");
        vm.put("playerName",playerName);
        vm.put("opponentName",opponentName);

        switch(request.queryParams("message")){
            case "won":
                vm.put("messageTitle", "Congratulations!!!");
                vm.put("message", "Congratulations! You won the game!");
                break;
            case "lost":
                vm.put("messageTitle", "Oh dear.........");
                vm.put("message", "Oh dear, your opponent took your last piece.....sorry, but you lost the game :(");
                break;
            case "forfeit":
                vm.put("messageTitle", "Well look at that!");
                vm.put("message", "Your opponent resigned from the game, that means you win!");
                break;
        }
        return new ModelAndView(vm, "game-over.ftl");
    }
}
