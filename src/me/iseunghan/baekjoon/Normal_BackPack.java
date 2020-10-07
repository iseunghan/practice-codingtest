package me.iseunghan.baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Normal_BackPack {
    static int n,k;
    static int dp[][],w[],v[]; // dp배열과 무게, 가치배열
    public void run() {
        /*Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int maxWeight = sc.nextInt();

        int[][] goods = new int[n][n];

        for (int i = 0; i < n; i++) {
            goods[i][0] = sc.nextInt();
            goods[i][1] = sc.nextInt();
        }

        *//*Arrays.sort(goods, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });*//*

        int max = 0;
        for (int i = 0; i < n; i++) {
            int weight = maxWeight - goods[i][0];
            int temp = 0;

            if (weight >= 0) {
                temp += goods[i][1];
            }

            for (int j = i + 1; j < n; j++) {
                if (weight == 0) {
                    break;
                }
                if (goods[j][0] <= weight) {
                    weight -= goods[j][0];
                    temp += goods[j][1];
                }
            }
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);*/
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        dp = new int[n+1][k+1];

        w =new int[n+1];
        v = new int[n+1];

        for(int i=1;i<=n;i++) {
            w[i] = sc.nextInt();
            v[i]= sc.nextInt();

        }


        for(int i=1;i<=n;i++) {
            for(int j=1;j<=k;j++) {
                dp[i][j] = dp[i-1][j]; // 기본적으로 이전 아이템의 가치를 저장한다.
                if(j - w[i]>=0) { // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면,
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]); // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}