package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

import static spark.Spark.halt;

public class PostSubmitTurnRoute implements Route {
    private final CheckersCenter checkersCenter;

    private CheckersGame game;

    PostSubmitTurnRoute(final CheckersCenter checkersCenter){
        //Validate that GameCenter is not null
        Objects.requireNonNull(checkersCenter, "gameCenter must not be null");
        this.checkersCenter = checkersCenter;
    }


    @Override
    public ModelAndView handle(Request request, Response response) {

        String playerName = request.cookie("playerName");
        String opponentName = request.cookie("opponentName");

        game = checkersCenter.getGame(request.cookie("playerName"));
        game.processPlayerTurn();
        game.clearMoves();

        if(game.isTurn(playerName)){
            response.redirect(String.format("/game?playerName=%s&opponent=%s",opponentName,playerName));
        }
        else{
            response.redirect(String.format("/game?playerName=%s&opponent=%s",playerName,opponentName));
        }
        halt();
        return null;
    }
}
