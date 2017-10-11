package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Board implements Iterable<Row>
{
    private ArrayList<Row> row;


    @Override
    public Iterator<Row> iterator()
    {
        return this.row.iterator();
    }

    public Board()
    {
        this.row = new ArrayList<Row>(Row.ROW_AMMOUT);

        for (int i = 0; i < Row.ROW_AMMOUT; i++)
        {
            this.row.add(new Row(i));
        }

    }

    public Row getRow(int index)
    {
       return this.row.get(index);
    }

}


/*
for (int row = 0 ; row < Row.ROW_AMMOUT; row++)
{
    this.rows.add(new Row(row));
    for (int cell = 0 ; cell < Row.ROW_AMMOUT;cell++)
    {
     if (board[row][cell].getPiece() != null )
     {
         //rows.get(row).placePiece(cell,board[row][cell].getPiece());
     }
    }
}*/