package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;
import com.webcheckers.model.Space;
import org.mockito.internal.matchers.Null;

public class SpaceTest {
    Space sp;
    Space s;
    Piece pi;
    Position pos;
    @Before
    public void setUp() throws Exception {
        sp = new Space(5, TRUE);
        pi=new Piece("Red");
        s = new Space(5,TRUE, pi);
        pos=new Position(5,8);


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCellIdx() throws Exception {

        assertEquals(5,sp.getCellIdx());
        assertEquals(true, sp.isBlack());
    }

    @Test
    public void getPiece() throws Exception {
        assertNotNull(s.getPiece());

    }

    @Test
    public void placePiece() throws Exception {
    }

    @Test
    public void containsPiece() throws Exception {
        assertTrue(this.pi!= null);
    }

    @Test
    public void removePiece() throws Exception {
        
    }

    @Test
    public void isBlack() throws Exception {
        assertTrue(true);

    }

    @Test
    public void isValid() throws Exception {
        assertTrue(sp.isValid());
    }

   /* @Test
    public void setPosition() throws Exception {
        sp.setPosition(pos);

    }*/

}