package me.iseunghan.programmers.level_3;

public class 정수삼각형 {
    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int len = triangle.length;

            int[][] dp = new int[triangle[len - 1].length][triangle[len - 1].length];

            // dp
            dp[0][0] = triangle[0][0];
            dp[1][0] = triangle[0][0] + triangle[1][0];
            dp[1][1] = triangle[0][0] + triangle[1][1];

            for (int i = 2; i < len; i++) {
                // 첫번째와 마지막은 따로 계산해준다.
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
                dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];

                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }

            for (int i = 0; i < len; i++) {
                answer = answer < dp[len - 1][i] ? dp[len - 1][i] : answer;
            }

            return answer;
        }
    }