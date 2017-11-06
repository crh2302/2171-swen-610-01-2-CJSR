package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest {
    Position pos1 = new Position(0,0);
    Position pos2 = new Position(1,1);
    Move cut = new Move(pos1,pos2);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getStart() throws Exception {
        assertEquals(pos1,cut.getStart());
    }

    @Test
    public void getEnd() throws Exception {
        assertEquals(pos2,cut.getEnd());
    }

}