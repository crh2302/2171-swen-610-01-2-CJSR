package com.webcheckers.model;


/**
 * An actual checkers game
 */
public class CheckersGame
{
    String turnColor;

    public String getTurnColor()
    {
        return turnColor;
    }

    public void setTurnColor(String turnColor)
    {
        this.turnColor = turnColor;
    }

    //TODO Board should be managed by this class.

}
