package me.iseunghan.programmers.고득점Kit.정렬;

import java.util.*;

public class H_Index {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int[] citations) {
            int[] answer = new int[citations.length];

            Arrays.sort(citations);

            for (int i = citations.length - 1; i >= 0; i--) {
                answer[i] = Math.min(citations[i], citations.length - i);
            }

            Arrays.sort(answer);
            return answer[answer.length-1];
        }
    }
}
