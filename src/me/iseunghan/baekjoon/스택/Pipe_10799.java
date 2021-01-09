package me.iseunghan.baekjoon.스택;

import java.util.Scanner;

/**
 * 스택 - 10799번 쇠막대기
 */
public class Pipe_10799 {
    static int bar = 0;     // 쇠막대기 개수
    static int cut_Bar = 0; // 잘린 막대기 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {

                /* 레이저 인 경우 */
                if (arr[i + 1].equals(")")) {
                    cut_Bar += bar;
                    i++;
                }/* 새로운 막대기 추가 */
                else {
                    bar++;
                }
            } /* 막대기가 끝났을 경우 */
            else {
                bar--;
                cut_Bar++;
            }
        }

        System.out.println(cut_Bar);
    }
}
