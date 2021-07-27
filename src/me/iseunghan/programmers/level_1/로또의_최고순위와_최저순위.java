package me.iseunghan.programmers.level_1;

public class 로또의_최고순위와_최저순위 {
    public static void main(String[] args) {
        int[] answer = Solution.solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6});

        System.out.println("최고 순위 : " + answer[0]);
        System.out.println("최저 순위 : " + answer[1]);
    }

    static class Solution {
        public static int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int correct = 0, empty = 0;

            for (int i = 0; i < 6; i++) {
                if (lottos[i] == 0) {
                    empty++;
                } else {
                    for (int j = 0; j < 6; j++) {
                        if (lottos[i] == win_nums[j]) {
                            correct++;
                            break;
                        }
                    }
                }
            }

            // 맞은 개수가 곧 최저 등수!
            answer[1] = getRank(correct);
            answer[0] = getRank(correct + empty);

            return answer;
        }

        static int getRank(int cor) {
            switch (cor) {
                case 6:
                    return 1;
                case 5:
                    return 2;
                case 4:
                    return 3;
                case 3:
                    return 4;
                case 2:
                    return 5;
                default:
                    return 6;
            }
        }
    }
}
