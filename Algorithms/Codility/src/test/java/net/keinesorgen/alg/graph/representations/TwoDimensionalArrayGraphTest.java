package net.keinesorgen.alg.graph.representations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 */
public class TwoDimensionalArrayGraphTest {

    public TwoDimensionalArrayGraphTest() {
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
     * Test of join method, of class TwoDimensionalArrayGraph.
     */
    @Test
    public void testJoin() throws Exception {
        System.out.println("join");
        Object source = null;
        Object[] destination = null;
        TwoDimensionalArrayGraph instance = new TwoDimensionalArrayGraph(10);
        instance.join("Marcin", "Tomek", "Krzysiek");
        instance.join("Tomek", "Jadzia");
        instance.join("Krzysiek", "Jadzia", "Zbyszek", "Paweł");
        String result = instance.toString();
        System.out.println(result);

    }

    /**
     * Test of toString method, of class TwoDimensionalArrayGraph.
     */
    @Ignore
    @Test
    public void testToString() {
        System.out.println("toString");
        TwoDimensionalArrayGraph instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
