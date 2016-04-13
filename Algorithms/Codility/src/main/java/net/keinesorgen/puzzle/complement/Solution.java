package net.keinesorgen.puzzle.complement;

import java.util.BitSet;

/**
 *
 */
public class Solution {

    static int getIntegerComplement(int n) {
        BitSet from = BitSet.valueOf(new long[] {(long)n});
        String value = Integer.toBinaryString(n);      
        BitSet target = new BitSet(from.length());        
        for(int i=0; i<from.length(); i++) {
            boolean bit = from.get(i);
            target.set(i, !bit);
        }        
        long[] casted = target.toLongArray();
        int result = (int) casted[0];        
        return result;
    }

    public static void main(String[] args) {
    }

}
