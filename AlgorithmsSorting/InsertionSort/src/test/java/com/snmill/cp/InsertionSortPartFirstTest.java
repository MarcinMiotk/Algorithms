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
public class InsertionSortPartFirstTest {

    public InsertionSortPartFirstTest() {
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
    public void official() {
        String input = "5\n"
                + "2 4 6 8 3";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InsertionSortPartFirst.main(null);
        assertEquals(""
                + "2 4 6 8 8\r\n"
                + "2 4 6 6 8\r\n"
                + "2 4 4 6 8\r\n"
                + "2 3 4 6 8", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = "10\n"
                + "2 3 4 5 6 7 8 9 10 1";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InsertionSortPartFirst.main(null);
        assertEquals(""
                + "2 3 4 5 6 7 8 9 10 10\r\n"
                + "2 3 4 5 6 7 8 9 9 10\r\n"
                + "2 3 4 5 6 7 8 8 9 10\r\n"
                + "2 3 4 5 6 7 7 8 9 10\r\n"
                + "2 3 4 5 6 6 7 8 9 10\r\n"
                + "2 3 4 5 5 6 7 8 9 10\r\n"
                + "2 3 4 4 5 6 7 8 9 10\r\n"
                + "2 3 3 4 5 6 7 8 9 10\r\n"
                + "2 2 3 4 5 6 7 8 9 10\r\n"
                + "1 2 3 4 5 6 7 8 9 10", outContent.toString().trim());
    }

}
