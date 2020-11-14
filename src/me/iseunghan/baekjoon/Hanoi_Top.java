package me.iseunghan.baekjoon;

import java.io.*;
import java.util.Scanner;

public class Hanoi_Top {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());

        int count = (int)Math.pow(2, N) - 1;
        bw.write(count + "\n");
        recursion(N, 1, 3, 2);
        bw.flush();
        bw.close();
    }

    private static void recursion(int N, int start, int goal, int sub) throws IOException {
        /** [3] [0] [0]
         *  [2] [0] [0]
         *  [1] [0] [0]
         */
        // 종료 조건
        if (N == 1) {
//            System.out.println(start + " " + goal );
            bw.write(start + " " + goal + "\n");
            return ;
        }else{
            // 시작
            recursion(N-1, start, sub, goal);
//            System.out.println(start + " " + goal );
            bw.write(start + " " + goal + "\n");
            recursion(N-1, sub, goal, start);
        }

    }
}
