package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import java.util.LinkedList;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class CheckersGameTest
{
    private CheckersGame CuT;
    private String playerMock;
    private String opponentMock;
    private Move moveMock;

    @Spy
    LinkedList<Move> spyMoves;

    @Before
    public void setUp() throws Exception
    {
        this.playerMock = "Bill";
        this.opponentMock = "Steve";
        spyMoves = new LinkedList<>();
        moveMock = mock(Move.class);
        CuT = new CheckersGame(playerMock,opponentMock);
    }

    @After
    public void tearDown() throws Exception
    {

    }


    @Test
    public void test_getSetBoard() {
        Board board1 = new Board();
        Board board2 = new Board();

        CuT.setBoard(board1);
        assertSame(board1,CuT.getBoard());
        CuT.setBoard(board2);
        assertSame(board2,CuT.getBoard());

    }

    @Test
    public void test_getPlayer(){
        assertEquals(this.playerMock,CuT.getPlayer());

    }

    @Test
    public void test_getOpponent(){
        assertEquals(this.opponentMock,CuT.getOpponent());
    }

    @Test
    public void test_hasPlayer()
    {
        assertTrue(CuT.hasPlayer(playerMock));
        assertTrue(CuT.hasPlayer(opponentMock));
        assertFalse(CuT.hasPlayer(""));
        assertFalse(CuT.hasPlayer("AnotherName"));

    }

    @Test
    public void test_isTurnAnToggleTurn()
    {
        assertTrue(CuT.isPlayerTurn(playerMock));
        assertFalse(CuT.isPlayerTurn(opponentMock));
        CuT.switchTurn();
        assertFalse(CuT.isPlayerTurn(playerMock));
        assertTrue(CuT.isPlayerTurn(opponentMock));
        CuT.switchTurn();
        assertTrue(CuT.isPlayerTurn(playerMock));
        assertFalse(CuT.isPlayerTurn(opponentMock));
    }

}
