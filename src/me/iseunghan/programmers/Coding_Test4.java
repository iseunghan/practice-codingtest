package me.iseunghan.programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Coding_Test4 {
    public String solution(String[] votes, int k) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String vote : votes) {
            if (map.containsKey(vote)) {
                map.put(vote, map.get(vote)+1);
            }else
                map.put(vote, 1);
        }

        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        })).collect(Collectors.toList());

        /*for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println( stringIntegerEntry);
        }*/

        for (Map.Entry<String, Integer> stringIntegerEntry : collect) {
            System.out.println(stringIntegerEntry);
        }
        int MAX = collect.get(0).getValue() + collect.get(1).getValue();
        //while(MAX > 1)

        return answer;
    }
}
