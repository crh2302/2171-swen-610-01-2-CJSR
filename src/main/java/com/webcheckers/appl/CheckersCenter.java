package com.webcheckers.appl;

import com.webcheckers.model.CheckersGame;
import com.webcheckers.ui.GetGameMenuRoute;
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

    public static List<String> allPlayers;
    public static List<String> inGamePlayers = new ArrayList<>();

    //
    // constructor
    //

    public CheckersCenter() {
        allPlayers = new ArrayList<>();
    }


    /**
     * Get the {@linkplain CheckersGame game} for the current user
     *
     * @param session
     *   The HTTP session
     *
     * @return
     *   A existing or new {@link CheckersGame}
     */
    public CheckersGame get(final Session session) {
        // validation
        Objects.requireNonNull(session, "session must not be null");
        CheckersGame game = session.attribute("checkGame");
        if (game == null) {
            // create new game
            game = new CheckersGame();
            session.attribute("checkGame", game);
        }
        return game;
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
             allPlayers.remove(GetGameMenuRoute.getPlayerNameString(request));
             inGamePlayers.remove(GetGameMenuRoute.getPlayerNameString(request));
        }
    }

    /**
     * to check to see if allPlayers list is empty
     *
     * @return
     *      boolean for if allPlayers list is empty
     */
    public boolean isPlayerListEmpty()
    {
        return allPlayers.isEmpty();
    }

    /**
     * Checking whether or not the name is valid
     *
     * @param playerName
     *
     * @return
     *      boolean to determine whether or not the allPlayers list contains the playerName
     */
    public boolean add(String playerName)
    {
        if (allPlayers.contains(playerName))
        {
            return  false;
        }
        else
        {
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
}