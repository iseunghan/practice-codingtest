package me.iseunghan.baekjoon.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1919
public class 애너그램만들기_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] srr1 = bf.readLine().split("");
        String[] srr2 = bf.readLine().split("");

        for (int i = 0; i < srr1.length; i++) {
            for (int j = 0; j < srr2.length; j++) {
                if (!srr2[j].equals("0") && srr1[i].equals(srr2[j])) {
                    srr1[i] = "0";
                    srr2[j] = "0";
                    break;
                }
            }
        }
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < srr1.length; i++) {
            if (!srr1[i].equals("0")) {
                count1++;
            }
        }
        for (int i = 0; i < srr2.length; i++) {
            if (!srr2[i].equals("0")) {
                count2++;
            }
        }

        System.out.print(count1 + count2);
    }
}