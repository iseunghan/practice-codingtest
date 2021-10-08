package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class 자두나무_2240 {
    static int T, W, MAX;
    static int[] fall;
    static int[][] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        MAX = 0;
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        fall = new int[T + 1];
        dp = new int[W + 2][T + 1];

        for (int i = 1; i <= T; i++) {
            fall[i] = Integer.parseInt(bf.readLine());
        }

        // dp!
        // 테이블 정의) dp[W][T] : 이동횟수가 W일 떄, T초동안 자두를 잡은 갯수이다.
        // 점화식) dp[i][j]는 MAX(dp[i][j-1], dp[i-1][j-1]);
        //   설명) i번 이동했을 때 T초에 잡은 자두의 개수는
        //          (이동하지 않았을 경우) i번 이동했을 때 T-1초에 잡은 자두의 개수와
        //          (이동한 경우)      i-1번 이동했을 때 T-1초에 잡은 자두의 개수 중 큰 수를 취한다.
        // 큰 값을 취한 뒤, T초 시점에 어느 나무에 있는지:line(35) 비교해서 +1을 시켜준다.
        for (int i = 1; i <= W + 1; i++) {
            for (int j = 1; j <= T; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]);

                if (fall[j] == (i - 1) % 2 + 1) dp[i][j]++;
            }
        }

        // 범위가 제일 중요하다! 만약 T가 30초 이하인데, 이동횟수 W가 30이라면? 의미가 없다.
        // 그러므로, T보다 W가 클때는 최대 T만큼만 탐색한다. 반면에 T가 W 이상일 땐 W+1까지 탐색
        int range = (T >= W) ? W + 1 : T;

        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= T; j++) {
                if (MAX < dp[i][j]) MAX = dp[i][j];
            }
        }

        System.out.print(MAX);
    }
}