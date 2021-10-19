/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youdev.othello.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static youdev97.othello.model.ColorP.BLACK;
import static youdev97.othello.model.ColorP.EMPTY;
import static youdev97.othello.model.ColorP.WHITE;
import static youdev97.othello.model.Direction.E;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import youdev97.othello.model.Board;
import youdev97.othello.model.ColorP;
import youdev97.othello.model.Direction;
import youdev97.othello.model.Piece;
import youdev97.othello.model.Position;

/**
 *
 * @author Younes
 */
public class BoardTest {

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPieceAt method, of class Board.
     */
    @Test
    public void testGetPionAt() {
        System.out.println("getPionAt white piece");
        Position pos = new Position(3, 3);
        Board instance = new Board();
        Piece expResult = new Piece(WHITE);
        Piece result = instance.getPieceAt(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPieceAt method, of class Board.
     */
    @Test
    public void testGetPionAt2() {
        System.out.println("getPionAt empty");
        Position pos = new Position(0, 0);
        Board instance = new Board();
        Piece expResult = new Piece(EMPTY);
        Piece result = instance.getPieceAt(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of setPieceAt method, of class Board.
     */
    @Test
    public void testSetPionAt() {
        System.out.println("setPionAt black piece");
        Position pos = new Position(2, 3);
        Piece expResult = new Piece(BLACK);
        Board instance = new Board();
        instance.setPieceAt(pos, expResult);
        Piece result = instance.getPieceAt(pos);

        assertEquals(result, expResult);
    }

    /**
     * Test of setPieceAt method, of class Board.
     */
    @Test
    public void testSetPionAt2() {
        System.out.println("setPionAt empty");
        Position pos = new Position(2, 3);
        Piece expResult = new Piece(EMPTY);
        Board instance = new Board();
        instance.setPieceAt(pos, expResult);
        Piece result = instance.getPieceAt(pos);
        assertEquals(result, expResult);
    }

    /**
     * Test of getLENGTH method, of class Board.
     */
    @Test
    public void testGetLENGTH() {
        System.out.println("getLENGTH");
        int expResult = 8;
        int result = Board.getLENGTH();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWIDTH method, of class Board.
     */
    @Test
    public void testGetWIDTH() {
        System.out.println("getWIDTH");
        int expResult = 8;
        int result = Board.getWIDTH();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentPlayer method, of class Board.
     */
    @Test
    public void testGetCurrentPlayer() {
        System.out.println("getCurrentPlayer black");
        Board instance = new Board();
        Piece expResult = new Piece(BLACK);
        Piece result = instance.getCurrentPlayer();
        assertEquals(result, expResult);
    }

    /**
     * Test of getCurrentPlayer method, of class Board.
     */
    @Test
    public void testGetJoueurCourant2() {
        System.out.println("getCurrentPlayer white");
        Board instance = new Board();
        instance.nextPlayer();
        Piece expResult = new Piece(WHITE);
        Piece result = instance.getCurrentPlayer();
        assertEquals(result, expResult);
    }

    /**
     * Test of isRunning method, of class Board.
     */
    @Test
    public void testIsRunning() {
        System.out.println("isRunning");
        Board instance = new Board();
        boolean result = instance.isRunning();
        assertTrue(result);
    }

    /**
     * Test of nextPlayer method, of class Board.
     */
    @Test
    public void testNextPlayer() {
        System.out.println("nextplayer");
        Board instance = new Board();
        instance.nextPlayer();
        Piece result = instance.getCurrentPlayer();
        Piece expResult = new Piece(WHITE);
        assertEquals(result, expResult);
    }

    /**
     * Test of nextPlayer method, of class Board.
     */
    @Test
    public void testNextPlayer2() {
        System.out.println("nextplayer 2x");
        Board instance = new Board();
        instance.nextPlayer();
        instance.nextPlayer();
        Piece result = instance.getCurrentPlayer();
        Piece expResult = new Piece(BLACK);
        assertEquals(result, expResult);
    }

    /**
     * Test of cntColor method, of class Board.
     */
    @Test
    public void testCntColor() {
        System.out.println("cntColor white");
        ColorP clr = WHITE;
        Board instance = new Board();
        int expResult = 2;
        int result = instance.cntColor(clr);
        assertEquals(expResult, result);
    }

    /**
     * Test of cntColor method, of class Board.
     */
    @Test
    public void testCntColor2() {
        System.out.println("cntColor black");
        ColorP clr = BLACK;
        Board instance = new Board();
        instance.place(new Position(2, 3));
        int expResult = 4;
        int result = instance.cntColor(clr);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Position p = new Position(6, 6);
        Board instance = new Board();
        boolean result = instance.isInside(p);
        assertTrue(result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void isInside2() {
        System.out.println("isInside false");
        Position p = new Position(8, 10);
        Board instance = new Board();
        boolean result = instance.isInside(p);
        assertFalse(result);
    }

    /**
     * Test of moveList method, of class Board.
     */
    @Test
    public void testMoveList() {
        System.out.println("moveList");
        Board instance = new Board();
        List<Position> expResult = new ArrayList<>();
        expResult.add(new Position(2, 3));
        expResult.add(new Position(3, 2));
        expResult.add(new Position(5, 4));
        expResult.add(new Position(4, 5));
        List<Position> result = instance.moveList();
        assertTrue(result.containsAll(expResult));
    }

    /**
     * Test of legalMove method, of class Board.
     */
    @Test
    public void testLegalMove() {
        System.out.println("legalMove false");
        Position pos = new Position(0, 0);
        Board instance = new Board();
        boolean result = instance.legalMove(pos);
        assertFalse(result);
    }

    /**
     * Test of legalMove method, of class Board.
     */
    @Test
    public void testLegalMove2() {
        System.out.println("legalMove true");
        Position pos = new Position(3, 2);
        Board instance = new Board();
        boolean result = instance.legalMove(pos);
        assertTrue(result);
    }

    /**
     * Test of getNbrSwitches method, of class Board.
     */
    @Test
    public void testGetNbrSwitches() {
        System.out.println("getNbrSwitches");
        Position pos = new Position(3, 2);
        Direction d = E;
        Board instance = new Board();
        int expResult = 1;
        int result = instance.getNbrSwitches(pos, d);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of switchPiece method, of class Board.
//     */
//    @Test
//    public void testSwitchPiece() {
//        System.out.println("switchPiece Est");
//        Position pos = new Position(2, 3);
//        Direction d = E;
//        int retourner = 1;
//        Board instance = new Board();
//        List<Position> expResult = new ArrayList<>();
//        expResult.add(new Position(2, 4));
//        List<Position> result = instance.switchPiece(pos, d, retourner);
//        assertTrue(result.containsAll(expResult));
//    }
//    
//    /**
//     * Test of switchPiece method, of class Board.
//     */
//    @Test
//    public void testSwitchPiece2() {
//        System.out.println("switchPiece2 North");
//        Position pos = new Position(5, 4);
//        Direction d = N;
//        int retourner = 1;
//        Board instance = new Board();
//        List<Position> expResult = new ArrayList<>();
//        expResult.add(new Position(4, 4));
//        List<Position> result = instance.switchPiece(pos, d, retourner);
//        assertTrue(result.containsAll(expResult));
//    }
//        /**
//     * Test of switchPiece method, of class Board.
//     */
//    @Test
//    public void testSwitchPiece3() {
//        System.out.println("switchPiece3 SE");
//        Position pos = new Position(5, 4);
//        Direction d = SE;
//        int retourner = 0;
//        Board instance = new Board();
//        List<Position> expResult = new ArrayList<>();
//        List<Position> result = instance.switchPiece(pos, d, retourner);
//        assertTrue(result.containsAll(expResult));
//    }
    
    
    /**
     * Test of place method, of class Board.
     */
    @Test
    public void testPlace() {
        System.out.println("place");
        Position pos = new Position(2, 3);
        Board instance = new Board();
        instance.place(pos);
        Piece result = instance.getPieceAt(pos);
        Piece expResult = new Piece(BLACK);
        assertEquals(result, expResult);
    }

}
