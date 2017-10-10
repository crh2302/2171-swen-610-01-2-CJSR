package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Board implements Iterable<Row>
{
    private ArrayList<Row> rows;


    @Override
    public Iterator<Row> iterator()
    {
        return this.rows.iterator();
    }

    public Board()
    {
        this.rows = new ArrayList<Row>(Row.ROW_AMMOUT);
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