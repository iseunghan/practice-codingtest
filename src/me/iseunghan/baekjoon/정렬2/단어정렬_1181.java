package me.iseunghan.baekjoon.정렬2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class 단어정렬_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine();
        }


        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });


        Stream<String> stream = Arrays.stream(arr).distinct();
        stream.forEach(e -> {
            try {
                bw.write(e + "\n");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        bw.flush();
        bw.close();
    }
}