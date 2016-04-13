package net.keinesorgen.puzzle.kdimension;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        int data[] = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = in.nextInt();
        }
    }

    protected int solution(int N, int K, int[] data) {
        int count = 0;
        Arrays.sort(data);
        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < data.length; j++) {
                int difference = data[i] - data[j];
                if (difference == K) {
                    count++;
                } else if (difference < K) {
                    break;
                }
            }
        }
        return count;
    }
}
