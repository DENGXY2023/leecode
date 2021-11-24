package qusetions;

public class Q746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int dp = 0;
        int a=0, b=0;
        for(int i=2; i<=len; i++){
            dp = Math.min(a+cost[i-1], b+cost[i-2]);
            b=a;
            a =dp;
            // dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp;
    }
}
