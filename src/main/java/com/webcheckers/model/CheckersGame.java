package com.webcheckers.model;

import com.webcheckers.appl.CheckersCenter;

import java.util.LinkedList;
import java.util.List;

/**
 * An actual checkers game
 */
public class CheckersGame
{
    private String player;
    private String opponent;
    public String capturedColor = null;

    private Board board;

    private int turn;
    private int redPiecesLeft;
    private int whitePiecesLeft;

    private LinkedList<Move> moves;

    public CheckersGame(final String player, final String opponent){
        this.player = player;
        this.opponent = opponent;
        this.turn = 0;
        this.redPiecesLeft = 12;
        this.whitePiecesLeft = 12;
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

    public int getWhitePiecesLeft(){
        return whitePiecesLeft;
    }

    public int getRedPiecesLeft(){
        return redPiecesLeft;
    }

    public void removeGame(CheckersGame game, CheckersCenter checkersCenter) {
        checkersCenter.getGamesList().remove(game);
    }

    /**
     * perform moves in 'moves' list for the turn
     * @return
     *      true when all moves completed
     */
    public void processTurn(){
        while (!moves.isEmpty()) {
            doMove(moves.remove());
        }
        switchTurn();
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
        if (piece.isSingle(piece) || piece.isKing(piece))
        {
                if (oldColumn-newColumn == 1 || oldColumn-newColumn == -1)
                {
                    if ((oldRow-newRow == 1 && piece.isRed(piece)) || (oldRow-newRow == -1 && piece.isWhite(piece))) {
                        return true;
                    }
                    else if((oldRow-newRow == 1 || oldRow-newRow == -1) && piece.isKing(piece)){
                        return true;
                    }
                }
                else if (oldColumn-newColumn == 2 || oldColumn-newColumn == -2)
                {
                    if (oldRow-newRow == 2)
                    {
                        int jumpedPieceRow = oldRow - 1;
                        int jumpedPieceColumn = jumpedPieceColumn(newColumn,oldColumn);

                        Piece jumpedPiece = board.returnJumpedPiece(jumpedPieceRow,jumpedPieceColumn);
                        if (isNotNullAndWhite(jumpedPiece)) {
                            capturedColor = "white";
                            board.populateJumpedSpace(jumpedPieceRow,jumpedPieceColumn);
                            return true;
                        }
                        else if((isNotNullAndRed(jumpedPiece)) && piece.isKing(piece)) {
                            capturedColor = "red";
                            board.populateJumpedSpace(jumpedPieceRow,jumpedPieceColumn);
                            return true;
                        }
                    }
                    else if(oldRow-newRow == -2)
                    {
                        int jumpedPieceRow = oldRow + 1;
                        int jumpedPieceColumn = jumpedPieceColumn(newColumn,oldColumn);

                        Piece jumpedPiece = board.returnJumpedPiece(jumpedPieceRow,jumpedPieceColumn);
                        if (isNotNullAndRed(jumpedPiece)) {
                            capturedColor = "red";
                            board.populateJumpedSpace(jumpedPieceRow,jumpedPieceColumn);
                            return true;
                        }
                        else if((isNotNullAndWhite(jumpedPiece)) && piece.isKing(piece)) {
                            capturedColor = "white";
                            board.populateJumpedSpace(jumpedPieceRow,jumpedPieceColumn);
                            return true;
                        }
                    }
                }
        }
        return false;
    }

    public int jumpedPieceColumn(int newColumn, int oldColumn){
        return (newColumn - oldColumn)/2 + oldColumn;
    }

    public boolean isNotNullAndWhite(Piece jumpedPiece){
        return (jumpedPiece != null && jumpedPiece.isWhite(jumpedPiece));
    }

    public boolean isNotNullAndRed(Piece jumpedPiece){
        return (jumpedPiece != null && jumpedPiece.isRed(jumpedPiece));
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

            removePiece();
            Piece kingPiece = board.getRows().get(oldRow).getSpaces().get(oldColumn).populateSpaceKing(piece.getColor());
            board.getRows().get(newRow).getSpaces().get(newColumn).setPiece(kingPiece);
        }
        else{
            removePiece();
            Piece manPiece = board.getRows().get(oldRow).getSpaces().get(oldColumn).populateSpaceMan();
            board.getRows().get(newRow).getSpaces().get(newColumn).setPiece(manPiece);
        }
        return true;
    }

    private void removePiece(){
        if(capturedColor != null && capturedColor.equals("white")){
            whitePiecesLeft--;
            this.capturedColor = null;
        }
        else if(capturedColor != null && capturedColor.equals("red")){
            redPiecesLeft--;
            this.capturedColor = null;
        }
    }
}