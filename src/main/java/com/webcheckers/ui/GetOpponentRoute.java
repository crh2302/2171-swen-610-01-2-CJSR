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
 *
 * The {@code GET /opponent} route handler.
 *
 */
public class GetOpponentRoute implements TemplateViewRoute {

    //
    // constants
    //

    static final String OPPONENT_ERROR_MSG = "Chosen opponent is already in a game. Please choose another.";

    //
    // attributes
    //

    private final CheckersCenter checkersCenter;


    /**
     * The constructor for the {@code GET /opponent} route handler.
     *
     * @param checkersCenter
     *    The {@link CheckersCenter} for the application.
     */
    GetOpponentRoute(final CheckersCenter checkersCenter) {
        // validation
        Objects.requireNonNull(checkersCenter, "checkersCenter must not be null");
        this.checkersCenter = checkersCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        // start building the View-Model
        final Map<String, Object> vm = new HashMap<>();

        String playerName = request.queryParams(("playerName"));
        String opponent = request.queryParams("opponent");
        boolean playerGameCheck = isInGame(opponent);

        if(playerGameCheck){
            response.redirect(String.format("/game-menu?playerName=%s&errorPath=true",playerName));
        }
        else{
            response.redirect(String.format("/game?opponent=%s&playerName=%s",opponent,playerName));
        }

        return null;
    }

    /**
     *
     * @param opponentName
     *
     * @return
     *       boolean to distinguish whether or not a chosen opponent is already in a game
     */
    private boolean isInGame(String opponentName){
        return isInGame(opponentName);
    }
}
