package third.dp;

import java.util.Arrays;

/**
 * @Author：wuwei
 * @Date：2023/3/6
 */
public class dp15_30 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int x : stones
        ) {
            sum += x;
        }
        int target = sum / 2;
        Arrays.sort(stones);
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
