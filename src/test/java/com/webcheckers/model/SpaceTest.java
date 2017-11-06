package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;
import com.webcheckers.model.Space;


public class SpaceTest {

    Space CuT = new Space(0, true, new Piece("KING","RED"));
    Space sp = new Space(5,true,new Piece("SINGLE","RED"));
    Space spNULL = new Space(5,true,null);
    Space spFALSE = new Space(5, false, null);

    Piece newP = new Piece("KING", "RED");
    Piece newP2 = new Piece("KING", "RED");

    @Test
    public void getCellIdx() throws Exception {
        assertEquals(5,sp.getCellIdx());
    }

    @Test
    public void getPiece() throws Exception {
        assertNotNull(sp.getPiece());
    }

    @Test
    public void setPiece() throws Exception {
        CuT.setPiece(new Piece("SINGLE","RED"));
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(spNULL.isValid());
        assertFalse(spFALSE.isValid());
        assertFalse(CuT.isValid());
    }

    @Test
    public void populateManPiece() throws Exception {

    }

    @Test
    public void populateKingPiece() throws Exception {
        CuT.populateSpaceKing("RED");
        assertEquals("KING",newP.getType());
    }
}