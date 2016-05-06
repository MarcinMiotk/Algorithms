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
        String input = "haveaniceday";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("hae and via ecy", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = "feedthedog";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("fto ehg ee dd", outContent.toString().trim());
    }

    @Test
    public void official_3() {
        String input = "chillout";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("clu hlt io", outContent.toString().trim());
    }

    @Test
    public void grid_54() {
        char[][] grid = Solution.grid(54);
        assertEquals(7, grid.length);
        assertEquals(8, grid[0].length);
    }

    @Test
    public void grid_10() {
        char[][] grid = Solution.grid(10);
        assertEquals(3, grid.length);
        assertEquals(4, grid[0].length);
    }

    @Test
    public void convert() {
        char[][] grid = Solution.convert("chillout");

        char[][] expected = new char[][]{
            {'c', 'h', 'i'},
            {'l', 'l', 'o'},
            {'u', 't', 0}};

        assertArrayEquals(expected, grid);
    }

    @Test
    public void convert_feedthedog() {
        char[][] grid = Solution.convert("feedthedog");

        char[][] expected = new char[][]{
            {'f', 'e', 'e', 'd'},
            {'t', 'h', 'e', 'd'},
            {'o', 'g', 0, 0}};

        assertArrayEquals(expected, grid);
    }
}
