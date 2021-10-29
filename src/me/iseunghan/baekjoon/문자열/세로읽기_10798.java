package me.iseunghan.baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String input = bf.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != 0)
                    sb.append(arr[i][j]);
            }
        }
        System.out.print(sb);
    }
}