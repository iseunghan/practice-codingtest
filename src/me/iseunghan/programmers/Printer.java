package me.iseunghan.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    //priorities = [2, 1, "3", 2] , location = 2, req_docs = 3;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> qu = new LinkedList<>();
        Print[] plist = new Print[priorities.length];

        for (int i = 0; i < priorities.length; i++) {
            qu.add(new Print(priorities[i], i));
        }//우선순위, 위치(=0,1,2,3)

        Arrays.sort(priorities);

        int idx = 1;
        int loc = 0;

        while (!qu.isEmpty()) {
            Print p1 = qu.poll();
            int max = priorities[priorities.length - idx];

            if (max == p1.priorities) {
                plist[loc] = p1;
                loc++;
                if (priorities.length > idx) {
                    idx++;
                }
            } else if (max > p1.priorities) {
                qu.add(p1);
            }
        }

        for (int i = 0; i < priorities.length; i++) {
            if (location == plist[i].location) {
                answer = i + 1;
            }
        }


        return answer;
    }


    public class Print {
        int priorities;
        int location;

        public Print(int priorities, int location) {
            this.priorities = priorities;
            this.location = location;
        }
    }
}
