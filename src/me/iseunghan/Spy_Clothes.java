package me.iseunghan;

import java.util.HashMap;
import java.util.Map;

public class Spy_Clothes {
    public int run(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        // h ,h ,h
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                Integer integer = map.get(clothes[i][1]);
                map.replace(clothes[i][1], ++integer);
            }else {
                map.put(clothes[i][1], 1);
            }
        }// h : 3

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        return answer - 1;
    }
}
