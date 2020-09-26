package me.iseunghan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Target_Number {
    int answer = 0;
    int[] numbers;
    int target;
    int[] sign;
    boolean[] visited;
    Queue<Integer> queue = new LinkedList<>();
    public int run(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        visited = new boolean[numbers.length];

        // --------------init----------------
        sign = new int[numbers.length];
        Arrays.fill(sign, 1);
        // ----------------------------------

        //this.recycle(answer);

        return answer;
    }
    public void bfs(int start) {
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int num = queue.peek();
        }
    }
}
