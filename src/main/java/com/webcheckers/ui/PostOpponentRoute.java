package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.CheckersGame;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

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
        vm.put(HomeController.TITLE_ATTR, HomeController.TITLE_ATTR_MSG);

        String playerName = request.queryParams(("playerName"));
        String opponent = request.queryParams("opponent");

        if(!isInList(opponent)){
            response.redirect(String.format("/game-menu?playerName=%s&%s=noExistence", playerName, ERROR_PATH_TYPE));
            halt();
        }
        else if(isSelf(playerName,opponent)){
            request.attribute("playerName",playerName);
            response.redirect(String.format("/game-menu?playerName=%s&%s=selfPlay", playerName, ERROR_PATH_TYPE));
            halt();
        }
        else {
            if (isInGame(opponent)) {
                response.redirect(String.format("/game-menu?playerName=%s&%s=inGame", playerName, ERROR_PATH_TYPE));
                halt();
            } else {
                checkersCenter.getInGamePlayers().add(opponent);
                checkersCenter.getInGamePlayers().add(playerName);
                checkersCenter.getGamesList().add(new CheckersGame(playerName,opponent));
               // set playerName to be retrieved in PostValidateMoveRoute
                response.cookie("playerName",playerName);
                response.redirect(String.format("/game?opponent=%s&playerName=%s&myTurn=true", opponent, playerName));
                halt();
            }
        }
        return new ModelAndView(vm, GetGameMenuRoute.VIEW_NAME);
    }

    /**
     *
     * @param opponentName
     *
     * @return
     *       boolean to distinguish whether or not a chosen opponent is already in a game
     */
    public boolean isInGame(String opponentName){
        List<String> opponents = checkersCenter.getInGamePlayers();
        return opponents.contains(opponentName);
    }


    /**
     *
     * @param opponentName
     *
     * @return
     *      a boolean to determine whether or not opponent name submitted is in the list
     */
    public boolean isInList(String opponentName){
        List<String> opponents = checkersCenter.getAllPlayers();
        return opponents.contains(opponentName);
    }

    /**
     *
     * @param playerName,opponentName
     *
     * @return
     *       boolean to distinguish whether or not a chosen opponent is the player themselves
     */
    public boolean isSelf(String playerName,String opponentName){
        return playerName.equals(opponentName);
    }
}