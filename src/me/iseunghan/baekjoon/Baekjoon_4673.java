package me.iseunghan.baekjoon;

public class Baekjoon_4673 {
    static int[] arr = new int[10001];
    public static void main(String[] args) {

        for (int i = 1; i <= 10000; i++) {
            int res = d(i);
            if (res <= 10000) {
                arr[res] = -1;
            }
        }

        for (int i=1; i<=10000; i++) {
            if(arr[i] != -1)
                System.out.println(i);
        }
    }

    public static int d(int n) {
        int temp = n;
        while (true) {
            temp += n % 10;
            n /= 10;
            if (n < 10) {
                temp += n;
                break;
            }
        }
        return temp;
    }
}
