package com.snmill.cp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
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
    public void findDigits_official() {
        String input = "25";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("15511210043330985984000000", outContent.toString().trim());
    }

    @Test
    public void factorialOf_1() {
        assertEquals("1", Solution.factorialOf(1));
    }

    @Test
    public void factorialOf_2() {
        assertEquals("2", Solution.factorialOf(2));
    }

    @Test
    public void factorialOf_3() {
        assertEquals("6", Solution.factorialOf(3));
    }

    @Test
    public void factorialOf_4() {
        assertEquals("24", Solution.factorialOf(4));
    }

}
