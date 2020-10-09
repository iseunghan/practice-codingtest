package me.iseunghan.baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1546 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        double answer = 0;
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int MAX = arr[N - 1];

        for (int i : arr) {
            answer += (double)i / MAX * 100;
        }
        System.out.println(MAX);
        System.out.println(answer / N);
    }
}
