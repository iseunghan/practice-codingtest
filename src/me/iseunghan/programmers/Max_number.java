package me.iseunghan.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Max_number {
    public String run(int[] numbers) {
        // int[] numbers = {6, 10, 2}
        String result = "";
        String[] str = new String[numbers.length];
        // int[] to string[]
        for (int i = 0; i < numbers.length; i++) {
            str[i] = numbers[i] + "";
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (int i = 0; i < str.length; i++) {
            result += str[i];
        }
        return result;

    }
}
