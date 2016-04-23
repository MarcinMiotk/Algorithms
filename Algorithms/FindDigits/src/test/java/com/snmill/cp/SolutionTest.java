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
        String input = ""
                + "2\n"
                + "12\n"
                + "1012";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("2\r\n"
                + "3", outContent.toString().trim());
    }

    @Test
    public void integerToArray_1012digits() {
        int[] result = Solution.integerToArray(1012);
        assertArrayEquals(new int[]{2, 1, 0, 1}, result);
    }

    @Test
    public void integerToArray_1234digits() {
        int[] result = Solution.integerToArray(1234);
        assertArrayEquals(new int[]{4, 3, 2, 1}, result);
    }

}
