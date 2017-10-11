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


    @Override
    public Iterator<Row> iterator()
    {
        return this.row.iterator();
    }

    //
    // Constructor
    //

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
     *
     * @return
     *      row.index
     */
    public Row getRow(int index)
    {
       return this.row.get(index);
    }

}
