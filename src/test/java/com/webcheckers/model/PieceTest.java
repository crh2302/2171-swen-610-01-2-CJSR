package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PieceTest {
    Piece piece;
    @Before
    public void setUp() throws Exception {
      piece = new Piece("SINGLE","RED");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getType() throws Exception {
        assertEquals("SINGLE",piece.getType());
    }

    @Test
    public void getColor() throws Exception {
        assertEquals("RED",piece.getColor());
    }

    @Test
    public void crownPiece() throws Exception {
        piece.crownPiece();
        assertEquals("KING",piece.getType());
    }

}