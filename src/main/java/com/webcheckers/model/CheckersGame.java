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

    private int turn;

    private LinkedList<Move> moves;

    public CheckersGame(final String player, final String opponent){
        this.player = player;
        this.opponent = opponent;
        this.turn = 0;
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

    public boolean hasPlayer(String name){
        return player.equals(name) || opponent.equals(name);
    }

    public boolean processPlayerTurn(){
        try {
            while (!moves.isEmpty()) {
                board.doMove(moves.remove());
            }
            toggleTurn();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void clearMoves(){
        moves.clear();
    }

    public boolean isTurn(String otherPlayer){
        int test;
        if(this.player.equals(otherPlayer)){
            test = 0;
        }
        else{
            test = 1;
        }
        return test == turn;
    }

    public int toggleTurn(){
        if(turn == 1){
            turn = 0;
        }
        else{
            turn = 1;
        }
        return turn;
    }
}