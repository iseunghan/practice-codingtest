package me.iseunghan.programmers.고득점Kit.DP;

// 여기서 우리는 3가지 상황을 생각해볼 수 있다.
// 첫번째 상황은, 집이 3개인 경우!
//      - 가장 큰 돈을 가지고 있는 집을 택하면 된다.
// 두번째 상황은, 0번째 집을 터는 경우이다.
//      - 0번째 집을 털었다면, 왼쪽, 오른쪽 집은 털수가 없다. 즉, 마지막, 1번째 집은 털수가 없다는 것이다.
// 세번째 상황은, 0번째 집을 털지 않는 경우이다.
//      - 0번째 집을 털지 않으면, 왼쪽, 오른쪽 집을 털어도 된다. 즉, 마지막, 1번째 집을 털어도 된다는 뜻이다.
public class 도둑질 {
    class Solution {
        public int solution(int[] money) {
            int answer = 0;

            // 3집뿐이라면, 가장 돈이 많은 집을 택하면 된다!
            if (money.length == 3) {
                for (int i = 0; i < 3; i++)
                    if (answer < money[i]) answer = money[i];
                return answer;
            }

            int[] dp = new int[money.length + 1];

            // 1번째) 0번째 집을 터는 경우! -> 1번째 집과 마지막 집은 털 수 없다. (주의!!)
            dp[0] = money[0];
            dp[1] = dp[0];  // (주의하기!!) 이것때문에 틀렸었는데, 1번째 집을 털지 않았어도 dp[i-1] 값은 가지고 있어야하는 것을 놓쳤다! 주의하자!

            // 점화식) i번째 집을 털었다면 dp[i-2] + money[i] 이고, i번째 집을 털지 않았다면 dp[i-1]이므로 둘 중 가장 큰 값을 취하면 된다!
            for (int i = 2; i < money.length; i++) {
                dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
                // 주의할 점) 0번째 집을 털었다면, 마지막 집은 당연히 털지 않아야 한다. 하지만 위 MAX 식에서는 당연히 마지막 집을 털은 돈이 많기 때문에 털게 될 것이다. 그렇기 때문에 0번째 집의 돈을 빼줘야한다.
                if (i == money.length - 1) dp[i] -= money[0];
                if (answer < dp[i]) answer = dp[i];
            }

            // 2번째) 0번째 집을 털지 않는 경우! -> 마지막 집과, 1번째 집을 털어도 된다!
            dp = new int[money.length + 1];
            dp[0] = 0;
            dp[1] = money[1];

            for (int i = 2; i < money.length; i++) {
                dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
                if (answer < dp[i]) answer = dp[i];
            }

            return answer;
        }
    }
}
