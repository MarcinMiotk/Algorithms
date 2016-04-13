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
public class DictionaryOfNodesGraphTest {

    public DictionaryOfNodesGraphTest() {
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
     * Test of join method, of class DictionaryOfNodesGraph.
     */
    @Test
    public void testJoin() throws Exception {
        System.out.println("join");
        DictionaryOfNodesGraph instance = new DictionaryOfNodesGraph();
        instance.join("Marcin", "Tomek", "Krzysiek");
        instance.join("Tomek", "Jadzia");
        instance.join("Krzysiek", "Jadzia", "Zbyszek", "Paweł");
        String result = instance.toString();
        System.out.println(result);

    }

    /**
     * Test of toString method, of class DictionaryOfNodesGraph.
     */
    @Ignore
    @Test
    public void testToString() {
        System.out.println("toString");
        DictionaryOfNodesGraph instance = new DictionaryOfNodesGraph();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
