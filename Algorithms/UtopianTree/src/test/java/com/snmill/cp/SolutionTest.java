package com.snmill.cp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class SolutionTest {

    public SolutionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void utopianTreeFor_0_is_1() {
        assertEquals(1, Solution.utopianTree(0));
    }

    @Test
    public void utopianTreeFor_1_is_2() {
        assertEquals(2, Solution.utopianTree(1));
    }

    @Test
    public void utopianTreeFor_4_is_7() {
        assertEquals(7, Solution.utopianTree(4));
    }

    @Test
    public void testMain_31() {
        String input = "3\n"
                + "0\n"
                + "1\n"
                + "4";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("1\r\n"
                + "2\r\n"
                + "7", outContent.toString().trim());
    }

}
