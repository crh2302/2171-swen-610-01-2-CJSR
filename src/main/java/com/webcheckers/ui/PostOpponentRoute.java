package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
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
 * The {@code GET /opponent} route handler.
 *
 */
public class PostOpponentRoute implements TemplateViewRoute {

    //
    // constants
    //

    static final String ERROR_PATH_TYPE = "errorPathType";
    static final String SELF_PLAY_ERROR_MSG = "Invalid Opponent. You can't play against yourself!";
    static final String INVALID_OPP_MSG = "Entered opponent does not exist.";
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
    PostOpponentRoute(final CheckersCenter checkersCenter) {
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
        boolean playerListCheck = isInList(opponent);

        if(!playerListCheck){
            return error(response, playerName, false);
        }
        else if(playerName.equals(opponent)){
            return error(response, opponent, true);
        }
        else {
            boolean playerGameCheck = isInGame(opponent);

            if (playerGameCheck) {
                response.redirect(String.format("/game-menu?playerName=%s&%s=inGame", playerName, ERROR_PATH_TYPE));
            } else {
                response.redirect(String.format("/game?opponent=%s&playerName=%s", opponent, playerName));
            }
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
        List<String> opponent = checkersCenter.getInGamePlayers();
        if(opponent.contains(opponentName)){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     *
     * @param opponentName
     *
     * @return
     *      a boolean to determine whether or not opponent name submitted is in the list
     */
    private boolean isInList(String opponentName){
        List<String> opponent = checkersCenter.getAllPlayers();
        return opponent.contains(opponentName);
    }


    /**
     * Redirects player to game menu with different error path type, dependent on boolean value of selfPlay
     *
     * @param response
     * @param playerName
     * @param selfPlay
     *
     * @return
     *      null
     */
    public synchronized ModelAndView error(Response response, String playerName, boolean selfPlay)
    {
        //if player tried to play against him self equals true
        if(selfPlay) {
            response.redirect(String.format("/game-menu?playerName=%s&%s=selfPlay", playerName, ERROR_PATH_TYPE));
        }
        else {
            response.redirect(String.format("/game-menu?playerName=%s&%s=noExistence", playerName, ERROR_PATH_TYPE));
        }

        return null;
    }
}
