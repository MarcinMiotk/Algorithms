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
    public void official_1() {
        String input = ""
                + "4 4 1\n"
                + "1 2 3 4\n"
                + "5 6 7 8\n"
                + "9 10 11 12\n"
                + "13 14 15 16";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals(""
                + "2 3 4 8\r\n"
                + "1 7 11 12\r\n"
                + "5 6 10 16\r\n"
                + "9 13 14 15", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = ""
                + "4 4 2\n"
                + "1 2 3 4\n"
                + "5 6 7 8\n"
                + "9 10 11 12\n"
                + "13 14 15 16";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals(""
                + "3 4 8 12\r\n"
                + "2 11 10 16\r\n"
                + "1 7 6 15\r\n"
                + "5 9 13 14", outContent.toString().trim());
    }

    @Test
    public void official_3() {
        String input = ""
                + "5 4 7\n"
                + "1 2 3 4\n"
                + "7 8 9 10\n"
                + "13 14 15 16\n"
                + "19 20 21 22\n"
                + "25 26 27 28";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals(""
                + "28 27 26 25\r\n"
                + "22 9 15 19\r\n"
                + "16 8 21 13\r\n"
                + "10 14 20 7\r\n"
                + "4 3 2 1", outContent.toString().trim());
    }

    @Test
    public void official_4() {
        String input = ""
                + "2 2 3\n"
                + "1 1\n"
                + "1 1";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals(""
                + "1 1\r\n"
                + "1 1", outContent.toString().trim());
    }
}
