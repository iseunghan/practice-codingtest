package me.iseunghan.baekjoon.문자열;

import java.util.*;

public class 경고_3029 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();
        String input2 = sc.nextLine();

        // 같다면 24시간 출력
        if (input1.equals(input2)) {
            System.out.print("24:00:00");
            System.exit(1);
        }

        String[] time1 = input1.split(":");
        String[] time2 = input2.split(":");


        int h1 = Integer.parseInt(time1[0]);
        int m1 = Integer.parseInt(time1[1]);
        int s1 = Integer.parseInt(time1[2]);

        int h2 = Integer.parseInt(time2[0]);
        int m2 = Integer.parseInt(time2[1]);
        int s2 = Integer.parseInt(time2[2]);


        // 초, 분 시 순으로 뺄셈
        if (s1 > s2) {
            s2 += 60;
            m2--;
        }
        if (m1 > m2) {
            m2 += 60;
            h2--;
        }
        if (h1 > h2) {
            h2 += 24;
        }

        String hour, min, sec;
        // "HH:MM:SS" 형태로 표현
        hour = (h2 - h1 < 10) ? "0" + (h2 - h1) : h2 - h1 + "";
        min = (m2 - m1 < 10) ? "0" + (m2 - m1) : m2 - m1 + "";
        sec = (s2 - s1 < 10) ? "0" + (s2 - s1) : s2 - s1 + "";

        System.out.print(hour + ":" + min + ":" + sec);
    }
}