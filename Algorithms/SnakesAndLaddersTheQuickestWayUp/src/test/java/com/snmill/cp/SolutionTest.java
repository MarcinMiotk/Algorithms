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
                + "2\n"
                + "3\n"
                + "32 62\n"
                + "42 68\n"
                + "12 98\n"
                + "7\n"
                + "95 13\n"
                + "97 25\n"
                + "93 37\n"
                + "79 27\n"
                + "75 19\n"
                + "49 47\n"
                + "67 17\n"
                + "4\n"
                + "8 52\n"
                + "6 80\n"
                + "26 42\n"
                + "2 72\n"
                + "9\n"
                + "51 19\n"
                + "39 11\n"
                + "37 29\n"
                + "81 3\n"
                + "59 5\n"
                + "79 23\n"
                + "53 7\n"
                + "43 33\n"
                + "77 21 ";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("3\r\n"
                + "5", outContent.toString().trim());
    }

}
