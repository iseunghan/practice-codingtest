package me.iseunghan.baekjoon;

import java.io.*;
import java.util.Scanner;

public class GoldBach_Guess_9020 {
    //TODO
    //반을 나눠서 나오는 소수*2 를 한 수의 + 2 한 수이면 -> 그 소수보다 한단계 작은 소수로 시작하고
    //만약 아니면 그 소수로 시작한다.
    static int[] demical = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //init
        demical[0] = -1;
        demical[1] = -1;
        for (long i = 2; i < demical.length; i++) {
            if (demical[(int) i] != -1) {
                for (long j = i * i; j < demical.length; j += i) {
                    demical[(int) j] = -1;
                }
            }
        }
        int T = Integer.parseInt(bf.readLine());

        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(bf.readLine());
            int demi = 0;
            //소수인지 판별
            if (demical[N / 2] == -1) {
                // 소수가 아닐때 소수 찾기
                for (int i = N / 2 - 1; i >= 2; i--) {
                    if (demical[i] == 0) {
                        if (demical[N - i] == 0) {
                            demi = i; // 소수 찾아서 넣어주기
                            break;
                        }
                    }
                }
                bw.write(demi + " " + (N - demi) + "\n");
            } else {
                demi = N / 2;
                bw.write(demi + " " + demi + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
