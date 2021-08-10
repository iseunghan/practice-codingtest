package me.iseunghan.programmers.level_1;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 */
public class 상호평가 {
    class Solution {
        public String solution(int[][] scores) {
            StringBuffer sb = new StringBuffer();
            int sum = 0, len = scores[0].length;
            // [0] : idx, [1] : value, [2] : count
            int[] MAX = new int[3];
            int[] MIN = new int[3];

            for (int i = 0; i < scores.length; i++) {
                sum = 0;
                // MAX, MIN값 세팅
                MAX[1] = 0;
                MIN[1] = 100;
                for (int j = 0; j < scores[0].length; j++) {
                    // j를 '행'처럼, i를 '열'처럼 사용!
                    if (scores[j][i] > MAX[1]) {
                        MAX[0] = j;
                        MAX[1] = scores[j][i];
                        MAX[2] = 1;
                    } else if (scores[j][i] == MAX[1]) {
                        MAX[2]++;
                    }
                    if (MIN[1] > scores[j][i]) {
                        MIN[0] = j;
                        MIN[1] = scores[j][i];
                        MIN[2] = 1;
                    } else if (scores[j][i] == MIN[1]) {
                        MIN[2]++;
                    }
                    sum += scores[j][i];
                }
                // 만약 MAX, MIN값의 인덱스가 자기 자신이라면
                if (i == MAX[0]) {
                    if (MAX[1] != MIN[1] && MAX[2] == 1) {
                        sum -= MAX[1];
                        sb.append(getGrade(sum / (len - 1)));
                        continue;
                    }
                } else if (i == MIN[0]) {
                    if (MAX[1] != MIN[1] && MIN[2] == 1) {
                        sum -= MIN[1];
                        sb.append(getGrade(sum / (len - 1)));
                        continue;
                    }
                }
                sb.append(getGrade(sum / len));
            }

            return sb.toString();
        }

        // 성적을 반환해주는 메소드
        public String getGrade(int score) {
            if (score >= 90) {
                return "A";
            } else if (score >= 80) {
                return "B";
            } else if (score >= 70) {
                return "C";
            } else if (score >= 50) {
                return "D";
            }
            return "F";
        }
    }
}
