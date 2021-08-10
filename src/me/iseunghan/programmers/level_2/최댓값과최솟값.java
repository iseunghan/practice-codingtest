package me.iseunghan.programmers.level_2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12939
 */
public class 최댓값과최솟값 {
    class Solution {
        public String solution(String s) {
            int MAX = Integer.MIN_VALUE;
            int MIN = Integer.MAX_VALUE;

            String[] arr = s.split(" ");

            for (int i = 0; i < arr.length; i++) {
                int val = Integer.parseInt(arr[i]);
                if (MAX < val) {
                    MAX = val;
                }
                if (MIN > val) {
                    MIN = val;
                }
            }

            String answer = "";
            answer = MIN + " " + MAX;

            return answer;
        }
    }
}