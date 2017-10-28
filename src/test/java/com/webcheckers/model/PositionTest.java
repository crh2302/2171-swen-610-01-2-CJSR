package com.webcheckers.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class PositionTest {

    //attributes
    private int row;
    private int cell;
    private Position CuT = new Position(row, cell);


    @Test
    public void get_row(){
        assertEquals(CuT.getRow(), this.row);
    }

    @Test
    public void get_cell(){
        assertEquals(CuT.getCell(), this.cell);
    }

}
