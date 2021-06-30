package me.iseunghan.programmers.고득점Kit.DFS_BFS;

public class 타겟넘버 {
    public static void main(String[] args) {

    }

    static class Solution {
        static int answer = 0;
        static int MAX = 0;

        public int solution(int[] numbers, int target) {
            MAX = numbers.length;

            recur(0, target, 0, numbers);   // 재귀 함수 실행

            return answer;
        }

        public void recur(int depth, int target, int result, int[] numbers) {
            if (depth == MAX) {           // 종료조건 : 깊이가 5일 경우
                if (result == target) {   // 정답조건 : 계산 결과가 타겟과 일치한 경우
                    answer++;
                }
                return;
            }

            recur(depth + 1, target, result + numbers[depth], numbers);   // + 인 경우
            recur(depth + 1, target, result - numbers[depth], numbers);   // - 인 경우
        }
    }
}
