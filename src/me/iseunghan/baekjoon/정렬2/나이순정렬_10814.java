package me.iseunghan.baekjoon.정렬2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나이순정렬_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());

        People[] people = new People[N];
        int age;
        String name;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            people[i] = new People(age, name);
        }

        Arrays.sort(people, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        for (People person : people) {
            bw.write(person.getAge() + " " + person.getName() + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static class People {
        int age;
        String name;

        public People(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
