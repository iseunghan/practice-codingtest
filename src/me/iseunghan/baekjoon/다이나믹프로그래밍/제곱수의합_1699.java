package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class 제곱수의합_1699 {
        public static void main(String args[]) throws IOException {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            int[] dp = new int[100_001];

            dp[1] = 1;

            // i의 제곱의 수를 1로 초기화한다.
            for(int i=2; i*i<=100_000; i++) {
                dp[i*i] = 1;
            }

            // ex) 5 = 4+1 or 3+2 로 표현할 수 있다.
            for(int i=2; i<=100_000; i++) {
                // dp에 값이 있으면 건너뛴다.
                if(dp[i] != 0)  continue;

                dp[i] = Integer.MAX_VALUE;
                // 예를들어, i가 5일 때, j: 4부터 2까지 해당 수로 만들 수 있는 조합을 뽑아서 최솟값을 구한다.
                // ex1) 4 + 1
                // ex2) 3 + 2 등등
                for(int j=i-1; j>=i/2; j--) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
                }
            }

            System.out.println(dp[N]);
        }
    }