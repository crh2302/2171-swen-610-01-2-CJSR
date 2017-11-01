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
    private Board board;
    private LinkedList<Move> moves;

    public CheckersGame(final String player, final String opponent){
        this.player = player;
        this.opponent = opponent;
        setBoard(new Board());
        moves = new LinkedList<>();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
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

    /**
     * Adds a move to the move queue
     * @param newMove - move to be added to the linked list
     */
    public void addMove(Move newMove){
        moves.addLast(newMove);
    }

}