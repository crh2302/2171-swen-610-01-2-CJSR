package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Class to render a game board
 *
 */
public class Board implements Iterable<Row>
{
    //
    // attributes
    //

    private List<Row> rows;

    /**
     * Constructor for a brand new Board
     */
    public Board()
    {
        rows = new ArrayList<>();
        for (int i = 0; i <= 7; i++)
        {
            rows.add(new Row(i));
        }
    }

    public List<Row> getRows() {
        return rows;
    }

    @Override
    public Iterator<Row> iterator() {
        return rows.iterator();
    }

    public boolean moveIsValid(Move move)
    {
        int oldRow = move.getStart().getRow();
        int oldColumn = move.getStart().getCell();
        int newRow = move.getEnd().getRow();
        int newColumn = move.getEnd().getCell();

        Piece piece = getRows().get(oldRow).getSpaces().get(oldColumn).getPiece();

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

                        Piece jumpedPiece = getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).getPiece();
                        if (jumpedPiece != null && jumpedPiece.getColor().equals("WHITE"))
                        {
                            getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).populateSpaceMan();
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

                        Piece jumpedPiece = getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).getPiece();
                        if (jumpedPiece != null && jumpedPiece.getColor().equals("RED"))
                        {
                            getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).populateSpaceMan();
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

        Piece piece = getRows().get(oldRow).getSpaces().get(oldColumn).getPiece();

        try
        {
            if((newRow == 0) || newRow == 7){
                System.out.println("=========");
                System.out.println("Last Row Entered, Piece Converted to King");
                System.out.println("=========");

                Piece kingPiece = getRows().get(oldRow).getSpaces().get(oldColumn).populateSpaceKing(piece.getColor());
                getRows().get(newRow).getSpaces().get(newColumn).setPiece(kingPiece);

            }
            else{
                Piece manPiece = getRows().get(oldRow).getSpaces().get(oldColumn).populateSpaceMan();
                getRows().get(newRow).getSpaces().get(newColumn).setPiece(manPiece);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}
