package me.iseunghan.baekjoon;

import java.io.*;

public class Baekjoon_8958 {
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[] score = new int[N]; // 점수를 담을 배열

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            arr = s.split("");
            score[i] = getScore(arr);
        }
        for (int i : score) {
            System.out.println(i);
        }
    }

    private static int getScore(String[] arr) {
        int score = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("O")) {
                temp++;
                score += temp;
            } else {
                temp = 0;
            }
        }
        return score;
    }
}
