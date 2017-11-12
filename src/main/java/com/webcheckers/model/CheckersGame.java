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
    private int redPiecesLeft;
    private int whitePiecesLeft;

    private LinkedList<Move> moves;

    public CheckersGame(final String player, final String opponent){
        this.player = player;
        this.opponent = opponent;
        this.turn = 0;
        this.redPiecesLeft = 1;
        this.whitePiecesLeft = 1;
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
        if (piece.getType().equals("SINGLE") || pieceIsKing(piece))
        {
                if (oldColumn-newColumn == 1 || oldColumn-newColumn == -1)
                {
                    if ((oldRow-newRow == 1 && pieceIsRed(piece)) || (oldRow-newRow == -1 && pieceIsWhite(piece)))
                    {
                        return true;
                    }
                    else if((oldRow-newRow == 1 || oldRow-newRow == -1) && pieceIsKing(piece)){
                        return true;
                    }
                }
                else if (oldColumn-newColumn == 2 || oldColumn-newColumn == -2)
                {
                    if (oldRow-newRow == 2)
                    {
                        int jumpedPieceRow = oldRow - 1;
                        int jumpedPieceColumn = jumpedPieceColumn(newColumn,oldColumn);

                        Piece jumpedPiece = jumpedPiece(jumpedPieceRow,jumpedPieceColumn);

                        if (isNotNullAndWhite(jumpedPiece)) {
                            whitePiecesLeft--;
                            return populateJumpedSpace(jumpedPieceRow,jumpedPieceColumn);
                        }
                        else if((isNotNullAndRed(jumpedPiece)) && pieceIsKing(piece)) {
                            redPiecesLeft--;

                            return populateJumpedSpace(jumpedPieceRow,jumpedPieceColumn);
                        }
                    }
                    else if(oldRow-newRow == -2)
                    {
                        int jumpedPieceRow = oldRow + 1;
                        int jumpedPieceColumn = jumpedPieceColumn(newColumn,oldColumn);

                        Piece jumpedPiece = jumpedPiece(jumpedPieceRow,jumpedPieceColumn);
                        if (isNotNullAndRed(jumpedPiece))
                        {

                            redPiecesLeft--;

                            return populateJumpedSpace(jumpedPieceRow,jumpedPieceColumn);
                        }
                        else if((isNotNullAndWhite(jumpedPiece)) && pieceIsKing(piece))
                        {

                            whitePiecesLeft--;

                            return populateJumpedSpace(jumpedPieceRow,jumpedPieceColumn);
                        }
                    }
                }
        }
        return false;
    }

    public Piece jumpedPiece(int jumpedPieceRow, int jumpedPieceColumn){
        return board.getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).getPiece();
    }

    public int jumpedPieceColumn(int newColumn, int oldColumn){
        return (newColumn - oldColumn) / 2 + oldColumn;
    }

    public boolean populateJumpedSpace(int jumpedPieceRow, int jumpedPieceColumn){
        board.getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).populateSpaceMan();
        return true;
    }

    public boolean pieceIsKing(Piece piece){
        return piece.getType().equals("KING");
    }

    public boolean pieceIsRed(Piece piece){
        return piece.getColor().equals("RED");
    }

    public boolean pieceIsWhite(Piece piece){
        return piece.getColor().equals("WHITE");
    }

    public boolean isNotNullAndWhite(Piece jumpedPiece){
        return (jumpedPiece != null && pieceIsWhite(jumpedPiece));
    }

    public boolean isNotNullAndRed(Piece jumpedPiece){
        return (jumpedPiece != null && pieceIsRed(jumpedPiece));
    }

    public int getWhitePiecesLeft(){
        return whitePiecesLeft;
    }

    public int getRedPiecesLeft(){
        return whitePiecesLeft;
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