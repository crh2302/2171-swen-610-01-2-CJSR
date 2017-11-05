package com.webcheckers.model;

import java.util.LinkedList;
import java.util.List;

/**
 * An actual checkers game
 */
public class CheckersGame
{
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
                doMove(moves.remove());
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

    public boolean moveIsValid(Move move)
    {
        int oldRow = move.getStart().getRow();
        int oldColumn = move.getStart().getCell();
        int newRow = move.getEnd().getRow();
        int newColumn = move.getEnd().getCell();

        Piece piece = board.getRows().get(oldRow).getSpaces().get(oldColumn).getPiece();

        if (piece.getType().equals("SINGLE"))
        {
            if (piece.getColor().equals("RED"))
            {
                if (oldColumn - newColumn == 1 || oldColumn - newColumn == -1)
                {
                    if (oldRow - newRow == 1)
                    {
                        return true;
                    }
                }
                else if (oldColumn - newColumn == 2 || oldColumn - newColumn == -2)
                {
                    if (oldRow - newRow == 2)
                    {
                        int jumpedPieceRow = oldRow - 1;
                        int jumpedPieceColumn = (newColumn - oldColumn) / 2 + oldColumn;

                        Piece jumpedPiece = board.getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).getPiece();
                        if (jumpedPiece != null && jumpedPiece.getColor().equals("WHITE"))
                        {
                            board.getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).populateSpaceMan();
                            return true;
                        }
                    }
                }
            }

            if (piece.getColor() == "WHITE")
            {
                if (oldRow - newRow == -1)
                {
                    if (oldColumn - newColumn == 1 || oldColumn - newColumn == -1)
                    {
                        return true;
                    }
                }
                else if (oldColumn - newColumn == 2 || oldColumn - newColumn == -2)
                {
                    if (oldRow - newRow == -2)
                    {
                        int jumpedPieceRow = oldRow + 1;
                        int jumpedPieceColumn = (newColumn - oldColumn) / 2 + oldColumn;

                        Piece jumpedPiece = board.getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).getPiece();
                        if (jumpedPiece != null && jumpedPiece.getColor().equals("RED"))
                        {
                            board.getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).populateSpaceMan();
                            return true;
                        }
                    }
                }
            }

        }
        else if (piece.getType() == "KING") {

        }

        return false;
    }

    public boolean doMove(Move move)
    {
        int oldRow = move.getStart().getRow();
        int oldColumn = move.getStart().getCell();
        int newRow = move.getEnd().getRow();
        int newColumn = move.getEnd().getCell();

        Piece piece = board.getRows().get(oldRow).getSpaces().get(oldColumn).getPiece();

        try
        {
            if((newRow == 0) || newRow == 7){
                System.out.println("=========");
                System.out.println("Last Row Entered, Piece Converted to King");
                System.out.println("=========");

                Piece kingPiece = board.getRows().get(oldRow).getSpaces().get(oldColumn).populateSpaceKing(piece.getColor());
                board.getRows().get(newRow).getSpaces().get(newColumn).setPiece(kingPiece);

            }
            else{
                Piece manPiece = board.getRows().get(oldRow).getSpaces().get(oldColumn).populateSpaceMan();
                board.getRows().get(newRow).getSpaces().get(newColumn).setPiece(manPiece);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}