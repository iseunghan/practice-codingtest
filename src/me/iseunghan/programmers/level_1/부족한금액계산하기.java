package me.iseunghan.programmers.level_1;

/**
 * 위클리 챌린지 > 1주차 > 부족한 금액 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/82612?language=java
 */
public class 부족한금액계산하기 {
    class Solution {
        public long solution(int price, int money, int count) {
            long answer = -1;

            int count_sum = 0;
            for (int i = 1; i <= count; i++) {
                count_sum += i;
            }

            answer = (long) price * count_sum - money;

            return answer > 0 ? answer : 0;
        }
    }
}
