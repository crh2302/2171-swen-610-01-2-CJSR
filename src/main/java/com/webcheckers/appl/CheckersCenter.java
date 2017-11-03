package com.webcheckers.appl;

import com.webcheckers.model.CheckersGame;
import spark.Request;
import spark.Session;
import java.util.*;

/**
 *
 * The object to coordinate the state of the application.
 *
 */
public class CheckersCenter {

    //
    // attributes
    //

    private List<CheckersGame> gameList;
    private List<String> allPlayers;
    private List<String> inGamePlayers;

    //
    // constructor
    //

    public CheckersCenter() {
        gameList = new ArrayList<>();
        allPlayers = new ArrayList<>();
        inGamePlayers = new ArrayList<>();
    }


    /**
     * Ends the user's session, freeing up their name and logging them out
     *
     * @param session
     * @param request
     *
     */
    public void end(Session session, Request request) {
        // validation
        Objects.requireNonNull(session, "session must not be null");
        // remove the game from the user's session
        session.removeAttribute("checkGame");
        // do some application-wide book-keeping
        synchronized (this) {  // protect the critical code
            allPlayers.remove(request.queryParams("signedOut"));
            inGamePlayers.remove(request.queryParams("signedOut"));
        }
    }

    /**
     * Checking whether or not the name is valid
     *
     * @param playerName
     *
     * @return
     *      boolean to determine whether or not the allPlayers list contains the playerName
     */
    public boolean add(String playerName) {
        if (allPlayers.contains(playerName)) {
            return  false;
        }
        else {
            return allPlayers.add(playerName);
        }
    }


    /**
     *
     * @return
     *      allPlayer's list
     */
    public List<String> getAllPlayers() {
        return allPlayers;
    }

    public List<String> getInGamePlayers() {
        return inGamePlayers;
    }

    public List<CheckersGame> getGamesList() {
        return gameList;
    }


    public CheckersGame getGame(String p1){
        for (CheckersGame game: gameList) {
            if(game.hasPlayer(p1)){
                return game;
            }
        }
        return null;
    }
}
