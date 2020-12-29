package me.iseunghan.baekjoon.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find_Fraction_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String answer = "";

        int startNum = 1;
        int EndIndex = 1;
        while (true) {
            EndIndex += startNum++;
            if (EndIndex > N) {
                startNum--; // 시작 번호
                EndIndex--; // 마지막 index
                break;
            }
        }

        if (startNum % 2 == 0) { // 짝수 일때, 1부터 증가
            answer += (startNum - (EndIndex - N)) + "/" + (1 + (EndIndex - N));
        } else { // 홀수 일때, startNum부터 1씩 감소
            answer += (1 + (EndIndex - N)) + "/" + (startNum - (EndIndex - N));
        }
        System.out.println(answer);
    }
}