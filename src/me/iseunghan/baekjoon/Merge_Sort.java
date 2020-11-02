package me.iseunghan.baekjoon;

public class Merge_Sort {
    final static int N = 8;
    static int[] sorted = new int[8];
    static int temp = 5;
    // 정복 부분!
    public static void merge(int[] array, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;

        while (i <= middle && j <= n) {
            if (array[i] <= array[j]) {
                sorted[k] = array[i];
                i++;
            } else {
                sorted[k] = array[j];
                j++;
            }
            k++;
        }
        // 만약 i가 먼저 middle에 도달하고, j값이 남아있다면? -> j값을 다 넣어주면 된다.
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                sorted[k] = array[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = array[t];
                k++;
            }
        }
        //원래 배열에 다시 넣어준다!
        for (int t = m; t <= n; t++) {
            array[t] = sorted[t];
        }
    }

    // 분할 부분!
    public static void mergeSort(int[] a, int m, int n) {
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle + 1, n);
            merge(a, m, middle, n); // 한 배열을 반으로 분할을 하고, merge 함수를 이용해 다시 정복을 시키는 과정이다.
        }
    }

    public static void main(String[] args) {
        int[] array = {7, 6, 5, 8, 3, 5, 9, 1};
        mergeSort(array, 0, N - 1);
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + ", ");
        }
        int[] s = {1, 2, 3};
        sd(s);
        for (int i : s) {
            System.out.print(i + ", ");
        }
    }

    static void sd(int[] a) {
        a[0] = 100;
        a[1] = 200;
    }
}
