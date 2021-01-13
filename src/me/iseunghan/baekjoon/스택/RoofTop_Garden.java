package me.iseunghan.baekjoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 옥상 정원 꾸미기 : 6198번
 */
public class RoofTop_Garden {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int peek = 0;
        int result = 0; // int형으로 하니까 틀림, long으로 바꾸면 통과! (이상함..)
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i < N; i++) {
            int b = i;

            while (++b <= (N-1)) {
                if (arr[i] > arr[b]) {
                    result++;
                } else if (arr[i] == arr[b]) {  // 높이가 같은 빌딩이면 못봄!
                    result++;
                    break;
                } else {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
