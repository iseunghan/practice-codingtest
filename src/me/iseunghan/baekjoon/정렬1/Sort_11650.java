package me.iseunghan.baekjoon.정렬1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sort_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        Dot[] dots = new Dot[N];

        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            dots[i] = new Dot(x, y);
        }

        Arrays.sort(dots, new Comparator<Dot>() {
            @Override
            public int compare(Dot o1, Dot o2) {
                if (o1.getX() == o2.getX()) {
                    return Integer.compare(o1.getY(), o2.getY());
                }
                return Integer.compare(o1.getX(), o2.getX());
            }
        });

        for (int i = 0; i < dots.length; i++) {
            Dot dot = dots[i];
            bw.write(dot.getX() +  " " + dot.getY() + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
