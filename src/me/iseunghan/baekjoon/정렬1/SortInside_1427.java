package me.iseunghan.baekjoon.정렬1;

import java.util.Arrays;
import java.util.Scanner;

public class SortInside_1427 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split("");

        Arrays.sort(split);

        for (int i = split.length-1; i >=0 ; i--) {
            sb.append(split[i]);
        }

        System.out.println(sb.toString());
    }
}
