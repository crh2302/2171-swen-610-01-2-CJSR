package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;

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

    private ArrayList<Row> row;

    //
    // Constructor
    //

    /**
     * Default constructor for board.
     */
    public Board()
    {
        this.row = new ArrayList<Row>(Row.ROW_AMMOUT);

        for (int i = 0; i < Row.ROW_AMMOUT; i++)
        {
            this.row.add(new Row(i));
        }

    }

    /**
     * accessor for row
     *
     * @param index
     *      Index of the row that wants to be get
     * @return
     *      The row on the specified index
     */
    public Row getRow(int index)
    {
       return this.row.get(index);
    }

    @Override
    public Iterator<Row> iterator()
    {
        return this.row.iterator();
    }

}
