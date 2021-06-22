package me.iseunghan.programmers.고득점Kit.정렬;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] result = new int[commands.length];

            for (int j = 0; j < commands.length; j++) {
                int[] answer = new int[commands[j][1] - commands[j][0] + 1];
                int idx = -1;
                for (int i = commands[j][0] - 1; i < commands[j][1]; i++) {
                    answer[++idx] = array[i];

                }
                Arrays.sort(answer);
                result[j] = answer[commands[j][2] - 1];
            }

            return result;
        }
    }
}
