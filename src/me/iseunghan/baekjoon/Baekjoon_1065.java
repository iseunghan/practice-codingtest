package me.iseunghan.baekjoon;

import java.util.Scanner;

public class Baekjoon_1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = arithmetic(N);
        System.out.println(answer);
    }


    public static int arithmetic(int N) {
        int count = 0; // 한수의 개수 count

        if (N < 100) {
            return N;
        } else {
            count += 99; // 99까지의 수열을 더해준다.

            for (int i = 100; i <= N; i++) {
                int d_1 = i % 10;       // 1의 자리
                int d_10 = (i / 10) % 10;// 10의 자리
                int d_100 = i / 100;      // 100의 자리
                if ((d_100 - d_10) == (d_10 - d_1)) {
                    count++;
                }
            }
            return count;
        }
    }
}
