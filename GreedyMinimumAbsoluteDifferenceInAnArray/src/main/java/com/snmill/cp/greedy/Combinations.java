package com.snmill.cp.greedy;

class Combinations {


    static int countCombinationsWithoutRepetitions(int k, int n) {
        int up = factorial(n);
        int down_difference = factorial(n-k);
        int down_k = factorial(k);
        int down = down_difference*down_k;
        int result = up/down;
        return result;
    }

    static int factorial(int n) {
        int factorialnumbers=1;
        while(n>0){
            factorialnumbers=factorialnumbers*n;
            n--;
        }
        return factorialnumbers;
    }
}
