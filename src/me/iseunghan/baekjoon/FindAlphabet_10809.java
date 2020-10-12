package me.iseunghan.baekjoon;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FindAlphabet_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1); // -1로 초기화
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            int num = (int) s.charAt(i);
            if(alphabet[num-97] == -1) { // 중복 알파벳이 있을 경우 제외
                alphabet[num - 97] = i;
            }
        }
        for (int i : alphabet) {
            System.out.print(i + " ");
        }
    }
}
