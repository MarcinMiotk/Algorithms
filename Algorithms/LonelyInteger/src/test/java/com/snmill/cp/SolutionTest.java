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
    public void findTheNumberThatOccursOnlyOnce_official_test() {
        String input = ""
                + "1\n"
                + "1";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("1", outContent.toString().trim());
    }

    @Test
    public void findTheNumberThatOccursOnlyOnce_official_test2() {
        String input = ""
                + "3\n"
                + "1 1 2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("2", outContent.toString().trim());
    }

    @Test
    public void findTheNumberThatOccursOnlyOnce_official_test3() {
        String input = ""
                + "5\n"
                + "0 0 1 2 1";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("2", outContent.toString().trim());
    }
}
