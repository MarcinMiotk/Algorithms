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
    public void countTheNumberOfSquareIntegersBetween_official() {
        String input = ""
                + "2\n"
                + "3 9\n"
                + "17 24";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("2\r\n"
                + "0", outContent.toString().trim());
    }

    @Test
    public void countTheNumberOfSquareIntegersBetween_64_822() {
        int squares = Solution.countTheNumberOfSquareIntegersBetween(64, 822);
        assertEquals(21, squares);
    }

    @Test
    public void experiment() {
        int a = 64;
        int b = 822;

        double bSqrt = Math.sqrt(b);
        double aSqrt = Math.sqrt(a);

        double difference = bSqrt - aSqrt + 1;

        int squares = (int) Math.floor(difference);
        assertEquals(21, squares);
    }

    @Test
    public void countTheNumberOfSquareIntegersBetween_213_874() {
        int squares = Solution.countTheNumberOfSquareIntegersBetween(213, 874);
        assertEquals(15, squares);
    }

    @Test
    public void countTheNumberOfSquareIntegersBetween_failed_at_first_submit() {
        String input = ""
                + "100\n"
                + "213 874\n"
                + "300 346\n"
                + "252 879\n"
                + "208 867\n"
                + "152 871\n"
                + "47 320\n"
                + "53 292\n"
                + "152 823\n"
                + "354 800\n"
                + "275 558\n"
                + "298 457\n"
                + "236 785\n"
                + "85 154\n"
                + "156 435\n"
                + "192 778\n"
                + "470 688\n"
                + "95 602\n"
                + "125 926\n"
                + "467 942\n"
                + "413 556\n"
                + "202 588\n"
                + "266 893\n"
                + "203 511\n"
                + "336 995\n"
                + "311 882\n"
                + "64 822\n"
                + "17 834\n"
                + "477 718\n"
                + "42 893\n"
                + "367 388\n"
                + "227 380\n"
                + "270 636\n"
                + "281 949\n"
                + "69 360\n"
                + "184 945\n"
                + "488 723\n"
                + "294 860\n"
                + "40 47\n"
                + "130 421\n"
                + "423 583\n"
                + "294 599\n"
                + "172 669\n"
                + "216 275\n"
                + "159 859\n"
                + "478 552\n"
                + "35 180\n"
                + "404 795\n"
                + "301 907\n"
                + "275 668\n"
                + "124 886\n"
                + "53 203\n"
                + "63 687\n"
                + "405 826\n"
                + "125 419\n"
                + "212 667\n"
                + "91 317\n"
                + "16 368\n"
                + "94 277\n"
                + "414 558\n"
                + "370 756\n"
                + "82 689\n"
                + "57 927\n"
                + "476 511\n"
                + "96 688\n"
                + "346 454\n"
                + "46 855\n"
                + "277 694\n"
                + "232 350\n"
                + "73 578\n"
                + "194 660\n"
                + "45 827\n"
                + "40 943\n"
                + "354 661\n"
                + "241 947\n"
                + "457 607\n"
                + "336 778\n"
                + "34 696\n"
                + "152 911\n"
                + "36 423\n"
                + "280 511\n"
                + "213 281\n"
                + "428 961\n"
                + "149 527\n"
                + "202 711\n"
                + "41 747\n"
                + "494 587\n"
                + "72 269\n"
                + "460 940\n"
                + "204 824\n"
                + "182 555\n"
                + "6 744\n"
                + "344 454\n"
                + "475 814\n"
                + "394 446\n"
                + "422 618\n"
                + "251 790\n"
                + "144 658\n"
                + "121 743\n"
                + "31 711\n"
                + "354 387";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("15\r\n"
                + "1\r\n"
                + "14\r\n"
                + "15\r\n"
                + "17\r\n"
                + "11\r\n"
                + "10\r\n"
                + "16\r\n"
                + "10\r\n"
                + "7\r\n"
                + "4\r\n"
                + "13\r\n"
                + "3\r\n"
                + "8\r\n"
                + "14\r\n"
                + "5\r\n"
                + "15\r\n"
                + "19\r\n"
                + "9\r\n"
                + "3\r\n"
                + "10\r\n"
                + "13\r\n"
                + "8\r\n"
                + "13\r\n"
                + "12\r\n"
                + "21\r\n"
                + "24\r\n"
                + "5\r\n"
                + "23\r\n"
                + "0\r\n"
                + "4\r\n"
                + "9\r\n"
                + "14\r\n"
                + "10\r\n"
                + "17\r\n"
                + "4\r\n"
                + "12\r\n"
                + "0\r\n"
                + "9\r\n"
                + "4\r\n"
                + "7\r\n"
                + "12\r\n"
                + "2\r\n"
                + "17\r\n"
                + "2\r\n"
                + "8\r\n"
                + "8\r\n"
                + "13\r\n"
                + "9\r\n"
                + "18\r\n"
                + "7\r\n"
                + "19\r\n"
                + "8\r\n"
                + "9\r\n"
                + "11\r\n"
                + "8\r\n"
                + "16\r\n"
                + "7\r\n"
                + "3\r\n"
                + "8\r\n"
                + "17\r\n"
                + "23\r\n"
                + "1\r\n"
                + "17\r\n"
                + "3\r\n"
                + "23\r\n"
                + "10\r\n"
                + "3\r\n"
                + "16\r\n"
                + "12\r\n"
                + "22\r\n"
                + "24\r\n"
                + "7\r\n"
                + "15\r\n"
                + "3\r\n"
                + "9\r\n"
                + "21\r\n"
                + "18\r\n"
                + "15\r\n"
                + "6\r\n"
                + "2\r\n"
                + "11\r\n"
                + "10\r\n"
                + "12\r\n"
                + "21\r\n"
                + "2\r\n"
                + "8\r\n"
                + "9\r\n"
                + "14\r\n"
                + "10\r\n"
                + "25\r\n"
                + "3\r\n"
                + "7\r\n"
                + "2\r\n"
                + "4\r\n"
                + "13\r\n"
                + "14\r\n"
                + "17\r\n"
                + "21\r\n"
                + "1", outContent.toString().trim());
    }

    @Test
    public void countTheNumberOfSquareIntegersBetween_1_1000000000() {
        int squares = Solution.countTheNumberOfSquareIntegersBetween(1, 1000000000);
        assertEquals(31622, squares);
    }

    @Test
    public void countTheNumberOfSquareIntegersBetween_1_999950884() {
        int squares = Solution.countTheNumberOfSquareIntegersBetween(1, 999950884);
        assertEquals(31622, squares);
    }

    @Test
    public void sqrt_9() {
        double sqrt = Solution.sqrt(9.0);
        System.out.println("sqrt1=" + sqrt);
        //       assertEquals("3.0", (int) sqrt);
    }

    @Test
    public void sqrt_v2_9() {
        double sqrt = Solution.sqrt_v2(9.0);
        System.out.println("sqrt2=" + sqrt);
//        assertEquals("3.0", (int) sqrt);
    }

    @Test
    public void sqrt_NewtonRaphson_9() {
        double sqrt = Solution.sqrt_NewtonRaphson(9.0);
        System.out.println("sqrt3=" + sqrt);
//        assertEquals("3.0", (int) sqrt);
    }

}
