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
public class InsertionSortPartSecondTest {

    public InsertionSortPartSecondTest() {
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
        String input = "6\n"
                + "1 4 3 5 6 2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InsertionSortPartSecond.main(null);
        assertEquals(""
                + "1 4 3 5 6 2\r\n"
                + "1 3 4 5 6 2\r\n"
                + "1 3 4 5 6 2\r\n"
                + "1 3 4 5 6 2\r\n"
                + "1 2 3 4 5 6", outContent.toString().trim());
    }

}
