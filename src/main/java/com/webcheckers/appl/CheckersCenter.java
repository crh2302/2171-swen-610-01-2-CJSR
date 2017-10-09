package com.webcheckers.appl;

import com.webcheckers.model.CheckersGame;
import com.webcheckers.ui.GetGameMenuRoute;
import spark.Request;
import spark.Session;;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckersCenter {

    public static List<String> allPlayers;

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

    public void end(Session session, Request request) {
        // validation
        Objects.requireNonNull(session, "session must not be null");
        // remove the game from the user's session
        session.removeAttribute("checkGame");
        // do some application-wide book-keeping
        synchronized (this) {  // protect the critical code
             allPlayers.remove(GetGameMenuRoute.getNameString(request));
        }
    }
}
