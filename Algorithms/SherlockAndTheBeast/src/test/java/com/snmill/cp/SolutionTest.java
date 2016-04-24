package com.snmill.cp;

import com.snmill.cp.Solution.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

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
    public void official() {
        String input = ""
                + "4\n"
                + "1\n"
                + "3\n"
                + "5\n"
                + "11";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("-1\r\n"
                + "555\r\n"
                + "33333\r\n"
                + "55555533333", outContent.toString().trim());
    }

    @Test
    public void official_but_I_got_error_At_1_submit() {
        String input = ""
                + "20\n"
                + "93579\n"
                + "71254\n"
                + "19943\n"
                + "35305\n"
                + "49521\n"
                + "97230\n"
                + "44568\n"
                + "96635\n"
                + "16488\n"
                + "33271\n"
                + "61297\n"
                + "66001\n"
                + "3016\n"
                + "25151\n"
                + "759\n"
                + "30263\n"
                + "96388\n"
                + "14065\n"
                + "57296\n"
                + "66223";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);

        System.out.println(outContent.toString().trim());
//        
//        assertEquals("-1\r\n"
//                + "555\r\n"
//                + "33333\r\n"
//                + "55555533333", outContent.toString().trim());
    }

    @Test
    public void largestDecentNumber_1() {
        String decent = Solution.largestDecentNumberAsString(1);
        assertEquals("-1", decent);
    }

    @Test
    public void largestDecentNumber_2() {
        String decent = Solution.largestDecentNumberAsString(2);
        assertEquals("-1", decent);
    }

    @Test
    public void largestDecentNumber_3() {
        String decent = Solution.largestDecentNumberAsString(3);
        assertEquals("555", decent);
    }

    @Test
    public void largestDecentNumber_4() {
        String decent = Solution.largestDecentNumberAsString(4);
        assertEquals("-1", decent);
    }

    @Test
    public void largestDecentNumber_5() {
        String decent = Solution.largestDecentNumberAsString(5);
        assertEquals("33333", decent);
    }

    @Test
    public void largestDecentNumber_6() {
        String decent = Solution.largestDecentNumberAsString(6);
        assertEquals("555555", decent);
    }

    @Test
    public void largestDecentNumber_7() {
        String decent = Solution.largestDecentNumberAsString(7);
        assertEquals("-1", decent);
    }

    @Test
    public void largestDecentNumber_8() {
        String decent = Solution.largestDecentNumberAsString(8);
        assertEquals("55533333", decent);
    }

    @Test
    public void largestDecentNumber_93579() {
        Response response = Solution.largestDecentNumber(93579);
        assertEquals(0, response.count3);
        assertEquals(93579, response.count5);
    }

    @Test
    public void largestDecentNumber_71254() {
        Response response = Solution.largestDecentNumber(71254);
        assertEquals(10, response.count3);
        assertEquals(71244, response.count5);
    }

    @Test
    public void largestDecentNumber_19943() {
        Response response = Solution.largestDecentNumber(19943);
        assertEquals(5, response.count3);
        //    assertEquals(71244, response.count5);
    }

    @Test
    public void largestDecentNumber_35305() {
        Response response = Solution.largestDecentNumber(35305);
        assertEquals(10, response.count3);
        //    assertEquals(71244, response.count5);
    }

    @Test
    public void largestDecentNumber_49521() {
        Response response = Solution.largestDecentNumber(49521);
        assertEquals(0, response.count3);
        assertEquals(49521, response.count5);
    }

    @Test
    public void largestDecentNumber_97230() {
        Response response = Solution.largestDecentNumber(97230);
        assertEquals(0, response.count3);
        assertEquals(97230, response.count5);
    }

    @Test
    public void largestDecentNumber_44568() {
        Response response = Solution.largestDecentNumber(44568);
        assertEquals(0, response.count3);
        assertEquals(44568, response.count5);
    }

    @Test
    public void largestDecentNumber_66223() {
        Response response = Solution.largestDecentNumber(66223);
        assertEquals(10, response.count3);
        assertEquals(66223 - 10, response.count5);
    }

    @Test
    public void largestDecentNumber_57296() {
        Response response = Solution.largestDecentNumber(57296);
        assertEquals(5, response.count3);
        assertEquals(57296 - 5, response.count5);
    }

    @Test
    public void largestDecentNumber_14065() {
        Response response = Solution.largestDecentNumber(14065);
        assertEquals(10, response.count3);
        assertEquals(14065 - 10, response.count5);
    }

//                + "96635\n"
//                + "16488\n"
//                + "33271\n"
//                + "61297\n"
//                + "66001\n"
//                + "3016\n"
//                + "25151\n"
//                + "759\n"
//                + "30263\n"
//                + "96388\n"
}
