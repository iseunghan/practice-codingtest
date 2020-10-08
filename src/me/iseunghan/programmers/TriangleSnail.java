package me.iseunghan.programmers;

public class TriangleSnail {
    public int[] solution(int n) {
        int[] answer = {};
        int length = 0;
        //배열의 길이 구하기
        for (int i = 1; i <= n; i++) {
            length += i;
        }
        //init
        answer = new int[length];
        answer[0] = 1;
        answer[1] = 2;
        answer[3] = 3;
        answer[2] = answer[3] * (n - 1);
        answer[length - 1 - n] = n*2;
        answer[length - n] = n;
        for (int i = length - n +1; i < length; i++) {
            answer[i] = answer[i - 1] + 1;
        }

        for (int i : answer) {
            System.out.print(i + ",  ");
        }



        return answer;
    }
}
