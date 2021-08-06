package me.iseunghan.programmers.level_2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 * 프로그래머스 > 2021 Dev-Matching 웹 백엔드 개발자(상반기) > 행렬 테두리 회전하기
 */
public class 행렬_테두리_회전하기 {

    static class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            // 배열 생성
            int[][] arr = new int[rows + 1][columns + 1];
            int[][] cpy = new int[rows + 1][columns + 1];
            int num = 1;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= columns; j++) {
                    arr[i][j] = num;
                    cpy[i][j] = num++;
                }
            }

            for (int q = 0; q < queries.length; q++) {
                int MIN = rows * columns;

                int x1 = queries[q][0];
                int y1 = queries[q][1];
                int x2 = queries[q][2];
                int y2 = queries[q][3];

                /* 행렬 테두리를 찾아서 큐에 넣는 로직 */

                // 1. 사각형의 상단 부분 탐색
                for (int i = y1; i < y2; i++) {
                    // 값 복사
                    arr[x1][i + 1] = cpy[x1][i];
                    // 최솟값 비교
                    if (MIN > arr[x1][i + 1]) {
                        MIN = arr[x1][i + 1];
                    }
                }
                // 2. 사각형의 오른쪽 부분 탐색
                for (int i = x1; i < x2; i++) {
                    arr[i + 1][y2] = cpy[i][y2];

                    if (MIN > arr[i + 1][y2]) {
                        MIN = arr[i + 1][y2];
                    }
                }

                // 3. 사각형의 하단 부분 탐색
                for (int i = y2; i > y1; i--) {
                    arr[x2][i - 1] = cpy[x2][i];

                    if (MIN > arr[x2][i - 1]) {
                        MIN = arr[x2][i - 1];
                    }
                }

                // 4. 사각형의 왼쪽 부분 탐색
                for (int i = x2; i > x1; i--) {
                    arr[i - 1][y1] = cpy[i][y1];

                    if (MIN > arr[i - 1][y1]) {
                        MIN = arr[i - 1][y1];
                    }
                }
                // 최솟값을 저장!
                answer[q] = MIN;

                // 회전한 배열을 다시 cpy 배열로 복사!
                copy_Array(arr, cpy);
            }


            return answer;
        }

        // 2차원 배열의 깊은 복사 메소드
        static void copy_Array(int[][] original, int[][] destination) {
            for (int i = 1; i < original.length; i++) {
                for (int j = 1; j < original[0].length; j++) {
                    destination[i][j] = original[i][j];
                }
            }
        }
    }
}
