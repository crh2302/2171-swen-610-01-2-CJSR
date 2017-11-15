package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public Piece returnJumpedPiece(int jumpedPieceRow, int jumpedPieceColumn){
        return getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).getPiece();
    }

    public void populateJumpedSpace(int jumpedPieceRow, int jumpedPieceColumn){
        getRows().get(jumpedPieceRow).getSpaces().get(jumpedPieceColumn).populateSpaceMan();
    }
}

