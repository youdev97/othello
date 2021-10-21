/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youdev.othello.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static youdev97.othello.model.Direction.E;
import static youdev97.othello.model.Direction.N;
import static youdev97.othello.model.Direction.NE;
import static youdev97.othello.model.Direction.NO;
import static youdev97.othello.model.Direction.O;
import static youdev97.othello.model.Direction.S;
import static youdev97.othello.model.Direction.SE;
import static youdev97.othello.model.Direction.SO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import youdev97.othello.model.Direction;

/**
 *
 * @author youdev97
 */
public class DirectionTest {
    
    public DirectionTest() {
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
     * Test of values method, of class Direction.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Direction[] expResult = {O, NO, N, NE, E, SE, S, SO};
        Direction[] result = Direction.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getX method, of class Direction.
     */
    @Test
    public void testGetX() {
        System.out.println("getX NO");
        Direction instance = NO;
        int expResult = -1;
        int result = instance.getX();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getX method, of class Direction.
     */
    @Test
    public void testGetX2() {
        System.out.println("getX S");
        Direction instance = S;
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Direction.
     */
    @Test
    public void testGetY() {
        System.out.println("getY NO");
        Direction instance = NO;
        int expResult = -1;
        int result = instance.getY();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getY method, of class Direction.
     */
    @Test
    public void testGetY2() {
        System.out.println("getY SE");
        Direction instance = SE;
        int expResult = 1;
        int result = instance.getY();
        assertEquals(expResult, result);
    }
}
