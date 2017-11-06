package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;
import com.webcheckers.model.Space;


public class SpaceTest {

    Space sp = new Space(5,true,new Piece("SINGLE","RED"));
    Space spNULL = new Space(5,true,null);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCellIdx() throws Exception {
        assertEquals(5,sp.getCellIdx());
    }

    @Test
    public void getPiece() throws Exception {
        assertNotNull(sp.getPiece());
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(spNULL.isValid());
    }
}