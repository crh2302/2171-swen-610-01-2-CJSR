package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import java.util.LinkedList;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CheckersGameTest
{
    private CheckersGame CuT;
    private String playerMock;
    private String opponentMock;
    private Move moveMock;
    private Move CuT_move;
    private Position CuT_pos_start;
    private Position CuT_pos_end;
    private Piece piece;

    @Spy
    LinkedList<Move> spyMoves;

    @Before
    public void setUp() throws Exception
    {
        this.playerMock = "Bill";
        this.opponentMock = "Steve";
       // spyMoves = new LinkedList<>();
        spyMoves = mock(LinkedList.class);
        moveMock = mock(Move.class);
        CuT = new CheckersGame(playerMock,opponentMock);
        CuT_pos_start=new Position(4,5);
        CuT_pos_end=new Position(5,6);
        CuT_move=new Move(CuT_pos_start,CuT_pos_end);
        piece=new Piece("KING","RED");
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

    @Test
    public void test_processTurn()
    {
        when(spyMoves.isEmpty()).thenReturn(Boolean.FALSE);
       // assertTrue(CuT.doMove(spyMoves.remove()));
        assertTrue(CuT.processTurn());
    }

    @Test
    public void test_getclearMoves()
    {
        CuT.clearMoves();
        assertNotNull(spyMoves);
    }

    @Test (expected = NullPointerException.class)
    public void test_moveIsValid()
    {
        assertTrue(CuT.moveIsValid(CuT_move));

        int oldRow=CuT_move.getStart().getRow();
        int oldColumn=CuT_move.getStart().getCell();
        int newRow=CuT_move.getEnd().getRow();
        int newColumn=CuT_move.getEnd().getCell();
        assertNotNull(oldRow);
        assertNotNull(oldColumn);
        assertNotNull(newRow);
        assertNotNull(newColumn);

        assertTrue((oldRow-newRow == 1 || oldRow-newRow == -1) && CuT.pieceIsKing(piece));
        assertTrue(oldColumn-newColumn == 2 || oldColumn-newColumn == -2);

        assertTrue(oldRow-newRow == 2);

        int jumpedPieceRow = oldRow - 1;
        int jumpedPieceColumn = CuT.jumpedPieceColumn(newColumn,oldColumn);
        assertNotNull(jumpedPieceColumn);

        Piece jumpedPiece = CuT.jumpedPiece(jumpedPieceRow,jumpedPieceColumn);
        assertNotNull(jumpedPiece);

        assertTrue(CuT.isNotNullAndWhite(jumpedPiece));
        assertTrue(CuT.isNotNullAndRed(jumpedPiece) && CuT.pieceIsKing(piece));

        assertTrue(oldRow-newRow == -2);
        int jumpedPieceRow1 = oldRow + 1;
        int jumpedPieceColumn1 = CuT.jumpedPieceColumn(newColumn,oldColumn);
        assertNotNull(jumpedPieceRow1);
        assertNotNull(jumpedPieceColumn1);

        Piece jumpedPiece1 = CuT.jumpedPiece(jumpedPieceRow1,jumpedPieceColumn1);
        assertNotNull(jumpedPiece1);
        assertTrue(CuT.isNotNullAndRed(jumpedPiece1));
        assertTrue((CuT.isNotNullAndWhite(jumpedPiece)) && CuT.pieceIsKing(piece));


    }



}
