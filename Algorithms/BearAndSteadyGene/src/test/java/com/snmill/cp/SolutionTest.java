package com.snmill.cp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
        String input = "8\n"
                + "GAAATAAA";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("5", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = "40\n"
                + "TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("5", outContent.toString().trim());
    }

    @Test
    public void official_3() {
        String input = "2000\n"
                + "ACAAAAATAAACAAAAACAAAAAAAAAATAAATACAATAAAAAAAAAAAATGAAATACAACAACAAATAAAATAAAAACGACTAAAAAATAAAAAAAAAAAAAAAAAGAGTACTAAAAAAAAAAAAAAAAAATAAAAAAAAAAAAAACACAATCAAAATAAACAAAAAAAAAAAAACCAAAATAATCAACAAAAAAAAAAAAAACAAAAACAACAACAAACAAAAAAAAACACAAACAAAAAAAAAAAAAAAACAAAACAAACAAAAAAAAAAAAACAAAAAAACAAAAAAAAAAAAAAAAACAAAAAAAAAAATAAAAAAAAAAAAAAAAAAAAAACAAACAAAAAAAAAAAATACAAAAAGCTATAAAAAAAAAAAAATTAAAAAACAAAAAAAAATAAAAAAAAAAAAAAAAAAAAAAAATAAAAAAAAAAAAAAAAAAAAAATAAAAAAAAAAAAAAAAAAGAAAAACAAAAAAAAAAAAAAAAACAACCAAAAAACAAAAAAAAACTAAAAAAAAAAAAAAAAAAAAAAAAAAATAACAAAAAACACAAAAAAAAAAAAGAAAGAAAAAAAACACAAAAAAAAACAAACAAAAAAAAAAAAAAAAAAAGAAAACAAAAAAACAAAAAAAACAAAAAAAAAACAAAAATTGGACAAAAAAAAACAAAAAAAAAAAACAAAAAAAGTAAAACAAATAAAAAAACAAAAAAAACAAAAAAAAAAAAAAAAAACAAAAAAGAAACAAAAAACAAAAAAAAATAACAAAACCAAAAAACAAATAAAAAACAAAAAAAATAACACAAAAAAAAAAAGAAACAAAAAAAAAAAAAAAAAAAAAAATTATAAAAAAAAAAAAAAAACAAAAAAAAAAAAAACAAAAAAAAAAGGAAAAAAAAAAAAAAAAAAAAAAAAAAATAACTAAACAAAAAAAAACAAACAAAAAATCAAAAAAAAAAAAGAAAAAAGAATAAGCAACAAAAACACAAAAAAAAAAAAAAAAAAAAAAAACATAAACAATAATAAAAAAAAAACAAAAAAAACAAAAGAACAACAAAAAACAAAACTAAACAAATAAAAAAAAAAAAACAAAAACTACAAAAAAAAAAAGAAAAAAAAAGAAAAAAAAACAAATAAAAGAAAAAAAAAAAAAAAAAAAACACAAAAAAAAAAATAAAAAAAAAAAAAAAAACAAAATAAACAAAAACAAAGAAAAAAACAAACAAAAAAAAAAAACAAAAAACTAAAAACAAAAAAAAAACAAAACACAAAAAAAAAAAAAAATAAAAAAAAAACAAAAAAACAAAAAGGAAAAAAAAAAAAGAACAAAAAAAAAAACAACAGAAAAAAGAAAAGAAAAAAAAAAAAAGACCACAAAATAAAAAAAAACAACAAACAAAAAAAAACAAAACAAAAAAACGAACAAAAAAAACAAAAACAAAAAAAAAAAAAAAAAAAAAAAGGCAAAAACAAAAAAAACAAAACAAAACAAAAAAACAAAAAAAAATTAAGATAAAGAACAAAAAAAGAAGAGAAAAAATTAACAAAAAAAAAAAAATAAAAAATACAAAAAGAAATAAAAAATACAACACACAACAAAAACGAAAAAAAAAAAAAAAACACAAAATAGAAAAAAAAAAAAAACAAAAAAAAAAAAAAGAAAAAAACAAAAAAAAAAAAATAAAAAAAAACGACACAGAAACAAAAAATAACAAAAAAAAAAAAAATAAAAAAAAAACAAAAAAAAAACAAAAAATAAAAAAAAAAACAAACAAAAAAAAAAAAAAAATAAAAAAAAAAAAAGCAAAACATAAACAAGAAAAAAAAAAAAAGTACAAATAACAAAACAAAAAAGACACTAAAAAAAAAAAAAAAAAACAAAAAAAAAAAAAAAAAAAAAAAAAGAAAAAAAACCACAAAACAAAAAAATAAAGCAAAAAAAAAAAAAAAAAAAAAAAAAAAATAAATGAAAAAAAAAAGAAAACCAAAAAAATAAAAGA";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("1393", outContent.toString().trim());
    }

    @Test
    public void official_4() {
        InputStream fromFile = SolutionTest.class.getResourceAsStream("/timeout");
        System.setIn(fromFile);
        Solution.main(null);
        assertEquals("206", outContent.toString().trim());
    }
}
