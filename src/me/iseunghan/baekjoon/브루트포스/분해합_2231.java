package me.iseunghan.baekjoon.브루트포스;

import java.util.Scanner;

public class 분해합_2231 {
    public static void main(String[] args) {
        //this class For print
        Scanner sc = new Scanner(System.in);
        int NMG = 0;
        int MOK = 0;

        int N = sc.nextInt(); // 124
        int result = 0;
        int temp = 0;

        for (int i = N / 2; i < N; i++) {
            temp = i; // 116
            result = i; // 116

            while (temp >= 10) {
                MOK = temp / 10; // 1
                NMG = temp % 10; // 1

                result += NMG; // 123
                temp /= 10; // 1
            }
            result += temp;

            if (result == N) {
                System.out.println(i);
                break;
            }
        }
        if (result != N)
            System.out.println("0");
    }
}