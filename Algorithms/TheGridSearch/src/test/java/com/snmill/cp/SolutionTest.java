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
        String input = "2\n"
                + "10 10\n"
                + "7283455864\n"
                + "6731158619\n"
                + "8988242643\n"
                + "3830589324\n"
                + "2229505813\n"
                + "5633845374\n"
                + "6473530293\n"
                + "7053106601\n"
                + "0834282956\n"
                + "4607924137\n"
                + "3 4\n"
                + "9505\n"
                + "3845\n"
                + "3530\n"
                + "15 15\n"
                + "400453592126560\n"
                + "114213133098692\n"
                + "474386082879648\n"
                + "522356951189169\n"
                + "887109450487496\n"
                + "252802633388782\n"
                + "502771484966748\n"
                + "075975207693780\n"
                + "511799789562806\n"
                + "404007454272504\n"
                + "549043809916080\n"
                + "962410809534811\n"
                + "445893523733475\n"
                + "768705303214174\n"
                + "650629270887160\n"
                + "2 2\n"
                + "99\n"
                + "99";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("YES\r\n"
                + "NO", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = "2\n"
                + "20 20\n"
                + "34889246430321978567\n"
                + "58957542800420926643\n"
                + "35502505614464308821\n"
                + "14858224623252492823\n"
                + "72509980920257761017\n"
                + "22842014894387119401\n"
                + "01112950562348692493\n"
                + "16417403478999610594\n"
                + "79426411112116726706\n"
                + "65175742483779283052\n"
                + "89078730337964397201\n"
                + "13765228547239925167\n"
                + "26113704444636815161\n"
                + "25993216162800952044\n"
                + "88796416233981756034\n"
                + "14416627212117283516\n"
                + "15248825304941012863\n"
                + "88460496662793369385\n"
                + "59727291023618867708\n"
                + "19755940017808628326\n"
                + "7 4\n"
                + "1641\n"
                + "7942\n"
                + "6517\n"
                + "8907\n"
                + "1376\n"
                + "2691\n"
                + "2599\n"
                + "25 25\n"
                + "7652157548860692421022503\n"
                + "9283597467877865303553675\n"
                + "4160389485250089289309493\n"
                + "2583470721457150497569300\n"
                + "3220130778636571709490905\n"
                + "3588873017660047694725749\n"
                + "9288991387848870159567061\n"
                + "4840101673383478700737237\n"
                + "8430916536880190158229898\n"
                + "8986106490042260460547150\n"
                + "2591460395957631878779378\n"
                + "1816190871689680423501920\n"
                + "0704047294563387014281341\n"
                + "8544774664056811258209321\n"
                + "9609294756392563447060526\n"
                + "0170173859593369054590795\n"
                + "6088985673796975810221577\n"
                + "7738800757919472437622349\n"
                + "5474120045253009653348388\n"
                + "3930491401877849249410013\n"
                + "1486477041403746396925337\n"
                + "2955579022827592919878713\n"
                + "2625547961868100985291514\n"
                + "3673299809851325174555652\n"
                + "4533398973801647859680907\n"
                + "5 4\n"
                + "5250\n"
                + "1457\n"
                + "8636\n"
                + "7660\n"
                + "7848";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("NO\r\n"
                + "YES", outContent.toString().trim());
    }

    @Test
    public void official_3_failed() {
        InputStream is = SolutionTest.class.getResourceAsStream("/testcase_failed");
        System.setIn(is);

        Solution.main(null);
        assertEquals("YES\r\n"
                + "YES\r\n"
                + "NO\r\n"
                + "YES\r\n"
                + "NO", outContent.toString().trim());
    }

    @Test
    public void official_3_failed_single() {
        InputStream is = SolutionTest.class.getResourceAsStream("/testcase_failed_single");
        System.setIn(is);

        Solution.main(null);
        assertEquals("YES", outContent.toString().trim());
    }

    @Test
    public void edge() {
        String input = "1\n"
                + "4 5\n"
                + "12340\n"
                + "43210\n"
                + "56780\n"
                + "87650\n"
                + "4 4\n"
                + "1234\n"
                + "4321\n"
                + "5678\n"
                + "8765";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("YES", outContent.toString().trim());
    }
}
