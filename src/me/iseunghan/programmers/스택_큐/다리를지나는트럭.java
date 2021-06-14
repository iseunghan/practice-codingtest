package me.iseunghan.programmers.스택_큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {

    }

    class Solution {
        class Truck {
            int weight;
            int entry;

            Truck(int weight, int entry) {
                this.weight = weight;
                this.entry = entry;
            }
        }

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Queue<Truck> waiting = new LinkedList<>();
            Queue<Truck> passing = new LinkedList<>();

            for (int i = 0; i < truck_weights.length; ++i) {
                waiting.offer(new Truck(truck_weights[i], 0));
            }

            int totalWeight = 0;
            while (!waiting.isEmpty() || !passing.isEmpty()) {
                answer++;
                if (!passing.isEmpty()) {
                    Truck t = passing.peek();
                    if (answer - t.entry >= bridge_length) {
                        totalWeight -= t.weight;
                        passing.poll();
                    }
                }

                if (!waiting.isEmpty()) {
                    if (totalWeight + waiting.peek().weight <= weight) {
                        Truck t = waiting.poll();
                        totalWeight += t.weight;

                        passing.offer(new Truck(t.weight, answer));
                    }
                }
            }
            return answer;
        }
    }
}