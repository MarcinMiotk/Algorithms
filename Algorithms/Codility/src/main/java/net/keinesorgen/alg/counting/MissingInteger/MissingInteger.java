package net.keinesorgen.alg.counting.MissingInteger;

/**
 * expected worst-case time complexity is O(N)
 *
 * expected worst-case space complexity is O(N)
 */
public class MissingInteger {

    /**
     * Wnioski
     *
     * 1. Zakres to od 1 do 100 0000
     *
     * 2. Staramy sie zaalokowac wartosc 1, jesli zajete to 2, jesli zajete to
     * 3, jesli zajete to 4 i tak dalej. Na samym koncu 100 000.
     *
     * 3. Jesli bedzie ciag 1,2,3,4, 99 000, 100 000, 100 0001 itd, to i tak
     * rozwiazanie zmiesci sie w tablicy [1...100 000]. Niezaleznie od wartosci
     * w A, rozwiazanie jest z przedzialu od 1 do 100 001.
     *
     *
     * @param A
     * @return minimal positive integer that does not occur in A
     */
    public int solution(int[] A /* [1..100,000] */) {
        boolean[] counters = new boolean[A.length];
        int used = A.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (max < value) {
                max = value;
            }
            // normalize to array
            value--;
            // mark
            if (value >= 0 && value < counters.length) {
                if (!counters[value]) {
                    counters[value] = true;
                    used--;
                }
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (!counters[i]) {
                return i + 1;
            }
        }
        return max + 1;
    }
}
