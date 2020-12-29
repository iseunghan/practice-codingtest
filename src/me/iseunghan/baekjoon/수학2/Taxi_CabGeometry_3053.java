package me.iseunghan.baekjoon.수학2;

import java.util.Scanner;

public class Taxi_CabGeometry_3053 {
    final static double PI = 3.14159265359;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        double r1 = R * R * PI;
        double r2 = R * R * 2;
        System.out.printf("%6f" + "\n" + "%6f", r1, r2);
    }
}
