package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        System.out.println("***********************************");

        int oldRow = move.getStart().getRow();
        int oldCol = move.getStart().getCell();
        int newRow = move.getEnd().getRow();
        int newCol = move.getEnd().getCell();

        Piece piece = getRows().get(oldRow).getSpaces().get(oldCol).getPiece();

        System.out.println("oldPos = " + oldRow + "," + oldCol);
        System.out.println("newPos = " + newRow + "," + newCol);

        if (piece.getType().equals("SINGLE"))
        {
            if (piece.getColor().equals("RED"))
            {
                if (oldCol - newCol == 1 || oldCol - newCol == -1)
                {
                    if (oldRow - newRow == 1)
                    {
                        return true;
                    }
                }
                else if (oldCol - newCol == 2 || oldCol - newCol == -2)
                {
                    if (oldRow - newRow == 2)
                    {
                        int jumpedPieceRow = oldRow - 1;
                        int jumpedPieceCol = (newCol - oldCol) / 2 + oldCol;
                        Piece jumpedPiece = getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceCol).getPiece();
                        if (jumpedPiece != null && jumpedPiece.getColor().equals("WHITE"))
                        {
                            return true;
                        }
                    }
                }
            }

            if (piece.getColor() == "WHITE")
            {
                if (oldRow - newRow == -1)
                {
                    if (oldCol - newCol == 1 || oldCol - newCol == -1)
                    {
                        return true;
                    }
                } else if (oldCol - newCol == 2 || oldCol - newCol == -2)
                {
                    if (oldRow - newRow == -2)
                    {
                        int jumpedPieceRow = oldRow + 1;
                        int jumpedPieceCol = (newCol - oldCol) / 2 + oldCol;
                        Piece jumpedPiece = getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceCol).getPiece();
                        if (jumpedPiece != null && jumpedPiece.getColor().equals("RED"))
                        {
                            return true;
                        }
                    }
                }
            }

        } else if (piece.getType() == "KING")

        {

        }

        return false;
    }

}
