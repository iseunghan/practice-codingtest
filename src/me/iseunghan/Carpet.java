package me.iseunghan;

public class Carpet {
    public int[] solution(int yellow, int brown) {
        int[] answer = new int[2];

        int width = 0;
        int height = 0;
    // yellow의 세로가 1인 경우! || 소수 인 경우
        if (brown == yellow * 2 + 6 || isPrime(yellow)) { // 소수 일때
            width = yellow + 2;
            height = 3;
        }else { // 소수가 아닐때
            int temp_w = yellow / getSqrt(yellow) + 2;
            int temp_h = (yellow + brown) / temp_w;
            if (temp_w >= temp_h) {
                width = temp_w;
                height = temp_h;
            }
        }


            answer[0] = width;
            answer[1] = height;

            return answer;
    }

    public int getSqrt(int x) {
        int sqrt = (int) Math.sqrt(x);
        int max = 0;
        for (int i = 2; i <= sqrt; i++) {
            if (x % i == 0) {
                if (max < i) {
                    max = i;
                }
            }
        }
        return max;
    }

    public Boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
