package me.iseunghan.baekjoon.브루트포스;

import java.util.Scanner;

public class 영화감독숌_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        int num = 665;
        while (count != N) {
            num++;
            if (Integer.toString(num).contains("666")) {
                count++;
            }
        }
        System.out.println(num);
    }
}
