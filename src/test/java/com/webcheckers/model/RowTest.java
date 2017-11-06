package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RowTest {
    Row row;
    @Before
    public void setUp() throws Exception {
        row=new Row(8);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getSpaces() throws Exception {
        assertNotNull(row.getSpaces());
        assertEquals(8,row.getSpaces().size());
    }

    @Test
    public void getIndex() throws Exception {
        assertNotNull(row.getIndex());
        assertEquals(8,row.getIndex());
    }

}
