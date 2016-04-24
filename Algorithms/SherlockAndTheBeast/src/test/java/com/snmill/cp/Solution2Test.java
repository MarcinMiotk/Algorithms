package com.snmill.cp;

import java.io.ByteArrayInputStream;
import org.junit.Test;

/**
 *
 */
public class Solution2Test {

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

//        
//        assertEquals("-1\r\n"
//                + "555\r\n"
//                + "33333\r\n"
//                + "55555533333", outContent.toString().trim());
    }
}
