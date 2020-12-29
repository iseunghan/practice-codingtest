package me.iseunghan.baekjoon.문자열;

import java.util.Scanner;

public class Dial_5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 65;
            if (idx == 18 || idx == 21 || (idx / 3) == 8) { //S , Z인 경우
                answer += idx / 3 + 2;
            }else{
                answer += idx / 3 + 3;
            }
        }

        System.out.println(answer);
    }
}
