package com.snmill.cp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
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
        String input = "11\n"
                + "middle-Outz\n"
                + "2";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("okffng-Qwvb", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = "10\n"
                + "159357lcfd\n"
                + "98";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("159357fwzx", outContent.toString().trim());
    }

    @Test
    public void symbolsAreNotEncrypted() {
        String result = Solution.encrypt("-!", 2, (byte) 0x02);
        assertEquals("-!", result);
    }

    @Test
    public void fchangesintof_after_98_key() {
        String result = Solution.encrypt("l", 1, (byte) 98);
        assertEquals("f", result);
    }
}
