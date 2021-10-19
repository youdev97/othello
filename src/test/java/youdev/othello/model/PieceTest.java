/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youdev.othello.model;

import static org.junit.Assert.assertEquals;
import static youdev97.othello.model.ColorP.BLACK;
import static youdev97.othello.model.ColorP.EMPTY;
import static youdev97.othello.model.ColorP.WHITE;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import youdev97.othello.model.ColorP;
import youdev97.othello.model.Piece;

/**
 *
 * @author Younes
 */
public class PieceTest {
    
    public PieceTest() {
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
     * Test of getColor method, of class Piece.
     */
    @Test
    public void testGetCouleur() {
        System.out.println("getCouleur");
        Piece instance = new Piece(WHITE);
        ColorP expResult = WHITE;
        ColorP result = instance.getColor();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getColor method, of class Piece.
     */
    @Test
    public void testGetCouleur2() {
        System.out.println("getCouleur");
        Piece instance = new Piece(BLACK);
        ColorP expResult = BLACK;
        ColorP result = instance.getColor();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getColor method, of class Piece.
     */
    @Test
    public void testGetCouleur3() {
        System.out.println("getCouleur");
        Piece instance = new Piece(EMPTY);
        ColorP expResult = EMPTY;
        ColorP result = instance.getColor();
        assertEquals(expResult, result);
    }
    
}
