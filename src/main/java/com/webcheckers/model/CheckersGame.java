package com.webcheckers.model;


/**
 * An actual checkers game
 */
public class CheckersGame
{
    PieceColor turnColor;

    public PieceColor getTurnColor()
    {
        return turnColor;
    }

    public void setTurnColor(PieceColor turnColor)
    {
        this.turnColor = turnColor;
    }

}
