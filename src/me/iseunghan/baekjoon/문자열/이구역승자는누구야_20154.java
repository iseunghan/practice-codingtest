package me.iseunghan.baekjoon.문자열;

import java.util.*;

public class 이구역승자는누구야_20154 {
    public static void main(String args[]) {
        int[] index = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            qu.offer(index[input.charAt(i) - 'A']);
        }

        while (qu.size() > 1) {
            int a = qu.poll();
            int b = qu.poll();

            qu.offer((a + b) % 10);
        }

        int result = qu.poll() % 10;

        if (result % 2 == 1) {
            System.out.print("I'm a winner!");
        } else {
            System.out.print("You're the winner?");
        }
    }

}
