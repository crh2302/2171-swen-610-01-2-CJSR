package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.Board;
import com.webcheckers.model.CheckersGame;
import com.webcheckers.model.Move;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

/**
 * Post route for /validateMove
 */
public class PostValidateMoveRoute implements Route
{

	private final CheckersCenter checkersCenter;
	private CheckersGame game;
	private Board board;

	PostValidateMoveRoute(final CheckersCenter checkersCenter)
	{
		// Validate that GameCenter is not null
		Objects.requireNonNull(checkersCenter, "gameCenter must not be null");
		this.checkersCenter = checkersCenter;
	}

	@Override
	public Object handle(Request request, Response response)
	{
		game = checkersCenter.getGame(request.cookie("playerName"));

		final String dataStr = request.body();
		final Move move = JsonUtils.fromJson(dataStr, Move.class);

		if (game.moveIsValid(move)) {
			game.addMove(move);
			return new Message("Valid Move");
		}
		else {
			return new Message("Invalid Move");
		}
	}

}
