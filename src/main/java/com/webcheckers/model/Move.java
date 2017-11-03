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

	@Override
	public boolean equals(Object nMove)
	{
		if (nMove == null)
		{
			return false;
		}
		try {
			final Move that = (Move) nMove;
				if (that.getStart().equals(this.getStart())) {
					if (that.getEnd().equals(this.getEnd()))
						return true;
				}
		}catch(Exception e){

		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(start,end);
	}

}
