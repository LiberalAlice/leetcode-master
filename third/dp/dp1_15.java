package third.dp;

/**
 * @Author：wuwei
 * @Date：2023/2/28
 */
public class dp1_15 {
    public static void main(String[] args) {
        dp1_15 dp1_15 = new dp1_15();
        int[] a ={10,15,20};
        dp1_15.minCostClimbingStairs(a);
    }


    //2.斐波那契
    public int fib(int n) {
        //1.明确dp[i]的含义
        int dp[] = new int[n + 1];
        //2.确定递推公式 dp[n] = dp[n -1] + dp[n -2];
        //3.初始化dp
        dp[0] = 0;
        dp[1] = 1;
        //4.确定遍历顺序 从前向后
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //3.爬楼梯
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        //1.明确dp[i]的含义  第n个台阶有dp[n]种方法
        int[] dp = new int[n + 1];
        //2.确定递推公式  dp[n] = dp[n-1] + dp[n-2]
        //3.初始化
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    //4.使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {
        //1.确定dp[i]的含义 dp[i] : 下标为i时最少的体力花费为dp[i]
        int length = cost.length;
        if (length < 2) {
            return cost[length - 1];
        }
        int[] dp = new int[length + 1];
        //2.确定递推公式  dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2]  + cost[i - 2])
        //3.初始化  初始化为cost[0] 和 cost[1]即可
        //dp[0] = 0;
        //dp[1] = 0;
        //4.确定遍历顺序  从前往后
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[length];
    }

    //6.不同路径
    public int uniquePaths(int m, int n) {
        //1.明确dp[i][j]的含义 dp[i][j]: 在i，j时的路径数为dp[i][j]
        int[][] dp = new int[m][n];
        //2.确定递推公式  dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        //3.初始化 因为是从左上方计算，因此要初始化左上的一行
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //4.确定遍历方向
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    //7.不同路径2
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //1.明确dp[i][j]的含义 dp[i][j]: 在i，j时的路径数为dp[i][j]
        int[][] dp = new int[m][n];
        //2.确定递推公式  dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        //3.初始化 因为是从左上方计算，因此要初始化左上的一行
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        //4.确定遍历方向
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) { continue;}
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }







    public int lastStoneWeightII(int[] stones) {
        //1. 明确dp[i]的含义
        int[] dp = new int[stones.length];
        //
        return 1;
    }
}
