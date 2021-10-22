package me.iseunghan.baekjoon.문자열;

import java.util.*;

public class 밀비급일_11365 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb;

        String input = sc.nextLine();

        while (!input.equals("END")) {
            sb = new StringBuffer();
            sb.append(input);
            System.out.println(sb.reverse());

            input = sc.nextLine();
        }
    }
}