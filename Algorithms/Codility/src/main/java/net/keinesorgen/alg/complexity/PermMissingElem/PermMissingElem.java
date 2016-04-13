package net.keinesorgen.alg.complexity.PermMissingElem;

/**
 * expected worst-case time complexity is O(N) expected worst-case space
 * complexity is O(1)
 */
public class PermMissingElem {

    static long sum(int[] arg) {
        long sum = 0;
        for (int i : arg) {
            sum += i;
        }
        return sum;
    }

    public int solution(int[] A) {
        /**
         * (first + latest)*count/2 = Total sum
         *
         * For 4, we have 1+2+3+4 = 10         <=> (1+4)*4/2 = 10
         *
         * For 6, we have 1+2+3+4+5+6 = 21     <=> (1+6)*6/2 = 21
         *
         * For 7, we have 1+2+3+4+5+6+7 = 28   <=> (1+7)*7/2 = 28
         *
         */
        long idealSum = (1L + A.length) * A.length / 2L;
        long givenSum = sum(A);

        long missing = idealSum - givenSum + A.length + 1L;
        return (int)missing;


        /*      
         Jeśli
         Dla 4 idealnie mamy 10, a dostalismy
         2+3+1+5 = 11, przy czym wiemy ze najwieksza liczba, to 5, wiec 11-5 = 6
         Odejmujac 10 od 6 wiemy ze brakuje nam w szeregu 4.
         */
    }

}
