package me.iseunghan.programmers.level_2;

import java.util .Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12941?language=java
 */
public class 최솟값만들기 {

    class Solution {
        public int solution(int[] A, int[] B) {
            int len = A.length;
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            for (int i = 0; i < len; i++) {
                answer += A[i] * B[len - i - 1];
            }

            return answer;
        }
    }
}
