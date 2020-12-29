package me.iseunghan.baekjoon.함수;

public class Baekjoon_15596{
    public long sum(int[] a) {
        long answer = 0L;

        for (int i : a) {
            answer += i;
        }
        return answer;
    }
}
