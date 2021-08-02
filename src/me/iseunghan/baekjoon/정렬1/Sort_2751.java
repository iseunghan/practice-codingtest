package me.iseunghan.baekjoon.정렬1;

import java.io.*;

public class Sort_2751 {
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
//        temp = new int[N]; // 이렇게 미리 할당 시키면 메모리 초과
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        mergeSort(arr, 0, N - 1);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int[] arr, int start, int end) {

        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle,  end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int m = start;
        int n = middle + 1;
        int k = 0;

        temp = new int[end - start + 1];

        while (m <= middle && n <= end) {
            if (arr[m] > arr[n]) {
                temp[k] = arr[n];
                n++;
            } else {
                temp[k] = arr[m];
                m++;
            }
            k++;
        }

        if (m > middle) {
            for (int o = n; o <= end; o++) {
                temp[k] = arr[o];
                k++;
            }
        } else {
            for (int o = m; o <= middle; o++) {
                temp[k] = arr[o];
                k++;
            }
        }
        k = 0;
        for (int o = m; o <= end; o++) {
            arr[o] = temp[k++];
        }

    }
}
