package me.iseunghan.baekjoon.배열;

import java.util.Scanner;

public class 알파벳개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
