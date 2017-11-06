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

    public void addMove(Move newMove){
        moves.addLast(newMove);
    }

    public boolean hasPlayer(String name){
        return player.equals(name) || opponent.equals(name);
    }

    /**
     * perform moves in 'moves' list for the turn
     * @return
     *      true when all moves completed
     */
    public boolean processTurn(){
        while (!moves.isEmpty()) {
            doMove(moves.remove());
        }
        switchTurn();

        return true;
    }


    /**
     * clear the list of moves
     */
    public void clearMoves(){
        moves.clear();
    }


    /**
     * @param
     *      otherPlayer
     * @return
     *      whether or not it is the players turn
     */
    public boolean isPlayerTurn(String otherPlayer){
        int test;
        if(this.player.equals(otherPlayer)){
            test = 0;
        }
        else{
            test = 1;
        }
        return test == turn;
    }


    /**
     * switch turns between players
     * @return
     */
    public int switchTurn(){
        if(turn == 1){
            turn = 0;
        }
        else{
            turn = 1;
        }
        return turn;
    }


    /**
     * checking to see if move made is valid
     * @param
     *      move
     * @return
     *      boolean for if valid move
     */
    public boolean moveIsValid(Move move)
    {
        //old piece location
        int oldRow = move.getStart().getRow();
        int oldColumn = move.getStart().getCell();

        //new piece location
        int newRow = move.getEnd().getRow();
        int newColumn = move.getEnd().getCell();

        Piece piece = board.getRows().get(oldRow).getSpaces().get(oldColumn).getPiece();

        if (piece.getType().equals("SINGLE"))
        {
            if (piece.getColor().equals("RED") || piece.getColor().equals("WHITE"))
            {
                if (oldColumn-newColumn == 1 || oldColumn-newColumn == -1)
                {
                    if (oldRow-newRow == 1 || oldRow-newRow == -1)
                    {
                        return true;
                    }
                }
                else if (oldColumn-newColumn == 2 || oldColumn-newColumn == -2)
                {
                    if (oldRow-newRow == 2)
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
                    else if(oldRow-newRow == -2)
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
            //do king move here
        }
        return false;
    }


    /**
     * make a move
     * @param
     *      move
     * @return
     *      boolean once move is made
     */
    public boolean doMove(Move move)
    {
        int oldRow = move.getStart().getRow();
        int oldColumn = move.getStart().getCell();
        int newRow = move.getEnd().getRow();
        int newColumn = move.getEnd().getCell();

        Piece piece = board.getRows().get(oldRow).getSpaces().get(oldColumn).getPiece();

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
}