package me.iseunghan.baekjoon.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 복호화_9046 {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] count;
        int N = Integer.parseInt(bf.readLine());

        for (int t = 0; t < N; t++) {
            int MAX = 0;

            count = new int['z' - 'a' + 2];

            String str = bf.readLine();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ' ') continue;
                count[str.charAt(j) - 'a']++;
            }

            for (int j = 0; j < 27; j++) {
                if (MAX < count[j]) MAX = count[j];
            }

            int cnt = 0;
            int idx = 0;
            for (int j = 0; j < 27; j++) {
                if (MAX == count[j]) {
                    cnt++;
                    idx = j;
                }
            }

            if (cnt > 1) System.out.println("?");
            else System.out.println((char) (idx + 'a'));
        }
    }
}