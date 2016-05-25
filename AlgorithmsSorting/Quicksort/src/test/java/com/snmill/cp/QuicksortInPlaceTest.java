package com.snmill.cp;

import static com.snmill.cp.QuicksortInPlace.partition;
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
public class QuicksortInPlaceTest {

    public QuicksortInPlaceTest() {
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
        String input = "7\n"
                + "1 3 9 8 2 7 5";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        QuicksortInPlace.main(null);
        assertEquals(""
                + "1 3 2 5 9 7 8\r\n"
                + "1 2 3 5 9 7 8\r\n"
                + "1 2 3 5 7 8 9", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = "9\n"
                + "9 8 6 7 3 5 4 1 2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        QuicksortInPlace.main(null);
        assertEquals(""
                + "1 2 6 7 3 5 4 9 8\r\n"
                + "1 2 6 7 3 5 4 8 9\r\n"
                + "1 2 3 4 6 5 7 8 9\r\n"
                + "1 2 3 4 6 5 7 8 9\r\n"
                + "1 2 3 4 5 6 7 8 9", outContent.toString().trim());
    }

    @Test
    public void partition_returnsPartitionOfWholeInput() {
        int[] input = new int[]{1, 3, 9, 8, 2, 7, 5};
        int nextPivotIndex = partition(input, 0, input.length);
        assertArrayEquals(new int[]{1, 3, 2, 5, 9, 7, 8}, input);
        assertEquals(3, nextPivotIndex);
    }

    @Test
    public void partition_returnsPartitionOfFirstPartOfInput() {
        int[] input = new int[]{1, 3, 2, 5, 9, 7, 8};
        int nextPivotIndex = partition(input, 0, 3);
        assertArrayEquals(new int[]{1, 2, 3, 5, 9, 7, 8}, input);
        assertEquals(1, nextPivotIndex);
    }

    @Test
    public void partition_returnsPartitionOfSecondPartOfInput() {
        int[] input = new int[]{1, 2, 3, 5, 9, 7, 8};
        int nextPivotIndex = partition(input, 4, input.length);
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 8, 9}, input);
        assertEquals(5, nextPivotIndex);
    }

}
