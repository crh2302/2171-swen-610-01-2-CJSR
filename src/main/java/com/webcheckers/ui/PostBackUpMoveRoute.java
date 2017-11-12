package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

import static spark.Spark.halt;

public class PostBackUpMoveRoute implements Route {

    private final CheckersCenter checkersCenter;
    private CheckersGame game;

    PostBackUpMoveRoute(final CheckersCenter checkersCenter) {
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
        game.backUpMove();

        halt();
        return null;
    }
}
