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
    public void official_numberOfSticksThatAreLeftBeforeEachSubsequentCutOperations_sample_1() {
        String input = ""
                + "6\n"
                + "5 4 4 2 2 8";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("6\r\n"
                + "4\r\n"
                + "2\r\n"
                + "1", outContent.toString().trim());
    }

    @Test
    public void official_numberOfSticksThatAreLeftBeforeEachSubsequentCutOperations_sample_2() {
        String input = ""
                + "8\n"
                + "1 2 3 4 3 3 2 1";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("8\r\n"
                + "6\r\n"
                + "4\r\n"
                + "1", outContent.toString().trim());
    }

}
