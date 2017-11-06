package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;


public class BoardTest
{
    private Board CuT;
    @Before
    public void setUp() throws Exception
    {
        //Given
        CuT = new Board();

    }

    @After
    public void tearDown() throws Exception
    {
    }
    @Test
    public void test_constructor()
    {
        assertNotNull("Board is not null therefore is correctly instantiated",CuT);
    }


    @Test
    public void test_getRows() throws Exception
    {
        assertTrue("getRows returns an instance of List",CuT.getRows() instanceof List);
        Class elementType = CuT.getRows().get(0).getClass();
        assertEquals("getRows is a list made of Row elements",Row.class.getName(),elementType.getName());

    }

    @Test
    public void test_iterator() throws Exception
    {
        CuT.iterator().next().getClass();
        assertTrue("Iterator returns an instance of Iterator",CuT.iterator() instanceof Iterator);

        Class elementType = CuT.iterator().next().getClass();
        assertEquals("Iterator is made of Row elements",Row.class.getName(),elementType.getName());
    }

    @Test
    public void test_boardHas8Row()
    {
        assertEquals("Board has 8 rows",8,CuT.getRows().size());
    }

}
