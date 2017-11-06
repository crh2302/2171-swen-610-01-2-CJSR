package com.webcheckers.model;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a move
 */
public class Move
{

	private Position start;
	private Position end;

	public Move(Position start, Position end)
	{
		this.start = start;
		this.end = end;
	}

	public Position getStart()
	{
		return start;
	}

	public Position getEnd()
	{
		return end;
	}

}
