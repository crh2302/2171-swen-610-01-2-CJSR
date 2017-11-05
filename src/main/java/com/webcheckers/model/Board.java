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



}
