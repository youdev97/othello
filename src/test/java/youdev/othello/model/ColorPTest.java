/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youdev.othello.model;

import static org.junit.Assert.assertArrayEquals;
import static youdev97.othello.model.ColorP.BLACK;
import static youdev97.othello.model.ColorP.EMPTY;
import static youdev97.othello.model.ColorP.WALL;
import static youdev97.othello.model.ColorP.WHITE;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import youdev97.othello.model.ColorP;

/**
 *
 * @author youdev97
 */
public class ColorPTest {
    
    public ColorPTest() {
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
     * Test of values method, of class ColorP.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        ColorP[] expResult = {WHITE, BLACK, EMPTY, WALL};
        ColorP[] result = ColorP.values();
        assertArrayEquals(expResult, result);
    }

}
