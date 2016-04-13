package net.keinesorgen.alg.prefix.CountDiv;

/**
 * O(1) for time and space complexity
 */
public class CountDiv {

    public int solution(int A, int B, int K) {
        int count = B/K-A/K;
        if(A%K==0) count++;                        
        return count;
    }
}
