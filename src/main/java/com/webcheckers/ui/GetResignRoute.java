package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;
import spark.*;

import java.util.Objects;

import static spark.Spark.halt;

/**
 * The {@code GET /resignGame} route handler.
 *
 * Class used when player resigns from the game he/she is in
 */
public class GetResignRoute implements Route {

    private final CheckersCenter checkersCenter;
    private CheckersGame game;

    GetResignRoute(final CheckersCenter checkersCenter){
        //Validate that GameCenter is not null
        Objects.requireNonNull(checkersCenter, "gameCenter must not be null");
        this.checkersCenter = checkersCenter;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        String playerName = request.cookie("playerName");

        game = checkersCenter.getGame(playerName);

        checkersCenter.getInGamePlayers().remove(request.cookie("playerName"));
        checkersCenter.getInGamePlayers().remove(request.cookie("opponentName"));

        response.redirect(String.format("/game-menu?playerName=%s&opponent=%s&errorPathType=none",
                request.cookie("playerName"),request.cookie("opponentName")));
        halt();
        return null;
    }
}
