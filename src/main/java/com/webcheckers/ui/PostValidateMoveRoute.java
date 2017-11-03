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
		game = checkersCenter.getGame("cool");
		board = game.getBoard();
		System.out.println("===========================");

		System.out.println("Move attempt made");

		final String dataStr = request.body();
		final Move move = JsonUtils.fromJson(dataStr, Move.class);

		boolean goodMove = board.moveIsValid(move);
		if (goodMove)
		{
			game.addMove(move);
			return new Message("Valid Move");
		}
		return new Message("Invalid Move");
	}

}
