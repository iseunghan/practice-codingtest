package me.iseunghan.programmers.고득점Kit.완전탐색;

import java.lang.Math;

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            // 전체 면적 구하기
            int area = brown + yellow;
            // 정답 배열 선언
            int[] answer = new int[2];

            // 제곱근까지의 숫자를 다 시도한다.
            for (int h = 1; h <= Math.sqrt(yellow); h++) {
                // 나머지가 0인 수라면?
                if (yellow % h == 0) {
                    // 임시 가로길이 구하기
                    int w = yellow / h;

                    // 만약 임시 가로 세로의 넓이 값이 area와 같다면? 정답!
                    if ((h + 2) * (w + 2) == area) {
                        answer[0] = Math.max(w, h) + 2;
                        answer[1] = Math.min(w, h) + 2;
                    }
                }
            }
            return answer;
        }
    }
}
