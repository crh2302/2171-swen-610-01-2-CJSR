package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.halt;

import java.util.Objects;

/**
 * The {@code POST /submitTurn} route handler
 *
 * Called when the player submits a turn to the server
 */
public class PostSubmitTurnRoute implements Route {

    private final CheckersCenter checkersCenter;
    private CheckersGame game;

    PostSubmitTurnRoute(final CheckersCenter checkersCenter){
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
        String opponentName = request.cookie("opponentName");

        game = checkersCenter.getGame(request.cookie("playerName"));
        game.processTurn();
        game.clearMoves();

        if(game.getWhitePiecesLeft() == 0 || game.getRedPiecesLeft() == 0){
            checkersCenter.removePlayers(playerName,opponentName);
            game.removeGame(game,checkersCenter);
            response.redirect(String.format("/game-over?playerName=%s&opponentName=%s&message=won",playerName,opponentName));
        }
        if(game.isPlayerTurn(playerName)){
            response.redirect(String.format("/game?playerName=%s&opponent=%s",opponentName,playerName));
        }
        else{
            response.redirect(String.format("/game?playerName=%s&opponent=%s",playerName,opponentName));
        }
        halt();
        return null;
    }
}
