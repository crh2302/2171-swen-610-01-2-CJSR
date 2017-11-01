package com.webcheckers.model;

import java.util.LinkedList;
import java.util.List;

/**
 * An actual checkers game
 */
public class CheckersGame
{
    private String turnColor;
    private String player;
    private String opponent;

    public CheckersGame(final String player, final String opponent){
        this.player = player;
        this.opponent = opponent;
    }
    
    public String getTurnColor() {
        return turnColor;
    }

    public void setTurnColor(String turnColor) {
        this.turnColor = turnColor;
    }

    public String getPlayer(){
        return player;
    }

    public String getOpponent(){
        return opponent;
    }
}
