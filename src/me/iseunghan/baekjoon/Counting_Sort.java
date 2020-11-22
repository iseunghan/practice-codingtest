package me.iseunghan.baekjoon;

public class Counting_Sort {
    //
    public static void main(String[] args) {
        int[] array = new int[100000]; //수열의 원소 : 100개
        int[] counting = new int[100001];//수의 범위 : 0~30
        int[] result = new int[100000];//정렬 될 배열

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100001);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            counting[array[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;
        }
        long end = System.currentTimeMillis();

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println("\n" + (end-start)/1000.0000);
    }
}
