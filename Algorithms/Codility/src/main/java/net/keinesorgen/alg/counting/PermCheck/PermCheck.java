package net.keinesorgen.alg.counting.PermCheck;

/**
 *
 */
public class PermCheck {

    public boolean solutionB(int[] A) {
        // for N=4 permutation is 1,2,3,4 and sum is (1+4)*4/2      
        long expectedSum = (1L + A.length) * A.length / 2L;
        long realSum = 0;

        for (int item : A) {
            realSum += item;
        }

        if (expectedSum == realSum) {

            // jesli wartosc 5 zosala znaleziona to robimy negacje wartosci A[5].
            // jesli pod A[5] byla juz wczesniej negacja, to oznacza ze jest
            // to duplikat wartosci 5, czyli na pewno nie ma tu permutacji
            // na koniec wszystkie wartosci w tablicy powinny byc ujemne
            for (int i = 0; i < A.length; i++) {
                // offset to array index
                int value = Math.abs(A[i]) - 1;
                // is between 1 and N
                if (value >= 0 && value < A.length) {
                    if (A[value] > 0) {
                        A[value] = -A[value];
                    } else {
                        // it is not permutation
                        return false;
                    }
                } else {
                    // it is not permutation
                    return false;
                }
            }

            for (int i = 0; i < A.length; i++) {
                if (A[i] > 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public int solution(int[] A) {
        return solutionB(A) ? 1 : 0;
    }
}
