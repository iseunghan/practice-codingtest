package me.iseunghan.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Baekjoon_4344 {
    static int[] score; // 각 케이스의 점수를 담을 배열들
    static double average; // 각 케이스의 평균
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
//        double s = 40.0;
//        System.out.printf("%.3f", s); // 40.000 출력!
        double[] answer = new double[N]; // 정답 담을 배열
        for (int i = 0; i < N; i++) {
            average = 0;
            st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            score = new int[X]; // 케이스 바뀔때 마다 새로 초기화!
            for (int j = 0; j < X; j++) {
                score[j] =  Integer.parseInt(st.nextToken());
            }
            average = (double)Arrays.stream(score).sum() / X;
            double percent = getPercent(score);
            answer[i] = percent;
        }
        for (double v : answer) {
//            System.out.println((double)Math.round(v * 1000)/1000.0 + "%");
            System.out.printf("%.3f", round(v*1000)/1000.0);
            System.out.println("%");
        }
    }

    private static double getPercent(int[] score) {
        int count = 0;

        for (int i = 0; i < score.length; i++) {
            if (score[i] > average) {
                count++;
            }
        }
        return (double)count / score.length * 100.0;
    }
}
